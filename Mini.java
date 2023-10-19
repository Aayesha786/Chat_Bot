import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 public class Mini extends JFrame implements KeyListener,ActionListener{
	JPanel p=new JPanel();
	ImageIcon img=new ImageIcon("C:\\Users\\hp\\Desktop\\w3.jpg");
	JLabel background=new JLabel("",img,JLabel.CENTER);
	JFrame frame=new JFrame("Chat Bot");
	JButton b=new JButton(new ImageIcon("C:\\Users\\hp\\Desktop\\smiley.png"));
	JButton br=new JButton(new ImageIcon("C:\\Users\\hp\\Downloads\\1.jpg"));
	int c,n;
    String s1,s2,s3,s4,s5;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17;
    Panel p1;
    TextField tf;
    GridLayout grid;
	JButton send=new JButton(new ImageIcon("C:\\Users\\hp\\Desktop\\send button.png"));  
	ImageIcon icon=new ImageIcon("C:\\Users\\hp\\Desktop\\chat1.jfif"); 
    JTextArea dialog=new JTextArea(30,50);
	 JTextArea input=new JTextArea(1,20);
	 JScrollPane scroll=new JScrollPane(dialog,
			 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	 String[][] Chatbot={
			 {"hi","hai","hello","hola","howdy","Hi","Hai","Hello","Hola","Howdy"},
			 {"hi","hello","hey","Hi","Hello","Hey"},
			 {"how are you","How r u","how r you","how r u","how are you"},
			 {"Good","doing well","fine","good","Doing Well","Fine"},
			 {"Yes","yes","Yeah","yeah"},
			 {"no","No","NO!!!!!"},
			 {"shut up","you're bad","nope","stop talking",("Not available ")}
	 }; 
 public static void main(String[] args){
		 new Mini();
	 }
	 public Mini(){
	super("Chat Bot");
	setSize(600,610);
	setResizable(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	p.setBackground(new Color(72,61,138));
	setVisible(true);
	input.addKeyListener(this);
	p.add(scroll);
	p.add(input);
	dialog.paint(getGraphics());
	//background.setBounds(0,0,300,500);
	background.setSize(600,610);setVisible(true);
	dialog.add(background);
	setVisible(true);
	p.add(b);br.addActionListener(this);
	p.add(br);
	p.add(send);
	setIconImage (icon.getImage());
	dialog.paint(getGraphics());
	add(p);
	dialog.setEditable(true);setVisible(true);
	 }
	public void keyPressed(KeyEvent e) {
	if((e.getKeyCode()==KeyEvent.VK_ENTER)){
		input.setEditable(true);	}
	    String quote=input.getText(); 
	    input.setText("");
	    addText("+-->You:\t" +quote);
	    quote.trim();
	 while(quote.charAt(quote.length()-1)=='!'||
		   quote.charAt(quote.length()-1)=='.'||
		   quote.charAt(quote.length()-1)=='?'){
		   quote=quote.substring(0,quote.length()-1);
	    }
	    quote.trim();
	    byte response=0;
	    int j=0;
	    while(response==0){
	    	if(inArray(quote.toLowerCase(),Chatbot[j*2])){
	    		response=2;
	    		int r=(int)Math.floor(Math.random()*Chatbot[(j*2)+1].length);
	    		addText("\n-->Bot\t" +Chatbot[(j*2)+1][r]);}
	    	j++;
	    	if(j*2==Chatbot.length-1&&response==0){
	    		response=1;
	    	}
	    }	
	    if(response==1){
	    	int r=(int)Math.floor(Math.random()*Chatbot[Chatbot.length-1].length);
	    	addText("\n-->Bot\t" +Chatbot[Chatbot.length-1][r]);}
	    addText("\n");
		}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	public void keyTyped(KeyEvent e) {}
	private void addText(String str) {
		dialog.setText(dialog.getText() +str);
	}
	 public boolean inArray(String in,String[] str){
		 boolean match=false;
		 for(int i=0;i<str.length;i++){
			 if(str[i].equals(in)){
				 match=true;
			 }
		 }
		 return match;
	  
	 }
	public void actionPerformed(ActionEvent e) {
	}
	}
 