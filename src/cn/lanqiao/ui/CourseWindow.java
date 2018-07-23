package cn.lanqiao.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CourseWindow extends JInternalFrame {

	
	private JPanel CourseWindowPane;
	private static CourseWindow courseWindow = null;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CourseWindow() {
		setVisible(true);
		setBounds(0, -28, 870, 627);
		//�������
		CourseWindowPane = new JPanel();
		CourseWindowPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(CourseWindowPane);
		CourseWindowPane.setLayout(null);
		
		//����Ŀ�
		JPanel CoursepanelNorth = new JPanel();
		CoursepanelNorth.setBounds(5, 5, 844, 31);
		CourseWindowPane.add(CoursepanelNorth);
		CoursepanelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("�γ̹���");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("����", Font.BOLD, 18));
		CoursepanelNorth.add(label);
		
		JButton AddCoursebutton = new JButton("�¿��γ�");
		AddCoursebutton.setBounds(58, 496, 111, 37);
		CourseWindowPane.add(AddCoursebutton);
		
		JButton RemoveCourseButton = new JButton("ɾ���γ�");
		RemoveCourseButton.setBounds(246, 496, 111, 37);
		CourseWindowPane.add(RemoveCourseButton);
		
		JButton SelectCourseButton = new JButton("�鿴�γ�");
		SelectCourseButton.setBounds(665, 496, 111, 37);
		CourseWindowPane.add(SelectCourseButton);
		
		
		
		JButton UpdateCourseButton = new JButton("�޸Ŀγ�");
		UpdateCourseButton.setBounds(454, 496, 111, 37);
		CourseWindowPane.add(UpdateCourseButton);
		
		if(TotalWindow.level==2) {
			AddCoursebutton.setVisible(false);
			RemoveCourseButton.setVisible(false);
			UpdateCourseButton.setVisible(false);
		}
		
		JButton btnNewButton = new JButton("�γ̹���");
	/*	btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddScore addScore = AddScore.getAddScore();
				addScore.setVisible(true);
				addScore.setLocationRelativeTo(null);
			}
			
		});*/
		
		JLabel backLabelclassCourse = new JLabel("");
		backLabelclassCourse.setForeground(Color.WHITE);
		backLabelclassCourse.setBounds(0, 0, 855, 600);
		backLabelclassCourse.setIcon(new ImageIcon("src\\��ͼ4.jpg"));
		CourseWindowPane.add(backLabelclassCourse);	
		
		//���Ӽ���
		AddCoursebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse addcourse = AddCourse.getaddcourse();
				addcourse.setVisible(true);
				addcourse.setLocationRelativeTo(null);
			}
		});
		//ɾ������
		RemoveCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveCourse removeCourse =  new RemoveCourse();//�����´���
				removeCourse.frame.setVisible(true);
			}//
		});
		
		
		//�޸ļ���
		UpdateCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCourse updateCourse = new UpdateCourse();
				updateCourse.frame.setVisible(true);
			}
		});
		//�鿴����
		SelectCourseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LookCourse lookCourse = LookCourse.getLookcourse();
				lookCourse.setVisible(true);
				lookCourse.setLocationRelativeTo(null);
				
			}
			
		});
		
	}
	
		
		// ����ģʽ
	public static synchronized CourseWindow getCourseWindow() {
		if (courseWindow == null) {
			courseWindow = new CourseWindow();
		}
		return courseWindow;

	}

}
