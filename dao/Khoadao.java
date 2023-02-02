package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Khoabean;

public class Khoadao {
	//Viet 1 ham doc file vao mang: ds
		public ArrayList<Khoabean> getkhoa() throws Exception{
			ArrayList<Khoabean> ds= new ArrayList<Khoabean>();
			//b1: tao cau lenh sql
			String sql="select * from KHOA";
			//b2: trao ra doi tuong prepareStatement
			PreparedStatement cmd= Connect.cn.prepareStatement(sql);
			//b3: thuc hien cau lenh
			ResultSet rs= cmd.executeQuery();
	while(rs.next()) {
				
				Khoabean dn= new Khoabean();
				dn.setMakhoa(rs.getString("makhoa"));
				dn.setTenkhoa(rs.getString("tenkhoa"));
				ds.add(dn);
			}
			rs.close();
			return ds;
		}
}
