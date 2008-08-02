package net.dfs.ui;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import net.dfs.server.main.ServerServicesStarter;

/**
 * @author Rukshan Silva
 */
public class ServerUI extends JPanel {

	private static final long serialVersionUID = 1L;
	public ServerUI() {
		initComponents();
	}

	public static void main(String[] args) {
		new ServerUI();
	}

	private void btnStartActionPerformed(ActionEvent e) {

		new Thread(new Runnable(){
			
			public void run(){
				TextAreaAppender.setTextArea(txtConsole);
				new ANSIColorLayout();
				
				try {
					ServerServicesStarter.startServer();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}).start();
		
		mnuSettings.setEnabled(false);
		
		//FIXME Print the Log in the TextArea
		//TextAreaAppender.setTextArea(txtConsole);
	}

	private void btnTerminateActionPerformed(ActionEvent e) {

		ServerServicesStarter.exitServer();
		
		//FIXME Print the Log in the TextArea
		//TextAreaAppender.setTextArea(txtConsole);
	}

	private void mnuServerIPActionPerformed(ActionEvent e) {
		String ip = JOptionPane.showInputDialog(null, "Enter the Server IP (optional)","localhost");
		if(ip != null){
			JOptionPane.showMessageDialog(null, "The Server IP "+ip+" has been Set", "Confirm Server IP",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void mnuChunkSizeActionPerformed(ActionEvent e) {
		String chunk = JOptionPane.showInputDialog(null, "Enter the chunk size","1024");
		if(Integer.parseInt(chunk) == 0){
			JOptionPane.showMessageDialog(null, "Please enter a valid chunk size","Confirm Chunk size", JOptionPane.ERROR_MESSAGE);
		}
		else if(chunk != null){
			JOptionPane.showMessageDialog(null, "The Chunk size "+Integer.parseInt(chunk)+" has been Set", "Confirm Chunk size",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void initComponents() {
		//Component initialization //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Rukshan Silva
		frame1 = new JFrame();
		menuBar1 = new JMenuBar();
		mnuFile = new JMenu();
		mnuClose = new JMenuItem();
		mnuSettings = new JMenu();
		mnuServerIP = new JMenuItem();
		mnuChunkSize = new JMenuItem();
		mnuHelp = new JMenu();
		mnuAbout = new JMenuItem();
		panel1 = new JPanel();
		lable1 = new JLabel();
		lblServerName = new JLabel();
		label2 = new JLabel();
		lblServerIP = new JLabel();
		lblServerIP2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		lblServerIP3 = new JLabel();
		panel2 = new JPanel();
		scrollPane1 = new JScrollPane();
		txtConsole = new JTextArea();
		panel3 = new JPanel();
		panel4 = new JPanel();
		btnStart = new JButton();
		btnTerminate = new JButton();

		//======== frame1 ========
		{
			frame1.setTitle("Distributed File System");
			frame1.setMaximizedBounds(new Rectangle(100, 150, 250, 200));
			frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			Container frame1ContentPane = frame1.getContentPane();
			frame1ContentPane.setLayout(new GridBagLayout());
			((GridBagLayout)frame1ContentPane.getLayout()).columnWidths = new int[] {0, 0};
			((GridBagLayout)frame1ContentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
			((GridBagLayout)frame1ContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
			((GridBagLayout)frame1ContentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

			//======== menuBar1 ========
			{

				//======== mnuFile ========
				{
					mnuFile.setText("File");

					//---- mnuClose ----
					mnuClose.setText("Close");
					mnuFile.add(mnuClose);
				}
				menuBar1.add(mnuFile);

				//======== mnuSettings ========
				{
					mnuSettings.setText("Settings");

					//---- mnuServerIP ----
					mnuServerIP.setText("Server IP");
					mnuServerIP.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mnuServerIPActionPerformed(e);
						}
					});
					mnuSettings.add(mnuServerIP);

					//---- mnuChunkSize ----
					mnuChunkSize.setText("Chunk Size");
					mnuChunkSize.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mnuChunkSizeActionPerformed(e);
						}
					});
					mnuSettings.add(mnuChunkSize);
				}
				menuBar1.add(mnuSettings);

				//======== mnuHelp ========
				{
					mnuHelp.setText("Help");

					//---- mnuAbout ----
					mnuAbout.setText("About");
					mnuHelp.add(mnuAbout);
				}
				menuBar1.add(mnuHelp);
			}
			frame1.setJMenuBar(menuBar1);

			//======== panel1 ========
			{
				panel1.setBorder(new TitledBorder(new EtchedBorder(), "Server-Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.black));

				// JFormDesigner evaluation mark
				panel1.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

				panel1.setLayout(null);

				//---- lable1 ----
				lable1.setText("Server Name :");
				panel1.add(lable1);
				lable1.setBounds(10, 23, 95, 37);

				//---- lblServerName ----
				lblServerName.setText("#ServerName#");
				panel1.add(lblServerName);
				lblServerName.setBounds(127, 23, 150, 37);

				//---- label2 ----
				label2.setText("Server IP :");
				panel1.add(label2);
				label2.setBounds(9, 58, 101, 42);

				//---- lblServerIP ----
				lblServerIP.setText("#ServerIP#");
				panel1.add(lblServerIP);
				lblServerIP.setBounds(128, 59, 149, 41);

				//---- lblServerIP2 ----
				lblServerIP2.setText("#NoOfClients#");
				panel1.add(lblServerIP2);
				lblServerIP2.setBounds(404, 23, 100, 41);

				//---- label3 ----
				label3.setText("Number of Clients :");
				panel1.add(label3);
				label3.setBounds(287, 22, 117, 42);

				//---- label4 ----
				label4.setText("Number of Users :");
				panel1.add(label4);
				label4.setBounds(286, 60, 117, 42);

				//---- lblServerIP3 ----
				lblServerIP3.setText("#NoOfUsers#");
				panel1.add(lblServerIP3);
				lblServerIP3.setBounds(406, 60, 100, 41);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel1.getComponentCount(); i++) {
						Rectangle bounds = panel1.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel1.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel1.setMinimumSize(preferredSize);
					panel1.setPreferredSize(preferredSize);
				}
			}
			frame1ContentPane.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//======== panel2 ========
			{
				panel2.setBorder(new TitledBorder(new EtchedBorder(), "Server-console", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
				panel2.setLayout(new BorderLayout());

				//======== scrollPane1 ========
				{

					//---- txtConsole ----
					txtConsole.setEditable(false);
					scrollPane1.setViewportView(txtConsole);
				}
				panel2.add(scrollPane1, BorderLayout.CENTER);
			}
			frame1ContentPane.add(panel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//======== panel3 ========
			{
				panel3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				panel3.setLayout(new GridBagLayout());
				((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0, 0};
				((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0};
				((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
				((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

				//======== panel4 ========
				{
					panel4.setLayout(new GridBagLayout());
					((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0};
					((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
					((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

					//---- btnStart ----
					btnStart.setText("Start");
					btnStart.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					btnStart.setHorizontalAlignment(SwingConstants.RIGHT);
					btnStart.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btnStartActionPerformed(e);
						}
					});
					panel4.add(btnStart, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				panel3.add(panel4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 0, 0), 0, 0));

				//---- btnTerminate ----
				btnTerminate.setText("Terminate");
				btnTerminate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				btnTerminate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnTerminateActionPerformed(e);
					}
				});
				panel3.add(btnTerminate, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			frame1ContentPane.add(panel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 0), 0, 0));
			frame1.setSize(680, 470);
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
		}
		// End of component initialization //GEN-END:initComponents
	}

	// Variables declaration //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Rukshan Silva
	private JFrame frame1;
	private JMenuBar menuBar1;
	private JMenu mnuFile;
	private JMenuItem mnuClose;
	private JMenu mnuSettings;
	private JMenuItem mnuServerIP;
	private JMenuItem mnuChunkSize;
	private JMenu mnuHelp;
	private JMenuItem mnuAbout;
	private JPanel panel1;
	private JLabel lable1;
	private JLabel lblServerName;
	private JLabel label2;
	private JLabel lblServerIP;
	private JLabel lblServerIP2;
	private JLabel label3;
	private JLabel label4;
	private JLabel lblServerIP3;
	private JPanel panel2;
	private JScrollPane scrollPane1;
	private JTextArea txtConsole;
	private JPanel panel3;
	private JPanel panel4;
	private JButton btnStart;
	private JButton btnTerminate;
	// End of variables declaration  //GEN-END:variables
}
