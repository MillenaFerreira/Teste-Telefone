package br.senai.sp.jandira.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import br.senai.sp.jandira.test.ui.theme.AnimatedFloatingActionButton
import br.senai.sp.jandira.test.ui.theme.ExpandableFloatingActionButton
import br.senai.sp.jandira.test.ui.theme.FilterChipExample
import br.senai.sp.jandira.test.ui.theme.ModalExampleWithNavigation
import br.senai.sp.jandira.test.ui.theme.ModalWithVideo
import br.senai.sp.jandira.test.calendarioNovo.CalendarFragments
import br.senai.sp.jandira.test.calendarioNovo.CalendarScreen
import br.senai.sp.jandira.test.calendarioNovo.CalendaryS
import br.senai.sp.jandira.test.calendarioNovo.CustomCalendar
import br.senai.sp.jandira.test.calendarioNovo.MyKalendarScreen
import br.senai.sp.jandira.test.relatorio.RelatorioScreen
import br.senai.sp.jandira.test.telateste.FinalizarCadastroScreen
import br.senai.sp.jandira.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
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

                    CalendarScreen()
                    //CalendaryS()
                    //CalendarFragments()

                    //MyKalendarScreen()
                    //RelatorioScreen()
                    //var selectedDate by remember { mutableLongStateOf(0L) }
                    //CustomCalendar(selectedDate = mutableLongStateOf(selectedDate))





                    var context = LocalContext.current

                    //showTimePicker(context)
                }
            }
        }
    }
}