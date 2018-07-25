package net.elshaarawy.football.teams

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.elshaarawy.football.FootballApp
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

    companion object {
        private const val LEAGUE_ID = "league_id"
        fun startMe(leagueId: Long) {
            with(Intent()) {
                setClass(FootballApp.context(), TeamsActivity::class.java)
                putExtra(LEAGUE_ID, leagueId)
            }.also { FootballApp.context().startActivity(it) }

        }
    }
}
