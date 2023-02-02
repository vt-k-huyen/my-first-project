package bean;

import java.util.Date;

public class SinhVienbean {
	private String masv;
	private String hoten;
	private String malop;
	private Boolean gioitinh;
	private Date ngaysinh;
	private String diachi;
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public Boolean getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	public SinhVienbean(String masv, String hoten, String malop, Boolean gioitinh, Date ngaysinh, String diachi) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.malop = malop;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
	}
	
	public SinhVienbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void hienthi() {
		System.out.println("SV: " + masv + "  " + hoten + "  " + malop + "  " + ngaysinh + "  " + gioitinh + "  " + diachi);
	}
}
