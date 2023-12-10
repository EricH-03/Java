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
	
	/* testParseInput()
        Tests the parseInput function with sample input.
    */
    public void testParseInput() {
        System.out.println("Number of teams: " + numTeams);
		System.out.println("Team\t\tWins\tGames Left\tRemaining games");
		for (int i = 0; i < numTeams; i++) {
			System.out.printf("%-13s\t%d\t%d\t%s%n", teamNames[i], wins[i], gamesLeft[i], Arrays.toString(gamesRemaining[i]));
		}
    }
	

	/* createFlowNetwork()
        Creates the flow network
    */
    public FlowNetwork createFlowNetwork(int excludeTeam) {
		int numVertices = numTeams * (numTeams - 1) / 2 + numTeams + 2;
		FlowNetwork flowNetwork = new FlowNetwork(numVertices);
        
		int source = 0;
        int sink = numVertices-1;
		int gameVertices = numTeams * (numTeams - 1) / 2; //where vertices of games end
		int teamVertices = gameVertices + 1; //where vertices of teams start
		int vertex= 1;
		
		//Source -> Games
		for (int i = 0; i < numTeams; i++) {
			if(i == excludeTeam) continue; //exclude specficed team since we are assuming they win all 
            for (int j = i+1; j < numTeams; j++) {
				 if (j == excludeTeam) continue; // Exclude the specified team

				flowNetwork.addEdge(new FlowEdge(source, vertexCounter, gamesRemaining[i][j]));
                
				
				// Connect game vertex to team vertices i and j
				double flowCapacity = edge.capacity();
				FlowEdge edgeToI = new FlowEdge(vertexCounter, gameVertices + i + 1, flowCapacity);
				FlowEdge edgeToJ = new FlowEdge(vertexCounter, gameVertices + j + 1, flowCapacity);
				flowNetwork.addEdge(edgeToI);
				flowNetwork.addEdge(edgeToJ);
				
				vertex++;	
            }
        }
		
		//TODO:
		/*
		Currently I have completed source -> games. Am working on games -> teams 
		Then I need to implement teams -> sink 
		Then we can start logic to see inflow
		*/
		/*
		int teamVerticesStart = gameVertices + 1;
		int teamVerticesEnd = teamVerticesStart + numTeams - 1;

		// Connect games to teams
		for (int gameVertex = 1; gameVertex <= gameVertices; gameVertex++) {
			int gameTeam1, gameTeam2;
			if (gameVertex <= (numTeams - 1) * numTeams / 2) {
				gameTeam1 = ((int) (Math.sqrt(1 + 8 * gameVertex) - 1) / 2);
				gameTeam2 = gameVertex - (gameTeam1 * (numTeams - 1) - (gameTeam1 * (gameTeam1 + 1)) / 2);
				gameTeam2 += (gameTeam2 >= gameTeam1) ? 1 : 0;
			} else {
				gameTeam1 = numTeams - 2;
				gameTeam2 = numTeams - 1;
			}

			if (gameTeam1 != excludeTeam && gameTeam2 != excludeTeam) {
				FlowEdge edgeToTeam1 = new FlowEdge(gameVertex, teamVerticesStart + gameTeam1, Double.POSITIVE_INFINITY);
				FlowEdge edgeToTeam2 = new FlowEdge(gameVertex, teamVerticesStart + gameTeam2, Double.POSITIVE_INFINITY);
				flowNetwork.addEdge(edgeToTeam1);
				flowNetwork.addEdge(edgeToTeam2);
			}
		}

		// Connect teams to sink
		for (int teamVertex = teamVerticesStart; teamVertex <= teamVerticesEnd; teamVertex++) {
			int team = teamVertex - teamVerticesStart;
			if (team != excludeTeam) {
				FlowEdge edgeToSink = new FlowEdge(teamVertex, sink, wins[excludeTeam] + gamesLeft[excludeTeam] - wins[team]);
				flowNetwork.addEdge(edgeToSink);
			}
		} */
        printFlowNetwork(flowNetwork);
		
        // Now, use Ford-Fulkerson algorithm to compute max flow
        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, source, sink);
        
        // Retrieve the maximum flow value
        double maxFlow = fordFulkerson.value();
        
        // Output the maximum flow value
        System.out.println("Maximum flow from source to sink: " + maxFlow);
		
		

        return flowNetwork;
    }
	
	public static void printFlowNetwork(FlowNetwork flowNetwork) {
		System.out.println("Flow Network:");
        System.out.println(flowNetwork.toString());
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
		
		createFlowNetwork(1);
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

		//Test Parsing
		be.testParseInput();
		
		if (be.eliminated.size() == 0)
			System.out.println("No teams have been eliminated.");
		else
			System.out.println("Teams eliminated: " + be.eliminated);
		
	}
	
	
}
