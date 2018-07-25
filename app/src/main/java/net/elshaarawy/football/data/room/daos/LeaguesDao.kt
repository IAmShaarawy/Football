package net.elshaarawy.football.data.room.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import net.elshaarawy.football.data.room.entities.LeagueEntity

/**
 * Created by elshaarawy on 7/25/18.
 */
@Dao
interface LeaguesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLeagues(leagues: List<LeagueEntity>)

    @Query("SELECT * FROM leagues_table")
    fun retrieveAllLeagues(): Single<List<LeagueEntity>>

}