package amilosevic.and.anovinc.ferit.temperatureprediction.ui.viewmodels

import amilosevic.and.anovinc.ferit.temperatureprediction.models.ColumnNames
import amilosevic.and.anovinc.ferit.temperatureprediction.repository.TemperaturePredictionRepo
import androidx.lifecycle.ViewModel
import java.util.ArrayList

class MainActivityViewModel(private val temperaturePredictionRepo: TemperaturePredictionRepo) : ViewModel() {

    suspend fun temperaturePrediction(arrayList: ArrayList<String>) {
        temperaturePredictionRepo.temperaturePrediction(arrayList)
    }
}