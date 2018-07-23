package cn.lanqiao.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbClass;
import cn.lanqiao.service.TbClassService;
import cn.lanqiao.service.impl.TbClassServiceImpl;

public class AddClass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static AddClass addclass = null;
	JOptionPane jOptionPane_LoginFeedback = new JOptionPane();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private AddClass() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
		// jOptionPane_LoginFeedback.setLayout(null);
		// contentPane.add(jOptionPane_LoginFeedback);

		JPanel panelNorth = new JPanel();
		panelNorth.setBounds(5, 5, 547, 37);
		contentPane.add(panelNorth);

		JLabel lblNewLabel = new JLabel("�����༶");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.BLUE);
		panelNorth.add(lblNewLabel);

		JLabel label = new JLabel("�༶���:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("����", Font.BOLD, 16));
		label.setBounds(138, 128, 96, 30);
		contentPane.add(label);

		JLabel label_1 = new JLabel("�༶����:");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("����", Font.BOLD, 16));
		label_1.setBounds(138, 224, 96, 30);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setBounds(302, 127, 135, 36);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(302, 218, 135, 36);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("ȷ������");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// �����༶����
				if (textField.getText().length() == 0) {
					jOptionPane_LoginFeedback = new JOptionPane();
					jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
					jOptionPane_LoginFeedback.setLayout(null);
					contentPane.add(jOptionPane_LoginFeedback);
					jOptionPane_LoginFeedback.setVisible(true);
					jOptionPane_LoginFeedback.showMessageDialog(contentPane, "������༶���", "������ʾ",
							jOptionPane_LoginFeedback.ERROR_MESSAGE);
				} else if (textField_1.getText().length() == 0) {
					jOptionPane_LoginFeedback = new JOptionPane();
					jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
					jOptionPane_LoginFeedback.setLayout(null);
					contentPane.add(jOptionPane_LoginFeedback);
					jOptionPane_LoginFeedback.setVisible(true);
					jOptionPane_LoginFeedback.showMessageDialog(contentPane, "������༶����", "������ʾ",
							jOptionPane_LoginFeedback.ERROR_MESSAGE);
				} else {// ����������
					TbClassService ourClass = new TbClassServiceImpl();
					List<TbClass> allTbClass = ourClass.getAllTbClass();
					Boolean flag = false;
					for (TbClass tbClass : allTbClass) {
						if (String.valueOf(tbClass.getClassId()).equals(textField.getText())) {
							jOptionPane_LoginFeedback = new JOptionPane();
							jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
							jOptionPane_LoginFeedback.setLayout(null);
							contentPane.add(jOptionPane_LoginFeedback);
							jOptionPane_LoginFeedback.setVisible(true);
							String msg = "�༶����Ѿ�����";
							jOptionPane_LoginFeedback.showMessageDialog(contentPane, msg, "������ʾ",
									jOptionPane_LoginFeedback.ERROR_MESSAGE);
							flag = true;
							break;
						}
					}
					if (!flag) {
						ourClass.insertTbClass(
								new TbClass(Integer.parseInt(textField.getText()), textField_1.getText()));
						jOptionPane_LoginFeedback = new JOptionPane();
						jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
						jOptionPane_LoginFeedback.setLayout(null);
						contentPane.add(jOptionPane_LoginFeedback);
						jOptionPane_LoginFeedback.setVisible(true);
						ImageIcon icon = new ImageIcon("src/YES.jpg");
						String msg = "�ɹ���ӱ��Ϊ:  " + textField.getText() + "  ����Ϊ:   " + textField_1.getText()
								+ "  �༶��Ϣ";
						jOptionPane_LoginFeedback.showMessageDialog(contentPane, msg, "�ɹ���ʾ",
								jOptionPane_LoginFeedback.YES_OPTION,icon);
					}
				}
				// ==
			}
		});
		btnNewButton.setBounds(225, 323, 118, 35);
		contentPane.add(btnNewButton);

	}

	public static synchronized AddClass getAddClass() {
		if (addclass == null) {
			addclass = new AddClass();
		}
		return addclass;
	}

}
