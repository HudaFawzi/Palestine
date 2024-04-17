package com.huda.palestine.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.huda.palestine.R
import com.huda.palestine.data.Section
import com.huda.palestine.model.City
import com.huda.palestine.ui.AppUiState

@Composable
fun CityListOnlyAndMapContent(
    cityUiState: AppUiState, onCityCardPressed: (City) -> Unit, modifier: Modifier = Modifier
) {
    if (cityUiState.currentSection != Section.MAP) {
        // Show ListOnlyScreen
        val cities = cityUiState.currentSectionCities
        LazyColumn(
            modifier = modifier.padding(
                horizontal = dimensionResource(R.dimen.list_only_horizontal_padding)
            ),
            contentPadding = PaddingValues(0.dp, 8.dp),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.list_item_vertical_spacing)),

            ) {
            items(cities, key = { city -> city.cityName }) { city ->
                CityListItem(
                    city = city,
                    selected = false,
                    onCardClick = { onCityCardPressed(city) })
            }
        }
    } else {
        // Show MapScreen
        var scale by remember { mutableFloatStateOf(1f) }
        var rotation by remember { mutableFloatStateOf(0f) }
        var offset by remember { mutableStateOf(Offset.Zero) }
        val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
            scale *= zoomChange
            rotation += rotationChange
            offset += offsetChange
        }
        Column(modifier = modifier) {
            Image(
                painter = painterResource(id = R.drawable.palestine_full),
                contentDescription = stringResource(R.string.palestine_map),
                modifier = Modifier
                    .graphicsLayer(
                        scaleX = scale,
                        scaleY = scale,
                        rotationZ = rotation,
                        translationX = offset.x,
                        translationY = offset.y
                    )
                    .fillMaxSize()
                    // add transformable to listen to multitouch transformation events
                    // after offset
                    .transformable(state = state),
                contentScale = ContentScale.FillHeight
            )
        }
    }
}

@Composable
private fun CityListItem(
    city: City, selected: Boolean, onCardClick: () -> Unit, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier, colors = CardDefaults.cardColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primaryContainer
            else MaterialTheme.colorScheme.secondaryContainer
        ), onClick = onCardClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            CityListImageItem(
                city = city, modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )

            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .fillMaxSize()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = stringResource(city.cityName),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space)),
                )
                Text(
                    text = stringResource(R.string.pop) + stringResource(city.population),
                    style = MaterialTheme.typography.bodySmall,
                )
                Text(
                    text = stringResource(city.area),
                    style = MaterialTheme.typography.bodySmall,
                )
            }

        }
    }
}

@Composable
private fun CityListImageItem(city: City, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(city.cityImage),
            contentDescription = stringResource(id = R.string.city_image),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(
                RoundedCornerShape(
                    topEnd = 0.dp, topStart = 16.dp, bottomEnd = 0.dp, bottomStart = 16.dp
                )
            )

        )
    }
}