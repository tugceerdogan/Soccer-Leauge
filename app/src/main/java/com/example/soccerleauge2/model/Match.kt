package com.example.soccerleauge2.model

class Match(title: String?, team1: String?, team2: String?, team3: String?, team4: String?, team5: String?
            , team6: String?, team7: String?, team8: String?, team9: String?, team10: String?) {
    private var title: String
    private var team1: String
    private var team2: String
    private var team3: String
    private var team4: String
    private var team5: String
    private var team6: String
    private var team7: String
    private var team8: String
    private var team9: String
    private var team10: String


    init {
        this.title = title!!
        this.team1 = team1!!
        this.team2 = team2!!
        this.team3 = team3!!
        this.team4 = team4!!
        this.team5 = team5!!
        this.team6 = team6!!
        this.team7 = team7!!
        this.team8 = team8!!
        this.team9 = team9!!
        this.team10 = team10!!

    }
    fun getTitle(): String? {
        return title
    }

    fun team1(): String? {
        return team1
    }

    fun team2(): String? {
        return team2
    }
    fun team3(): String? {
        return team3
    }
    fun team4(): String? {
        return team4
    }
    fun team5(): String? {
        return team5
    }
    fun team6(): String? {
        return team6
    }
    fun team7(): String? {
        return team7
    }
    fun team8(): String? {
        return team8
    }
    fun team9(): String? {
        return team9
    }
    fun team10(): String? {
        return team10
    }

}