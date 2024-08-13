package be.jossart.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.jossart.pojo.Match;
import be.jossart.pojo.Opponent;
import be.jossart.pojo.Player;
import be.jossart.pojo.Schedule;
import be.jossart.pojo.Tournament;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class TournamentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int yOffset = 70;
	int xOffset = 69;
	int i;

	public TournamentFrame(Tournament tournament) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JScrollPane scrollPane = new JScrollPane(contentPane);
        setContentPane(scrollPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel lblGentlemenSingleResult = new JLabel("Result of the round ");
		lblGentlemenSingleResult.setBounds(5, 5, 157, 13);
		lblGentlemenSingleResult.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblGentlemenSingleResult);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(5, 18, 96, 21);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home homeFrame = new Home();
				homeFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnReturn);
		
		JButton btnStartRound = new JButton("Start Round");
		btnStartRound.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        for (Schedule s : tournament.getSchedules()) {
		            s.playNextRound();
		        }

		        DisplayResults();
		    }

		    private void DisplayResults() {
		        contentPane.removeAll();

		        JButton btnNextRound = new JButton("Next Round");
		        btnNextRound.setBounds(5, 5, 121, 21);
		        btnNextRound.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	if(tournament.getSchedules().get(0).getActualRound() > 1){
		            		for (Schedule s : tournament.getSchedules()) {
			                    s.prepareNextRound();
			                    s.playNextRound();
			                    DisplayResults();
			                }
		            	}else {
		            		for(Schedule s : tournament.getSchedules()) {
		            			s.getWinner();
		            		}
		            	}
		            }
		        });
		        contentPane.add(btnNextRound);

		        JLabel lblRoundResults = new JLabel("Results of the round ");
		        lblRoundResults.setBounds(5, 30, 300, 15);
		        lblRoundResults.setHorizontalAlignment(SwingConstants.CENTER);
		        lblRoundResults.setForeground(Color.BLUE);
		        contentPane.add(lblRoundResults);

		        int yOffset = 60; 
		        int xOffset = 10; 

		        for (Schedule s : tournament.getSchedules()) {
		        	if(s.getActualRound() >= 1) {
		        		JLabel lblScheduleType = new JLabel("Schedule Type: " + s.getType().name() + " - Round: " + s.getActualRound());
			            lblScheduleType.setBounds(10, yOffset, 300, 15);
			            lblScheduleType.setForeground(Color.RED);
			            contentPane.add(lblScheduleType);
		        	}
		            yOffset += 20;

		            for (Match m : s.getMatches()) {
		                JLabel lblMatch = new JLabel("Match: " + (s.getMatches().indexOf(m) + 1));
		                lblMatch.setBounds(10, yOffset, 100, 15);
		                contentPane.add(lblMatch);

		                xOffset = 120;
		                for (Opponent o : m.getOpponents()) {
		                    for (Player p : o.getPlayers()) {
		                        JLabel lblPlayer = new JLabel(p.getFirstname() + " " + p.getLastname());
		                        lblPlayer.setBounds(xOffset, yOffset, 200, 15);
		                        contentPane.add(lblPlayer);
		                        xOffset += 100;
		                    }
		                    yOffset += 15;
		                }

		                List<Player> winners = m.getWinnerPlayer();

		                String winnerNames = winners.stream()
		                        .map(p -> p.getFirstname() + " " + p.getLastname())
		                        .reduce((p1, p2) -> p1 + ", " + p2)
		                        .orElse("No Winner");

		                JLabel lblMatchResult = new JLabel("Winners: " + winnerNames +
		                        " | Score: " + m.getSetsWonByPlayer1() + "-" + m.getSetsWonByPlayer2());
		                lblMatchResult.setBounds(10, yOffset, 800, 15);
		                contentPane.add(lblMatchResult);

		                yOffset += 30;
		            }
		            if (s.getActualRound() == 1) {
		                List<Player> winners = s.getWinner();
		                String winnerNames = winners.stream()
		                        .map(p -> p.getFirstname() + " " + p.getLastname())
		                        .reduce((p1, p2) -> p1 + ", " + p2)
		                        .orElse("No Winner");

		                JLabel lblTournamentWinner = new JLabel("Tournament Winner(s): " + winnerNames);
		                lblTournamentWinner.setBounds(10, yOffset, 800, 15);
		                lblTournamentWinner.setForeground(Color.GREEN);
		                contentPane.add(lblTournamentWinner);

		                yOffset += 30;
		            }
		            if (s.getActualRound() < 1) {
		            	JLabel lblScheduleFinalType = new JLabel("Final Schedule Type: " + s.getType().name());
		                lblScheduleFinalType.setBounds(10, yOffset, 300, 15);
		                lblScheduleFinalType.setForeground(Color.RED);
		                contentPane.add(lblScheduleFinalType);

		                yOffset += 20;
		                
		                List<Player> winners = s.getWinner();
		                String winnerNames = winners.stream()
		                        .map(p -> p.getFirstname() + " " + p.getLastname())
		                        .reduce((p1, p2) -> p1 + ", " + p2)
		                        .orElse("No Winner");

		                JLabel lblTournamentWinner = new JLabel("Tournament Winner(s): " + winnerNames);
		                lblTournamentWinner.setBounds(10, yOffset, 800, 15);
		                lblTournamentWinner.setForeground(Color.GREEN);
		                contentPane.add(lblTournamentWinner);

		                yOffset += 30;
		            }
		            yOffset += 40;
		        }

		        contentPane.revalidate();
		        contentPane.repaint();
		    }
		});

		btnStartRound.setBounds(5, 39, 121, 21);
		contentPane.add(btnStartRound);
		
		
		
		
	}
}
