package com.carolmusyoka.dazn.presentation.screen

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.carolmusyoka.dazn.domain.model.events.GetEventsResponseItem
import com.carolmusyoka.dazn.presentation.components.Menu
import com.carolmusyoka.dazn.presentation.components.Title
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util


@Composable
fun PlaybackScreen(
    navBack:() -> Unit,
    modifier: Modifier = Modifier,
    eventsResponseItem: GetEventsResponseItem
){
    Scaffold(
        topBar = {
            Menu(
                title = "Video Playback",
                pressBack = navBack
            )
        },
        backgroundColor = Color.White,
        content = {
               VideoPlayerContent(
                   eventsResponseItem = eventsResponseItem
               )
        }
    )
}

@Composable
fun VideoPlayerContent(eventsResponseItem: GetEventsResponseItem) {
    // create a column with title for the video and subtitle texts and the video player
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = eventsResponseItem.title,
            style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = eventsResponseItem.subtitle,
            style = MaterialTheme.typography.body1)

        Spacer(modifier = Modifier.height(30.dp))

        VideoPlayer(url = eventsResponseItem.videoUrl)
    }


}

@Composable
fun VideoPlayer(url: String) {
    val context = LocalContext.current

    // create player
    val exoPlayer = remember{
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.Builder()
                .setUri(Uri.parse(url))
                .build()
            setMediaItem(mediaItem)

            this.prepare()
        }
    }

    // Implementing the player view
    AndroidView(factory = { context ->
        StyledPlayerView(context).apply {
            player = exoPlayer
        }
    })

}
@Preview
@Composable
fun VideoPreview(){
    PlaybackScreen(
        navBack = {},
        eventsResponseItem = GetEventsResponseItem(
            date = "",
            id = "",
            imageUrl = "",
            title = "Title",
            subtitle = "Subtitle",
            videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
        )
    )
}
