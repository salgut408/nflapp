package com.sgut.android.nationalfootballleague.data.service.impl

import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.sgut.android.nationalfootballleague.data.domainmodels.User
import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.data.service.trace
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AccountServiceImpl @Inject constructor(
    private val auth: FirebaseAuth
): AccountService {

    override val currentUserId: String
        get() = auth.currentUser?.uid.orEmpty()


    override val hasUser: Boolean
        get() = auth.currentUser != null

   override val currentUser: Flow<User>
    get() = callbackFlow {
        val listener = FirebaseAuth.AuthStateListener { auth->
            this.trySend(auth.currentUser?.let {
                User(it.uid, it.isAnonymous) } ?: User())
        }
        auth.addAuthStateListener(listener)
        awaitClose {auth.removeAuthStateListener(listener) }
    }

    override suspend fun authenticate(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }


    override suspend fun sendRecoveryEmail(email: String) {
        auth.sendPasswordResetEmail(email)
    }


    override suspend fun createAnonymousAccount(): Unit = trace(ANON_ACCOUNT_CREATED) {
        auth.signInAnonymously().await()
    }

  override suspend fun linkAccount(email: String, password: String): Unit = trace(LINK_ACCOUNT_TRACE)  {
        val credential = EmailAuthProvider.getCredential(email, password)
        auth.currentUser!!.linkWithCredential(credential).await()
    }


    override suspend fun deleteAccount(): Unit = trace(DELETE_ACCOUNT_TRACE)  {
        auth.currentUser!!.delete().await()
    }

    override suspend fun signOut(): Unit = trace(SIGN_OUT) {
        if (auth.currentUser!!.isAnonymous) {
            auth.currentUser!!.delete()
        }
        auth.signOut()

        // Sign the user back in anonymously.
        createAnonymousAccount()
    }

    companion object {
        private const val LINK_ACCOUNT_TRACE = "linkAccount"
        private const val DELETE_ACCOUNT_TRACE = "deleteAccount"
        private const val SIGN_OUT = "signOut"
        private const val ANON_ACCOUNT_CREATED = "AnonAccountCreated"



    }


}