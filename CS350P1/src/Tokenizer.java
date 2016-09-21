/*
 * Jared Bartrug
 * Nicolas Trefz
 * Due: 9-22-2016
 * CS310 Programming assignment #1
 */

public class Tokenizer {

	private String tokens;
	private char current;
	private int location = 0;

	public Tokenizer(String s) {
		tokens = s + "$";	// We add $ at the end of the string for use with endOfString()
		current = tokens.charAt(location);
	}

	public char getCurrentToken() {
		current = tokens.charAt(location);	// returns the current token character
		return current;
	}

	public char getNextToken() {
		location++;
		return getCurrentToken();		// returns the next token in the string
	}

	public boolean endOfString() {
		return (current == '$');		// checks whether or not the program has reached the end of the string
	}
}
