package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.KetQuabean;


public class KetQuadao {
	ArrayList<KetQuabean> dskq = new ArrayList<KetQuabean>();
	public ArrayList<KetQuabean> getkq() throws Exception{
		//b1: tao cau lenh sql
		String sql="select * from KETQUA";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		//b3: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			KetQuabean kq = new KetQuabean();
			kq.setMasv(rs.getString("MaSV"));
			kq.setHoten(rs.getString("HoTen"));
			kq.setMamh(rs.getString("MaMH"));
			kq.setDcc(rs.getFloat("DiemCC"));
			kq.setKt1(rs.getFloat("DiemKT1"));
			kq.setKt2(rs.getFloat("DiemKT2"));
			kq.setQtht(rs.getFloat("QTHT"));
			kq.setThi(rs.getFloat("DiemThi"));
			kq.setHeso(rs.getFloat("HeSo"));
			kq.setHechu(rs.getString("HeChu"));
			kq.setXeploai(rs.getString("XepLoai"));
			dskq.add(kq);
		}
		rs.close();
		return dskq;
	}
	public int Nhapkq(String masv, String hoten, String mamh, Float dcc, Float kt1, Float kt2, Float qtht,
			Float thi,Float heso, String hechu, String xeploai) throws Exception{
		String sql = "insert into KETQUA(MaSV,HoTen,MaMH,DiemCC,DiemKT1,DiemKT2,QTHT,DiemThi,HeSo,HeChu,XepLoai) values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		cmd.setString(1,masv);
		cmd.setString(2,hoten);
		cmd.setString(3,mamh);
		cmd.setFloat(4,dcc);
		cmd.setFloat(5,kt1);
		cmd.setFloat(6,kt2);
		cmd.setFloat(7,qtht);
		cmd.setFloat(8,thi);
		cmd.setFloat(9,heso);
		cmd.setString(10,hechu);
		cmd.setString(11,xeploai);
		return cmd.executeUpdate();
	}
	public int Xoa(String masv, String mamh) throws Exception {
		//b1: Tao cau lenh sql
				String sql="delete from KETQUA where MaSV=? and MaMH=?";
				//b2: trao ra doi tuong prepareStatement
				PreparedStatement cmd= Connect.cn.prepareStatement(sql);
				cmd.setString(1, masv);
				cmd.setString(2, mamh);
				//b3: thuc hien cau lenh
				return cmd.executeUpdate();
	}
	public int Sua(String masv, String hoten, String mamh, Float dcc, Float kt1, Float kt2,
			Float qtht, Float thi,Float heso, String hechu, String xeploai) throws Exception {
		String sql="update KETQUA set HoTen=?,DiemCC=?, DiemKT1=?, DiemKT2=?, QTHT=?, DiemThi=?, HeSo=?, HeChu=?, XepLoai=? where MaSV=? and MaMH=?";
		//b2: trao ra doi tuong prepareStatement
		PreparedStatement cmd= Connect.cn.prepareStatement(sql);
		cmd.setString(1, hoten);
		cmd.setFloat(2, dcc);
		cmd.setFloat(3, kt1);
		cmd.setFloat(4, kt2);
		cmd.setFloat(5, qtht);
		cmd.setFloat(6, thi);
		cmd.setFloat(7, heso);
		cmd.setString(8, hechu);
		cmd.setString(9, xeploai);
		cmd.setString(10, masv);
		cmd.setString(11, mamh);
		return cmd.executeUpdate();
	}
}
