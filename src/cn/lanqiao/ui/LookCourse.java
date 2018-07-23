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

import cn.lanqiao.model.TbCourse;
import cn.lanqiao.model.TbScore;
import cn.lanqiao.service.TbCourseService;
import cn.lanqiao.service.TbScoreService;
import cn.lanqiao.service.impl.TbCourseServiceImpl;
import cn.lanqiao.service.impl.TbScoreServiceImpl;

public class LookCourse extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private static LookCourse lookcourse = null;
	JOptionPane jOptionPane = new JOptionPane();

	private LookCourse() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 547, 37);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("�鿴�γ�");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.BLUE);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("������γ̱�ţ�");
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
				TbCourseService course = new TbCourseServiceImpl();
				List<TbCourse> allTbCourse = course.getAllTbCourse();
				Boolean flag = false;
				if (textField.getText().length() == 0) {
					jOptionPane.showMessageDialog(null, "������γ̱��!", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else {
					// System.out.println(allTbScore);
					for (TbCourse lookCourse : allTbCourse) {
						if (String.valueOf(lookCourse.getCourseNum()).equals(textField.getText())) {
							String msg1 = String.valueOf(lookCourse.getCourseName());
							String msg2 = String.valueOf(lookCourse.getCourseHour());
							String msg3 = String.valueOf(lookCourse.getCourseScore());
							jOptionPane.showMessageDialog(null, "�γ̱�ű��Ϊ   " + textField.getText() + " �Ŀγ�����: " + msg1
									+ "  ��ʱ��:  " + msg2 + " ѧ����: " + msg3, "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
							flag = true;
							break;
						}
					}
					if(!flag){
						jOptionPane.showMessageDialog(null, "û�пγ̺�Ϊ   " + textField.getText()+"�������Ϣ", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);

		btnNewButton.setBounds(222, 303, 128, 44);
		contentPane.add(btnNewButton);
	}

	public static synchronized LookCourse getLookcourse() {
		if (lookcourse == null) {
			lookcourse = new LookCourse();
		}
		return lookcourse;
	}

}
