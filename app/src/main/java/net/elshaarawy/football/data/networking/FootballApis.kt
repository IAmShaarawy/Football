package net.elshaarawy.football.data.networking

import io.reactivex.Observable
import net.elshaarawy.football.data.room.entities.LeagueEntity
import net.elshaarawy.football.data.room.models.FixturesResponse
import net.elshaarawy.football.data.room.models.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by elshaarawy on 7/25/18.
 */
interface FootballApis {
    @GET("competitions")
    fun getLeagues(): Observable<List<LeagueEntity>>

    @GET("competitions/{league_id}/teams")
    fun getLeagueTeams(@Path("league_id") leagueId: Long): Observable<TeamsResponse>

    @GET("teams/{team_id}/fixtures")
    fun getTeamFixtures(@Path("team_id") teamId: Long): Observable<FixturesResponse>

    object footballApis{
        val apis = retrofitManager.networkCall.create(FootballApis::class.java)
    }
}