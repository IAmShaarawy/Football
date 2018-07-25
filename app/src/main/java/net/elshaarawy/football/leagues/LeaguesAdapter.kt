package net.elshaarawy.football.leagues

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_league.view.*
import net.elshaarawy.football.R
import net.elshaarawy.football.data.room.entities.LeagueEntity
import net.elshaarawy.football.teams.TeamsActivity

/**
 * Created by elshaarawy on 7/25/18.
 */
class LeaguesAdapter(private var leagues: List<LeagueEntity> = listOf()) : RecyclerView.Adapter<LeaguesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaguesViewHolder {
        val item = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_league, parent, false)
        return LeaguesViewHolder(item)
    }

    override fun getItemCount(): Int {
        return leagues.size
    }

    override fun onBindViewHolder(holder: LeaguesViewHolder, position: Int) {
        holder.bindData(leagues[position])
    }

    fun onDataChange(newLeagues: List<LeagueEntity>?) {
        apply {
            leagues = newLeagues?: listOf()
            notifyDataSetChanged()
        }
    }
}

class LeaguesViewHolder(private val item: View) : RecyclerView.ViewHolder(item) {
    fun bindData(data: LeagueEntity) {
        with(item) {
            league_title.text = data.league
            league_year.text = data.year
            league_caption.text = data.caption
            league_played.text = "${data.currentMatchDay}/${data.numberOfMatchDays}"
            league_games.text = data.numberOfGames.toString()
            league_teams.text = data.numberOfTeams.toString()
            setOnClickListener { TeamsActivity.startMe(data.id) }
        }
    }
}