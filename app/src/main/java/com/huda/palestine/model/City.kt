package com.huda.palestine.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.huda.palestine.data.local.Section

data class City(
    @StringRes val cityName: Int,
    @DrawableRes val cityImage: Int = -1,
    val section: Section = Section.MAP,
    @StringRes val population: Int = -1,
    @StringRes val area: Int = -1,
    @StringRes val description: Int = -1
)