package br.senai.sp.jandira.test.relatorio.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.test.relatorio.AddRelatorioScreen

@Composable
fun Questionario() {
    Surface(
        color = Color(248, 240, 236)
    ) {
        Column(
            //verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 40.dp, start = 15.dp, end = 15.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Questionário ",
                fontSize = 28.sp,
                //fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(500),
                color = Color(0xFF35225F)
            )

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun fsdfsadfssdfssf() {
    Questionario()
}