import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.PrintStream;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;


public class ControlPanelGUI {

	private JFrame frmGeekyShutdown;
	private JTextField textField;
	private JTextArea oneWayChat;
	private JScrollPane scrollPaneForOneWayChat;
	
	//Thread threadOfControl;
	ControlPanel control;
	
	// Instance fields (so that other methods can refer)
	JComboBox<String[]> comboBoxCondition;
	JComboBox<Integer[]> comboBoxTimeGap;
	JComboBox<Integer[]> comboBoxTimeDelay;
	JComboBox<Integer[]> comboBoxEvacuationTime;

	JButton btnStart;
	JButton btnStop;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanelGUI window = new ControlPanelGUI();
					window.frmGeekyShutdown.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ControlPanelGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Makes GUI look good.
		try
		{ 
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
		
		frmGeekyShutdown = new JFrame();
		frmGeekyShutdown.setTitle("Geeky Shutdown");
		frmGeekyShutdown.setResizable(false);
		frmGeekyShutdown.setBounds(100, 100, 331, 419);
		frmGeekyShutdown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeekyShutdown.getContentPane().setLayout(null);
		
		
		// Code block for JLabel "Shutdown Condition"
		JLabel lblShutdownCondition = new JLabel("Shutdown Condition");
		lblShutdownCondition.setBounds(10, 11, 102, 14);
		frmGeekyShutdown.getContentPane().add(lblShutdownCondition);
		
		
		// Code block for JComboxBox "Shutdown Condition"
		String[] shutdownConditionList = {"Specific IP connected"};
		comboBoxCondition = new JComboBox(shutdownConditionList);
		comboBoxCondition.setBounds(117, 8, 196, 20);
		frmGeekyShutdown.getContentPane().add(comboBoxCondition);
		comboBoxCondition.setSelectedIndex(0);
		
		
		// Code block for JLabel "Target IP Address"
		JLabel lblTargetIpAddress = new JLabel("Target IP Address");
		lblTargetIpAddress.setBounds(10, 40, 102, 14);
		frmGeekyShutdown.getContentPane().add(lblTargetIpAddress);
		
		
		// Code block for JTextField "Target IP Address"
		textField = new JTextField();
		textField.setBounds(117, 37, 139, 20);
		frmGeekyShutdown.getContentPane().add(textField);
		textField.setColumns(100);

		
		// Code block for JLabel "Time Gap"
		JLabel lblTimeGap = new JLabel("Time Gap");
		lblTimeGap.setBounds(10, 69, 88, 14);
		frmGeekyShutdown.getContentPane().add(lblTimeGap);
		
		
		// Code block for JComboxBox "Time Gap"
		Integer[] timeGapList = {10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65,
				70, 75, 80, 85, 90, 95, 100, 120, 180, 240, 300};
		comboBoxTimeGap = new JComboBox(timeGapList);
		comboBoxTimeGap.setBounds(117, 66, 45, 20);
		frmGeekyShutdown.getContentPane().add(comboBoxTimeGap);
		comboBoxTimeGap.setSelectedIndex(22);
		comboBoxTimeGap.setSelectedItem(10); // Sets default value.
		
		
		// Code block for JLabel "Time Delay"
		JLabel lblTimeDelay = new JLabel("Time Delay");
		lblTimeDelay.setBounds(10, 98, 88, 14);
		frmGeekyShutdown.getContentPane().add(lblTimeDelay);
		
		
		// Code block for JComboxBox "Time Delay"
		Integer[] timeDelayList = {60, 120, 180, 240, 300, 360, 420, 480, 540, 600, 1200, 1800};
		comboBoxTimeDelay = new JComboBox(timeDelayList);
		comboBoxTimeDelay.setBounds(117, 95, 45, 20);
		frmGeekyShutdown.getContentPane().add(comboBoxTimeDelay);
		comboBoxTimeDelay.setSelectedIndex(11);
		comboBoxTimeDelay.setSelectedItem(300);
		
		// Code block for JLabel "sec"
		JLabel lblSecTimeGap = new JLabel("sec");
		lblSecTimeGap.setBounds(171, 65, 46, 14);
		frmGeekyShutdown.getContentPane().add(lblSecTimeGap);
		
		
		// Code block for JLabel "Evacuation Time"
		JLabel lblEvacuationTime = new JLabel("Evacuation Time");
		lblEvacuationTime.setBounds(10, 127, 88, 14);
		frmGeekyShutdown.getContentPane().add(lblEvacuationTime);
		
		
		// Code block for JComboxBox "Evacuation Time"
		Integer[] evacuationTime = {0, 15, 30, 60, 120, 180, 240, 300};
		comboBoxEvacuationTime = new JComboBox(evacuationTime);
		comboBoxEvacuationTime.setBounds(117, 124, 45, 20);
		frmGeekyShutdown.getContentPane().add(comboBoxEvacuationTime);
		comboBoxEvacuationTime.setSelectedIndex(7);
		comboBoxEvacuationTime.setSelectedItem(60);
		
		
		// Code block for JLabel "sec"
		JLabel lblSecTimeDelay = new JLabel("sec");
		lblSecTimeDelay.setBounds(171, 96, 46, 14);
		frmGeekyShutdown.getContentPane().add(lblSecTimeDelay);
		
		
		// Code block for JLabel "sec"
		JLabel lblSecEvacuationTime = new JLabel("sec");
		lblSecEvacuationTime.setBounds(171, 125, 46, 14);
		frmGeekyShutdown.getContentPane().add(lblSecEvacuationTime);
		
		// Code block for JTextArea
		oneWayChat = new JTextArea();
		scrollPaneForOneWayChat = new JScrollPane(oneWayChat);
		scrollPaneForOneWayChat.setViewportView(oneWayChat);
		oneWayChat.setBounds(11, 203, 303, 177);
		scrollPaneForOneWayChat.setBounds(11, 203, 303, 177);
		frmGeekyShutdown.getContentPane().add(scrollPaneForOneWayChat);
		TextAreaOutputStream textOut = new TextAreaOutputStream(oneWayChat);
		PrintStream outStream = new PrintStream(textOut, true);
		System.setOut(outStream);
				
				
		// Code block for JButton "Start!"
		btnStart = new JButton("Start!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				this.disableAllInputSource();
				this.clickOnStartButton();
				System.out.println("Done");
			}

			private void disableAllInputSource() {
				// TODO Auto-generated method stub
				comboBoxCondition.setEnabled(false);
				comboBoxTimeGap.setEnabled(false);
				comboBoxTimeDelay.setEnabled(false);
				comboBoxEvacuationTime.setEnabled(false);
				textField.setEnabled(false);
				btnStart.setEnabled(false);
				btnStop.setEnabled(true);
			}

			private void clickOnStartButton()
			{
				// TODO Auto-generated method stub
				control = new ControlPanel((String)comboBoxCondition.getSelectedItem(), 
						textField.getText(), Long.parseLong(comboBoxTimeGap.getSelectedItem().toString()), 
						Long.parseLong(comboBoxTimeDelay.getSelectedItem().toString()), Long.parseLong(comboBoxEvacuationTime.getSelectedItem().toString()));
				control.start(); // Makes ControlPanel as a thread so that the swing GUI will not freeze.
			}
		});
		btnStart.setBounds(10, 162, 95, 30);
		frmGeekyShutdown.getContentPane().add(btnStart);
		
		
		// Code block for JButton "Help / About"
		JButton btnHelpAbout = new JButton("Help / About");
		btnHelpAbout.setBounds(220, 162, 95, 30);
		frmGeekyShutdown.getContentPane().add(btnHelpAbout);
		
		
		// Code block for "Stop" button
		btnStop = new JButton("Stop");
		btnStop.setBounds(116, 162, 95, 30);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				this.clickOnStopButton();
			}

			private void clickOnStopButton() 
			{
				// TODO Auto-generated method stub
				comboBoxCondition.setEnabled(true);
				comboBoxTimeGap.setEnabled(true);
				comboBoxTimeDelay.setEnabled(true);
				comboBoxEvacuationTime.setEnabled(true);
				textField.setEnabled(true);
				btnStart.setEnabled(true);
				btnStop.setEnabled(false);
				control.stopThread();
			}
		});
		frmGeekyShutdown.getContentPane().add(btnStop);
		btnStop.setEnabled(false);
	}
}
