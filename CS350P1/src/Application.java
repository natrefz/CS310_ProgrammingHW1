import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application{
  public static void main(String args[]){

	  System.out.println("Please select which language type the file is.\n1: Language 1\n2: Language 2\n3: Language 3\n4: Language 4");
	  
	  Scanner in = new Scanner(System.in);
	  int selection = in.nextInt();
	  
	  System.out.println("Please enter the location of the file");
	  String filename = in.next();
	  try{
	  Scanner file = new Scanner(new File(filename));
	  }
	  catch(FileNotFoundException e){
		  System.out.println("Your file location was not valid");
	  }
	  Language1 l1 = new Language1();
	  Language2 l2 = new Language2();
	  Language3 l3 = new Language3();
	  Language4 l4 = new Language4();
	  

  }
}
