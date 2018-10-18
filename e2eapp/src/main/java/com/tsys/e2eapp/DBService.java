package com.tsys.e2eapp;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBService {
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(method=RequestMethod.GET, path="db")
	public String dbTest() {
		String dbType="No DB";
		try {
			dbType = dataSource.getConnection().getMetaData().getDatabaseProductName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dbType;
	}
	
}
