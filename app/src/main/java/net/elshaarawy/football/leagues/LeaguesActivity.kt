package net.elshaarawy.football.leagues

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_leagues.*
import net.elshaarawy.football.R

class LeaguesActivity : AppCompatActivity() {

    lateinit var leaguesViewModel: LeaguesViewModel
    val leaguesAdapter by lazy { LeaguesAdapter() }
    var isFirstTime = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_leagues)

        leaguesViewModel = ViewModelProviders.of(this).get(LeaguesViewModel::class.java)

        leaguesViewModel.listData
                .observe(this, Observer(leaguesAdapter::onDataChange))
        leaguesViewModel.loadingSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { league_refresh.isRefreshing = it }

        league_refresh.setOnRefreshListener { leaguesViewModel.loadData() }

        isFirstTime.takeIf { true }
                .apply { leaguesViewModel.loadData() }
                .also { isFirstTime = false }


        if (league_rv != null) bindPortrait() else bindLandscape()
    }

    private fun bindPortrait() {
        league_rv.let {
            it.layoutManager = GridLayoutManager(this, 1)
            it.adapter = leaguesAdapter
        }
    }

    private fun bindLandscape() {
        league_rv_land.let {
            it.layoutManager = GridLayoutManager(this, 2)
            it.adapter = leaguesAdapter
        }
    }
}
