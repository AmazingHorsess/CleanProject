package com.amazinghorsess.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amazinghorsess.utils.NoteOrder
import com.amazinghorsess.utils.OrderType

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OrderSelection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit,
) {
    Column(modifier = modifier) {
        FlowRow(
            horizontalArrangement = Arrangement.Center,
            maxItemsInEachRow = 3,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(
                text = "Title",
                selected = noteOrder is NoteOrder.Title,
                onSelect = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
            )
            RadioButton(
                text = "Date",
                selected = noteOrder is NoteOrder.Date,
                onSelect = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
            )
            RadioButton(
                text = "Color",
                selected = noteOrder is NoteOrder.Color,
                onSelect = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            FlowRow(
                horizontalArrangement = Arrangement.Center,
                maxItemsInEachRow = 3,
                modifier = Modifier.fillMaxWidth()
            ) {
                RadioButton(
                    text = "Ascending",
                    selected = noteOrder.orderType is OrderType.Ascending,
                    onSelect = { onOrderChange(noteOrder.copy(OrderType.Ascending)) }
                )
                RadioButton(
                    text = "Descending",
                    selected = noteOrder is NoteOrder.Date,
                    onSelect = { onOrderChange(noteOrder.copy(OrderType.Descending)) }
                )

            }







        }


    }

}




