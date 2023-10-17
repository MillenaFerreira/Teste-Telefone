package br.senai.sp.jandira.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalContext
import br.senai.sp.jandira.test.telateste.FinalizarCadastroScreen
import br.senai.sp.jandira.test.ui.theme.TestTheme

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
                    //ModalExampleWithNavigation()
//                    Column {
//                        FilterChipExample()
//                    }
                    //ExtendedExample(onClick = {})
                    //AnimatedFloatingActionButton()
                    //ExpandableFloatingActionButton()
                    ModalWithTimer(onDismiss = {})

                    //ModalWithVideo()
                    //AutoComplete()

                    //CalendarApp()

                    //CalendarView()

                    //SingleRowCalendar()

                    FinalizarCadastroScreen()





                    var context = LocalContext.current

                    //showTimePicker(context)
                }
            }
        }
    }
}