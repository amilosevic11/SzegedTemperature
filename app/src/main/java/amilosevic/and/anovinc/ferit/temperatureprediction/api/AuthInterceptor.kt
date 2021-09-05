package amilosevic.and.anovinc.ferit.temperatureprediction.api

import amilosevic.and.anovinc.ferit.temperatureprediction.utils.Constants
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var request: Request = chain.request().also {
            it.newBuilder()
                .addHeader(Constants.AUTHORIZATION, Constants.API_AUTH)
                .addHeader(Constants.CONTENT_TYPE, Constants.HEADER_CONTENT_TYPE)
                .build()

        }

        return chain.proceed(request)
    }

}