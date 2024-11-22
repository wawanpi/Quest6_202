package com.example.pertemuan8.navigation

import android.window.SplashScreenView
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan8.ui.view.screen.MahasiswaFormView
import com.example.pertemuan8.ui.view.screen.RencanaStudyView
import com.example.pertemuan8.ui.view.screen.SplashView
import com.example.pertemuan8.ui.view.screen.TampilData
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
) {
    val mahasiwaUiState = mahasiswaViewModel.MahasiswaStateUI.collectAsState().value
    val KrsUiState = KrsViewModel.krsState.collectAsState().value
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaiButton = {
                navController.navigate(Halaman.Mahasiswa.name)
            })
        }
    }
    composable(route = Halaman.Mahasiswa.name) {
        MahasiswaFormView(
            onSimpanButtonClicked = {
                mahasiswaViewModel.saveDataMahasiswa(it)
                navController.navigate(Halaman.MataKuliah.name)
            },
            onBackButtonClicked = {
                navController.popBackStack()
            }
        )
    }
    composable(route = Halaman.MataKuliah.name) {
        RencanaStudyView(
            mahasiswa = mahasiswaUiState,
            onSubmitButtonClicked = {
                KrsViewModel.saveDataKRS(it)
                navController.navigate(Halaman.Tampil.name)
            },
            onBackButtonClicked = { navController.popBackStack() }
        )
    }
    composable(route = Halaman.Tampil.name) {
        TampilData(
            mahasiswa = mahasiwaUiState,
            rencanaStudi = KrsUiState,
            onBackButtonClicked = {
                navController.navigate(Halaman.Splash.name) {
                    popUpTo(0) { inclusive = true }
                }
            }
        )
    }
}
}


