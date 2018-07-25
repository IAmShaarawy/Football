package net.elshaarawy.football.teams

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_leagues.*
import kotlinx.android.synthetic.main.activity_teams.*
import net.elshaarawy.football.FootballApp
import net.elshaarawy.football.R

class TeamsActivity : AppCompatActivity() {

    private lateinit var teamsViewModel: TeamsViewModel
    private val leaguesAdapter by lazy { TeamsAdapter() }
    private var isFirstTime = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        apply {
            setContentView(R.layout.activity_teams)
            setTitle(intent.getStringExtra(TITLE))
        }

        teamsViewModel = ViewModelProviders.of(this,
                TeamsViewModelFactory(intent.getLongExtra(LEAGUE_ID, 0)))
                .get(TeamsViewModel::class.java)
                .let {
                    it.listData
                            .observe(this, Observer(leaguesAdapter::onDataChange))
                    it.loadingSubject
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe { teams_refresh.isRefreshing = it }
                    it
                }

        teams_refresh.setOnRefreshListener { teamsViewModel.loadData() }

        isFirstTime.takeIf { true }
                .apply { teamsViewModel.loadData() }
                .also { isFirstTime = false }


        if (teams_rv != null) bindPortrait() else bindLandscape()
    }

    private fun bindPortrait() {
        teams_rv.let {
            it.layoutManager = GridLayoutManager(this, 1)
            it.adapter = leaguesAdapter
        }
    }

    private fun bindLandscape() {
        teams_rv_land.let {
            it.layoutManager = GridLayoutManager(this, 2)
            it.adapter = leaguesAdapter
        }
    }

    companion object {
        private const val LEAGUE_ID = "league_id"
        private const val TITLE = "title"
        fun startMe(leagueId: Long, title: String?) {
            Intent().apply {
                setClass(FootballApp.context(), TeamsActivity::class.java)
                putExtra(LEAGUE_ID, leagueId)
                putExtra(TITLE, title)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }.also { FootballApp.context().startActivity(it) }

        }
    }
}
