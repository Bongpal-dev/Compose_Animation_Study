package com.bongpal.composestudy_animation

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bongpal.composestudy_animation.ui.theme.ComposeStudy_AnimationTheme
import java.text.NumberFormat

@Composable
fun Ex_2_2(paddingValues: PaddingValues = PaddingValues()) {
    var resultMoney by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val animatedMoney by animateIntAsState(
            targetValue = resultMoney,
            animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
        )
        LaunchedEffect(key1 = true) {
            resultMoney = 10000000
        }

        val formattedResultMoney = NumberFormat.getNumberInstance().format(animatedMoney)

        Text(
            text = "${formattedResultMoney}원",
            fontSize = 50.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Ex_2_2_Preview() {
    ComposeStudy_AnimationTheme {
        Ex_2_2()
    }
}