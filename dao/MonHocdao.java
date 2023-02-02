package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.MonHocbean;

public class MonHocdao {
	ArrayList<MonHocbean> dsmh = new ArrayList<MonHocbean>();
	public ArrayList<MonHocbean> getmh() throws Exception{
		String sql="select * from MONHOC";
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			MonHocbean mh = new MonHocbean();
			mh.setMamh(rs.getString("MaMH"));
			mh.setTenmh(rs.getString("TenMH"));
			mh.setSotc(rs.getInt("SoTC"));
			dsmh.add(mh);
		}
		rs.close();
		return dsmh;
	}
	public int ThemMH(String mamh, String tenmh, int sotc) throws Exception {
		String sql = "insert into MONHOC(MaMH,TenMH,SoTC) values (?,?,?)";
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		cmd.setString(1,mamh);
		cmd.setString(2,tenmh);
		cmd.setInt(3, sotc);
		return cmd.executeUpdate();	
	}
	public int Sua(String mamh, String tenmh, int sotc) throws Exception {
		String sql="update MONHOC set TenMH=?,SoTC=? where MaMH=?";
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		cmd.setString(1, tenmh);
		cmd.setInt(2, sotc);
		cmd.setString(3, mamh);
		return cmd.executeUpdate();	
	}
	public int Xoa(String mamh) throws Exception {
		String sql="delete from MONHOC where MaMH=? ";
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		cmd.setString(1, mamh);
		return cmd.executeUpdate();
	}
}
