package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbScore;
import cn.lanqiao.service.TbScoreService;
import cn.lanqiao.service.impl.TbScoreServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LookScore extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static LookScore lookScore = null;
	JOptionPane jOptionPane = new JOptionPane();

	private LookScore() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 547, 37);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("�鿴�ɼ�");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.BLUE);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("������ɼ���ţ�");
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
				// TODO Auto-generated method stub
				TbScoreService scores = new TbScoreServiceImpl();
				List<TbScore> allTbScore = scores.getAllTbScore();
				boolean flag = false;
				if(textField.getText().length()==0){
					jOptionPane.showMessageDialog(null, "������ɼ���ţ�", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				}
				// System.out.println(allTbScore);
				for (TbScore lookScore : allTbScore) {
					if (String.valueOf(lookScore.getScoreId()).equals(textField.getText())) {
						String msg = String.valueOf(lookScore.getScoreGrade());
						jOptionPane.showMessageDialog(null, "�ɼ����Ϊ" + textField.getText() + "�ĳɼ���Ӧ�ɼ���" + msg, "�� ʾ",
								jOptionPane.INFORMATION_MESSAGE);
						flag = true;
					}
				}
				if(!flag){
					jOptionPane.showMessageDialog(null, "û�гɼ����Ϊ  " + textField.getText() + "  �������Ϣ", "�� ʾ",
							jOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(222, 303, 128, 44);
		contentPane.add(btnNewButton);
	}

	public static synchronized LookScore getLookScore() {
		if (lookScore == null) {
			lookScore = new LookScore();
		}
		return lookScore;
	}

}
