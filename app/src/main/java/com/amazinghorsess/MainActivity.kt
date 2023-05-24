package com.amazinghorsess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.amazinghorsess.feature_note.presentation.notes.NotesScreen
import com.amazinghorsess.utils.theme.CleanProjectTheme
import com.amazinghorsess.utils.theme.DarkSurfaceColor
import com.amazinghorsess.utils.theme.LightSurfaceColor


import com.amazinghorsess.utils.theme.pastelBlue
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CleanProjectTheme {
                // A surface container using the 'background' color from the theme
                val systemUiController = rememberSystemUiController()
                val darkTheme = isSystemInDarkTheme()
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = if (darkTheme) DarkSurfaceColor else LightSurfaceColor
                    )
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    Column {


                        NotesScreen()
                    }

                }
            }
        }
    }
}

