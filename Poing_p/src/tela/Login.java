package tela;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;

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
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				File f = new File("C:\\e files\\UNIFACEAR");
				Cadastro cad = new Cadastro();
				String senha = new String(txtPassword.getPassword());
				if(cad.logic(txtUser.getText(), senha)==true) {
					JOptionPane.showMessageDialog(null, "acesso permitido!!");
				}else {
					JOptionPane.showMessageDialog(null, "acesso negado!!");
				}
				
				
			/*	File f = new File("C:\\e files\\UNIFACEAR");
				try {
					int nl =1;
					RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
					String u =txtUser.getText();
					String p =txtPassword.getText();
					String forUser;
					String forsenha;
					for(int i=0;i<nl;i+=4) {
					
						forUser = raf.readLine().substring(5);
						forsenha =raf.readLine().substring(6);
						if(u.equals(forUser) && p.equals(forsenha)) {
							JOptionPane.showMessageDialog(null, " Usuario encontrado!!");
							break;
						}
						else if(i==(nl-2)) {
							JOptionPane.showMessageDialog(null, " Usuario ou senha incorreto!!!");
						}
						for(int j=1;j<=2;j++) {
							raf.readLine();
						}
				
					}
				} catch (FileNotFoundException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
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
	File f = new File("C:\\e files\\UNIFACEAR");
	void createFolder() {
		if(!f.exists()) {
			f.mkdirs();
		}
	}
	
	void readFile() {

		try {
			FileReader fr = new FileReader(f+"\\logins.txt");
			
		} catch (FileNotFoundException e) {
			try {
				FileWriter fw = new FileWriter(f+"\\logins.txt");
		
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		
	}	


}
