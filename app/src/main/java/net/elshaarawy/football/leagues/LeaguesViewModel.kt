package net.elshaarawy.football.leagues

import android.arch.lifecycle.LiveData
import net.elshaarawy.football.bases.BaseViewModel
import net.elshaarawy.football.data.room.entities.LeagueEntity

/**
 * Created by elshaarawy on 7/25/18.
 */
class LeaguesViewModel : BaseViewModel<LeagueEntity>() {
    override fun loadData(): LiveData<List<LeagueEntity>> {
        return this.listData
    }

}