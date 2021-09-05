package amilosevic.and.anovinc.ferit.temperatureprediction.api

import amilosevic.and.anovinc.ferit.temperatureprediction.models.Inputs
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface AzureML {

    @POST("execute")
    suspend fun predictTemperature(
        @Body input: Inputs
    )
}