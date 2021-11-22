import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class calc2 implements ActionListener {
	JFrame frame;
	JPanel panel;
	JPanel[] smallpanels;
	JButton[][] barray;
	JTextField field;
	JLabel label;
	String fieldnum1="";
	String fieldnum2="";
	String op;
	Font bigFont=new Font("serif",Font.BOLD,28);
	public  static void main(String[] args){
		calc2 abc= new calc2();
		abc.go();

	}
	
	public void go(){
		frame=new JFrame("My calc");
		panel=new JPanel();

		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		smallpanels =new JPanel[4];
		barray = new JButton[4][4];
		field=new JTextField(20);
		field.setFont(bigFont);
		label=new JLabel("Made by ARHAM AMROHI");
		panel.add(label);
		panel.add(field);

		smallpanels[0]=new JPanel();
		
			panel.add(smallpanels[0]);
		for(int i=1;i<4;i++){
		panel.add(smallpanels[i]=new JPanel());
		

			for(int j=0;j<3;j++){
				barray[i][j]=new JButton(String.valueOf(12-(3*i)-j));
				
				}
			}
			

			barray[0][0]=new JButton("0");
			
			
			barray[0][1]=new JButton(".");
			
			barray[0][2]=new JButton("=");
			
			barray[0][3]=new JButton("/");
			
			barray[1][3]=new JButton("x");
			
			barray[2][3]=new JButton("-");
			
			barray[3][3]=new JButton("+");
			


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setSize(300,350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				barray[i][j].addActionListener(this);
				barray[i][j].setFont(bigFont);
				smallpanels[i].add(barray[i][j]);

			}
		}
		System.out.println(smallpanels[0].getHeight());

		System.out.println(field.getSize());
	}

	public void actionPerformed(ActionEvent event){
		String e=event.getActionCommand();
		System.out.println(e);
		
		if(e=="+"||e=="-"||e=="/"||e=="x"){
			fieldnum1=fieldnum2;
			op=e;
			fieldnum2="";
		}
		else if(e=="="){
			int a=Integer.parseInt(fieldnum1);
			int b=Integer.parseInt(fieldnum2);
			if(op=="+"){
				fieldnum2=String.valueOf(a+b);
			}
			else if(op=="-"){
				fieldnum2=String.valueOf(a-b);
			}
			
			else if(op=="/"){
				fieldnum2=String.valueOf(a/b);
			}
			else {
				fieldnum2=String.valueOf(a*b);
			}
			fieldnum1="";
		}

		else{

			fieldnum2=fieldnum2+e;
			}
		
		
		field.setText(fieldnum2);
	}


}