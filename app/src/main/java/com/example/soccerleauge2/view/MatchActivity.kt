package com.example.soccerleauge2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerleauge2.R
import com.example.soccerleauge2.adapter.MatchesAdapter
import com.example.soccerleauge2.model.Match

class MatchActivity : AppCompatActivity() {
    private val matchList = ArrayList<Match>()
    private lateinit var matchAdapter: MatchesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        matchAdapter = MatchesAdapter(matchList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = matchAdapter
        prepareMatchData()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)

    }
    private fun prepareMatchData() {
        var match = Match("Previous Week Matches","Green Wave     1","2    Amigos","Bandits      0","2      Big Blues",
                "Aztecs      1","1    Red Foxes","Chippewas    3","4    Black Stars","Sharks      0","0    Fast&Furious")
        matchList.add(match)
        match = Match("Next Week Matches", "Bandits","Big Blues","Green Wave","Red Foxes","Sharks",
                "Chippewas","Fast&Furious","Amigos","Black Stars","Aztecs")
        matchList.add(match)
        matchAdapter.notifyDataSetChanged()
    }
}