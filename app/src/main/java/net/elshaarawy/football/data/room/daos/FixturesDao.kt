package net.elshaarawy.football.data.room.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import net.elshaarawy.football.data.room.entities.FixtureEntity

/**
 * Created by elshaarawy on 7/25/18.
 */
@Dao
interface FixturesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllFixture(leagues: List<FixtureEntity>)

    @Query("SELECT * FROM fixture_table WHERE fixture_team_id == :teamId")
    fun retrieveTeamFixtures(teamId:Long): Single<List<FixtureEntity>>
}