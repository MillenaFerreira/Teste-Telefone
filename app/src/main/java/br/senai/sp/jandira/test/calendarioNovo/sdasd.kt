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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Calendar

class CalendarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = ComposeView(requireContext())
        rootView.apply {
            setContent {
                CalendarScreen()
            }
        }
        return rootView
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen() {
    var selectedDate by remember { mutableLongStateOf(0L) }
    val selectedMonthYear = remember { mutableStateOf(Pair(0, 0)) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Substituir o topo do CalendarView pela TopAppBar
        androidx.compose.material.TopAppBar(
            title = {
                Text(
                    text = getMonthYearString(
                        selectedMonthYear.value.first,
                        selectedMonthYear.value.second
                    ),
                    style = MaterialTheme.typography.h6,
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = { /* Ação do ícone de esquerda */ },
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(
                    onClick = { /* Ação do ícone de direita */ }
                ) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }
            },
            elevation = 0.dp
        )

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
            text = "Selected Date: ${SimpleDateFormat("dd/MM/yyyy").format(selectedDate)}",
            modifier = Modifier.padding(16.dp)
        )
    }
}

fun getMonthYearString(month: Int, year: Int): String {
    val monthsArray = arrayOf(
        "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    )
    return "${monthsArray[month]} de $year"
}
