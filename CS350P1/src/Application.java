import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application{
  public static void main(String args[]) throws FileNotFoundException{
  // hi jared\
	  //hello nick
	  System.out.println("Please select which language type the file is.\n1: Language 1\n2: Language 2\n3: Language 3\n4: Language 4");
	  
	  Scanner in = new Scanner(System.in);
	  int selection = in.nextInt();
	  
	  System.out.println("Please enter the location of the file");
	  String filename = in.next();
	  Scanner file = new Scanner(new File(filename));
  }
}
