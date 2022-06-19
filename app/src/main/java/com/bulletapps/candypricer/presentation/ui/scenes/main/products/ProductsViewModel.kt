package com.bulletapps.candypricer.presentation.ui.scenes.main.products

import androidx.lifecycle.ViewModel
import com.bulletapps.candypricer.data.model.Product
import com.bulletapps.candypricer.data.model.Supply
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor() : ViewModel() {

    val productsList: MutableStateFlow<List<Product>> = MutableStateFlow(
        listOf(
            Product(
                id = "",
                name = "Brigadeiro",
                price = "R$ 5,00",
                quantity = 1.0,
                unitType = "Unidade",
                componentIds = listOf()
            ),
            Product(
                id = "",
                name = "Brigadeiro",
                price = "R$ 5,00",
                quantity = 1.0,
                unitType = "Unidade",
                componentIds = listOf()
            ),
            Product(
                id = "",
                name = "Brigadeiro",
                price = "R$ 5,00",
                quantity = 1.0,
                unitType = "Unidade",
                componentIds = listOf()
            )
        ),
    )
}
