import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application{
  public static void main(String args[]){

	  
	  @SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	  boolean done = false;
	  boolean doAnotherFile = false;
	  int selection = 0;
		  do
	  {		  
	  while(done ==false){
		  System.out.println("Please select which language type the file is.\n1: Language 1\n2: Language 2\n3: Language 3\n4: Language 4");
		  selection = in.nextInt();
		  in.nextLine();
		  if(selection >4 || selection <1){
			  System.out.println("Not a valid selection please try again");
		  }
		  else{
			  done = true;
		  }
	  }
	  done = false;
	  Scanner file = null;
	  while(done == false){
	  System.out.println("Please enter the location of the file");
	  String filename = in.nextLine();
	  try{
	  file = new Scanner(new File(filename));
	  done = true;
	  }
	  catch(FileNotFoundException e){
		  System.out.println("Your file location was not valid please try again");
		  done = false;
	  }
	  }
	  
	  Language l = new Language(selection);
	  System.out.println("Language "+selection+" was selected processing file now");
	  
	  System.out.println("Language number: "+selection);

		  while(file.hasNextLine())
		  {
			  String s = file.nextLine();
			  System.out.printf("String testing: %10.15s"+"  |  Result: "+l.parseExp(s)+"\n",s);
		  }
		  
	  System.out.println();
	  System.out.println("Would you like to test another file? (y/n)");
	  String doagain = in.nextLine();
	  if (doagain.equalsIgnoreCase("y"))
	  {
		  doAnotherFile = true;
	  }
	  else 
		  doAnotherFile = false;
	  done = false;
	  } while(doAnotherFile);
	  System.out.println("Program terminated. \nThank you.");

  }
}
