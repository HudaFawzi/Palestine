package com.huda.palestine.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.huda.palestine.R
import com.huda.palestine.data.Section
import com.huda.palestine.model.City
import com.huda.palestine.ui.AppUiState

@Composable
fun CityListOnlyContent(
    cityUiState: AppUiState, onCityCardPressed: (City) -> Unit, modifier: Modifier = Modifier
) {

    if (cityUiState.currentSection != Section.MAP) {
        val cities = cityUiState.currentSectionCities
        LazyColumn(
            modifier = modifier, verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.list_item_vertical_spacing)
            )
        ) {
            items(cities, key = { city -> city.cityName }) { city ->
                CityListItem(
                    city = city,
                    selected = false,
                    onCardClick = { onCityCardPressed(city) })
            }
        }
    } else {
        Row {
            MapContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(city.cityName),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
                Row {
                    Text(
                        text = "Population: ",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.secondary,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 3
                    )
                    Text(
                        text = stringResource(city.population),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.secondary,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 3
                    )

                }

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
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )
    }
}