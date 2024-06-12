package tela;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

import javax.swing.JDialog;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JDialog {
	private JTextField textNomedoCadastro;
	private JTextField textUserdoCadastro;
	private JTextField textSenhadoCadastro;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
		int ln;
		

	public Cadastro() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 546, 455);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblUser = new JLabel("USER:");
		lblUser.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblUser.setBounds(104, 180, 51, 21);
		panel.add(lblUser);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(104, 141, 51, 28);
		panel.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("SENHA:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(94, 214, 73, 14);
		panel.add(lblNewLabel);
		setLocationRelativeTo(null);
		
		textNomedoCadastro = new JTextField();
		textNomedoCadastro.setBounds(183, 146, 217, 20);
		panel.add(textNomedoCadastro);
		
		JLabel lblCadastro = new JLabel("CADASTRO");
		lblCadastro.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblCadastro.setBounds(197, 61, 114, 28);
		panel.add(lblCadastro);
		
		textUserdoCadastro = new JTextField();
		textUserdoCadastro.setColumns(10);
		textUserdoCadastro.setBounds(183, 181, 217, 20);
		panel.add(textUserdoCadastro);
		
		textSenhadoCadastro = new JTextField();
		textSenhadoCadastro.setColumns(10);
		textSenhadoCadastro.setBounds(183, 212, 217, 20);
		panel.add(textSenhadoCadastro);
		
		JButton btnConfir_cad = new JButton("CADASTRAR");
		btnConfir_cad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNomedoCadastro.getText()!=null || textSenhadoCadastro !=null || textUserdoCadastro!=null) {
					createFolder();
					readFile();
					contelinhas();
					addData(textNomedoCadastro.getText(),textUserdoCadastro.getText(),textSenhadoCadastro.getText());	
					JOptionPane.showMessageDialog(null, "cadastro confirmado!!!");
					TelaPrincipal tl = new TelaPrincipal();
					tl.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "formulario preenchido incorretamente!!!");
				}
			}
		});
		btnConfir_cad.setBounds(225, 256, 138, 37);
		panel.add(btnConfir_cad);
		
		JButton btnVoltar_cad = new JButton("VOLTAR");
		btnVoltar_cad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tl = new TelaPrincipal();
				tl.setVisible(true);
				dispose();
			}
		});
		btnVoltar_cad.setBounds(54, 338, 101, 37);
		panel.add(btnVoltar_cad);
		
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

	void addData(String nome, String user, String senha){
		try {
			RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
			for(int i =0;i<ln;i++) {
				raf.readLine();
			}
			raf.writeBytes("\r\n");
			raf.writeBytes("Nome:"+nome+"\r\n");
			raf.writeBytes("User:"+user+"\r\n");
			raf.writeBytes("Senha:"+senha+"\r\n");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void contelinhas() {
		
		try {
			ln =1;
			RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
			for(int i=0;raf.readLine() !=null; i++) {
				ln++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public boolean logic(String user, String pswd) {
		boolean confirmado = false;
		try {
			int nl =1;
			RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
	
			for(int i=0;i<ln;i+=2) {
			
				String forUser = raf.readLine().substring(5);
				String forsenha =raf.readLine().substring(6);
				if(user.equals(forUser) & pswd.equals(forsenha)) {
					confirmado = true;
					break;
				}
				else if(i==(ln-3)) {
					JOptionPane.showMessageDialog(null, " Usuario ou senha incorreto!!!");
				}
				for(int j=1;j<=1;j++) {
					raf.readLine();
				}
		
			}
		} catch (FileNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	return confirmado;	
	}
}
