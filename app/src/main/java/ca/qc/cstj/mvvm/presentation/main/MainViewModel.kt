package ca.qc.cstj.mvvm.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.qc.cstj.mvvm.core.Constants
import ca.qc.cstj.mvvm.domain.models.Pilot
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val pilot = Pilot("anthonyq", 15)

    private val _mainUiState = MutableStateFlow<MainUiState>(MainUiState.Empty)
    val mainUiState = _mainUiState.asStateFlow()

    init {
        _mainUiState.update {
            return@update MainUiState.Success(pilot)
        }
    }


    fun fly(revolution: Int, isTraining: Boolean) {
        if(pilot.canFly()) {
            viewModelScope.launch {

                _mainUiState.update {
                    MainUiState.Loading
                }

                delay(Constants.REVOLUTION_DURATION * revolution)


                pilot.fly(revolution,isTraining)

                _mainUiState.update {
                    MainUiState.Success(pilot)
                }
            }

        }
        else {
            _mainUiState.update {
                MainUiState.Error("Can't Fly")
            }
        }
    }

    fun recharge() {
        pilot.recharge()
        _mainUiState.value = MainUiState.Success(pilot)
    }

}
