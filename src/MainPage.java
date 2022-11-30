import javax.swing.JFrame;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;

public class MainPage {

	private JFrame frame;
	
	class Component extends JFrame {
		void makeResult(JPanel jpanel, int rank) {
			JPanel panel_1 = new JPanel();
		    jpanel.add(panel_1);
		    panel_1.setLayout(null);
		    
		    JButton btnNewButton_1 = new JButton("");
		    btnNewButton_1.setBounds(0, 6, 75, 60);
		    //btnNewButton_1.setIcon(new ImageIcon(Start.class.getResource("/data/result_egg.png")));
		    panel_1.add(btnNewButton_1);
		   
		    String name;
		    String description;
		    String link;
		    //String name = Main.rest[rank].getName();
		   // String description = Main.rest[rank]
		    //String link = Main.rest[rank]
		    
		    JLabel content = new JLabel("\"<html>\" + name + \"<br>@\" + description + \"<br>@\" + link + \"<html>\"");
		    content.setBounds(75, 65, 500, -60);
		    panel_1.add(content);
		}
	}

	public MainPage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("이미지 버튼");
		btnNewButton.setBounds(780, 46, 113, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("이름 버튼");
		btnNewButton_1.setBounds(899, 46, 89, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton logo = new JButton("");
		logo.setIcon(new ImageIcon(MainPage.class.getResource("/image/main_logo.png")));
		logo.setBounds(21, 34, 128, 50);
		logo.setBorderPainted(false);
		logo.setContentAreaFilled(false);
		logo.setFocusPainted(false);
		
		logo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(logo);
		
		JButton home = new JButton("");
		home.setBounds(21, 94, 128, 75);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.setFocusPainted(false);
		
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(home);
		
		JButton search = new JButton("");
		search.setBounds(21, 181, 128, 75);
		search.setBorderPainted(false);
		search.setContentAreaFilled(false);
		search.setFocusPainted(false);
		
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(search);
		
		JButton retrieval = new JButton("");
		retrieval.setBounds(21, 256, 128, 68);
		retrieval.setBorderPainted(false);
		retrieval.setContentAreaFilled(false);
		retrieval.setFocusPainted(false);
		
		retrieval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(retrieval);
		
		JButton message = new JButton("");
		message.setBounds(21, 392, 128, 79);
		message.setBorderPainted(false);
		message.setContentAreaFilled(false);
		message.setFocusPainted(false);
	
		message.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(message);
		
		JButton alarm = new JButton("");
		alarm.setBounds(21, 469, 128, 72);
		alarm.setBorderPainted(false);
		alarm.setContentAreaFilled(false);
		alarm.setFocusPainted(false);
		
		alarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(alarm);
		
		JButton newPost = new JButton("");
		newPost.setBounds(21, 538, 128, 79);
		newPost.setBorderPainted(false);
		newPost.setContentAreaFilled(false);
		newPost.setFocusPainted(false);
		
		newPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(newPost);
		
		JButton profile = new JButton("");
		profile.setBounds(10, 664, 128, 29);
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(profile);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainPage.class.getResource("/image/menu.png")));
		lblNewLabel.setBounds(21, 123, 128, 483);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel timeline = new JPanel();
		timeline.setBounds(205, 113, 558, 653);
		frame.getContentPane().add(timeline);
		timeline.setLayout(new BorderLayout(2, 0));
		
		JScrollBar scrollBar = new JScrollBar();
		timeline.add(scrollBar);
	}
}