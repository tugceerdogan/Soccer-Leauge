package com.example.soccerleauge2.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleauge2.R
import com.example.soccerleauge2.model.Match

internal class MatchesAdapter(private var matchList: List<Match>) :
        RecyclerView.Adapter<MatchesAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var team1: TextView = view.findViewById(R.id.team1)
        var team2: TextView = view.findViewById(R.id.team2)
        var team3: TextView = view.findViewById(R.id.team3)
        var team4: TextView = view.findViewById(R.id.team4)
        var team5: TextView = view.findViewById(R.id.team5)
        var team6: TextView = view.findViewById(R.id.team6)
        var team7: TextView = view.findViewById(R.id.team7)
        var team8: TextView = view.findViewById(R.id.team8)
        var team9: TextView = view.findViewById(R.id.team9)
        var team10: TextView = view.findViewById(R.id.team10)

    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.match_list, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val match = matchList[position]
        holder.title.text = match.getTitle()
        holder.team1.text = match.team1()
        holder.team2.text = match.team2()
        holder.team3.text = match.team3()
        holder.team4.text = match.team4()
        holder.team5.text = match.team5()
        holder.team6.text = match.team6()
        holder.team7.text = match.team7()
        holder.team8.text = match.team8()
        holder.team9.text = match.team9()
        holder.team10.text = match.team10()
    }
    override fun getItemCount(): Int {
        return matchList.size
    }
}