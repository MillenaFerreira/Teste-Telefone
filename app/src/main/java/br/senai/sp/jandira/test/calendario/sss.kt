package br.senai.sp.jandira.test.calendario

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun SingleRowCalendar() {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    // Renderiza o cabeçalho do mês e ano
    val headerText = selectedDate.format(DateTimeFormatter.ofPattern("MMMM yyyy", Locale.getDefault()))
    Text(
        text = headerText,
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(16.dp)
    )

    // Renderiza a grade de dias do mês
    val daysInMonth = getDaysInMonth(selectedDate)
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(daysInMonth) { day ->
            CalendarDayItem(
                day = day,
                onDateSelected = { selectedDate = it },
                isSelected = day == selectedDate
            )
        }
    }
}

@Composable
fun CalendarDayItem(
    day: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    isSelected: Boolean
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .padding(4.dp)
            .background(if (isSelected) Color.Black else Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.dayOfMonth.toString(),
            color = if (isSelected) Color.White else Color.Black,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.clickable { onDateSelected(day) }
        )
    }
}

fun getDaysInMonth(date: LocalDate): List<LocalDate> {
    val year = date.year
    val month = date.month
    val days = mutableListOf<LocalDate>()

    val firstDay = LocalDate.of(year, month, 1)
    val lastDay = firstDay.plusMonths(1).minusDays(1)

    var currentDay = firstDay
    while (!currentDay.isAfter(lastDay)) {
        days.add(currentDay)
        currentDay = currentDay.plusDays(1)
    }

    return days
}
