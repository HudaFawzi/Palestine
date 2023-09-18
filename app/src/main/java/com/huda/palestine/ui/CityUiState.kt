package com.huda.palestine.ui

import com.huda.palestine.data.local.LocalCitiesDataProvider
import com.huda.palestine.data.local.Section
import com.huda.palestine.model.City

data class CityUiState(
    val sections: Map<Section, List<City>> = emptyMap(),
    val currentSection: Section = Section.MAP,
    val currentSelectedCity: City = LocalCitiesDataProvider.defaultCity,
    val isShowingHomePage: Boolean = true
) {
    val currentSectionCities: List<City> by lazy { sections[currentSection]!! }
}