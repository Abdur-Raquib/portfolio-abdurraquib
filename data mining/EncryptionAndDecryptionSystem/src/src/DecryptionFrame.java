package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DecryptionFrame extends JFrame {
	
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
					DecryptionFrame frame = new DecryptionFrame();
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
	public DecryptionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 492, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
				if(list.getSelectedValue() == "Ch_De-stuffing") {
					String str = st.CharacterDeStuffing(txt);
					textArea_1.setText(str);
				}
				else if(list.getSelectedValue() == "Bit_DE_Stuffing") {
					String str1 = st.BitStuffing(txt);
					textArea_1.setText(str1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(334, 78, 96, 33);
		panel.add(btnNewButton);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea_1.setBorder(new LineBorder(new Color(64, 64, 64), 2, true));
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(25, 133, 405, 102);
//		textArea_1.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		panel.add(textArea_1);
		
		JLabel lblNewLabel = new JLabel("Decrypt your data");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(186, 11, 122, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Encryption");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EncryptionFrame().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(186, 254, 104, 35);
//		btnNewButton_1.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(334, 46, 96, 21);
		panel.add(scrollPane);
		
		String[] listEntries = {"Ch_De-stuffing","Bit_DE_Stuffing"};
		list = new JList(listEntries);
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setIcon(new ImageIcon(DecryptionFrame.class.getResource("/src/decryption.jpg")));
		lblNewLabel_1.setBounds(0, 0, 492, 310);
		panel.add(lblNewLabel_1);

	}

}
