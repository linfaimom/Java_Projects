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
		add(new JLabel("����������"));
		txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(100,30));
		add(txtName);
		checkAtSchool = new JCheckBox("��У��");
		add(checkAtSchool);
		radioMale = new JRadioButton("��");
		radioFemale = new JRadioButton("Ů");
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
		comboZZMM.addItem("�й���Ա");
		comboZZMM.addItem("������Ա");
		comboZZMM.addItem("��������");
		comboZZMM.setSelectedIndex(0);
		comboZZMM.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				switch (arg0.getItem().toString()) {
				case "�й���Ա":
					txtName.setForeground(Color.red);
					break;
				case "������Ա":
					txtName.setForeground(Color.pink);
					break;
				case "��������":
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
					txtSummary.append("�Ƿ���У:��\r\n");
				}
				else {
					txtSummary.append("�Ƿ���У:��\r\n");
				}
				if(radioMale.isSelected()){
					txtSummary.append("�Ա�:��\r\n");
				}
				else{
					txtSummary.append("�Ա�:Ů\r\n");
				}
				txtSummary.append("������ò:"+comboZZMM.getSelectedItem().toString()+"\r\n");
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
