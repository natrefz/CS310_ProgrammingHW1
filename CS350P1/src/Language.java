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
			return S3();
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
				if(tok.getNextToken()=='c')
				{
					tok.getNextToken();
					if(B1())
					{
						tok.getNextToken();
						if (tok.endOfString())
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
	public boolean S3()
	{
		if(A3())
		{
			if (tok.endOfString())
			{
				return true;
			}
		}
		return false;
	}
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
	//Language 4 methods
		public boolean S4(){
			if(!A4()){
				if(tok.getCurrentToken()=='a'){
					tok.getNextToken();
					System.out.println(tok.getCurrentToken());
					if(!B4()){			
						if(tok.getCurrentToken()=='b'){
							tok.getNextToken();
							if(tok.endOfString()){
							return true;
							}
						}
					}	
				}
			}
			return false;
		}
		public boolean A4(){
			if(tok.getCurrentToken()!='b') return true;
			if(tok.getCurrentToken()=='b'){
				tok.getNextToken();
				if(A4()){
					return false;
				}
			}
			return false;
		}
		public boolean B4(){
			if(tok.getCurrentToken()!='a') return true;
			if(tok.getCurrentToken()=='a'){
				tok.getNextToken();
				if(B4()){
					return false;
				}
			}
			return false;
		}
}

