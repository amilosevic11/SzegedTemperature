package amilosevic.and.anovinc.ferit.temperatureprediction.di

import amilosevic.and.anovinc.ferit.temperatureprediction.api.AuthInterceptor
import amilosevic.and.anovinc.ferit.temperatureprediction.api.AzureML
import amilosevic.and.anovinc.ferit.temperatureprediction.repository.TemperaturePredictionRepo
import amilosevic.and.anovinc.ferit.temperatureprediction.ui.viewmodels.MainActivityViewModel
import amilosevic.and.anovinc.ferit.temperatureprediction.utils.Constants
import amilosevic.and.anovinc.ferit.temperatureprediction.utils.Constants.Companion.BASE_URL
import androidx.databinding.library.BuildConfig
import get
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModules = module {
    single { TemperaturePredictionRepo(get()) }
}

val viewModelModules = module {
    viewModel { MainActivityViewModel(TemperaturePredictionRepo(get())) }
}

val networkingModule = module {
    single { AuthInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideNetwork(get()) }
    single { provideRetrofit(get()) }
}


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://ussouthcentral.services.azureml.net/workspaces/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideAuthInterceptor() : AuthInterceptor = AuthInterceptor()

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(logging)
        .build()
}

fun provideNetwork(retrofit: Retrofit): AzureML = retrofit.create(AzureML::class.java)

