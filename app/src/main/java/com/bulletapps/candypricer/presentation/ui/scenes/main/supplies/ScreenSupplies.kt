@file:OptIn(ExperimentalFoundationApi::class)

package com.bulletapps.candypricer.presentation.ui.scenes.main.supplies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bulletapps.candypricer.R
import com.bulletapps.candypricer.domain.model.MenuModel
import com.bulletapps.candypricer.presentation.ui.theme.CandyPricerTheme
import com.bulletapps.candypricer.presentation.ui.widgets.MenuItem
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ScreenMenu(
    viewModel: SuppliesViewModel = hiltViewModel()
) {
//    Screen(viewModel.menuItems)
}

@Composable
fun Screen(
    menuState: MutableStateFlow<List<MenuModel>>
) {
    val items = menuState.collectAsState()
    CandyPricerTheme {
        Column (
            modifier = Modifier.fillMaxSize(),
        ) {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.main_menu)
                    )
                },
            )
            MenuGrid(items.value)
        }
    }
}

@Composable
fun MenuGrid(menuItems: List<MenuModel>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(top = 32.dp),
        content = {
            items(menuItems.size) { index ->
                val item = menuItems[index]
                MenuItem(item) {

                }
            }
        }
    )
}