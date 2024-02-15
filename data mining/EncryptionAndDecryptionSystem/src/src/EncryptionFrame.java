package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class EncryptionFrame extends JFrame {
	
	JList list;
	JTextArea textArea;
	JTextArea textArea_1;
	Stuffing st = new Stuffing();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptionFrame frame = new EncryptionFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EncryptionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 349);
//		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 492, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea.setTabSize(4);
		textArea.setBorder(new LineBorder(new Color(64, 64, 64), 2, true));
		textArea.setLineWrap(true);
		textArea.setToolTipText("Enter your data");
		textArea.setBounds(25, 43, 284, 79);
//		textArea.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = textArea.getText();
				if(list.getSelectedValue() == "Ch_Stuffing") {
					String str = st.CharacterStuffing(txt);
					textArea_1.setText(str);
				}
				else if(list.getSelectedValue() == "Bit_Stuffing") {
					String str1 = st.BitStuffingDestuffing(txt);
					textArea_1.setText(str1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(330, 78, 96, 33);
		panel.add(btnNewButton);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea_1.setBorder(new LineBorder(new Color(64, 64, 64), 2, true));
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(25, 133, 405, 102);
//		textArea_1.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		panel.add(textArea_1);
		
		JLabel lblNewLabel = new JLabel("Encrypt your data");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(186, 11, 122, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Decryption");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new DecryptionFrame().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(186, 250, 104, 35);
//		btnNewButton_1.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(330, 43, 96, 24);
		panel.add(scrollPane);
		
		String[] listEntries = {"Ch_Stuffing","Bit_Stuffing"};
		list = new JList(listEntries);
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(2);
		scrollPane.setViewportView(list);
				
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EncryptionFrame.class.getResource("/src/encryption1.jpg")));
		lblNewLabel_1.setBounds(0, 0, 492, 310);
		panel.add(lblNewLabel_1);
		
		
		
		
		
	}
}
