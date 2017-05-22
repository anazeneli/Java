import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {
		Scanner scan = new Scanner(System.in);
		Department dept 	= new Department(); 
		dept.load("Departments.txt");
		Classroom CS3400	= new Classroom();
		CS3400.load("Students.txt");
		Program prog = new Program();
		Student stud 		= new Student();
		
		String input = "";
		char ans  	 = ' '; 
		String file  = "";
		int i = 0, num = 0;
		double gpa = 0; 
		String name = "";
		
		while(input != "exit")
		{
			// output each task
	    	System.out.println("\nTask 1: List of all programs               ");
			System.out.println("Task 2: List of all courses 	             ");
			System.out.println("Task 3: List of courses in a program         ");
			System.out.println("Task 4: List of all students                 ");
			System.out.println("Task 5: List of students in a program        ");
			System.out.println("Task 6: Enter a student name                 ");
			System.out.println("Task 7: Student GPA 	                     ");
			System.out.println("Task 8: Exit		 	                     ");

			
			// input selection i
			i = scan.nextInt();
	
			// switch to check input
			switch (i) {
			// List of all Programs
			case 1:
				System.out.println("PROGRAMS: ");
				dept.printNames();
	
				break;
				
			//List of all courses 
			case 2: 
				System.out.println("ALL COURSES: ");
				System.out.println(dept);
				
				break;

			//  List of courses in a specified program 
			case 3:
				System.out.println("Enter the program name ");
				Scanner sc = new Scanner(System.in);
				input = sc.nextLine();
			
				file = adjustInput(input) + ".txt";
				prog.load(file);
				System.out.println(prog + "\n");
	
				break;
				
			// List of all students
			case 4:
				System.out.println("STUDENTS: " );
				CS3400.printNames();
				
				break;
				
			// List of students in a program
			case 5: 
				System.out.println("Enter the program name ");
				Scanner sn = new Scanner(System.in);
				input = sn.nextLine();
				
				System.out.println("STUDENTS ENROLLED IN " + input + ":\n");
				for(int j = 0; j < CS3400.getNumNames(); ++j)
				{
					name = CS3400.getName(j);
					file = adjustInput(name + ".txt"); 
					//System.out.println(file);
					
					stud.load(file);
					if( stud.getMajor().equalsIgnoreCase(input))
						System.out.println( name );
						
				}
				
				break;
				
				// Outputs student information
			case 6:				
				System.out.println("Enter a student name ");
				Scanner sn1 = new Scanner(System.in);
				input = sn1.nextLine();
	
				file = adjustInput(input) + ".txt";
				stud.load(file);
				
				System.out.println(stud);
					
				if( stud.getLoaded() == true )
				{
					// Option to find GPA of previously specified student
					System.out.println("Would you like to see the student's GPA? (Y/N) ");
					ans = sn1.next().charAt(0);
						
					if(ans == 'Y' || ans == 'y')
					{
						gpa = stud.calculateGPA();
						System.out.println(input + " GPA: " + gpa);
					}
					else
						if(ans == 'N' || ans == 'n')
							break;
				}
					break;
			

			// Outputs only student GPA
			case 7:
				System.out.println("Enter a student name ");
				Scanner sn11 = new Scanner(System.in);
				input = sn11.nextLine();
				file = adjustInput(input) + ".txt";
				stud.load(file);
				
				gpa = stud.calculateGPA();
				System.out.println(input + " GPA: " + gpa);
				
				break; 
				
			case 8: 
				input = "exit"; 
				break;
			default:
				System.out.println("Invalid input! Please try again.");
			}
		}
    }
    
    public static String adjustInput(String line)
    {
        line = line.replace(" ", "");		// student's file name 

    	return line; 
    }
}
