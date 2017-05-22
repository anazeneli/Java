import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class ProgramList extends JFrame{

	private JFrame frmListOfPrograms;
;
	/**
     * The text area which is used for displaying logging information.
     */
    private JTextArea textArea;
	
    public ProgramList() throws ClassNotFoundException, IOException {
    	setTitle("Programs");
		initialize();
         
        textArea = new JTextArea(50, 10);
        textArea.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
         
        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);
        
    }
	
	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramList window = new ProgramList();
					window.frmListOfPrograms.setVisible(true);
					
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws ClassNotFoundException, IOException {
		frmListOfPrograms = new JFrame();
		frmListOfPrograms.setTitle("Programs");
		
		frmListOfPrograms.setBounds(500, 100, 450, 300);
		Department dept = new Department();
		dept.load("Departments.txt");
		dept.printNames();
		
		frmListOfPrograms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListOfPrograms.getContentPane().setLayout(null);
		
		JTextPane txtpnSelectAMajor = new JTextPane();
		txtpnSelectAMajor.setBackground(SystemColor.window);
		txtpnSelectAMajor.setForeground(SystemColor.activeCaptionText);
		txtpnSelectAMajor.setBounds(0, 1, 342, 34);
		txtpnSelectAMajor.setText("Select a major below to see its required courses or enrolled students");
		frmListOfPrograms.getContentPane().add(txtpnSelectAMajor);
		
		JButton btnComputerScience = new JButton("Computer Science");
		btnComputerScience.setHorizontalAlignment(SwingConstants.LEFT);
		btnComputerScience.setBounds(0, 47, 225, 46);
		btnComputerScience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Program prog= new Program();
					newArea("Computer Science");
					prog.load("ComputerScience.txt");
					System.out.println(prog + "\n");
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(btnComputerScience);
		
		JButton btnEnglish = new JButton("English");
		btnEnglish.setBounds(0, 93, 225, 46);
		btnEnglish.setHorizontalAlignment(SwingConstants.LEFT);
		btnEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("English");

					Program prog = new Program();
					prog.load("English.txt");
					System.out.println(prog + "\n");
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(btnEnglish);
		
		JButton btnIntegrativeNeuroscience = new JButton("Integrative Neuroscience");
		btnIntegrativeNeuroscience.setBounds(0, 139, 225, 46);
		btnIntegrativeNeuroscience.setHorizontalAlignment(SwingConstants.LEFT);
		btnIntegrativeNeuroscience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("Integrative Neuroscience");
					Program prog = new Program();
					prog.load("IntegrativeNeuroscience.txt");
					System.out.println(prog + "\n");
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(btnIntegrativeNeuroscience);
		
		JButton btnMathematics = new JButton("Mathematics");
		btnMathematics.setBounds(0, 185, 225, 46);
		btnMathematics.setHorizontalAlignment(SwingConstants.LEFT);
		btnMathematics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("Mathematics");

					Program prog = new Program();
					prog.load("Mathematics.txt");
					System.out.println(prog + "\n");
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(btnMathematics);
		
		JButton btnPhilosophy = new JButton("Philosophy");
		btnPhilosophy.setBounds(0, 231, 225, 46);
		btnPhilosophy.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhilosophy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("Philosophy");

					Program prog = new Program();
					prog.load("Philosophy.txt");
					System.out.println(prog + "\n");
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(btnPhilosophy);
		
		JButton btnCourses = new JButton("Courses");
		btnCourses.setBounds(225, 59, 117, 29);
		btnCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Program prog= new Program();
					newArea("Computer Science");
					prog.load("ComputerScience.txt");
					System.out.println(prog + "\n");
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(btnCourses);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setBounds(333, 59, 117, 29);
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Classroom CS3400 = new Classroom();
					CS3400.load("Students.txt");

					newArea("Student Enrolled in Computer Science");
					
					for(int j = 0; j < CS3400.getNumNames(); ++j)
					{
						String name = CS3400.getName(j);
						Student stud = new Student();
						String file = adjustInput(name + ".txt"); 
						//System.out.println(file);
						
						stud.load(file);
						if( stud.getMajor().equalsIgnoreCase("Computer Science"))
							System.out.println( name );
					}
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(btnStudents);
		
		JButton button = new JButton("Students");
		button.setBounds(333, 102, 117, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("Student Enrolled in English");
					Classroom CS3400 = new Classroom();
					CS3400.load("Students.txt");

					for(int j = 0; j < CS3400.getNumNames(); ++j)
					{
						String name = CS3400.getName(j);
						Student stud = new Student();
						String file = adjustInput(name + ".txt"); 
						//System.out.println(file);
						
						stud.load(file);
						if( stud.getMajor().equalsIgnoreCase("English"))
							System.out.println( name );
							
					}
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(button);
		
		JButton button_1 = new JButton("Courses");
		button_1.setBounds(225, 102, 117, 29);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("English");

					Program prog = new Program();
					prog.load("English.txt");
					System.out.println(prog + "\n");
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Courses");
		button_2.setBounds(225, 148, 117, 29);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("Integrative Neuroscience");
					Program prog = new Program();
					prog.load("IntegrativeNeuroscience.txt");
					System.out.println(prog + "\n");
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Students");
		button_3.setBounds(333, 148, 117, 29);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("Student Enrolled in Integrative Neuroscience");

					Classroom CS3400 = new Classroom();
					CS3400.load("Students.txt");

					for(int j = 0; j < CS3400.getNumNames(); ++j)
					{
						String name = CS3400.getName(j);
						Student stud = new Student();
						String file = adjustInput(name + ".txt"); 
						//System.out.println(file);
						
						stud.load(file);
						if( stud.getMajor().equalsIgnoreCase("Integrative Neuroscience"))
							System.out.println( name );
							
					}
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Courses");
		button_4.setBounds(225, 194, 117, 29);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("Mathematics");

					Program prog = new Program();
					prog.load("Mathematics.txt");
					System.out.println(prog + "\n");
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Courses");
		button_5.setBounds(225, 240, 117, 29);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("Philosophy");

					Program prog = new Program();
					prog.load("Philosophy.txt");
					System.out.println(prog + "\n");
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("Students");
		button_6.setBounds(333, 194, 117, 29);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("Students Enrolled in Mathematics");
					Classroom CS3400 = new Classroom();
					CS3400.load("Students.txt");

					for(int j = 0; j < CS3400.getNumNames(); ++j)
					{
						String name = CS3400.getName(j);
						Student stud = new Student();
						String file = adjustInput(name + ".txt"); 
						//System.out.println(file);
						
						stud.load(file);
						if( stud.getMajor().equalsIgnoreCase("Mathematics"))
							System.out.println( name );
							
					}
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("Students");
		button_7.setBounds(333, 240, 117, 29);
		 button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newArea("Students Enrolled in Philosophy");

					Classroom CS3400 = new Classroom();
					CS3400.load("Students.txt");

					for(int j = 0; j < CS3400.getNumNames(); ++j)
					{
						String name = CS3400.getName(j);
						Student stud = new Student();
						String file = adjustInput(name + ".txt"); 
						//System.out.println(file);
						
						stud.load(file);
						if( stud.getMajor().equalsIgnoreCase("Philosophy"))
							System.out.println( name );
							
					}
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmListOfPrograms.getContentPane().add(button_7);
	}
	


    public static String adjustInput(String line)
    {
        line = line.replace(" ", "");		// student's file name 

    	return line; 
    }

}
