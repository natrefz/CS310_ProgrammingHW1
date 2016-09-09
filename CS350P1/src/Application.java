import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application{
  public static void main(String args[]){

	  System.out.println("Please select which language type the file is.\n1: Language 1\n2: Language 2\n3: Language 3\n4: Language 4");
	  
	  Scanner in = new Scanner(System.in);
	  boolean done = false;
	  int selection = 0;
			  
	  while(done ==false){
		  System.out.println("Please select which language type the file is.\n1: Language 1\n2: Language 2\n3: Language 3\n4: Language 4");
		  selection = in.nextInt();
		  if(selection >4 || selection <1){
			  System.out.println("Not a valid selection please try again");
		  }
		  else{
			  done = true;
		  }
	  }
	  done = false;
	  while(done == false){
	  System.out.println("Please enter the location of the file");
	  String filename = in.next();
	  try{
	  Scanner file = new Scanner(new File(filename));
	  done = true;
	  }
	  catch(FileNotFoundException e){
		  System.out.println("Your file location was not valid please try again");
		  done = false;
	  }
	  }
	  if(selection==1){
		  Language1 l1 = new Language1();
		  System.out.println("Language 1 was selected processing file now");
	  }
	  else if(selection==2){
		  Language2 l2 = new Language2();
		  System.out.println("Language 2 was selected processing file now");
	  }
	  else if(selection==3){
		  Language3 l3 = new Language3();
		  System.out.println("Language 3 was selected processing file now");

	  }
	  else{
		  Language4 l4 = new Language4();
		  System.out.println("Language 4 was selected processing file now");
	  }
	  

  }
}
