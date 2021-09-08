package amilosevic.and.anovinc.ferit.temperatureprediction.api

import amilosevic.and.anovinc.ferit.temperatureprediction.utils.Constants
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {

    private val TAG = "AuthInterceptor"

    override fun intercept(chain: Interceptor.Chain): Response {

        var req = chain.request()

        try{
            if(req.url.toString().contains("azureml") ){
                Log.d(TAG,"authentication in progress")
                req = req.newBuilder()
                    .addHeader("Authorization","Bearer phJidOzPd2Lv6eZpu/yj6g6Roe5sgqCvhOyhEB1vI6BDuIlf225PHSwdQYb0RFaQqV9JLBPdAv8KC60A4YZZYA==")
                    .build()
            }
            // DONT INCLUDE API KEYS IN YOUR SOURCE CODE
            val url = req.url.newBuilder().build()
            req = req.newBuilder().url(url).build()
            return chain.proceed(req)
        } catch (e: Exception){
            e.printStackTrace()
            e.message?.let { Log.d(TAG, it) }
        }

        return chain.proceed(req)

    }

}