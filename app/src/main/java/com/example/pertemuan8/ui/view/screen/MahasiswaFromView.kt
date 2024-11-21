package com.example.pertemuan8.ui.view.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MahasiswaFormView(
    onSubmitButtonCLicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
){
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(nama, nim, email)
}