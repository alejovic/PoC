package shorts.v4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.
 * <p>
 * The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position,
 * we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
 * <p>
 * You are given an array of strings votes which is the votes of all voters in the ranking systems.
 * Sort all teams according to the ranking system described above.
 * <p>
 * Return a string of all teams sorted by the ranking system.
 * Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
 * Output: "ACB"
 * Explanation:
 * Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
 * Team B was ranked second by 2 voters and ranked third by 3 voters.
 * Team C was ranked second by 3 voters and ranked third by 2 voters.
 * As most of the voters ranked C second, team C is the second team, and team B is the third.
 */
public class TeamRanking {
    public String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) return "";

        int numTeams = votes[0].length();
        Map<Character, int[]> voteCounts = new HashMap<>();

        // Initialize vote counts
        for (char team : votes[0].toCharArray()) {
            voteCounts.put(team, new int[numTeams]);
        }

        // Count votes
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char team = vote.charAt(i);
                voteCounts.get(team)[i]++;
            }
        }

        // Sort teams
        List<Character> teams = new ArrayList<>(voteCounts.keySet());
        teams.sort((a, b) -> {
            for (int i = 0; i < numTeams; i++) {
                if (voteCounts.get(a)[i] != voteCounts.get(b)[i]) {
                    return voteCounts.get(b)[i] - voteCounts.get(a)[i];
                }
            }
            return a - b;
        });

        // Build result string
        StringBuilder result = new StringBuilder();
        for (char team : teams) {
            result.append(team);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        TeamRanking ranking = new TeamRanking();
        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        System.out.println("Ranked Teams: " + ranking.rankTeams(votes)); // Output: "ACB"

        String[] votes1 = {"WXYZ","XYZW"};
        System.out.println("Ranked Teams: " + ranking.rankTeams(votes1)); // Output: XWYZ"

        String[] votes2 = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        System.out.println("Ranked Teams: " + ranking.rankTeams(votes2)); // Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
    }
}
