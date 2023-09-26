package br.senai.sp.jandira.test.ui.theme

import android.app.TimePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun showTimePicker(context: Context){

    val calendar = Calendar.getInstance()
    val horas = Calendar.HOUR
    val  minutos = Calendar.MINUTE

    val tempo = remember{
        mutableStateOf("")
    }
    val timePickerDialog = TimePickerDialog(
        context,
        { _, horas:Int,minutos:Int->
            tempo.value="$horas:$minutos"
        },horas,minutos,false
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selecione o tempo:${tempo.value}")
        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = {
            timePickerDialog.show()
        }) {
            Text(text = "Abra o tempo ")
        }
    }
}