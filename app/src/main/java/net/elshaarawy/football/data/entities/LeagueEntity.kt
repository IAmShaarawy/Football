package net.elshaarawy.football.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Created by elshaarawy on 7/25/18.
 */
const val LEAGUES_TABLE = "leagues_table"
const val LEAGUE_ID = "leagues_id"

@Entity(tableName = LEAGUES_TABLE)
data class LeagueEntity(
        @SerializedName("id")
        @ColumnInfo(name = LEAGUE_ID)
        @PrimaryKey
        val id: Long,

        @SerializedName("caption")
        val caption: String?,

        @SerializedName("league")
        val league: String?,

        @SerializedName("year")
        val year: String?,

        @SerializedName("currentMatchday")
        val currentMatchDay: Int?,

        @SerializedName("numberOfMatchdays")
        val numberOfMatchDays: Int?,

        @SerializedName("numberOfTeams")
        val numberOfTeams: Int?,

        @SerializedName("numberOfGames")
        val numberOfGames: Int?
)