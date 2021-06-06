package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {
    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        HashMap<String, Integer> scoreBoard = new HashMap<>();
        for (int i = 0, resultsSize = results.size(); i < resultsSize; i++) {
            Integer res = results.get(i);
            ArrayList<String> competition = competitions.get(i);
            if (res.equals(1)) {
                String homeTeam = competition.get(0);
                scoreBoard.put(homeTeam, scoreBoard.getOrDefault(homeTeam, 0) + 3);
            } else {
                String awayTeam = competition.get(1);
                scoreBoard.put(awayTeam, scoreBoard.getOrDefault(awayTeam, 0) + 3);
            }

        }
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : scoreBoard.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> teams=new ArrayList<>();
        ArrayList<String> team=new ArrayList<>();
        team.add("HTML");
        team.add("C#");
        teams.add(team);
        team=new ArrayList<>();
        team.add("C#");
        team.add("Python");
        teams.add(team);
        team=new ArrayList<>();
        team.add("Python");
        team.add("HTML");
        teams.add(team);
        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);
        System.out.println(new TournamentWinner().tournamentWinner(teams,results));
    }
}
