public class Language{
	
	int selection;
	String expression = "";
	Tokenizer tok = new Tokenizer(expression);
	
	public Language(int i){
		selection = i;
	}
	
	
	public boolean parseExp(String s){
		tok = new Tokenizer(s);
		if(selection ==1){
			return S1();
			
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
		if (tok.getCurrentToken() == 'a')
		{
			tok.getNextToken();		
			if(S1()){
				if(tok.getNextToken()=='c'){
					if(B1()){
						return true;
					}
				}
			}
		}
		if (tok.getCurrentToken() == 'b')
		{
			tok.getNextToken();
			return true;
		}
		if(A1()){
			return true;
		}
		return false;
	}
	public boolean A1()
	{
		if(tok.getCurrentToken()=='c'){
			tok.getNextToken();
			if(A1()){
				return true;
			}
		}
		if(tok.getCurrentToken()=='d'){
			return true;
		}
		return false;
	}
	public boolean B1()
	{
		if(tok.getCurrentToken()=='d'){
			return true;
		}
		if(tok.getCurrentToken()=='a'){
			tok.getNextToken();
			if(A1()){
			return true;
			}
		}
		return false;
	}
}
