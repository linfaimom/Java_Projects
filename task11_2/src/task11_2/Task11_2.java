package task11_2;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		add(radioFemale);
		add(radioMale);
		comboZZMM = new JComboBox();
		comboZZMM.addItem("�й���Ա");
		comboZZMM.addItem("������Ա");
		comboZZMM.addItem("��������");
		comboZZMM.setSelectedIndex(0);
		add(comboZZMM);
		btnOK = new JButton("OK");
		add(btnOK);
		txtSummary = new JTextArea(10,30);
		add(txtSummary);
	}
}

public class Task11_2 {
	public static void main(String[] args) {
		Component first = new Component();
	}
}
