package net.dfs.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import net.dfs.server.main.ServerServicesStarter;
import net.dfs.user.test.Retrieve;
import net.dfs.user.test.Store;

/**
 * @author Rukshan Silva
 */
public class UserUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserUI() {
		initComponents();
	}

	public static void main(String[] args) {
		new UserUI();
	}

	private void btnConnectActionPerformed(ActionEvent e) {
		
		new Thread(new Runnable(){

			public void run() {
				try {
					Store.userStarter();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}).start();
		
		btnStoreFile.setEnabled(true);
	}

	@SuppressWarnings("static-access")
	private void btnStoreFileActionPerformed(ActionEvent e) {
		
		if(btnStoreFile.getText() == "Browse"){
			fileChooser1.setFileSelectionMode(fileChooser1.FILES_ONLY);
			fileChooser1.showOpenDialog(null);
			File selected = fileChooser1.getSelectedFile();

			lblStoreFile.setText(selected.getAbsolutePath());
			btnStoreFile.setText("Save File");
		}

		else {
			try {
				Store.store(lblStoreFile.getText());
				lblServerIP.setText(Store.serverIP());
				lblUserIP.setText(Store.userIP());
				lblUserName.setText(Store.userName());
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			btnStoreFile.setText("Browse");
			
		}
		
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

	private void btnretrieveFileActionPerformed(ActionEvent e) {
		try {
			Retrieve.retrieve(txtRetrieveFile.getText());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void setServerName(String name){
		lblServerName.setText(name);
	}

	/**
	 * 
	 */
	private void initComponents() {
		// Component initialization //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Rukshan Silva
		frame1 = new JFrame();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		mnuSettings = new JMenuItem();
		menu2 = new JMenu();
		mnuAbout = new JMenuItem();
		panel1 = new JPanel();
		lable1 = new JLabel();
		lblUserName = new JLabel();
		label2 = new JLabel();
		lblUserIP = new JLabel();
		lblServerIP = new JLabel();
		label3 = new JLabel();
		lable2 = new JLabel();
		lblServerName = new JLabel();
		btnStoreFile = new JButton();
		btnretrieveFile = new JButton();
		txtRetrieveFile = new JTextField();
		lblStoreFile = new JLabel();
		panel2 = new JPanel();
		pnlStore = new JPanel();
		scrollPane1 = new JScrollPane();
		txtStoreConsole = new JTextArea();
		panel3 = new JPanel();
		btnTerminate = new JButton();
		btnConnect = new JButton();
		fileChooser1 = new JFileChooser();

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
				panel1.setBorder(new TitledBorder(new EtchedBorder(), "User-Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.blue));

				// JFormDesigner evaluation mark
				panel1.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

				panel1.setLayout(null);

				//---- lable1 ----
				lable1.setText("User Name :");
				panel1.add(lable1);
				lable1.setBounds(14, 22, 75, 37);

				//---- lblUserName ----
				lblUserName.setText("#UserName#");
				panel1.add(lblUserName);
				lblUserName.setBounds(114, 22, 150, 37);

				//---- label2 ----
				label2.setText("User IP :");
				panel1.add(label2);
				label2.setBounds(13, 57, 76, 42);

				//---- lblUserIP ----
				lblUserIP.setText("#UserIP#");
				panel1.add(lblUserIP);
				lblUserIP.setBounds(115, 58, 149, 41);

				//---- lblServerIP ----
				lblServerIP.setText("#ServerIP#");
				panel1.add(lblServerIP);
				lblServerIP.setBounds(386, 56, 149, 41);

				//---- label3 ----
				label3.setText("Server IP :");
				panel1.add(label3);
				label3.setBounds(266, 56, 99, 42);

				//---- lable2 ----
				lable2.setText("Server Name :");
				panel1.add(lable2);
				lable2.setBounds(267, 21, 103, 37);

				//---- lblServerName ----
				lblServerName.setText("#ServerName#");
				panel1.add(lblServerName);
				lblServerName.setBounds(385, 21, 150, 37);

				//---- btnStoreFile ----
				btnStoreFile.setText("Browse");
				btnStoreFile.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				btnStoreFile.setEnabled(false);
				btnStoreFile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnStoreFileActionPerformed(e);
					}
				});
				panel1.add(btnStoreFile);
				btnStoreFile.setBounds(258, 110, 115, 23);

				//---- btnretrieveFile ----
				btnretrieveFile.setText("Retrieve File");
				btnretrieveFile.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				btnretrieveFile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnretrieveFileActionPerformed(e);
					}
				});
				panel1.add(btnretrieveFile);
				btnretrieveFile.setBounds(258, 140, 115, 23);

				//---- txtRetrieveFile ----
				txtRetrieveFile.setText("<retrieve_file>");
				panel1.add(txtRetrieveFile);
				txtRetrieveFile.setBounds(15, 143, 205, txtRetrieveFile.getPreferredSize().height);

				//---- lblStoreFile ----
				lblStoreFile.setText("<store_file>");
				panel1.add(lblStoreFile);
				lblStoreFile.setBounds(20, 108, 200, 25);

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
				panel2.setLayout(new BorderLayout());

				//======== pnlStore ========
				{
					pnlStore.setBorder(new TitledBorder(new EtchedBorder(), "Store-Retrieve console", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.blue));
					pnlStore.setLayout(new BorderLayout());

					//======== scrollPane1 ========
					{
						scrollPane1.setAutoscrolls(true);

						//---- txtStoreConsole ----
						txtStoreConsole.setForeground(Color.blue);
						scrollPane1.setViewportView(txtStoreConsole);
					}
					pnlStore.add(scrollPane1, BorderLayout.CENTER);
				}
				panel2.add(pnlStore, BorderLayout.CENTER);
			}
			frame1ContentPane.add(panel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//======== panel3 ========
			{
				panel3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				panel3.setLayout(new GridLayout());

				//---- btnTerminate ----
				btnTerminate.setText("Terminate");
				btnTerminate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				btnTerminate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnTerminateActionPerformed(e);
					}
				});
				panel3.add(btnTerminate);

				//---- btnConnect ----
				btnConnect.setText("Connect");
				btnConnect.setBorderPainted(false);
				btnConnect.setHorizontalTextPosition(SwingConstants.CENTER);
				btnConnect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnConnectActionPerformed(e);
					}
				});
				panel3.add(btnConnect);
			}
			frame1ContentPane.add(panel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 0), 0, 0));
			frame1.setSize(600, 590);
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
			TextAreaAppender.setTextArea(txtStoreConsole);
		}
		// End of component initialization //GEN-END:initComponents
//		frame1.setVisible(true);
//		TextAreaAppender.setTextArea(txtStoreConsole);
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
	private JLabel lblUserName;
	private JLabel label2;
	private JLabel lblUserIP;
	private JLabel lblServerIP;
	private JLabel label3;
	private JLabel lable2;
	private static JLabel lblServerName;
	private JButton btnStoreFile;
	private JButton btnretrieveFile;
	private JTextField txtRetrieveFile;
	private JLabel lblStoreFile;
	private JPanel panel2;
	private JPanel pnlStore;
	private JScrollPane scrollPane1;
	private JTextArea txtStoreConsole;
	private JPanel panel3;
	private JButton btnTerminate;
	private JButton btnConnect;
	private JFileChooser fileChooser1;
	//End of variables declaration //GEN-END:variables
}
