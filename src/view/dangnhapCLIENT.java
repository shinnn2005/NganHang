package view;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class dangnhapCLIENT extends JFrame {
	private Label JLtaikhoan = new Label("taikhoan");
	private JTextField JTtaikhoan = new JTextField(20);
	private JLabel JLmatkhau = new JLabel("matkhau");
	private JPasswordField JPmatkhau = new JPasswordField(20);
	 
	
	public static String taikhoan;

	public dangnhapCLIENT() {
		taikhoan = JTtaikhoan.getText();
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(JLtaikhoan);
		jp.add(JTtaikhoan);
		JLtaikhoan.setFont(new Font("Sylfaen", Font.PLAIN, 15));

		JPanel ok = new JPanel();
		ok.setLayout(new FlowLayout());
		ok.add(JLmatkhau);
		ok.add(JPmatkhau);
		JLmatkhau.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		
		JCheckBox hienmk = new JCheckBox("hiện mật khẩu");

		JButton btnLOGIN = new JButton("LOGIN");
		btnLOGIN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLOGIN.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(view.dangnhapCLIENT.class.getResource("client.png"))));
		JPanel as = new JPanel();
		as.setLayout(new FlowLayout());
		as.add(btnLOGIN);

		Container sc = this.getContentPane();
		sc.setLayout(new GridLayout(4, 1));
		sc.add(jp);
		sc.add(ok);
		sc.add(hienmk);
		sc.add(as);

		
		btnLOGIN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stu
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost/javacuoiki?" + "user=root&password=dinhsinh12");
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("Select * from taikhoanclient where taikhoan='"
							+ JTtaikhoan.getText() + "'and matkhau='" + JPmatkhau.getText() + "'");
					taikhoan = JTtaikhoan.getText();
					if (rs.next()) {
						giaodienchucnangCLIENT sc = new giaodienchucnangCLIENT();

						sc.setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Login Fail");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		
		hienmk.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (hienmk.isSelected()) {
		            JPmatkhau.setEchoChar((char) 0);
		        } else {
		            JPmatkhau.setEchoChar('•'); 
		        }
		    }
		});

		setTitle("Đăng nhập");
		setVisible(true);
		setSize(300, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
