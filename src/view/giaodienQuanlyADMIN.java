package view;

import java.awt.Component;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.Font;
import java.awt.Toolkit;

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

public class giaodienQuanlyADMIN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField JTtaikhoan;
	private final JLabel lblNewLabel = new JLabel();
	public static String taikhoanclient;
	public giaodienQuanlyADMIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 597);
		getContentPane().setLayout(null);
		setTitle("giaodienADmin");
		JLabel JLxoatk = new JLabel("Xóa Tài Khoản");
		JLxoatk.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLxoatk.setBounds(127, 41, 130, 31);
		getContentPane().add(JLxoatk);

		JButton btnxoatk = new JButton();
		btnxoatk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnxoatk.setBounds(262, 10, 92, 80);
		getContentPane().add(btnxoatk);
		btnxoatk.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(giaodienQuanlyADMIN.class.getResource("user.png"))));
		JLabel JLruttien = new JLabel("Rút Tiền");
		JLruttien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLruttien.setBounds(127, 152, 99, 31);
		getContentPane().add(JLruttien);

		JButton btnruttien = new JButton();
		btnruttien.setBounds(262, 133, 92, 72);
		getContentPane().add(btnruttien);
		btnruttien.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(giaodienQuanlyADMIN.class.getResource("ruttien.png"))));
		JLabel JLNaptien = new JLabel("Nap Tiền");
		JLNaptien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLNaptien.setBounds(398, 41, 114, 31);
		getContentPane().add(JLNaptien);

		JLabel JlchuyenTien = new JLabel("Chuyển Tiền");
		JlchuyenTien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JlchuyenTien.setBounds(398, 152, 107, 31);
		getContentPane().add(JlchuyenTien);

		JButton btnnaptien = new JButton();
		btnnaptien.setBounds(525, 22, 92, 72);
		getContentPane().add(btnnaptien);
		btnnaptien.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(giaodienQuanlyADMIN.class.getResource("salary.png"))));
		JButton btnchuyentien = new JButton();
		btnchuyentien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnchuyentien.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(giaodienQuanlyADMIN.class.getResource("chuyentien.png"))));
		btnchuyentien.setBounds(525, 133, 92, 72);
		getContentPane().add(btnchuyentien);

		JLabel Jlindanhsach = new JLabel("In Danh Sách");
		Jlindanhsach.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Jlindanhsach.setBounds(637, 41, 114, 31);
		getContentPane().add(Jlindanhsach);

		JButton btnindanhsach = new JButton();
		btnindanhsach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnindanhsach.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(giaodienQuanlyADMIN.class.getResource("printer.png"))));
		btnindanhsach.setBounds(761, 22, 92, 72);
		getContentPane().add(btnindanhsach);

		JLabel admin = new JLabel("ADMIN");
		admin.setFont(new Font("Times New Roman", Font.BOLD, 17));
		admin.setBounds(21, 51, 130, 117);
		getContentPane().add(admin);
		admin.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(giaodienQuanlyADMIN.class.getResource("admin.png"))));

		JLabel Jltaotk = new JLabel("Tạo Tài Khoản");
		Jltaotk.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Jltaotk.setBounds(627, 152, 124, 31);
		getContentPane().add(Jltaotk);

		JButton btntaotk = new JButton();
		btntaotk.setBounds(761, 133, 92, 72);
		getContentPane().add(btntaotk);
		btntaotk.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(giaodienQuanlyADMIN.class.getResource("addacc.png"))));

		JLabel JLtaikhoan = new JLabel("Tài Khoản");
		JLtaikhoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLtaikhoan.setBounds(303, 241, 107, 46);
		getContentPane().add(JLtaikhoan);
		btnxoatk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.jdbc.Driver");
					try (Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12")) {
						try (PreparedStatement stmt = conn
								.prepareStatement("DELETE from taikhoanclient WHERE taikhoan = ?")) {
							stmt.setString(1, JTtaikhoan.getText());
							int rowsAffected = stmt.executeUpdate();
							if (rowsAffected > 0) {
								JOptionPane.showMessageDialog(null, "Đã xóa tài khoản thành công");
							} else {
								JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại");
							}
						}
					} catch (SQLException ex) {
						ex.printStackTrace();

					}
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			}
		});
		btntaotk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					taotaikhoan sc = new taotaikhoan();
					sc.setVisible(true);
					setVisible(false);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

		JTtaikhoan = new JTextField();
		JTtaikhoan.setBounds(398, 244, 192, 46);
		getContentPane().add(JTtaikhoan);
		JTtaikhoan.setColumns(10);

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Họ và Tên");
		dm.addColumn("Số tài Khoản");
		dm.addColumn("Tài Khoản");
		dm.addColumn("Mật Khẩu");
		dm.addColumn("Quốc Tịch");
		dm.addColumn("Ngày Sinh");
		dm.addColumn("CMND");
		dm.addColumn("Số tiền");
		dm.addColumn("Quê Quán");
		dm.addColumn("Giới Tính");
		final JTable tbl = new JTable(dm);
		JScrollPane r = new JScrollPane(tbl);
		r.setBounds(21, 300, 855, 250);
		getContentPane().add(r);
		
		JButton btnsuatk = new JButton();
		btnsuatk.setIcon(new ImageIcon("C:\\Users\\nguye\\Downloads\\information.png"));
		btnsuatk.setBounds(624, 231, 58, 56);
		getContentPane().add(btnsuatk);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon("D:\\ANHlamjava\\l.jpg"));
		lblNewLabel.setBounds(-63, -38, 1024, 616);
		getContentPane().add(lblNewLabel);
		
		btnsuatk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					suatk sc = new suatk();
					sc.setVisible(true);
					setVisible(false);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

		btnindanhsach.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javacuoiki", "root", "dinhsinh12");
		            Statement sttm = conn.createStatement();
		            ResultSet rs = sttm.executeQuery("select * from taikhoanclient ORDER BY sotien DESC LIMIT 2;");
		            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) tbl.getModel();

		            // Clear existing data in the table
		            model.setRowCount(0);

		            int cols = rsmd.getColumnCount();
		            String[] colName = new String[cols];
		            for (int i = 0; i < cols; i++)
		                colName[i] = rsmd.getColumnName(i + 1);
		            model.setColumnIdentifiers(colName);

		            String hoten, sotk, taikhoan, matkhau, quoctich, ngaysinh, CMND, quequan, gioitinh;
		            String sotien;

		            while (rs.next()) {
		                hoten = rs.getString("hoten");
		                sotk = rs.getString("sotk");
		                taikhoan = rs.getString("taikhoan");
		                matkhau = rs.getString("matkhau");
		                quoctich = rs.getString("quoctich");
		                ngaysinh = rs.getString("ngaysinh");
		                CMND = rs.getString("CMND");
		                sotien = rs.getString("sotien");
		                quequan = rs.getString("quequan");
		                gioitinh = rs.getString("gioitinh");

		                String[] row = { hoten, sotk, taikhoan, matkhau, quoctich, ngaysinh, CMND, sotien, quequan, gioitinh };
		                model.addRow(row);
		            }

		            sttm.close();
		            conn.close();

		        } catch (ClassNotFoundException | SQLException e2) {
		            e2.printStackTrace();
		        }
		    }
		});
		btnnaptien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				naptien f = new naptien();
				f.setVisible(true);
				setVisible(false);
			}
		});
		btnchuyentien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chuyentienADMIN l = new chuyentienADMIN();
				l.setVisible(true);
				setVisible(false);
			}
		});
		btnruttien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ruttien sc = new ruttien();
					sc.setVisible(true);
					setVisible(false);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		taikhoanclient = JTtaikhoan.getText();

	}
}