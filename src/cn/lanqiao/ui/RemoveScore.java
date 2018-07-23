package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbScore;
import cn.lanqiao.model.TbStudent;
import cn.lanqiao.service.TbScoreService;
import cn.lanqiao.service.TbStudentService;
import cn.lanqiao.service.impl.TbScoreServiceImpl;
import cn.lanqiao.service.impl.TbStudentServiceImpl;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class RemoveScore extends JFrame {
	
	static JFrame frame;
	private JTextField textField;
	JOptionPane jOptionPane = new JOptionPane();
	private static RemoveScore removeScore = null;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private RemoveScore() {
		
		frame = new JFrame();
		frame.setTitle("�ɼ�ɾ��");
		frame.setBounds(100, 100, 600, 450);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ȫ���ر�
//		frame.DISPOSE_ON_CLOSE
		frame.dispose();//ֻ�ر��Ӵ���,��Ӱ����������
		frame.setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("�ɼ�ɾ��");
		label.setBounds(230, 90, 1100, 50);
		label.setFont(new Font("����", Font.BOLD, 23));
		label.setForeground(Color.BLUE);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("������ɼ���ţ�");
		lblNewLabel.setBounds(108, 176, 140, 35);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(325, 178, 155, 33);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("ȷ��ɾ��");
		btnNewButton.setBounds(222, 288, 126, 43);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("����", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
	
		frame.getContentPane().add(contentPane);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ȼ���ɼ���Ŵ���
				boolean cheng=true;
				// �쳣�ж�
				if (textField.getText().length() == 0) {
					
					jOptionPane.showMessageDialog(null, "�ɼ���Ų���Ϊ�գ�", "�� ʾ",
							jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbScoreService sc = new TbScoreServiceImpl();
					List<TbScore> scs = sc.getAllTbScore();
					for (TbScore s : scs) {
						if ((s.getScoreId() + "").equals(textField.getText())) {
							cheng = false;
							sc.removeTbScore(s);
							System.out.println("ɾ���ɹ�");
							frame.dispose();
							jOptionPane.showMessageDialog(null, "ɾ���ɹ�����ˢ������","�� ʾ",
									jOptionPane.INFORMATION_MESSAGE);
							break;
	
						}
					}
					if(cheng) {
						jOptionPane.showMessageDialog(null, "û�иóɼ����","�� ʾ",
								jOptionPane.INFORMATION_MESSAGE);

					}
					
				}
			}
		});
	}
	
	public static synchronized RemoveScore getRemoveScore(){
		if(removeScore==null){
			removeScore = new RemoveScore();
		}
		return removeScore;
	}

}
