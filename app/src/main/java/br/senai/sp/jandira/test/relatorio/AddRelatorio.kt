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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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

    var descricaoState by remember {
        mutableStateOf("")
    }

    androidx.compose.material.Surface(
        color = Color(248, 240, 236)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 20.dp, start = 15.dp, end = 15.dp)
                .fillMaxSize()
        ) {
            IconButton(
                onClick = {
                    //navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = ""
                )
            }
            Column(
                //horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "Lurdes Aparecida",
                    fontSize = 25.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF35225F)
                )
                Text(
                    text = "#76573",
                    fontSize = 14.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF9986BD)
                )
                Text(
                    text = "84 anos, Mulher",
                    fontSize = 14.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF9986BD)
                )

                Spacer(modifier = Modifier.height(30.dp))

                Column {
                    Text(
                        text = "Relátorio",
                        fontSize = 18.sp,
                        //fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF35225F)
                    )
                    TextField(
                        value = descricaoState,
                        onValueChange = { descricaoState = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(450.dp)
                            .border(
                                width = 1.dp,
                                color = Color(167, 165, 164),
                                shape = RoundedCornerShape(4.dp)
                            ),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(248, 240, 236)
                        )
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
//                    DefaultButton(
//                        onClick = { /*TODO*/ },
//                        text = "Adicionar"
//                    )
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .width(180.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF35225F))
                    ) {
                        Text(
                            text = "Questionário",
                            fontSize = 18.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(600),
                            color = Color.White
                        )
                    }
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