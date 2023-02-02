package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public static Connection cn;
    public void KetNoi() {
   	 try {
   		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   	//	 System.out.println("Da xac dinh HQTCSDL");
   		 String st="jdbc:sqlserver://DESKTOP-EOUJRL3\\SQLEXPRESS:1433; "+" databaseName=QuanLyDiemSinhVien; user=sa; password=123";
   			    		 cn=DriverManager.getConnection(st);
   			    //		 System.out.println("Da ket noi");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		Connect cs= new Connect();
		cs.KetNoi();
	}

}
