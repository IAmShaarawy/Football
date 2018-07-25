package net.elshaarawy.football.data.networking

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import net.elshaarawy.football.FootballApp
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by elshaarawy on 7/25/18.
 */
class ConnectionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        if (isConnectionAvailable()) {
            throw ConnectionException()
        }
        val builder = chain?.request()?.newBuilder()
        return chain?.proceed(builder?.build())
    }

    private fun isConnectionAvailable(): Boolean {

        val connectivityManager: ConnectivityManager = FootballApp.context()
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfo: NetworkInfo = connectivityManager.activeNetworkInfo

        return networkInfo.isConnected
    }
}