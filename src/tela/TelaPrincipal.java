package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private JPanel contentPane_1;

	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane_1 = new JPanel();
		contentPane_1.setBounds(0, 0, 493, 439);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1);
		contentPane_1.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblSeNoTem = new JLabel("SE N\u00C3O TEM CONTA CLIQUE EM NOVO JOGADOR:");
		lblSeNoTem.setBounds(77, 256, 380, 18);
		lblSeNoTem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeNoTem.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		contentPane_1.add(lblSeNoTem);
		
		JLabel lblJaTemConta = new JLabel("JA TEM CONTA:");
		lblJaTemConta.setBounds(59, 145, 380, 18);
		lblJaTemConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblJaTemConta.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		contentPane_1.add(lblJaTemConta);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login Logar = new Login();
				Logar.setVisible(true);
				dispose();
			}
		});
		btnEntrar.setBounds(207, 187, 89, 23);
		contentPane_1.add(btnEntrar);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro Cadatrar = new Cadastro();
				Cadatrar.setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setBounds(184, 301, 128, 23);
		contentPane_1.add(btnRegistrar);
	}
	
	

}

	



