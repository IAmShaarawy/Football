package net.elshaarawy.football.data.room.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by elshaarawy on 7/25/18.
 */
const val FIXTURE_TABLE = "fixture_table"
const val FIXTURE_ID = "fixture_id"

@Entity(tableName = FIXTURE_TABLE)
data class FixtureEntity(
        @ColumnInfo(name = FIXTURE_ID)
        @PrimaryKey(autoGenerate = true)
        val id: Int,

        @SerializedName("date")
        val date: String?,

        @SerializedName("status")
        val status: String?,

        @SerializedName("homeTeamName")
        val homeTeamName: String?,

        @SerializedName("awayTeamName")
        val awayTeamName: String?,

        @SerializedName("fixture")
        @Embedded(prefix = "fixture")
        val fixtureLinks: FixtureLinks
)

data class FixtureLinks(
        @SerializedName("homeTeam")
        @Embedded(prefix = "homeTeam")
        val homeTeamName: HomeTeam,

        @SerializedName("awayTeam")
        @Embedded(prefix = "awayTeam")
        val awayTeam: AwayTeam
)

data class HomeTeam(
        @SerializedName("href")
        val href: String
)

data class AwayTeam(
        @SerializedName("href")
        val href: String
)