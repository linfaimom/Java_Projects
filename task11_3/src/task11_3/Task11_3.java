package task11_3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	Component window = this;
	
	public Component(){
		super();
		init();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init(){
		setLayout(new FlowLayout());
		setSize(400,300);
		JLabel label = new JLabel("请输入姓名");
		add(label);
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
		add(radioFemale);
		add(radioMale);
		comboZZMM = new JComboBox();
		comboZZMM.addItem("中共党员");
		comboZZMM.addItem("共青团员");
		comboZZMM.addItem("民主党派");
		comboZZMM.setSelectedIndex(0);
		add(comboZZMM);
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				window.setTitle(txtName.getText().toString());
			}
		});
		add(btnOK);
		txtSummary = new JTextArea(10,30);
		add(txtSummary);
	}
}

public class Task11_3 {
	public static void main(String[] args) {
		Component second = new Component();
	}
}
