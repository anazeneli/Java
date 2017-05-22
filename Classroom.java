import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Classroom 
{
	private String cname;
	private List<Student> members;
	private List<String> classNames;
	final static int SIZE = 10;
	private int numNames = 0;

	public Classroom() 
	{
		members 	= new LinkedList< Student >();
		classNames	= new LinkedList< String >();

	}
	
	public Classroom(String name) 
	{
		cname 		= name; 
		members 	= new LinkedList<Student>();
		classNames 	= new LinkedList< String >();

	}
	
	public void setNameC(String name) 
	{
		this.cname = name;
	}

	public String getNameC() 
	{
		return cname;
	}
	
	// function to calculate the average grade of an array 
	public void addStudent( Student stud) 
	{
		if (stud != null) 
			members.add(stud);
	}
	
	public void addName( String name) 
	{
		if (name != null) 
			classNames.add(name);
	}
	
	public int getNumNames()
	{
		return numNames;
	}
	
	public String getName(int i) 
	{
		return classNames.get(i);
	}
	
	public void printNames()
	{
		int i = 1; 
		for (String stud : classNames)
		{
			if( i < 10)
    		{
    			System.out.println(i + "  : " + stud);
    		}
    		else 
    		{
    			System.out.println(i + " : " + stud);
    		}
			++i;
		}
		System.out.println();
	}
	
	/*  Creates and returns a string representation of this Program of Study. */
	public String toString() 
	{
		String result = "";
		for (Student stud : members)
			result += stud + "\n"; 
		return result;
	}
	
	/**
	* Returns an iterator for this Program of Study. */
	public Iterator<Student> iterator() 
	{
		return members.iterator();
	}
	
	public void adjustFileName(String file)
	{
		String[] r = file.split("(?=[A-Z])");
		file = String.join(",", r);
		for(int i = 0 ; i < r.length ; ++ i)
			System.out.print(r[i] + " ");
		System.out.println();
	}
        			
	public void load(String fileName) throws IOException, ClassNotFoundException
	{
		classNames = new LinkedList<String>();

		String line = null; 
		try 
		{
			FileReader     fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			while( (line = br.readLine()) != null)
			{				
				addName(line);
				++numNames;
	
				// removes whitespace so student name becomes
				Student stud = new Student(line);	// ex) Aimee Pohan -> AimeePohan
				line = line.replace(" ", "");		// student's file name 
				stud.load(line + ".txt");			// loads above line as file -> AimeePohan.txt
				addStudent(stud); 					// adds the student to the list of students in the class
				
			}
		      // Close it.
	        br.close();
		
	    }
	    catch(FileNotFoundException ex) {
	        System.out.println("Unable to open file '" + fileName + "'");
	    }
	    catch(IOException ex) {
	        System.out.println("Error reading file '" + fileName + "'");
	    }
		
	}
	
}

