package br.senai.sp.jandira.test.relatorio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//import androidx.navigation.NavController
//import br.senai.sp.jandira.ayancare_frontmobile.R
//import br.senai.sp.jandira.ayancare_frontmobile.components.DefaultButton
//import br.senai.sp.jandira.ayancare_frontmobile.components.DefaultTextField
//import br.senai.sp.jandira.ayancare_frontmobile.components.Wave

@Composable
fun QuestionScreen(
    //navController: NavController,
    //navRotasController: NavController
) {
    var descricaoState by remember {
        mutableStateOf("")
    }

    val options = listOf(
        "Sim",
        "Não",
    )

    var isSelectState by remember {
        mutableStateOf("")
    }


    Surface(
        color = Color(248, 240, 236)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
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
                horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Questionário ",
                    fontSize = 28.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF35225F)
                )
//                DefaultButton(
//                    onClick = { /*TODO*/ },
//                    text = "Adicionar"
//                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(280.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF35225F))
                ) {
                    Text(
                        text = "+ Adicionar Pergunta",
                        fontSize = 18.sp,
                        //fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(600),
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                LazyColumn(
                    modifier = Modifier.height(450.dp)
                ){
                    items(10){
                        Column {
                            Text(
                                text = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem? ",
                                fontSize = 16.sp,
                                //fontFamily = FontFamily(Font(R.font.manrope)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF9986BD)
                            )
                            Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {

                                Row (
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    RadioButton(
                                        selected = true,
                                        onClick = {}
                                    )
                                    Text(
                                        text = "Sim",
                                        fontSize = 16.sp,
                                        //fontFamily = FontFamily(Font(R.font.poppins)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF35225F)
                                    )
                                }

                                Row (
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    RadioButton(
                                        selected = false,
                                        onClick = {}
                                    )
                                    Text(
                                        text = "Não",
                                        fontSize = 16.sp,
                                        //fontFamily = FontFamily(Font(R.font.poppins)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF35225F)
                                    )
                                }


                            }

                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
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
                            text = "Gerar PDF",
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun fsdf() {
    QuestionScreen()
}