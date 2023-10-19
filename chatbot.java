import javax.swing.Box;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.*;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
public class chatbot extends JFrame implements KeyListener,ActionListener{
	JPanel p=new JPanel();
	//ImageIcon img=new ImageIcon("C:\\Users\\hp\\Desktop\\w3.jpg");
	//JLabel background=new JLabel("",img,JLabel.CENTER);
	JTextArea dialog=new JTextArea(20,50);
	JTextArea input=new JTextArea(1,30);
	ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Desktop\\chat1.jfif");
    Box box = Box.createVerticalBox();
	JButton br=new JButton(new ImageIcon("C:\\Users\\hp\\Desktop\\smiley.png"));
	JButton b=new JButton(new ImageIcon("C:\\Users\\hp\\Downloads\\1.jpg"));
	JFrame frame=new JFrame();
	//private ImageIcon rotateIcon;
	//JRadioButton rotateButton = new JRadioButton();
	//ImageIcon icon1=new ImageIcon("C:\\Users\\hp\\Desktop\\w2.jpg");
	JScrollPane Scroll=new JScrollPane(
			dialog,
	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
);
 String[][] chatbot= {
		 {"hi","hai","hello","hola","howdy"},
		 {"hi","hello","hey","Hi","Hey","Hello"},
		 {"how are you","How r u","how r you","how r u","how are you"},
		 {"good","doing well","fine","Good","Doing well","Fine"},
		 {"yes","s","Yes"},
		 {"no","No","NO!!!!!"},
		 {"shutup","you're bad","nope","stop talking",("Not available")}
		 };
public static void main(String [] args) {
	new chatbot();  
	}
public chatbot() {
	super("chatbot");
    setSize(600,500);
    setResizable(false);
    setIconImage (icon.getImage());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    dialog.setEditable(false);
    input.addKeyListener(this);   
    p.add(Scroll);
    p.add(input);
    //br.setSize(100,20);
    p.add(br);
    br.setBounds(400,500,20,60);
    br.setVisible(true);
    p.add(b);
    b.setVisible(true);
	//frame.add(br);
   // background.setSize(600,610);setVisible(true);
   // dialog.add(background);
	//setVisible(true);
    p.setBackground(new Color(72,61,139));
    add(p);
    setVisible(true);
  }
	
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		input.setEditable(false);
	 	String quote=input.getText();
		input.setText(" ");
		addText("+--You:\t" +quote);
		quote.trim();
		while(quote.charAt(quote.length()-1)=='!'||
				quote.charAt(quote.length()-1)=='.'||
		quote.charAt(quote.length()-1)=='?'){
			quote=quote.substring(0,quote.length()-1);
		}
			quote.trim();
			byte response=0;
			int j=0;
			while(response==0) {
				if(inArray(quote.toLowerCase(),chatbot[j*2])) {
					response=2;
				int r= (int)Math.floor(Math.random()*chatbot[(j*2)+1].length);
				addText("\n-->Chitti\t" +chatbot[(j*2)+1][r]);
				}
				j++;
				if(j*2==chatbot.length-1 && response==0) {
					response=1;
				}
				}
			if(response==1) {int r=(int)Math.floor(Math.random()*chatbot[chatbot.length-1].length);
			addText("\n-->Chitti\t" +chatbot[chatbot.length-1][r]);}
			addText("\n");
			}
				}	

public void keyTyped(KeyEvent e) {}

private void addText(String str) {
dialog.setText(dialog.getText() +str);
}
private boolean inArray(String in, String[] str) {
	boolean match=false;
	for(int i=0;i<str.length;i++) {
		if(str[i].contentEquals(in)) {
			match=true;
		}
	}
	return match;
}
public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			input.setEditable(true);
		}
}
public void actionPerformed(ActionEvent e) {
	b.addActionListener(this);
	Frame f1=new Frame("Attachments");JMenuItem open; open=new JMenuItem("Open File");      
	open.addActionListener(this); 
	if(e.getSource()==open){    
	    JFileChooser fc=new JFileChooser();    
	    int i=fc.showOpenDialog(this);    
	    if(i==JFileChooser.APPROVE_OPTION){    
	        File f=fc.getSelectedFile();JTextArea ta;    
	        String filepath=f.getPath();    
	        try{  
	        BufferedReader br=new BufferedReader(new FileReader(filepath));    
	        String s1="",s2="";                         
	        while((s1=br.readLine())!=null){    
	        s2+=s1+"\n";    
	        }    
	        ta=new JTextArea(800,800);    
	        ta.setBounds(0,20,800,800);  ta.setText(s2);          
	        br.close();    
	        }catch (Exception ex) {ex.printStackTrace();  }                 
	    }    
	}    
}
	

}
