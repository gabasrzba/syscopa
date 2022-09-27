package dao;
import syscopa.*;
import Interface.*;
import java.util.*;

public class JogadorDAO implements JogadorInterface{
	
	private static ArrayList<Jogador> listaJogador = new ArrayList<Jogador>();
	static Scanner scan = new Scanner(System.in);

	/**
	 *  ADICIONAR UM NOVO JOGADOR:
	 * @param nomeSelecao
	 * @return
	 */
		public static Jogador inserirJogador(String nomeSelecao) {
			boolean jaExiste = false;
			System.out.println("CODIGO DO JOGADOR: ");
			System.out.flush();
			int codigo = scan.nextInt();
			
			Iterator<Jogador> i = listaJogador.iterator();
			while(i.hasNext()) {
				Jogador e = i.next();
				if (e.getCodJog() == codigo) {
					jaExiste = true;
					while(jaExiste) {
						System.out.println("CODIGO JA USADO. TENTE OUTRO");
						System.out.println("CODIGO DO JOGADOR: ");
						System.out.flush();
						codigo = scan.nextInt();
						if (e.getCodJog() == codigo)
							jaExiste = true;
						else
							jaExiste = false;
					}
				}
			}
			System.out.println("NOME DO JOGADOR: ");
			System.out.flush();
			String nome = scan.next();
			System.out.println("POSICAO DO JOGADOR: ");
			System.out.flush();
			String posicao = escolherPosicao();
			System.out.println("GOLS DO JOGADOR: ");
			System.out.flush();
			int gols = scan.nextInt();
			System.out.println("CARTOES AMARELOS DO JOGADOR: ");
			System.out.flush();
			int cAmarelos = scan.nextInt();
			System.out.println("CARTOES VERMELHOS DO JOGADOR: ");
			System.out.flush();
			int cVermelhos = scan.nextInt();
//			qtdJog = listaJogador.size() + 1;
			listaJogador.add(new Jogador(codigo, nome, posicao, nomeSelecao, gols, cAmarelos, cVermelhos));
			return new Jogador(codigo, nome, posicao, nomeSelecao, gols, cAmarelos, cVermelhos);
		}
		
		/**
		 * MÉTODO PARA VISUALIZAR TODOS OS JOGADORES:
		 */
		public static void listarJogadores() {
			System.out.println("----------------------------------------");
			Iterator<Jogador> i = listaJogador.iterator();
			while(i.hasNext()) {
				Jogador e = i.next();
				System.out.println(e);
			}
			System.out.println("----------------------------------------");
		}
		
		/**
		 * MÉTODO PARA BUSCAR UM JOGADOR PELO CODIGO:
		 */
		public static void procurarJogador() {
			boolean encontrado = false;
			System.out.println("DIGITE O CODIGO DO JOGADOR QUE DESEJA ENCONTRAR:");
			System.out.flush();
			int codigo = scan.nextInt();
			System.out.println("----------------------------------------");
			Iterator<Jogador> i = listaJogador.iterator();
			while(i.hasNext()) {
				Jogador e = i.next();
				if (e.getCodJog() == codigo) {
				System.out.println(e);
				encontrado = true;
				}
			}
			if (!encontrado)
				System.out.println("CODIGO DE JOGADOR NAO ENCONTRADO");
			System.out.println("----------------------------------------");
		}
		
		/**
		 * MÉTODO PARA DELETAR UM JOGADOR:
		 */
		public static void excluirJogador() {
			boolean encontrado = false;
			System.out.println("DIGITE O CODIGO DO JOGADOR QUE DESEJA REMOVER: ");
			System.out.flush();
			int codigo = scan.nextInt();
			System.out.println("----------------------------------------");
			Iterator<Jogador> i = listaJogador.iterator();
			while(i.hasNext()) {
				Jogador e = i.next();
				if (e.getCodJog() == codigo) {
				i.remove();
				ArrayList<Selecao> listaSelecao = SelecaoDAO.getListaSelecao();
				ListIterator<Selecao> s = listaSelecao.listIterator();
				while(s.hasNext()) {
					Selecao f = s.next();
					ListIterator<Jogador> jogador = f.getListJog().listIterator();
					while (jogador.hasNext()) {
						Jogador j = jogador.next();
						if (j.getCodJog() == codigo) {
							jogador.remove();
						}
					}
				}
				encontrado = true;
				}
			}
			if (!encontrado)
				System.out.println("CODIGO DE JOGADOR NAO ENCONTRADO");
			else
				System.out.println("JOGADOR REMOVIDO");
			System.out.println("----------------------------------------");
		}
		
		/**
		 *  MÉTODO PARA SELECIONAR A POSIÇÃO DE 'JOGADOR':
		 * @return
		 */
		public static String escolherPosicao() {
			int opcao;
			String posicao = null;
			do {
				System.out.println("SELECIONE A POSICAO DO JOGADOR:");
				System.out.println("1 - GOLEIRO");
				System.out.println("2 - DEFENSOR");
				System.out.println("3 - MEIO-CAMPO");
				System.out.println("4 - ATACANTE");
				System.out.flush();
				opcao = scan.nextInt();
				switch(opcao) {
					case 1:
						posicao = "GOL";
					case 2:
						posicao = "DEFENSOR";
					case 3:
						posicao = "MEIO-CAMPO";
					case 4:
						posicao = "ATACANTE";
				}
			} while(opcao > 4);
			return posicao;
		}
		
		/**
		 * MÉTODO PARA ATUALIZAR DADOS DO JOGADOR:
		 */
		public static void editarJogador() {
			boolean encontrado = false;
			System.out.println("DIGITE O CODIGO DO JOGADOR QUE DESEJA ATUALIZAR: ");
			System.out.flush();
			int codigo = scan.nextInt();
			System.out.println("----------------------------------------");
			ListIterator<Jogador> l = listaJogador.listIterator(); // lista de jogadores do DAO
			while(l.hasNext()) {
				Jogador e = l.next();
				if(e.getCodJog() == codigo) {
						System.out.print("DIGITE O NOME DO JOGADOR: ");
						String nome = scan.next();
						System.out.print("DIGITE A POSICAO DO JOGADOR: ");
						String posicao = escolherPosicao();
						System.out.print("DIGITE A SELECAO DO JOGADOR: ");
						String selecao = scan.next();
						System.out.print("DIGITE A QUANTIDADE DE GOLS DO JOGADOR: ");
						int gols = scan.nextInt();
						System.out.print("DIGITE A QUANTIDADE DE CARTOES AMARELOS DO JOGADOR: ");
						int amarelos = scan.nextInt();
						System.out.print("DIGITE A QUANTIDADE DE CARTOES VERMELHOS DO JOGADOR: ");
						int vermelhos = scan.nextInt();
						l.set(new Jogador(codigo, nome,posicao,selecao,gols,amarelos,vermelhos)); // altera na lista do DAO
						ArrayList<Selecao> listaSelecao = SelecaoDAO.getListaSelecao();
						ListIterator<Selecao> s = listaSelecao.listIterator();
						while(s.hasNext()) {
							Selecao f = s.next();
							ListIterator<Jogador> jogador = f.getListJog().listIterator();
							while(jogador.hasNext()) {
								Jogador j = jogador.next();
									if(j.getNomeJog().equals(e.getNomeJog())){
										jogador.set(new Jogador(codigo, nome,posicao,selecao,gols,amarelos,vermelhos));
										encontrado = true;
							}
						}
					}
				}
			}
			if (!encontrado)
				System.out.println("CODIGO DE JOGADOR NAO ENCONTRADO");
			else
				System.out.println("JOGADOR ATUALIZADO");
			System.out.println("----------------------------------------");
			}
		
		/**
		 * MÉTODO PARA LER LISTA DE JOGADORES:
		 * @param listaJogador
		 */
		public static void listarJogadores(ArrayList<Jogador> listaJogador) {
			for (Jogador objeto : listaJogador) {
				System.out.println(objeto);
			}			
		}
}