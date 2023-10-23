package br.senai.sp.jandira.test.calendarioNovo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import com.himanshoe.kalendar.endlos.DaySelectionMode
import com.himanshoe.kalendar.endlos.Kalendar
import com.himanshoe.kalendar.endlos.model.KalendarEvents
import com.himanshoe.kalendar.endlos.paging.rememberKalendarPagingController
import com.himanshoe.kalendar.endlos.ui.color.KalendarColor
import com.himanshoe.kalendar.endlos.ui.color.KalendarColors
import com.himanshoe.kalendar.endlos.ui.day.KalendarDayKonfig
import com.himanshoe.kalendar.endlos.ui.header.KalendarHeaderPreview
import com.himanshoe.kalendar.endlos.ui.header.KalendarTextKonfig
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
fun MyKalendarScreen() {
    val pagingController = rememberKalendarPagingController()

    // Defina a data inicial, por exemplo, a data atual
    val initialDate = LocalDate.now()



    // Use o componente Kalendar e defina-o como uma Composable
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ){
        Text(text = initialDate.toString())
    Kalendar(
        modifier = Modifier.fillMaxSize(),
        showLabel = true,
        pagingController = pagingController,
        kalendarHeaderTextKonfig = KalendarTextKonfig(
            kalendarTextColor = Color.Blue,
            kalendarTextSize = 10.sp
        ),
        kalendarColors = KalendarColors(),
        events = KalendarEvents(),
        kalendarDayKonfig = KalendarDayKonfig(
            size = 18.dp,
            textColor = Color.Blue,
            textSize = 10.sp,
            selectedTextColor = Color.Black,
            borderColor = Color.Black
        ),
        contentPadding = PaddingValues(16.dp),
        monthContentPadding = PaddingValues(8.dp),
        dayContent = { date ->
            Text(
                text = date.dayOfMonth.toString(),
                fontSize = 16.sp,
                color = Color.Black
            )
        },
        headerContent = { month, year ->
            Text(
                text = "${month.name}, $year",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        },
        daySelectionMode = DaySelectionMode.Range,
        onDayClicked = { date, events ->
            // Handle day click event
        },
        onRangeSelected = { range, events ->
            // Handle range selection event
        },
        onErrorRangeSelected = { error ->
            // Handle range selection error
        }
    )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun sfsdf() {
    MyKalendarScreen() // Chame o Composable do Kalendar aqui
}


