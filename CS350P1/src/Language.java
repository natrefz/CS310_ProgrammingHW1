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
	public boolean A2(){
		if(tok.getCurrentToken()=='a'){
			tok.getNextToken();
			if(A2()){
				if(tok.getNextToken()=='c'){
					return true;
				}
			}
		}
		if(B2()){
			return true;
		}
		return false;
	}
	public boolean B2(){
		if(tok.getCurrentToken()=='b'){
			tok.getNextToken();
			if(B2()){
				if(tok.getNextToken()=='c'){
					return true;
				}
			}
		}
		return false;
	}
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

