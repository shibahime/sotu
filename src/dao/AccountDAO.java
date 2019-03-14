package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {

public Account findByLogin(Login login) {
	Connection conn=null;
	Account account=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/account?useSSL=false", "root", "root");

		String sql="SELECT ID,PASS,MAIL,NAME,AGE FROM user WHERE ID=?AND PASS=?";
						PreparedStatement pStmt=conn.prepareStatement(sql);
		                pStmt.setString(1, login.getId());
		                pStmt.setString(2, login.getPass());

		                ResultSet rs=pStmt.executeQuery();

		                if(rs.next()) {

		                	String id=rs.getString("ID");
		                	String pass=rs.getString("PASS");
		                	String mail=rs.getString("MAIL");
		                	String name=rs.getString("NAME");
		                	int age =rs.getInt("AGE");

		                	account=new Account(id,pass,mail,name,age);
		                }
	}catch (SQLException e) {
			e.printStackTrace();
	        return null;
	}catch(ClassNotFoundException e) {
		    e.printStackTrace();
		    return null;
	}finally{
		if(conn !=null) {
					try {
					conn.close();
					}catch(SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
		}
		return account;
}
}

