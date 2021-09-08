package amilosevic.and.anovinc.ferit.temperatureprediction.ui.viewmodels

import amilosevic.and.anovinc.ferit.temperatureprediction.api.Input
import amilosevic.and.anovinc.ferit.temperatureprediction.api.Inputs
import amilosevic.and.anovinc.ferit.temperatureprediction.api.SampleRequest
import amilosevic.and.anovinc.ferit.temperatureprediction.repository.TemperaturePredictionRepo
import amilosevic.and.anovinc.ferit.temperatureprediction.response.Response
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(private val temperaturePredictionRepo: TemperaturePredictionRepo) : ViewModel() {

    private var _temperaturePredictionResponse: MutableLiveData<Response> = MutableLiveData()
    var temperaturePredictionResponse: LiveData<Response> = _temperaturePredictionResponse
    private var _temperature: MutableLiveData<Double> = MutableLiveData()
    var temperature: LiveData<Double> = _temperature

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

        val response = temperaturePredictionRepo.predict(sampleRequest = sampleRequest)
        Log.d("responsitj", response.toString())

        val temperature = response.Results.output1.value.Values[0][0]
        _temperature.postValue(temperature.toDouble())

        Log.d("prebaciajde", _temperature.value.toString())

        _temperaturePredictionResponse.postValue(response)
    }

}