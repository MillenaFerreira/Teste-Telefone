package br.senai.sp.jandira.test

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleAlarm() {
    var isAlarmActivated by remember { mutableStateOf(false) }
    var alarmMessage by remember { mutableStateOf("Alarm is not activated") }

    val coroutineScope = rememberCoroutineScope()

    val textFieldValue = remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Simple Alarm") }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                BasicTextField(
                    value = textFieldValue.value,
                    onValueChange = { newValue ->
                        textFieldValue.value = newValue
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp
                    ),
                    singleLine = true,
                    cursorBrush = SolidColor(Color.Black),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            // Dismiss the keyboard on "Done" press
                            // You can add more logic here to handle the alarm time input
                        }
                    )
                )

                Button(
                    onClick = {
                        val inputTime = textFieldValue.value.text
                        if (inputTime.isEmpty()) {
                            alarmMessage = "Please enter a valid time."
                        } else {
                            val timeInMillis = parseTimeToMillis(inputTime)
                            if (timeInMillis > 0) {
                                isAlarmActivated = true
                                alarmMessage = "Alarm activated for $inputTime"
                                coroutineScope.launch {
                                    delay(timeInMillis)
                                    // Call a function to handle the alarm action here
                                    // For example: showAlarmNotification(context)
                                    isAlarmActivated = false
                                    alarmMessage = "Alarm is not activated"
                                }
                            } else {
                                alarmMessage = "Please enter a valid time format (hh:mm:ss)."
                            }
                        }
                    }
                ) {
                    Text(text = "Activate Alarm")
                }

                Text(
                    text = alarmMessage,
                    color = if (isAlarmActivated) Color.Red else Color.Black,
                    fontSize = 18.sp
                )
            }
        }
    )
}

fun parseTimeToMillis(time: String): Long {
    val parts = time.split(":")
    if (parts.size == 3) {
        val hours = parts[0].toLongOrNull()
        val minutes = parts[1].toLongOrNull()
        val seconds = parts[2].toLongOrNull()

        if (hours != null && minutes != null && seconds != null) {
            return ((hours * 3600 + minutes * 60 + seconds) * 1000)
        }
    }
    return -1
}