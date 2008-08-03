package net.dfs.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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

import net.dfs.remote.main.ClientServicesStarter;
import net.dfs.server.main.ServerServicesStarter;

/**
 * @author Rukshan Silva
 */
public class NodeUI extends JPanel {

	private static final long serialVersionUID = 1L;
	public NodeUI() {
		initComponents();
	}
	
	public static void main(String[] args) {
		new NodeUI();
	}

	@SuppressWarnings("static-access")
	private void btnLocationActionPerformed(ActionEvent e) {
		fileChooser1.setFileSelectionMode(fileChooser1.DIRECTORIES_ONLY);
		fileChooser1.showOpenDialog(null);
		File selected = fileChooser1.getSelectedFile();

		String loc = selected.getAbsolutePath();
		lblSaveLoc.setText(ClientServicesStarter.setLocation(loc));
		
		btnStart.setEnabled(true);
	}

	private void btnStartActionPerformed(ActionEvent e) {
		new Thread(new Runnable(){

			public void run() {

				try {
					lblNodeIP.setText(ClientServicesStarter.clientIP());
					lblNodeName.setText(ClientServicesStarter.clientName());
					lblServerIP.setText(ClientServicesStarter.serverIP());
					ClientServicesStarter.startClient();

				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
			}
			
		}).start();
		
		btnStart.setEnabled(false);
		btnLocation.setEnabled(false);
	}

	private void btnTerminateActionPerformed(ActionEvent e) {
		int op = JOptionPane.showConfirmDialog(null, "Do you wish to Terminate the Server ?", "Exit Server", JOptionPane.YES_NO_OPTION);
		if(op == 0){
			ServerServicesStarter.exitServer();
		}

	}

	private void mnuSettingsActionPerformed(ActionEvent e) {
		int op = JOptionPane.showConfirmDialog(null, "Do you wish to Terminate the Server ?", "Exit Server", JOptionPane.YES_NO_OPTION);
		if(op == 0){
			ServerServicesStarter.exitServer();
		}

	}
	
	public static void setServerName(String name){
		lblServerName.setText(name);
	}
	
	private void initComponents() {
		//Component initialization //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Rukshan Silva
		frame1 = new JFrame();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		mnuSettings = new JMenuItem();
		menu2 = new JMenu();
		mnuAbout = new JMenuItem();
		panel1 = new JPanel();
		lable1 = new JLabel();
		lblNodeName = new JLabel();
		label2 = new JLabel();
		lblNodeIP = new JLabel();
		lblServerIP = new JLabel();
		label3 = new JLabel();
		lable2 = new JLabel();
		lblServerName = new JLabel();
		label4 = new JLabel();
		lblSaveLoc = new JLabel();
		panel2 = new JPanel();
		scrollPane1 = new JScrollPane();
		txtConsole = new JTextArea();
		panel3 = new JPanel();
		panel4 = new JPanel();
		btnStart = new JButton();
		btnTerminate = new JButton();
		panel5 = new JPanel();
		btnLocation = new JButton();
		fileChooser1 = new JFileChooser();

		//======== frame1 ========
		{
			frame1.setTitle("Distributed File System");
			frame1.setMaximizedBounds(new Rectangle(100, 150, 250, 200));
			frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			Container frame1ContentPane = frame1.getContentPane();
			frame1ContentPane.setLayout(new GridBagLayout());
			((GridBagLayout)frame1ContentPane.getLayout()).columnWidths = new int[] {0, 0};
			((GridBagLayout)frame1ContentPane.getLayout()).rowHeights = new int[] {125, 131, 0, 0};
			((GridBagLayout)frame1ContentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
			((GridBagLayout)frame1ContentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

			//======== menuBar1 ========
			{

				//======== menu1 ========
				{
					menu1.setText("File");

					//---- mnuSettings ----
					mnuSettings.setText("Close");
					mnuSettings.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mnuSettingsActionPerformed(e);
						}
					});
					menu1.add(mnuSettings);
				}
				menuBar1.add(menu1);

				//======== menu2 ========
				{
					menu2.setText("Help");

					//---- mnuAbout ----
					mnuAbout.setText("About");
					menu2.add(mnuAbout);
				}
				menuBar1.add(menu2);
			}
			frame1.setJMenuBar(menuBar1);

			//======== panel1 ========
			{
				panel1.setBorder(new TitledBorder(new EtchedBorder(), "Node-Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.blue));

				// JFormDesigner evaluation mark
				panel1.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

				panel1.setLayout(null);

				//---- lable1 ----
				lable1.setText("Node Name :");
				panel1.add(lable1);
				lable1.setBounds(14, 22, 75, 37);

				//---- lblNodeName ----
				lblNodeName.setText("<node_name>");
				panel1.add(lblNodeName);
				lblNodeName.setBounds(105, 22, 150, 37);

				//---- label2 ----
				label2.setText("Node IP :");
				panel1.add(label2);
				label2.setBounds(13, 52, 76, 42);

				//---- lblNodeIP ----
				lblNodeIP.setText("<node_IP>");
				panel1.add(lblNodeIP);
				lblNodeIP.setBounds(106, 53, 149, 41);

				//---- lblServerIP ----
				lblServerIP.setText("<server_IP>");
				panel1.add(lblServerIP);
				lblServerIP.setBounds(376, 59, 149, 41);

				//---- label3 ----
				label3.setText("Server IP :");
				panel1.add(label3);
				label3.setBounds(266, 59, 89, 42);

				//---- lable2 ----
				lable2.setText("Server Name :");
				panel1.add(lable2);
				lable2.setBounds(267, 24, 88, 37);

				//---- lblServerName ----
				lblServerName.setText("<server_name>");
				panel1.add(lblServerName);
				lblServerName.setBounds(374, 24, 150, 37);

				//---- label4 ----
				label4.setText("Save Location :");
				label4.setForeground(new Color(0, 204, 0));
				panel1.add(label4);
				label4.setBounds(11, 88, 94, 42);

				//---- lblSaveLoc ----
				lblSaveLoc.setText("<save_loc>");
				lblSaveLoc.setForeground(new Color(0, 204, 0));
				panel1.add(lblSaveLoc);
				lblSaveLoc.setBounds(104, 88, 456, 41);

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
				panel2.setBorder(new TitledBorder(new EtchedBorder(), "Node-console", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.blue));
				panel2.setLayout(new BorderLayout());

				//======== scrollPane1 ========
				{
					scrollPane1.setAutoscrolls(true);

					//---- txtConsole ----
					txtConsole.setForeground(Color.blue);
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
					panel4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					panel4.setLayout(new GridLayout());

					//---- btnStart ----
					btnStart.setText("Start");
					btnStart.setBorderPainted(false);
					btnStart.setHorizontalTextPosition(SwingConstants.CENTER);
					btnStart.setEnabled(false);
					btnStart.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btnStartActionPerformed(e);
						}
					});
					panel4.add(btnStart);

					//---- btnTerminate ----
					btnTerminate.setText("Terminate");
					btnTerminate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					btnTerminate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btnTerminateActionPerformed(e);
						}
					});
					panel4.add(btnTerminate);

					//======== panel5 ========
					{
						panel5.setLayout(new GridLayout());

						//---- btnLocation ----
						btnLocation.setText("Save Location");
						btnLocation.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								btnLocationActionPerformed(e);
							}
						});
						panel5.add(btnLocation);
					}
					panel4.add(panel5);
				}
				panel3.add(panel4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.EAST, GridBagConstraints.NONE,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			frame1ContentPane.add(panel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 0), 0, 0));
			frame1.setSize(590, 445);
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
			TextAreaAppender.setTextArea(txtConsole);
		}
		// End of component initialization  //GEN-END:initComponents
//		frame1.setVisible(true);
//		TextAreaAppender.setTextArea(txtConsole);

	}

	// Variables declaration //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Rukshan Silva
	private JFrame frame1;
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem mnuSettings;
	private JMenu menu2;
	private JMenuItem mnuAbout;
	private JPanel panel1;
	private JLabel lable1;
	private JLabel lblNodeName;
	private JLabel label2;
	private JLabel lblNodeIP;
	private JLabel lblServerIP;
	private JLabel label3;
	private JLabel lable2;
	private static JLabel lblServerName;
	private JLabel label4;
	private JLabel lblSaveLoc;
	private JPanel panel2;
	private JScrollPane scrollPane1;
	private JTextArea txtConsole;
	private JPanel panel3;
	private JPanel panel4;
	private JButton btnStart;
	private JButton btnTerminate;
	private JPanel panel5;
	private JButton btnLocation;
	private JFileChooser fileChooser1;
	//End of variables declaration //GEN-END:variables
}
