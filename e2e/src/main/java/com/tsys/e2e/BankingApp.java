package com.tsys.e2e;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankingApp {
	
	@Autowired
	private DataSource dataSource;

	
	@RequestMapping(path="data", method=RequestMethod.GET)
	public String getMessage() {
		Connection con = null;
		String result =null;
		try {
			con = dataSource.getConnection();
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select * from customers");
			if (rs.next()) {
				result= "data found";
			} else {
				result= "No data found";
			}
		} catch (SQLException e) {
			if (con !=null) {
				try {
					con.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
			}
			
			e.printStackTrace();
		}
		return result;
		
	}
	
}
