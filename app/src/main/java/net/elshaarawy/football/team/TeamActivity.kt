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

        apply{
            setContentView(R.layout.activity_team)
            setTitle(intent.getStringExtra(TITLE))
        }

        teamViewModel = ViewModelProviders.of(this,
                TeamViewModelFactory(intent.getLongExtra(TEAM_ID,0)))
                .get(TeamViewModel::class.java)
//                .let{}
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
