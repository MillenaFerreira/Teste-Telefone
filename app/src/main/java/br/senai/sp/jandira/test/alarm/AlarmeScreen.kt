package br.senai.sp.jandira.test.alarm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.Calendar

//@ExperimentalMaterial3Api()
//@Composable
//fun AlarmScreen() {
//    var selectedTime by remember { mutableStateOf(Calendar.getInstance()) }
//    var selectedDays by remember { mutableStateOf(emptyList<Int>()) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text("Selecione o horário do alarme:")
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Botão para abrir o DatePickerDialog
//        Button(
//            onClick = {
//                showTimePickerDialog(selectedTime) { newTime ->
//                    selectedTime = newTime
//                }
//            }
//        ) {
//            Text("Escolher Horário")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text("Selecione os dias da semana:")
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Componente para selecionar os dias da semana
//        DaysOfWeekPicker(selectedDays) { newDays ->
//            selectedDays = newDays
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Botão para configurar o alarme
//        Button(
//            onClick = {
//                setAlarm(selectedTime, selectedDays)
//            }
//        ) {
//            Text("Configurar Alarme")
//        }
//    }
//}