package com.example.pertemuan8.ui.view.viewmodel;

import static kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow;

public class RencanaStudyViewModel : ViewModel() {
    private val_krsState = MutableStateFlow(RencanaStudi())
    val krsState: StateFlow<RencanaStudi> = _krsState.asStateFlow()

    fun setMataKuliah(mkPilihan: String) {
        _krsState.update { stateMK -> stateMK.copy(namaMk = mkPilihan) }
    }
    fun setKelas(kelasPilihan: String) {
        _krsState.update { stateKelas -> stateKelas.copy(kelas = kelasPilihan) }
    }
    fun saveDataKRS(ls: MutableList<String>){
        _krsState.update {
            status -> status.copy(
                    namaMk = ls[0],
                    kelas = ls[1]
            )
        }
    }
}
