package com.jodifrkh.navigationquest


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jodifrkh.navigationquest.model.DataKelamin
import com.jodifrkh.navigationquest.ui.view.DetailMahasiswaView
import com.jodifrkh.navigationquest.ui.view.FormMahasiswaView
import com.jodifrkh.navigationquest.ui.viewModel.MahasiswaViewModel


enum class Halaman{
    Form,
    Data
}


@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel : MahasiswaViewModel = viewModel()
){
    Scaffold { isipadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navController,
            startDestination = Halaman.Form.name)
        {
            composable(route = Halaman.Form.name){
                val konteks = LocalContext.current
                FormMahasiswaView(
                    listJK = DataKelamin.listJK.map {
                            id -> konteks.resources.getString(id)
                    },
                    onSubmitButtonClicked = {
                        viewModel.saveDataMahasiswa(it)
                        navController.navigate(Halaman.Data.name)
                    }
                )
            }
            composable(route = Halaman.Data.name) {
                DetailMahasiswaView(
                    uiStateMahasiswa = uiState,
                    onClickButton = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}