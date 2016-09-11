package cn.bd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url="jdbc:sqlserver://localhost:1433;DatabaseName=BookManage";
	
	private Connection conn=null;
	public Connection getConnection(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"sa","123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeAll(Connection conn,PreparedStatement pstm,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(pstm!=null){
			try {
				pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public int executeUpdate(String sql,Object...parm){
		int result=0;
		PreparedStatement pstm=null;
		try {
			conn=this.getConnection();
			pstm=conn.prepareStatement(sql);
			if(parm!=null){
				for(int i=0;i<parm.length;i++){
					pstm.setObject(i+1, parm[i]);
				}
			}
			result=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet executeQuery(String sql,Object...parm){
		ResultSet rs=null;
		PreparedStatement pstm=null;
		try {
			conn=this.getConnection();
			pstm=conn.prepareStatement(sql);
			if(parm!=null){
				for(int i=0;i<parm.length;i++){
					pstm.setObject(i+1, parm[i]);
				}
			}
			rs=pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
