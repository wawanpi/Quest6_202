package com.example.pertemuan8.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pertemuan8.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {
    private val _mahasiwaStateUI = MutableStateFlow(Mahasiswa())

    val MahasiswaStateUI: StateFlow<Mahasiswa> = _mahasiwaStateUI.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>) {
        _mahasiwaStateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = ls[0],
                nim = ls[1],
                email = ls[2]
            )
        }
    }
}