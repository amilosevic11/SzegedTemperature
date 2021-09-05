package amilosevic.and.anovinc.ferit.temperatureprediction.ui.activities

import amilosevic.and.anovinc.ferit.temperatureprediction.databinding.ActivityMainBinding
import amilosevic.and.anovinc.ferit.temperatureprediction.ui.viewmodels.MainActivityViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater).also {

            val humidity = it.etHumidity.text.toString()
            val windSpeed = it.etWindSpeed.text.toString()
            val visibility = it.etVisibility.text.toString()

            it.btnPredict.setOnClickListener {
                CoroutineScope(Dispatchers.Default).launch {
                    viewModel.temperaturePrediction(addData(humidity, windSpeed, visibility))
                }
            }
        }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun addData(
        humidity: String,
        windSpeed: String,
        visibility: String
    ): ArrayList<String> {
        return arrayListOf("0", humidity, windSpeed, visibility)
    }
}