package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Lopbean;

public class Lopdao {
	ArrayList<Lopbean> dsl = new ArrayList<Lopbean>();
	public ArrayList<Lopbean> getlop() throws Exception{
		String sql="select * from LOP";
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			Lopbean lh=new Lopbean();
			lh.setMalop(rs.getString("MaLop"));
			lh.setMalop(rs.getString("TenLop"));
			dsl.add(lh);
		}
		rs.close();
		return dsl;
	}
}
