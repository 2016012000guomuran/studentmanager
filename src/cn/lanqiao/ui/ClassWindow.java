package cn.lanqiao.ui;

import java.awt.Color;
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

public class ClassWindow extends JInternalFrame {

	private JPanel ClasscontentPane;
	private static ClassWindow classWindow = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private ClassWindow() {
		setVisible(true);

		setBounds(0, -28, 870, 627);

		ClasscontentPane = new JPanel();
		ClasscontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ClasscontentPane);
		ClasscontentPane.setLayout(null);

		JPanel panelNorth = new JPanel();
		panelNorth.setBounds(5, 5, 844, 31);
		ClasscontentPane.add(panelNorth);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		


		JLabel label = new JLabel("�༶����");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("����", Font.BOLD, 18));
		panelNorth.add(label);
		
		JButton AddClassbutton = new JButton("�����༶");
		AddClassbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//�����༶����
				AddClass addClass = AddClass.getAddClass();
				addClass.setVisible(true);
				addClass.setLocationRelativeTo(null);
			}
		});
		AddClassbutton.setBounds(58, 496, 111, 37);
		ClasscontentPane.add(AddClassbutton);
		
		JButton RemoveClassButton = new JButton("ɾ���༶");
		RemoveClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveClass removeClass = RemoveClass.getRemoveClass();
				removeClass.setVisible(true);
				removeClass.setLocationRelativeTo(null);
			}
		});
		RemoveClassButton.setBounds(246, 496, 111, 37);
		ClasscontentPane.add(RemoveClassButton);
		
		JButton SelectClassButton = new JButton("��ѯ�༶");
		SelectClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println("�Ƿ�󶨳ɹ�");
				LookClass lookClass =  LookClass.getLookClass();
				lookClass.setVisible(true);
				lookClass.setLocationRelativeTo(null);
			}
		});
		SelectClassButton.setBounds(665, 496, 111, 37);
		ClasscontentPane.add(SelectClassButton);
		
		JButton UpdateClassButton = new JButton("�޸İ༶");
		UpdateClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		UpdateClassButton.setBounds(454, 496, 111, 37);
		ClasscontentPane.add(UpdateClassButton);
		
		JButton btnNewButton = new JButton("�༶����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddScore addScore = AddScore.getAddScore();
				addScore.setVisible(true);
				addScore.setLocationRelativeTo(null);
			}
			
		});
		
		if(TotalWindow.level==2) {
			AddClassbutton.setVisible(false);
			RemoveClassButton.setVisible(false);
			UpdateClassButton.setVisible(false);
		}
		
		
		JLabel backLabelclass = new JLabel("");
		backLabelclass.setForeground(Color.WHITE);
		backLabelclass.setBounds(0, 0, 860, 600);
		backLabelclass.setIcon(new ImageIcon("src\\��ͼ1.jpg"));
		ClasscontentPane.add(backLabelclass);	
		
	
	}
		
		// ����ģʽ
		public static synchronized ClassWindow getClassWindow() {
			if (classWindow == null) {
				classWindow = new ClassWindow();
			}
			return classWindow;
		
		
}
	
	
	
	}
