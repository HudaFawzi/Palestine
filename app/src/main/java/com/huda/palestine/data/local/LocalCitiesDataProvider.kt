package com.huda.palestine.data.local

import com.huda.palestine.R
import com.huda.palestine.data.Section
import com.huda.palestine.model.City

object LocalCitiesDataProvider {
    val allCities = listOf(
        City(
            R.string.jerusalem,
            R.drawable.jerusalem,
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
            R.drawable.jericho,
            Section.WEST_BANK,
            R.string.jericho_pop,
            R.string.jericho_area,
            R.string.jericho_description
        ), City(
            R.string.nablus,
            R.drawable.nablus,
            Section.WEST_BANK,
            R.string.nablus_pop,
            R.string.nablus_area,
            R.string.nablus_description
        ), City(
            R.string.ramallah,
            R.drawable.ramallah,
            Section.WEST_BANK,
            R.string.ramallah_pop,
            R.string.ramallah_area,
            R.string.ramallah_description
        ), City(
            R.string.bethlehem,
            R.drawable.bethlehem,
            Section.WEST_BANK,
            R.string.bethlehem_pop,
            R.string.bethlehem_area,
            R.string.bethlehem_description
        ), City(
            R.string.tulkarm,
            R.drawable.tulkarm,
            Section.WEST_BANK,
            R.string.tulkarm_pop,
            R.string.tulkarm_area,
            R.string.tulkarm_description
        ), City(
            R.string.jenin,
            R.drawable.jenin,
            Section.WEST_BANK,
            R.string.jenin_pop,
            R.string.jenin_area,
            R.string.jenin_description
        ), City(
            R.string.al_bireh,
            R.drawable.al_bireh,
            Section.WEST_BANK,
            R.string.al_bireh_pop,
            R.string.al_bireh_area,
            R.string.al_bireh_description
        ),

        City(
            R.string.beit_jala,
            R.drawable.beit_jala,
            Section.WEST_BANK,
            R.string.beit_jala_pop,
            R.string.beit_jala_area,
            R.string.beit_jala_description
        ),

        City(
            R.string.beit_sahour,
            R.drawable.beit_sahour,
            Section.WEST_BANK,
            R.string.beit_sahour_pop,
            R.string.beit_sahour_area,
            R.string.beit_sahour_description
        ),

        City(
            R.string.sabastia,
            R.drawable.sabastia,
            Section.WEST_BANK,
            R.string.sabastia_pop,
            R.string.sabastia_area,
            R.string.sabastia_description
        ),

        City(
            R.string.haifa,
            R.drawable.haifa,
            Section.WEST_BANK,
            R.string.haifa_pop,
            R.string.haifa_area,
            R.string.haifa_description
        ),

        City(
            R.string.jaffa,
            R.drawable.jaffa,
            Section.WEST_BANK,
            R.string.jaffa_pop,
            R.string.jaffa_area,
            R.string.jaffa_description
        ),

        City(
            R.string.safed,
            R.drawable.safed,
            Section.WEST_BANK,
            R.string.safed_pop,
            R.string.safed_area,
            R.string.safed_description
        ),

        City(
            R.string.tubas,
            R.drawable.tubas,
            Section.WEST_BANK,
            R.string.tubas_pop,
            R.string.tubas_area,
            R.string.tubas_description
        ),

        City(
            R.string.qalqilya,
            R.drawable.qalqilya,
            Section.WEST_BANK,
            R.string.qalqilya_pop,
            R.string.qalqilya_area,
            R.string.qalqilya_description
        ),

        City(
            R.string.salfit,
            R.drawable.salfit,
            Section.WEST_BANK,
            R.string.salfit_pop,
            R.string.salfit_area,
            R.string.salfit_description
        ),

        City(
            R.string.attil,
            R.drawable.attil,
            Section.WEST_BANK,
            R.string.attil_pop,
            R.string.attil_area,
            R.string.attil_description
        ),

        City(
            R.string.yatta,
            R.drawable.yatta,
            Section.WEST_BANK,
            R.string.yatta_pop,
            R.string.yatta_area,
            R.string.yatta_description
        ),


        City(
            R.string.khan_yunis,
            R.drawable.khan_yunis,
            Section.GAZA,
            R.string.khan_yunis_pop,
            R.string.khan_yunis_area,
            R.string.khan_yunis_description
        ), City(
            R.string.rafah,
            R.drawable.rafah,
            Section.GAZA,
            R.string.rafah_pop,
            R.string.rafah_area,
            R.string.rafah_description
        ), City(
            R.string.nuseirat,
            R.drawable.nuseirat,
            Section.GAZA,
            R.string.nuseirat_pop,
            R.string.nuseirat_area,
            R.string.nuseirat_description
        ), City(
            R.string.deir_al_balah,
            R.drawable.deir_al_balah,
            Section.GAZA,
            R.string.deir_al_balah_pop,
            R.string.deir_al_balah_area,
            R.string.deir_al_balah_description
        ),

        City(
            R.string.north_gaza,
            R.drawable.north_gaza,
            Section.GAZA,
            R.string.north_gaza_pop,
            R.string.north_gaza_area,
            R.string.north_gaza_description
        ),

        City(
            R.string.rahat,
            R.drawable.rahat,
            Section.AL_NAQAB,
            R.string.rahat_pop,
            R.string.rahat_area,
            R.string.rahat_description
        )
    )

    val defaultCity = City(
        R.string.hebron,
        R.drawable.hebron,
        Section.WEST_BANK,
        R.string.hebron_pop,
        R.string.hebron_area,
        R.string.hebron_description
    )
}