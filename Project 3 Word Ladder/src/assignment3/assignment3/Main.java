/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Viraj Parikh>
 * <VHP286>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Fall 2019
 */


package assignment3;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

	// static variables and constants only here.
	public static Set<String> dictionary;

	public static void main(String[] args) throws Exception {
		
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file, for student testing and grading only
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default input from Stdin
			ps = System.out;			// default output to Stdout
		}
		initialize();
		// TODO methods to read in words, output ladder
		//ArrayList<String> StartEndWords	= parse(kb);
        //printLadder(getWordLadderDFS(StartEndWords.get(0),StartEndWords.get(1)));
        printLadder(getWordLadderBFS("Smart","Money"));

    }
	
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
		dictionary = makeDictionary();
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */

	public static ArrayList<String> parse(Scanner keyboard) {
		String start = keyboard.next();
		start =start.toLowerCase();
		ArrayList<String> parse = new ArrayList<>();
		if(start.equals("/quit")){
			return parse;
		}
		String end = keyboard.next();
		parse.add(start.toUpperCase());
		parse.add(end.toUpperCase());
		return parse;
	}
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		// Returned list should be ordered start to end.  Include start and end.
		// If ladder is empty, return list with just start and end.
		// TODO some code
		Graph ladderDFS = new Graph(dictionary);
		ArrayList<String> DFS = new ArrayList<>();
		ladderDFS.DFS(start.toUpperCase(),end.toUpperCase(),DFS);
		return DFS;
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
		// TODO some code
		Graph ladderBFS = new Graph(dictionary);
		return ladderBFS.BFS(start.toUpperCase(),end.toUpperCase()); // replace this line later with real return
	}
    
	
	public static void printLadder(ArrayList<String> ladder) {
		if(ladder.size() <= 2) {
			System.out.println("no word ladder can be found between "+ ladder.get(0) + " and "+ladder.get(1)+".");
			return;
		}
		for(int i = 0;i<ladder.size();i++){
			System.out.println(ladder.get(i));
		}
	}

	// TODO
	// Other private static methods here


	/* Do not modify makeDictionary */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("C:\\Users\\viraj\\Documents\\Projects\\assignment3-fa-19-fa19-pr3-pair-3\\src\\assignment3\\assignment3\\five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
}
