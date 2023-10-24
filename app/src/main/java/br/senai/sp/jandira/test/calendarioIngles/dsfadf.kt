package br.senai.sp.jandira.test.calendarioIngles

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextEditCalendary(text:String) {
    Text(
        text = text,
        fontSize = 18.sp,
        //fontFamily = FontFamily(Font(R.font.poppins)),
        fontWeight = FontWeight(400),
        color = Color(0xFFAFAFAF),
        textAlign = TextAlign.Center
    )
}