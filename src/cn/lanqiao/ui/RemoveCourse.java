package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbCourse;
import cn.lanqiao.service.TbCourseService;
import cn.lanqiao.service.impl.TbCourseServiceImpl;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RemoveCourse extends JFrame {

	static JFrame frame;
	public JTextField textField;
	JOptionPane jOptionPane = new JOptionPane();
	//private static RemoveCourse removeCourse = null;

	public RemoveCourse() {
		
		frame = new JFrame();
		frame.setTitle("�γ�ɾ��");
		frame.setBounds(100, 100, 570, 460);
		frame.dispose();//ֻ�ر��Ӵ���,��Ӱ����������
		frame.setLocationRelativeTo(null);
	
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ȷ��ɾ��");
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(210, 309, 113, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("��ѡ��Ҫɾ���Ŀγ̣�");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(121, 160, 175, 18);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ѡ��γ�"}));
		TbCourseService co = new TbCourseServiceImpl();
		List<TbCourse> cos = co.getAllTbCourse();
		for (TbCourse tbClass : cos) {
			String banJ = tbClass.getCourseName();
			comboBox.addItem(banJ);
		}
		comboBox.setBounds(310, 158, 107, 24);
		contentPane.add(comboBox);
		
		frame.getContentPane().add(contentPane);
		
		//ɾ������
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �쳣�ж�
				if (comboBox.getSelectedIndex() == 0) {
					jOptionPane.showMessageDialog(null, "��ѡ��༶��", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbCourseService co = new TbCourseServiceImpl();
					List<TbCourse> cos = co.getAllTbCourse();
					for (TbCourse s : cos) {
						if ((s.getCourseName()).equals(String.valueOf(comboBox.getSelectedItem()))) {
							co.removeTbCourse(s);
							System.out.println("ɾ���ɹ�");
							frame.dispose();
							jOptionPane.showMessageDialog(null, "ɾ���ɹ�����ˢ������","�� ʾ",
									jOptionPane.INFORMATION_MESSAGE);
							break;
	
						}
					}		
				}
			}
		});
	}
	
	
/*	//����ģʽ
	public static synchronized RemoveCourse getRemoveCourse(){
		if(removeCourse==null){
			removeCourse = new RemoveCourse();
		}
		return removeCourse;
	}*/
}
