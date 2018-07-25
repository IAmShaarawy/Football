package net.elshaarawy.football.team

import android.arch.lifecycle.LiveData
import net.elshaarawy.football.bases.BaseViewModel
import net.elshaarawy.football.data.room.entities.FixtureEntity

/**
 * Created by elshaarawy on 7/25/18.
 */
class TeamViewModel(private val teamId: Long) : BaseViewModel<FixtureEntity>() {
    override fun loadData(): LiveData<List<FixtureEntity>> {
        return this.listData
    }

}