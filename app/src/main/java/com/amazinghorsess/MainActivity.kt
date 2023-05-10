package com.amazinghorsess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.amazinghorsess.feature_note.presentation.notes.NotesScreen
import com.amazinghorsess.feature_note.presentation.notes.components.OrderSelection
import com.amazinghorsess.utils.NoteOrder
import com.amazinghorsess.utils.OrderType
import com.amazinghorsess.utils.theme.CleanProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NotesScreen()
                }
            }
        }
    }
}

