package task11_6;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Component extends JFrame{
	JLabel label;
	JButton btn;
	JTextField txtInput,txtOutput;
	
	public Component(){
		super();
		init();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init(){
		setLayout(new FlowLayout());
		setSize(400,300);
		label = new JLabel("����������:");
		add(label);
		txtInput = new JTextField();
		txtInput.setPreferredSize(new Dimension(100,30));
		add(txtInput);
		btn = new JButton("����׳�");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int num;
				int result = 1;
				num = Integer.parseInt(txtInput.getText().toString());
				if(num==0 || num==1){
					txtOutput.setText(""+num);
				}
				else{
					for(;num>0;num--){
						result = num * result;
					}
					txtOutput.setText(""+result);
				}
			}
		});
		add(btn);
		txtOutput = new JTextField();
		txtOutput.setPreferredSize(new Dimension(100,30));
		add(txtOutput);
	}
}

public class Task11_6 {
	public static void main(String[] args) {
		Component fifth = new Component();
	}
}