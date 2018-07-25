package net.elshaarawy.football.data.room.models

import com.google.gson.annotations.SerializedName
import net.elshaarawy.football.data.room.entities.FixtureEntity

/**
 * Created by elshaarawy on 7/25/18.
 */
data class FixturesResponse(@SerializedName("fixtures") val fixturesList: List<FixtureEntity>)