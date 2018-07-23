package cn.lanqiao.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbClass;
import cn.lanqiao.model.TbScore;
import cn.lanqiao.service.TbClassService;
import cn.lanqiao.service.impl.TbClassServiceImpl;
import cn.lanqiao.service.impl.TbScoreServiceImpl;

public class LookClass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static LookClass lookClass = null;
	JOptionPane jOptionPane = new JOptionPane();

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public LookClass() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 547, 37);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("���Ұ༶");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.BLUE);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("������༶��ţ�");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel_1.setBounds(92, 196, 139, 37);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(323, 198, 156, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("����鿴");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() == 0) {
					jOptionPane.showMessageDialog(null, "������༶���", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else {
					// TODO Auto-generated method stub
					TbClassService tbClass = new TbClassServiceImpl();
					List<TbClass> allTbClass = tbClass.getAllTbClass();
					boolean flag = false;
					for (TbClass lookClass : allTbClass) {
						if (String.valueOf(lookClass.getClassId()).equals(textField.getText())) {
							String msg = String.valueOf(lookClass.getClassName());
							jOptionPane.showMessageDialog(null, "�༶���:  " + textField.getText() + "  ���Ӧ�İ༶������" + msg,
									"�� ʾ", jOptionPane.INFORMATION_MESSAGE);
							flag = true;
							break;
						}
						
					}
					if (!flag) {
						jOptionPane.showMessageDialog(null, "û�а༶���:  " + textField.getText() + "  �������Ϣ", "�� ʾ",
								jOptionPane.INFORMATION_MESSAGE);
					}
					
				}
			}
		});

		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(222, 303, 128, 44);
		contentPane.add(btnNewButton);
	}

	public static synchronized LookClass getLookClass() {
		if (lookClass == null) {
			lookClass = new LookClass();
		}
		return lookClass;
	}
}
