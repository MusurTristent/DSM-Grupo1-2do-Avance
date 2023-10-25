package com.example.logincondosa.ui.login.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.logincondosa.R
import com.example.logincondosa.ui.theme.LoginCondosaTheme

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.background_base),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
        Login(
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
fun Login(modifier: Modifier, viewModel: LoginViewModel) {

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

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_condosa),
        contentDescription = "Logo Condosa",
        modifier = modifier
            .fillMaxWidth() // Ajusta el ancho al máximo
            .aspectRatio(4f / 1f) // Aspecto 4:1
            .padding(2.dp) // Agrega espacio alrededor de la imagen
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CorreoField(correo: String, ontextFieldChanged: (String) -> Unit) {
    TextField(
        value = correo,
        onValueChange = { ontextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),
        placeholder = { Text(text = "Correo Electrónico...") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF858585),
            focusedIndicatorColor = Color.Transparent, // Borde enfocado transparente
            unfocusedIndicatorColor = Color.Transparent // Borde no enfocado transparente
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, ontextFieldChanged: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = { ontextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),
        placeholder = { Text(text = "Contraseña...") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF858585),
            focusedIndicatorColor = Color.Transparent, // Borde enfocado transparente
            unfocusedIndicatorColor = Color.Transparent // Borde no enfocado transparente
        )
    )
}

@Composable
fun ForgotPassword(modifier: Modifier, navController: NavHostController) {
    Text(
        text = "¿Olvidaste la contraseña?",
        modifier = modifier.clickable {
            navController.navigate("forgotScreen") // Reemplaza "forgotScreen" con el ID de la ruta de navegación correspondiente
        },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        color = Color(0xFF3443C5)
    )
}


@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = {onLoginSelected()},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF085394)
        ), enabled = loginEnable
    ) {
        Text(
            text = "Iniciar Sesión",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun RegisterText(modifier: Modifier) {
    Text(
        text = "¿Eres nuevo? Regístrate aquí",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        color = Color(0xFF3443C5)
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val viewModel = LoginViewModel() // Asegúrate de tener una instancia válida de tu ViewModel

    // Utiliza la función LoginScreen en la vista previa con el modificador Modifier.fillMaxSize()
    LoginCondosaTheme {
        LoginScreen(
            viewModel = viewModel,
        )
    }
}
