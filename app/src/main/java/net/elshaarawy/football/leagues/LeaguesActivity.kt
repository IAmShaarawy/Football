package net.elshaarawy.football.leagues

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_leagues.*
import net.elshaarawy.football.R

class LeaguesActivity : AppCompatActivity() {

    lateinit var leaguesViewModel: LeaguesViewModel
    val leaguesAdapter by lazy { LeaguesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leagues)
        leaguesViewModel = ViewModelProviders.of(this).get(LeaguesViewModel::class.java)


        leaguesViewModel.loadData()
                .observe(this, Observer(leaguesAdapter::onDataChange))

        if (league_rv != null) {
            league_rv.let {
                it.layoutManager = GridLayoutManager(this, 1)
                it.adapter = leaguesAdapter
            }

        } else {
            league_rv_land.let {
                it.layoutManager = GridLayoutManager(this, 2)
                it.adapter = leaguesAdapter
            }
        }
    }
}
