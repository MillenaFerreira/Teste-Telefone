package br.senai.sp.jandira.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalContext
import br.senai.sp.jandira.test.AgoraVaiCalendario.CalendarScreenSS
import br.senai.sp.jandira.test.relatorio.AddQuestion
import br.senai.sp.jandira.test.relatorio.QuestionScreen
import br.senai.sp.jandira.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {

                Surface {
                    //MyScreen()
                    //SimpleAlarm()
                    //Time()
                    //ModalExampleWithNavigation()
//                    Column {
                        //FilterChipExample()
//                    }
                    //AnimatedFloatingActionButton()
                    //ExpandableFloatingActionButton()
                    //ModalWithTimer(onDismiss = {})

                    //ModalWithVideo()
                    //AutoComplete()

                    //CalendarApp()

                    //CalendarView()

                    //SingleRowCalendar()

                    //FinalizarCadastroScreen()

                    //CalendarScreen()
                    //CalendaryS()
                    //CalendarFragments()

                    //MyKalendarScreen()
                    //RelatorioScreen()
                    //var selectedDate by remember { mutableLongStateOf(0L) }
                    //CustomCalendar(selectedDate = mutableLongStateOf(selectedDate))
                    //CalendarScreenS()
                    //CalendarScreenSS()

                    //QuestionScreen()
                    AddQuestion()




                    var context = LocalContext.current

                    //showTimePicker(context)
                }
            }
        }
    }
}