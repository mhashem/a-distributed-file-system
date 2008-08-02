package net.dfs.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

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
	
	private void tnOpenActionPerformed(ActionEvent e) {
		frame2.setVisible(true);
	}

	private void initComponents() {
		// Component initialization //GEN-BEGIN:initComponents
		frame2 = new JFrame();
		fileChooser1 = new JFileChooser();
		frame1 = new JFrame();
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		mnuSettings = new JMenuItem();
		menu3 = new JMenu();
		menuItem4 = new JMenuItem();
		menuItem3 = new JMenuItem();
		menu2 = new JMenu();
		mnuAbout = new JMenuItem();
		panel1 = new JPanel();
		lable1 = new JLabel();
		lblServerName = new JLabel();
		label2 = new JLabel();
		lblServerIP = new JLabel();
		lblServerIP2 = new JLabel();
		label3 = new JLabel();
		lable2 = new JLabel();
		lblServerName2 = new JLabel();
		label4 = new JLabel();
		lblServerIP3 = new JLabel();
		panel2 = new JPanel();
		scrollPane1 = new JScrollPane();
		txtConsole = new JTextArea();
		panel3 = new JPanel();
		btnTerminate = new JButton();
		btnStart = new JButton();
		panel4 = new JPanel();
		tnOpen = new JButton();

		//======== frame2 ========
		{
			frame2.setTitle("Select File");
			frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame2.setResizable(false);
			Container frame2ContentPane = frame2.getContentPane();
			frame2ContentPane.setLayout(new BorderLayout());
			frame2ContentPane.add(fileChooser1, BorderLayout.CENTER);
			frame2.setSize(585, 420);
			frame2.setLocationRelativeTo(frame2.getOwner());
		}

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
					menu1.add(mnuSettings);
				}
				menuBar1.add(menu1);

				//======== menu3 ========
				{
					menu3.setText("Settings");

					//---- menuItem4 ----
					menuItem4.setText("Server IP");
					menu3.add(menuItem4);

					//---- menuItem3 ----
					menuItem3.setText("Save Path");
					menu3.add(menuItem3);
				}
				menuBar1.add(menu3);

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
				panel1.setBorder(new TitledBorder(new EtchedBorder(), "User-Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.black));

				panel1.setLayout(null);

				//---- lable1 ----
				lable1.setText("User Name :");
				panel1.add(lable1);
				lable1.setBounds(14, 22, 75, 37);

				//---- lblServerName ----
				lblServerName.setText("#UserName#");
				panel1.add(lblServerName);
				lblServerName.setBounds(105, 22, 150, 37);

				//---- label2 ----
				label2.setText("User IP :");
				panel1.add(label2);
				label2.setBounds(13, 57, 76, 42);

				//---- lblServerIP ----
				lblServerIP.setText("#UserIP#");
				panel1.add(lblServerIP);
				lblServerIP.setBounds(106, 58, 149, 41);

				//---- lblServerIP2 ----
				lblServerIP2.setText("#ServerIP#");
				panel1.add(lblServerIP2);
				lblServerIP2.setBounds(358, 56, 149, 41);

				//---- label3 ----
				label3.setText("Server IP :");
				panel1.add(label3);
				label3.setBounds(266, 56, 76, 42);

				//---- lable2 ----
				lable2.setText("Server Name :");
				panel1.add(lable2);
				lable2.setBounds(267, 21, 75, 37);

				//---- lblServerName2 ----
				lblServerName2.setText("#ServerName#");
				panel1.add(lblServerName2);
				lblServerName2.setBounds(357, 21, 150, 37);

				//---- label4 ----
				label4.setText("File Name :");
				label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD));
				label4.setForeground(new Color(51, 204, 0));
				panel1.add(label4);
				label4.setBounds(12, 93, 76, 42);

				//---- lblServerIP3 ----
				lblServerIP3.setText("#FileName#");
				lblServerIP3.setFont(lblServerIP3.getFont().deriveFont(lblServerIP3.getFont().getStyle() | Font.BOLD));
				lblServerIP3.setForeground(new Color(51, 204, 0));
				panel1.add(lblServerIP3);
				lblServerIP3.setBounds(104, 93, 149, 41);

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
				panel2.setBorder(new TitledBorder(new EtchedBorder(), "User-console", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
				panel2.setLayout(new BorderLayout());

				//======== scrollPane1 ========
				{
					scrollPane1.setAutoscrolls(true);
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
				panel3.setLayout(new GridLayout());

				//---- btnTerminate ----
				btnTerminate.setText("Terminate");
				btnTerminate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				panel3.add(btnTerminate);

				//---- btnStart ----
				btnStart.setText("Start");
				btnStart.setBorderPainted(false);
				btnStart.setHorizontalTextPosition(SwingConstants.CENTER);
				panel3.add(btnStart);

				//======== panel4 ========
				{
					panel4.setLayout(new GridLayout());

					//---- tnOpen ----
					tnOpen.setText("Open File");
					tnOpen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							tnOpenActionPerformed(e);
						}
					});
					panel4.add(tnOpen);
				}
				panel3.add(panel4);
			}
			frame1ContentPane.add(panel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 0), 0, 0));
			frame1.setSize(585, 380);
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
		}
		// End of component initialization //GEN-END:initComponents
	}

	// Variables declaration //GEN-BEGIN:variables
	private JFrame frame2;
	private JFileChooser fileChooser1;
	private JFrame frame1;
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem mnuSettings;
	private JMenu menu3;
	private JMenuItem menuItem4;
	private JMenuItem menuItem3;
	private JMenu menu2;
	private JMenuItem mnuAbout;
	private JPanel panel1;
	private JLabel lable1;
	private JLabel lblServerName;
	private JLabel label2;
	private JLabel lblServerIP;
	private JLabel lblServerIP2;
	private JLabel label3;
	private JLabel lable2;
	private JLabel lblServerName2;
	private JLabel label4;
	private JLabel lblServerIP3;
	private JPanel panel2;
	private JScrollPane scrollPane1;
	private JTextArea txtConsole;
	private JPanel panel3;
	private JButton btnTerminate;
	private JButton btnStart;
	private JPanel panel4;
	private JButton tnOpen;
	//End of variables declaration //GEN-END:variables
}
