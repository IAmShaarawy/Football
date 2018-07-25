package net.elshaarawy.football.teams

import android.arch.lifecycle.LiveData
import net.elshaarawy.football.bases.BaseViewModel
import net.elshaarawy.football.data.room.entities.TeamEntity

/**
 * Created by elshaarawy on 7/25/18.
 */
class TeamsViewModel(private val leagueId: Long) : BaseViewModel<TeamEntity>() {
    override fun loadData(): LiveData<List<TeamEntity>> {
        return this.listData
    }

}