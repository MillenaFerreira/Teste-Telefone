package br.senai.sp.jandira.test

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import br.senai.sp.jandira.test.ui.theme.AnimatedFloatingActionButton
import br.senai.sp.jandira.test.ui.theme.ExpandableFloatingActionButton
import br.senai.sp.jandira.test.ui.theme.FilterChipExample
import br.senai.sp.jandira.test.ui.theme.ModalExampleWithNavigation
import br.senai.sp.jandira.test.ui.theme.ModalWithVideo
//import br.senai.sp.jandira.test.ui.theme.ExtendedExample
import br.senai.sp.jandira.test.ui.theme.TestTheme
import br.senai.sp.jandira.test.ui.theme.VideoPlayer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {

                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    //MyScreen()
                    //SimpleAlarm()
                    //Time()
                    ModalExampleWithNavigation()
//                    Column {
                        //FilterChipExample()
//                    }
                    //AnimatedFloatingActionButton()
                    //ExpandableFloatingActionButton()
                    //ModalWithTimer(onDismiss = {})

                    //ModalWithVideo()






                    var context = LocalContext.current

                    //showTimePicker(context)
                }
            }
        }
    }
}