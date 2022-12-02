import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
	
    Login(Operator _o){

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(255, 255, 255));
        centerPanel.setPreferredSize(new Dimension(1200, 800));
        centerPanel.setLayout(null);
        getContentPane().add(centerPanel);
        setTitle("instagram");
        
        JLabel pwL = new JLabel("비밀번호");
        pwL.setBackground(new Color(128, 128, 128));
        pwL.setForeground(new Color(128, 128, 128));
        pwL.setBounds(626, 326, 326, 30);
        pwL.setPreferredSize(new Dimension(50, 30));
        centerPanel.add(pwL);
        
        JTextField id = new JTextField();
        id.setForeground(new Color(128, 128, 128));
        id.setText("전화번호, 사용자 이름 및 이메일");
        id.setBackground(new Color(245, 245, 245));
        id.setBounds(621, 260, 341, 52);
        id.setPreferredSize(new Dimension(140, 30));
        centerPanel.add(id);
        
        JPasswordField pw = new JPasswordField();
        pw.setBackground(new Color(245, 245, 245));
        pw.setBounds(620, 315, 341, 52);
        pw.setPreferredSize(new Dimension(140, 30));
        centerPanel.add(pw);

        JButton loginBtn = new JButton("");
        loginBtn.setIcon(new ImageIcon(Login.class.getResource("/image/login.png")));
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
        loginBtn.setBounds(623, 369, 334, 40);
        loginBtn.setPreferredSize(new Dimension(75, 63));
        centerPanel.add(loginBtn);
        
        loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            String uid = id.getText();
	            String upass = "";
	            for(int i=0; i<pw.getPassword().length; i++) {
	                upass = upass + pw.getPassword()[i];
	            }
	         
	                if(uid.equals("") || upass.equals("")) {
	                    JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
	                    System.out.println("로그인 실패 > 로그인 정보 미입력");
	                }

	                else if(uid != null && upass != null) {
	                    if(_o.db.logincheck(uid, upass)) {	
	                        System.out.println("로그인 성공");
	                        JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
	                        new MainPage();
	        				setVisible(false);
	                    } else {
	                        System.out.println("로그인 실패 > 로그인 정보 불일치");
	                        JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
	                    }
	                }
	            }
			}
		);
        
        JButton joinBtn = new JButton("계정이 없으신가요? 가입하기");
        joinBtn.setBounds(626, 581, 332, 81);
        joinBtn.setPreferredSize(new Dimension(135, 25));
        centerPanel.add(joinBtn);
        
        joinBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        
        JButton exitBtn = new JButton("프로그램 종료");
        exitBtn.setBounds(621, 674, 341, 25);
        exitBtn.setPreferredSize(new Dimension(135, 25));
        centerPanel.add(exitBtn);
        
        exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("프로그램 종료");
                System.exit(0);
			}
		});
        
        JButton instaImage = new JButton("");
        instaImage.setIcon(new ImageIcon(Login.class.getResource("/image/1.png")));
        instaImage.setBackground(new Color(100, 149, 237));
        instaImage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        instaImage.setSelectedIcon(null);
        instaImage.setBounds(215, 129, 393, 586);
        centerPanel.add(instaImage);
        
        JButton logo = new JButton("");
        logo.setIcon(new ImageIcon(Login.class.getResource("/image/2.png")));
        logo.setBounds(626, 129, 335, 81);
        logo.setBorderPainted(false);
		logo.setContentAreaFilled(false);
		logo.setFocusPainted(false);
		centerPanel.add(logo); 
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/image/or.png")));
		lblNewLabel.setBounds(623, 446, 326, 25);
		centerPanel.add(lblNewLabel);
		
		JButton changePassword = new JButton("비밀번호를 잊으셨나요?");
		changePassword.setPreferredSize(new Dimension(75, 63));
		changePassword.setForeground(UIManager.getColor("List.selectionBackground"));
		changePassword.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		changePassword.setBounds(618, 471, 334, 40);
		changePassword.setBorderPainted(false);
		changePassword.setContentAreaFilled(false);
		changePassword.setFocusPainted(false);
		centerPanel.add(changePassword);
		
		changePassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ChangePassword(_o);
				setVisible(false);
			}
		});

        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
    }
}