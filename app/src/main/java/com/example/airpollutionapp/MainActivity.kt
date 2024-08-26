package com.example.airpollutionapp

import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.airpollutionapp.ui.theme.AirPollutionAppTheme
import kotlinx.coroutines.Delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AirPollutionAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}

@Composable
fun CircularProgressBar( percentage:Float,
                         number:Int,
                         fontSize:TextUnit=28.sp,
                         radius:Dp=50.dp,
                         color: Color=Color.Green,
                         strokeWidth: Dp=8.dp,
                         animDuration: Int=1000,
                         animDelay: Int=0,
                         ) {
    var animationPlayed by remember{ mutableStateOf(false) }
   val curPercentage= animateFloatAsState(
       targetValue = if (animationPlayed) percentage else 0f,
       animationSpec = tween(durationMillis = animDuration,
           delayMillis = animDelay)
   )
    LaunchedEffect(key1 = true) {
        animationPlayed=true
    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius*2f)
        ){
        Canvas(modifier = Modifier.size(radius*2f)) {
            drawArc(color)
        }
    }
}
