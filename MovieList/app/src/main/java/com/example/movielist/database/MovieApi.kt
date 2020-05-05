package com.example.movielist.database


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApi(yearMovie: String) {
    companion object {
        // The base url off the api.
        private const val baseUrl = "https://api.themoviedb.org/"

        /**
         * @return [NumbersApiService] The service class off the retrofit client.
         */
        fun createApi(): MovieApiService {
            // Create an OkHttpClient to be able to make a log of the network traffic
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            // Create the Retrofit instance
            val movieApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Return the Retrofit NumbersApiService as instance
            return movieApi.create(MovieApiService::class.java)
        }
    }
}