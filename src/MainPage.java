import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class MainPage {

	public static JFrame frame;
	Operator o;
	ResultSet rs = null;
	String newid = null;
	String usid;

	public MainPage(Operator _o, String uid) {
		o = _o;
		initialize(uid);
	}
	public MainPage(Operator _o, String uid, String _newid) {
		o = _o;
		usid = uid;
		newid = _newid;
		initialize(newid);
	}

	private void initialize(String uid) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton logo = new JButton("");
		logo.setIcon(new ImageIcon(MainPage.class.getResource("../image/main_logo.png")));
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
				String input = JOptionPane.showInputDialog(null, "search user", "search", JOptionPane.PLAIN_MESSAGE);
				//입력받은 id넣어서 팔로우 아티클 실행하도록
				new MainPage(o, uid, input);
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
				if(newid==null) new articlepage(o, uid);
				else new articlepage(o, usid, newid);
			}
		});
		frame.getContentPane().add(newPost);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainPage.class.getResource("../image/menu.png")));
		lblNewLabel.setBounds(21, 123, 128, 483);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel timeline = new JPanel();
		timeline.setBounds(205, 113, 558, 653);
		frame.getContentPane().add(timeline);
		timeline.setLayout(null);
		
		JTextArea time = new JTextArea();
		time.setBounds(0, 0, 558, 643);
		timeline.add(time);
		
		JButton following = new JButton("following");
		following.setBounds(814, 123, 113, 41);
		following.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = o.db.printfollowing(uid);
				try
				{
					while(rs.next())
					{
			    		String contents = rs.getString(1);
			    		JOptionPane.showMessageDialog(null, contents, "following", JOptionPane.PLAIN_MESSAGE);
					}
				}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(null, "follow others", "following", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(following);
		
		JButton follower = new JButton("follower");
		follower.setBounds(814, 190, 113, 41);
		follower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = o.db.printfollower(uid);
				try
				{
					while(rs.next())
					{
			    		String contents = rs.getString(1);
			    		JOptionPane.showMessageDialog(null, contents, "follower", JOptionPane.PLAIN_MESSAGE);
					}
				}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(null, "Gather your followers", "following", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(follower);
		
		if(newid != null)
		{
			JButton follow = new JButton("follow");
			follow.setBounds(814, 34, 113, 41);
			follow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(o.db.follow(usid, uid))
					{
	            		JOptionPane.showMessageDialog(null,"팔로우 완료");
	            	}
	            	else 
	            	{
	                    JOptionPane.showMessageDialog(null, "팔로우 실패");
	            	}
				}
			});
			frame.getContentPane().add(follow);
		}
		
		rs = o.db.printarticle(uid);
		try
		{
			while(rs.next())
			{
	    		String contents = rs.getString(1);
	    		String locations = rs.getString(2);
	    		String writer_id = rs.getString(3);
	    		if(!uid.equals(writer_id)) 
	    		{
	    			time.append(contents + " #" );
		    		time.append(locations);
	    			time.append("@" + writer_id + "\n");
	    		}
	    		else
	    		{
	    			time.append(contents + " #" );
		    		time.append(locations+"\n");
	    		}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		frame.setVisible(true);
	}
}