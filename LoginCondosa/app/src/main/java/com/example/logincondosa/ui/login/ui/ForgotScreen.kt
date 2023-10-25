package com.example.logincondosa.ui.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.logincondosa.R
import com.example.logincondosa.ui.theme.LoginCondosaTheme

@Composable
fun ForgotScreen(viewModel: ForgotViewModel) {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.background_base),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
        Forgot(
            Modifier
                .align(Alignment.Center)
                .width(350.dp)
                .background(Color.White)
                .padding(50.dp)
            ,viewModel
        )
    }
}

@Composable
fun Forgot(modifier: Modifier, viewModel: ForgotViewModel) {

    val correo: String by viewModel.correo.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val navController = rememberNavController()

    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        CorreoField(correo, {viewModel.onLoginChanged(it, password)})
        Spacer(modifier = Modifier.padding(16.dp))
        PasswordField(password, {viewModel.onLoginChanged(correo, it)})
        Spacer(modifier = Modifier.padding(8.dp))
        ForgotPassword(Modifier.align(Alignment.End),
            navController = navController)
        Spacer(modifier = Modifier.padding(16.dp))
        LoginButton(loginEnable){viewModel.onLoginSelected()}
        Spacer(modifier = Modifier.padding(20.dp))
        RegisterText(Modifier.align(Alignment.CenterHorizontally))
    }
}


@Preview(showBackground = true)
@Composable
fun ForgotScreenPreview() {
    val viewModel = ForgotViewModel() // Asegúrate de tener una instancia válida de tu ViewModel

    // Utiliza la función LoginScreen en la vista previa con el modificador Modifier.fillMaxSize()
    LoginCondosaTheme {
        ForgotScreen(
            viewModel = viewModel,
        )
    }
}
