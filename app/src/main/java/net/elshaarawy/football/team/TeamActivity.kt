package net.elshaarawy.football.team

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.elshaarawy.football.R

class TeamActivity : AppCompatActivity() {

    lateinit var teamViewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        val teamId: Long = 5
        teamViewModel = ViewModelProviders.of(this, TeamViewModelFactory(teamId))
                .get(TeamViewModel::class.java)
    }
}
