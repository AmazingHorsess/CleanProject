package com.amazinghorsess.feature_note.presentation.notes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amazinghorsess.feature_note.domain.model.Note
import com.amazinghorsess.utils.theme.Shapes
import com.amazinghorsess.utils.theme.pastelPink
import com.amazinghorsess.utils.theme.pastelPinkB1
import com.amazinghorsess.utils.theme.pastelPinkH1

@Composable
fun GridNoteItem(

    modifier: Modifier = Modifier,

    ){
    Box(
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures  (
                onLongPress = {
                }
                    )
        }
    ) {

        Column(
            modifier = Modifier


                .clip(RoundedCornerShape(30.dp))
                .background(pastelPink)


                .width(200.dp)
                .height(146.dp)
                .padding(start = 10.dp, end = 10.dp, bottom = 0.dp )



        ) {

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Заголовок",
                color = pastelPinkH1,
                style = MaterialTheme.typography.h1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,

            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Lorem ipsum bla bla. ",
                color = pastelPinkB1,
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "29 мая",
                color = pastelPinkB1,
                style = MaterialTheme.typography.body2,
            )

        }


    }

}
@Preview(showBackground = true)
@Composable
fun GridNoteItemPreview(){
    GridNoteItem(

    )
}
