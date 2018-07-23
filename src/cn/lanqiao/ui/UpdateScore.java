package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.lanqiao.model.TbScore;
import cn.lanqiao.model.TbScore;
import cn.lanqiao.service.TbScoreService;
import cn.lanqiao.service.TbScoreService;
import cn.lanqiao.service.impl.TbScoreServiceImpl;
import cn.lanqiao.service.impl.TbScoreServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class UpdateScore extends JFrame {

	private JPanel contentPane;
	static JFrame frame;
	JOptionPane jOptionPane = new JOptionPane();
	private static UpdateScore updateScore = null;
	private JTextField textField_1;
	//����Ҫ�޸ĵĳɼ�����
	TbScore tbScore = null;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	private UpdateScore() {
		
		frame = new JFrame();
		frame.setTitle("�ɼ��޸�");
		frame.setBounds(100, 100, 570, 460);
		frame.dispose();//ֻ�ر��Ӵ���,��Ӱ����������
		frame.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("�������µĳɼ���");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel_1.setBounds(130, 172, 139, 37);
		contentPane.add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(283, 174, 108, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ȷ���޸�");
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(222, 303, 128, 44);
		contentPane.add(btnNewButton);
			
		JLabel lblNewLabel = new JLabel("������ɼ���ţ�");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(107, 46, 139, 33);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 45, 108, 33);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("ȷ��");
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(362, 44, 113, 34);
		contentPane.add(btnNewButton_1);
		
		jOptionPane.setBounds(new Rectangle(28, 316, 260, 110));
		jOptionPane.setLayout(null);
		contentPane.add(jOptionPane);
		
		frame.getContentPane().add(contentPane);
		
		//���ؿؼ�
		textField.setVisible(false);
		lblNewLabel_1.setVisible(false);
		btnNewButton.setVisible(false);
		
		
		
		//ȷ�ϳɼ����
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ȼ���ɼ���Ŵ���
				boolean cheng=true;
				// �쳣�ж�
				if (textField_1.getText().length() == 0) {
					jOptionPane.showMessageDialog(null, "�ɼ���Ų���Ϊ�գ�", "�� ʾ",jOptionPane.INFORMATION_MESSAGE);
				} else {
					TbScoreService se = new TbScoreServiceImpl();
					List<TbScore> ses = se.getAllTbScore();
					for (TbScore s : ses) {
						if ((s.getScoreId()+ "").equals(textField_1.getText())) {
							cheng = false;
							tbScore = s;
							//��ʾ���صĿؼ�
							textField.setVisible(true);
							lblNewLabel_1.setVisible(true);
							btnNewButton.setVisible(true);
							
//							textField_2.setText(s.getScoreName());
//							textField_4.setText(s.getScoreBirthday());
							jOptionPane.showMessageDialog(null, "������Ҫ���µ���Ϣ","�� ʾ",jOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
					if(cheng) {
						jOptionPane.showMessageDialog(null, "û�иóɼ����","�� ʾ",jOptionPane.INFORMATION_MESSAGE);
					}	
				}
			}
		});
		
		//�޸� �ɼ�
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �쳣�ж�
				if (textField.getText().trim().equals("")) {
					jOptionPane.showMessageDialog(null, "������ɼ���", "�� ʾ", jOptionPane.INFORMATION_MESSAGE);
				} else  {
					
					TbScoreService se = new TbScoreServiceImpl();
					tbScore.setScoreGrade(Integer.parseInt(textField.getText()));
					se.updateTbScore(tbScore);
					System.out.println("�޸ĳɹ�");
					frame.dispose();
					jOptionPane.showMessageDialog(null, "�޸ĳɹ�����ˢ������","�� ʾ",jOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
	}
	public static synchronized UpdateScore getUpdateScore(){
		if(updateScore==null){
			 updateScore = new UpdateScore();
		}
		return updateScore;
	}

}
