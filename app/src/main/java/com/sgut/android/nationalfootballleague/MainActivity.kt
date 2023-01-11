package com.sgut.android.nationalfootballleague


import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sgut.android.nationalfootballleague.ui.theme.NationalFootballLeagueTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

          val DEBUG_TAG = "NetworkStatusExample"

        val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var isWifiConn: Boolean = false
        var isMobileConn: Boolean = false



        super.onCreate(savedInstanceState)
        setContent {
            NationalFootballLeagueTheme {

//                connMgr.allNetworks.forEach { network ->
//                    connMgr.getNetworkInfo(network)?.apply {
//                        if (type == ConnectivityManager.TYPE_WIFI) {
//                            isWifiConn = isWifiConn or isConnected
//                        }
//                        if (type == ConnectivityManager.TYPE_MOBILE) {
//                            isMobileConn = isMobileConn or isConnected
//                        }
//                    }
//                }
//                Log.d(DEBUG_TAG, "Wifi connected: $isWifiConn")
//                Log.d(DEBUG_TAG, "Mobile connected: $isMobileConn")

                EspnApp()



            }
        }
    }
}


