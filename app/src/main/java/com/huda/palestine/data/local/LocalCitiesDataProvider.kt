package com.huda.palestine.data.local

import com.example.palestine.R
import com.huda.palestine.model.City

object LocalCitiesDataProvider {
    val allCities = listOf(
        City(
            R.string.jerusalem,
            R.drawable.hebron,
            Section.WEST_BANK,
            R.string.jerusalem_pop,
            R.string.jerusalem_area,
            R.string.jerusalem_description
        ), City(
            R.string.hebron,
            R.drawable.hebron,
            Section.WEST_BANK,
            R.string.hebron_pop,
            R.string.hebron_area,
            R.string.hebron_description
        ), City(
            R.string.jericho,
            R.drawable.hebron,
            Section.WEST_BANK,
            R.string.jericho_pop,
            R.string.jericho_area,
            R.string.jericho_description
        ), City(
            R.string.nablus,
            R.drawable.hebron,
            Section.WEST_BANK,
            R.string.nablus_pop,
            R.string.nablus_area,
            R.string.nablus_description
        ), City(
            R.string.ramallah,
            R.drawable.hebron,
            Section.WEST_BANK,
            R.string.ramallah_pop,
            R.string.ramallah_area,
            R.string.ramallah_description
        ), City(
            R.string.bethlehem,
            R.drawable.hebron,
            Section.WEST_BANK,
            R.string.bethlehem_pop,
            R.string.bethlehem_area,
            R.string.bethlehem_description
        ), City(
            R.string.tulkarm,
            R.drawable.hebron,
            Section.WEST_BANK,
            R.string.tulkarm_pop,
            R.string.tulkarm_area,
            R.string.tulkarm_description
        ), City(
            R.string.jenin,
            R.drawable.hebron,
            Section.WEST_BANK,
            R.string.jenin_pop,
            R.string.jenin_area,
            R.string.jenin_description
        ), City(
            R.string.al_bireh,
            R.drawable.hebron,
            Section.WEST_BANK,
            R.string.al_bireh_pop,
            R.string.al_bireh_area,
            R.string.al_bireh_description
        ), City(
            R.string.khan_yunis,
            R.drawable.hebron,
            Section.WEST_BANK,
            R.string.khan_yunis_pop,
            R.string.khan_yunis_area,
            R.string.khan_yunis_description
        ), City(
            R.string.rafah,
            R.drawable.hebron,
            Section.GAZA,
            R.string.rafah_pop,
            R.string.rafah_area,
            R.string.rafah_description
        ), City(
            R.string.nuseirat,
            R.drawable.hebron,
            Section.GAZA,
            R.string.nuseirat_pop,
            R.string.nuseirat_area,
            R.string.nuseirat_description
        ), City(
            R.string.deir_al_balah,
            R.drawable.hebron,
            Section.GAZA,
            R.string.deir_al_balah_pop,
            R.string.deir_al_balah_area,
            R.string.deir_al_balah_description
        ), City(
            R.string.rahat,
            R.drawable.hebron,
            Section.AL_NAQAB,
            R.string.rahat_pop,
            R.string.rahat_area,
            R.string.rahat_description
        )
    )

    val defaultCity = City(
        cityName = R.string.jerusalem, section = Section.WEST_BANK
    )
}

enum class Section {
    MAP, WEST_BANK, GAZA, AL_NAQAB
}