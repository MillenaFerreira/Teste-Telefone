package br.senai.sp.jandira.test.calendarioNovo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomCalendar(
    selectedDate: MutableState<Long>
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Custom TopAppBar with Month and Year
        androidx.compose.material.TopAppBar(
            title = {
                Text(
                    text = "October 2023", // Replace with dynamic month and year
                    style = MaterialTheme.typography.h6
                )
            },
            elevation = 0.dp,
            modifier = Modifier.fillMaxWidth()
        )

        // Calendar Grid
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            content = {
                items(6) { rowIndex ->
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        content = {
                            items(7) { columnIndex ->
                                val date = (rowIndex * 7 + columnIndex + 1).toLong()
                                DayCell(
                                    date = date,
                                    isSelected = date == selectedDate.value,
                                    onDateSelected = { selectedDate.value = date }
                                )
                            }
                        }
                    )
                }
            }
        )
    }
}

@Composable
fun DayCell(
    date: Long,
    isSelected: Boolean,
    onDateSelected: (Long) -> Unit
) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(if (isSelected) Color.Blue else Color.White)
            .clickable { onDateSelected(date) }
    ) {
        Text(
            text = date.toString(),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
