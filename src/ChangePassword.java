import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword {

	private JFrame frame;

	Operator o = null;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_1;

        
	public ChangePassword(Operator _o) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(255, 255, 255));
        centerPanel.setPreferredSize(new Dimension(600, 800));
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(null);
        
        textField_2 = new JTextField();
        textField_2.setText("전화번호, 사용자 이름 및 이메일");
        textField_2.setPreferredSize(new Dimension(140, 30));
        textField_2.setForeground(Color.GRAY);
        textField_2.setBackground(new Color(245, 245, 245));
        textField_2.setBounds(460, 407, 341, 52);
        centerPanel.add(textField_2);
        
        textField = new JTextField();
        textField.setText("현재 비밀번호");
        textField.setPreferredSize(new Dimension(140, 30));
        textField.setForeground(Color.GRAY);
        textField.setBackground(new Color(245, 245, 245));
        textField.setBounds(460, 471, 341, 52);
        centerPanel.add(textField);
        
        textField_1 = new JTextField();
        textField_1.setText("새 비밀번호");
        textField_1.setPreferredSize(new Dimension(140, 30));
        textField_1.setForeground(Color.GRAY);
        textField_1.setBackground(new Color(245, 245, 245));
        textField_1.setBounds(460, 535, 341, 52);
        centerPanel.add(textField_1);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setIcon(new ImageIcon(ChangePassword.class.getResource("/image/forget_password.png")));
        btnNewButton.setBounds(517, 75, 217, 218);
        centerPanel.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("비밀번호를 변경하시겠어요?");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(500, 305, 256, 36);
        centerPanel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("아이디와 현재 비밀번호, 변경하고 싶은 비밀번호를 입력하시면 비밀번호가 변경됩니다.");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(460, 353, 341, 46);
        centerPanel.add(lblNewLabel_1);
        
        JButton btnNewButton_1 = new JButton("비밀번호 변경");
        btnNewButton_1.setBackground(SystemColor.controlHighlight);
        btnNewButton_1.setBounds(460, 599, 341, 36);
        btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid = textField_2.getText();
	            String upass = textField.getText();
	            String newpass = textField_1.getText();
				if(uid.equals("") || upass.equals("")) JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
            	else {
	            	if(_o.db.changepswd(uid, newpass, upass)) 
	            	{
	            		JOptionPane.showMessageDialog(null,"비밀번호가 변경되었습니다");
	            	}
	            	else {
	                    JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 일치하지 않습니다");
	            	}
            	}
			}
		});
        centerPanel.add(btnNewButton_1);   
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
	}
}