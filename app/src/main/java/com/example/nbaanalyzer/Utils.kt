package com.example.nbaanalyzer

import com.example.nbaanalyzer.models.Player
import com.example.nbaanalyzer.models.Team

class Utils{

    var easternTeams: ArrayList<Team> = ArrayList()
    var westernTeams: ArrayList<Team> = ArrayList()
    var playersStatistics: ArrayList<Player> = ArrayList()
    var easternId: ArrayList<Int> = arrayListOf(1610612738, 1610612741, 1610612737, 1610612751,
                                                1610612739, 1610612766, 1610612752, 1610612765,
                                                1610612748, 1610612755, 1610612754, 1610612753,
                                                1610612761, 1610612749, 1610612764)
    var westernId: ArrayList<Int> = arrayListOf(1610612742, 1610612743, 1610612744, 1610612745,
                                                1610612750, 1610612746, 1610612763, 1610612757,
                                                1610612747, 1610612740, 1610612760, 1610612760,
                                                1610612756, 1610612759, 1610612762, 1610612758)

    init {
        easternTeams.add(Team(1610612738, R.drawable.ic_boston_celtics, "Boston Celtics"))
        easternTeams.add(Team(1610612741, R.drawable.ic_chicago_bulls, "Chicago Bulls"))
        easternTeams.add(Team(1610612737, R.drawable.ic_atlanta_hawks, "Atlanta Hawks"))
        easternTeams.add(Team(1610612751, R.drawable.ic_brooklyn_nets, "Brooklyn Nets"))
        easternTeams.add(Team(1610612739, R.drawable.ic_cleveland_cavaliers, "Cleveland Cavaliers"))
        easternTeams.add(Team(1610612766, R.drawable.ic_charlotte_hornets, "Charlotte Hornets"))
        easternTeams.add(Team(1610612752, R.drawable.ic_new_york_knicks, "New York Nicks"))
        easternTeams.add(Team(1610612765, R.drawable.ic_detroit_pistons, "Detroit Pistons"))
        easternTeams.add(Team(1610612748, R.drawable.ic_miami_heat_logo, "Miami Heats"))
        easternTeams.add(Team(1610612755, R.drawable.ic_philadelphia_76ers, "Philadelphia 76es"))
        easternTeams.add(Team(1610612754, R.drawable.ic_indiana_pacers, "Indiana Pacers"))
        easternTeams.add(Team(1610612753, R.drawable.ic_orlando_magic, "Orlando Magics"))
        easternTeams.add(Team(1610612761, R.drawable.ic_toronto_raptors, "Toronto Raptors"))
        easternTeams.add(Team(1610612749, R.drawable.ic_milwaukee_bucks, "Milwaukee Bucks"))
        easternTeams.add(Team(1610612764, R.drawable.ic_washington_wizards, "Washington Wizards"))

        westernTeams.add(Team(1610612742, R.drawable.ic_dallas_mavericks, "Dallas Mavericks"))
        westernTeams.add(Team(1610612743, R.drawable.ic_denver_nuggets, "Denver Nuggets"))
        westernTeams.add(Team(1610612744, R.drawable.ic_golden_state_warriors, "Golden State Warriors"))
        westernTeams.add(Team(1610612745, R.drawable.ic_houston_rockets, "Houston Rockets"))
        westernTeams.add(Team(1610612750, R.drawable.ic_minnesota_timberwolves, "Minnesota Timberwolves"))
        westernTeams.add(Team(1610612746, R.drawable.ic_la_clippers, "Los Ángeles Clippers"))
        westernTeams.add(Team(1610612763, R.drawable.ic_memphis_grizzlies, "Memphis Grizzlies"))
        westernTeams.add(Team(1610612757, R.drawable.ic_portland_trail_blazers, "Portland Trail Blazers"))
        westernTeams.add(Team(1610612747, R.drawable.ic_la_lakers, "Los Ángeles Lakers"))
        westernTeams.add(Team(1610612740, R.drawable.ic_new_orleans_pelicans, "New Orleans Pelicans"))
        westernTeams.add(Team(1610612760, R.drawable.ic_oklahoma_city_thunder, "Oklahoma City Thunder"))
        westernTeams.add(Team(1610612756, R.drawable.ic_phoenix_suns, "Phoenix Suns"))
        westernTeams.add(Team(1610612759, R.drawable.ic_san_antonio_spurs, "San Antonio Spurs"))
        westernTeams.add(Team(1610612762, R.drawable.ic_utah_jazz_logo, "Utah Jazz"))
        westernTeams.add(Team(1610612758, R.drawable.ic_sacramento_kings, "Sacramento Kings"))

        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))
        playersStatistics.add(Player(1, "Michael Jordan", "SG", 89,34.3, 30.21, 4.5, 10.2, 0.56, 2.18, 10.3, 16.43, 0.53, 5.32, 7.37, 0.60, 0.12, 13.21, 23.4, 0.67, 0.53, 10.3, 11.3, 0.90))

    }

    // TODO: Change logic to query the id to the database and take the team
    fun getTeamById(id: Int): String {
        var teamFounded = false
        var name= ""
        var counter = 0
        if (id in easternId) {
            while (!teamFounded and (counter < easternTeams.size)) {
                if (easternTeams[counter].teamId == id) {
                    teamFounded = true
                    name = easternTeams[counter].teamName
                }
                counter++
            }
        } else if (id in westernId) {
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

