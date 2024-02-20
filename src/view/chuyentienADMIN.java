package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.main;

public class chuyentienADMIN extends JFrame {
	private JLabel JLchuyentienADMIN = new JLabel("Số Tiền");
	private JTextField JTsotien = new JTextField(20);
	private JLabel JLtaikhoan = new JLabel("Tài khoản chuyển");
	private JTextField JTtaikhoan = new JTextField(20);
	private JLabel JLtknhan = new JLabel("Tài khoản nhận");
	private JTextField JTtknhan = new JTextField(20);
	private final JLabel lblNewLabel = new JLabel();

	public chuyentienADMIN() {

		Container sc = this.getContentPane();
		JButton btnHome = new JButton("HOME");
		btnHome.setBounds(66, 155, 134, 41);

		btnHome.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(chuyentienADMIN.class.getResource("home.png"))));
		JButton btnpay = new JButton("PAY");
		btnpay.setBounds(221, 155, 134, 41);
		btnpay.setBackground(new Color(255, 0, 0));
		btnpay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnpay.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(chuyentienADMIN.class.getResource("bill.png"))));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHome.setBackground(new Color(175, 238, 238));

		JPanel nut = new JPanel();
		nut.setLayout(null);
		nut.add(btnHome);
		JTsotien.setBounds(211, 109, 182, 30);
		nut.add(JTsotien);
		nut.add(btnpay);
		sc.add(nut);
		JLchuyentienADMIN.setForeground(new Color(255, 255, 255));
		JLchuyentienADMIN.setBounds(38, 103, 91, 36);
		nut.add(JLchuyentienADMIN);
		JTtaikhoan.setBounds(211, 28, 182, 30);
		nut.add(JTtaikhoan);
		JTtknhan.setBounds(211, 69, 182, 30);
		nut.add(JTtknhan);
		JLchuyentienADMIN.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		JLtaikhoan.setForeground(new Color(255, 255, 255));
		JLtaikhoan.setBounds(38, 28, 168, 30);
		nut.add(JLtaikhoan);

		JLtaikhoan.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		JLtknhan.setForeground(new Color(255, 255, 255));
		JLtknhan.setBounds(38, 68, 162, 30);
		nut.add(JLtknhan);

		JLtknhan.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(-231, -242, 989, 561);
		lblNewLabel.setIcon(new ImageIcon("D:\\ANHlamjava\\a.jpg"));

		nut.add(lblNewLabel);

		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				giaodienQuanlyADMIN sc = new giaodienQuanlyADMIN();
				sc.setVisible(true);
				setVisible(false);
			}
		});

		btnpay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try (Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12");
							Statement stmt = conn.createStatement()) {

						ResultSet rs = stmt.executeQuery(
								"SELECT sotien FROM taikhoanclient WHERE taikhoan = '" + JTtaikhoan.getText() + "'");
						if (rs.next()) {
							int JTsotienValue = Integer.parseInt(JTsotien.getText());

							if (rs.getInt("sotien") >= JTsotienValue) {
								try (PreparedStatement updateSourceStmt = conn.prepareStatement(
										"UPDATE taikhoanclient SET sotien = sotien - ? WHERE taikhoan = ?");
										PreparedStatement updateTargetStmt = conn.prepareStatement(
												"UPDATE taikhoanclient SET sotien = sotien + ? WHERE taikhoan = ?")) {

									updateSourceStmt.setInt(1, JTsotienValue);
									updateSourceStmt.setString(2, JTtaikhoan.getText());
									updateSourceStmt.executeUpdate();

									updateTargetStmt.setInt(1, JTsotienValue);
									updateTargetStmt.setString(2, JTtknhan.getText());
									updateTargetStmt.executeUpdate();

									JOptionPane.showConfirmDialog(null, "Thành công");
								}
							} else {
								JOptionPane.showConfirmDialog(null, "Không đủ tiền");
							}
						} else {
							JOptionPane.showConfirmDialog(null, "Không tồn tại tài khoản");
						}
					}
				} catch (ClassNotFoundException | SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		setTitle("Chuyển Tiền");
		setVisible(true);
		setSize(428, 243);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
