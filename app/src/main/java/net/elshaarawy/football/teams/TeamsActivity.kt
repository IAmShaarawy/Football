package net.elshaarawy.football.teams

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.elshaarawy.football.R

class TeamsActivity : AppCompatActivity() {

    lateinit var teamsViewModel: TeamsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        val teamId: Long = 5
        teamsViewModel = ViewModelProviders.of(this, TeamsViewModelFactory(teamId))
                .get(TeamsViewModel::class.java)
    }
}
