package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.KetQuabean;
import bean.MonHocbean;
import bean.SinhVienbean;
import bo.KetQuabo;
import bo.MonHocbo;
import bo.SinhVienbo;
import dao.Connect;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class FrmKetQua extends JFrame {

	private JPanel contentPane;
	private JTable table;
	TextField txtxeploai = new TextField();
	TextField txthechu = new TextField();
	TextField txtheso = new TextField();
	TextField txtthi = new TextField();
	TextField txtqtht = new TextField();
	TextField txtkt2 = new TextField();
	TextField txtkt1 = new TextField();
	TextField txtcc = new TextField();
	TextField txtmamh = new TextField();
	TextField txthoten = new TextField();
	TextField txtmasv = new TextField();
	ArrayList<SinhVienbean> dssv;
	SinhVienbo svbo = new SinhVienbo();
	ArrayList<MonHocbean> dsmh;
	MonHocbo mhbo = new MonHocbo();
	ArrayList<KetQuabean> dskq;
	KetQuabo kqbo = new KetQuabo();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKetQua frame = new FrmKetQua();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	
	void NapBang(ArrayList<KetQuabean> dskq) {
		//b1: Tao ra mo hinh bang
		DefaultTableModel mh= new DefaultTableModel();
		//b2: Tao cot
		mh.addColumn("MaSV");mh.addColumn("HoTen");
		mh.addColumn("MaMH");mh.addColumn("DiemCC");
		mh.addColumn("KT1");mh.addColumn("KT2");
		mh.addColumn("QTHT");mh.addColumn("DiemThi");
		mh.addColumn("DTB");mh.addColumn("HeChu");
		mh.addColumn("XepLoai");
		//b3: Tao dong
		for(KetQuabean kq : dskq) {
			Object[] t= new Object[11];
			t[0] = kq.getMasv();t[1] = kq.getHoten();
			t[2] = kq.getMamh();t[3] = kq.getDcc();
			t[4] = kq.getKt1();t[5] = kq.getKt2();
			t[6] = kq.getQtht();t[7] = kq.getThi();
			t[8] = kq.getHeso();t[9] = kq.getHechu();
			t[10] = kq.getXeploai();
			mh.addRow(t);
		}
		//b4: Dua mo hinh vao bang
		table.setModel(mh);
	}
	/**
	 * Create the frame.
	 */
	public FrmKetQua() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					Connect cs= new Connect();
					cs.KetNoi();
					dskq = kqbo.getkq();
					
					NapBang(dskq);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 859, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("MaSV");
		label.setFont(new Font("Arial Black", Font.BOLD, 12));
		label.setForeground(new Color(0, 0, 128));
		label.setBounds(39, 61, 59, 21);
		contentPane.add(label);
		
		Label label_2 = new Label("Ho va ten");
		label_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setBounds(39, 109, 59, 21);
		contentPane.add(label_2);
		
		Label label_3 = new Label("MaMH");
		label_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_3.setForeground(new Color(0, 0, 128));
		label_3.setBounds(39, 161, 59, 21);
		contentPane.add(label_3);
		txtmasv.setFont(new Font("Arial", Font.PLAIN, 12));
		txtmasv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if(e.getKeyCode() == 10) {
						String ma = txtmasv.getText();
						for(SinhVienbean sv : svbo.getsv()) {
							if(ma.equals(sv.getMasv())) {
								txthoten.setText(sv.getHoten());
							}
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	
		txtmasv.setBounds(122, 61, 86, 21);
		contentPane.add(txtmasv);
		txthoten.setFont(new Font("Arial", Font.PLAIN, 12));
		
		txthoten.setBounds(122, 109, 171, 21);
		contentPane.add(txthoten);
		txtmamh.setFont(new Font("Arial", Font.PLAIN, 12));
		
		txtmamh.setBounds(122, 161, 86, 21);
		contentPane.add(txtmamh);
		
		Label label_1 = new Label("Diem CC");
		label_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setBounds(369, 61, 59, 21);
		contentPane.add(label_1);
		
		Label label_4 = new Label("Diem KT1");
		label_4.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_4.setForeground(new Color(0, 0, 128));
		label_4.setBounds(369, 109, 59, 21);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Diem KT2");
		label_5.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_5.setForeground(new Color(0, 0, 128));
		label_5.setBounds(369, 161, 59, 21);
		contentPane.add(label_5);
		
		txtcc.setBounds(447, 61, 59, 21);
		contentPane.add(txtcc);
		
		txtkt1.setBounds(447, 109, 59, 21);
		contentPane.add(txtkt1);
		
		txtkt2.setBounds(447, 161, 59, 21);
		contentPane.add(txtkt2);
		
		Label label_6 = new Label("QTHT");
		label_6.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_6.setForeground(new Color(0, 0, 128));
		label_6.setBounds(549, 84, 59, 21);
		contentPane.add(label_6);
		
		Label label_7 = new Label("Diem thi");
		label_7.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_7.setForeground(new Color(0, 0, 128));
		label_7.setBounds(549, 141, 59, 21);
		contentPane.add(label_7);
		
		txtqtht.setBounds(640, 84, 66, 21);
		contentPane.add(txtqtht);
	
		txtthi.setBounds(640, 141, 66, 21);
		contentPane.add(txtthi);
		
		Label label_8 = new Label("He so");
		label_8.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_8.setForeground(new Color(0, 0, 128));
		label_8.setBounds(49, 219, 59, 21);
		contentPane.add(label_8);
		txtheso.setFont(new Font("Arial", Font.PLAIN, 12));
		
		txtheso.setBounds(122, 219, 59, 21);
		contentPane.add(txtheso);
		
		Label label_9 = new Label("He chu");
		label_9.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_9.setForeground(new Color(0, 0, 128));
		label_9.setBounds(278, 219, 59, 21);
		contentPane.add(label_9);
		
		txthechu.setBounds(343, 219, 85, 21);
		contentPane.add(txthechu);
		
		Label label_10 = new Label("Xep loai");
		label_10.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_10.setForeground(new Color(0, 0, 128));
		label_10.setBounds(507, 219, 59, 21);
		contentPane.add(label_10);
		
		
		txtxeploai.setBounds(585, 219, 93, 21);
		contentPane.add(txtxeploai);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(39, 307, 745, 185);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("KET QUA", null, scrollPane, null);
		
		table = new JTable();
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		table.setBackground(new Color(240, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();
				
				String masv = table.getValueAt(d, 0).toString();
				txtmasv.setText(masv);
				
				String hoten = table.getValueAt(d, 1).toString();
				txthoten.setText(hoten);
				
				String mamh = table.getValueAt(d, 2).toString();
				txtmamh.setText(mamh);
				
				String dcc = table.getValueAt(d, 3).toString();
				txtcc.setText(dcc);
				
				String kt1 = table.getValueAt(d, 4).toString();
				txtkt1.setText(kt1);
				
				String kt2 = table.getValueAt(d, 5).toString();
				txtkt2.setText(kt2);
				
				String qtht = table.getValueAt(d, 6).toString();
				txtqtht.setText(qtht);
				
				String thi = table.getValueAt(d, 7).toString();
				txtthi.setText(thi);
				
				String heso = table.getValueAt(d, 8).toString();
				txtheso.setText(heso);
			
				String hechu = table.getValueAt(d, 9).toString();
				txthechu.setText(hechu);
				
				String xeploai = table.getValueAt(d, 10).toString();
				txtxeploai.setText(xeploai);
			}
		});
		scrollPane.setViewportView(table);
		
		Button button = new Button("Nhap");
		button.setFont(new Font("Arial Black", Font.BOLD, 12));
		button.setForeground(new Color(240, 255, 240));
		button.setBackground(new Color(0, 0, 139));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String masv = txtmasv.getText();
				String hoten = txthoten.getText();
				String mamh = txtmamh.getText();
				String dcc =txtcc.getText();
				String kt1 = txtkt1.getText();
				String kt2 = txtkt2.getText();
				String qtht = txtqtht.getText();
				String thi = txtthi.getText();
				String heso = txtheso.getText();
				String hechu = txthechu.getText();
				String xeploai = txtxeploai.getText();
				
				
					int ktsv = 1;
					for(SinhVienbean sv:svbo.getsv()) {
						if(sv.getMasv().equals(txtmasv.getText())==true) {
							ktsv = 0;
							break;
						}
					}
					int ktmh = 1;
					for(MonHocbean mh:mhbo.getmh()) {
						if(mh.getMamh().equals(txtmamh.getText())==true) {
							ktmh = 0;
							break;
						}
					}
					if(ktsv == 0 && ktmh == 0) {
						kqbo.Nhapkq(masv, hoten, mamh, Float.parseFloat(dcc), Float.parseFloat(kt1),  Float.parseFloat(kt2),
								 Float.parseFloat(qtht),  Float.parseFloat(thi),  Float.parseFloat(heso), hechu, xeploai);
						NapBang(dskq);
					}
					else {
						JOptionPane.showMessageDialog(null, "Loi");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(81, 265, 66, 21);
		contentPane.add(button);
		
		Button button_1 = new Button("Xoa");
		button_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_1.setForeground(new Color(240, 255, 240));
		button_1.setBackground(new Color(0, 0, 139));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int t=JOptionPane.showConfirmDialog(null, "Xoa ket qua?");
					String masv = txtmasv.getText();
					String mamh = txtmamh.getText();
					if(t==0) {
						kqbo.Xoa(masv, mamh);
						NapBang(dskq);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			private void Xoa(String masv, String mamh) {
				// TODO Auto-generated method stub
				
			}
		});
		button_1.setBounds(260, 265, 66, 21);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Sua");
		button_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_2.setForeground(new Color(240, 255, 240));
		button_2.setBackground(new Color(0, 0, 139));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String masv = txtmasv.getText();
				String hoten = txthoten.getText();
				String mamh = txtmamh.getText();
				String dcc =txtcc.getText();
				String kt1 = txtkt1.getText();
				String kt2 = txtkt2.getText();
				String qtht = txtqtht.getText();
				String thi = txtthi.getText();
				String heso = txtheso.getText();
				String hechu = txthechu.getText();
				String xeploai = txtxeploai.getText();
				
				try {
					kqbo.Sua(masv, hoten, mamh, Float.parseFloat(dcc), Float.parseFloat(kt1),  Float.parseFloat(kt2),
									 Float.parseFloat(qtht),  Float.parseFloat(thi),  Float.parseFloat(heso), hechu, xeploai);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				NapBang(dskq);
			}
		});
		button_2.setBounds(446, 265, 66, 21);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Tim kiem");
		button_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_3.setForeground(new Color(240, 255, 240));
		button_3.setBackground(new Color(0, 0, 139));
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String key=JOptionPane.showInputDialog("Nhap masv hoac ma mon hoc can tim:");
				ArrayList<KetQuabean> tam = new ArrayList<KetQuabean>();
				try {
					tam = kqbo.Tim(key);
					NapBang(tam);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(656, 265, 66, 21);
		contentPane.add(button_3);
		
		Button button_4 = new Button("Tinh");
		button_4.setForeground(new Color(240, 248, 255));
		button_4.setBackground(new Color(25, 25, 112));
		button_4.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Float dcc = Float.parseFloat(txtcc.getText());
				Float kt1 = Float.parseFloat(txtkt1.getText());
				Float kt2 = Float.parseFloat(txtkt2.getText());
				Float qtht = (float) ((dcc + (kt1*1.5) + (kt2*1.5))/4) ;
				txtqtht.setText(qtht.toString());
				
				Float thi = Float.parseFloat(txtthi.getText());
				Float dtb = (float) (((qtht*4) + (thi*6))/10);
				txtheso.setText(dtb.toString());
				
				if(dtb<=10 && dtb >=8.5) {
					txthechu.setText("A");
					txtxeploai.setText("Gioi");
				}
				if(dtb<=8.4 && dtb >=7) {
					txthechu.setText("B");
					txtxeploai.setText("Kha");
				}
				if(dtb<=6.9 && dtb >=5.5) {
					txthechu.setText("C");
					txtxeploai.setText("Trung binh");
				}
				if(dtb<=5.4 && dtb >=4) {
					txthechu.setText("D");
				    txtxeploai.setText("Trung binh yeu");
				}
				if(dtb<4) {
					txthechu.setText("F");
					txtxeploai.setText("Kem");
				}
			}
		});
		button_4.setBounds(585, 34, 66, 21);
		contentPane.add(button_4);
	}
}
