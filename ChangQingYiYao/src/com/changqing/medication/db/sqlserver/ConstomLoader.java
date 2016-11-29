package com.changqing.medication.db.sqlserver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.AsyncTaskLoader;

public class ConstomLoader extends AsyncTaskLoader<ResultSet>{

	private Bundle mBundle;
	private Connection mConnection;
	public ConstomLoader(Context context,Connection connection,Bundle bundle) {
		super(context);
		// TODO Auto-generated constructor stub
		mBundle = bundle;
		mConnection = connection;
	}
    
	@Override
	public ResultSet loadInBackground() {
		// TODO Auto-generated method stub
		//Connection connection = DatabaseManager.getConnection("", "", "");
		ResultSet resultSet = null;
		try {
			Statement stateMent = mConnection.createStatement();
			resultSet = stateMent.executeQuery(mBundle.getString("sql"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	
}
