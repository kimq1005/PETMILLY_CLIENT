package com.llama.petmilly_client.presentation.shelterscreen.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R

@Composable
fun ShelterCategoryItems(
    title: String,
) {
    Card {
        Row(
            Modifier

        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = null,
                modifier = Modifier.weight(1f)
            )

            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(16.dp)
            ) {
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "$title / $title / $title / $title",
                    fontSize = 12.sp,
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "$title / $title",
                    fontSize = 12.sp,
                )


            }


        }
    }

}