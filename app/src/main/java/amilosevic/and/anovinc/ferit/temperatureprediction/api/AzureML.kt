package amilosevic.and.anovinc.ferit.temperatureprediction.api

import amilosevic.and.anovinc.ferit.temperatureprediction.response.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface AzureML {

    @POST("88a1a7916bef4c4ba6679d0e2d4612dc/services/ba39fbc75f954d9b9b54b5e40af18c77/execute?api-version=2.0&details=true")
    suspend fun predictTemperature(
        @Body sampleRequest: SampleRequest
    ) : Response
}