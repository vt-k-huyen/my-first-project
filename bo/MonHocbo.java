package bo;

import java.util.ArrayList;

import bean.MonHocbean;
import dao.MonHocdao;

public class MonHocbo {
	MonHocdao mhdao = new MonHocdao();
	ArrayList<MonHocbean> dsmh;
	public ArrayList<MonHocbean> getmh() throws Exception{
		dsmh = mhdao.getmh();
		return dsmh;
	}
	public int ThemMH(String mamh, String tenmh, int sotc) throws Exception {
		mhdao.ThemMH(mamh, tenmh, sotc);
		MonHocbean mh = new MonHocbean(mamh, tenmh, sotc);
		dsmh.add(mh);
		return 1;
	}
	public int Sua(String mamh, String tenmh, int sotc) throws Exception {
		for(MonHocbean mh:dsmh) {
			if(mh.getMamh().equals(mamh)) {
				mh.setTenmh(tenmh);
				mh.setSotc(sotc);
				mhdao.Sua(mamh, tenmh, sotc);
				return 1;
			}
		}
		return 0;
	}
	public int Xoa(String mamh) throws Exception {
		for(MonHocbean mh:dsmh) {
			if(mh.getMamh().equals(mamh)) {
				dsmh.remove(mh);
				mhdao.Xoa(mamh);
				return 1;
			}
		}
		return 0;
	}
	public ArrayList<MonHocbean> Tim(String key) throws Exception{
		ArrayList<MonHocbean> tam = new ArrayList<MonHocbean>();
		for(MonHocbean mh:dsmh) {
			if(key.toLowerCase().equals(mh.getMamh().toLowerCase())) {
				tam.add(mh);
			}
		}
		for(MonHocbean mh:dsmh) {
			if(key.toLowerCase().equals(mh.getTenmh().toLowerCase())) {
				tam.add(mh);
			}
		}
		return tam;
	}
}
