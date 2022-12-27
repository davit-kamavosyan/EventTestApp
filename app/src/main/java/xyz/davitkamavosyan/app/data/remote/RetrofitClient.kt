package xyz.davitkamavosyan.app.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Interceptor
import okhttp3.Response

private const val API_URL = "https://api.openweathermap.org/" // todo move to gradle
private const val API_KEY = "9e9756915198187260f700f98619f656"

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url.newBuilder()
            .build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}

