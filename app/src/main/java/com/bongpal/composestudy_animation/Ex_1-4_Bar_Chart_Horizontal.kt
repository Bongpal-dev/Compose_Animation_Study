package com.bongpal.composestudy_animation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bongpal.composestudy_animation.ui.theme.ComposeStudy_AnimationTheme

@Composable
fun Ex_1_4(paddingValues: PaddingValues = PaddingValues()) {
    val chartData = listOf(0.2f, 0.4f, 0.6f, 0.8f, 1f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.BottomCenter
    ) {
        ChartArea_1_4(input = chartData)
    }
}

@Composable
fun ChartArea_1_4(input: List<Float>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        input.forEach {
            Row() {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = it * 0.8f)
                        .height(30.dp)
                        .background(
                            Color.Magenta,
                            shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 15.dp)
                        )
                ) {

                }

                Text(
                    text = "${(it * 100).toInt()}%",
                    modifier = Modifier.padding(top = 4.dp, start = 12.dp),
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ex_1_4_Preview() {
    ComposeStudy_AnimationTheme {
        Ex_1_4()
    }
}