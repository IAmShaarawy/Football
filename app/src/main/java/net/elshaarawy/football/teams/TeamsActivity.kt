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

        apply {
            setContentView(R.layout.activity_teams)
            setTitle(intent.getStringExtra(TITLE))
        }

        teamsViewModel = ViewModelProviders.of(this, TeamsViewModelFactory(intent.getLongExtra(LEAGUE_ID,0)))
                .get(TeamsViewModel::class.java)


    }

    companion object {
        private const val LEAGUE_ID = "league_id"
        private const val TITLE = "title"
        fun startMe(leagueId: Long,title:String?) {
            Intent().apply {
                setClass(FootballApp.context(), TeamsActivity::class.java)
                putExtra(LEAGUE_ID, leagueId)
                putExtra(TITLE,title)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }.also { FootballApp.context().startActivity(it) }

        }
    }
}
