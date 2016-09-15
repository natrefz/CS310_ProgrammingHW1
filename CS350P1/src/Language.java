public class Language{
	
	int selection;
	String expression = "";
	Tokenizer tok = new Tokenizer(expression);
	
	public Language(int i){
		selection = i;
	}
	
	//Parse int take the string and runs the appropriate 
	//identifier method on it based on the selection
	public boolean parseExp(String s){
		tok = new Tokenizer(s);
		if(selection ==1){//Language 1
			return S1();
			
		}
		else if(selection ==2){ // Language 2
			return assign();
		}
		else if(selection ==3){//Language 3
			return A3();
		}
		else{//Language 4
			return S4();
		}
	}
	//Language 1 methods
	public boolean S1()
	{			
		if (tok.getCurrentToken() == 'a')
		{
			tok.getNextToken();		
			if(S1()){
				if(tok.getNextToken()=='c'){
					tok.getNextToken();
					if(B1()){
						return true;
					}
				}
			}
			else{
				return false;
			}
		}
		if (tok.getCurrentToken() == 'b')
		{
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
	//Language 2 methods
	public boolean assign(){
		
		if(ID()){
			tok.getNextToken();
			if(tok.getCurrentToken()=='='){
				tok.getNextToken();
				if(expr()){
					return true;
				}
			}
		}
		return false;
	}
	public boolean expr(){
		if(digit()){
			if(tok.getNextToken()=='+'){
				if(expr()){
					return true;
				}
			}
			if(tok.getNextToken()=='-'){
				if(expr()){
					return true;
				}
			}
			return true;
		}
		return false;
	}
	public boolean ID(){
		if(tok.getCurrentToken() =='a'||tok.getCurrentToken()=='b'){
			return true;
		}
		return false;
	}
	public boolean digit(){
		int digit = Character.getNumericValue(tok.getCurrentToken());
		if(digit>=0||digit<10){
			return true;
		}
		return false;
	}
	//Language 3 methods
	public boolean A3(){
		if(tok.getCurrentToken()=='a'){
			tok.getNextToken();
			if(A3()){
				if(tok.getNextToken()=='c'){
					return true;
				}
			}
		}
		if(B3()){
			return true;
		}
		return false;
	}
	public boolean B3(){
		if(tok.getCurrentToken()=='b'){
			tok.getNextToken();
			if(B3()){
				if(tok.getNextToken()=='c'){
					return true;
				}
			}
		}
		return true;
	}
	//Language 4 methods
	public boolean S4(){
		if(A4()){
			if(tok.getNextToken()=='a'){
				tok.getNextToken();
				if(B4()){
					if(tok.getNextToken()=='a'){
						return true;
					}
				}	
			}
		}
		return false;
	}
	public boolean A4(){
		if(A4()){
			if(tok.getNextToken()=='b'){
				return true;
			}
		}
		if(tok.getCurrentToken()=='b'){
			return true;
		}
		return false;
	}
	public boolean B4(){
		if(tok.getCurrentToken()=='a'){
			tok.getNextToken();
			if(B4()){
				return true;
			}
		}
		if(tok.getCurrentToken()=='a'){
			return true;
		}
		return false;
	}
}

