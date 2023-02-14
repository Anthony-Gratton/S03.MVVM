package ca.qc.cstj.mvvm.presentation.planet

import ca.qc.cstj.mvvm.domain.models.Planet

sealed class PlanetsUiState {
    object Empty : PlanetsUiState()
    class Sucess(val planets: List<Planet>) : PlanetsUiState()
}