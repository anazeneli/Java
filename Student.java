import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

/* *********************************************************************
 ***********************************************************************
 Design a public class called Person that includes the
 following variables: lastname, firstname, list of courses
 
 * Designate grades and courses taken.
 * It has set and get functions and a constructor to define
 * the score initial value
 
 It also have get and set value functions. Lastly, it should have at
 least one constructor that initialize all the values
 
 ********************************************************************* */
// Each student has own program

public class Student
{
    protected String first_name;
    protected String last_name;
	private boolean loaded = false; 

    
	private List<Course> courseload;
	private List<String> courseNames;

    protected String major; 		//designates student's course path
    
    private String[] grades; 
    private int numGrades; 
    private double GPA = 0;
    
    public Student()
    {
        first_name = "";
        last_name = "";
        
    	courseload = new LinkedList<Course>(); 
    	numGrades = 0; 
    }
    
    
    public Student(String name)
    {
        String[] split	= name.split(" ");
        first_name 	= split[0]; 
        last_name 	= split[1];
        		
    	courseload = new LinkedList<Course>();
    	numGrades = 0; 

    }
    
    /*
    // constructor to initialize Student variables
    public Student(String fname, String lname, String maj)
    {
        // Sets program name in Program class
        // Designates which student is in which program
        this.first_name		= fname;
        this.last_name		= lname;
        this.major 			= maj;
        
    	courseload = new LinkedList<Course>();
    	numGrades = 0; 
    }
    */
	public void addCourse( Course course) 
	{
		if (course != null) 
			courseload.add(course);
	}
	
	public void addCName( String course) 
	{
		if (course != null) 
			courseNames.add(course);
	}
	
	public String getCName(int i)
	{
		System.out.println(courseNames.get(i));
		return courseNames.get(i);
	}
	
	public double calculateGPA()
	{
		final int numElements = numGrades; 
		
		for(int i = 0; i < numElements; ++i)
		{
			if(gradeConversion( grades[i] ) >= 0)
				GPA+= gradeConversion(grades[i]);
			
			else
				--numGrades;
		}
		
		GPA /= numGrades; 
		// convert GPA number into 3 digit precision
		GPA = Math.round(GPA * 1000 );
		GPA /= 1000;
		
		return GPA;
	}
	
	// calculates GPA based on letter grades
	public double gradeConversion(String grade) {
		double gradeValue = 0;

		if (grade.equals("A") || grade.equals("A+") )
			gradeValue = 4.00;
		else if (grade.equals("A-"))
			gradeValue = 3.67;
		else if (grade.equals("B+"))
			gradeValue = 3.33;
		else if (grade.equals("B"))
			gradeValue = 3.00;
		else if (grade.equals("B-"))
			gradeValue = 2.67;
		else if (grade.equals("C+"))
			gradeValue = 2.33;
		else if (grade.equals("C"))
			gradeValue = 2.00;
		else if (grade.equals("D+"))
			gradeValue = 1.33;
		else if (grade.equals("D"))
			gradeValue = 1.00;
		else if (grade.equals("F"))
			gradeValue = 0;
		else if (grade.equals("FX"))
			gradeValue = 0;
		else
			if (grade.equals(" "))
				return -1; 
				
		return gradeValue;

	}

    // return methods to access private variables
    public String getFirstName()
    {
        return first_name;
    }
    
    public String getLastName()
    {
        return last_name;
    }
    
    public String getMajor() 
    {
    	return major;  
    }
    
    public int getNumGrades()
    {
    	return numGrades; 
    }
    
	public Course find(String prefix, int number) 
	{
		for (Course course : courseload)
		if (prefix.equals(course.getPrefix()) && number == course.getNumber())
			return course;
			
		return null;
	}
	
    // ensure name is a character string
    public void validateName(String str)
    {
        int len = str.length();
        for(int i = 0; i < len ; ++i)
        {
            // Tests whether each part of the string is a character
            if( str.charAt(i) > 'z' || str.charAt(i) < 'a' )
                System.out.println("Not valid name.");
        }
    }
    
    /**
     * Creates and returns a string representation of this course. */
    public String toString()
    {
        String result = first_name + " " + last_name + "\n" + major + "\n\n" ;
        for (Course course : courseload)
			result += course + "\n"; 
        return result;
        
    }
    // iterates through course list 
    public Iterator<Course> iterator() {
        
        return courseload.iterator();
    }
    
	public Course finder(String prefix, int number) 
	{
		for (Course course : courseload)
			if (prefix.equals(course.getPrefix()) && number == course.getNumber())
				return course;
		
		return null;
	}
    
	public boolean getLoaded()
	{
		return loaded; 
	}
	
	/**
	* Loads a serialized Program of Study from the specified file. */
	public void load(String fileName) throws IOException, ClassNotFoundException
	{
		String line = null,  course_name = "" ; 
		int i = 0, j = 0; //counter
        String pre    	= ""; 
        int number 		= 0;
        String title 	= "";
        grades = new String[15];
        
        try {
        	FileReader     fr = new FileReader(fileName);
    		BufferedReader br = new BufferedReader(fr);
    		
			while ((line = br.readLine()) != null)
	        {
	            if( i == 0)
	            {
	            	if( first_name.length() < 1)
	            	{
	            		String[] split = line.split(" ");
	            		first_name = split[0];
	            		last_name = split[1]; 
	            	}
	            }
	            else
	                if( i == 1 )
	                    major = line;
	                else
	                {
	                    String[] split	= line.split("	");
	                    
	                     //course_name = split[0] + "\t" +  split[1] + "\t" +  split[2] + "\t" ;
	                    //addCName(course_name);
	                    
	                    pre	   			= split[0];
	                    number			= Integer.parseInt(split[1]);
	                    title			= split[2];
	                    grades[j]		= split[3];
	                    
	                    ++numGrades; 
	                    	
	                    addCourse(new Course( pre, number, title, grades[j]));
	                    
	                    ++j;
	                }
	            
	            ++i;
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
