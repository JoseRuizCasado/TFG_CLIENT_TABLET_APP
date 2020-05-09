package com.example.nbaanalyzer

import com.example.nbaanalyzer.models.Team

class Utils{
    var easternTeams: ArrayList<Team> = ArrayList()
    var westernTeams: ArrayList<Team> = ArrayList()
    init {
        easternTeams.add(Team(1, 1, "Boston Celtics"))
        easternTeams.add(Team(6, 6, "Chicago Bulls"))
        easternTeams.add(Team(11, 11, "Atlanta Hawks"))
        easternTeams.add(Team(2, 2, "Brooklyn Nets"))
        easternTeams.add(Team(7, 7, "Cleveland Cavaliers"))
        easternTeams.add(Team(12, 12, "Charlotte Hornets"))
        easternTeams.add(Team(3, 3, "New York Nicks"))
        easternTeams.add(Team(8, 8, "Detroit Pistons"))
        easternTeams.add(Team(13, 13, "Miami Heats"))
        easternTeams.add(Team(4, 4, "Philadelphia 76es"))
        easternTeams.add(Team(9, 9, "Indiana Pacers"))
        easternTeams.add(Team(14, 14, "Orlando Magics"))
        easternTeams.add(Team(5, 5, "Toronto Raptors"))
        easternTeams.add(Team(10, 10, "Milwaukee Bucks"))
        easternTeams.add(Team(15, 15, "Washington Wizards"))
        westernTeams.add(Team(16, 16, "Dallas Mavericks"))
        westernTeams.add(Team(17, 17, "Denver Nuggets"))
        westernTeams.add(Team(18, 18, "Golden State Warriors"))
        westernTeams.add(Team(19, 19, "Houston Rockets"))
        westernTeams.add(Team(20, 20, "Minnesota Timberwolves"))
        westernTeams.add(Team(21, 21, "Los Ángeles Clippers"))
        westernTeams.add(Team(22, 22, "Memphis Grizzlies"))
        westernTeams.add(Team(23, 23, "Portland Trail Blazers"))
        westernTeams.add(Team(24, 24, "Los Ángeles Lakers"))
        westernTeams.add(Team(25, 25, "New Orleans Pelicans"))
        westernTeams.add(Team(26, 26, "Oklahoma City Thunder"))
        westernTeams.add(Team(27, 27, "Phoenix Suns"))
        westernTeams.add(Team(28, 28, "San Antonio Spurs"))
        westernTeams.add(Team(29, 29, "Utah Jazz"))
        westernTeams.add(Team(30, 30, "Sacramento Kings"))

    }

    // TODO: Change logic to query the id to the database and take the team
    fun getTeamById(id: Int): String {
        var teamFounded = false
        var name: String = ""
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

