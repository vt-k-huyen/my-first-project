package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.KetQuabean;
import bean.MonHocbean;
import bo.MonHocbo;
import dao.Connect;

import java.awt.Label;
import java.awt.TextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class FrmMonHoc extends JFrame {

	private JPanel contentPane;
	private JTable table;
	TextField txtsotc = new TextField();
	TextField txttenmh = new TextField();
	TextField txtmamh = new TextField();
	ArrayList<MonHocbean> dsmh;
	MonHocbo mhbo=new MonHocbo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMonHoc frame = new FrmMonHoc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	void NapBang(ArrayList<MonHocbean> dsmh) {
		DefaultTableModel mh= new DefaultTableModel();
		mh.addColumn("MaMH");
		mh.addColumn("TenMH");
		mh.addColumn("SoTC");
		for(MonHocbean mon:dsmh) {
			Object[] t= new Object[3];
			t[0] = mon.getMamh();
			t[1] = mon.getTenmh();
			t[2] = mon.getSotc();
			mh.addRow(t);
		}
			table.setModel(mh);
	}
	public FrmMonHoc() {
		setBackground(new Color(255, 255, 255));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {	
				try {
					Connect cs= new Connect();
					cs.KetNoi();
					dsmh = mhbo.getmh();
					NapBang(dsmh);
				} catch (Exception e1) {		
					e1.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 698, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("MaMH");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		label.setBounds(24, 41, 59, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("TenMH");
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		label_1.setBounds(24, 106, 59, 21);
		contentPane.add(label_1);
		
		Label label_2 = new Label("SoTC");
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		label_2.setBounds(24, 169, 59, 21);
		contentPane.add(label_2);
		txtmamh.setForeground(new Color(0, 0, 139));
		txtmamh.setBackground(new Color(255, 250, 250));
		
		txtmamh.setBounds(89, 41, 80, 21);
		contentPane.add(txtmamh);
				txttenmh.setForeground(new Color(0, 0, 139));
				txttenmh.setBackground(new Color(255, 250, 250));
				txttenmh.setBounds(89, 106, 111, 21);
		contentPane.add(txttenmh);
		txtsotc.setForeground(new Color(0, 0, 139));
		txtsotc.setBackground(new Color(255, 250, 250));
		
		
		txtsotc.setBounds(89, 169, 41, 21);
		contentPane.add(txtsotc);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(246, 53, 410, 210);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("MON HOC", null, scrollPane, null);
		
		table = new JTable();
		table.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		table.setBackground(new Color(248, 248, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();
				
				String mamh = table.getValueAt(d, 0).toString();
				txtmamh.setText(mamh);
				
				String tenmh = table.getValueAt(d, 1).toString();
				txttenmh.setText(tenmh);
				
				String sotc = table.getValueAt(d, 2).toString();
				txtsotc.setText(sotc);
				
			}
		});
		scrollPane.setViewportView(table);
		
		Button button = new Button("Them");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 0, 102));
		button.setFont(new Font("Arial Black", Font.BOLD, 12));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mamh= txtmamh.getText();
				String tenmh= txttenmh.getText();
				int sotc = Integer.parseInt(txtsotc.getText());
				
				try {
					int kt=0;
					for(MonHocbean mh:dsmh) {
						if(mh.getMamh().equals(txtmamh.getText())) {
							kt=1;
							break;
						}
					}
					if(kt==0) {
						mhbo.ThemMH(mamh, tenmh, sotc);
						NapBang(dsmh);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(24, 239, 66, 21);
		contentPane.add(button);
		
		Button button_1 = new Button("Sua");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(0, 0, 102));
		button_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mamhString = txtmamh.getText();
				String tenString = txttenmh.getText();
				int sotc = Integer.parseInt(txtsotc.getText());
				try {
					mhbo.Sua(mamhString, tenString, sotc);
					NapBang(dsmh);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(139, 239, 66, 21);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Xoa");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(0, 0, 102));
		button_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t=JOptionPane.showConfirmDialog(null, "Xoa mon hoc?");
				String mamh = txtmamh.getText();
				try {
					if(t==0) {
						mhbo.Xoa(mamh);
						NapBang(dsmh);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(24, 287, 66, 21);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Tim Kiem");
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(0, 0, 102));
		button_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String key=JOptionPane.showInputDialog("Nhap ma mon hoc hoac ten mon hoc:");
				ArrayList<MonHocbean> tam= new ArrayList<MonHocbean>();
				try {
					tam = mhbo.Tim(key);
					NapBang(tam);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(139, 287, 66, 21);
		contentPane.add(button_3);
	}
}
