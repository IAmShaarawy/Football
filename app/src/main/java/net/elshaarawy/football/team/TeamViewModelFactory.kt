package net.elshaarawy.football.team

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders

/**
 * Created by elshaarawy on 7/25/18.
 */
class TeamViewModelFactory(private val teamId: Long) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            modelClass.getConstructor(Long::class.java).newInstance(teamId)
}