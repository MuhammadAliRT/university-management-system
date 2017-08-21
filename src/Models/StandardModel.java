package Models;

import java.util.*;
import java.lang.reflect.Method;
import java.sql.*;
import Models.*;

public abstract class StandardModel {
	public boolean connected;
	public Connection conn;
	public Statement stmt;

	public StandardModel() {
		connected = false;
		conn = null;
		stmt = null;
	}

	public abstract int checkIfExists(Object n);

	public Connection connect() {
		try {
			Class.forName(DbVariables.getReg());
			conn = DriverManager.getConnection(DbVariables.getUrl(), DbVariables.getUser(), DbVariables.getPassword());
			connected = true;
			System.out.println("Connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ResultSet select(String tableName) {
		connect();
		if (connected) {
			try {
				stmt = conn.createStatement();
				String sql = "SELECT * FROM " + tableName + ";";
				ResultSet result = stmt.executeQuery(sql);
				return result;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close();
		}
		return null;
	}

	public void insertRecord(ArrayList columnData, String tableName) {
		connect();
		if (connected) {
			try {
				System.out.println("Check 1");

				stmt = conn.createStatement();
				String sql = "INSERT INTO " + tableName + " VALUES(";
				for (Object a : columnData) {
					if (a instanceof String) {
						sql = sql.concat(" '" + a + "' ");
					} else {
						sql = sql.concat(" " + a + " ");
					}
					if (columnData.indexOf(a) != columnData.size() - 1)
						sql = sql.concat(",");
				}

				sql = sql.concat(");");
				System.out.println(sql);
				stmt.executeUpdate(sql);
				System.out.println("Record Added");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close();
		}
	}

	public void update(String tableName, ArrayList columnData, ArrayList attrName, ArrayList compareField,
			ArrayList key) {

		connect();
		if (connected) {
			try {
				stmt = conn.createStatement();
				String sql = "UPDATE " + tableName + " SET ";
				for (Object attr : attrName) {
					Object cData = columnData.get(attrName.indexOf(attr));

					if (cData instanceof String) {
						sql = sql.concat("" + attr + "= '" + cData + "' ");
					} else {
						sql = sql.concat("" + attr + "= " + cData + " ");
					}
					if (attrName.indexOf(attr) != attrName.size() - 1)
						sql = sql.concat(",");
					else {
						sql = sql.concat(" WHERE ");
					}
				}

				for (Object cField : compareField) {
					Object k = key.get(compareField.indexOf(cField));
					
					if ((compareField.size() > 1) && (compareField.indexOf(cField) > 0)) {
						sql = sql.concat(" AND ");
					}
					if (k instanceof String) {

						sql = sql.concat("" + cField + "='" + k + "'");
					} else {
						sql = sql.concat("" + cField + "=" + k + "");
					}
				}

				stmt.executeUpdate(sql);
				System.out.println("Record Updated");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close();
		}
	}

	public ResultSet findRecord(ArrayList key, ArrayList columnNames, String tableName) {
		connect();
		if (connected) {
			try {

				stmt = conn.createStatement();

				String sql = "SELECT * FROM " + tableName + " WHERE ";
				for (Object cName : columnNames) 
				{
					Object k = key.get(columnNames.indexOf(cName));

					if ((columnNames.size() > 1) && (columnNames.indexOf(cName) > 0)) {
						sql = sql.concat(" AND ");
					}
					if (k instanceof String) {
						sql = sql.concat("" + cName + "='" + k + "'");
					} else {
						sql = sql.concat("" + cName + "=" + k + "");
					}
				}
				ResultSet result = stmt.executeQuery(sql);
				return result;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close();
		}
		return null;
	}
	
	public int Delete(ArrayList key, ArrayList compareFields, String tableName)
	{
		connect();
		if(connected)
		{
			try 
			{
				stmt = conn.createStatement();
				String sql = "DELETE FROM "+tableName+" WHERE";
				
				for(Object cField : compareFields)
				{
					Object k = key.get(compareFields.indexOf(cField));
					if((compareFields.size()>1)&&(compareFields.indexOf(cField)>0))
					{
						sql = sql.concat(" AND ");
					}
					if(k instanceof String)
					{
						sql = sql.concat(" "+cField+"='"+k+"'");
					}
					else
					{
						sql = sql.concat(" "+cField+"="+k+" ");
					}
				}
				int i =stmt.executeUpdate(sql);
				if(i>0)
				{
					return 1;
				}
				else
				{
					return 0;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			close();
		}
		return 0;
	}

}
