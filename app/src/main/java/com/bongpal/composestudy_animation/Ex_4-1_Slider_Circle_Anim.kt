package com.bongpal.composestudy_animation

import android.graphics.Paint.Align
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bongpal.composestudy_animation.ui.theme.ComposeStudy_AnimationTheme


@Composable
fun Ex_4_1(paddingValues: PaddingValues = PaddingValues()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Contents()
    }
}

@Composable
fun Contents() {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        var sliderPosition by remember { mutableStateOf(0.5f) }

        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Red,
                inactiveTrackColor = Color.LightGray
            )
        )

        SliderCircle(sliderPosition)
    }
}

@Composable
fun SliderCircle(position: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(300.dp),
        contentAlignment = Alignment.Center
    ) {
        CircleShape(color = Color.Gray)

        val progress = position * 360

        CircleShape(color = Color.Cyan, position = progress)

        Text(
            text = "${(position * 100).toInt()}%",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold

        )
    }
}

@Composable
fun CircleShape(color: Color, position: Float = 360f) {
    Canvas(
        modifier = Modifier
            .width(250.dp)
            .height(250.dp)
    ) {
        drawArc(
            brush = SolidColor(color),
            startAngle = -90f,
            sweepAngle = position,
            useCenter = false,
            style = Stroke(35f, cap = StrokeCap.Round)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Ex_4_1_Preview() {
    ComposeStudy_AnimationTheme {
        Ex_4_1()
    }
}