package amilosevic.and.anovinc.ferit.temperatureprediction.repository

import amilosevic.and.anovinc.ferit.temperatureprediction.api.AzureML
import amilosevic.and.anovinc.ferit.temperatureprediction.api.SampleRequest
import amilosevic.and.anovinc.ferit.temperatureprediction.utils.Constants
import android.util.Log

class TemperaturePredictionRepo(private val azureML: AzureML) {

    suspend fun predict(sampleRequest: SampleRequest) {
        val response = azureML.predictTemperature(sampleRequest = sampleRequest)
        Log.d("response", response.toString())
    }
}