import java.awt.EventQueue;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CoursesList extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmAllCourses;
	/**
     * The text area which is used for displaying logging information.
     */
    private JTextArea textArea;
     
    public CoursesList() throws ClassNotFoundException, IOException {
		initialize();
         
        textArea = new JTextArea(50, 10);
        textArea.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
         
        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);

         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setLocationRelativeTo(null);    // centers on screen
    }
     
	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoursesList window = new CoursesList();
					//window.frmAllCourses.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, IOException {
		frmAllCourses = new JFrame();
		frmAllCourses.setTitle("Courses");
		frmAllCourses.setBounds(100, 100, 450, 300);
		
		Department dept = new Department();
		dept.load("Departments.txt");
		System.out.println("COURSES");
		System.out.println(dept);

		frmAllCourses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
