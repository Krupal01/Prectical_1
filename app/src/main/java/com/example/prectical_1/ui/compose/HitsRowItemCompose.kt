package com.example.prectical_1.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prectical_1.model.HitsItem

@Composable
fun HitsRowItemCompose(hitsItem: HitsItem ,
                       onCardClick : () -> Unit ,
                       isSelected : Boolean,
                       onSwitchCheckChange : (Boolean) -> Unit
){
    Card(
        modifier = Modifier
            .padding(all = 3.dp)
            .fillMaxWidth()
            .clickable(onClick = onCardClick),
        shape = RoundedCornerShape(5.dp),
        elevation = 3.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(all = 10.dp)
        ) {
            Row {
                Text(text = hitsItem.title.toString(),
                    modifier = Modifier.weight(1F).padding(all = 3.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Switch(checked = isSelected,
                    onCheckedChange = (onSwitchCheckChange),
                    modifier = Modifier.padding(all = 3.dp)
                )
            }
            Text(text = "Author : ${hitsItem.author}",
                modifier = Modifier.fillMaxWidth().padding(all = 3.dp),
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 15.sp
            )
            Text(text = hitsItem.getDDMMYYYY().toString() ,
                modifier = Modifier.padding(all = 3.dp).align(alignment = Alignment.End),
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 15.sp
            )

        }

    }
}
