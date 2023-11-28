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
		
		JLabel lblGentlemenSingleResult = new JLabel("Result of the round " + tournament.getSchedules().get(0).getActualRound());
		lblGentlemenSingleResult.setBounds(5, 5, 157, 13);
		lblGentlemenSingleResult.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblGentlemenSingleResult);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.setBounds(5, 18, 96, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home homeFrame = new Home();
				homeFrame.setVisible(true);

				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Start Round");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Lancer les matches en respectant le Round
			}
		});
		btnNewButton_1.setBounds(5, 39, 121, 21);
		contentPane.add(btnNewButton_1);
		
		
		
		for(Schedule s : tournament.getSchedules()) {
			for(Match m : s.getMatches()) {
				JLabel lblMatch = new JLabel("Match : " + (i+1));
				lblMatch.setBounds(10, yOffset, 100, 13);
		        contentPane.add(lblMatch);
		        i+=1;
		        if(i == 64) {
		            i=0;
		        }
		        
				for(Opponent o : m.getOpponents()) {
	            	for(Player p : o.getPlayers()) {
	            		JLabel lblNewLabel = new JLabel(p.getFirstname() + " " + p.getLastname());
		        		
						lblNewLabel.setBounds(xOffset, yOffset, 200, 13);
		        		contentPane.add(lblNewLabel);
		        		xOffset+=50;
	            	}
	            	xOffset-=50;
	            	yOffset += 15;
	            }
	            yOffset += 30;
			}
		}
	}
}
