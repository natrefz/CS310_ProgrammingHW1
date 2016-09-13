public class Language{
	
	int selection;
	String expression = "";
	Tokenizer tok = new Tokenizer(expression);
	
	public Language(int i){
		selection = i;
	}
	
	
	public boolean parseExp(String s){
		expression = s;
		if(selection ==1){
			Language1_S();
		}
		else if(selection ==2){
			
		}
		else if(selection ==3){
			
		}
		else{
			
		}
		return false;
	}
	public boolean S1()
	{	
		if (tok.endOfString())
			return true;
		if (tok.getCurrentToken() == 'a')
		{
			tok.getNextToken();
			if (tok.endOfString())
				return false;			
			S1();
			return true;
		}
		if (tok.getCurrentToken() == 'b')
		{
			tok.getNextToken();
			S1();
		}		
		if (tok.getCurrentToken() == 'c')
		{
			tok.getNextToken();
			if (tok.endOfString())
				return false;
		}	
		if (tok.getCurrentToken() == 'd')
		{
			
		}	
		return false;
	}
	public boolean A1()
	{
		
		return false;
	}
	public boolean B1()
	{
		
		return false;
	}
}
