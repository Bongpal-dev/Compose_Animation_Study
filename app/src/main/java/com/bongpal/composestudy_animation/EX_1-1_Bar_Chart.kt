package com.bongpal.composestudy_animation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bongpal.composestudy_animation.ui.theme.ComposeStudy_AnimationTheme

@Composable
fun Ex_1_1(paddingValues: PaddingValues = PaddingValues()) {
    val chartData = listOf(0.2f, 0.4f, 0.6f, 0.8f, 1f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.BottomCenter
    ) {
        ChartArea(input = chartData)
    }
}

@Composable
fun ChartArea(input: List<Float>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp)
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        input.forEach { ChartBar(input = it) }
    }
}

@Composable
fun ChartBar(input: Float) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${(input * 100).toInt()}%")
        Spacer(modifier = Modifier.height(12.dp))
        Box(modifier = TopRound(heightRate = input, color = Color.Black))
    }
}

@Composable
fun TopRound(heightRate: Float, color: Color): Modifier {
    return Modifier
        .fillMaxHeight(fraction = heightRate)
        .width(30.dp)
        .background(
            color = color,
            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
        )
}

@Preview(showBackground = true)
@Composable
fun Ex_1_1_Preview() {
    ComposeStudy_AnimationTheme {
        Ex_1_1()
    }
}
