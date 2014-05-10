//Football (aka Soccer)
//!!! Character encoding of Judge data does not match System default !!!
package vol1.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Problem10194 {
	static BufferedReader br;
	
	static class Team {
		String name;
		int points=0;
		int wins=0;
		int losses=0;
		int ties=0;
		int games=0;
		int goalsScored=0;
		int goalsAgainst=0;
		int goalsDiff=0;
		
		Team (String name) {
			this.name = name;
		}
		public String toString() {
			return name + " " + points+"p, " +
					games + "g " + "("+wins+"-"+ties+"-"+losses+")" + ", " +
					goalsDiff+"gd " + "("+goalsScored+"-"+goalsAgainst+")";
		}
	}
	
	static class RefereeComparator implements Comparator<Team> {
		public int compare(Team team1, Team team2) {
			//return negative difference for descending order
			if (team1.points != team2.points)
				return -(team1.points - team2.points);
			if (team1.wins != team2.wins)
				return -(team1.wins - team2.wins);
			if (team1.goalsDiff != team2.goalsDiff)
				return -(team1.goalsDiff - team2.goalsDiff);
			if (team1.goalsScored != team2.goalsScored)
				return -(team1.goalsScored - team2.goalsScored);
			if (team1.games != team2.games)
				return (team1.games - team2.games);
			
			return team1.name.compareToIgnoreCase(team2.name);
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = getBufferedReader(args, "/input/vol1/sorting/Problem10194");
		PrintWriter cout = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
		
		int numTournaments = Integer.parseInt(br.readLine());
		for (int tournament=0; tournament<numTournaments; tournament++) {
			String tournamentName = br.readLine();
			cout.println(tournamentName);
			
			List<Team> teams = getData();
			Collections.sort(teams, new RefereeComparator());
			
			int rank = 1;
			for (Team team : teams) {
				cout.println(rank + ") " + team.toString());
				rank++;
			}
			
			if (tournament != numTournaments-1) {
				cout.println();
			}
			cout.flush();
		}
	}
	
	private static List<Team> getData() throws Exception {
		HashMap<String, Team> teams = new HashMap<String, Team>();
		int numTeams = Integer.parseInt(br.readLine());
		for (int team=0; team<numTeams; team++) {
			String teamName = br.readLine();
			teams.put(teamName, new Team(teamName));
		}
		
		int numGames = Integer.parseInt(br.readLine());
		for (int game=0; game<numGames; game++) {
			String match = br.readLine();
			String[] results = match.split("[@#]");
			
			Team team1 = teams.get(results[0]);
			int goals1 = Integer.parseInt(results[1]);
			int goals2 = Integer.parseInt(results[2]);
			Team team2 = teams.get(results[3]);
			
			//Update goals
			team1.goalsScored += goals1;
			team1.goalsAgainst += goals2;
			team1.goalsDiff += (goals1-goals2);
			team2.goalsScored += goals2;
			team2.goalsAgainst += goals1;
			team2.goalsDiff += (goals2-goals1);
			
			//Update wins, ties, points
			if (goals1 > goals2) {
				team1.wins++;
				team1.points += 3;
				team2.losses++;
			}
			else if (goals2 > goals1) {
				team2.wins++;
				team2.points += 3;
				team1.losses++;
			}
			else {
				team1.ties++;
				team2.ties++;
				team1.points++;
				team2.points++;
			}
			
			//Update games
			team1.games++;
			team2.games++;
		}
		
		return new ArrayList<Team>(teams.values());
	}
	
	private static BufferedReader getBufferedReader(String[] args, String path) throws Exception {
		Reader stdin;
		if (args.length == 1)
			stdin = new FileReader(args[0] + path);
		else
			stdin = new InputStreamReader(System.in, "ISO-8859-1");
		
		return new BufferedReader(stdin);
	}
}
