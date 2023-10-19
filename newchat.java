import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class newchat extends JFrame{
	private JTextArea chatarea=new JTextArea();
    private JTextField chatbox=new JTextField();
    public newchat() {
    	final JFrame frame=new JFrame("Chatbot");
    	JButton b=new JButton(new ImageIcon("C:\\Users\\hp\\Desktop\\smiley.png"));
    	JButton br=new JButton(new ImageIcon("C:\\Users\\hp\\Downloads\\1.jpg"));
    	ImageIcon icon=new ImageIcon("C:\\Users\\hp\\Desktop\\chat1.jfif");
    	ImageIcon img=new ImageIcon("C:\\Users\\hp\\Downloads\\background1.png");
    	ImageIcon img1=new ImageIcon("C:\\Users\\hp\\Desktop\\w3.jpg");
    	final JLabel background1=new JLabel("",img1,JLabel.CENTER);
    	final JLabel background=new JLabel("",img,JLabel.CENTER);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	frame.setSize(600,600);
    	frame.setVisible(true);
    	frame.setResizable(true);
    	frame.setLayout(null);
    	frame.setIconImage (icon.getImage());
    	setVisible(true);
    	frame.add(background1);
    	background1.setBounds(0,0,600,600);
    	setVisible(true);
    	frame.add(b); 
    	b.setBounds(400,500,60,60);
    	b.setVisible(true);
    	frame.add(br);
    	br.setBounds(475,500,60,60);
    	br.setVisible(true);
    	frame.add(chatarea);
    	//chatarea.add(background);
    	//background.setBounds(0,0,600,600);
    	//setVisible(true);
    	frame.add(chatbox);
    	setVisible(true);
    	chatarea.setSize(550,450);
    	chatarea.setLocation(2,2);
    	chatbox.setBackground(Color.WHITE);setVisible(true);
    	chatbox.setSize(300,30);
    	chatbox.setLocation(2,500);
    	setVisible(true);
    	final JTextArea area=new JTextArea();
    	 chatbox.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				final String gtext=chatbox.getText();
				chatbox.setBackground(Color.WHITE);setVisible(true);
		    	chatbox.setSize(300,30);
		    	chatbox.setLocation(2,500);
		    	setVisible(true);
				frame.add(chatarea);
				//chatarea.add(background);
		    	//background.setBounds(0,0,600,600);
		    	//setVisible(true);
		    	//area.setSize(200,30);
				//chatarea.add(area);
				chatarea.append("YOU:" +gtext +"\n");setVisible(true);
				chatbox.setText("");
				if(gtext.contains("Hi")||gtext.contains("hi")||gtext.contains("Hai")||gtext.contains("hai")||gtext.contains("hey")||gtext.contains("Hello")||gtext.contains("Hola")) {
					int r=(int)(Math.random()*3+1);
					if(r==1) {
						newchat("Hi");
					}
					else if(r==2){
						newchat("Hola");
					}
					else if(r==3) {
						newchat("Hello");
					}
				}
				else if(gtext.contains("How are you?")||gtext.contains("how are you?")||gtext.contains("How r u?")||gtext.contains("how r you?")){
					int r=(int)(Math.random()*3+1);
					if(r==1) {
						newchat("i'm fine and u?");
					}
					else if(r==2){
						newchat("Doing well and u?");
					}
					else if(r==3) {
						newchat("i'm great and u?");
					}
				}
				else if(gtext.contains("fine")||gtext.contains("doing well")||gtext.contains("great")) {
					newchat("Great to hear");
				}
				else if(gtext.contains("sad")||gtext.contains("not doing well")||gtext.contains("not feeling well")) {
					newchat("sorry to hear");
				}
				else if(gtext.contains("what is your occupation?")||gtext.contains("what are you doing?")||gtext.contains("em doing?")) {
					newchat("Chatting with u");
				}
				else if(gtext.contains("Are u free to chat?")||gtext.contains("can u chat with me?")||gtext.contains("want to chat with u")) {
					newchat("yes");
					newchat("Sure i'm always ready to accompany u");
				}
				else if(gtext.contains("Thank you")||gtext.contains("thank u")||gtext.contains("thank u so much")) {
					newchat("you are my friend");
				}
				else if(gtext.contains("Bye")||gtext.contains("bye bye")||gtext.contains("i'm going")) {
					newchat("Bye");
					newchat("Take Care");
				}
				else if(gtext.contains("Good Night")||gtext.contains("good night")||gtext.contains("going to sleep")) {
					newchat("Good Night");
					newchat("sleep tight");
				}
				else {
					int r=(int)(Math.random()*3+1);
					if(r==1) {
						newchat("I don't understand");
					}
					else if(r==2){
						newchat("please come again");
					}
					else if(r==3) {
						newchat("shut up");
					}
					
				}
				
			}
			
			private void newchat(String str) {
				area.setSize(200,30);setVisible(true);
				chatarea.add(area);
				frame.add(area);
				chatarea.append("BOT:" +str +"\n");
			}	
    	});
    }
	public static void main(String[] args) {
		new newchat();
	}

}
