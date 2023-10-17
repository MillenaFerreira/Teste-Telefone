package br.senai.sp.jandira.test.telateste

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownGender(
    context: Context,
    gender: String,
    onValueChange: (String) -> Unit
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var selectedGender = gender // Use uma variável separada para rastrear a seleção

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {

            TextField(
                value = selectedGender,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            // Aqui você pode criar uma lista de gêneros para exibir no DropdownMenu
            val genderOptions = listOf("Masculino", "Feminino", "Outro")

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                genderOptions.forEach {
                    DropdownMenuItem(
                        text = { Text(text = it, color = Color.Black) },
                        onClick = {
                            selectedGender = it // Atualiza a variável com a seleção do usuário
                            onValueChange(it) // Chama a função de retorno com o valor selecionado
                            isExpanded = false
                        }
                    )
                }
            }

        }
    }
}
