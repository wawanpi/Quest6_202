package com.example.pertemuan8.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan8.ui.view.viewmodel.MahasiswaViewModel
import com.example.pertemuan8.ui.view.viewmodel.RencanaStudyViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    MataKuliah,
    Tampilan
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    KrsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
