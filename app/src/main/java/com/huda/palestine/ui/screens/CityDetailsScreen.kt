package com.huda.palestine.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.huda.palestine.data.local.LocalCitiesDataProvider
import com.huda.palestine.ui.AppUiState
import com.huda.palestine.ui.theme.Shapes

@Composable
fun CityDetailsScreen(
    cityUiState: AppUiState, onBackPressed: () -> Unit, modifier: Modifier = Modifier
) {
    BackHandler {
        onBackPressed()
    }
    val scrollState = rememberScrollState()

    Column(modifier = modifier.verticalScroll(state = scrollState)) {
        Image(
            painter = painterResource(cityUiState.currentSelectedCity.cityImage),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 8.dp, 8.dp, 0.dp)
                .clip(Shapes.large)
        )
        Text(
            text = stringResource(cityUiState.currentSelectedCity.cityName),
            style = MaterialTheme.typography.displaySmall,
            color = Color.Black,
            modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 0.dp)
        )

        Column {
            Row {
                Text(
                    text = "Population: ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp, 8.dp, 0.dp, 4.dp),

                    )

                Text(
                    text = stringResource(cityUiState.currentSelectedCity.population),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    modifier = Modifier.padding(0.dp, 10.dp, 8.dp, 4.dp)
                )
            }

            Row {
                Text(
                    text = "Area: ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 8.dp)
                )

                Text(
                    text = stringResource(cityUiState.currentSelectedCity.area),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    modifier = Modifier.padding(0.dp, 2.dp, 8.dp, 8.dp)
                )
            }

            Text(
                text = stringResource(LocalCitiesDataProvider.defaultCity.description),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp)
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsPreview() {
    Column {
        Image(
            painter = painterResource(LocalCitiesDataProvider.defaultCity.cityImage),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 8.dp, 8.dp, 0.dp)
                .clip(Shapes.large)
        )
        Text(
            text = stringResource(LocalCitiesDataProvider.defaultCity.cityName),
            style = MaterialTheme.typography.displaySmall,
            color = Color.Black,
            modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 0.dp)
        )

        Column {
            Row {
                Text(
                    text = "Population: ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp, 8.dp, 0.dp, 4.dp),

                    )

                Text(
                    text = stringResource(LocalCitiesDataProvider.defaultCity.population),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    modifier = Modifier.padding(0.dp, 10.dp, 8.dp, 4.dp)
                )
            }

            Row {
                Text(
                    text = "Area: ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 8.dp)
                )

                Text(
                    text = stringResource(LocalCitiesDataProvider.defaultCity.area),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    modifier = Modifier.padding(0.dp, 2.dp, 8.dp, 8.dp)
                )
            }

            Text(
                text = stringResource(LocalCitiesDataProvider.defaultCity.description),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp)
            )

        }
    }

}