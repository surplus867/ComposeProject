package com.example.composeProject.navigation.destination

/*
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composeProject.ui.screens.splash.SplashScreen
import com.example.composeProject.util.Constants


fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = Constants.SPLASH_SCREEN,
    ) {
        AnimatedSplashScreen(navigateToListScreen = navigateToListScreen)
    }
}
@Composable
fun AnimatedSplashScreen(navigateToListScreen: () -> Unit) {
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(),
        exit = slideOutVertically(targetOffsetY = { it }) + fadeOut(animationSpec = TweenSpec(durationMillis = 300))
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}*/
