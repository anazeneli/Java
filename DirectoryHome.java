import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class DirectoryHome {

	private JFrame frmUniversityDirectory;
	private JTextField txtWelcomeFindOut;
	protected Object frmAllCourses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectoryHome window = new DirectoryHome();
					window.frmUniversityDirectory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void newArea(String windowName)
	{
		JTextArea textArea = new JTextArea(20, 40);

		textArea.setEditable(false);

		JFrame frmUniversityDirectory = new JFrame();
		frmUniversityDirectory.setTitle(windowName);
		frmUniversityDirectory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frmUniversityDirectory.getContentPane();
		frmUniversityDirectory.getContentPane().setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollPane);
		frmUniversityDirectory.pack();
		frmUniversityDirectory.setVisible(true);

		StudentDirectoryHome out = new StudentDirectoryHome(textArea);
		System.setOut(new PrintStream(out));
	}

	/**
	 * Create the application.
	 */
	public DirectoryHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmUniversityDirectory = new JFrame();
		frmUniversityDirectory.setTitle("New Window");
		frmUniversityDirectory.setBounds(100, 100, 450, 300);
		frmUniversityDirectory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUniversityDirectory.getContentPane().setLayout(null);

		JButton btnPrograms = new JButton("Programs");
		// create new window once programs button is pressed
		btnPrograms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ProgramList nw = new ProgramList();
					nw.NewScreen();
					newArea("Programs");

				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnPrograms.setBounds(0, 39, 378, 29);
		frmUniversityDirectory.getContentPane().add(btnPrograms);

		JButton btnCourses = new JButton("Courses");
		// create new window once courses button is pressed
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CoursesList nx = new CoursesList();
					nx.NewScreen();
					newArea("Courses");

				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCourses.setBounds(0, 73, 378, 29);
		frmUniversityDirectory.getContentPane().add(btnCourses);

		JButton btnStudents = new JButton("Students");
		// create new window once students button is pressed
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AllStudents ny = new AllStudents();
					ny.NewScreen();
					newArea("Students");


				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStudents.setBounds(0, 104, 378, 29);
		frmUniversityDirectory.getContentPane().add(btnStudents);

		
		
		txtWelcomeFindOut = new JTextField();
		txtWelcomeFindOut.setBackground(SystemColor.window);
		txtWelcomeFindOut.setText("Welcome! Find out more about our university below!");
		txtWelcomeFindOut.setBounds(6, 1, 372, 26);
		frmUniversityDirectory.getContentPane().add(txtWelcomeFindOut);
		txtWelcomeFindOut.setColumns(10);

	}
}
