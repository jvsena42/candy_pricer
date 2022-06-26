package com.bulletapps.candypricer.presentation.ui.scenes.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bulletapps.candypricer.presentation.ui.scenes.main.addProduct.ScreenAddProduct
import com.bulletapps.candypricer.presentation.ui.scenes.main.addSupply.ScreenAddSupply
import com.bulletapps.candypricer.presentation.ui.scenes.main.login.ScreenLogin
import com.bulletapps.candypricer.presentation.ui.scenes.main.menu.ScreenMenu
import com.bulletapps.candypricer.presentation.ui.scenes.main.products.ScreenProducs
import com.bulletapps.candypricer.presentation.ui.scenes.main.register.ScreenRegister
import com.bulletapps.candypricer.presentation.ui.scenes.main.settings.ScreenSettings
import com.bulletapps.candypricer.presentation.ui.scenes.main.supplies.ScreenSupplies
import com.bulletapps.candypricer.presentation.util.setNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val sharedViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setNavigation(
                startDestination = MainViewModel.Navigation.Login.router,
                navGraphBuilder = ::navigationBuilder,
                navEventFlow = sharedViewModel.eventFlow,
                navEvent = ::navEvent
            )
        }
    }

    private fun navigationBuilder(builder: NavGraphBuilder) = builder.apply {
        composable(MainViewModel.Navigation.MainMenu.router) {
            ScreenMenu(sharedViewModel = sharedViewModel)
        } 
        composable(MainViewModel.Navigation.Login.router) {
            ScreenLogin(sharedViewModel = sharedViewModel)
        }
        composable(MainViewModel.Navigation.Register.router) {
            ScreenRegister(sharedViewModel = sharedViewModel)
        }
        composable(MainViewModel.Navigation.Supplies.router) {
            ScreenSupplies(sharedViewModel = sharedViewModel)
        }
        composable(MainViewModel.Navigation.AddSupply.router) {
            ScreenAddSupply(sharedViewModel = sharedViewModel)
        }
        composable(MainViewModel.Navigation.Products.router) {
            ScreenProducs(sharedViewModel = sharedViewModel)
        }
        composable(MainViewModel.Navigation.AddProduct.router) {
            ScreenAddProduct(sharedViewModel = sharedViewModel)
        }
        composable(MainViewModel.Navigation.Settings.router) {
            ScreenSettings(sharedViewModel = sharedViewModel)
        }
    }

    private fun navEvent(navController: NavController, navScreen: MainViewModel.Navigation) {
        navController.navigate(route = navScreen.router)
    }
}