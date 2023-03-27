package com.sgut.android.nationalfootballleague.ui.commoncomps.commoncomposables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.*
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.VideoModel

@Composable
fun VideoPlayer(
    videos: VideoModel
) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    var autoPlay = rememberSaveable { true }
    var window = rememberSaveable { 0 }
    var position = rememberSaveable { 0L }

    val player = remember {
        val player = ExoPlayer.Builder(context).build()
        val mediaItem = MediaItem.fromUri(videos.links.source?.mezzanine?.href?: "")
        player.setMediaItem(mediaItem)
        player.playWhenReady = autoPlay
        player.seekTo(window, position)
        player
    }

    fun updateState() {
        autoPlay = player.playWhenReady
        window = player.currentMediaItemIndex
        position = 0L
    }

    val playerView = remember {
        val playerView = PlayerView(context)
        lifecycle.addObserver(object: LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onStart() {
                playerView.onResume()
                player.playWhenReady = autoPlay
            }
            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop() {
                updateState()
                playerView.onPause()
                player.playWhenReady = false
            }


        })
        playerView
    }
    DisposableEffect(Unit){
        onDispose {
            updateState()
            player.release()
        }
    }
    AndroidView(
        factory = { playerView },
        modifier = Modifier.fillMaxWidth()
    ) {
        playerView.player = player
    }
}