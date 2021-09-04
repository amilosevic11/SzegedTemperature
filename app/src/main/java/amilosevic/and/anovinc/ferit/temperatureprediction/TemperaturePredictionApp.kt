package amilosevic.and.anovinc.ferit.temperatureprediction

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TemperaturePredictionApp : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin {
            androidContext(this@TemperaturePredictionApp)
        }
    }
}