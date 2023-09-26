package com.huda.palestine.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.huda.palestine.R
import com.huda.palestine.data.Section
import com.huda.palestine.model.City
import com.huda.palestine.ui.AppUiState
import com.huda.palestine.ui.utils.ContentType
import com.huda.palestine.ui.utils.NavigationType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigationType: NavigationType,
    contentType: ContentType,
    uiState: AppUiState,
    onTabPressed: (Section) -> Unit,
    onCityCardPressed: (City) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            section = Section.MAP,
            icon = ImageVector.vectorResource(id = R.drawable.baseline_map_24),
            text = stringResource(id = R.string.palestine_map)
        ), NavigationItemContent(
            section = Section.WEST_BANK,
            icon = Icons.Default.Place,
            text = stringResource(id = R.string.west_bank)
        ), NavigationItemContent(
            section = Section.GAZA,
            icon = Icons.Default.Place,
            text = stringResource(id = R.string.gaza)
        ), NavigationItemContent(
            section = Section.AL_NAQAB,
            icon = Icons.Default.Place,
            text = stringResource(id = R.string.al_naqab)
        )
    )

    if (navigationType == NavigationType.PERMANENT_NAVIGATION_DRAWER) {
        val navigationDrawerContentDescription = stringResource(R.string.navigation_drawer)
        PermanentNavigationDrawer(drawerContent = {
            PermanentDrawerSheet(Modifier.width(dimensionResource(id = R.dimen.drawer_width))) {
                NavigationDrawerContent(
                    selectedDestination = uiState.currentSection,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.inverseOnSurface)
                        .padding(dimensionResource(id = R.dimen.drawer_padding_content))
                        .testTag(navigationDrawerContentDescription)
                )
            }
        }) {
            AppContent(
                navigationType = navigationType,
                contentType = contentType,
                uiState = uiState,
                onTabPressed = onTabPressed,
                onCityCardPressed = onCityCardPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier
            )
        }
    } else {
        if (uiState.isShowingHomePage) {
            AppContent(
                navigationType = navigationType,
                contentType = contentType,
                uiState = uiState,
                onTabPressed = onTabPressed,
                onCityCardPressed = onCityCardPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier
            )
        } else {
            CityDetailsScreen(
                cityUiState = uiState,
                onBackPressed = onDetailScreenBackPressed,
                modifier = modifier
            )
        }
    }

}

@Composable
private fun AppContent(
    navigationType: NavigationType,
    contentType: ContentType,
    uiState: AppUiState,
    onTabPressed: ((Section) -> Unit),
    onCityCardPressed: (City) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Row(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(visible = navigationType == NavigationType.NAVIGATION_RAIL) {
                val navigationRailContentDescription = stringResource(R.string.navigation_rail)
                CityNavigationRail(
                    currentTab = uiState.currentSection,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier.testTag(navigationRailContentDescription)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
            ) {
                if (contentType == ContentType.LIST_AND_DETAIL) {
                    ListAndDetailContent(
                        cityUiState = uiState,
                        onCityCardPressed = onCityCardPressed,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    CityListOnlyAndMapContent(
                        cityUiState = uiState,
                        onCityCardPressed = onCityCardPressed,
                        modifier = Modifier.weight(1f)

                    )

                }

                AnimatedVisibility(
                    visible = navigationType == NavigationType.BOTTOM_NAVIGATION
                ) {
                    val bottomNavigationContentDescription =
                        stringResource(id = R.string.navigation_bottom)
                    AppBottomNavigationBar(
                        currentTab = uiState.currentSection,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth()
                            .testTag(bottomNavigationContentDescription)
                    )
                }
            }
        }
    }
}

@Composable
private fun AppBottomNavigationBar(
    currentTab: Section,
    onTabPressed: ((Section) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(selected = currentTab == navItem.section,
                onClick = { onTabPressed(navItem.section) },
                icon = {
                    Icon(
                        imageVector = navItem.icon, contentDescription = navItem.text
                    )
                })
        }
    }
}

@Composable
private fun CityNavigationRail(
    currentTab: Section,
    onTabPressed: ((Section) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(selected = currentTab == navItem.section,
                onClick = { onTabPressed(navItem.section) },
                icon = {
                    Icon(
                        imageVector = navItem.icon, contentDescription = navItem.text
                    )
                })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NavigationDrawerContent(
    selectedDestination: Section,
    onTabPressed: ((Section) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(selected = selectedDestination == navItem.section, label = {
                Text(
                    text = navItem.text,
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.drawer_padding_header))
                )
            }, icon = {
                Icon(
                    imageVector = navItem.icon, contentDescription = navItem.text
                )
            }, colors = NavigationDrawerItemDefaults.colors(
                unselectedContainerColor = Color.Transparent
            ), onClick = { onTabPressed(navItem.section) })
        }
    }
}


private data class NavigationItemContent(
    val section: Section, val icon: ImageVector, val text: String
)