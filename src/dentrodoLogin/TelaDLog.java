package dentrodoLogin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDLog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public TelaDLog() {
		setBounds(100, 100, 454, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("JOGAR");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						Java2DTeste ent = new Java2DTeste();
						Java2DTeste.jogue();
						ent.setVisible(true);
					} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "contate o desenvolvedor!!");
						e1.printStackTrace();
					}
				dispose();
					
				}
			});
			btnNewButton.setBounds(148, 123, 125, 33);
			btnNewButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("RANKING");
			btnNewButton_1.setBounds(148, 226, 125, 33);
			btnNewButton_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("SAIR");
			btnNewButton_2.setBounds(64, 332, 67, 27);
			btnNewButton_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
			contentPanel.add(btnNewButton_2);
		}
		{
			JLabel lblNewLabel = new JLabel("BEM VINDO AO POING GAME");
			lblNewLabel.setBounds(112, 48, 214, 18);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
			contentPanel.add(lblNewLabel);
		}
	}

}
