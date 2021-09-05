package amilosevic.and.anovinc.ferit.temperatureprediction.di

import amilosevic.and.anovinc.ferit.temperatureprediction.api.AuthInterceptor
import amilosevic.and.anovinc.ferit.temperatureprediction.api.AzureML
import amilosevic.and.anovinc.ferit.temperatureprediction.repository.TemperaturePredictionRepo
import amilosevic.and.anovinc.ferit.temperatureprediction.ui.viewmodels.MainActivityViewModel
import amilosevic.and.anovinc.ferit.temperatureprediction.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModules = module {
    single { TemperaturePredictionRepo(get()) }
}

val viewModelModules = module {
    viewModel { MainActivityViewModel(get()) }
}

val networkModule = module {
    single { AuthInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideNetwork(get()) }
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {

    val logging: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    return OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(logging)
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideNetwork(retrofit: Retrofit): AzureML = retrofit.create(AzureML::class.java)