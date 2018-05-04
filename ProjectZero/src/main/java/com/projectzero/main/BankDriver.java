package com.projectzero.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.projectzero.util.ConnectionUtil;

public class BankDriver {
	public static void main(String[] args) {

		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
