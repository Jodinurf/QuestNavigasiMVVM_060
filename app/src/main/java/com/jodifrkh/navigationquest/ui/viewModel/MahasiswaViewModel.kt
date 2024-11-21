package com.jodifrkh.navigationquest.ui.viewModel

import androidx.lifecycle.ViewModel
import com.jodifrkh.navigationquest.model.DataMahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel:ViewModel() {
    //Request
    private val _uiState = MutableStateFlow(DataMahasiswa())
    val uiState:StateFlow<DataMahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(listDM: List<String>){
        _uiState.update { dataMhs ->
            dataMhs.copy(
                nama = listDM[0],
                gender = listDM[1],
                alamat = listDM[2],
                noHP = listDM[3]
            )
        }
    }
}