package net.elshaarawy.football.teams

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import java.io.File

/**
 * Created by elshaarawy on 7/25/18.
 */
class TeamsViewModelFactory(private val leagueId: Long) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            modelClass.getConstructor(Long::class.java).newInstance(leagueId)
}