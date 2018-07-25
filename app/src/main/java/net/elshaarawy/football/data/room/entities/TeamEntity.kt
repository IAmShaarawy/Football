package net.elshaarawy.football.data.room.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by elshaarawy on 7/25/18.
 */
const val TEAMS_TABLE = "teams_table"
const val TEAM_ID = "team_id"

@Entity(tableName = TEAMS_TABLE)
data class TeamEntity(
        @ColumnInfo(name = TEAM_ID)
        @PrimaryKey(autoGenerate = true)
        val id: Int,

        @SerializedName("name")
        val name: String?,

        @SerializedName("code")
        val code: String?,

        @SerializedName("shortName")
        val shortName: String?,

        @SerializedName("squadMarketValue")
        val squadMarketValue: String?,

        @SerializedName("crestUrl")
        val crestUrl: String?,

        @SerializedName("_links")
        @Embedded(prefix = "team")
        val links: TeamLinks
)

data class TeamLinks(
        @SerializedName("fixtures")
        @Embedded(prefix = "fixtures")
        val fixtures: TeamFixtures
)

data class TeamFixtures(
        @SerializedName("href")
        val href: String
)