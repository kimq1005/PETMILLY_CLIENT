package com.llama.petmilly_client.presentation.shelterscreen

import android.app.Activity
import androidx.activity.compose.LocalActivityResultRegistryOwner
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen

@Composable
fun ShelterAnimalInfoUploadScreen() {
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {

        val (value, setvaluse) = rememberSaveable {
            mutableStateOf(" ")
        }

        val (job, setjob) = rememberSaveable {
            mutableStateOf(" ")
        }

        val (location, setlocation) = rememberSaveable {
            mutableStateOf(" ")
        }

        val (animalExperiencee, setanimalExperience) = rememberSaveable {
            mutableStateOf(false)
        }

        Text(
            text = "모금을 유도하는 치료비 내역, 모금 내역 등은 기재할 수 없습니다.\n입양 홍보 목적으로만 이용해주세요.",
            fontSize = 12.sp,
            color = Color.Black
        )


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "동네",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "월계2동",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "분류",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "갱얼지", Modifier.align(Alignment.CenterVertically))
            Checkbox(
                checked = animalExperiencee,
                onCheckedChange = setanimalExperience,
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "고양이", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)

        }


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "이름",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )


        OutlinedTextField(
            value = location,
            onValueChange = setlocation,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "성별",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "수컷", Modifier.align(Alignment.CenterVertically))
            Checkbox(
                checked = animalExperiencee,
                onCheckedChange = setanimalExperience,
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "암컷", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "모름", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)
        }


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "몸무게",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(modifier = Modifier.fillMaxWidth()) {

            Text(text = "1~3kg", Modifier.align(Alignment.CenterVertically))
            Checkbox(
                checked = animalExperiencee,
                onCheckedChange = setanimalExperience,
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "4~7kg", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "8~15kg", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "15kg~", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "품종",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )


        OutlinedTextField(
            value = location,
            onValueChange = setlocation,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "예상나이",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )


        OutlinedTextField(
            value = location,
            onValueChange = setlocation,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        )


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "중성화여부",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "완료", Modifier.align(Alignment.CenterVertically))
            Checkbox(
                checked = animalExperiencee,
                onCheckedChange = setanimalExperience,
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "모름/미완료", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)

        }



        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "접종여부 및 건강상태",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "미접종", Modifier.align(Alignment.CenterVertically))
            Checkbox(
                checked = animalExperiencee,
                onCheckedChange = setanimalExperience,
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "1차완료", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "2차완료", Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = animalExperiencee, onCheckedChange = setanimalExperience)

        }

        OutlinedTextField(
            value = location,
            onValueChange = setlocation,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "성격/특징",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )


        OutlinedTextField(
            value = location,
            onValueChange = setlocation,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        )

        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 16,
            modifier = Modifier.fillMaxWidth(),
            backgroundcolor = Button_Clicked
        ) {

        }

    }
}

@Composable
fun ShelterAnimalInfoUploadScreen_Second() {

    val (value, setvaluse) = rememberSaveable {
        mutableStateOf(" ")
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "모금을 유도하는 치료비 내역, 모금 내역 등은 기재할 수 없습니다.\n입양 홍보 목적으로만 이용해주세요.",
            fontSize = 12.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "픽업방법 : 직접픽업/ 조율가능",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "희망지역 :",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "임보 희망 기간",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "임보조건(입력값)",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "이런분을 희망해요",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )


        OutlinedTextField(
            value = value,
            onValueChange = setvaluse,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        )


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "이런분은 앙대용",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )


        OutlinedTextField(
            value = value,
            onValueChange = setvaluse,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        )

        Divider(Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 16,
            modifier = Modifier.fillMaxWidth(),
            backgroundcolor = Button_Clicked
        ) {

        }
    }
}

@Preview
@Composable
fun AnimalPreview() {
    ShelterAnimalInfoUploadScreen_Second()
}