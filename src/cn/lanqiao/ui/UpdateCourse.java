package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbCourse;
import cn.lanqiao.model.TbStudent;
import cn.lanqiao.service.TbCourseService;
import cn.lanqiao.service.TbStudentService;
import cn.lanqiao.service.impl.TbCourseServiceImpl;
import cn.lanqiao.service.impl.TbStudentServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UpdateCourse extends JFrame {

	static JFrame frame;
	JOptionPane jOptionPane = new JOptionPane();
	//private static UpdateCourse updateCourse = null;
	TbCourse tbCourse = null;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateCourse frame = new UpdateCourse();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UpdateCourse() {
		
		frame = new JFrame();
		frame.setTitle("�γ��޸�");
		frame.setBounds(100, 100, 570, 460);
		frame.dispose();//ֻ�ر��Ӵ���,��Ӱ����������
		frame.setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("���¿γ̣�");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		
		lblNewLabel.setBounds(108, 78, 86, 18);
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
		comboBox.setBounds(208, 76, 113, 24);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(358, 73, 86, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("�γ����֣�");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel_1.setBounds(186, 151, 92, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("�γ�ѧʱ��");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel_2.setBounds(186, 199, 92, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("�γ�ѧ�֣�");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel_3.setBounds(186, 252, 92, 18);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(292, 149, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(292, 197, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(292, 250, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("ȷ�ϸ���");
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(208, 318, 113, 27);
		contentPane.add(btnNewButton_1);
		
		frame.getContentPane().add(contentPane);
		
		//���ؿؼ�
		lblNewLabel_1.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_3.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		btnNewButton_1.setVisible(false);
		
		//ȷ��Ҫ�޸ĵĿγ�
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �쳣�ж�
				if (comboBox.getSelectedIndex() == 0) {
					jOptionPane.showMessageDialog(null, "��ѡ��γ̣�", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbCourseService co = new TbCourseServiceImpl();
					List<TbCourse> cos = co.getAllTbCourse();
					for (TbCourse s : cos) {
						if ((s.getCourseName()).equals(String.valueOf(comboBox.getSelectedItem()))) {
							tbCourse = s;
							//��ʾ���صĿؼ�
							lblNewLabel_1.setVisible(true);
							lblNewLabel_2.setVisible(true);
							lblNewLabel_3.setVisible(true);
							textField.setVisible(true);
							textField_1.setVisible(true);
							textField_2.setVisible(true);
							btnNewButton_1.setVisible(true);
							jOptionPane.showMessageDialog(null, "�뿪ʼ�޸ģ���ˢ������","�� ʾ",
									jOptionPane.INFORMATION_MESSAGE);
							break;
	
						}
					}		
				}
			}
		});
		
		//�޸Ĳ���
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �쳣�ж�
				if (textField.getText().trim().equals("")) {
					jOptionPane.showMessageDialog(null, "������γ����֣�", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else if (textField_1.getText().trim().equals("")) {
					jOptionPane.showMessageDialog(null, "������γ�ѧʱ��", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else if (textField_2.getText().trim().equals("")) {
					jOptionPane.showMessageDialog(null, "��ѡ��γ�ѧ�֣�", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbCourseService co = new TbCourseServiceImpl();
					tbCourse.setCourseName(textField.getText());
					tbCourse.setCourseHour(Integer.parseInt(textField_1.getText()));
					tbCourse.setCourseScore(textField_2.getText());
					co.updateTbCourse(tbCourse);
					frame.dispose();
					jOptionPane.showMessageDialog(null, "�޸ĳɹ�����ˢ������","�� ʾ",jOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
	}
	
	/*public static synchronized UpdateCourse getUpdateCourse(){
		if(updateCourse==null){
			 updateCourse = new UpdateCourse();
		}
		return updateCourse;
	}*/
}
