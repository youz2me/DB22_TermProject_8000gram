import java.sql.*;
public class Database {
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    String url = "jdbc:mysql://localhost/dbteam";
    String username = "root";
    String password = "12345";
    int post_id;

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
            String checkingStr = "SELECT password FROM account WHERE id='" + id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);

            int count = 0;
            while(result.next()) {
                if(pw.equals(result.getString("password"))) {
                    flag = true;
                    System.out.println("로그인 성공");
                }

                else {
                    flag = false;
                    System.out.println("로그인 실패");
                }
                count++;
            }
        } catch(Exception e) {
            flag = false;
            System.out.println("로그인 실패 > " + e.toString());
        }

        return flag;
    }
    
    boolean create(String id, String pswd)
    {
    	boolean flag = false;
    	try//계정생성
		{
			String sql= "insert into account value (?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pswd);
			pstmt.executeUpdate();
			flag = true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			flag = false;
		}
    	return flag;
    }
    
    boolean changepswd(String id, String newpswd, String pswd)
    {
    	boolean flag = false;
    	try//비번변경
		{
			String sql= "update account set password = ? where ID = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newpswd);
			pstmt.setString(2, id);
			pstmt.setString(3, pswd);
			pstmt.executeUpdate();
			flag = true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			flag = false;
		}
    	return flag;
    }
    
    boolean follow(String following_id, String follower_id)
    {
    	boolean flag = false;
    	try//팔로우
		{
			String sql = "insert into following value (?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, following_id);
			pstmt.setString(2, follower_id);
			pstmt.executeUpdate();
			flag = true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
    	return flag;
    }
    
    boolean article(String id, String content, String location)
    {
    	boolean flag = false;
    	ResultSet rs;
    	try//게시글작성
		{
    		String sql = "select max(post_id) from article";
    		pstmt = con.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		rs.next();
    		if(rs.getString(1) == null)
    		{
    			post_id = 1;
    			sql = "insert into article value (?, ?, ?, ?, ?)";
    			pstmt = con.prepareStatement(sql);
    			pstmt.setString(1, id);
    			pstmt.setString(2, id);
    			pstmt.setString(3, content);
    			pstmt.setString(4, location);
    			pstmt.setInt(5, post_id);
    			pstmt.executeUpdate();
    			flag = true;
    		}
    		else
    		{
    			post_id =  Integer.parseInt(rs.getString(1));
    			post_id++;
    			sql = "insert into article value (?, ?, ?, ?, ?)";
    			pstmt = con.prepareStatement(sql);
    			pstmt.setString(1, id);
    			pstmt.setString(2, id);
    			pstmt.setString(3, content);
    			pstmt.setString(4, location);
    			pstmt.setInt(5, post_id);
    			pstmt.executeUpdate();
    			flag = true;
    		}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
    	return flag;
    }
    
    boolean follwoing_article(String id, String newid, String content, String location)
    {
    	boolean flag = false;
    	ResultSet rs;
    	try//팔로워에게 게시글작성
    	{
    		String sql = "select max(post_id) from article";
    		pstmt = con.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		rs.next();
    		if(rs.getString(1) == null)
    		{
    			post_id = 1;
    			sql = "insert into article value (?, ?, ?, ?, ?)";
    			pstmt = con.prepareStatement(sql);
    			pstmt.setString(1, newid);
    			pstmt.setString(2, id);
    			pstmt.setString(3, content);
    			pstmt.setString(4, location);
    			pstmt.setInt(5, post_id);
    			pstmt.executeUpdate();
    			flag = true;
    		}
    		else
    		{
    			post_id =  Integer.parseInt(rs.getString(1));
    			post_id++;
    			sql = "insert into article value (?, ?, ?, ?, ?)";
    			pstmt = con.prepareStatement(sql);
    			pstmt.setString(1, newid);
    			pstmt.setString(2, id);
    			pstmt.setString(3, content);
    			pstmt.setString(4, location);
    			pstmt.setInt(5, post_id);
    			pstmt.executeUpdate();
    			flag = true;
    		}
    	}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
    	return flag;
    }
    
    ResultSet printarticle(String id)
    {
    	ResultSet rs = null;
    	try//게시글보여주기
		{
			String sql = "select content, location, writer_id from article where ID = ? order by post_id desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
    	return rs;
    }
    
    ResultSet printfollowing(String id)
    {
    	ResultSet rs = null;
    	try//내가 팔로우한사람 보여주기
    	{
    		String sql = "select follower_id from following  where following_id = ?";
    		pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, id);
    		rs = pstmt.executeQuery();
    	}
    	catch (SQLException e)
		{
			e.printStackTrace();
		}
    	return rs;
    }
    
    ResultSet printfollower(String id)
    {
    	ResultSet rs = null;
    	try//나를팔로우한사람 보여주기
    	{
    		String sql = "select following_id from following  where follower_id = ?";
    		pstmt = con.prepareStatement(sql);
    		pstmt.setString(1, id);
    		rs = pstmt.executeQuery();
    	}
    	catch (SQLException e)
		{
			e.printStackTrace();
		}
    	return rs;
    }
     
}