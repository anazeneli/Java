import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class AllStudents extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frmAllStudents;
    private JTextArea textArea;
    /**
     * The text area which is used for displaying logging information.
     */
     
    public AllStudents() throws ClassNotFoundException, IOException {
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
					AllStudents window = new AllStudents();
					window.frmAllStudents.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// outputs console results in new window 
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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, IOException {
		frmAllStudents = new JFrame();
		frmAllStudents.setTitle("Students");
		frmAllStudents.setBounds(500, 100, 450, 450);
    	Classroom CS3400 = new Classroom();
    	CS3400.load("Students.txt");
		System.out.println("STUDENTS: " );
		CS3400.printNames();		
		
		frmAllStudents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0 , 0 ,0 };
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 ,0.0 , 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmAllStudents.getContentPane().setLayout(gridBagLayout);
		
		JTextPane txtpnSelectAMajor = new JTextPane();
		txtpnSelectAMajor.setText("Select a major below to see its required courses");
		GridBagConstraints gbc_txtpnSelectAMajor = new GridBagConstraints();
		gbc_txtpnSelectAMajor.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtpnSelectAMajor.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnSelectAMajor.gridx = 1;
		gbc_txtpnSelectAMajor.gridy = 0;
		frmAllStudents.getContentPane().add(txtpnSelectAMajor, gbc_txtpnSelectAMajor);
		
		JButton btnCb = new JButton("Camille Bai");
		btnCb.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_cb = new GridBagConstraints();
		gbc_cb.anchor = GridBagConstraints.WEST;
		gbc_cb.insets = new Insets(0, 0, 5, 0);
		gbc_cb.gridx = 1;
		gbc_cb.gridy = 1;
		btnCb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student stud= new Student();
					newArea("Camille Bai");
					stud.load("CamilleBai.txt");
					double gpa = stud.calculateGPA();
					System.out.println(stud + "\n");
					System.out.println(" GPA: " + gpa);
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		frmAllStudents.getContentPane().add(btnCb, gbc_cb);
		
		JButton btn_jd = new JButton("James Dean");
		btn_jd.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_jd = new GridBagConstraints();
		gbc_jd.insets = new Insets(0, 0, 5, 0);
		gbc_jd.anchor = GridBagConstraints.WEST;
		gbc_jd.gridx = 1;
		gbc_jd.gridy = 2;
		btn_jd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student stud= new Student();
					newArea("James Dean");
					stud.load("JamesDean.txt");
					double gpa = stud.calculateGPA();
					System.out.println(stud + "\n");
					System.out.println(" GPA: " + gpa);
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmAllStudents.getContentPane().add(btn_jd, gbc_jd);
		
		JButton btnJane = new JButton("Jane Doe");
		btnJane.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_Jane = new GridBagConstraints();
		gbc_Jane.insets = new Insets(0, 0, 5, 0);
		gbc_Jane.anchor = GridBagConstraints.WEST;
		gbc_Jane.gridx = 1;
		gbc_Jane.gridy = 3;
		btnJane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student stud= new Student();
					newArea("Jane Doe");
					stud.load("JaneDoe.txt");
					double gpa = stud.calculateGPA();
					System.out.println(stud + "\n");
					System.out.println(" GPA: " + gpa);
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmAllStudents.getContentPane().add(btnJane, gbc_Jane);
		
		JButton btnJohn = new JButton("John Doe");
		btnJohn.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_John = new GridBagConstraints();
		gbc_John.insets = new Insets(0, 0, 5, 0);
		gbc_John.anchor = GridBagConstraints.WEST;
		gbc_John.gridx = 1;
		gbc_John.gridy = 4;
		btnJohn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student stud= new Student();
					newArea("John Doe");
					stud.load("JohnDoe.txt");
					double gpa = stud.calculateGPA();
					System.out.println(stud + "\n");
					System.out.println(" GPA: " + gpa);
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmAllStudents.getContentPane().add(btnJohn, gbc_John);
		
		JButton btnJam = new JButton("James Evans");
		btnJam.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_Jam = new GridBagConstraints();
		gbc_Jam.anchor = GridBagConstraints.WEST;
		gbc_Jam.gridx = 1;
		gbc_Jam.gridy = 5;
		btnJam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student stud= new Student();
					newArea("James Evans");
					stud.load("JamesEvans.txt");
					double gpa = stud.calculateGPA();
					System.out.println(stud + "\n");
					System.out.println(" GPA: " + gpa);
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmAllStudents.getContentPane().add(btnJam, gbc_Jam);
		
		JButton btnKT = new JButton("Katie Holmes");
		btnKT.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_kt = new GridBagConstraints();
		gbc_kt.anchor = GridBagConstraints.WEST;
		gbc_kt.insets = new Insets(0, 0, 5, 0);
		gbc_kt.gridx = 1;
		gbc_kt.gridy = 6;
		btnKT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student stud= new Student();
					newArea("Katie Holmes");
					stud.load("KatieHolmes.txt");
					double gpa = stud.calculateGPA();
					System.out.println(stud + "\n");
					System.out.println(" GPA: " + gpa);
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmAllStudents.getContentPane().add(btnKT, gbc_kt);
		
		JButton btnTi = new JButton("Tessa Inloes");
		btnTi.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_ti = new GridBagConstraints();
		gbc_ti.insets = new Insets(0, 0, 5, 0);
		gbc_ti.anchor = GridBagConstraints.WEST;
		gbc_ti.gridx = 1;
		gbc_ti.gridy = 7;
		btnTi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student stud= new Student();
					newArea("Tessa Inloes");
					stud.load("TessaInloes.txt");
					double gpa = stud.calculateGPA();
					System.out.println(stud + "\n");
					System.out.println(" GPA: " + gpa);
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmAllStudents.getContentPane().add(btnTi, gbc_ti);
		
		JButton btnSP = new JButton("Sarah Parker");
		btnSP.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_sp = new GridBagConstraints();
		gbc_sp.insets = new Insets(0, 0, 5, 0);
		gbc_sp.anchor = GridBagConstraints.WEST;
		gbc_sp.gridx = 1;
		gbc_sp.gridy = 8;
		btnSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student stud= new Student();
					newArea("Sarah Parker");
					stud.load("SarahParker.txt");
					double gpa = stud.calculateGPA();
					System.out.println(stud + "\n");
					System.out.println(" GPA: " + gpa);
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmAllStudents.getContentPane().add(btnSP, gbc_sp);
		
		JButton btnAp = new JButton("Aimee Pohan");
		btnAp.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_ap = new GridBagConstraints();
		gbc_ap.insets = new Insets(0, 0, 5, 0);
		gbc_ap.anchor = GridBagConstraints.WEST;
		gbc_ap.gridx = 1;
		gbc_ap.gridy = 9;
		btnAp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student stud= new Student();
					newArea("Aimee Pohan");
					stud.load("AimeePohan.txt");
					double gpa = stud.calculateGPA();
					System.out.println(stud + "\n");
					System.out.println(" GPA: " + gpa);
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmAllStudents.getContentPane().add(btnAp, gbc_ap);
		
		JButton btnMs = new JButton("Michael Scott");
		btnMs.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_ms = new GridBagConstraints();
		gbc_ms.anchor = GridBagConstraints.WEST;
		gbc_ms.gridx = 1;
		gbc_ms.gridy = 10;
		btnMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student stud= new Student();
					newArea("Michael Scott");
					stud.load("MichaelScott.txt");
					double gpa = stud.calculateGPA();
					System.out.println(stud + "\n");
					System.out.println(" GPA: " + gpa);
					
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frmAllStudents.getContentPane().add(btnMs, gbc_ms);
		
		
		frmAllStudents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
