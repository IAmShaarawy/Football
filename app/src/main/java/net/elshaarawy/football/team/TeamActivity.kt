package net.elshaarawy.football.team

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.elshaarawy.football.FootballApp
import net.elshaarawy.football.R
import net.elshaarawy.football.data.room.entities.LEAGUE_ID
import net.elshaarawy.football.teams.TeamsActivity

class TeamActivity : AppCompatActivity() {

    lateinit var teamViewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        val teamId: Long = 5
        teamViewModel = ViewModelProviders.of(this, TeamViewModelFactory(teamId))
                .get(TeamViewModel::class.java)
    }


    companion object {
        private const val TEAM_ID = "team_id"
        private const val TITLE = "title"
        fun startMe(teamId: Long,title:String?) {
            Intent().apply {
                setClass(FootballApp.context(), TeamActivity::class.java)
                putExtra(TEAM_ID, teamId)
                putExtra(TITLE,title)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }.also { FootballApp.context().startActivity(it) }

        }
    }
}
