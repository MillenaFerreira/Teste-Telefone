package br.senai.sp.jandira.test.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.test.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun ModalWithVideo() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_ln2lqabi))
    var isPlaying by remember { mutableStateOf(true) }
    
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying
    )

    LaunchedEffect(key1 = progress){
        if (progress == 0f){
            isPlaying= true
        }
        if (progress == 1f){
            isPlaying= false
        }
    }
    
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .size(100.dp),
            progress = progress
        )
        Text(
            text = "Successfully accepted!",
            fontSize = 20.sp,
            //fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(600),
            color = Color(0xFF54595E)
        )
        
    }
}


