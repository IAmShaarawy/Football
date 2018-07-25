package net.elshaarawy.football.data.room.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.net.Uri
import com.google.gson.annotations.SerializedName

/**
 * Created by elshaarawy on 7/25/18.
 */
const val FIXTURE_TABLE = "fixture_table"
const val FIXTURE_ID = "fixture_id"
const val FIXTURE_TEAM_ID = "fixture_team_id"

@Entity(tableName = FIXTURE_TABLE)
data class FixtureEntity(

        @SerializedName("fixture")
        @Embedded(prefix = "fixture")
        val fixtureLinks: FixtureLinks,

        @ColumnInfo(name = FIXTURE_ID)
        @PrimaryKey()
        val id: Long = fixtureLinks.self.retrieveId(),

        @ColumnInfo(name = FIXTURE_TEAM_ID)
        var teamId: Long = 0,

        @SerializedName("date")
        val date: String?,

        @SerializedName("status")
        val status: String?,

        @SerializedName("homeTeamName")
        val homeTeamName: String?,

        @SerializedName("awayTeamName")
        val awayTeamName: String?

        )

data class FixtureLinks(
        @SerializedName("homeTeam")
        @Embedded(prefix = "homeTeam")
        val homeTeamName: HomeTeam,

        @SerializedName("awayTeam")
        @Embedded(prefix = "awayTeam")
        val awayTeam: AwayTeam,

        @SerializedName("self")
        @Embedded(prefix = "self")
        val self: FixtureSelf
)

data class FixtureSelf(
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

data class HomeTeam(
        @SerializedName("href")
        val href: String
)

data class AwayTeam(
        @SerializedName("href")
        val href: String
)