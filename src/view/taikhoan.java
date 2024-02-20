package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oop.Khachhang;
import java.awt.Font;

public class taikhoan extends JFrame {

	public taikhoan() throws SQLException {

		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12");
		String sql = "SELECT * FROM taikhoanCLIENT WHERE taikhoan = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dangnhapCLIENT.taikhoan);

		ResultSet rs = pstmt.executeQuery();
		ArrayList<Khachhang> khachHangs = new ArrayList<>();
		while (rs.next()) {
			String hoten = rs.getString("hoten");
			String sotk = rs.getString("sotk");
			String taikhoan = rs.getString("taikhoan");
			String matkhau = rs.getString("matkhau");
			String quoctich = rs.getString("quoctich");
			String ngaysinh = rs.getString("ngaysinh");
			String CMND = rs.getString("CMND");
			String sotien = rs.getString("sotien");
			String quequan = rs.getString("quequan");
			String gioitinh = rs.getString("gioitinh");

			Khachhang khachhang = new Khachhang();
			khachhang.setHoten(hoten);
			khachhang.setSotk(sotk);
			khachhang.setTaikhoan(taikhoan);
			khachhang.setMatkhau(matkhau);
			khachhang.setQuoctich(quoctich);
			khachhang.setNgaysinh(ngaysinh);
			khachhang.setCMND(CMND);
			khachhang.setSotien(sotien);
			khachhang.setQuequan(quequan); 
			khachhang.setGioitinh(gioitinh);
			khachHangs.add(khachhang);
		}
		conn.close();
		

		JFrame frame = new JFrame("Thông tin CLIENT");

		frame.setSize(800, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTable table = new JTable();
		table.setBounds(10, 0, 776, 152);
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "Họ tên", "Số tài khoản",
				"Tài khoản", "Mật khẩu", "Quốc tịch", "Ngày sinh", "CMND", "Số tiền", "Quê Quán", "Giới tính" });
		table.setModel(model);

		for (Khachhang khachhang : khachHangs) {
			model.addRow(new Object[] { khachhang.getHoten(), khachhang.getSotk(), khachhang.getTaikhoan(),
					khachhang.getMatkhau(), khachhang.getQuoctich(), khachhang.getNgaysinh(), khachhang.getCMND(),
					khachhang.getSotien(), khachhang.getQuequan(), khachhang.getGioitinh() });
		}
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(table);

		JButton btnhome = new JButton("Home");
		btnhome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnhome.setIcon(new ImageIcon("C:\\Users\\nguye\\Downloads\\home.png"));
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				giaodienchucnangCLIENT sc = new giaodienchucnangCLIENT();
				sc.setVisible(true);
				dispose();
				frame.setVisible(false);
			}
		});
		btnhome.setBounds(328, 162, 122, 41);
		frame.getContentPane().add(btnhome);
		frame.setVisible(true);
		
	}
}
