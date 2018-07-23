package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.Test;

import cn.lanqiao.model.TbStudent;
import cn.lanqiao.model.UserMnager;
import cn.lanqiao.service.TbStudentService;
import cn.lanqiao.service.UserMnagerService;
import cn.lanqiao.service.impl.TbStudentServiceImpl;
import cn.lanqiao.service.impl.UserMnagerServiceImpl;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class OperationWindow extends JInternalFrame {
	private JPanel contentPane;
	private JTable table;// ��
	JScrollPane scrollPane = new JScrollPane();// ������
	// private static OperationWindow studentWindow = null;
	private JTextField textField;
	private JTextField textField_1;
	String TableHead[];
	Object student[][];
	Object[][] student1;
	int i;
	int j;
	JOptionPane jOptionPane_LoginFeedback;
	JTable newTable;
	String TableHead2[];
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public OperationWindow() {
		setVisible(true);

		setBounds(0, -28, 870, 627);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelNorth = new JPanel();
		panelNorth.setBounds(5, 5, 844, 31);
		contentPane.add(panelNorth);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel label = new JLabel("ѧ������");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("����", Font.BOLD, 18));
		panelNorth.add(label);

		JLabel label_1 = new JLabel("��ѡ���ѯ��ʽ:");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("����", Font.BOLD, 16));
		label_1.setBounds(255, 61, 132, 31);
		contentPane.add(label_1);

		String choose[] = { "-��ѡ��-", "ѧ�Ų�ѯ", "������ѯ" };
		JComboBox comboBox = new JComboBox(choose);
		comboBox.setFont(new Font("����", Font.PLAIN, 14));
		comboBox.setBounds(437, 67, 152, 21);
		contentPane.add(comboBox);
		// -----------------------------��������ʾ---------------------------
		TbStudentService studentService = new TbStudentServiceImpl();
		List<TbStudent> students = studentService.getAllTbStudent();
		// ������ת���ɶ�ά�������
		TableHead = new String[] { "ѧ��", "����", "�Ա�", "��������", "�༶���" };// ��ͷ�ֶ�
		student = new Object[students.size()][TableHead.length];// ����
		// ��ͷ

		for (i = 0; i < students.size(); i++) {
			for (j = 0; j < TableHead.length; j++) {
				switch (j) {
				case 0:
					student[i][j] = students.get(i).getStudentNum();
					break;
				case 1:
					student[i][j] = students.get(i).getStudentName();
					break;
				case 2:
					student[i][j] = students.get(i).getStudentSex();
					break;
				case 3:
					student[i][j] = students.get(i).getStudentBirthday();
					break;
				case 4:
					student[i][j] = students.get(i).getClassId();
					break;

				}
			}
		}
		getTable();
//		table = null;
//		table = new JTable(student, TableHead);
//		table.setEnabled(false);
//		table.setBounds(0, 0, 529, 407);
//		table.setFont(new Font("����", Font.BOLD, 14));
//
//		scrollPane.setBounds(5, 200, 839, 344);
//		getContentPane().add(scrollPane);
//		scrollPane.setViewportView(table);
		// ----------------------------------------------
		JButton button_1 = new JButton("����ѧ��");
		button_1.setFont(new Font("����", Font.BOLD, 14));
		button_1.setForeground(Color.BLUE);
		button_1.setBounds(98, 554, 104, 39);
		contentPane.add(button_1);

		JButton button_2 = new JButton("ɾ��ѧ��");
		button_2.setForeground(Color.BLUE);
		button_2.setFont(new Font("����", Font.BOLD, 14));
		button_2.setBounds(295, 554, 104, 39);
		contentPane.add(button_2);

		JButton button_3 = new JButton("����ѧ��");
		button_3.setForeground(Color.BLUE);
		button_3.setFont(new Font("����", Font.BOLD, 14));
		button_3.setBounds(495, 554, 104, 39);
		contentPane.add(button_3);
		if (TotalWindow.level == 2) {
			button_1.setVisible(false);
			button_2.setVisible(false);
			button_3.setVisible(false);
		}

		JButton button_4 = new JButton("ˢ������");
		button_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TbStudentService studentService = new TbStudentServiceImpl();
				List<TbStudent> students = studentService.getAllTbStudent();
				// ������ת���ɶ�ά�������
				TableHead = new String[] { "ѧ��", "����", "�Ա�", "��������", "�༶���" };// ��ͷ�ֶ�
				student = new Object[students.size()][TableHead.length];// ����
				// ��ͷ

				for (i = 0; i < students.size(); i++) {
					for (j = 0; j < TableHead.length; j++) {
						switch (j) {
						case 0:
							student[i][j] = students.get(i).getStudentNum();
							break;
						case 1:
							student[i][j] = students.get(i).getStudentName();
							break;
						case 2:
							student[i][j] = students.get(i).getStudentSex();
							break;
						case 3:
							student[i][j] = students.get(i).getStudentBirthday();
							break;
						case 4:
							student[i][j] = students.get(i).getClassId();
							break;

						}
					}
				}
				getTable();
			}
		});
		button_4.setForeground(Color.BLUE);
		button_4.setFont(new Font("����", Font.BOLD, 14));
		button_4.setBounds(695, 554, 104, 39);
		contentPane.add(button_4);
		// --------------------------
		JLabel label_2 = new JLabel("������ѧ��ѧ��:");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("����", Font.BOLD, 14));
		label_2.setBounds(255, 102, 132, 31);
		contentPane.add(label_2);

		textField = new JTextField();// ѧ�������
		textField.setBounds(437, 98, 152, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label_3 = new JLabel("������ѧ������:");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("����", Font.BOLD, 14));
		label_3.setBounds(255, 102, 132, 31);
		contentPane.add(label_3);

		textField_1 = new JTextField();// ���������
		textField_1.setColumns(10);
		textField_1.setBounds(437, 98, 152, 30);
		contentPane.add(textField_1);

		JButton button = new JButton("��ѯ");// ��һ����ѯѧ��
		button.setFont(new Font("����", Font.PLAIN, 16));
		button.setBounds(639, 98, 93, 27);
		contentPane.add(button);

		JButton button_5 = new JButton("��ѯ");// �ڶ�����ѯ����
		button_5.setFont(new Font("����", Font.PLAIN, 16));
		button_5.setBounds(639, 98, 93, 27);
		contentPane.add(button_5);

		// ����3:����ѧ��
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("�Ƿ�󶨳ɹ�");//���԰󶨳ɹ�
				AddStudentImpl addStudentImpl = AddStudentImpl.getAddStudentImpl();// �����´���
				addStudentImpl.setLocation(400, 200);
				addStudentImpl.setSize(592, 350);
				addStudentImpl.setVisible(true);
				addStudentImpl.setResizable(false);
				addStudentImpl.validate();

			}
		});
		// ����4:����ѧ��
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudent updatestudent = UpdateStudent.getUpdateStudent();
				updatestudent.frame.setVisible(true);
			}
		});

		// ---����1.ģ����ѯ��������
		// ��һ��:������
		label_2.setVisible(false);
		textField.setVisible(false);
		button.setVisible(false);

		label_3.setVisible(false);
		textField_1.setVisible(false);
		button_5.setVisible(false);
		// �ڶ�������������������ʾ����
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedIndex() == 1) {
					label_2.setVisible(true);
					textField.setVisible(true);
					button.setVisible(true);
					label_3.setVisible(false);
					textField_1.setVisible(false);
					button_5.setVisible(false);

				} else if (comboBox.getSelectedIndex() == 2) {
					label_3.setVisible(true);
					textField_1.setVisible(true);
					button_5.setVisible(true);
					label_2.setVisible(false);
					textField.setVisible(false);
					button.setVisible(false);
				}

			}
		});

		// ɾ����ť��������
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RemoveStuendt removeStuendt = RemoveStuendt.getRemoveStuendt();// �����´���
				removeStuendt.frame.setVisible(true);
				// --------------------

			}
		});
		// ---����2:�����ѯ����ѧ����ѧ�Ž��в�ѯ
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("�����Ƿ�󶨳ɹ�");
				// ��ȡ��������� �����ж��Ƿ�������ݿ��С���������ڵ���dialog,���ھ͸��Ǳ������Ϣ��ʾ����//Ϊ�ո�����ʾ��

				String input_number = textField.getText();// �����ѧ��
				if (input_number.length() == 0) {
					jOptionPane_LoginFeedback = new JOptionPane();
					jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
					jOptionPane_LoginFeedback.setLayout(null);
					// jOptionPane_LoginFeedback.setVisible(false);
					contentPane.add(jOptionPane_LoginFeedback);
					jOptionPane_LoginFeedback.setVisible(true);
					jOptionPane_LoginFeedback.showMessageDialog(contentPane, "�������ѯѧ��", "������ʾ",
							OperationWindow.this.jOptionPane_LoginFeedback.ERROR_MESSAGE);

				} else {

					TbStudentService studentService = new TbStudentServiceImpl();
					List<TbStudent> students = studentService.getAllTbStudent();
					Boolean flag = false;
					for (TbStudent msg : students) {
						if ((String.valueOf(msg.getStudentNum()).trim().equals(input_number))) {
							// ���˺ŵ�½����ʾ����
							// ����ѯ���ݸ�����ʾ�������
							TableHead = new String[] { "ѧ��", "����", "�Ա�", "��������", "�༶���" };// ��ͷ�ֶ�
							student = new Object[1][5];
							student[0][0] = msg.getStudentNum();
							student[0][1] = msg.getStudentName();
							student[0][2] = msg.getStudentSex();
							student[0][3] = msg.getStudentBirthday();
							student[0][4] = msg.getClassId();
							// table.repaint();
							getTable();
//							table = null;
//							table = new JTable(student1, TableHead2);
//							table.setEnabled(false);
//							// System.out.println(table.getColumnCount());
//							table.setBounds(0, 0, 529, 407);
//							table.setFont(new Font("����", Font.BOLD, 14));
//							scrollPane = new JScrollPane();// ������
//							scrollPane.setBounds(5, 200, 839, 344);
//							getContentPane().add(scrollPane);
//							scrollPane.setViewportView(table);
							// ��ͷ
							flag = true;
						}
					}
					if (!flag) {// ����
						jOptionPane_LoginFeedback = new JOptionPane();
						jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
						jOptionPane_LoginFeedback.setLayout(null);
						// jOptionPane_LoginFeedback.setVisible(false);
						contentPane.add(jOptionPane_LoginFeedback);
						jOptionPane_LoginFeedback.setVisible(true);
						jOptionPane_LoginFeedback.showMessageDialog(contentPane, "û�и�ѧ��ѧ��", "������ʾ",
								OperationWindow.this.jOptionPane_LoginFeedback.ERROR_MESSAGE);

					}
				}
			}
		});

		// ---����3:�����ѯ����ѧ�����������в�ѯ ����һ�����߶����������ѯ
		button_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input_name = textField_1.getText();// �õ����������
				if (input_name.length() == 0) {// û����������
					jOptionPane_LoginFeedback = new JOptionPane();
					jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
					jOptionPane_LoginFeedback.setLayout(null);
					contentPane.add(jOptionPane_LoginFeedback);
					jOptionPane_LoginFeedback.setVisible(true);
					jOptionPane_LoginFeedback.showMessageDialog(contentPane, "�������ѯ����", "������ʾ",
							OperationWindow.this.jOptionPane_LoginFeedback.ERROR_MESSAGE);
				} else {
					TbStudentService tss = new TbStudentServiceImpl();
					List<TbStudent> stus = tss.getvaguaSearch(input_name.trim());
					for (TbStudent names : stus) {
						// System.out.println(names);
						 TableHead = new String[] { "ѧ��", "����", "�Ա�", "��������", "�༶���" };// ģ����ͷ�ֶ�

						 student = new Object[stus.size()][TableHead.length];
						for (i = 0; i < stus.size(); i++) {
							for (j = 0; j < TableHead.length; j++) {
								switch (j) {
								case 0:
									student[i][j] = stus.get(i).getStudentNum();
									break;
								case 1:
									student[i][j] = stus.get(i).getStudentName();
									break;
								case 2:
									student[i][j] = stus.get(i).getStudentSex();
									break;
								case 3:
									student[i][j] = stus.get(i).getStudentBirthday();
									break;
								case 4:
									student[i][j] = stus.get(i).getClassId();
									break;

								}
							}
						}
						getTable();
					}
				}

			}
		});

	}
	public void getTable(){
		table = null;
		table = new JTable(student, TableHead);
		table.setEnabled(false);
		table.setBounds(0, 0, 529, 407);
		table.setFont(new Font("����", Font.BOLD, 14));

		scrollPane.setBounds(5, 200, 839, 344);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
	}
}
