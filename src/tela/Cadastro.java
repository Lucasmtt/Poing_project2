package tela;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cadastro extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField textNomedoCadastro;
	private JTextField textUserdoCadastro;
	private JTextField textSenhadoCadastro;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	File f = new File("C:\\efiles\\UNIFACEAR");


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

				if ("".equals(textNomedoCadastro.getText())) {
					JOptionPane.showMessageDialog(null, "Campo Nome não pode está vazio!!!");
					textNomedoCadastro.requestFocus();

				} else if ("".equals(textUserdoCadastro.getText())) {

					JOptionPane.showMessageDialog(null, "Campo User não pode estar vazio!!!");

					textUserdoCadastro.requestFocus();

				} else if ("".equals(textSenhadoCadastro.getText())) {
					JOptionPane.showMessageDialog(null, "Campo Senha não pode estar vazio!!!");

					textSenhadoCadastro.requestFocus();

				}

				else {
					createFolder();
					readFile();
					Boolean cad = Boolean.FALSE;
					cad = userConfirme(textUserdoCadastro.getText());
					if (cad == false) {
				cadastro(textNomedoCadastro.getText(), textUserdoCadastro.getText(),
								textSenhadoCadastro.getText());

					} else {
						JOptionPane.showMessageDialog(null, "Nome de Usuario ja em uso!!");
					}
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

	void createFolder() {
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	void readFile() {

		try {
			FileReader fr = new FileReader(f + "\\logins.txt");

		} catch (FileNotFoundException e) {
			try {
				FileWriter fw = new FileWriter(f + "\\logins.txt");

			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "impossivel criar esse arquivo");
				e1.printStackTrace();
			}

		}

	}

	public void cadastro(String name, String nike, String pass) {
		try {

			FileWriter writer = new FileWriter("C:\\efiles\\UNIFACEAR\\logins.txt", true);
			PrintWriter out = new PrintWriter(writer, true);

			PrintWriter append = out.append(textNomedoCadastro.getText() + "," + textUserdoCadastro.getText() + ","
					+ textSenhadoCadastro.getText() + "," + "0");

			out.println();
			out.close();
			textNomedoCadastro.setText("");
			textUserdoCadastro.setText("");
			textSenhadoCadastro.setText("");
			JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso!");

		} catch (IOException Erro) {
			JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
		}
	}

	public Boolean userConfirme(String user) {

		String path = "C:\\efiles\\UNIFACEAR\\logins.txt";
		Boolean permit = Boolean.FALSE;
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {
				String[] vetor = line.split(",");

				if (user.equals(vetor[1])) {

					permit = true;
					break;
				} else {
					line = br.readLine();
				}
			}

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"não foi possivel salvar os dados," + " entre em contato com o desenvolvedor");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "erro ao ler arquivo, contate o desenvolvedor!!!");
		}

		return permit;
	}
}
