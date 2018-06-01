package com.bru.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.bru.model.LoginBean;
import com.bru.util.ConnectDB;

@Repository
public class LoginDao {

	public LoginBean login(String email, String password) {
		LoginBean bean = new LoginBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement pre = null;
		StringBuilder sql = new StringBuilder();
		
		try {
			sql.append(" SELECT * FROM test2 WHERE email = ? AND password = ? ");
			pre = con.openConnect().prepareStatement(sql.toString());
			pre.setString(1, email);
			pre.setString(2, password);
			
			ResultSet rs = pre.executeQuery();
			
			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bean;
	}
}
