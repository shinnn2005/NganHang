package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;
import java.awt.Color;

public class taotaikhoan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField JTsotaikhoan;
	private JTextField textField;
	private JTextField JTngaysinh;
	private JLabel JlCMND;
	private JTextField JTsoCMND;
	private JLabel Jlquoctich;
	private JComboBox comboBox;
	private JLabel Jlquequan;
	private JTextField Jtquequan;
	private JLabel Jltaikhoan;
	private JTextField JTtaikhoan;
	private JLabel Jlmatkhau;
	private JPasswordField Jpmatkhau;
	private JTextField Jtsotk;
	private JButton btnnew;
	private JButton btnUpdate;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	public taotaikhoan() {

		getContentPane().setBackground(new Color(255, 248, 220));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 494);
		getContentPane().setLayout(null);

		JLabel Jlhoten = new JLabel("Họ Và Tên");
		Jlhoten.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		Jlhoten.setBounds(193, 26, 106, 39);
		getContentPane().add(Jlhoten);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(309, 26, 180, 39);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel Jlngaysinh = new JLabel("Ngày Sinh");
		Jlngaysinh.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		Jlngaysinh.setBounds(529, 119, 121, 39);
		getContentPane().add(Jlngaysinh);

		JTngaysinh = new JTextField();
		JTngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JTngaysinh.setColumns(10);
		JTngaysinh.setBounds(663, 119, 180, 39);
		getContentPane().add(JTngaysinh);

		JlCMND = new JLabel("CMND");
		JlCMND.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		JlCMND.setBounds(193, 119, 106, 39);
		getContentPane().add(JlCMND);

		JTsoCMND = new JTextField();
		JTsoCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JTsoCMND.setColumns(10);
		JTsoCMND.setBounds(309, 119, 180, 39);
		getContentPane().add(JTsoCMND);

		Jlquoctich = new JLabel("Quốc Tịch");
		Jlquoctich.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		Jlquoctich.setBounds(529, 187, 121, 39);
		getContentPane().add(Jlquoctich);

		String country[] = { "Việt Nam", "Anh", "USA", "Nhật Bản", "Thái Lan", "Lào", "Trung Quốc", "Nga", "Đức",
				"Hàn Quốc", "Ấn Độ" };
		comboBox = new JComboBox(country);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(663, 187, 180, 39);
		getContentPane().add(comboBox);

		JLabel Jlgioitinh = new JLabel("Giới Tính");
		Jlgioitinh.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		Jlgioitinh.setBounds(529, 28, 121, 39);
		getContentPane().add(Jlgioitinh);
		setTitle("Tạo Tài Khoản CLIENT");
		ButtonGroup ss = new ButtonGroup();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(640, 26, 203, 52);
		getContentPane().add(panel);
		panel.setLayout(null);

		JRadioButton rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(26, 6, 65, 40);
		panel.add(rdoNam);
		rdoNam.setBackground(new Color(255, 255, 255));
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ss.add(rdoNam);
		JRadioButton rdoNữ = new JRadioButton("Nữ");
		rdoNữ.setBounds(116, 4, 81, 44);
		panel.add(rdoNữ);
		rdoNữ.setBackground(new Color(255, 255, 255));
		rdoNữ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ss.add(rdoNữ);

		Jlquequan = new JLabel("Quê Quán");
		Jlquequan.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		Jlquequan.setBounds(24, 187, 121, 39);
		getContentPane().add(Jlquequan);

		Jtquequan = new JTextField();
		Jtquequan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Jtquequan.setColumns(10);
		Jtquequan.setBounds(134, 187, 355, 39);
		getContentPane().add(Jtquequan);

		Jltaikhoan = new JLabel("Tài Khoản");
		Jltaikhoan.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		Jltaikhoan.setBounds(99, 268, 128, 39);
		getContentPane().add(Jltaikhoan);

		JTtaikhoan = new JTextField();
		JTtaikhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JTtaikhoan.setColumns(10);
		JTtaikhoan.setBounds(214, 268, 180, 39);
		getContentPane().add(JTtaikhoan);

		Jlmatkhau = new JLabel("Mật Khẩu");
		Jlmatkhau.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		Jlmatkhau.setBounds(478, 268, 128, 39);
		getContentPane().add(Jlmatkhau);

		Jpmatkhau = new JPasswordField();
		Jpmatkhau.setBounds(592, 268, 188, 41);
		getContentPane().add(Jpmatkhau);

		JLabel Jlsotaikhoan = new JLabel("Số tài khoản");
		Jlsotaikhoan.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		Jlsotaikhoan.setBounds(275, 333, 128, 39);
		getContentPane().add(Jlsotaikhoan);

		Jtsotk = new JTextField();
		Jtsotk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Jtsotk.setColumns(10);
		Jtsotk.setBounds(401, 333, 180, 39);
		getContentPane().add(Jtsotk);

		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHome.setBounds(141, 392, 143, 55);
		getContentPane().add(btnHome);
		btnHome.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(taotaikhoan.class.getResource("home.png"))));

		btnnew = new JButton("New");
		btnnew.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnnew.setBounds(401, 392, 143, 55);
		btnnew.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(taotaikhoan.class.getResource("adduser.png"))));
		getContentPane().add(btnnew);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(640, 392, 143, 55);
		btnUpdate.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(taotaikhoan.class.getResource("update.png"))));
		getContentPane().add(btnUpdate);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nguye\\Downloads\\face-scan.png"));
		lblNewLabel_1.setBounds(10, 43, 121, 115);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("D:\\ANHlamjava\\ii.jpg"));
		lblNewLabel.setBounds(-52, 0, 994, 457);
		getContentPane().add(lblNewLabel);
		btnnew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String country = comboBox.getSelectedItem().toString();
				String gioitinh = "";

				if (rdoNam.isSelected())
					gioitinh = rdoNam.getText();
				if (rdoNữ.isSelected())
					gioitinh = rdoNữ.getText();

				try {
					Class.forName("com.mysql.jdbc.Driver");

					try (Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12")) {
						// Check if the username and account number already exist
						String checkQuery = "SELECT COUNT(*) FROM taikhoanclient WHERE taikhoan = ? OR sotk = ?";
						try (PreparedStatement checkStatement = conn.prepareStatement(checkQuery)) {
							checkStatement.setString(1, JTtaikhoan.getText());
							checkStatement.setString(2, Jtsotk.getText());

							try (ResultSet resultSet = checkStatement.executeQuery()) {
								resultSet.next();
								int count = resultSet.getInt(1);

								if (count > 0) {
									System.out.println(
											"Tên tài khoản hoặc số tài khoản đã tồn tại. Vui lòng chọn tên hoặc số tài khoản khác.");
									JOptionPane.showMessageDialog(null,
											"Tên tài khoản hoặc số tài khoản đã tồn tại. Vui lòng chọn tên hoặc số tài khoản khác.");
									return; // Stop the process if the username or account number already exists
								}
							}
						}

						// Use PreparedStatement for better performance and to prevent SQL injection
						String insertQuery = "INSERT INTO taikhoanclient (hoten, sotk, taikhoan, matkhau, quoctich, ngaysinh, CMND, quequan, gioitinh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

						try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {
							ps.setString(1, textField.getText());
							ps.setString(2, Jtsotk.getText());
							ps.setString(3, JTtaikhoan.getText());
							ps.setString(4, Jpmatkhau.getText());
							ps.setString(5, country);
							ps.setString(6, JTngaysinh.getText());
							ps.setString(7, JTsoCMND.getText());
							ps.setString(8, Jtquequan.getText());
							ps.setString(9, gioitinh);

							int recordsInserted = ps.executeUpdate();

							if (recordsInserted > 0) {
								JOptionPane.showMessageDialog(null, "Đã thêm tài khoản thành công");
							} else {
								System.out.println("Không thể thêm tài khoản. Kiểm tra lại dữ liệu.");
								JOptionPane.showMessageDialog(null, "Không thể thêm tài khoản. Kiểm tra lại dữ liệu.");
							}
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
						System.out.println("Lỗi khi thêm tài khoản: " + ex.getMessage());
						JOptionPane.showMessageDialog(null, "Lỗi khi thêm tài khoản: " + ex.getMessage());
					}
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
					System.out.println("Lỗi: Driver MySQL không được tìm thấy");
					JOptionPane.showMessageDialog(null, "Lỗi: Driver MySQL không được tìm thấy");
				}
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String country = comboBox.getSelectedItem().toString();
				String gioitinh = "";

				if (rdoNam.isSelected())
					gioitinh = rdoNam.getText();
				if (rdoNữ.isSelected())
					gioitinh = rdoNữ.getText();

				try {
					Class.forName("com.mysql.jdbc.Driver");

					try (Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12")) {
						// Use PreparedStatement for better performance and to prevent SQL injection
						String updateQuery = "UPDATE taikhoanclient SET hoten=?, sotk=?, matkhau=?, quoctich=?, ngaysinh=?, CMND=?, quequan=?, gioitinh=? WHERE taikhoan=?";

						try (PreparedStatement ps = conn.prepareStatement(updateQuery)) {
							ps.setString(1, textField.getText());
							ps.setString(2, Jtsotk.getText());
							ps.setString(3, Jpmatkhau.getText());
							ps.setString(4, country);
							ps.setString(5, JTngaysinh.getText());
							ps.setString(6, JTsoCMND.getText());
							ps.setString(7, Jtquequan.getText());
							ps.setString(8, gioitinh);
							ps.setString(9, JTtaikhoan.getText());

							int recordsUpdated = ps.executeUpdate();

							if (recordsUpdated > 0) {
								JOptionPane.showMessageDialog(null, "Đã cập nhật thành công!!");
							} else {
								JOptionPane.showMessageDialog(null, "Không thể cập nhật. Kiểm tra lại dữ liệu.");
							}
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật: " + ex.getMessage());
					}
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi: Driver MySQL không được tìm thấy");
				}
			}
		});
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
		setLocationRelativeTo(null);
	}
}
