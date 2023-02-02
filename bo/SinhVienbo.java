package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.SinhVienbean;
import dao.SinhViendao;

public class SinhVienbo {
	SinhViendao svdao = new SinhViendao();
	ArrayList<SinhVienbean> dssv;
	public ArrayList<SinhVienbean> getsv() throws Exception{
		dssv= svdao.getsv();
		return dssv;
	}
	public int Themsv(String masv, String hoten, String malop,Boolean gioitinh, Date ngaysinh, String diachi) throws Exception{
		for(SinhVienbean sv: dssv) {
			if(sv.getMasv().equals(masv)) 
				return 0;
		}
	//	SinhVienbean sv = new SinhVienbean(masv, hoten, malop, gioitinh, ngaysinh, diachi); 
		svdao.Themsv(masv, hoten, malop, gioitinh, ngaysinh, diachi);
		dssv.add(new SinhVienbean(masv, hoten, malop, gioitinh, new java.sql.Date(ngaysinh.getTime()), diachi));
		return 1;
	}
	public int Xoa(String masv) throws Exception {
		for(SinhVienbean sv : dssv) {
			if(sv.getMasv().equals(masv)) {
				//Xoa trong bo nho
				dssv.remove(sv);
				//Xoa trong csdl
				svdao.Xoa(masv);
				return 1;
			}	
		}
		return 0;
	}
	public ArrayList<SinhVienbean> Tim(String key) throws Exception {
		ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
		for(SinhVienbean sv : dssv) {
			 if(key.toLowerCase().equals(sv.getMasv().toLowerCase())) {
				 tam.add(sv);
			 }
			 if(key.toLowerCase().equals(sv.getHoten().toLowerCase())) {
				 tam.add(sv);
			 }
//			
//				 if(key.toLowerCase().equals(h.getMasv().toLowerCase())) {
//					 tam.add(h);
//				 }
//				 if(key.toLowerCase().equals(h.getMakhoa().toLowerCase())) {
//					 tam.add(h);
//				 }
//			 }
			
		}
		 return tam;
	}
	public int Sua(String masv, String hoten,String malop,Boolean gioitinh, Date ngaysinh, String diachi) throws Exception {
		for(SinhVienbean sv: dssv)
			if(sv.getMasv().equals(masv)) {
				//Sua trong bo nho
				sv.setMasv(masv);
				sv.setHoten(hoten);
				sv.setMalop(malop);
				sv.setGioitinh(gioitinh);
				sv.setNgaysinh(new java.sql.Date(ngaysinh.getTime()));
			//	sv.setNgaysinh(ngaysinh);
				sv.setDiachi(diachi);
				//Sua trong csdl
				svdao.Sua(masv, hoten, malop, gioitinh,  new java.sql.Date(ngaysinh.getTime()), diachi);
				return 1;
			}
		return 0;
	}
}
