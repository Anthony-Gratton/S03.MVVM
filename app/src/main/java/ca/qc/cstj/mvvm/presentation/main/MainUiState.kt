package ca.qc.cstj.mvvm.presentation.main

import ca.qc.cstj.mvvm.domain.models.Pilot

//class PilotUiState(val isSuccess:Boolean, val pilot :Pilot)


sealed class MainUiState{
    class Success(val pilot:Pilot): MainUiState()
    object Loading: MainUiState()
    class Error(val message:String): MainUiState()
    object Empty: MainUiState()

}