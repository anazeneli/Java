import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {
	private String prefix;  // Department
	private int number;     // class designation
    private String title;   // course names
	private String grade;   // null or letter grade
    //private Date timetaken;  // semester class was taken

	/**
	* Constructs the course with the specified information. */
	public Course(String prefix, int number, String title, String grade) 
	{
		this.prefix = prefix; 
		this.number = number; 
		this.title = title; 
		if (grade == null)
			this.grade = ""; 
		else 
			this.grade = grade;
	}
		
	/**
	 * Constructs the course with the specified information, with NO GRADE
	 * established. */
	public Course(String prefix, int number, String title) 
	{
		this(prefix, number, title, "");
	}

	/**
	 * Constructs the course with the specified information, with NO GRADE
	 * and NO TITLE established. */
	public Course(String prefix, int number) 
	{
		this(prefix, number, "", "");
	}
	
	/**
	 * Returns the prefix of the course designation.*/
	public String getPrefix() {
		return prefix;
	}

	/**
	 * Returns the number */
	public int getNumber() {
		return number;
	}

	/**
	* Returns the title of this course. */
	public String getTitle() {
	return title;
	 }

	/**
	* Returns the grade for this course. */
	
	public String getGrade() 
	{
		return grade;
	}

	/**
	 * Sets the grade for this course to the one specified. *
	 * 
	 * @param grade
	 *            the new grade for the course
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * Returns true if this course has been taken (if a grade has been
	 * received). *
	 * 
	 * @return true if this course has been taken and false otherwise
	 */
	public boolean taken() {
		return !grade.equals("");
	}

	/** Determines if this course is equal to the one specified, based on the
	 *  course designation (prefix and number). */
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Course) {
			Course otherCourse = (Course) other;
			if (prefix.equals(otherCourse.getPrefix()) && number == otherCourse.getNumber())
				result = true;
		}
		return result;
	}
	
	public static String LPad(String str, Integer length, char car) {
		  return str  +  String.format("%" + (length - str.length()) + "s", "")
		                     .replace(" ", String.valueOf(car));
		}

	/**
	 * Creates and returns a string representation of this course. */
	public String toString() 
	{
		title = LPad(title, 40, ' ');
		
		String result = prefix + " " + number + ": " + title;
		if(!grade.equals(""))
			result+="\t["+grade+"]";
		return result;
		
	}

}
