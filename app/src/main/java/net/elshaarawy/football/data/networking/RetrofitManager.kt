package net.elshaarawy.football.data.networking

import io.reactivex.android.schedulers.AndroidSchedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by elshaarawy on 7/25/18.
 */

private const val BASE_URL: String = "http://api.football-data.org/v1/"

private fun httpClientCreator(): OkHttpClient {
    return OkHttpClient().newBuilder()
            .addInterceptor(ConnectionInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
}

fun retrofit(): Retrofit {
    return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(AndroidSchedulers.mainThread()))
            .client(httpClientCreator())
            .build()
}