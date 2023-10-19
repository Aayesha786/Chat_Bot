import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.*;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class chatbot2 extends JFrame implements KeyListener{
	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(30,50);
	JTextArea input=new JTextArea(1,40);
    Box box = Box.createVerticalBox();
	Button br=new Button("Emoji");
	JFrame frame=new JFrame(); 
	Frame f=new Frame();
	Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\chat1.jfif");     
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
	new chatbot2();
	}
public chatbot2() {
	super("chatbot");
  setSize(600,400);
  setResizable(true);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  dialog.setEditable(true);
  input.addKeyListener(this);
  frame.add(Scroll);
  p.add(input);frame.add(box);
  p.add(br);f.setIconImage(icon);
  p.setBackground(new Color(255,200,0));
  add(p);f.paint(getGraphics());
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
	
public void paint(Graphics g) { 
	  
    Toolkit t=Toolkit.getDefaultToolkit();  
    Image i=t.getImage("C:\\Users\\hp\\Desktop\\w3.jpg");  
    g.drawImage(i, 120,100,this);  
      
}
}
