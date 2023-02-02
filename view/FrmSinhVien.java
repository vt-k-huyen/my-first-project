package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.SinhVienbean;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class FrmSinhVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	TextField txtdiachi = new TextField();
	TextField txthoten = new TextField();
	TextField txtmalop = new TextField();
	TextField txtns = new TextField();
	TextField txtgt = new TextField();
	TextField txtmasv = new TextField();
	ArrayList<SinhVienbean> dssv;
	SinhVienbo svbo = new SinhVienbo();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSinhVien frame = new FrmSinhVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void NapBang(ArrayList<SinhVienbean> dssv) {
		//b1: Tao ra mo hinh bang
		DefaultTableModel mh= new DefaultTableModel();
		//b2: Tao cot
		mh.addColumn("MaSV");mh.addColumn("HoTen");
		mh.addColumn("MaLop");mh.addColumn("NgaySinh");
		mh.addColumn("GioiTinh");mh.addColumn("DiaChi");
		//b3: Tao dong
		for(SinhVienbean sv: dssv) {
			Object[] t= new Object[6];
			t[0]=sv.getMasv();t[1]=sv.getHoten();
			t[2]=sv.getMalop();
			t[3]=sv.getNgaysinh().toString();
			String gtString = null;
			if(sv.getGioitinh()== true)
				gtString = "Nam";
			if(sv.getGioitinh()==false)
				gtString = "Nu";
			t[4]=gtString;
			//t[4]=sv.getGioitinh();
			t[5]=sv.getDiachi();
			mh.addRow(t);
		}
		//b4: Dua mo hinh vao bang
				table.setModel(mh);
	}
	/**
	 * Create the frame.
	 */
	public FrmSinhVien() {
		setBackground(Color.WHITE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					Connect cs= new Connect();
					cs.KetNoi();
					dssv = svbo.getsv();
					NapBang(dssv);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 886, 506);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("MaSV");
		label.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 12));
		label.setBackground(new Color(240, 255, 240));
		label.setForeground(new Color(25, 25, 112));
		label.setBounds(143, 38, 59, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("GioiTinh");
		label_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 12));
		label_1.setBackground(new Color(240, 255, 240));
		label_1.setForeground(new Color(25, 25, 112));
		label_1.setBounds(143, 79, 59, 21);
		contentPane.add(label_1);
		
		Label label_2 = new Label("NgaySinh");
		label_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 12));
		label_2.setBackground(new Color(240, 255, 240));
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setBounds(143, 118, 59, 21);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Ho va ten");
		label_3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 12));
		label_3.setBackground(new Color(240, 255, 240));
		label_3.setForeground(new Color(25, 25, 112));
		label_3.setBounds(428, 38, 59, 21);
		contentPane.add(label_3);
		
		Label label_4 = new Label("DiaChi");
		label_4.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 12));
		label_4.setBackground(new Color(240, 255, 240));
		label_4.setForeground(new Color(25, 25, 112));
		label_4.setBounds(428, 79, 59, 21);
		contentPane.add(label_4);
		
		txtmasv.setBounds(208, 38, 98, 21);
		contentPane.add(txtmasv);
		
		txtgt.setBounds(208, 79, 98, 21);
		contentPane.add(txtgt);
		
		txtns.setBounds(208, 118, 98, 21);
		contentPane.add(txtns);
		
		txthoten.setBounds(493, 38, 155, 21);
		contentPane.add(txthoten);
		
		
		txtdiachi.setBounds(493, 79, 155, 21);
		contentPane.add(txtdiachi);
		
		Button button = new Button("Them");
		button.setFont(new Font("Arial Black", Font.BOLD, 12));
		button.setForeground(new Color(240, 248, 255));
		button.setBackground(new Color(0, 0, 128));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String masv = txtmasv.getText();
					String hoten = txthoten.getText();
					String malop = txtmalop.getText();
					String gt = null;
					if (txtgt.getText().equalsIgnoreCase("Nam"))
						gt = "true";
					else 
						gt = "false";
					SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
					Date ngaysinh = dd.parse(txtns.getText());
					String diachi = txtdiachi.getText();
					
					int ktma = 0;
					for(SinhVienbean sv : dssv) {
						if(sv.getMasv().equals(txtmasv.getText())==true) {
							ktma = 1;
							break;
						}
					}
					if(ktma == 0) {
						svbo.Themsv(masv, hoten, malop,  Boolean.parseBoolean(gt), ngaysinh, diachi);
						NapBang(dssv);
					}
					else
						JOptionPane.showMessageDialog(null, "Ma sv nay da co");
					
//					svbo.Themsv(masv, hoten, malop, Boolean.parseBoolean(gt), ngaysinh, diachi);
//					NapBang(dssv);
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
			}
		});
		button.setBounds(120, 175, 66, 21);
		contentPane.add(button);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(60, 230, 756, 194);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("DANH SACH SINH VIEN", null, scrollPane, null);
		
		table = new JTable();
		table.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();
				
				String masv = table.getValueAt(d, 0).toString();
				txtmasv.setText(masv);
				
				String hoten = table.getValueAt(d, 1).toString();
				txthoten.setText(hoten);
				
				String malop = table.getValueAt(d, 2).toString();
				txtmalop.setText(malop);
				
				String gioitinh = table.getValueAt(d, 4).toString();
				txtgt.setText(gioitinh);
				
				String ngaysinh = table.getValueAt(d, 3).toString();
				txtns.setText(ngaysinh);
				
				String diachi = table.getValueAt(d, 5).toString();
				txtdiachi.setText(diachi);
			}
		});
		scrollPane.setViewportView(table);
		
		Button button_1 = new Button("Sua");
		button_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_1.setForeground(new Color(240, 248, 255));
		button_1.setBackground(new Color(0, 0, 128));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String masv = txtmasv.getText();
					String hoten = txthoten.getText();
					String malop = txtmalop.getText();
					String gt = null;
					if (txtgt.getText().equalsIgnoreCase("Nam"))
						gt = "true";
					else 
						gt = "false";
					SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
					Date ngaysinh = dd.parse(txtns.getText());
					
					String diachi = txtdiachi.getText();
					svbo.Sua(masv, hoten, malop, Boolean.parseBoolean(gt), ngaysinh, diachi);
//					NapBang(svbo.getsv());
					NapBang(dssv);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		button_1.setBounds(465, 175, 66, 21);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Xoa");
		button_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_2.setForeground(new Color(240, 248, 255));
		button_2.setBackground(new Color(0, 0, 128));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int t=JOptionPane.showConfirmDialog(null, "Xoa sinh vien?");
					String masv = txtmasv.getText();
					if(t==0) {
						svbo.Xoa(masv);
						NapBang(dssv);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(289, 175, 66, 21);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Tim kiem");
		button_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_3.setForeground(new Color(240, 248, 255));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=JOptionPane.showInputDialog("Nhap masv can tim:");
				ArrayList<SinhVienbean> tam = new ArrayList<SinhVienbean>();
				try {
					tam = svbo.Tim(key);
					NapBang(tam);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_3.setBackground(new Color(0, 0, 128));
		button_3.setBounds(646, 175, 66, 21);
		contentPane.add(button_3);
		
		Label label_5 = new Label("MaLop");
		label_5.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 12));
		label_5.setBackground(new Color(240, 255, 240));
		label_5.setForeground(new Color(25, 25, 112));
		label_5.setBounds(428, 118, 59, 21);
		contentPane.add(label_5);
		
		
		txtmalop.setBounds(493, 118, 155, 21);
		contentPane.add(txtmalop);
	}
}
