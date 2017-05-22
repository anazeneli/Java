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
import java.util.Iterator;
import java.io.*;

/**
* Represents the Department a particular program is in
*/
public class Department implements Iterable<Program>, Serializable 
{
	private List<Program> listD;
	private List<String> progNames;
	/** Constructs an initially empty Department. */
	public Department() 
	{
		listD = new LinkedList<Program>();
	}

/** Adds the specified Program to the end of the Program list. */
	public void addProgram( Program prog) 
	{
		if (prog != null) 
			listD.add(prog);
	}

	public Program find(String other) 
	{
	for (Program prog : listD)
		if (other.equals(prog.getNameP() ) )
		return prog;
		
	return null;
	}
	/*  Creates and returns a string representation of this Program of Study. */
	public String toString() 
	{
		String result = "";
		for (Program prog : listD)
			result += prog + "\n"; 
		return result;
	}
	
	/**
	* Returns an iterator for this Program of Study. */
	public Iterator<Program> iterator() 
	{
		return listD.iterator();
	}
	
	public void addNames( String name) 
	{
		if (name != null) 
			progNames.add(name);
	}
	
	public void printNames()
	{
		int i = 1; 
		for (String prog : progNames)
		{
			if( i < 10)
    		{
    			System.out.println(i + "  : " + prog);
    		}
    		else 
    		{
    			System.out.println(i + " : " + prog);
    		}
			++i;
		}
		System.out.println();
	}
	
	/*public void adjustFileName(String file)
	{
		String[] r = file.split("(?=[A-Z])");
		file = String.join(",", r);
		for(int i = 0 ; i < r.length ; ++ i)
			System.out.print(r[i] + " ");
		System.out.println();
	}
	*/
	
	/** Loads a serialized Program of Study from the specified file. */
	public void load(String fileName) throws IOException, ClassNotFoundException
	{
		FileReader     fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		progNames = new LinkedList<String>();

		String line = null; 
		  
        try {
        	while( (line = br.readLine()) != null)
        	{
        		addNames(line);

        		Program prog = new Program(line);	
    			line = line.replace(" ", "");		// Computer Science -> ComputerScience
    			prog.load(line + ".txt");			// loads above line as file 
    			addProgram(prog); 					
        		
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