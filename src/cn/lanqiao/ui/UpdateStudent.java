package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbClass;
import cn.lanqiao.model.TbStudent;
import cn.lanqiao.service.TbClassService;
import cn.lanqiao.service.TbStudentService;
import cn.lanqiao.service.impl.TbClassServiceImpl;
import cn.lanqiao.service.impl.TbStudentServiceImpl;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;

public class UpdateStudent extends JFrame {
	
	static JFrame frame;
	private static UpdateStudent updateStudent = null;   //��̬˽�л�һ������
	JOptionPane jOptionPane = new JOptionPane();
	private JPanel contentPane;
	
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnNewButton_1;
	
	//����ѧ��
	int studentNum=0;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	private UpdateStudent() {
		
		frame = new JFrame();
		frame.setTitle("����ѧ��");
		frame.setBounds(100, 100, 570, 460);
		frame.dispose();//ֻ�ر��Ӵ���,��Ӱ����������
		frame.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(222, 43, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new UpdateStudent_jButton1_actionAdapter(this));
		btnNewButton.setBounds(322, 40, 113, 27);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("����ѧ�ţ�");
		label.setFont(new Font("����", Font.BOLD, 15));
		label.setForeground(Color.BLUE);
		label.setBounds(122, 46, 86, 18);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(275, 96, 120, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(275, 138, 120, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel = new JLabel("��    ����");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(161, 99, 86, 18);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("�������ڣ�");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(161, 141, 86, 18);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("��    ��");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(161, 190, 86, 18);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("��    ����");
		lblNewLabel_3.setFont(new Font("����", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(161, 238, 86, 18);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton_1 = new JButton("ȷ���޸�");
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(197, 317, 113, 27);
		contentPane.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"��ѡ��༶"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(275, 235, 120, 24);
		TbClassService tcs = new TbClassServiceImpl();
		List<TbClass> tc = tcs.getAllTbClass();
		for (TbClass tbClass : tc) {
			int banJ = tbClass.getClassId();
			comboBox.addItem(banJ);
		}
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.BLUE);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"��ѡ���Ա�"}));
		comboBox_1.setBounds(275, 187, 120, 24);
		comboBox_1.addItem("��");
		comboBox_1.addItem("Ů");
		contentPane.add(comboBox_1);
		
		jOptionPane.setBounds(new Rectangle(28, 316, 260, 110));
		jOptionPane.setLayout(null);
		contentPane.add(jOptionPane);
		
		frame.getContentPane().add(contentPane);
		
		//���ؿؼ�
		textField_2.setVisible(false);
		textField_4.setVisible(false);
		lblNewLabel.setVisible(false);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_3.setVisible(false);
		comboBox.setVisible(false);
		comboBox_1.setVisible(false);
		btnNewButton_1.setVisible(false);
		
		//�޸�ѧ����Ϣ
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				// �쳣�ж�
				if (textField_2.getText().trim().equals("")) {
					jOptionPane.showMessageDialog(null, "������ѧ��������", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else if (textField_4.getText().trim().equals("")) {
					jOptionPane.showMessageDialog(null, "������ѧ���������ڣ�", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else if (comboBox.getSelectedIndex() == 0) {
					jOptionPane.showMessageDialog(null, "��ѡ��ѧ�����ڰ༶��", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else if (comboBox_1.getSelectedIndex() == 0) {
					jOptionPane.showMessageDialog(null, "��ѡ��ѧ���Ա�", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbStudentService st = new TbStudentServiceImpl();
					String  studentName, studentSex, studentBirthday, classId;
					studentName = textField_2.getText().trim();
					studentSex = String.valueOf(comboBox_1.getSelectedItem());
					studentBirthday = textField_4.getText().trim();
					classId = String.valueOf(comboBox.getSelectedItem());
					TbStudent student = new TbStudent(studentNum, studentName, studentSex, studentBirthday, Integer.parseInt(classId));
					st.updateTbStudent(student);
					System.out.println("�޸ĳɹ�");
					frame.dispose();
					jOptionPane.showMessageDialog(null, "�޸ĳɹ�����ˢ������","�� ʾ",jOptionPane.INFORMATION_MESSAGE);
				}
			}
		});	
	}
	
	
	//ȷ��Ҫ�޸ĵ�ѧ��
	public void jButton1_actionAdapter(ActionEvent e) {
		//�ȼ���ѧ�Ŵ���
		boolean cheng=true;
		// �쳣�ж�
		if (textField_1.getText().length() == 0) {
			jOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ�գ�", "�� ʾ",jOptionPane.INFORMATION_MESSAGE);
		} else {
			TbStudentService st = new TbStudentServiceImpl();
			List<TbStudent> sts = st.getAllTbStudent();
			for (TbStudent s : sts) {
				if ((s.getStudentNum() + "").equals(textField_1.getText())) {
					cheng = false;
					studentNum = s.getStudentNum();
					//��ʾ���صĿؼ�
					textField_2.setVisible(true);
					textField_4.setVisible(true);
					lblNewLabel.setVisible(true);
					lblNewLabel_1.setVisible(true);
					lblNewLabel_2.setVisible(true);
					lblNewLabel_3.setVisible(true);
					comboBox.setVisible(true);
					comboBox_1.setVisible(true);
					btnNewButton_1.setVisible(true);
					
//					textField_2.setText(s.getStudentName());
//					textField_4.setText(s.getStudentBirthday());
					jOptionPane.showMessageDialog(null, "������Ҫ���µ���Ϣ","�� ʾ",jOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
			if(cheng) {
				jOptionPane.showMessageDialog(null, "û�и�ѧ��","�� ʾ",jOptionPane.INFORMATION_MESSAGE);
			}	
		}
	}
	
	//����ģʽ��ȡ����
	public static synchronized UpdateStudent getUpdateStudent() {
		if (updateStudent == null) {
			updateStudent = new UpdateStudent();
		}
		return updateStudent;
	}
}

//�ⲿ������
class UpdateStudent_jButton1_actionAdapter implements ActionListener {
	private UpdateStudent adaptee;

	UpdateStudent_jButton1_actionAdapter(UpdateStudent adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionAdapter(e);
	}
}