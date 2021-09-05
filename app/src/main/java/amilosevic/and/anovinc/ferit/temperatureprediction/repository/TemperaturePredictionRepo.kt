package amilosevic.and.anovinc.ferit.temperatureprediction.repository

import amilosevic.and.anovinc.ferit.temperatureprediction.api.AzureML
import amilosevic.and.anovinc.ferit.temperatureprediction.models.Input1
import amilosevic.and.anovinc.ferit.temperatureprediction.models.Inputs
import android.util.Log
import java.util.ArrayList

class TemperaturePredictionRepo(private val azureML: AzureML) {


    suspend fun temperaturePrediction(arrayList: ArrayList<String>) {
        val response = azureML.predictTemperature(input = Inputs(input1 = Input1(arrayList)))

        Log.d("responseAzureML", response.toString())
    }
}