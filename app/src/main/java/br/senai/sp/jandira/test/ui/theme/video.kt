package br.senai.sp.jandira.test.ui.theme

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import android.widget.VideoView
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun VideoPlayer(videoUri: Uri) {
    val context = LocalContext.current
    val videoView = remember {
        VideoView(context).apply {
            setVideoURI(videoUri)
            start()
        }
    }

    AndroidView(factory = { videoView })
}
