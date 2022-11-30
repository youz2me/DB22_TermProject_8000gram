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

public class MainPage {

	private JFrame frame;
	private JTextField textField;


	public MainPage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JTextArea textArea_8 = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea_8, 72, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea_8, 582, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(textArea_8);
		
		JButton btnNewButton = new JButton("이미지 버튼");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 780, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea_8, -37, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -107, SpringLayout.EAST, frame.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("이름 버튼");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -12, SpringLayout.EAST, frame.getContentPane());
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("로고 버튼");
		springLayout.putConstraint(SpringLayout.WEST, textArea_8, 48, SpringLayout.EAST, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("홈");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 111, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -36, SpringLayout.NORTH, btnNewButton_3);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 0, SpringLayout.WEST, btnNewButton_2);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("검색");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_4, 38, SpringLayout.SOUTH, btnNewButton_3);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_4, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("탐색탭");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_5, 35, SpringLayout.SOUTH, btnNewButton_4);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_5, 0, SpringLayout.WEST, btnNewButton_2);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("메시지");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_6, 38, SpringLayout.SOUTH, btnNewButton_5);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_6, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("알림");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_7, 42, SpringLayout.SOUTH, btnNewButton_6);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_7, 0, SpringLayout.WEST, btnNewButton_2);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("만들기");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_8, 37, SpringLayout.SOUTH, btnNewButton_7);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_8, 0, SpringLayout.WEST, btnNewButton_2);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("프로필");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_9, 50, SpringLayout.SOUTH, btnNewButton_8);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_9, 0, SpringLayout.WEST, btnNewButton_2);
		frame.getContentPane().add(btnNewButton_9);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, -47, SpringLayout.NORTH, textArea_8);
		springLayout.putConstraint(SpringLayout.WEST, textField, 48, SpringLayout.EAST, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -18, SpringLayout.NORTH, textArea_8);
		springLayout.putConstraint(SpringLayout.EAST, textField, 519, SpringLayout.EAST, btnNewButton_2);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}