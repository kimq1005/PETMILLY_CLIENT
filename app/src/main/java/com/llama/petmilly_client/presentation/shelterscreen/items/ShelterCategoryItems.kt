package com.llama.petmilly_client.presentation.shelterscreen.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.homescreen.CategoryTest
import com.llama.petmilly_client.ui.theme.Purple700

@Composable
fun ShelterCategoryItems(
    title: String,
    onclcik:()->Unit,
) {
    Card(modifier = Modifier
        .fillMaxSize()
        .clickable {
            onclcik()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier.width(90.dp).height(90.dp),
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = null,
            )



            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = title,
                        fontSize = 11.sp,
                    )

                }

                Spacer(modifier = Modifier.height(5.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${ title} / ${title} / ${ title} / ${ title}",
                        fontSize = 12.sp,
                        color = Color.Blue,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text =  title,
                        fontSize = 11.sp,
                        color = Color.Black
                    )
                }


            }


        }
    }

}