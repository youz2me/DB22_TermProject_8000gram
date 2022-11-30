import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    /* Panel */
    JPanel basePanel = new JPanel(new BorderLayout());
    JPanel centerPanel = new JPanel();
    JLabel pwL = new JLabel("비밀번호");

    /* TextField */
    JTextField id = new JTextField();
    JPasswordField pw = new JPasswordField();

    /* Button */
    JButton loginBtn = new JButton("");
    JButton joinBtn = new JButton("계정이 없으신가요? 가입하기");
    JButton exitBtn = new JButton("프로그램 종료");

    Operator o = null;
    Login(Operator _o){
    	o = _o;

        setTitle("instagram");

        centerPanel.setBackground(new Color(255, 255, 255));
        centerPanel.setPreferredSize(new Dimension(600, 800));
        
        basePanel.setBackground(new Color(255, 255, 255));
        setContentPane(basePanel);	//panel을 기본 컨테이너로 설정

        basePanel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(null);
        pwL.setBackground(new Color(128, 128, 128));
        pwL.setForeground(new Color(128, 128, 128));
        pwL.setBounds(626, 326, 326, 30);
        centerPanel.add(pwL);
        pwL.setPreferredSize(new Dimension(50, 30));
        pw.setBackground(new Color(245, 245, 245));
        pw.setBounds(620, 315, 341, 52);
        centerPanel.add(pw);
        pw.setPreferredSize(new Dimension(140, 30));
        loginBtn.setIcon(new ImageIcon(Login.class.getResource("/image/login.png")));
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setBackground(UIManager.getColor("PopupMenu.selectionBackground"));
        loginBtn.setBounds(623, 369, 334, 40);
        centerPanel.add(loginBtn);
        loginBtn.setPreferredSize(new Dimension(75, 63));
        id.setForeground(new Color(128, 128, 128));
        id.setText("전화번호, 사용자 이름 및 이메일");
        id.setBackground(new Color(245, 245, 245));
        id.setBounds(621, 260, 341, 52);
        centerPanel.add(id);
        id.setPreferredSize(new Dimension(140, 30));
        joinBtn.setBounds(626, 473, 332, 58);
        centerPanel.add(joinBtn);
        joinBtn.setPreferredSize(new Dimension(135, 25));
        exitBtn.setBounds(620, 690, 341, 25);
        centerPanel.add(exitBtn);
        exitBtn.setPreferredSize(new Dimension(135, 25));
        
        /* Button 이벤트 리스너 추가 */
        ButtonListener bl = new ButtonListener();
        
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
        centerPanel.add(logo);
        logo.setBorderPainted(false);
		logo.setContentAreaFilled(false);
		logo.setFocusPainted(false);
		
		JButton changePassword = new JButton("비밀번호 변경");
		changePassword.setPreferredSize(new Dimension(75, 63));
		changePassword.setForeground(UIManager.getColor("PopupMenu.foreground"));
		changePassword.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		changePassword.setBounds(626, 421, 334, 40);
		centerPanel.add(changePassword);
		
		changePassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ChangePassword(_o);
				setVisible(false);
			}
		});
        
        exitBtn.addActionListener(bl);
        joinBtn.addActionListener(bl);
        loginBtn.addActionListener(bl);

        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /* Button 이벤트 리스너 */
    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();

            /* TextField에 입력된 아이디와 비밀번호를 변수에 초기화 */
            String uid = id.getText();
            String upass = "";
            for(int i=0; i<pw.getPassword().length; i++) {
                upass = upass + pw.getPassword()[i];
            }

            /* 종료 버튼 */
            if(b.getText().equals("프로그램 종료")) {
                System.out.println("프로그램 종료");
                System.exit(0);
            }

            /* 회원가입 버튼 이벤트 */
            else if(b.getText().equals("회원가입")) {

            }

            /* 로그인 버튼 이벤트 */
            else if(b.getText().equals("로그인")) {
                if(uid.equals("") || upass.equals("")) {
                    JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
                    System.out.println("로그인 실패 > 로그인 정보 미입력");
                }

                else if(uid != null && upass != null) {
                    if(o.db.logincheck(uid, upass)) {	//데이터베이스에 접속해 로그인 정보를 확인하는 부분
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
    }
}