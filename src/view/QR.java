package view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class QR extends JFrame {
	public QR() {

		JLabel qr = new JLabel();
		qr.setBounds(93, 10, 160, 205);
		qr.setIcon(new ImageIcon("D:\\ANHlamjava\\maqr.jpg"));
		Container sc = this.getContentPane();
		getContentPane().setLayout(null);

		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHome.setBounds(107, 225, 121, 37);
		getContentPane().add(btnHome);
		btnHome.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(chuyentien.class.getResource("home.png"))));
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				giaodienchucnangCLIENT sc = new giaodienchucnangCLIENT();
				sc.setVisible(true);
				setVisible(false);
			}
		});
		sc.add(qr);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("D:\\ANHlamjava\\cxx.jpg"));
		lblNewLabel.setBounds(-15, 0, 513, 282);
		getContentPane().add(lblNewLabel);
		setVisible(true);
		setSize(348, 309);
		setLocationRelativeTo(null);
		setTitle("MAQR");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
