package net.elshaarawy.football.leagues

import android.arch.lifecycle.LiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import net.elshaarawy.football.bases.BaseViewModel
import net.elshaarawy.football.data.networking.FootballApis
import net.elshaarawy.football.data.networking.FootballApis.footballApis
import net.elshaarawy.football.data.room.entities.LeagueEntity

/**
 * Created by elshaarawy on 7/25/18.
 */
class LeaguesViewModel : BaseViewModel<LeagueEntity>() {
    override fun loadData(): LiveData<List<LeagueEntity>> {
        loadingSubject.onNext(true)
        footballApis.apis.getLeagues()
                .doAfterNext { loadingSubject.onNext(false) }
                .subscribe(listData::postValue)
        return this.listData
    }

}