package com.example.soccerleauge2.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.soccerleauge2.model.Team
import com.example.soccerleauge2.services.TeamAPIService
import com.example.soccerleauge2.services.TeamDatabase
import com.example.soccerleauge2.util.OzelSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class TeamListFragmentViewModel(application : Application) : BaseViewModel(application) {

    val teams = MutableLiveData<List<Team>>()
    val teamHataMesaji = MutableLiveData<Boolean>()
    val takimYukleniyor = MutableLiveData<Boolean>()

    private var guncellemeZamani = 10 * 60 * 1000 * 1000 * 1000L

    private val teamApiService = TeamAPIService()
    private val disposable = CompositeDisposable()
    private val ozelSharedPreferences = OzelSharedPreferences(getApplication())


    fun refreshData(){

        val kaydedilmeZamani = ozelSharedPreferences.zamaniAl()
        if(kaydedilmeZamani != null && kaydedilmeZamani != 0L && System.nanoTime()-kaydedilmeZamani < guncellemeZamani ){
            verileriSQLitedanAL()
        }else{
            verileriInternettenAl()
        }

    }

    fun refreshFromInternet(){
        verileriInternettenAl()
    }

    private fun verileriSQLitedanAL(){

        launch{

            val liste= TeamDatabase(getApplication()).teamDao().getAllTeam()
            takimlariGoster(liste)
        }
    }

    private fun verileriInternettenAl(){
        takimYukleniyor.value = true

        disposable.add(
                teamApiService.getData()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<List<Team>>(){
                            override fun onSuccess(t: List<Team>) {

                                sqliteSakla(t)

                            }

                            override fun onError(e: Throwable) {

                                teamHataMesaji.value = true
                                takimYukleniyor.value=false
                            }


                        })
        )
    }

    private fun takimlariGoster(takimlarListesi : List<Team>){
        teams.value = takimlarListesi
        teamHataMesaji.value = false
        takimYukleniyor.value = false
    }

    private fun sqliteSakla(teamListesi: List<Team>){

        launch{

            val dao = TeamDatabase(getApplication()).teamDao()
            dao.deleteAllTeam()

            val uuidListesi = dao.insertAll(*teamListesi.toTypedArray())
            var i =0

            while(i<teamListesi.size){
                teamListesi[i].uuid = uuidListesi[i].toInt()
                i=i+1
            }

            takimlariGoster(teamListesi)
        }

        ozelSharedPreferences.zamaniKaydet(System.nanoTime())
    }

}