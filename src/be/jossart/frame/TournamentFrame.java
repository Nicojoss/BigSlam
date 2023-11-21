package be.jossart.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TournamentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public TournamentFrame(String tournamentType) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTournamentResult = new JLabel(tournamentType + " tournament result");
		lblTournamentResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblTournamentResult.setBounds(109, 10, 240, 13);
		contentPane.add(lblTournamentResult);
	}

}
