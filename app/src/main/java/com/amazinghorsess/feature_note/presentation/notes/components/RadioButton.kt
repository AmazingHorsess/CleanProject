package com.amazinghorsess.feature_note.presentation.notes.components

import android.widget.RadioButton
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioButton(
    text: String,
    selected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically

    ) {
        RadioButton(
            selected = selected,
            onClick = onSelect,
            colors = RadioButtonDefaults.colors(
                selectedColor = androidx.compose.ui.graphics.Color.White, /*TODO Change color*/
                unselectedColor = androidx.compose.ui.graphics.Color.LightGray, /*TODO Change color*/
                )
        )

        Text(
            text = text
        )

    }

}

@Preview
@Composable
fun RadioButtonPreview(){
    RadioButton(text = "TEST", selected = true, onSelect = { /*TODO*/ })
}