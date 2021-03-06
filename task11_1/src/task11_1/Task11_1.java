//测试GUI图形用户界面程序

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
	
	JMenuBar menuBar;  					//菜单条
	JMenu menuFile;						//菜单“File”
	JMenuItem menuItemCreate;				//菜单项“Create”
	JMenu menuOpen;						//菜单“Open”
	JMenuItem menuItemSave;					//菜单项“Save”
	JMenuItem menuItemClose;				//菜单项“Close”
	JMenuItem menuItemFile1;				//菜单项“File1”
	JMenuItem menuItemFile2;	 	       		//菜单项“File2”
	JButton btnOK;      	         		  	//按钮OK
	
	public FirstWindow(){
		setLayout(new FlowLayout()); 			//设置窗口布局为FlowLayout
		init();						//初始化各对象
		setVisible(true); 				//设置可见
		setSize(640,360);
	}
	
	//初始化各对象
	public void init(){
		menuBar = new JMenuBar();  					//菜单条
		menuFile = new JMenu("File");					//菜单“File”
		menuItemCreate = new JMenuItem("Create");			//菜单项“Create”
		menuOpen = new JMenu("Open");					//菜单“Open”
		menuItemSave = new JMenuItem("Save");				//菜单项“Save”
		menuItemClose = new JMenuItem("Close");				//菜单项“Close”
		menuItemFile1 = new JMenuItem("File1");				//菜单项“File1”
		menuItemFile2 = new JMenuItem("File2");	        		//菜单项“File2”
		btnOK = new JButton("OK");      	        		//按钮OK
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
