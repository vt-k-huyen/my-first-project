package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.SinhVienbean;

public class SinhViendao {
	//Viet 1 ham doc file vao mang: ds
	ArrayList<SinhVienbean> dssv = new ArrayList<SinhVienbean>();
	public ArrayList<SinhVienbean> getsv() throws Exception{
		//ArrayList<SinhVienbean> dssv = new ArrayList<SinhVienbean>();
		//b1: tao cau lenh sql
		String sql="select * from SINHVIEN";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			SinhVienbean sv = new SinhVienbean();			
			sv.setMasv(rs.getString("MaSV"));
			sv.setHoten(rs.getString("HoTen"));
			sv.setMalop(rs.getString("MaLop"));
			sv.setGioitinh(rs.getBoolean("GioiTinh"));
			sv.setNgaysinh(rs.getDate("NgaySinh"));
			sv.setDiachi(rs.getString("DiaChi"));
			dssv.add(sv);
		}
		rs.close();
		return dssv;
	}
	public int Themsv(String masv, String hoten, String malop,Boolean gioitinh, Date ngaysinh, String diachi) throws Exception{
				String sql = "insert into SINHVIEN(MaSV,HoTen,MaLop,NgaySinh, GioiTinh,DiaChi) values(?,?,?,?,?,?)";
		//b2: trao ra doi tuong prepareStatement
				PreparedStatement cmd= Connect.cn.prepareStatement(sql);
				cmd.setString(1,masv);
				cmd.setString(2,hoten);
				cmd.setString(3,malop);
				//Doi ngay Util sang ngay sql
				cmd.setDate(4,new java.sql.Date(ngaysinh.getTime()));
				cmd.setBoolean(5, gioitinh);
				cmd.setNString(6, diachi);
				return cmd.executeUpdate();
	}
	public int Xoa(String masv) throws Exception {
		//b1: Tao cau lenh sql
		String sql="delete from SINHVIEN where MaSV=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		cmd.setString(1, masv);
		//b3: thuc hien cau lenh
		return cmd.executeUpdate();
	}
	public int Sua(String masv, String hoten,String malop,Boolean gioitinh, Date ngaysinh, String diachi) throws Exception {
		//b1: Tao cau lenh sql
		String sql="update SINHVIEN set HoTen = ? ,MaLop=?, NgaySinh=?, GioiTinh=?, DiaChi=? where MaSV = ?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		cmd.setString(6,masv);
		cmd.setString(1,hoten);
		cmd.setString(2, malop);
		cmd.setBoolean(4, gioitinh);
		cmd.setDate(3,new java.sql.Date(ngaysinh.getTime()));
		cmd.setString(5, diachi);
		//b3: thuc hien cau lenh
		return cmd.executeUpdate();
	}
}
