package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class suatk extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField JThoten;
	private JLabel JLquequan;
	private JTextField JTquequan;
	private JLabel JLCMND;
	private JLabel JLngaysinh;
	private JTextField JTCMND;
	private JTextField JTngaysinh;
	private JLabel lblNewLabel;
	private JButton btnupdate;
	private JPasswordField JPmatkhau;

	public suatk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 346);
		setTitle("Cập Nhật Thông Tin");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// tạo đường Viền 

		setContentPane(contentPane);//tránh việc sắp xếp mặc định và sẽ xếp theo SETBOUNDS từng cái 1 
		contentPane.setLayout(null);

		JLabel Jlhoten = new JLabel("Họ Và Tên");
		Jlhoten.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Jlhoten.setBounds(201, 47, 93, 24);
		contentPane.add(Jlhoten);

		JThoten = new JTextField();
		JThoten.setBounds(336, 45, 211, 34);
		contentPane.add(JThoten);
		JThoten.setColumns(10);

		JLabel JLmatkhau = new JLabel("Mật Khẩu");
		JLmatkhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLmatkhau.setBounds(201, 102, 93, 24);
		contentPane.add(JLmatkhau);

		JLquequan = new JLabel("Quê Quán");
		JLquequan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLquequan.setBounds(29, 163, 93, 24);
		contentPane.add(JLquequan);

		JTquequan = new JTextField();
		JTquequan.setColumns(10);
		JTquequan.setBounds(140, 153, 407, 34);
		contentPane.add(JTquequan);

		JLCMND = new JLabel("CMND");
		JLCMND.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLCMND.setBounds(29, 197, 93, 24);
		contentPane.add(JLCMND);

		JLngaysinh = new JLabel("Ngày Sinh");
		JLngaysinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLngaysinh.setBounds(321, 197, 93, 24);
		contentPane.add(JLngaysinh);

		JTCMND = new JTextField();
		JTCMND.setColumns(10);
		JTCMND.setBounds(128, 197, 183, 24);
		contentPane.add(JTCMND);

		JTngaysinh = new JTextField();
		JTngaysinh.setColumns(10);
		JTngaysinh.setBounds(418, 197, 183, 24);
		contentPane.add(JTngaysinh);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nguye\\Downloads\\face-scan.png"));
		lblNewLabel.setBounds(44, 24, 119, 117);
		contentPane.add(lblNewLabel);

		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon("C:\\Users\\nguye\\Downloads\\home.png"));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnHome.setBounds(128, 251, 159, 48);
		contentPane.add(btnHome);

		btnupdate = new JButton("Update");
		btnupdate.setIcon(new ImageIcon("C:\\Users\\nguye\\Downloads\\update.png"));
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnupdate.setBounds(349, 251, 159, 48);
		contentPane.add(btnupdate);

		JPmatkhau = new JPasswordField();
		JPmatkhau.setBounds(337, 89, 210, 37);
		contentPane.add(JPmatkhau);

		JLabel Jlbackground = new JLabel();
		Jlbackground.setIcon(new ImageIcon("D:\\ANHlamjava\\ii.jpg"));// tạo một đối tượng ImageIcon, đóng gói hình ảnh nằm ở đường dẫn tệp được chỉ định.
		Jlbackground.setBounds(-37, -14, 700, 336);
		contentPane.add(Jlbackground);
		btnupdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12");

					Statement stmt = conn.createStatement();

					stmt.executeUpdate("UPDATE taikhoanclient SET matkhau= '" + JPmatkhau.getText()
							+ "' WHERE taikhoan = '" + giaodienQuanlyADMIN.taikhoanclient + "'");
					stmt.executeUpdate("UPDATE taikhoanclient SET hoten= '" + JThoten.getText() + "' WHERE taikhoan = '"
							+ dangnhapCLIENT.taikhoan + "'");
					stmt.executeUpdate("UPDATE taikhoanclient SET quequan= '" + JTquequan.getText()
							+ "' WHERE taikhoan = '" + giaodienQuanlyADMIN.taikhoanclient + "'");
					stmt.executeUpdate("UPDATE taikhoanclient SET CMND= '" + JTCMND.getText() + "' WHERE taikhoan = '"
							+ giaodienQuanlyADMIN.taikhoanclient + "'");
					stmt.executeUpdate("UPDATE taikhoanclient SET ngaysinh= '" + JTngaysinh.getText()
							+ "' WHERE taikhoan = '" + giaodienQuanlyADMIN.taikhoanclient + "'");

					JOptionPane.showMessageDialog(null, "taikhoanclient information updated successfully.");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				giaodienQuanlyADMIN sc = new giaodienQuanlyADMIN();
				sc.setVisible(true);
				setVisible(false);
			}
		});
	}
}
