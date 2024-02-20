package view;

import java.awt.Button;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;

public class naptienDT extends JFrame {

	private JButton btndong;
	private JTextField JTsotien;

	public naptienDT() {
		getContentPane().setBackground(new Color(255, 255, 224));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nạp Tiền Điện Thoại");
		setSize(509, 340);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JTextField JTsotkc = new JTextField();

		JTsotkc.setFont(new Font("Tahoma", Font.PLAIN, 25));
		JTsotkc.setBounds(207, 46, 241, 39);

		getContentPane().add(JTsotkc);

		JLabel JLoaithanhtoan = new JLabel("Số Điện Thoại");
		JLoaithanhtoan.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		JLoaithanhtoan.setBounds(63, 53, 136, 28);
		getContentPane().add(JLoaithanhtoan);

		JLabel JLsotien = new JLabel("Số Tiền");
		JLsotien.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		JLsotien.setBounds(63, 186, 113, 28);
		getContentPane().add(JLsotien);

		JTsotien = new JTextField();
		JTsotien.setBounds(207, 175, 241, 39);
		getContentPane().add(JTsotien);
		JTsotien.setColumns(10);

		JButton btnpay = new JButton("PAY");
		btnpay.setBackground(new Color(255, 0, 0));
		btnpay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnpay.setBounds(273, 240, 174, 53);
		getContentPane().add(btnpay);

		JButton btnHome = new JButton("HOME");
		btnHome.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(chuyentien.class.getResource("home.png"))));
		btnpay.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(chuyentien.class.getResource("bill.png"))));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHome.setBackground(new Color(175, 238, 238));
		btnHome.setBounds(63, 240, 174, 53);
		getContentPane().add(btnHome);

		JLabel JLoaithe = new JLabel("Loại Thẻ");
		JLoaithe.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		JLoaithe.setBounds(63, 113, 120, 28);
		getContentPane().add(JLoaithe);

		String loai[] = { "Viettel", "Mobiphone", "Vinaphone", "Bông Lúa", "Vietnammobie", };
		JComboBox comboBox = new JComboBox(loai);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(207, 108, 241, 39);
		getContentPane().add(comboBox);

		JLabel Jlloaithe = new JLabel();
		Jlloaithe.setIcon(new ImageIcon("D:\\ANHlamjava\\l.jpg"));
		Jlloaithe.setBounds(-42, -24, 612, 339);
		getContentPane().add(Jlloaithe);

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
				try {
					// TODO Auto-generated method stub
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12");
					String sk = dangnhapCLIENT.taikhoan;
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT sotien FROM taikhoanclient WHERE taikhoan = '" + sk + "'");

					if (rs.next()) { // Move the cursor to the first row

						int JTsotienValue = Integer.parseInt(JTsotien.getText()); // Convert the JTextField value to int

						if (rs.getInt("sotien") > JTsotienValue) {
							stmt.executeUpdate("UPDATE taikhoanclient SET sotien = sotien - " + JTsotienValue
									+ " WHERE taikhoan = '" + sk + "'");

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