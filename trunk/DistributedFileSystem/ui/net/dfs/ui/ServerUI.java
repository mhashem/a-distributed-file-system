package net.dfs.ui;

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
import java.io.IOException;

import javax.swing.BoxLayout;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import net.dfs.server.main.ServerServicesStarter;

/**
 * @author Rukshan Silva
 */
public class ServerUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private String IP;
	private String CHUNK = ServerServicesStarter.setSize();
	
	public ServerUI() {
		initComponents();
	}

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new ServerUI();
	}

	private void btnStartActionPerformed(ActionEvent e) {
		new Thread(new Runnable(){
			public void run(){
				try {
					lblServerName.setText(ServerServicesStarter.serverName());
					lblServerIP.setText(ServerServicesStarter.startServer());
					lblChunkSize.setText(CHUNK+" bytes");
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}).start();
		
		mnuSettings.setEnabled(false);
		btnStart.setEnabled(false);
		
		//FIXME Print the Log in the TextArea - Done
	}

	private void btnTerminateActionPerformed(ActionEvent e) {
		int op = JOptionPane.showConfirmDialog(null, "Do you wish to Terminate the Server ?", "Exit Server", JOptionPane.YES_NO_OPTION);
		if(op == 0){
			ServerServicesStarter.exitServer();
		}
	}

	private void mnuServerIPActionPerformed(ActionEvent e) {
		this.IP = JOptionPane.showInputDialog(null, "Enter the Server IP (optional)","localhost");
		try {
			String res = ServerServicesStarter.setServer(this.IP);
			if(res == this.IP){
				JOptionPane.showMessageDialog(null, "The Server IP "+IP+" has been Set", "Confirm Server IP",JOptionPane.INFORMATION_MESSAGE);
		}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void mnuChunkSizeActionPerformed(ActionEvent e) {
		this.CHUNK = JOptionPane.showInputDialog(null, "Enter the chunk size","1024");
		try {
			String res = ServerServicesStarter.setChunk(this.CHUNK);
			if(CHUNK == res){
				JOptionPane.showMessageDialog(null, "The Chunk size "+CHUNK+" has been Set", "Confirm Chunk size",JOptionPane.INFORMATION_MESSAGE);
				this.CHUNK = res;
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	private void mnuCloseActionPerformed(ActionEvent e) {
		int op = JOptionPane.showConfirmDialog(null, "Do you wish to Terminate the Server ?", "Exit Server", JOptionPane.YES_NO_OPTION);
		if(op == 0){
			System.exit(1);
		}
	}

	public static void setClients(int num){
		lblClientNo.setText(Integer.toString(num));
	}

	public static void setUsers(int num){
		lblUserNo.setText(Integer.toString(num));
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
		panel6 = new JPanel();
		panel5 = new JPanel();
		lable2 = new JLabel();
		lblServerName = new JLabel();
		label6 = new JLabel();
		lblServerIP = new JLabel();
		lblChunkSize = new JLabel();
		label9 = new JLabel();
		panel1 = new JPanel();
		lblClientNo = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		lblUserNo = new JLabel();
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
					mnuClose.setText("Terminate");
					mnuClose.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mnuCloseActionPerformed(e);
						}
					});
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

			//======== panel6 ========
			{

				panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));

				//======== panel5 ========
				{
					panel5.setBorder(new TitledBorder(new EtchedBorder(), "Server-Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.blue));
					panel5.setForeground(Color.blue);
					panel5.setLayout(null);

					//---- lable2 ----
					lable2.setText("Server Name :");
					panel5.add(lable2);
					lable2.setBounds(17, 23, 95, 37);

					//---- lblServerName ----
					lblServerName.setText("<server_name>");
					panel5.add(lblServerName);
					lblServerName.setBounds(134, 23, 150, 37);

					//---- label6 ----
					label6.setText("Server IP :");
					panel5.add(label6);
					label6.setBounds(16, 46, 101, 42);

					//---- lblServerIP ----
					lblServerIP.setText("<server_ip>");
					panel5.add(lblServerIP);
					lblServerIP.setBounds(135, 47, 149, 41);

					//---- lblChunkSize ----
					lblChunkSize.setText("<chunk_size>");
					panel5.add(lblChunkSize);
					lblChunkSize.setBounds(135, 75, 149, 41);

					//---- label9 ----
					label9.setText("Chunk Size :");
					panel5.add(label9);
					label9.setBounds(15, 74, 101, 42);

					{ // compute preferred size
						Dimension preferredSize = new Dimension();
						for(int i = 0; i < panel5.getComponentCount(); i++) {
							Rectangle bounds = panel5.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panel5.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panel5.setMinimumSize(preferredSize);
						panel5.setPreferredSize(preferredSize);
					}
				}
				panel6.add(panel5);

				//======== panel1 ========
				{
					panel1.setBorder(new TitledBorder(new EtchedBorder(), "Client/User-Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.blue));
					panel1.setForeground(Color.blue);
					panel1.setLayout(null);

					//---- lblClientNo ----
					lblClientNo.setText("<number_of_clients>");
					panel1.add(lblClientNo);
					lblClientNo.setBounds(140, 18, 135, 41);

					//---- label3 ----
					label3.setText("Number of Clients :");
					panel1.add(label3);
					label3.setBounds(20, 18, 117, 42);

					//---- label4 ----
					label4.setText("Number of Users :");
					panel1.add(label4);
					label4.setBounds(20, 46, 117, 42);

					//---- lblUserNo ----
					lblUserNo.setText("<number_of_usres>");
					panel1.add(lblUserNo);
					lblUserNo.setBounds(140, 49, 135, 41);

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
				panel6.add(panel1);
			}
			frame1ContentPane.add(panel6, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//======== panel2 ========
			{
				panel2.setBorder(new TitledBorder(new EtchedBorder(), "Server-console", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.blue));
				panel2.setForeground(Color.blue);
				panel2.setFocusCycleRoot(true);
				panel2.setLayout(new BorderLayout());

				//======== scrollPane1 ========
				{

					//---- txtConsole ----
					txtConsole.setEditable(false);
					txtConsole.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
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
			frame1.setSize(685, 515);
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
			TextAreaAppender.setTextArea(txtConsole);
		}
		// End of component initialization //GEN-END:initComponents
//		frame1.setVisible(true);
//		TextAreaAppender.setTextArea(txtConsole);
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
	private JPanel panel6;
	private JPanel panel5;
	private JLabel lable2;
	private JLabel lblServerName;
	private JLabel label6;
	private JLabel lblServerIP;
	private JLabel lblChunkSize;
	private JLabel label9;
	private JPanel panel1;
	private static JLabel lblClientNo;
	private JLabel label3;
	private JLabel label4;
	private static JLabel lblUserNo;
	private JPanel panel2;
	private JScrollPane scrollPane1;
	private JTextArea txtConsole;
	private JPanel panel3;
	private JPanel panel4;
	private JButton btnStart;
	private JButton btnTerminate;
	// End of variables declaration  //GEN-END:variables
}
