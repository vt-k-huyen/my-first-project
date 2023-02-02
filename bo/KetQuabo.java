package bo;

import java.util.ArrayList;

import bean.KetQuabean;
import bean.MonHocbean;
import bean.SinhVienbean;
import dao.KetQuadao;
import dao.MonHocdao;
import dao.SinhViendao;

public class KetQuabo {
	KetQuadao kqdao = new KetQuadao();
	ArrayList<KetQuabean> dskq;
	SinhViendao svdao = new SinhViendao();
	ArrayList<SinhVienbean> dssv;
	MonHocdao mhdao = new MonHocdao();
	ArrayList<MonHocbean> dsmh;
	public ArrayList<KetQuabean> getkq() throws Exception{
		dskq = kqdao.getkq();
		return dskq;
	}

	public int Nhapkq(String masv, String hoten, String mamh, Float dcc, Float kt1, Float kt2, Float qtht, Float thi,
			Float heso, String hechu, String xeploai) throws Exception{

		kqdao.Nhapkq(masv, hoten, mamh, dcc, kt1, kt2, qtht, thi, heso, hechu, xeploai);
		KetQuabean kq1 = new KetQuabean(masv, hoten, mamh, dcc, kt1, kt2, qtht, thi, heso, hechu, xeploai);
		dskq.add(kq1);
		return 1;
	}
	public int Xoa(String masv, String mamh) throws Exception {
		for(KetQuabean kq:dskq) {
			if(kq.getMasv().equals(masv)== true && kq.getMamh().equals(mamh)==true) {
				dskq.remove(kq);
				kqdao.Xoa(masv, mamh);
				return 1;
			}
		}
		return 0;
	}

	public int Sua(String masv, String hoten, String mamh, Float dcc, Float kt1, Float kt2, 
			Float qtht, Float thi,Float heso, String hechu, String xeploai) throws Exception {
		for(KetQuabean kq:dskq) {
			if(kq.getMasv().equals(masv)==true && kq.getMamh().equals(mamh)==true) {
				kq.setHoten(hoten);
				kq.setDcc(dcc);
				kq.setKt1(kt1);
				kq.setKt2(kt2);
				kq.setQtht(qtht);
				kq.setThi(thi);
				kq.setHeso(heso);
				kq.setHechu(hechu);
				kq.setXeploai(xeploai);
				kqdao.Sua(masv, hoten, mamh, dcc, kt1, kt2, qtht, thi, heso, hechu, xeploai);
				return 1;
			}			
		}	
		return 0;
	}
	public ArrayList<KetQuabean> Tim(String ma) throws Exception {
		ArrayList<KetQuabean> tam = new ArrayList<KetQuabean>();
		for(KetQuabean kq:dskq) {
			if(ma.toLowerCase().equals(kq.getMasv().toLowerCase())) {
				tam.add(kq);
			}
		}
		for(KetQuabean kq:dskq) {
			if(ma.toLowerCase().equals(kq.getMamh().toLowerCase())) {
				tam.add(kq);
			}
		}
		return tam;
	}
}
