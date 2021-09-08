package amilosevic.and.anovinc.ferit.temperatureprediction

import amilosevic.and.anovinc.ferit.temperatureprediction.di.appModules
import amilosevic.and.anovinc.ferit.temperatureprediction.di.networkingModule
import amilosevic.and.anovinc.ferit.temperatureprediction.di.viewModelModules
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
            modules(listOf(appModules, viewModelModules, networkingModule))
        }
    }
}