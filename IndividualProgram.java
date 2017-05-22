import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class IndividualProgram extends JFrame{

	private JFrame frmListOfPrograms;
;
	/**
     * The text area which is used for displaying logging information.
     */
    private JTextArea textArea;
	
    public IndividualProgram() throws ClassNotFoundException, IOException {
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
					IndividualProgram window = new IndividualProgram();
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
	
		frmListOfPrograms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmListOfPrograms.getContentPane().setLayout(gridBagLayout);
		
		JTextPane txtpnSelectAMajor = new JTextPane();
		txtpnSelectAMajor.setText("Select a major below to see its required courses");
		GridBagConstraints gbc_txtpnSelectAMajor = new GridBagConstraints();
		gbc_txtpnSelectAMajor.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtpnSelectAMajor.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnSelectAMajor.gridx = 1;
		gbc_txtpnSelectAMajor.gridy = 0;
		frmListOfPrograms.getContentPane().add(txtpnSelectAMajor, gbc_txtpnSelectAMajor);
		
		JButton btnComputerScience = new JButton("Computer Science");
		GridBagConstraints gbc_btnComputerScience = new GridBagConstraints();
		gbc_btnComputerScience.anchor = GridBagConstraints.WEST;
		gbc_btnComputerScience.insets = new Insets(0, 0, 5, 0);
		gbc_btnComputerScience.gridx = 1;
		gbc_btnComputerScience.gridy = 1;
		btnComputerScience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Classroom CS3400 = new Classroom();
					
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
		frmListOfPrograms.getContentPane().add(btnComputerScience, gbc_btnComputerScience);
		
		JButton btnEnglish = new JButton("English");
		btnEnglish.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnEnglish = new GridBagConstraints();
		gbc_btnEnglish.insets = new Insets(0, 0, 5, 0);
		gbc_btnEnglish.anchor = GridBagConstraints.WEST;
		gbc_btnEnglish.gridx = 1;
		gbc_btnEnglish.gridy = 2;
		btnEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Classroom CS3400 = new Classroom();
					
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
		frmListOfPrograms.getContentPane().add(btnEnglish, gbc_btnEnglish);
		
		JButton btnIntegrativeNeuroscience = new JButton("Integrative Neuroscience");
		btnIntegrativeNeuroscience.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnIntegrativeNeuroscience = new GridBagConstraints();
		gbc_btnIntegrativeNeuroscience.insets = new Insets(0, 0, 5, 0);
		gbc_btnIntegrativeNeuroscience.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnIntegrativeNeuroscience.gridx = 1;
		gbc_btnIntegrativeNeuroscience.gridy = 3;
		btnIntegrativeNeuroscience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Classroom CS3400 = new Classroom();
					
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
		frmListOfPrograms.getContentPane().add(btnIntegrativeNeuroscience, gbc_btnIntegrativeNeuroscience);
		
		JButton btnMathematics = new JButton("Mathematics");
		btnMathematics.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnMathematics = new GridBagConstraints();
		gbc_btnMathematics.insets = new Insets(0, 0, 5, 0);
		gbc_btnMathematics.anchor = GridBagConstraints.WEST;
		gbc_btnMathematics.gridx = 1;
		gbc_btnMathematics.gridy = 4;
		btnMathematics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Classroom CS3400 = new Classroom();
					
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
		frmListOfPrograms.getContentPane().add(btnMathematics, gbc_btnMathematics);
		
		JButton btnPhilosophy = new JButton("Philosophy");
		btnPhilosophy.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnPhilosophy = new GridBagConstraints();
		gbc_btnPhilosophy.anchor = GridBagConstraints.WEST;
		gbc_btnPhilosophy.gridx = 1;
		gbc_btnPhilosophy.gridy = 5;
		btnPhilosophy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Classroom CS3400 = new Classroom();
					
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
		frmListOfPrograms.getContentPane().add(btnPhilosophy, gbc_btnPhilosophy);
	}


    public static String adjustInput(String line)
    {
        line = line.replace(" ", "");		// student's file name 

    	return line; 
    }
}
