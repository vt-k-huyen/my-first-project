package bo;

import java.util.ArrayList;

import bean.Khoabean;
import dao.Khoadao;

public class Khoabo {
	Khoadao kdao=new Khoadao();
	ArrayList<Khoabean> dsk=new ArrayList<Khoabean>();
	public ArrayList<Khoabean> getkhoa() throws Exception{
		dsk=kdao.getkhoa();
		return dsk;
	}
}
