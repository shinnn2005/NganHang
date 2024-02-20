package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;

public class giaodienchucnangCLIENT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton Rbtnnu;
	private JLabel JLNoicap;
	private JTextField JTngaycap;
	private JTextField JTnoicap;
	private JLabel JLsotaikhoan;
	private JTextField JTsotaikhoan;
	private JLabel JLmatkhau;
	private JPasswordField passwordField;
	private JLabel JLnaptien;
	private JTextField JTsotien;
	private JLabel JLghichu;
	private JTextField textField_1;
	private JButton btncapnhat;
	private JButton btndong;
	private JButton btnHome;
	private final JLabel JLnamebak = new JLabel("SHINBANK");

	/**
	 * Launch the application.
	 */

	public giaodienchucnangCLIENT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLnamebak.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		JLnamebak.setBounds(96, 10, 195, 36);
		contentPane.add(JLnamebak);
		JLnamebak.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("money.png"))));

		JButton btnChuyentien = new JButton("Chuyentien");
		btnChuyentien.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChuyentien.setBounds(257, 69, 109, 88);
		contentPane.add(btnChuyentien);
		btnChuyentien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chuyentien x = new chuyentien();
				x.setVisible(true);
				setVisible(false);

			}
		});

		JButton btnqrcode = new JButton("QRCODE");
		btnqrcode.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnqrcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QR sc = new QR();
				sc.setVisible(true);
				setVisible(false);

			}
		});
		btnqrcode.setBounds(129, 69, 118, 88);
		contentPane.add(btnqrcode);

		JButton btnTaikhoan = new JButton("Tai Khoan");
		btnTaikhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTaikhoan.setBounds(10, 69, 109, 88);
		contentPane.add(btnTaikhoan);
		btnTaikhoan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taikhoan sc = null;
				try {
					sc = new taikhoan();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				sc.setVisible(true);
				setVisible(false);
			}
		});
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBackground(Color.RED);
		horizontalBox_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		horizontalBox_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		horizontalBox_2.setBounds(0, 186, 378, 345);
		contentPane.add(horizontalBox_2);

		JButton btnqrpay = new JButton();
		btnqrpay.setIcon(new ImageIcon("C:\\Users\\nguye\\Downloads\\qr-scan.png"));
		btnqrpay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnqrpay.setBackground(new Color(255, 255, 255));
		btnqrpay.setBounds(24, 203, 62, 59);
		btnqrpay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				QR sc = new QR();
				sc.setVisible(true);
				setVisible(false);
			}
		});

		contentPane.add(btnqrpay);

		JButton btnchuyenkhoan = new JButton();
		btnchuyenkhoan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnchuyenkhoan.setBackground(Color.WHITE);
		btnchuyenkhoan.setBounds(161, 204, 62, 59);
		contentPane.add(btnchuyenkhoan);
		btnchuyenkhoan.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("ct.png"))));
		btnchuyenkhoan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chuyentien x = new chuyentien();
				x.setVisible(true);
				setVisible(false);

			}
		});

		JButton btnnaptienDT = new JButton();
		btnnaptienDT.setBackground(new Color(255, 255, 255));
		btnnaptienDT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnnaptienDT.setBounds(294, 203, 62, 59);
		contentPane.add(btnnaptienDT);
		btnnaptienDT
				.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("payment.png"))));
		btnnaptienDT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				naptienDT sc = new naptienDT();
				sc.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnthanhtoanhd = new JButton();
		btnthanhtoanhd.setBackground(new Color(255, 255, 255));
		btnthanhtoanhd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnthanhtoanhd.setBounds(24, 328, 62, 59);
		contentPane.add(btnthanhtoanhd);
		btnthanhtoanhd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thanhtoan sc = new thanhtoan();
				sc.setVisible(true);
				setVisible(false);
			}
		});
		btnthanhtoanhd
				.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("thanht.png"))));

		JButton btnmuavemb = new JButton();
		btnmuavemb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				muavv sc = new muavv();
				sc.setVisible(true);
				setVisible(false);
			}
		});
		btnmuavemb.setBackground(new Color(255, 255, 255));
		btnmuavemb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnmuavemb.setBounds(161, 328, 62, 59);
		btnmuavemb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("mayb.png"))));
		contentPane.add(btnmuavemb);

		JButton btndattau = new JButton();
		btndattau.setBackground(new Color(255, 255, 255));
		btndattau.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btndattau.setBounds(294, 328, 62, 59);
		contentPane.add(btndattau);
		btndattau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("train.png"))));
		btndattau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				muavv sc = new muavv();
				sc.setVisible(true);
				setVisible(false);
			}
		});

		JButton btndatTAXI = new JButton();
		btndatTAXI.setBackground(new Color(255, 255, 255));
		btndatTAXI.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btndatTAXI.setBounds(24, 432, 62, 59);
		contentPane.add(btndatTAXI);
		btndatTAXI.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("datxe.png"))));
		btndatTAXI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				muavv sc = new muavv();
				sc.setVisible(true);
				setVisible(false);
			}
		});

		JButton btndatphong = new JButton();
		btndatphong.setBackground(new Color(255, 255, 255));
		btndatphong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btndatphong.setBounds(161, 432, 62, 59);
		btndatphong.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("room.png"))));
		contentPane.add(btndatphong);
		btndatphong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				muavv sc = new muavv();
				sc.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnsodu = new JButton();
		btnsodu.setIcon(new ImageIcon("C:\\Users\\nguye\\Downloads\\profits (1).png"));
		btnsodu.setBackground(new Color(255, 255, 255));
		btnsodu.setBounds(294, 433, 62, 59);
		contentPane.add(btnsodu);
		btnsodu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12");
		            Statement stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT sotien FROM taikhoanclient WHERE taikhoan='" + dangnhapCLIENT.taikhoan + "'");

		            if (rs.next()) {
		                int sotien = rs.getInt("sotien");
		                JOptionPane.showMessageDialog(null, "Số dư của bạn là: " + sotien);
		            } else {
		                JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin số dư.");
		            }

		        } catch (Exception e2) {
		            e2.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi truy vấn số dư.");
		        }
		    }
		});


		JButton btnHomee = new JButton("Home");
		btnHomee.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHomee.setBounds(45, 541, 144, 59);
		contentPane.add(btnHomee);
		btnHomee.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("home.png"))));

		JButton btnupdate = new JButton("UPDATE");
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnupdate.setBackground(new Color(240, 240, 240));
		btnupdate.setBounds(199, 541, 144, 59);
		contentPane.add(btnupdate);
		btnupdate.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(acc.class.getResource("update.png"))));

		JLabel JLfunction = new JLabel("Chức Năng");
		JLfunction.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JLfunction.setBounds(0, 167, 123, 19);
		contentPane.add(JLfunction);
		ButtonGroup btnGroup = new ButtonGroup();

		btnupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				acc s = new acc();
				s.setVisible(true);
				setVisible(false);
			}
		});
		btnHomee.setBackground(new Color(240, 240, 240));

		JLabel JLmaqr = new JLabel("Mã QR");
		JLmaqr.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		JLmaqr.setBounds(24, 272, 62, 28);
		contentPane.add(JLmaqr);

		JLabel JLchuyentien = new JLabel("Chuyển Tiền");
		JLchuyentien.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		JLchuyentien.setBounds(140, 273, 99, 28);
		contentPane.add(JLchuyentien);

		JLabel JlnaptienDT = new JLabel("Nạp tiền ĐT");
		JlnaptienDT.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		JlnaptienDT.setBounds(271, 272, 95, 28);
		contentPane.add(JlnaptienDT);

		JLabel Jlthanhtoan = new JLabel("Thanh Toán");
		Jlthanhtoan.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		Jlthanhtoan.setBounds(10, 394, 99, 28);
		contentPane.add(Jlthanhtoan);

		JLabel Jldatmaybay = new JLabel("Đặt Máy Bay");
		Jldatmaybay.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		Jldatmaybay.setBounds(140, 397, 109, 28);
		contentPane.add(Jldatmaybay);

		JLabel JLdattau = new JLabel("Đặt Tàu");
		JLdattau.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		JLdattau.setBounds(294, 395, 74, 28);
		contentPane.add(JLdattau);

		JLabel JLdatxe = new JLabel("Đặt Taxi");
		JLdatxe.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		JLdatxe.setBounds(24, 501, 74, 28);
		contentPane.add(JLdatxe);

		JLabel JLdatphong = new JLabel("Đặt Phòng");
		JLdatphong.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		JLdatphong.setBounds(154, 503, 85, 28);
		contentPane.add(JLdatphong);

		JLabel Jlsodu = new JLabel("Số Dư");
		Jlsodu.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		Jlsodu.setBounds(295, 502, 62, 28);
		contentPane.add(Jlsodu);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("D:\\ANHlamjava\\cxx.jpg"));
		lblNewLabel.setBounds(-21, 0, 453, 684);
		contentPane.add(lblNewLabel);
		btnHomee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("CLIENT");
		setSize(392, 647);
		setLocationRelativeTo(null);
	}
}
