public class Tokenizer{
	
	String tokens;
	char current;
	int location = 0;
	public Tokenizer(String s){
		tokens = s;
		current = tokens.charAt(location);
	}
		
	public char getCurrentToken(){
		return tokens.charAt(location);
	}
	public void getNextToken(){
		location++;
	}
	public boolean endOfString(){
		return (location==tokens.length());
	}
}
