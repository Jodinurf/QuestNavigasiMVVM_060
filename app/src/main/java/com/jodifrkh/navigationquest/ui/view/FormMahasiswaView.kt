package com.jodifrkh.navigationquest.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit
){
    var name by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val dataMahasiswa : MutableList<String> = mutableListOf(name, selectedGender, alamat, noHP)

    Column (Modifier.fillMaxSize().padding(16.dp)
        , horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(value = name,
            onValueChange = {name = it},
            placeholder = { Text("Masukkan Nama")
            }, label = { Text("Nama")},
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Row(){
            listJK.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically) { RadioButton(
                    selected = selectedGender == item,
                    onClick = {
                        selectedGender = item
                    } )
                    Text(item)
                }
            }
        }
        OutlinedTextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan Emai;") },
            label = { Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        OutlinedTextField(value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat") },
            label = { Text("Alamat")},
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        OutlinedTextField(value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Masukkan Nomor Handphone") },
            label = { Text("No HP")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Button(onClick = { onSubmitButtonClicked(dataMahasiswa)})
        {
            Text("Simpan")
        }


    }
}

