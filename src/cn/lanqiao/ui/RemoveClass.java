package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbClass;
import cn.lanqiao.service.TbClassService;
import cn.lanqiao.service.impl.TbClassServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class RemoveClass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JOptionPane jOptionPane_LoginFeedback = new JOptionPane();
	private static RemoveClass removeClass = null;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private RemoveClass() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 547, 37);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("ɾ���༶");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.BLUE);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("������༶���:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel_1.setBounds(107, 197, 155, 35);

		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(323, 202, 142, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("ȷ��ɾ��");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ɾ��������
				if (textField.getText().length() == 0) {
					jOptionPane_LoginFeedback = new JOptionPane();
					jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
					jOptionPane_LoginFeedback.setLayout(null);
					contentPane.add(jOptionPane_LoginFeedback);
					jOptionPane_LoginFeedback.setVisible(true);
					jOptionPane_LoginFeedback.showMessageDialog(contentPane, "������༶���", "������ʾ",
							jOptionPane_LoginFeedback.ERROR_MESSAGE);
				} else {
					TbClassService ourClass = new TbClassServiceImpl();
					List<TbClass> showClass = ourClass.getAllTbClass();
					Boolean flag = false;
					for (TbClass tbClass : showClass) {
						if(String.valueOf(tbClass.getClassId()).equals(textField.getText())){
							ourClass.removeTbClass(tbClass);
							jOptionPane_LoginFeedback = new JOptionPane();
							jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
							jOptionPane_LoginFeedback.setLayout(null);
							contentPane.add(jOptionPane_LoginFeedback);
							jOptionPane_LoginFeedback.setVisible(true);
							ImageIcon icn = new ImageIcon();
							String msg = "�ɹ�ɾ�����Ϊ    "+textField.getText()+" �İ༶���";
							jOptionPane_LoginFeedback.showMessageDialog(contentPane,msg, "������ʾ",
									jOptionPane_LoginFeedback.ERROR_MESSAGE,icn);
							flag = true;
							break;
						}
						
					}
					
					 if(!flag){
							jOptionPane_LoginFeedback = new JOptionPane();
							jOptionPane_LoginFeedback.setBounds(new Rectangle(28, 263, 262, 90));
							jOptionPane_LoginFeedback.setLayout(null);
							contentPane.add(jOptionPane_LoginFeedback);
							jOptionPane_LoginFeedback.setVisible(true);
							String msg = "û�б��Ϊ  "+textField.getText()+" �İ༶���";
							jOptionPane_LoginFeedback.showMessageDialog(contentPane,msg, "������ʾ",
									jOptionPane_LoginFeedback.ERROR_MESSAGE);
						}
				}
			}
		});
		btnNewButton.setBounds(228, 318, 109, 27);
		contentPane.add(btnNewButton);

	}

	public static synchronized RemoveClass getRemoveClass(){
		if(removeClass==null){
			removeClass = new RemoveClass();
		}
		return removeClass;
	}

}
