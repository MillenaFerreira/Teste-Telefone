package br.senai.sp.jandira.test


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomSwitchWithLabel(
    text: String,
    phoneNumber: String,
    onSwitchChange: (Boolean) -> Unit
) {
    var isSwitchOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                isSwitchOn = !isSwitchOn
                onSwitchChange(isSwitchOn)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = phoneNumber,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(MaterialTheme.colorScheme.primary)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyScreen() {
    //var phoneNumber by remember { mutableStateOf("966917301") }
    var switchState by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        CustomSwitchWithLabel(
            text = "Telefone Pessoal",
            phoneNumber = "11966927301",
            onSwitchChange = { newState ->
                switchState = newState
                if (switchState) {
                    // Inicie a chamada telefônica aqui
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel: 11966927301")
                    context.startActivity(intent)
                }
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomSwitchWithLabel(
            text = "Mãe",
            phoneNumber = "11962378021",
            onSwitchChange = { newState ->
                switchState = newState
                if (switchState) {
                    // Inicie a chamada telefônica aqui
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel: 11962378021")
                    context.startActivity(intent)
                }
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomSwitchWithLabel(
            text = "Pai",
            phoneNumber = "11905050505",
            onSwitchChange = { newState ->
                switchState = newState
                if (switchState) {
                    // Inicie a chamada telefônica aqui
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel: 11905050505")
                    context.startActivity(intent)
                }
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomSwitchWithLabel(
            text = "SAMU",
            phoneNumber = "193",
            onSwitchChange = { newState ->
                switchState = newState
                if (switchState) {
                    // Inicie a chamada telefônica aqui
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel: 193")
                    context.startActivity(intent)
                }
            }
        )
    }
}

@Composable
fun CustomSwitchWithLabelPreview() {
        MyScreen()
}

@Preview
@Composable
fun CustomSwitchWithLabelPreviewDark() {
        MyScreen()
}
