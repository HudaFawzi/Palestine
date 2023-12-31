package com.huda.palestine.ui

import androidx.lifecycle.ViewModel
import com.huda.palestine.data.Section
import com.huda.palestine.data.local.LocalCitiesDataProvider
import com.huda.palestine.model.City
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val cities: Map<Section, List<City>> =
            LocalCitiesDataProvider.allCities.groupBy { it.section }
        _uiState.value = AppUiState(
            sections = cities,
            currentSelectedCity = cities[Section.MAP]?.get(0) ?: LocalCitiesDataProvider.defaultCity
        )
    }

    fun updateDetailsScreenStates(city: City) {
        _uiState.update {
            it.copy(
                currentSelectedCity = city, isShowingHomePage = false
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedCity = it.sections[it.currentSection]?.get(0)
                    ?: LocalCitiesDataProvider.defaultCity, isShowingHomePage = true
            )
        }
    }

    fun updateCurrentSection(section: Section) {
        _uiState.update {
            it.copy(
                currentSection = section
            )
        }
    }
}