package net.elshaarawy.football.teams

import android.arch.lifecycle.LiveData
import net.elshaarawy.football.bases.BaseViewModel
import net.elshaarawy.football.data.networking.FootballApis
import net.elshaarawy.football.data.networking.FootballApis.footballApis
import net.elshaarawy.football.data.room.entities.TeamEntity
import net.elshaarawy.football.data.room.models.TeamsResponse

/**
 * Created by elshaarawy on 7/25/18.
 */
class TeamsViewModel(private val leagueId: Long) : BaseViewModel<TeamEntity>() {
    override fun loadData(): LiveData<List<TeamEntity>> {
        loadingSubject.onNext(true)
        footballApis.apis.getLeagueTeams(leagueId)
                .doAfterNext { loadingSubject.onNext(false) }
                .map(TeamsResponse::teamsList)
                .subscribe(listData::postValue)
        return this.listData
    }

}