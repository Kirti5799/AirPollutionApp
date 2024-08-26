package com.example.airpollutionapp.ui.screens
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airpollutionapp.ui.network.AirPollution
import com.example.airpollutionapp.ui.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Call

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

data class AirState(
    val result: Call<AirPollution> =AirPollution(),
    val status: Status = Status.LOADING,
    val error: String = "",
)

class AppViewModel(): ViewModel() {

    private val _state = MutableStateFlow(AirState())
    val state = _state.asStateFlow()

    init {
        fetchAirPollutionData()
    }

    private fun fetchAirPollutionData() {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.getAirPollutionData(
                    apiKey = "7f52c6fc5b89bcc512565d335fbf661e",
                    latitude = 40.7128,
                    longitude = -74.0060
                )
                _state.update { it.copy(result = result, status = Status.SUCCESS) }
            } catch (e: Exception) {
                _state.update {
                    it.copy(status = Status.ERROR, error = e.message ?: "Something went wrong")
                }
            }


        }
    }
}




