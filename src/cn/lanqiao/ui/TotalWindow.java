package cn.lanqiao.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class TotalWindow extends JFrame {
	public static int level;
	static String name;
	private JPanel contentPane;
	JOptionPane jOptionPane = new JOptionPane();
	static OperationWindow operationWindow;// ѧ������
	static ScoreWindow scoreWindow;// �ɼ�����
	static CourseWindow courseWindow;
	static ClassWindow classWindow;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalWindow frame = new TotalWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */

	public static void setFrameImage(JFrame jf) {
		// ��ȡ���������
		// public static Toolkit getDefaultToolkit():��ȡĬ�Ϲ��߰���
		Toolkit tk = Toolkit.getDefaultToolkit();

		// ����·����ȡͼƬ
		Image i = tk.getImage("src\\12.jpg");

		// ����������ͼƬ
		jf.setIconImage(i);
	}

	public TotalWindow(String name,int level) {
		this.name = name;
		this.level = level;
		System.out.println(level);
		setForeground(new Color(0, 0, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 731);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ImageIcon icon = new ImageIcon("src/Logo.jpg");
		setIconImage(icon.getImage());
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel labelTop = new JLabel("��ӭ"+name+"��������ѧ����Ϣ����ϵͳ");
		labelTop.setFont(new Font("����", Font.BOLD, 18));
		labelTop.setForeground(Color.BLUE);
		panelNorth.add(labelTop);
		// --------�ָ�-------------------------------
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		// ---------------JTree------------------------
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(// ���������нڵ��Լ��ӽڵ�

				new DefaultMutableTreeNode("����ϵͳ") {// ��ڵ�
					{
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("�ҵĹ���");
						node_1.add(new DefaultMutableTreeNode("ѧ������"));
						node_1.add(new DefaultMutableTreeNode("�ɼ�����"));
						node_1.add(new DefaultMutableTreeNode("�γ̹���"));
						node_1.add(new DefaultMutableTreeNode("�༶����"));
						node_1.add(new DefaultMutableTreeNode("��������"));
						add(node_1);
					}
				}

		));

		splitPane.setLeftComponent(tree);
		// -----------------�ұ�JPanel---------------------
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(10, 10, 870, 690);
		panel.add(label);
		
		

		JLabel panel2 = new JLabel("");
		panel2.setBounds(15, 16, 855, 555);
		panel2.setFont(new Font("����", Font.BOLD, 17));
		panel2.setIcon(new ImageIcon("src\\12.jpg"));
		panel.add(panel2);
		JFrame jf = new JFrame();
		Toolkit tk = Toolkit.getDefaultToolkit();

		// ����·����ȡͼƬ
		Image i = tk.getImage("src\\12.jpg");

		// ����������ͼƬ
		jf.setIconImage(i);

		// -----------------����tree����--------------------
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode lastSelectedPathComponent = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();

				if (lastSelectedPathComponent.toString().equals("ѧ������")) {
					operationWindow = new OperationWindow();
					label.add(operationWindow);
					operationWindow.setBorder(BorderFactory.createEtchedBorder());// ȥ���߿�
					operationWindow.setVisible(true);
					try {
						// operationWindow.setVisible(false);
						scoreWindow.setVisible(false);
						courseWindow.setVisible(false);
						classWindow.setVisible(false);
					} catch (Exception show) {

					}

				}
				if (lastSelectedPathComponent.toString().equals("�ɼ�����")) {
//					System.out.println("�ɼ�����");
					scoreWindow = ScoreWindow.getScoreWindow();
					label.add(scoreWindow);
					scoreWindow.setBorder(BorderFactory.createEtchedBorder());// ȥ���߿�
					scoreWindow.setVisible(true);
					try {
						operationWindow.setVisible(false);
						// scoreWindow.setVisible(false);
						courseWindow.setVisible(false);
						classWindow.setVisible(false);
					} catch (Exception show) {

					}

				}
				if (lastSelectedPathComponent.toString().equals("�γ̹���")) {
//					System.out.println("�γ̹���");
					courseWindow = CourseWindow.getCourseWindow();
					label.add(courseWindow);
					courseWindow.setBorder(BorderFactory.createEtchedBorder());
					courseWindow.setVisible(true);
					try {
						operationWindow.setVisible(false);
						scoreWindow.setVisible(false);
						classWindow.setVisible(false);
					} catch (Exception show) {

					}

				}

				if (lastSelectedPathComponent.toString().equals("�༶����")) {
//					System.out.println("�༶����");
					classWindow = ClassWindow.getClassWindow();
					label.add(classWindow);
					classWindow.setBorder(BorderFactory.createEtchedBorder());// ȥ���߿�
					classWindow.setVisible(true);
					try {
						operationWindow.setVisible(false);
						classWindow.setVisible(true);
						scoreWindow.setVisible(false);
						courseWindow.setVisible(false);
//						 classWindow.setVisible(false);
					} catch (Exception show) {

					}
				}
				
				
				if (lastSelectedPathComponent.toString().equals("��������")) {
						//System.out.println("��������");
						System.out.println("��������");
						jOptionPane.showMessageDialog(null, "ѧ����Ϣ����ϵͳ\n�汾�ţ�1.0\n���ߣ����ŵڶ���\n���ص�ַ:https://github.com/Npc-h\n���������ѧϰʹ��", "����", jOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});

	}
}
