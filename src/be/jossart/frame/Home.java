package be.jossart.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

		JButton btnStartGentlemenSingle = new JButton("Start Gentlemen Single");
		btnStartGentlemenSingle.setBounds(100, 60, 200, 30);
		contentPane.add(btnStartGentlemenSingle);

		JButton btnStartLadiesSingle = new JButton("Start Ladies Single");
		btnStartLadiesSingle.setBounds(100, 100, 200, 30);
		contentPane.add(btnStartLadiesSingle);

		JButton btnStartGentlemenDouble = new JButton("Start Gentlemen Double");
		btnStartGentlemenDouble.setBounds(100, 140, 200, 30);
		contentPane.add(btnStartGentlemenDouble);

		JButton btnStartLadiesDouble = new JButton("Start Ladies Double");
		btnStartLadiesDouble.setBounds(100, 180, 200, 30);
		contentPane.add(btnStartLadiesDouble);

		JButton btnStartMixedDouble = new JButton("Start Mixed Double");
		btnStartMixedDouble.setBounds(100, 220, 200, 30);
		contentPane.add(btnStartMixedDouble);
		
		btnStartGentlemenSingle.addActionListener(startTournamentListener("Gentlemen Single"));
		btnStartLadiesSingle.addActionListener(startTournamentListener("Ladies Single"));
		btnStartGentlemenDouble.addActionListener(startTournamentListener("Gentlemen Double"));
		btnStartLadiesDouble.addActionListener(startTournamentListener("Ladies Double"));
		btnStartMixedDouble.addActionListener(startTournamentListener("Mixed Double"));
	}

	private ActionListener startTournamentListener(final String tournamentType) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TournamentFrame tournamentFrame = new TournamentFrame(tournamentType);
				tournamentFrame.setVisible(true);

				dispose();
			}
		};
	}

}
