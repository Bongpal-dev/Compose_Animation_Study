package com.bongpal.composestudy_animation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bongpal.composestudy_animation.ui.theme.ComposeStudy_AnimationTheme

data class ChartModel(
    val fraction: Float,
    val color: Color
)

@Composable
fun Ex3_1(paddingValues: PaddingValues = PaddingValues()) {
    val items = listOf(
        ChartModel(fraction = 0.5f, color = Color.Red),
        ChartModel(fraction = 0.3f, color = Color.Blue),
        ChartModel(fraction = 0.2f, color = Color.Green)

    )
    var startAngle = 0f

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
        ) {
            items.forEach {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    drawArc(
                        color = it.color,
                        startAngle = startAngle,
                        sweepAngle = it.fraction * 360f,
                        useCenter = false,
                        size = Size(size.width, size.height),
                        style = Stroke(300f)
                    )

                    startAngle += it.fraction * 360f
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun Ex3_1_Preview() {
    ComposeStudy_AnimationTheme {
        Ex3_1()
    }
}