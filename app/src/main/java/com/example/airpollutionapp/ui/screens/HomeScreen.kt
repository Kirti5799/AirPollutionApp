package com.example.airpollutionapp.ui.screens

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import com.example.airpollutionapp.ui.network.AirPollution

@Composable
fun AirPollutionScreen(
    modifier: Modifier = Modifier,
    state: AirState,
    onSettingClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Air Pollution Data")
        Button(modifier = Modifier.padding(16.dp),
            shape = ShapeDefaults.Medium,
            onClick = { }) {

        }
    }
}