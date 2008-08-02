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
public class NodeUI extends JPanel {

	private static final long serialVersionUID = 1L;
	public NodeUI() {
		initComponents();
	}
	
	public static void main(String[] args) {
		new NodeUI();
	}

	private void btnConnecetActionPerformed(ActionEvent e) {
		// TODO add your code here
	}
	
	private void initComponents() {
		//Component initialization //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Rukshan Silva
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
		panel2 = new JPanel();
		scrollPane1 = new JScrollPane();
		txtConsole = new JTextArea();
		panel3 = new JPanel();
		panel4 = new JPanel();
		btnConnecet = new JButton();
		btnTerminate = new JButton();

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
				panel1.setBorder(new TitledBorder(new EtchedBorder(), "Node-Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.black));

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

				//---- lblServerName ----
				lblServerName.setText("#NodeName#");
				panel1.add(lblServerName);
				lblServerName.setBounds(105, 22, 150, 37);

				//---- label2 ----
				label2.setText("Node IP :");
				panel1.add(label2);
				label2.setBounds(13, 57, 76, 42);

				//---- lblServerIP ----
				lblServerIP.setText("#NodeIP#");
				panel1.add(lblServerIP);
				lblServerIP.setBounds(106, 58, 149, 41);

				//---- lblServerIP2 ----
				lblServerIP2.setText("#ServerIP#");
				panel1.add(lblServerIP2);
				lblServerIP2.setBounds(357, 56, 149, 41);

				//---- label3 ----
				label3.setText("Server IP :");
				panel1.add(label3);
				label3.setBounds(264, 56, 76, 42);

				//---- lable2 ----
				lable2.setText("Server Name :");
				panel1.add(lable2);
				lable2.setBounds(267, 21, 75, 37);

				//---- lblServerName2 ----
				lblServerName2.setText("#ServerName#");
				panel1.add(lblServerName2);
				lblServerName2.setBounds(357, 21, 150, 37);

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
				panel2.setBorder(new TitledBorder(new EtchedBorder(), "Node-console", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
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
				panel3.setLayout(new GridBagLayout());
				((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0, 0};
				((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0};
				((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
				((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

				//======== panel4 ========
				{
					panel4.setLayout(new GridBagLayout());
					((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0, 0};
					((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0};
					((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
					((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

					//---- btnConnecet ----
					btnConnecet.setText("Connect");
					btnConnecet.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					btnConnecet.setHorizontalAlignment(SwingConstants.RIGHT);
					btnConnecet.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btnConnecetActionPerformed(e);
						}
					});
					panel4.add(btnConnecet, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));

					//---- btnTerminate ----
					btnTerminate.setText("Terminate");
					btnTerminate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					panel4.add(btnTerminate, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				panel3.add(panel4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			frame1ContentPane.add(panel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 0), 0, 0));
			frame1.setSize(590, 390);
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
		}
		// End of component initialization  //GEN-END:initComponents
	}

	// Variables declaration //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Rukshan Silva
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
	private JPanel panel2;
	private JScrollPane scrollPane1;
	private JTextArea txtConsole;
	private JPanel panel3;
	private JPanel panel4;
	private JButton btnConnecet;
	private JButton btnTerminate;
	//End of variables declaration //GEN-END:variables
}
