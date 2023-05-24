package com.amazinghorsess.feature_note.presentation.notes

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Divider
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amazinghorsess.R
import com.amazinghorsess.feature_note.presentation.notes.components.GridNoteItem
import com.amazinghorsess.feature_note.presentation.notes.components.ListNotesItem
import com.amazinghorsess.feature_note.presentation.notes.components.OrderSelection
import com.amazinghorsess.feature_note.presentation.notes.components.ToggleIconButton
import com.amazinghorsess.utils.theme.Shapes
import com.amazinghorsess.utils.theme.accentCenter

import com.amazinghorsess.utils.theme.accentLeft
import com.amazinghorsess.utils.theme.accentRight

@OptIn(ExperimentalTextApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NotesScreen(

    viewModel: NotesViewModel = hiltViewModel(),
){  val context = LocalContext.current
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val segoeBold = FontFamily(Font(R.font.segoebold))
    val darkTheme = isSystemInDarkTheme()
    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .size(64.dp),
                shape = CircleShape,
                onClick = {
                    TODO()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
            }

        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true,
        topBar = {
                 TopAppBar(
                     backgroundColor = MaterialTheme.colors.surface,
                 ) {

                         Text(

                             text = buildAnnotatedString {
                                 withStyle(
                                     SpanStyle(
                                         color = MaterialTheme.colors.primary,
                                         fontSize = 26.sp,
                                         fontFamily = segoeBold

                                     )
                                 ) {
                                     append("My")
                                 }
                                 withStyle(
                                     SpanStyle(
                                         brush = Brush.linearGradient(

                                             colors = listOf(
                                                 accentLeft,
                                                 accentCenter,
                                                 accentRight
                                             ),
                                             // Конец градиента - середина высоты последней буквы

                                         ),
                                         fontSize = 26.sp,
                                         fontFamily = segoeBold
                                     )
                                 ) {
                                     append(" Notes")
                                 }

                             }
                         )
                         Spacer(modifier = Modifier.padding(horizontal = 18.dp))

                         ToggleIconButton(
                             onClick = {
                                 viewModel.onEvent(NotesEvent.ToggleListView)
                                 viewModel.onEvent(NotesEvent.ToggleButton) },
                             icon = {
                                 Icon(
                                     painter = painterResource(R.drawable.list),
                                     contentDescription = "Sort",
                                     tint = MaterialTheme.colors.primary,
                                     modifier = Modifier.size(32.dp)
                                 )

                             },
                             alternativeIcon = {
                                 Icon(
                                     painter = painterResource(R.drawable.grid),
                                     contentDescription = "Sort",
                                     tint = MaterialTheme.colors.primary,
                                     modifier = Modifier.size(32.dp)
                                 )


                             }

                         )
                         Spacer(modifier = Modifier.padding(start = 18.dp))





                         IconButton(

                             onClick = {
                                 viewModel.onEvent(NotesEvent.ToggleOrderSection)
                             }) {
                             Icon(
                                 painter = painterResource(R.drawable.sort),
                                 contentDescription = "Sort",
                                 tint = MaterialTheme.colors.primary,
                                 modifier = Modifier.size(32.dp)
                             )

                         }

                         Spacer(modifier = Modifier.padding(horizontal = 26.dp))

                         IconButton(

                             onClick = {
                                 /*TODO*/
                             }) {
                             Icon(
                                 painter = painterResource(R.drawable.settings),
                                 contentDescription = "Sort",
                                 tint = MaterialTheme.colors.primary,
                                 modifier = Modifier.size(32.dp)
                             )

                         }




                     AnimatedVisibility(
                         visible = state.isOrderSectionVisible,
                         enter = fadeIn() + slideInVertically(tween(250)),
                         exit = fadeOut(targetAlpha = 0f) + slideOutHorizontally (tween(200))
                     ) {
                         OrderSelection(
                             modifier = Modifier
                                 .fillMaxWidth()
                                 .padding(vertical = 16.dp),
                             noteOrder = state.notesOrder,
                             onOrderChange = {
                                 viewModel.onEvent(NotesEvent.Order(it))
                             }
                         )
                     }
                     Spacer(modifier = Modifier.padding(vertical = 6.dp))
                     Divider(
                         color = MaterialTheme.colors.onSurface,
                         thickness = 4.dp,
                         modifier = Modifier.clip(Shapes.medium),

                         )
                     Spacer(modifier = Modifier
                         .fillMaxWidth()
                         .padding(vertical = 12.dp))

                 }
        },
        bottomBar = {

            BottomAppBar(
                elevation = 16.dp,
                backgroundColor = MaterialTheme.colors.surface,

                cutoutShape = RoundedCornerShape(50.dp),
                contentPadding = PaddingValues(horizontal = 82.dp),

            ) {

                ToggleIconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.onEvent(NotesEvent.ToggleListView)
                        viewModel.onEvent(NotesEvent.ToggleButton) },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.list),
                            contentDescription = "Sort",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier.size(32.dp)
                        )

                    },
                    alternativeIcon = {
                        Icon(
                            painter = painterResource(R.drawable.grid),
                            contentDescription = "Sort",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier.size(32.dp)
                        )


                    }

                )


                ToggleIconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.onEvent(NotesEvent.ToggleListView)
                        viewModel.onEvent(NotesEvent.ToggleButton) },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.list),
                            contentDescription = "Sort",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier.size(32.dp)
                        )

                    },
                    alternativeIcon = {
                        Icon(
                            painter = painterResource(R.drawable.grid),
                            contentDescription = "Sort",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier.size(32.dp)
                        )


                    }

                )





            }


        },
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.surface,


        scaffoldState = scaffoldState
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.surface
        ) {


            Column(
                Modifier
                    .padding(start = 16.dp, end = 16.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(

                            text = buildAnnotatedString {
                                withStyle(
                                    SpanStyle(
                                       color = MaterialTheme.colors.primary,
                                        fontSize = 26.sp,
                                        fontFamily = segoeBold

                                    )
                                ) {
                                    append("My")
                                }
                            withStyle(
                                SpanStyle(
                                    brush = Brush.linearGradient(

                                        colors = listOf(
                                            accentLeft,
                                            accentCenter,
                                            accentRight
                                        ),
                                           // Конец градиента - середина высоты последней буквы

                                    ),
                                    fontSize = 26.sp,
                                    fontFamily = segoeBold
                                )
                            ) {
                                append(" Notes")
                            }

                        }
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 18.dp))

                    ToggleIconButton(
                        onClick = {
                            viewModel.onEvent(NotesEvent.ToggleListView)
                            viewModel.onEvent(NotesEvent.ToggleButton) },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.list),
                                contentDescription = "Sort",
                                tint = MaterialTheme.colors.primary,
                                modifier = Modifier.size(32.dp)
                            )

                        },
                        alternativeIcon = {
                            Icon(
                                painter = painterResource(R.drawable.grid),
                                contentDescription = "Sort",
                                tint = MaterialTheme.colors.primary,
                                modifier = Modifier.size(32.dp)
                            )


                        }

                    )
                    Spacer(modifier = Modifier.padding(start = 18.dp))





                    IconButton(

                        onClick = {
                            viewModel.onEvent(NotesEvent.ToggleOrderSection)
                        }) {
                        Icon(
                            painter = painterResource(R.drawable.sort),
                            contentDescription = "Sort",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier.size(32.dp)
                        )

                    }

                    Spacer(modifier = Modifier.padding(horizontal = 26.dp))

                    IconButton(

                        onClick = {
                        /*TODO*/
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.settings),
                            contentDescription = "Sort",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier.size(32.dp)
                        )

                    }



                }
                AnimatedVisibility(
                    visible = state.isOrderSectionVisible,
                    enter = fadeIn() + slideInVertically(tween(250)),
                    exit = fadeOut(targetAlpha = 0f) + slideOutHorizontally (tween(200))
                ) {
                    OrderSelection(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        noteOrder = state.notesOrder,
                        onOrderChange = {
                            viewModel.onEvent(NotesEvent.Order(it))
                        }
                    )
                }
                Spacer(modifier = Modifier.padding(vertical = 6.dp))
                Divider(
                    color = MaterialTheme.colors.onSurface,
                    thickness = 4.dp,
                    modifier = Modifier.clip(Shapes.medium),

                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp))


                AnimatedVisibility(
                    visible = state.isGrid,
                    enter = slideInVertically  (tween(500), initialOffsetY = { it }),
                    exit = slideOutVertically(tween(500), targetOffsetY = { it })
                ) {
                    if (state.isGrid) {
                        LazyVerticalGrid(
                            modifier = Modifier.fillMaxSize(),
                            columns = GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(14.dp),
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            items(8) {
                                GridNoteItem()
                            }
                        }
                    }
                }

                AnimatedVisibility(
                    visible = !state.isGrid,
                    enter = slideInHorizontally  (tween(500), ),
                    exit = slideOutHorizontally(tween(500))
                ) {
                    if (!state.isGrid) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(14.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            items(4) {
                                ListNotesItem()
                            }
                        }
                    }
                }











            }
        }

    }
}

@Preview
@Composable
fun NotesScreenPreview() {
    NotesScreen()
}

