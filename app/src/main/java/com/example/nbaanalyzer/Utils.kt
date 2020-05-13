package com.example.nbaanalyzer

import com.example.nbaanalyzer.models.Team

class Utils{
    var easternTeams: ArrayList<Team> = ArrayList()
    var westernTeams: ArrayList<Team> = ArrayList()
    init {
        easternTeams.add(Team(1, R.drawable.ic_boston_celtics, "Boston Celtics"))
        easternTeams.add(Team(6, R.drawable.ic_chicago_bulls, "Chicago Bulls"))
        easternTeams.add(Team(11, R.drawable.ic_atlanta_hawks, "Atlanta Hawks"))
        easternTeams.add(Team(2, R.drawable.ic_brooklyn_nets, "Brooklyn Nets"))
        easternTeams.add(Team(7, R.drawable.ic_cleveland_cavaliers, "Cleveland Cavaliers"))
        easternTeams.add(Team(12, R.drawable.ic_charlotte_hornets, "Charlotte Hornets"))
        easternTeams.add(Team(3, R.drawable.ic_new_york_knicks, "New York Nicks"))
        easternTeams.add(Team(8, R.drawable.ic_detroit_pistons, "Detroit Pistons"))
        easternTeams.add(Team(13, R.drawable.ic_miami_heat_logo, "Miami Heats"))
        easternTeams.add(Team(4, R.drawable.ic_philadelphia_76ers, "Philadelphia 76es"))
        easternTeams.add(Team(9, R.drawable.ic_indiana_pacers, "Indiana Pacers"))
        easternTeams.add(Team(14, R.drawable.ic_orlando_magic, "Orlando Magics"))
        easternTeams.add(Team(5, R.drawable.ic_toronto_raptors, "Toronto Raptors"))
        easternTeams.add(Team(10, R.drawable.ic_milwaukee_bucks, "Milwaukee Bucks"))
        easternTeams.add(Team(15, R.drawable.ic_washington_wizards, "Washington Wizards"))
        westernTeams.add(Team(16, R.drawable.ic_dallas_mavericks, "Dallas Mavericks"))
        westernTeams.add(Team(17, R.drawable.ic_denver_nuggets, "Denver Nuggets"))
        westernTeams.add(Team(18, R.drawable.ic_golden_state_warriors, "Golden State Warriors"))
        westernTeams.add(Team(19, R.drawable.ic_houston_rockets, "Houston Rockets"))
        westernTeams.add(Team(20, R.drawable.ic_minnesota_timberwolves, "Minnesota Timberwolves"))
        westernTeams.add(Team(21, R.drawable.ic_la_clippers, "Los Ángeles Clippers"))
        westernTeams.add(Team(22, R.drawable.ic_memphis_grizzlies, "Memphis Grizzlies"))
        westernTeams.add(Team(23, R.drawable.ic_portland_trail_blazers, "Portland Trail Blazers"))
        westernTeams.add(Team(24, R.drawable.ic_la_lakers, "Los Ángeles Lakers"))
        westernTeams.add(Team(25, R.drawable.ic_new_orleans_pelicans, "New Orleans Pelicans"))
        westernTeams.add(Team(26, R.drawable.ic_oklahoma_city_thunder, "Oklahoma City Thunder"))
        westernTeams.add(Team(27, R.drawable.ic_phoenix_suns, "Phoenix Suns"))
        westernTeams.add(Team(28, R.drawable.ic_san_antonio_spurs, "San Antonio Spurs"))
        westernTeams.add(Team(29, R.drawable.ic_utah_jazz_logo, "Utah Jazz"))
        westernTeams.add(Team(30, R.drawable.ic_sacramento_kings, "Sacramento Kings"))

    }

    // TODO: Change logic to query the id to the database and take the team
    fun getTeamById(id: Int): String {
        var teamFounded = false
        var name= ""
        var counter = 0
        if (id < 16) {
            while (!teamFounded and (counter < easternTeams.size)) {
                if (easternTeams[counter].teamId == id) {
                    teamFounded = true
                    name = easternTeams[counter].teamName
                }
                counter++
            }
        } else {
            while (!teamFounded and (counter < westernTeams.size)) {
                if (westernTeams[counter].teamId == id) {
                    teamFounded = true
                    name = westernTeams[counter].teamName
                }
                counter++
            }
        }
        return name
    }

}

