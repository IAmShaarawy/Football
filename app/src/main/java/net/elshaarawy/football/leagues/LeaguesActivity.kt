package net.elshaarawy.football.leagues

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.elshaarawy.football.R
import net.elshaarawy.football.data.room.FootballDatabase

class LeaguesActivity : AppCompatActivity() {

    lateinit var leaguesViewModel: LeaguesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leagues)
        leaguesViewModel = ViewModelProviders.of(this).get(LeaguesViewModel::class.java)
    }
}
