import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.io.*;

/**
* Represents a Program of Study, a list of courses taken and planned, for an
* individual student. *
* @author Java Foundations
* @version 4.0 */
public class Program implements Iterable<Course>, Serializable 
{
	private String nameP; 
	private List<Course> list;
	/**
	 * Constructs an initially empty Program of Study. */
	public Program() 
	{
		nameP = ""; 
		list = new LinkedList<Course>();
	}
	public Program(String name) 
	{
		nameP = name; 
		list = new LinkedList<Course>();
	}

/**
* Adds the specified course to the end of the course list. *
* @param course the course to add */
	public void addCourse( Course course) 
	{
		if (course != null) 
			list.add(course);
	}
	
	public String getNameP() 
	{
		return nameP;
	}

	public void setNameP(String nameP) 
	{
		this.nameP = nameP;
	}

	/**
	* Finds and returns the course matching the specified name. *
	* @return the program, or null if not found */
	public Course find(String prefix, int number) 
	{
	for (Course course : list)
	if (prefix.equals(course.getPrefix()) && number == course.getNumber())
		return course;
		
	return null;
	}
	
	/** Determines if this course is equal to the one specified, based on the
	 *  course designation (prefix and number). */
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Program) {
			Program otherProgram = (Program) other;
			if (nameP.equals(otherProgram.getNameP() ) )
				result = true;
		}
		return result;
	}
	

	/* Creates and returns a string representation of this Program of Study.  */
	public String toString() 
	{
		String result = "";
		for (Course course : list)
			result += course + "\n"; 
		return result;
	}
	
	/* Returns an iterator for this Program of Study. */
	public Iterator<Course> iterator() 
	{
		return list.iterator();
	}
	/* Saves a serialized version of this Program of Study to the specified
	* file name.  */
	public void save(String fileName) throws IOException 
	{
		FileOutputStream fos = new FileOutputStream(fileName); 
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
		oos.writeObject(this);
		oos.flush();
		oos.close();
	}

	public void adjustFileName(String file)
	{
		file =  file.substring(0, file.length() - 4);
		
		String[] r = file.split("(?=[A-Z])");
		
		for(int i = 0 ; i < r.length ; ++ i)
			System.out.print(r[i] + " ");
		System.out.println();

	}
	
	/** Loads a serialized Program of Study from the specified file. */
	public void load(String fileName) throws IOException, ClassNotFoundException
	{		
		FileReader     fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		String line = null; 
		String pre = null;
		int number = 0; 
		String title = null; 
		int j = 0; 

	    try 
	    {
			while( (line = br.readLine()) != null)
			{
				String[] split = line.split("	");
	            pre   = split[0];
	            number    = Integer.parseInt(split[1]);
	            title  = split[2];
	            
				addCourse( new Course( pre, number, title) ); 

	            ++j;
			}
        	//close file
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
		
	
