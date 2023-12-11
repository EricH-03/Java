/* BaseballElimination.java
   CSC 226 - Fall 2023
   Assignment 6 - Baseball Elimination Program
   
   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java BaseballElimination
	
   To conveniently test the algorithm with a large input, create a text file
   containing one or more test divisions (in the format described below) and run
   the program with
	java -cp .;algs4.jar BaseballElimination file.txt (Windows)
   or
    java -cp .:algs4.jar BaseballElimination file.txt (Linux or Mac)
   where file.txt is replaced by the name of the text file.
   
   The input consists of an integer representing the number of teams in the division and then
   for each team, the team name (no whitespace), number of wins, number of losses, and a list
   of integers represnting the number of games remaining against each team (in order from the first
   team to the last). That is, the text file looks like:
   
	<number of teams in division>
	<team1_name wins losses games_vs_team1 games_vs_team2 ... games_vs_teamn>
	...
	<teamn_name wins losses games_vs_team1 games_vs_team2 ... games_vs_teamn>

	
   An input file can contain an unlimited number of divisions but all team names are unique, i.e.
   no team can be in more than one division.
*/

import edu.princeton.cs.algs4.*;
import java.util.*;
import java.io.File;

//Do not change the name of the BaseballElimination class
public class BaseballElimination{
	
	// We use an ArrayList to keep track of the eliminated teams.
    public ArrayList<String> eliminated = new ArrayList<String>();
    public int numTeams;
    public String teamNames[];
    public int[] wins;
    public int[] gamesLeft;
    public int[][] gamesRemaining;
	public int sourceCapactiy; 

	/* parseInput(s)
        Parses the input from the given Scanner.
    */
    public void parseInput(Scanner s) {
        numTeams = s.nextInt();
        wins = new int[numTeams];
		teamNames = new String[numTeams];
        gamesLeft = new int[numTeams];
        gamesRemaining = new int[numTeams][numTeams];

        for (int i = 0; i < numTeams; i++) {
            teamNames[i] = s.next();
            wins[i] = s.nextInt();
            gamesLeft[i] = s.nextInt();

            for (int j = 0; j < numTeams; j++) {
                gamesRemaining[i][j] = s.nextInt();
            }
        }
    }
	
	/* createFlowNetwork()
        Creates the flow network
    */
    public FlowNetwork createFlowNetwork(int excludeTeam) {
		int numVertices = ((numTeams-1) * (numTeams - 2) / 2)	+ (numTeams-1) + 2;
		int source = 0;
		int sink = numVertices-1;
		FlowNetwork flowNetwork = new FlowNetwork(numVertices);
		
		if(excludeTeam >= numTeams){
			return flowNetwork;
		}
		
		// Teams -> Sink
		int k = 1;
		for (int i = 0; i < numTeams; i++) {
			if (i == excludeTeam) continue; // Exclude the specified team
			
			int capacity = wins[excludeTeam] + gamesLeft[excludeTeam] - wins[i]; 
			flowNetwork.addEdge(new FlowEdge(k, sink, Math.max(0, capacity))); 
			k++;
		} 
		/** 
		This is done in a little bit of a counter intutive way. By adding these first the team vertices
		first numbering is kept simpler(personally) for attaching the games to teams in the loop below.
		Since the underlying networkflow is practically the same, just numbered differently and we are
		only comparing output anyhow I elected to keep this but wanted to provide some clarity for the 
		markers
		**/
		
		int vertex = sink-1;
		//Source -> Games -> Team
		for (int i = 0; i < numTeams; i++) {
			if(i == excludeTeam) continue; //exclude specficed team since we are assuming they win all 
			
            for (int j = i+1; j < numTeams; j++) {
				 if (j == excludeTeam) continue; // Exclude the specified team

				// connect source to games
				flowNetwork.addEdge(new FlowEdge(source, vertex, gamesRemaining[i][j]));
				sourceCapactiy = sourceCapactiy + gamesRemaining[i][j];
						
				// Connect game vertex to team vertices i and j
				flowNetwork.addEdge(new FlowEdge(vertex, i, Double.POSITIVE_INFINITY));
				flowNetwork.addEdge(new FlowEdge(vertex, j, Double.POSITIVE_INFINITY));
						
				vertex--;
			}
		}
     
        return flowNetwork;
    }
	
	/* isEliminated(teamIndex)
       Checks if a team with the given index is eliminated.
	   Returns true if eliminated, false otherwise
    */
    public boolean isEliminated(int teamIndex) {
		sourceCapactiy = 0;
		FlowNetwork flowNetwork = createFlowNetwork(teamIndex);
        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, 0, flowNetwork.V() - 1);
        double maxFlow = fordFulkerson.value();
		System.out.println(teamNames[teamIndex] + " with max flow of " + maxFlow + " and sourceCapactiy of "  sourceCapactiy);
        return maxFlow < sourceCapactiy;
    }
    
	/* feasibilityCheck(teamIndex)
       Checks if a team with the given index is already eliminated without constructing the flow network.
       Returns true if eliminated, false otherwise.
    */
    public boolean feasibilityCheck(int teamIndex) {
		int maxPossibleWins = wins[teamIndex] + gamesLeft[teamIndex];

        for (int i = 0; i < numTeams; i++) {
			if(i == teamIndex) continue;
            if (maxPossibleWins < wins[i]) {
			System.out.println(teamNames[teamIndex] + " in Fes Check");
				eliminated.add(teamNames[teamIndex]);
				return false;
			}
		}
		return true;
	}
	
	/* BaseballElimination(s)
		Given an input stream connected to a collection of baseball division
		standings we determine for each division which teams have been eliminated 
		from the playoffs. For each team in each division we create a flow network
		and determine the maxflow in that network. If the maxflow exceeds the number
		of inter-divisional games between all other teams in the division, the current
		team is eliminated.
	*/
	public BaseballElimination(Scanner s){
		parseInput(s);
		
		for(int i = 0; i < numTeams; i++){
			if(!feasibilityCheck(i)) continue;
			
			if(isEliminated(i)){
				eliminated.add(teamNames[i]);
			}
		}
	}
		
	/* main()
	   Contains code to test the BaseballElimantion function. You may modify the
	   testing code if needed, but nothing in this function will be considered
	   during marking, and the testing process used for marking will not
	   execute any of the code below.
	*/
	public static void main(String[] args){
		
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Reading input values from stdin.\n");
		}
		
		BaseballElimination be = new BaseballElimination(s);
		
		if (be.eliminated.size() == 0)
			System.out.println("No teams have been eliminated.");
		else
			System.out.println("Teams eliminated: " + be.eliminated);
		
	}
	
	
}

