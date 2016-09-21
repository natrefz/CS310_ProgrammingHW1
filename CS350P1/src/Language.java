/* 
 * Jared Bartrug
 * Nicolas Trefz
 * Due: 9-22-2016
 * CS310 Programming assignment #1
 */


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
			boolean s1 = S1();
			tok.getNextToken();
			return s1 && tok.endOfString();
			
		}
		else if(selection ==2){ // Language 2
			return assign();
		}
		else if(selection ==3){//Language 3
			boolean a3 =A3();
			return a3 && tok.endOfString();
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
			if(S1())
			{
				tok.getNextToken();
				if(tok.getCurrentToken()=='c')
				{
					tok.getNextToken();
					if(B1())
					{
						return true;
					}
				}
			}			
		}
		else if (tok.getCurrentToken() == 'b')
		{
			return true;
		}
		else if(A1()){
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
		else if(tok.getCurrentToken()=='d'){
			return true;
		}
		return false;
	}
	public boolean B1()
	{
		if(tok.getCurrentToken()=='d'){
			return true;
		}
		else if(tok.getCurrentToken()=='a'){
			tok.getNextToken(); // 7tok=c
			if(A1()){
			return true;
			}
		}
		return false;
	}
	//Language 2 methods
	//Description of language: one variable (a or b) on the left, then one =, then at least one digit (1-9) followed by 
	// zero or more (+ digit) or (- digit)
	public boolean assign(){
		
		if(ID()){
			tok.getNextToken();
			if(tok.getCurrentToken()=='='){
				tok.getNextToken();
				if(expr()){
					if (tok.endOfString())
						return true;
				}
			}
		}
		return false;
	}
	public boolean expr(){
		if(digit()){
			tok.getNextToken();
			if(tok.getCurrentToken()=='+')
			{
				tok.getNextToken();
				if(expr())
				{
					return true;
				}
			}
			else if(tok.getCurrentToken()=='-')
			{
				tok.getNextToken();
				if(expr())
				{
					return true;
				}
			}
			else if (tok.endOfString())
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
		if(digit>=0&&digit<10)
		{
			return true;
		}
		return false;
	}
	//Language 3 methods
	// Language Description: zero or more a's followed by zero or more b's followed by c's 
	// The number of c's always is equal to the amount of a's and b's
	public boolean A3(){
		if(tok.getCurrentToken()=='a')
		{
			tok.getNextToken();
			if(A3()) //if this point is passed, there are no more a's or b's
			{
				if (tok.getCurrentToken()=='c')
				{
					tok.getNextToken();
					return true;
				}
				else 
					return false;
			}
		}
		else if(B3())
		{
			return true;
		}
		else if (tok.getCurrentToken()=='c')
		{
			return true;
		}
		return false;
	}
	public boolean B3()
	{
		if(tok.getCurrentToken()=='b')
		{
			tok.getNextToken();
			if(B3())
			{
				if (tok.getCurrentToken()=='c')
				{					tok.getNextToken();
				return true;
				}
			}
		}
		else if (tok.getCurrentToken()=='c')
			return true;
		return false;
	}
		// Language 4 methods
	// Language Description: one or more b's, followed by two or more a's, followed by exactly one a
	public boolean S4() {
		if (!A4()) {
			if (tok.getCurrentToken() == 'a') {
				tok.getNextToken();
				if (!B4()) {
					if (tok.getCurrentToken() == 'b') {
						tok.getNextToken();
						if (tok.endOfString()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public boolean A4() {
		if (tok.getCurrentToken() != 'b')
			return true;
		if (tok.getCurrentToken() == 'b') {
			tok.getNextToken();
			if (A4()) {
				return false;
			}
		}
		return false;
	}

	public boolean B4() {
		if (tok.getCurrentToken() != 'a')
			return true;
		if (tok.getCurrentToken() == 'a') {
			tok.getNextToken();
			if (B4()) {
				return false;
			}
		}
		return false;
	}
}

