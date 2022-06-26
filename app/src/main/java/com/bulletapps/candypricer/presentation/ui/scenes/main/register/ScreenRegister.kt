package com.bulletapps.candypricer.presentation.ui.scenes.main.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bulletapps.candypricer.R
import com.bulletapps.candypricer.presentation.ui.scenes.main.MainViewModel
import com.bulletapps.candypricer.presentation.ui.scenes.main.register.RegisterViewModel.*
import com.bulletapps.candypricer.presentation.ui.scenes.main.register.RegisterViewModel.ScreenActions.OnClickConfirm
import com.bulletapps.candypricer.presentation.ui.scenes.main.register.RegisterViewModel.ScreenActions.OnTextChanged
import com.bulletapps.candypricer.presentation.ui.theme.CandyPricerTheme
import com.bulletapps.candypricer.presentation.ui.widgets.LogoWithText
import com.bulletapps.candypricer.presentation.ui.widgets.NormalButton

@Composable
fun ScreenRegister(
    viewModel: RegisterViewModel = hiltViewModel(),
    sharedViewModel: MainViewModel
) {
    Screen(viewModel.uiState, viewModel::onAction)
}

@Composable
private fun Screen(
    uiState: UIState,
    onAction: (ScreenActions) -> Unit,
) {
    CandyPricerTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(64.dp))

            LogoWithText(text = stringResource(R.string.do_sign_in))

            Spacer(Modifier.height(32.dp))

            MakeFieldName(onAction, uiState)

            Spacer(Modifier.height(4.dp))

            MakeFieldEmail(onAction, uiState)

            Spacer(Modifier.height(4.dp))

            MakeFieldPhone(onAction, uiState)

            Spacer(Modifier.height(4.dp))

            MakeFieldPassword(onAction, uiState)

            Spacer(Modifier.height(4.dp))

            MakeFieldConfirmPassword(onAction, uiState)

            NormalButton(
                text = stringResource(R.string.confirm),
                onClick = { onAction(OnClickConfirm) }
            )

        }
    }
}

@Composable
private fun MakeFieldName(onAction: (ScreenActions) -> Unit, uiState: UIState) {
    val name by uiState.name.collectAsState()

    OutlinedTextField(
        value = name,
        singleLine = true,
        onValueChange = { onAction(OnTextChanged(FieldsTexts.Name(it))) },
        label = { Text(stringResource(R.string.name)) },
        modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
    )
}

@Composable
private fun MakeFieldEmail(onAction: (ScreenActions) -> Unit, uiState: UIState) {
    val email by uiState.email.collectAsState()

    OutlinedTextField(
        value = email,
        singleLine = true,
        onValueChange = { onAction(OnTextChanged(FieldsTexts.Email(it))) },
        label = { Text(stringResource(R.string.email)) },
        modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
    )
}

@Composable
private fun MakeFieldPhone(onAction: (ScreenActions) -> Unit, uiState: UIState) {
    val phone by uiState.phone.collectAsState()

    OutlinedTextField(
        value = phone,
        singleLine = true,
        onValueChange = { onAction(OnTextChanged(FieldsTexts.Phone(it))) },
        placeholder = { Text(stringResource(R.string.phone_placeholder)) },
        label = { Text(stringResource(R.string.phone_whatsapp)) },
        modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
    )
}

@Composable
private fun MakeFieldPassword(onAction: (ScreenActions) -> Unit, uiState: UIState) {
    val password by uiState.password.collectAsState()

    OutlinedTextField(
        value = password,
        singleLine = true,
        onValueChange = { onAction(OnTextChanged(FieldsTexts.Password(it))) },
        label = { Text(stringResource(R.string.password)) },
        modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
    )
}

@Composable
private fun MakeFieldConfirmPassword(onAction: (ScreenActions) -> Unit, uiState: UIState) {
    val confirmPassword by uiState.confirmPassword.collectAsState()

    OutlinedTextField(
        value = confirmPassword,
        singleLine = true,
        onValueChange = { onAction(OnTextChanged(FieldsTexts.ConfirmPassword(it))) },
        label = { Text(stringResource(R.string.repeat_password)) },
        modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Screen(
        onAction = {},
        uiState = UIState()
    )
}