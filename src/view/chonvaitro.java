package view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class chonvaitro extends JFrame {

	private static final long serialVersionUID = 1L;

	public chonvaitro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel JLCHUCVU = new JLabel("POSITION");
		JLCHUCVU.setFont(new Font("Bodoni MT", Font.BOLD, 25));

		JButton btnADMIN = new JButton("ADMIN");
		btnADMIN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnADMIN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(chonvaitro.class.getResource("s.png"))));

		JButton btnCLIENT = new JButton("CLIENT");
		btnCLIENT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCLIENT.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(chonvaitro.class.getResource("client.png"))));

		JPanel JPchucvu = new JPanel();
		JPchucvu.add(JLCHUCVU);

		JPanel JPNUT = new JPanel();
		JPNUT.setLayout(new FlowLayout());
		JPNUT.add(btnADMIN);

		JPNUT.add(btnCLIENT);

		// sukien
		btnADMIN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loginADMIN sc = new loginADMIN();
				sc.setVisible(true);
				setVisible(false);
			}
		});
		btnCLIENT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dangnhapCLIENT sc = new dangnhapCLIENT();
				sc.setVisible(true);
				setVisible(false);
			}
		});
		final JLabel nen = new JLabel();
		nen.setIcon(new ImageIcon("D:\\ANHlamjava\\cs.jpg"));

		Container sc = this.getContentPane();
		sc.setLayout(new GridLayout(2, 1));
		sc.add(JPchucvu);
		sc.add(JPNUT);

		setVisible(true);
		setSize(400, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
