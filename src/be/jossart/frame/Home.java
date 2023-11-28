package be.jossart.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.jossart.pojo.Tournament;

import javax.swing.SwingConstants;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to the tennis tournament.");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(77, 14, 258, 21);
		contentPane.add(lblWelcome);

		JButton btnStartTournament = new JButton("Start Tournament");
		btnStartTournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tournament tournament = new Tournament("Big Slam");
				TournamentFrame tournamentFrame = new TournamentFrame(tournament);
				tournamentFrame.setVisible(true);

				dispose();
			}
		});
		btnStartTournament.setBounds(100, 60, 200, 30);
		contentPane.add(btnStartTournament);

	}

}
