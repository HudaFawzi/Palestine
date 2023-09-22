package com.huda.palestine.ui.screens

import android.app.Activity
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import com.huda.palestine.R
import com.huda.palestine.model.City
import com.huda.palestine.ui.AppUiState

@Composable
fun ListAndDetailContent(
    cityUiState: AppUiState, onCityCardPressed: (City) -> Unit, modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        CityListOnlyContent(
            cityUiState = cityUiState,
            onCityCardPressed = onCityCardPressed,
            modifier = Modifier
                .weight(1f)
                .padding(
                    horizontal = dimensionResource(R.dimen.list_only_horizontal_padding)
                )
        )
        val activity = LocalContext.current as Activity
        CityDetailsScreen(
            cityUiState = cityUiState, onBackPressed = {
                activity.finish()
            }, modifier = modifier
        )
    }
}