package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class naptien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField JTtaikhoan;
	private JTextField JTsotien;

	public naptien() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Nạp Tiền");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Jltaikhoan = new JLabel("Tài Khoản");
		Jltaikhoan.setForeground(Color.WHITE);
		Jltaikhoan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Jltaikhoan.setBounds(50, 41, 115, 28);
		contentPane.add(Jltaikhoan);

		JTtaikhoan = new JTextField();
		JTtaikhoan.setBounds(219, 41, 176, 28);
		contentPane.add(JTtaikhoan);
		JTtaikhoan.setColumns(10);

		JLabel JLsotien = new JLabel("Số Tiền");
		JLsotien.setForeground(Color.WHITE);
		JLsotien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		JLsotien.setBounds(50, 111, 115, 28);
		contentPane.add(JLsotien);

		JTsotien = new JTextField();
		JTsotien.setColumns(10);
		JTsotien.setBounds(219, 111, 176, 28);
		contentPane.add(JTsotien);

		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnHome.setBounds(52, 162, 155, 45);
		contentPane.add(btnHome);

		JButton btnconfirm = new JButton("Confirm");
		btnconfirm.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(taotaikhoan.class.getResource("confirmation.png"))));
		btnHome.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(taotaikhoan.class.getResource("home.png"))));
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					giaodienQuanlyADMIN sc = new giaodienQuanlyADMIN();
					sc.setVisible(true);
					setVisible(false);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnconfirm.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnconfirm.setBounds(231, 162, 153, 45);
		contentPane.add(btnconfirm);
		btnconfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12");
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(
							"SELECT sotien FROM taikhoanclient WHERE taikhoan = '" + JTtaikhoan.getText() + "'");

					if (rs.next()) {
						int JTsotienValue = Integer.parseInt(JTsotien.getText());

						if (JTsotienValue > 0) {
							stmt.executeUpdate("UPDATE taikhoanclient SET sotien = sotien + " + JTsotienValue
									+ " WHERE taikhoan = '" + JTtaikhoan.getText() + "'");
							JOptionPane.showConfirmDialog(null, "Nạp tiền thành công");
						} else {
							JOptionPane.showConfirmDialog(null, "Số tiền không hợp lệ");
						}
					} else {
						JOptionPane.showConfirmDialog(null, "Không tìm thấy tài khoản");
					}

					// Close resources
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					// Handle the exception appropriately
				}
			}
		});

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("D:\\ANHlamjava\\cxx.jpg"));
		lblNewLabel.setBounds(-283, 5, 840, 244);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}

}
