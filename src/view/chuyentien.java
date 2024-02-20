package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.ImageIcon;

public class chuyentien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField JTsotaikhoan;
	private JLabel JLnganhang;
	private JLabel JLsotien;
	private JTextField JTsotien;
	private JButton btnpay;
	private JLabel lblNewLabel;

	public chuyentien() {
		setTitle("Chuyển Tiền");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel JLsotaikhaon = new JLabel("Số tài Khoản");
		JLsotaikhaon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLsotaikhaon.setBounds(47, 96, 144, 30);
		contentPane.add(JLsotaikhaon);

		JTsotaikhoan = new JTextField();
		JTsotaikhoan.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JTsotaikhoan.setBounds(202, 94, 224, 30);
		contentPane.add(JTsotaikhoan);
		JTsotaikhoan.setColumns(10);

		JLnganhang = new JLabel("Ngân Hàng");
		JLnganhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLnganhang.setBounds(47, 29, 144, 30);
		contentPane.add(JLnganhang);

		String nganhang[] = { "Shinbank", "VietcomBank", "BIDV", "VBSP", "Vietinbank", "VN-AGribank", "MHB", "VDB",
				"Nam A Bank", "Sacombank", "VP Bank" };
		JComboBox CBnganhang = new JComboBox(nganhang);
		CBnganhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		CBnganhang.setBounds(202, 29, 224, 30);
		contentPane.add(CBnganhang);

		JLsotien = new JLabel("Số Tiền");
		JLsotien.setBackground(new Color(0, 0, 255));
		JLsotien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLsotien.setBounds(47, 159, 144, 30);
		contentPane.add(JLsotien);

		JTsotien = new JTextField();
		JTsotien.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JTsotien.setColumns(10);
		JTsotien.setBounds(202, 159, 224, 30);
		contentPane.add(JTsotien);

		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon("C:\\Users\\nguye\\Downloads\\home.png"));
		btnHome.setBackground(new Color(0, 255, 255));
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHome.setBounds(90, 211, 125, 42);
		contentPane.add(btnHome);

		btnpay = new JButton("Pay");
		btnpay.setIcon(new ImageIcon("C:\\Users\\nguye\\Downloads\\bill.png"));
		btnpay.setBackground(new Color(255, 0, 0));
		btnpay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnpay.setBounds(243, 211, 125, 42);
		contentPane.add(btnpay);

		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("D:\\ANHlamjava\\cxx.jpg"));
		lblNewLabel.setBounds(-43, -20, 541, 315);
		contentPane.add(lblNewLabel);
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				giaodienchucnangCLIENT sc = new giaodienchucnangCLIENT();
				sc.setVisible(true);
				setVisible(false);
			}
		});

		btnpay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12");
					String sk = dangnhapCLIENT.taikhoan;
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT sotien FROM taikhoanclient WHERE taikhoan = '" + sk + "'");

					if (rs.next()) { // Move the cursor to the first row

						int JTsotienValue = Integer.parseInt(JTsotien.getText()); // Convert the JTextField value to int

						if (rs.getInt("sotien") > JTsotienValue) {
							stmt.executeUpdate("UPDATE taikhoanclient SET sotien = sotien - " + JTsotien.getText()
									+ " WHERE taikhoan = '" + sk + "'");
							stmt.executeUpdate("UPDATE taikhoanclient SET sotien = sotien +" + JTsotien.getText()
									+ "  WHERE sotk = '" + JTsotaikhoan.getText() + "'");
							JOptionPane.showConfirmDialog(null, "thanh cong ");
						} else {
							JOptionPane.showConfirmDialog(null, "hettien");
						}
					} else {
						JOptionPane.showConfirmDialog(null, "khong ton tai tai khoan ");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

	}
}
