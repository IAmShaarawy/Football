package net.elshaarawy.football

import android.app.Application
import android.content.Context

/**
 * Created by elshaarawy on 7/25/18.
 */
class FootballApp : Application() {

    init {
        context = this
    }

    companion object {
        var context: Context? = null
        fun context(): Context = context!!
    }

    override fun onCreate() {
        super.onCreate()
    }
}