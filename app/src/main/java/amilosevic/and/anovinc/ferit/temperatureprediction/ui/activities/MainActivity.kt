package amilosevic.and.anovinc.ferit.temperatureprediction.ui.activities

import amilosevic.and.anovinc.ferit.temperatureprediction.databinding.ActivityMainBinding
import amilosevic.and.anovinc.ferit.temperatureprediction.ui.viewmodels.MainActivityViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater).also {

            val binding = it

            it.btnPredict.setOnClickListener {

                val humidity = binding.etHumidity.text.toString()
                val windSpeed = binding.etWindSpeed.text.toString()
                val visibility = binding.etVisibility.text.toString()

                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.predict(humidity, windSpeed, visibility)
                }
            }
        }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}