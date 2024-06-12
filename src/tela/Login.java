package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dentrodoLogin.TelaDLog;

public class Login extends JDialog {
	
	private JTextField txtUser;
	private JPasswordField txtPassword;
	
	

	public Login() {
	
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 495);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		Panel panel = new Panel();
		panel.setBounds(0, 0, 532, 495);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(178, 168, 218, 20);
		panel.add(txtUser);
		
		JLabel lblUser = new JLabel("USER:");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblUser.setBounds(112, 168, 53, 18);
		panel.add(lblUser);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(230, 109, 100, 33);
		panel.add(lblNewLabel_1);
		
		JButton btnEntrarLogin = new JButton("ENTRAR");
		btnEntrarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if ("".equals(txtUser.getText())) {
					JOptionPane.showMessageDialog(null, "Coloque seu User!!!");
					txtUser.requestFocus();

				} else if ("".equals(txtPassword.getText())) {

					JOptionPane.showMessageDialog(null, "insira sua senha!!!");

					txtPassword.requestFocus();
				}else {
					Boolean confirme = Boolean.FALSE;
					confirme = librarcesso(txtUser.getText(), txtPassword.getText());
					
					if(confirme==true) {
					
						
						TelaDLog logado = new TelaDLog();
						logado.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "user ou senha invalidos!!!");

					}

				}
					

				
			
			
			
			}
		});
		btnEntrarLogin.setForeground(Color.GREEN);
		btnEntrarLogin.setBounds(216, 251, 141, 43);
		panel.add(btnEntrarLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(178, 208, 218, 20);
		panel.add(txtPassword);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblSenha.setBounds(98, 208, 67, 18);
		panel.add(lblSenha);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaPrincipal tl = new TelaPrincipal();
			tl.setVisible(true);
			dispose();
			}
		});
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBounds(215, 333, 141, 43);
		panel.add(btnVoltar);


	}

	 public Boolean librarcesso(String user, String senha) {
		  
		  String path ="C:\\efiles\\UNIFACEAR\\logins.txt";
		  Boolean permit = Boolean.FALSE;
		  try {
			FileReader	fr = new FileReader(path);
			BufferedReader br= new BufferedReader(fr);
			
			String line = br.readLine();
			
			
			while(line != null) {
				String[] vetor = line.split(",");
				
				if(user.equals(vetor[1]) && senha.equals(vetor[2])){
					
					permit = true;
					break;
				}
				else {
					line = br.readLine();
				}
			}		
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"não foi possivel salvar os dados,"
					+ " entre em contato com o desenvolvedor");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "erro ao ler arquivo, contate o desenvolvedor!!!");
		}
		  
		  return permit;
	  }
	 
	
}


