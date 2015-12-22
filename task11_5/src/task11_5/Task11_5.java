package task11_5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class Component extends JFrame{
	JTextField txtName;
	JCheckBox checkAtSchool;
	JRadioButton radioMale,radioFemale;
	JComboBox comboZZMM;
	JTextArea txtSummary;
	JButton btnOK;
	
	public Component(){
		super();
		init();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init(){
		setLayout(new FlowLayout());
		setSize(400,300);
		add(new JLabel("请输入姓名"));
		txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(100,30));
		add(txtName);
		checkAtSchool = new JCheckBox("在校生");
		add(checkAtSchool);
		radioMale = new JRadioButton("男");
		radioFemale = new JRadioButton("女");
		radioMale.setSelected(true);
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radioMale);
		radioGroup.add(radioFemale);
		ChangeListener cListener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(radioMale.isSelected()){
					radioMale.setForeground(Color.red);
					radioFemale.setForeground(Color.black);
				}
				else{
					radioMale.setForeground(Color.black);
					radioFemale.setForeground(Color.blue);
				}
			}
		};
		radioFemale.addChangeListener(cListener);
		radioMale.addChangeListener(cListener);
		add(radioFemale);
		add(radioMale);
		comboZZMM = new JComboBox();
		comboZZMM.addItem("中共党员");
		comboZZMM.addItem("共青团员");
		comboZZMM.addItem("民主党派");
		comboZZMM.setSelectedIndex(0);
		comboZZMM.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				switch (arg0.getItem().toString()) {
				case "中共党员":
					txtName.setForeground(Color.red);
					break;
				case "共青团员":
					txtName.setForeground(Color.pink);
					break;
				case "民主党派":
					txtName.setForeground(Color.blue);
					break;
				default:
					txtName.setForeground(Color.black);
					break;
				}
			}
		});
		add(comboZZMM);
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtSummary.append(txtName.getText().toString()+"\r\n");
				if(checkAtSchool.isSelected()){
					txtSummary.append("是否在校:是\r\n");
				}
				else {
					txtSummary.append("是否在校:否\r\n");
				}
				if(radioMale.isSelected()){
					txtSummary.append("性别:男\r\n");
				}
				else{
					txtSummary.append("性别:女\r\n");
				}
				txtSummary.append("政治面貌:"+comboZZMM.getSelectedItem().toString()+"\r\n");
			}
		});
		add(btnOK);
		txtSummary = new JTextArea(10,30);
		txtSummary.setEditable(true);
		add(txtSummary);
	}
}

public class Task11_5 {
	public static void main(String[] args) {
		Component fourth = new Component();
	}
}
