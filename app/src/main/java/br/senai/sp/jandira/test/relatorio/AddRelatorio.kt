package br.senai.sp.jandira.test.relatorio

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddRelatorioScreen() {

    val scrollState = rememberScrollState()

    Surface(
        color = Color(248, 240, 236)
    ) {
        Column(
            //verticalArrangement = Arrangement.SpaceBetween,
            //horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 40.dp, start = 15.dp, end = 15.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Lurdes Aparecida",
                fontSize = 25.sp,
                //fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(600),
                color = Color(0xFF35225F)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "#76573",
                fontSize = 14.sp,
                //fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(500),
                color = Color(0xFF9986BD)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "84 anos, Mulher",
                fontSize = 14.sp,
                //fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(500),
                color = Color(0xFF9986BD)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Column {
                Text(
                    text = "Relátorio",
                    fontSize = 18.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF35225F)
                )
                TextField(
                    value = "",
                    onValueChange = {
                        //localState = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFF9986BD),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color(248, 240, 236)
                    )
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                Button(
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Questionário",
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFF9F6FF),
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Questionário",
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFF9F6FF),
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Questionário",
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFF9F6FF),
                        textAlign = TextAlign.Center
                    )
                }
            }


        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun fsdfsadfssdf() {
    AddRelatorioScreen()
}