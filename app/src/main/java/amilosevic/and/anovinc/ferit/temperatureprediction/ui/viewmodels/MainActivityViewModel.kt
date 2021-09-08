package amilosevic.and.anovinc.ferit.temperatureprediction.ui.viewmodels

import amilosevic.and.anovinc.ferit.temperatureprediction.api.GlobalParameters
import amilosevic.and.anovinc.ferit.temperatureprediction.api.Input
import amilosevic.and.anovinc.ferit.temperatureprediction.api.Inputs
import amilosevic.and.anovinc.ferit.temperatureprediction.api.SampleRequest
import amilosevic.and.anovinc.ferit.temperatureprediction.repository.TemperaturePredictionRepo
import androidx.lifecycle.ViewModel
import org.json.JSONArray
import java.util.ArrayList

class MainActivityViewModel(private val temperaturePredictionRepo: TemperaturePredictionRepo) : ViewModel() {

    suspend fun predict(humidity: String, windSpeed: String, visibility: String) {
        val temp = 0

        val colNames = mutableListOf<String>()
        colNames.add("Temperature (C)")
        colNames.add("Humidity")
        colNames.add("Wind Speed (km/h)")
        colNames.add("Visibility (km)")

        val enteredValues = mutableListOf<String>()
        enteredValues.add(temp.toString())
        enteredValues.add(humidity)
        enteredValues.add(windSpeed)
        enteredValues.add(visibility)

        val values = mutableListOf<MutableList<String>>()
        values.add(enteredValues)

        val globalParameters: HashMap<String, String> = hashMapOf()

        val sampleRequest = SampleRequest(Inputs(Input(colNames, values)), globalParameters)

        temperaturePredictionRepo.predict(sampleRequest = sampleRequest)
    }

}