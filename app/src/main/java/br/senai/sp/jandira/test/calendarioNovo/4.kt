package br.senai.sp.jandira.test.calendarioNovo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import com.himanshoe.kalendar.Kalendar
import com.himanshoe.kalendar.KalendarEvents
import com.himanshoe.kalendar.KalendarType
import com.himanshoe.kalendar.color.KalendarColors
import com.himanshoe.kalendar.ui.component.day.KalendarDayKonfig
import com.himanshoe.kalendar.ui.firey.DaySelectionMode
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Locale

class CalendarFragments : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = ComposeView(requireContext())
        rootView.apply {
            setContent {
                CalendaryS()
            }
        }
        return rootView
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendaryS() {
    var selectedDate by remember { mutableStateOf(Calendar.getInstance().timeInMillis) }
    val selectedMonthYear = remember { mutableStateOf(Pair(0, 0)) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(
            factory = { context ->
                CalendarView(context).apply {
                    setOnDateChangeListener { _, year, month, dayOfMonth ->
                        selectedDate = Calendar.getInstance().apply {
                            set(year, month, dayOfMonth)
                        }.timeInMillis
                        selectedMonthYear.value = Pair(month, year)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Selected Date: ${SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).format(selectedDate)}",
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "Mês selecionado: ${getMonthYearStrings(selectedMonthYear.value.first, selectedMonthYear.value.second)}",
            modifier = Modifier.padding(16.dp)
        )
    }
}

fun getMonthYearStrings(month: Int, year: Int): String {
    val monthsArray = arrayOf(
        "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    )
    return "${monthsArray[month]} de $year"
}

@Composable
fun Kalendar() {

    val currentDate = remember { LocalDate.now() }

    Kalendar(
        currentDay = null,
        kalendarType = KalendarType.Firey,
        modifier = Modifier,
        showLabel = true,
        events = KalendarEvents(),
        kalendarHeaderTextKonfig = null,
        kalendarColors = KalendarColors.default(),
        kalendarDayKonfig = KalendarDayKonfig.default(),
        daySelectionMode = DaySelectionMode.Single,
        dayContent = null,
        headerContent = null,
        onDayClick = { selectedDay, events ->
            // Handle day click event
        },
        onRangeSelected = { selectedRange, events ->
            // Handle range selection event
        },
        onErrorRangeSelected = { error ->
            // Handle error
        })
}


