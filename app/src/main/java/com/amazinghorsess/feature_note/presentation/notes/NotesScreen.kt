package com.amazinghorsess.feature_note.presentation.notes

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.amazinghorsess.R
import com.amazinghorsess.feature_note.presentation.notes.components.NoteItem
import com.amazinghorsess.feature_note.presentation.notes.components.OrderSelection
import com.amazinghorsess.utils.theme.buttonColor
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NotesScreen(

    viewmodel: NotesViewModel = hiltViewModel(),
){
    val state = viewmodel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
            },
            backgroundColor = buttonColor) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon button" )
            }
        },
        scaffoldState = scaffoldState,


    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "My Notes",
                    style = MaterialTheme.typography.h2

                )
                IconButton(onClick = { /*TODO*/ }) {
                    viewmodel.onEvent(NotesEvent.ToggleOrderSection)

                    Icon(painter = painterResource(id = R.drawable.sort), contentDescription = "Sort IconButon for show/hide sort menu")


                }

            }

        }
        AnimatedVisibility(
            visible = state.isOrderSectionVisible,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        )  {
            OrderSelection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                noteOrder = state.notesOrder,
            onOrderChange = {
                viewmodel.onEvent(NotesEvent.Order(it))
            })
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),

        ){
            items(state.notes){ note ->
                NoteItem(
                    note = note,
                    modifier = Modifier
                        .clickable {

                        },
                    onDeleteClick = {
                        viewmodel.onEvent(NotesEvent.DeleteNote(note))
                        scope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                message = "Note deleted",
                                actionLabel = "Undo"
                            )
                            if (result == SnackbarResult.ActionPerformed) {
                                viewmodel.onEvent(NotesEvent.RestoreNote)
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))



            }
        }


    }



}