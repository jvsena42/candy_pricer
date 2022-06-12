package com.bulletapps.candypricer.presentation.ui.scenes.main.addSupply

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bulletapps.candypricer.R
import com.bulletapps.candypricer.presentation.ui.scenes.main.MainViewModel
import com.bulletapps.candypricer.presentation.ui.theme.CandyPricerTheme
import com.bulletapps.candypricer.presentation.ui.widgets.NormalButton
import com.bulletapps.candypricer.presentation.util.CustomArrangement

@Composable
fun ScreenAddSupply(
    viewModel: AddSupplyViewModel = hiltViewModel(),
    sharedViewModel: MainViewModel
) {
    Screen(viewModel::addProduct)
}

@Composable
fun Screen(onClick : () -> Unit) {
    CandyPricerTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background),
            verticalArrangement = CustomArrangement.spacedBy(8.dp)
        ) {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.add_supply)
                    )
                },
            )

            Spacer(Modifier.padding(8.dp))

            OutlinedTextField(
                value = "",
                onValueChange = { },
                placeholder = { Text(stringResource(R.string.cocoa_powder)) },
                label = { Text(stringResource(R.string.name)) },
                modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
            )

            OutlinedTextField(
                value = "",
                onValueChange = { },
                placeholder = { Text(stringResource(R.string.five_hundred)) },
                label = { Text(stringResource(R.string.quantity)) },
                modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
            )

            OutlinedTextField(
                value = "",
                onValueChange = { },
                placeholder = { Text(stringResource(R.string.cocoa_powder)) },
                label = { Text(stringResource(R.string.thirty_reals)) },
                modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
            )

            NormalButton(text = stringResource(R.string.confirm), onClick = onClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Screen(onClick = {})
}