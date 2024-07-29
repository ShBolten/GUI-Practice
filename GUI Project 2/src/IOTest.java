import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class IOTest{
 public static void main(String[] args) throws IOException {
	 File file1 = new File("Courses.txt"); // Create File object
	 Scanner scan1 = new Scanner(file1); // Create Scanner object
	 while(scan1.hasNext())
		 System.out.println(scan1.nextLine());
 	File file2 = new File("Enrollment.txt"); // Create File object
 	Scanner scan2 = new Scanner(file2); // Create Scanner object
 	while(scan2.hasNext())
 		System.out.println(scan2.nextLine());
	}
}

