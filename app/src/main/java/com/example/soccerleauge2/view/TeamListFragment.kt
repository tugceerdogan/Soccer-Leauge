package com.example.soccerleauge2.view

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soccerleauge2.R
import com.example.soccerleauge2.adapter.TeamAdapter
import com.example.soccerleauge2.viewmodel.TeamListFragmentViewModel
import kotlinx.android.synthetic.main.fragment_team_list.*



class TeamListFragment : Fragment() {

    private lateinit var viewModel : TeamListFragmentViewModel
    private val recyclerTeamAdapter = TeamAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_list, container, false)

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProviders.of(this).get(TeamListFragmentViewModel::class.java)
        viewModel.refreshData()


       maclaraGit_Button.setOnClickListener {

           requireActivity().run {
               startActivity(Intent(this, MatchActivity::class.java))

               overridePendingTransition(R.anim.sag_iceri,R.anim.sol_disari)

           }
       }

        btn_switch.setOnClickListener {
            when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Configuration.UI_MODE_NIGHT_NO ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }



        teamList_recyclerView.layoutManager = LinearLayoutManager(context)
        teamList_recyclerView.adapter = recyclerTeamAdapter


        swipeRefreshLayout2.setOnRefreshListener{

            takimYukleniyor.visibility = View.VISIBLE
            teamHataMesaji.visibility = View.GONE
            teamList_recyclerView.visibility = View.GONE
            viewModel.refreshFromInternet()
            swipeRefreshLayout2.isRefreshing = false

        }

        observeLiveData()

    }

        fun observeLiveData(){

            viewModel.teams.observe(viewLifecycleOwner, Observer {teams ->
                teams?.let{
                    teamList_recyclerView.visibility = View.VISIBLE
                    recyclerTeamAdapter.teamListUpdate(teams)

                }
            })

            viewModel.teamHataMesaji.observe(viewLifecycleOwner,Observer {hata->
                hata?.let{
                    if(it){
                        teamHataMesaji.visibility =View.VISIBLE
                        teamList_recyclerView.visibility = View.GONE
                    }else{
                        teamHataMesaji.visibility =View.GONE
                    }
                }

            })

            viewModel.takimYukleniyor.observe(viewLifecycleOwner,Observer { yukleniyor->
                yukleniyor?.let{
                    if(it){

                        teamList_recyclerView.visibility = View.GONE
                        teamHataMesaji.visibility = View.GONE
                        takimYukleniyor.visibility=View.VISIBLE

                    }else{
                        takimYukleniyor.visibility = View.GONE
                    }
                }

            })

        }
    }


