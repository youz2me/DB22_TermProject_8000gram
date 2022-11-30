import java.sql.*;

public class Database {
    Connection con = null;
    Statement stmt = null;
    String url = "jdbc:mysql://localhost/dbteam";
    String username = "root";
    String password = "68103jin";

    Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("MySQL 서버 연동 성공");
        } catch(Exception e) {
            System.out.println("MySQL 서버 연동 실패 > " + e.toString());
        }
    }

    boolean logincheck(String _i, String _p) {
        boolean flag = false;

        String id = _i;
        String pw = _p;

        try {
            String checkingStr = "SELECT password FROM member WHERE id='" + id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);

            while(result.next()) {
                if(pw.equals(result.getString("password"))) {
                    flag = true;
                    System.out.println("로그인 성공");
                }

                else {
                    flag = false;
                    System.out.println("로그인 실패");
                }
            }
        } catch(Exception e) {
            flag = false;
            System.out.println("로그인 실패 > " + e.toString());
        }

        return flag;
    }
}
