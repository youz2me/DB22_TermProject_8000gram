import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;

public class articlepage {
	Operator o;
	private JFrame frame;
	private JTextField contenttext;
	private JTextField locationtext;
	String id;
	public articlepage(Operator _o, String uid) {
		o = _o;
		id = uid;
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel content = new JLabel("content");
		content.setBounds(25, 33, 68, 33);
		frame.getContentPane().add(content);
		
		contenttext = new JTextField();
		contenttext.setBounds(125, 33, 262, 33);
		frame.getContentPane().add(contenttext);
		contenttext.setColumns(10);
		
		JLabel location = new JLabel("location");
		location.setBounds(25, 94, 68, 33);
		frame.getContentPane().add(location);
		
		locationtext = new JTextField();
		locationtext.setColumns(10);
		locationtext.setBounds(125, 94, 262, 33);
		frame.getContentPane().add(locationtext);
		
		JButton complete = new JButton("complete");
		complete.setBounds(158, 210, 95, 23);
		frame.getContentPane().add(complete);
		complete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				o.db.article(id, contenttext.getText(), locationtext.getText());
			}
		});
		frame.setVisible(true);
	}
		
}
