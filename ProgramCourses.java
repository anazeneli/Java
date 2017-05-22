import java.awt.EventQueue;

import javax.swing.JFrame;

public class ProgramCourses {

	private JFrame frmRequiredCourses;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramCourses window = new ProgramCourses();
					window.frmRequiredCourses.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProgramCourses() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRequiredCourses = new JFrame();
		frmRequiredCourses.setTitle("Required Courses");
		frmRequiredCourses.setBounds(100, 100, 450, 300);
		frmRequiredCourses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
