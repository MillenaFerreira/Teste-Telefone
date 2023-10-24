package br.senai.sp.jandira.test.AgoraVaiCalendario

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.test.calendarioIngles.TextEditCalendary
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun CalendarScreenSS() {
    var selectedDate by remember { mutableStateOf(Calendar.getInstance()) }
    val dateFormat = SimpleDateFormat("MMMM yyyy", Locale.getDefault())

    // Variáveis para rastrear a data selecionada
    var selectedYear by remember { mutableIntStateOf(selectedDate.get(Calendar.YEAR)) }
    var selectedMonth by remember { mutableIntStateOf(selectedDate.get(Calendar.MONTH) + 1) }
    var selectedDayOfWeek by remember { mutableStateOf("") }

    // Define um Locale para o idioma português
    val ptBrLocale = Locale("pt", "BR")

    Column(
        modifier = Modifier
            .background(
                Brush.horizontalGradient(
                    listOf(
                        Color(0, 0, 0),
                        Color(53, 34, 95),
                        //Color(0, 0, 0)
                    )
                )
            )
    ) {
        // Parte superior: nome do mês, ano e botões de navegação
        TopAppBar(
            title = {
                Text(
                    text = dateFormat.format(selectedDate.time).toUpperCase(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            },
            actions = {
                IconButton(onClick = {
                    selectedDate.add(Calendar.MONTH, -1)
                    selectedYear = selectedDate.get(Calendar.YEAR)
                    selectedMonth = selectedDate.get(Calendar.MONTH) + 1
                }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                IconButton(onClick = {
                    selectedDate.add(Calendar.MONTH, 1)
                    selectedYear = selectedDate.get(Calendar.YEAR)
                    selectedMonth = selectedDate.get(Calendar.MONTH) + 1
                }) {
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            backgroundColor = Color(53, 34, 95)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            TextEditCalendary("D")
            TextEditCalendary("S")
            TextEditCalendary("T")
            TextEditCalendary("Q")
            TextEditCalendary("Q")
            TextEditCalendary("S")
            TextEditCalendary("S")
        }

        // Parte do meio: LazyColumn com os dias do mês em blocos de 7
        val calendar = selectedDate.clone() as Calendar
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        val maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        val daysPerBlock = 7
        val numBlocks = (maxDays + daysPerBlock - 1) / daysPerBlock

        for (blockIndex in 0 until numBlocks) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (dayIndex in 0 until 7) {
                    val day = blockIndex * 7 + dayIndex - calendar.get(Calendar.DAY_OF_WEEK) + 2
                    if (day in 1..maxDays) {
                        val isSelected = selectedDate.get(Calendar.DAY_OF_MONTH) == day
                        if (isSelected) {
                            Card(
                                modifier = Modifier
                                    .size(45.dp),
                                backgroundColor = if (isSelected) Color(0xFFF9F1ED) else Color.Transparent,
                                shape = CircleShape
                            ) {
                                Text(
                                    text = day.toString(),
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        //.weight(1f)
                                        .padding(10.dp)
                                        .clickable {
                                            selectedDate.set(Calendar.DAY_OF_MONTH, day)
                                            selectedYear = selectedDate.get(Calendar.YEAR)
                                            selectedMonth = selectedDate.get(Calendar.MONTH) + 1
                                            selectedDayOfWeek =
                                                SimpleDateFormat(
                                                    "E",
                                                    ptBrLocale
                                                ).format(selectedDate.time)
                                        },
                                    textAlign = TextAlign.Center,
                                    color = if (isSelected) Color(0xFF35225F) else Color(0xFFF9F1ED)
                                )
                            }

                        } else {
                            Text(
                                text = day.toString(),
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(10.dp)
                                    .clickable {
                                        selectedDate.set(Calendar.DAY_OF_MONTH, day)
                                        selectedYear = selectedDate.get(Calendar.YEAR)
                                        selectedMonth = selectedDate.get(Calendar.MONTH) + 1
                                        selectedDayOfWeek =
                                            SimpleDateFormat(
                                                "E",
                                                ptBrLocale
                                            ).format(selectedDate.time)
                                    }
                                    .background(
                                        shape = CircleShape,
                                        color = if (isSelected) Color.Cyan else Color.Transparent,
                                        //border = if (isSelected) BorderStroke(2.dp, Color.White) else null
                                    )
                                    .size(30.dp), // Tamanho do círculo
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }

                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }

        // Texto com informações da data selecionada
        Text(
            text = buildString {
                append("Data selecionada: ${selectedDate.get(Calendar.DAY_OF_MONTH)}/$selectedMonth/$selectedYear\n")
                append("Ano: $selectedYear\n")
                append("Mês: $selectedMonth\n")
                append("Dia da semana: $selectedDayOfWeek")
            },
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
    }
}


@Preview
@Composable
fun dasfdsa() {
    CalendarScreenSS()
}





