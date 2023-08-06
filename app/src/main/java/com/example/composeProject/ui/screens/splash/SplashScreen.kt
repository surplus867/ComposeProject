package com.example.composeProject.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeProject.ui.theme.LOGO_HEIGHT
import com.example.composeProject.ui.theme.ToDoComposeTheme
import com.example.composeProject.ui.theme.splashScreenBackground
import com.example.myfirstandroidproject.R

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.splashScreenBackground),
        contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .size(LOGO_HEIGHT),
                painter = painterResource(id = getLogo()),
                contentDescription = stringResource(id = R.string.to_do_logo)
            )
    }
}

@Composable
fun getLogo(): Int {
    return if(isSystemInDarkTheme()){
        R.drawable.ic_logo_dark
    } else {
        R.drawable.ic_logo_light
    }
}

@Composable
@Preview
private fun SplashScreenPreview() {
    SplashScreen()
}