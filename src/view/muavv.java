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

public class muavv extends JFrame {

	private JButton btndong;
	private JTextField textField;

	public muavv() {
		getContentPane().setBackground(new Color(255, 255, 224));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Đặt Chỗ");
		setSize(509, 340);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		String loai[] = { "Vé Tàu", "Vé TAXI", "Vé Máy Bay", "Đặt Phòng" };
		JComboBox loaidat = new JComboBox(loai);
		loaidat.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		loaidat.setBounds(207, 46, 241, 39);

		getContentPane().add(loaidat);

		JLabel JLoaithanhtoan = new JLabel("Loại Đặt");
		JLoaithanhtoan.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		JLoaithanhtoan.setBounds(57, 53, 134, 28);
		getContentPane().add(JLoaithanhtoan);

		JLabel JLsotien = new JLabel("Số Tiền");
		JLsotien.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		JLsotien.setBounds(57, 123, 134, 28);
		getContentPane().add(JLsotien);

		JTextField JTsotien = new JTextField();
		JTsotien.setBounds(207, 112, 241, 39);
		getContentPane().add(JTsotien);
		JTsotien.setColumns(10);

		JButton btnpay = new JButton("PAY");
		btnpay.setBackground(new Color(255, 0, 0));
		btnpay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnpay.setBounds(281, 229, 174, 53);
		getContentPane().add(btnpay);

		JButton btnHome = new JButton("HOME");
		btnHome.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("home.png"))));
		btnpay.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("bill.png"))));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHome.setBackground(new Color(175, 238, 238));
		btnHome.setBounds(69, 229, 174, 53);
		getContentPane().add(btnHome);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("D:\\ANHlamjava\\l.jpg"));
		lblNewLabel.setBounds(-64, -24, 719, 329);
		getContentPane().add(lblNewLabel);
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
							JOptionPane.showMessageDialog(null, "Đặt vé thành công");
						} else {
							JOptionPane.showMessageDialog(null, "Hết tiền hoặc số tiền không hợp lệ");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Không tồn tại tài khoản");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
}
