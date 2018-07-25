package net.elshaarawy.football.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import net.elshaarawy.football.data.room.entities.FixtureEntity
import net.elshaarawy.football.data.room.entities.LeagueEntity
import net.elshaarawy.football.data.room.entities.TeamEntity

/**
 * Created by elshaarawy on 7/25/18.
 */
const val DATABASE_NAME = "FootballDatabase"

@Database(version = 1, exportSchema = false,
        entities = arrayOf(LeagueEntity::class, TeamEntity::class, FixtureEntity::class))
private abstract class FootballDatabase : RoomDatabase() {

    companion object {
        private var footballDatabase: FootballDatabase? = null

        /*we must call fallbackToDestructiveMigration from the builder
        to make migration from old schema to the new one smoothly*/
        @Synchronized
        fun getInstance(context: Context): FootballDatabase = footballDatabase
                ?: Room.databaseBuilder(context, FootballDatabase::class.java, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build().also { footballDatabase = it }

    }
}

