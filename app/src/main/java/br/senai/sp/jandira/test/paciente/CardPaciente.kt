package br.senai.sp.jandira.test.paciente

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardPaciente(
    onUnlinkClick: () -> Unit,
    onProfileClick: () -> Unit,
    nome: String,
    id: Int,
    foto: String,
    ano: Int
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded },
        //elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
//                AsyncImage(
//                    model = "$foto",
//                    contentDescription = "",
//                    modifier = Modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//                )
                Image(
                    imageVector = Icons.Default.Image,
                    contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "$nome",
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.manrope)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF35225F)
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.width(100.dp)
                        ) {
                            Text(
                                text = "#$id",
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                //fontFamily = FontFamily(Font(R.font.manrope)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF9986BD)
                            )
                            Text(
                                text = "$ano anos",
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                //fontFamily = FontFamily(Font(R.font.manrope)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF9986BD)
                            )
                        }

                    }

                    IconButton(
                        onClick = { isExpanded = !isExpanded }
                    ) {
                        if (isExpanded) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "",
                                modifier = Modifier.size(30.dp)
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowUp,
                                contentDescription = "",
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }
            }

            if (isExpanded) {
                Spacer(modifier = Modifier.run { height(16.dp) })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = onUnlinkClick,
                        modifier = Modifier
                            .width(150.dp)
                            .height(35.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF9A9A9A))
                    ) {
                        Text(
                            text = "Relátorio",
                            fontSize = 12.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF)
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = onProfileClick,
                        modifier = Modifier
                            .width(150.dp)
                            .height(35.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF35225F))
                    ) {
                        Text(
                            text = "Ver Agenda",
                            fontSize = 12.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF)
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = onProfileClick,
                        modifier = Modifier
                            .width(150.dp)
                            .height(35.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF35225F))
                    ) {
                        Text(
                            text = "Abrir Perfil",
                            fontSize = 12.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun fcdascvasd() {

    var isDialogVisibleConect by remember { mutableStateOf(false) }

    CardPaciente(
        onUnlinkClick = {
            isDialogVisibleConect = true
        },
        onProfileClick = {},
        nome = "Janice Nelson",
        id = 1597,
        foto = "it.foto_cuidador",
        ano = 84
    )
}