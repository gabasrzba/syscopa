package syscopa;
import java.util.Scanner;

/**
 * AUTORES: GABRIEL RIBEIRO SOUZA E GABRIEL SANTOS CRUZ
COMPONENTE CURRICULAR: EXA863 MI PROGRAMACAO
CONCLUIDO EM: 26/09/22
DECLARO QUE ESTE CÓDIGO FOI ELABORADO POR MIM DE FORMA INDIVIDUAL E NÃO CONTÉM NENHUM
TRECHO DE CODIGO DE OUTRO COLEGA OU DE OUTRO AUTOR, TAIS COMO PROVINDOS DE LIVROS E
APOSTILAS, E PAGINAS OU DOCUMENTOS ELETRONICOS DA INTERNET. QUALQUER TRECHO DE CODIGO
DE OUTRA AUTORIA QUE NAO A MINHA ESTA DESTACADO COM UMA CITACAO PARA O AUTOR E A FONTE
DO CODIGO, E ESTOU CIENTE QUE ESTES TRECHOS NAO SERAO CONSIDERADOS PARA FINS DE AVALIACAO.
 * @author GABRIEL RIBEIRO E GABRIEL SANTOS
 *
 */

/**
 * SISTEMA 'SYSCOPA'
 * 
 */
public class Main {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int opcao;
			do {
				System.out.println("\n---------- SYSCOPA ----------");
				System.out.println("1 - MENU DE JOGADORES");
				System.out.println("2 - MENU DE SELECOES");
				System.out.println("3 - MENU DE TECNICOS");
				System.out.println("4 - MENU DE ARBITROS");
				System.out.println("5 - SAIR");
				System.out.flush();
				opcao = scan.nextInt();
				switch(opcao) {
					case 1:
						Jogador.menuJogador();
						break;
					case 2:
						Selecao.menuSelecao();
						break;
					case 3:
						Tecnico.menuTecnico();
						break;
					case 4:
						Arbitro.menuArbitro();
						break;
					case 5:
						System.out.println("PROGRAMA ENCERRADO");
						break;
				}
			} while(opcao != 5);
		}
	}
}