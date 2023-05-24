package com.amazinghorsess.feature_note.presentation.notes.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.amazinghorsess.utils.theme.pastelPink
import com.amazinghorsess.utils.theme.pastelPinkB1
import com.amazinghorsess.utils.theme.pastelPinkH1

@Composable
fun ListNotesItem(){

    Box() {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier


                    .clip(RoundedCornerShape(30.dp))
                    .background(pastelPink)


                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(start = 24.dp, end = 24.dp, bottom = 10.dp, top = 10.dp)



            ) {

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Заголовок",
                    color = pastelPinkH1,
                    style = MaterialTheme.typography.h1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,

                    )

                Text(
                    modifier = Modifier.weight(1f),
                    text = "Lorem ipsum bla bla. ",
                    color = pastelPinkB1,
                    style = MaterialTheme.typography.body1,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    modifier = Modifier.weight(1f),
                    text = "29 мая 9:57  27 символов",
                    color = pastelPinkB1,
                    style = MaterialTheme.typography.body2,
                )

            }

        }

    }
}
