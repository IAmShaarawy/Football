package net.elshaarawy.football.teams

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_team.view.*
import net.elshaarawy.football.R
import net.elshaarawy.football.data.networking.loadSVG
import net.elshaarawy.football.data.room.entities.LeagueEntity
import net.elshaarawy.football.data.room.entities.TeamEntity
import net.elshaarawy.football.team.TeamActivity

/**
 * Created by elshaarawy on 7/25/18.
 */
class TeamsAdapter(private var teams: List<TeamEntity> = listOf()) : RecyclerView.Adapter<TeamsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val item = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_team, parent, false)
        return TeamsViewHolder(item)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bindData(teams[position])
    }

    fun onDataChange(newTeams: List<TeamEntity>?) {
        apply {
            teams = newTeams?: listOf()
            notifyDataSetChanged()
        }
    }

}

class TeamsViewHolder(private val item: View) : RecyclerView.ViewHolder(item) {
    fun bindData(data: TeamEntity) {
        with(item) {
            val na = context.getString(R.string.not_available)
            team_crust.loadSVG(data.crestUrl, R.drawable.football_loading, R.drawable.error)
            team_title.text = data.name ?: na
            team_title.requestFocus()
            team_short_name.text = data.shortName ?: na
            team_code.text = data.code ?: na
            team_value.text = data.squadMarketValue ?: na
            setOnClickListener { TeamActivity.startMe(data.id, data.name) }
        }
    }
}