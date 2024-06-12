package tela;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Jogador  {

	private String Nome;
	private String User;
	private String Senha;
	private Integer Ranking;

	
	
	public Jogador(String nome, String user, String senha, Integer ranking) {
		Nome = nome;
		User = user;
		Senha = senha;
		Ranking = ranking;
	}


	public Jogador() {
	
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getUser() {
		return User;
	}


	public void setUser(String user) {
		User = user;
	}


	public String getSenha() {
		return Senha;
	}


	public void setSenha(String senha) {
		Senha = senha;
	}


	public Integer getRanking() {
		return Ranking;
	}


	public void setRanking(Integer ranking) {
		Ranking = ranking;
	}
	
	ArrayList<Jogador> jogadorList= new ArrayList();
	
	Jogador jogador = new Jogador();
	
	

	 
	void ListarJogador(String NameJoglist, String UserJoglist, String SenhaJoglist) {
		
		jogador.Nome = NameJoglist;
		jogador.User = UserJoglist;
		jogador.Senha = SenhaJoglist;
		
		jogadorList.add(jogador);
		
	}
	
	

	
	public void createFolder() {
	File file = new File("C:\\PASTA1\\Pasta1");
		if(!file.exists()) {
			file.mkdirs();
			
		}
	file = new File("C:\\PASTA1\\Pasta1\\CADASTRO");
	if(!file.exists()) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	}
	public void salvarDoc() {
		
		
		
	
		
	}

	public Boolean ConfirmarSenha(String userConf, String senhaConf) {
		
	Boolean logar = false;	
	
		for(Jogador u : jogadorList) {
			
			String uUser = u.getUser();
			String uSenha = u.getSenha();
			
			boolean userConfere = userConf.equals(uUser);
			boolean senhaConfere = senhaConf.equals(uSenha);
			
			if(userConfere && senhaConfere) {
				logar = true;
				break;
			}
			
		}
		
		return logar;
	}
}	

