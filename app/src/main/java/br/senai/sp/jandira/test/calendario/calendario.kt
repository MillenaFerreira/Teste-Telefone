package br.senai.sp.jandira.test.calendario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
//import com.google.accompanist.pager.ExperimentalPagerApi
//import com.google.accompanist.pager.rememberPagerState
import java.text.SimpleDateFormat
import java.util.*

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            CalendarApp()
//        }
//    }
//}

//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun CalendarApp() {
//    val pagerState = rememberPagerState(pageCount = 12)
//    val selectedDate = remember { mutableStateOf(Calendar.getInstance()) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        // Cabeçalho com setas e mês/ano
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(
//                onClick = {
//                    // Navegar para o mês anterior
//                    selectedDate.value.add(Calendar.MONTH, -1)
//                }
//            ) {
//                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
//            }
//
//            Text(
//                text = SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(selectedDate.value.time),
//                style = MaterialTheme.typography.bodyMedium
//            )
//
//            IconButton(
//                onClick = {
//                    // Navegar para o próximo mês
//                    selectedDate.value.add(Calendar.MONTH, 1)
//                }
//            ) {
//                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Corpo do calendário
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(360.dp)
//                .background(Color.Gray)
//        ) {
//            // Incluir a lógica para exibir os dias do mês aqui
//            // Você pode usar um LazyColumn ou outra estrutura de layout
//        }
//    }
//}
