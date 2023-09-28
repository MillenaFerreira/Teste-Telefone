package br.senai.sp.jandira.test

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import br.senai.sp.jandira.test.R
import br.senai.sp.jandira.test.ui.theme.ModalWithVideo
//import br.senai.sp.jandira.test.VideoPlayerScreen
import br.senai.sp.jandira.test.ui.theme.VideoPlayer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ModalWithTimer(
    onDismiss: () -> Unit
) {
    var showDialog by remember { mutableStateOf(true) }

    val coroutineScope = rememberCoroutineScope()

    if (showDialog) {
        Dialog(
            onDismissRequest = {
                // Não faça nada aqui, forçaremos o fechamento após 5 segundos
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(0.5.dp)
                    .width(300.dp)
                    .height(226.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp))
                    .padding(start = 40.dp, top = 36.dp, end = 40.dp, bottom = 36.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                ModalWithVideo()

            }
        }

        // Use uma coroutine para fechar o modal após 5 segundos
        coroutineScope.launch {
            delay(4000) // 5 segundos
            showDialog = false
            onDismiss()
        }
    }
}

