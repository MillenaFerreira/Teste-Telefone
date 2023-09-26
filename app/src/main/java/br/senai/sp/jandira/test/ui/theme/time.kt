package br.senai.sp.jandira.test.ui.theme

import android.app.TimePickerDialog
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun Time() {
    var selectedTime by remember { mutableStateOf(Calendar.getInstance()) }
    val formatter = remember { SimpleDateFormat("hh:mm a", Locale.getDefault()) }
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    var showTimePicker by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { showTimePicker = true },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Set Time")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Selected Time: ${formatter.format(selectedTime.time)}")

        BackHandler(enabled = showTimePicker) {
            showTimePicker = false
        }

        if (showTimePicker) {
            val timePickerDialog = TimePickerDialog(
                LocalView.current.context,
                { _, hourOfDay, minute ->
                    selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    selectedTime.set(Calendar.MINUTE, minute)

                    snackScope.launch {
                        snackState.showSnackbar("Entered time: ${formatter.format(selectedTime.time)}")
                    }

                    showTimePicker = false
                },
                selectedTime.get(Calendar.HOUR_OF_DAY),
                selectedTime.get(Calendar.MINUTE),
                false
            )

            DisposableEffect(key1 = timePickerDialog) {
                onDispose {
                    timePickerDialog.dismiss()
                }
            }

            timePickerDialog.show()
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Screen Height: ${configuration.screenHeightDp}",
        )
    }

    SnackbarHost(
        hostState = snackState,
        modifier = Modifier
            .padding(16.dp)
    )
}