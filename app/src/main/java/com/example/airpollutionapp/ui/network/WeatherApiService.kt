package com.example.airpollutionapp.ui.network
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApiService {

    interface AirPollutionApiService {

        @GET("air_pollution")
        fun getAirPollutionData(
            @Query("lat") latitude: Double,
            @Query("lon") longitude: Double,
            @Query("appid") apiKey: String
        ): Call<AirPollution>
    }
}
object RetrofitInstance {

    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    val api: WeatherApiService.AirPollutionApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService.AirPollutionApiService::class.java)
    }
}