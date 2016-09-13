public class Tokenizer{
	
	String tokens;
	char current;
	int location = 0;	
	
	public Tokenizer(String s){
		tokens = s;
		current = tokens.charAt(location);
	}
		
	public char getCurrentToken(){
		current = tokens.charAt(location);
		return current;
	}
	public char getNextToken(){
		location++;
		return getCurrentToken();
	}
	public boolean endOfString(){
		return (location==tokens.length());
	}
}
