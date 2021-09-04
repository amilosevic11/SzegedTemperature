package amilosevic.and.anovinc.ferit.temperatureprediction.api

import retrofit2.http.POST
import retrofit2.http.Query

interface AzureML {
    @POST("execute")
    fun predictTemperature(
        @Query("api-version") apiVersion: String,
        @Query("format") format: String,
        @Query("Content-type") contentType: String,
        @Query("Authorization") auth: String
    )
}