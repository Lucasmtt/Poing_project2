package dentrodoLogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//E um JPanel e implementa um metodo Run
public class Java2DTeste extends JPanel implements Runnable, KeyListener {

	// controle da direcao da bola
	int posx = 400, posy = 300;
	int velocidadeBola = 5;
	int DirecaoPosx = 1, DirecaoPosy = 1;
	int TamBola = 20;
	
	//contador do pause
	boolean pause = false;
	
	// controle barra
	boolean praCima = false, praBaixo = false;
	int playerPosx = 20, playerPosy = 300;
	int playerTamx = 30, playerTamy = 150;
	int velocidadeJog = 3;
	int playervidaInicial = 5;
	int playervidas = playervidaInicial;

	//contador das pontuacoes
	int pontuacao = 0;
	int MelhorPontuacao;
	int recordeAnterior;

	
	BufferedImage imagemVida;

	// escutador de teclas
	public static void jogue() throws Exception {

		// criando janela
		JFrame janela = new JFrame("Jogo Pong");
		janela.setSize(800, 620);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		janela.setResizable(false);

		// area onde posso desenhar
		Java2DTeste canvas = new Java2DTeste(); // se tem parenteses entao ele e um metodo contrutor..
		canvas.setBounds(0, 0, 800, 600);
		canvas.setVisible(true);

		janela.setLayout(null);
		janela.add(canvas);

		janela.addKeyListener(canvas);

		// continuar rodando normal...
		
	}
	
	// Contrutor
	public Java2DTeste() throws Exception {
		// criando o processo principal do jogo
		// referencia a mim mesmo, no caso o Java2DTeste
		Thread processoDoJogo = new Thread(this);
		processoDoJogo.start();

		try {
			imagemVida = ImageIO.read(new File("coracao.png"));
		} catch (IOException e) {
			System.out.println("Nao achei a imagem do coracao");
			e.printStackTrace();
		}

		
		//Salvar em Uma lista as melhores pontuacoes depois para os logins
		//receber os logins e suas pontuacoes
		BufferedReader leitor = new BufferedReader(new FileReader("MelhorPontuacao.txt"));
		String conteudoArquivo = leitor.readLine();
		leitor.close();
		MelhorPontuacao = Integer.parseInt(conteudoArquivo);
		//recordeAnterior = MelhorPontuacao;

	}

	public void run() {

		while (true) {
			if (!pause) {
				atualizar(); // atualiza
				repaint(); // repita
			
			}
			VelocidadeBola(); // pausa um pouco

		}
	}

	public void atualizar() {

		// funcao afin
		//ritmo do jogo a cada 3 defesas a velocidade aumenta
		velocidadeBola = 5 + pontuacao / 5;
		
		//aumentando a velocidade do jogador um pouco
		velocidadeJog = 5 + pontuacao / 7;
		
		//diminuir o tamanho
		playerTamy = 150 - pontuacao;

		posx += velocidadeBola * DirecaoPosx;
		posy += velocidadeBola * DirecaoPosy;

		if (posx > (800 - TamBola)) {// inverte a posicao da bolinha no lado direito da tela

			DirecaoPosx *= -1;
		}

		if (posx <= 0) {

			posx = 600;
			playervidas--;

			pause = true;

			// verifica se voce perdeu
			if (playervidas == 0) {

				//fazer escrever a pontuacao
				FileWriter escreve;
				try {
					escreve = new FileWriter("MelhorPontuacao.txt");
					escreve.write(MelhorPontuacao);
					escreve.close();
				} catch (IOException e) {
					System.out.println("Nao foi possivel salvar sua pontuacao");
					e.printStackTrace();
				}

				// saida do jogo
				int resposta = JOptionPane.showConfirmDialog(this, "Voce fez " + pontuacao + " e a Melhor Pontuacao e "
						+ MelhorPontuacao + "\n Voce Perdeu!!! Quer jogar novamente?");
				// reiniciando a contagem e o jogo
				if (resposta == JOptionPane.OK_OPTION) {
					playervidas = playervidaInicial;
					pontuacao = 0;
					praCima = false;
					praBaixo = false;

				} else {
					System.exit(1);
				}
			}

		}

		if (posy > (600 - TamBola) || posy <= 0) {
			DirecaoPosy *= -1;
		}

		// verifica se bolinha passou da barra ou bateu nela

		if (posx <= (playerPosx + playerTamx)) {

			if (posy + TamBola >= playerPosy && (posy <= playerPosy + playerPosy)) {

				DirecaoPosx *= -1;
				pontuacao++;

				if (pontuacao > MelhorPontuacao) {
					MelhorPontuacao = pontuacao;
				}
			}
		}

		if (praCima && playerPosy > 0) {

			playerPosy -= velocidadeJog;
		}

		if (praBaixo && playerPosy + playerTamy < 600) {
			playerPosy += velocidadeJog;
		}

	}

	public void VelocidadeBola() {
		// controle da velocidade da bola

		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override // serve para usar a minha versao do pintar

	// Desenho de um quadrado (permite desenhar)
	public void paintComponent(Graphics g2) {
		super.paintComponent(g2); // limpa a tela
		
		//colocando a minha fonte das letras
		java.awt.Font MinhaFont = new Font("Consolas", Font.BOLD, 20);
		

		// ligar o atialising que melhora na renderizacao dos objetos.
		Graphics2D g = (Graphics2D) g2.create();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		//font das palavras escritas no jogo
		g.setFont(MinhaFont);
		
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 600);

		// Retangulo
		g.setColor(Color.BLUE);
		// g.fillRect(playerPosx, playerPosy, playerTamx, playerTamy);
		g.fillRoundRect(playerPosx, playerPosy, playerTamx, playerTamy, 15, 15);

		// Bola
		
		Color verde = new Color(0, 255, 0);
		g.setColor(verde);
		g.fillOval(posx, posy, TamBola, TamBola);

		g.setColor(Color.black);
		g.drawString("Pontuacao: " + pontuacao, 600, 20);
		g.drawString("Melhor Pontuacao: " + MelhorPontuacao, 550, 40);

		for (int i = 0; i < playervidas; i++) {

			// coracao
			g.drawImage(imagemVida, 50 + (i * 32), 20, 32, 32, this);
		}
		
		
		if (pause) {
			g.drawString("Aperte ENTER para continuar", 250, 300);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W) {
			praCima = true;

		} else if (e.getKeyCode() == KeyEvent.VK_S) {

			praBaixo = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			pause = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W) {

			praCima = false;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {

			praBaixo = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
