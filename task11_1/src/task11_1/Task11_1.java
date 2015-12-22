//����GUIͼ���û��������

package task11_1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class FirstWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;  					//�˵���
	JMenu menuFile;						//�˵���File��
	JMenuItem menuItemCreate;				//�˵��Create��
	JMenu menuOpen;						//�˵���Open��
	JMenuItem menuItemSave;					//�˵��Save��
	JMenuItem menuItemClose;				//�˵��Close��
	JMenuItem menuItemFile1;				//�˵��File1��
	JMenuItem menuItemFile2;	 	       		//�˵��File2��
	JButton btnOK;      	         		  	//��ťOK
	
	public FirstWindow(){
		setLayout(new FlowLayout()); 			//���ô��ڲ���ΪFlowLayout
		init();						//��ʼ��������
		setVisible(true); 				//���ÿɼ�
		setSize(640,360);
	}
	
	//��ʼ��������
	public void init(){
		menuBar = new JMenuBar();  					//�˵���
		menuFile = new JMenu("File");					//�˵���File��
		menuItemCreate = new JMenuItem("Create");			//�˵��Create��
		menuOpen = new JMenu("Open");					//�˵���Open��
		menuItemSave = new JMenuItem("Save");				//�˵��Save��
		menuItemClose = new JMenuItem("Close");				//�˵��Close��
		menuItemFile1 = new JMenuItem("File1");				//�˵��File1��
		menuItemFile2 = new JMenuItem("File2");	        		//�˵��File2��
		btnOK = new JButton("OK");      	        		//��ťOK
		menuBar.add(menuFile);
		//menuBar.add(menuOpen);
		menuFile.add(menuItemCreate);
		menuFile.add(menuItemClose);
		menuFile.add(menuItemSave);
		menuFile.add(menuOpen);
		menuOpen.add(menuItemFile1);
		menuOpen.add(menuItemFile2);
		setJMenuBar(menuBar);
		add(btnOK);
	}
}

public class Task11_1 {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		FirstWindow first = new FirstWindow();
	}
}