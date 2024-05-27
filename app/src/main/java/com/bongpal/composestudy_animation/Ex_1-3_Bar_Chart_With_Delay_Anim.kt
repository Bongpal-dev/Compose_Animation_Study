package com.bongpal.composestudy_animation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bongpal.composestudy_animation.ui.theme.ComposeStudy_AnimationTheme
import kotlinx.coroutines.delay

@Composable
fun Ex_1_3(paddingValues: PaddingValues = PaddingValues()) {
    val chartData = listOf(0.2f, 0.4f, 0.6f, 0.8f, 1f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.BottomCenter
    ) {
        ChartArea_1_3(input = chartData)
    }
}

@Composable
fun ChartArea_1_3(input: List<Float>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp)
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        input.forEachIndexed { index, value ->
            ChartBar_1_3(index = index, heightRate = value)
        }
    }
}

@Composable
fun ChartBar_1_3(index: Int, heightRate: Float) {
    val maxHeight = 600.dp
    var resultHeight by remember { mutableStateOf(0.dp) }
    val animatedHeight by animateDpAsState(
        targetValue = resultHeight,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )

    LaunchedEffect(true) {
        delay(index * 1000L)
        resultHeight = maxHeight * heightRate
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${(heightRate * 100).toInt()}%")
        Spacer(modifier = Modifier.height(12.dp))
        Box(modifier = AnimatedTopRound2(height = animatedHeight, color = Color.Red))
    }
}

@Composable
fun AnimatedTopRound2(height: Dp, color: Color): Modifier {
    return Modifier
        .height(height)
        .width(30.dp)
        .background(
            color = color,
            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
        )
}

@Preview(showBackground = true)
@Composable
fun Ex_1_3_Preview() {
    ComposeStudy_AnimationTheme {
        Ex_1_3()
    }
}