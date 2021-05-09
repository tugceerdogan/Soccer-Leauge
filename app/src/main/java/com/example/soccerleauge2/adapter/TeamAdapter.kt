package com.example.soccerleauge2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleauge2.R
import com.example.soccerleauge2.model.Team
import com.example.soccerleauge2.util.gorselIndir
import com.example.soccerleauge2.util.placeholderYap
import kotlinx.android.synthetic.main.team_recycler_row.view.*

class TeamAdapter(val teamList : ArrayList<Team>) :  RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }
 //row bağlama işi : (inflater yapıypr)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
     val inflater = LayoutInflater.from(parent.context)
     val view = inflater.inflate(R.layout.team_recycler_row,parent,false)
     return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {

        holder.itemView.team_textView.text = teamList.get(position).takimAdi
        holder.itemView.team_imageView.gorselIndir(teamList.get(position).takimGorsel, placeholderYap(holder.itemView.context))


    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    fun teamListUpdate(newTeamList : List<Team>){
        teamList.clear()
        teamList.addAll(newTeamList)
        notifyDataSetChanged()

    }

    


}
