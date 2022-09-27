package dao;
import syscopa.*;
import Interface.*;
import java.util.*;

public class SelecaoDAO implements SelecaoInterface {
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * LISTA DE SELEÇÕES:
	 */
	private static ArrayList<Selecao> listaSelecao = new ArrayList<Selecao>();
	
	public static ArrayList<Selecao> getListaSelecao() {return listaSelecao;}

	public static void setListaSelecao(ArrayList<Selecao> listaSelecao) {SelecaoDAO.listaSelecao = listaSelecao;}

	/**
	 * MÉTODO PARA INSERIR UMA NOVA SELEÇÃO ONDE ELE ADICIONA PELO MENOS UM JOGADOR E TÉCNICO À SELEÇÃO:
	 */
	public static void inserirSelecao() {
		
		ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>(11);
		
		int opcao = 0;
		
		System.out.println("DIGITE O NOME DA SELECAO");
		System.out.flush();
		String nome = scan.next();
		System.out.println("INSERÇÃO DOS JOGADORES");
		int jogQuant;
		do {
			jogQuant = listaJogadores.size();
			Jogador jogador = JogadorDAO.inserirJogador(nome);
			listaJogadores.add(jogador);
//			Selecao.setListJog(listaJogadores);
			System.out.println("DESEJA ADICIONAR MAIS UM JOGADOR? [0] - SIM / [1] - NAO: ");
			opcao = scan.nextInt();
			System.out.flush();
			
		} while(opcao != 1 && jogQuant < 11);
		
		System.out.println("INSERCAO DO TECNICO");
		Tecnico tecnico = TecnicoDAO.inserirTecnico(nome);
		
		
		listaSelecao.add(new Selecao(nome, listaJogadores, tecnico));
	}

	/**
	 * MÉTODO PARA EDITAR UMA SELEÇÃO ONDE O NOME DELA É MODIFICADO:
	 */
	public static void editarSelecao() {
		boolean encontrado = false;
		
		System.out.println("DIGITE O NOME DA SELECAO QUE DESEJA EDITAR:");
		System.out.flush();
		String nomeSelecao = scan.next();
		System.out.println("----------------------------------------");
		ListIterator<Selecao> s = listaSelecao.listIterator();
		while(s.hasNext()) {
			Selecao e = s.next();
			if(e.getName().equals(nomeSelecao)) {
				System.out.println("DIGITE O NOVO NOME DA SELECAO: ");
				String name = scan.next();
				e.setName(name);
				
				encontrado = true;
			} 
				
		}
		if (!encontrado) {
			System.out.println("SELECAO NÃO ENCONTRADA");
		} else {
			System.out.println("SELECAO ATUALIZADA!");
		}
		
	}

	/**
	 * MÉTODO PARA EXCLUIR UMA SELEÇÃO:
	 */
	public static void excluirSelecao() {
		boolean encontrado = false;
		System.out.println("DIGITE O NOME DA SELECAO QUE DESEJA EDITAR:");
		System.out.flush();
		String nomeSelecao = scan.next();
		System.out.println("----------------------------------------");
		Iterator<Selecao> s = listaSelecao.iterator();
		while(s.hasNext()) {
			Selecao e = s.next();
			if(e.getName().equals(nomeSelecao)) {
				s.remove();		
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("SELECAO NAO ENCONTRADA!");
		} else {
			System.out.println("SELECAO REMOVIDA!");
		}
		
		
	}

	/**
	 * MÉTODO PARA LISTAR UMA SELEÇÃO:
	 */
	public static void listarSelecao() {
		for (Selecao selecao: listaSelecao) {
			System.out.println("NOME DA SELECAO: " + selecao.getName());
			System.out.print("JOGADORES: ");
			JogadorDAO.listarJogadores(selecao.getListJog()); 
			System.out.print("TECNICO: ");
			System.out.println(selecao.getTecnico());
		}
	}
}