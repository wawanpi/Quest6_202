package com.example.pertemuan8.ui.view.screen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onSubmiteButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
){
var chosenDropdown by remember { mutableStateOf("") }
    var cheked by remember { mutableStateOf(false) }
    var pilihanKelas by remember { mutableStateOf("") }
}