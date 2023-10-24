package br.senai.sp.jandira.test.AgoraVaiCalendario

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CalendarScreenS() {
    var selectedDate by remember { mutableStateOf(Calendar.getInstance()) }
    val dateFormat = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
    val scrollState = rememberScrollState()

    // Variáveis para rastrear a data selecionada
    var selectedYear by remember { mutableStateOf(selectedDate.get(Calendar.YEAR)) }
    var selectedMonth by remember { mutableStateOf(selectedDate.get(Calendar.MONTH) + 1) }
    var selectedDayOfWeek by remember { mutableStateOf("") }

    // Define um Locale para o idioma português
    val ptBrLocale = Locale("pt", "BR")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Parte superior: nome do mês, ano e botões de navegação
        TopAppBar(
            title = {
                Text(
                    text = dateFormat.format(selectedDate.time),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    selectedDate.add(Calendar.MONTH, -1)
                    selectedYear = selectedDate.get(Calendar.YEAR)
                    selectedMonth = selectedDate.get(Calendar.MONTH) + 1
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = {
                    selectedDate.add(Calendar.MONTH, 1)
                    selectedYear = selectedDate.get(Calendar.YEAR)
                    selectedMonth = selectedDate.get(Calendar.MONTH) + 1
                }) {
                    Icon(Icons.Default.ArrowForward, contentDescription = null)
                }
            }
        )

        // Parte do meio: LazyRow com os dias do mês
        Row(
            modifier = Modifier
                .padding(16.dp)
                .horizontalScroll(scrollState),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                val calendar = selectedDate.clone() as Calendar
                calendar.set(Calendar.DAY_OF_MONTH, 1)
                val maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

                for (day in 1..maxDays) {
                    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
                    val dayOfWeekString = SimpleDateFormat("E", ptBrLocale).format(calendar.time)
                    DayItem(
                        dayOfMonth = day,
                        dayOfWeek = dayOfWeekString,
                        isSelected = selectedDate.get(Calendar.DAY_OF_MONTH) == day,
                        onClick = {
                            selectedDate.set(Calendar.DAY_OF_MONTH, day)
                            selectedYear = selectedDate.get(Calendar.YEAR)
                            selectedMonth = selectedDate.get(Calendar.MONTH) + 1
                            selectedDayOfWeek = SimpleDateFormat("E", ptBrLocale).format(selectedDate.time)
                        }
                    )
                    calendar.add(Calendar.DAY_OF_MONTH, 1)
                }
            }
        )

        // Texto com informações da data selecionada
        Text(
            text = buildString {
                append("Data selecionada: ${selectedDate.get(Calendar.DAY_OF_MONTH)}-$selectedMonth-$selectedYear\n")
                append("Ano: $selectedYear\n")
                append("Mês: $selectedMonth\n")
                append("Dia da semana: $selectedDayOfWeek")
            },
            modifier = Modifier.padding(16.dp)
        )
    }
}
