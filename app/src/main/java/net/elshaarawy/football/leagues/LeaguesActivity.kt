package net.elshaarawy.football.leagues

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_leagues.*
import net.elshaarawy.football.R

class LeaguesActivity : AppCompatActivity() {

    lateinit var leaguesViewModel: LeaguesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leagues)
        leaguesViewModel = ViewModelProviders.of(this).get(LeaguesViewModel::class.java)

        if (league_rv != null) {
            league_rv.layoutManager = GridLayoutManager(this, 1)
        } else {
            league_rv_land.layoutManager = GridLayoutManager(this, 2)
        }
    }
}
