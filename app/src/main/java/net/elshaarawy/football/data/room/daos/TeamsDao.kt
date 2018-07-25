package net.elshaarawy.football.data.room.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import net.elshaarawy.football.data.room.entities.TeamEntity

/**
 * Created by elshaarawy on 7/25/18.
 */
@Dao
interface TeamsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTeams(leagues: List<TeamEntity>)

    @Query("SELECT * FROM teams_table WHERE team_league_id == :leagueId ")
    fun retrieveLeagueTeams(leagueId: Long): Single<List<TeamEntity>>

    @Query("SELECT crestUrl FROM teams_table WHERE team_id == :team_id ")
    fun retrieveCrestUrlForTeam(teamId: Long): Single<List<TeamEntity>>
}