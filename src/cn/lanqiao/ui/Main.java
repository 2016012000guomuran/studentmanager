package cn.lanqiao.ui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/*
 * ����ʼ����½���
 * @author ���ŵڶ���
 * 
 */
public class Main {

	public static void main(String[] args) {
		//�����¼������߳� ��������
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//����ƽ̨Ĭ�ϴ���
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 new LoginClass();
			}
		});		
	}
	
	

}
