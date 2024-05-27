package com.bongpal.composestudy_animation

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bongpal.composestudy_animation.ui.theme.ComposeStudy_AnimationTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Ex_3_2(paddingValues: PaddingValues = PaddingValues()) {
    val items = listOf(
        ChartModel(fraction = 0.5f, color = Color.Red),
        ChartModel(fraction = 0.3f, color = Color.Blue),
        ChartModel(fraction = 0.2f, color = Color.Green)

    )
    var startAngle = 0f
    var animatedProgress by remember { mutableStateOf(0f) }
    val animatedState by animateFloatAsState(
        targetValue = animatedProgress,
        animationSpec = tween(durationMillis = 2000, easing = LinearOutSlowInEasing)
    )

    LaunchedEffect(key1 = true) {
        animatedProgress = 1f
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(300.dp)
        ) {
            items.forEach {
                val fraction = (it.fraction * 100f).toInt()
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    drawArc(
                        color = it.color,
                        startAngle = startAngle,
                        sweepAngle = it.fraction * animatedState * 360f,
                        useCenter = true,
                        size = Size(size.width, size.height),
                        style = Fill
                    )

                    val paint = Paint().asFrameworkPaint().apply {
                        color = android.graphics.Color.WHITE
                        textSize = 60f
                    }
                    val midPosition = startAngle + it.fraction * 180f
                    val radiusPosition = size.width * 0.5f * 0.5f
                    val xPosition =
                        (radiusPosition * cos(midPosition * (PI / 180))).toFloat() + size.width * 0.5f
                    val yPosition =
                        (radiusPosition * sin(midPosition * (PI / 180))).toFloat() + size.height * 0.5f

                    val textWidth = paint.measureText(fraction.toString())
                    val textHeight = paint.descent() - paint.ascent()
                    val newXPosition = xPosition - textWidth * 0.5f
                    val newYPosition = yPosition + textHeight * 0.5f

                    drawIntoCanvas {
                        it.nativeCanvas.drawText("${fraction}%", newXPosition, newYPosition, paint)
                    }
                    startAngle += it.fraction * 360f
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun Ex3_2_Preview() {
    ComposeStudy_AnimationTheme {
        Ex_3_2()
    }
}