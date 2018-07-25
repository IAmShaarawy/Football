package net.elshaarawy.football.data.room.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.net.Uri
import com.google.gson.annotations.SerializedName
import java.net.URI

/**
 * Created by elshaarawy on 7/25/18.
 */
const val TEAMS_TABLE = "teams_table"
const val TEAM_ID = "team_id"
const val TEAM_LEAGUE_ID = "team_league_id"

@Entity(tableName = TEAMS_TABLE)
data class TeamEntity(

        @SerializedName("_links")
        @Embedded(prefix = "team")
        val links: TeamLinks,

        @ColumnInfo(name = TEAM_ID)
        @PrimaryKey()
        val id: Long = links.self.retrieveId(),

        @ColumnInfo(name = TEAM_LEAGUE_ID)
        var leagueId: Long = 0,

        @SerializedName("name")
        val name: String?,

        @SerializedName("code")
        val code: String?,

        @SerializedName("shortName")
        val shortName: String?,

        @SerializedName("squadMarketValue")
        val squadMarketValue: String?,

        @SerializedName("crestUrl")
        val crestUrl: String?
)

data class TeamLinks(
        @SerializedName("fixtures")
        @Embedded(prefix = "fixtures")
        val fixtures: TeamFixtures,

        @SerializedName("self")
        @Embedded(prefix = "self")
        val self: TeamSelf
)

data class TeamSelf(
        @SerializedName("href")
        val href: String
) {
    fun retrieveId(): Long {
        return Uri.parse(href)
                .pathSegments
                .last()
                .toLong()
    }
}

data class TeamFixtures(
        @SerializedName("href")
        val href: String
)