package bo;

import java.util.ArrayList;

import bean.Lopbean;
import dao.Lopdao;

public class Lopbo {
	Lopdao lopdao= new Lopdao();
	ArrayList<Lopbean> dsl = new ArrayList<Lopbean>();
	public ArrayList<Lopbean> getlop() throws Exception{
		dsl = lopdao.getlop();
		return dsl;
	}
}
