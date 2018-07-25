package net.elshaarawy.football.data.room.models

import com.google.gson.annotations.SerializedName
import net.elshaarawy.football.data.room.entities.TeamEntity

/**
 * Created by elshaarawy on 7/25/18.
 */
data class TeamsResponse(@SerializedName("teams") val teamsList: List<TeamEntity>)