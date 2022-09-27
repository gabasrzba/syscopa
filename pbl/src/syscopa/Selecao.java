package syscopa;
import dao.*;
import java.util.*;

// CLASSE SELEÇÃO:
public class Selecao{

	private static String name;
	private ArrayList<Jogador> listJog = new ArrayList<Jogador>(11);
	private Tecnico tecnico;
	private static Scanner scan;
	
	
	/**
	 * CONSTRUCTOR DE SELEÇÃO:
	 * @param nome
	 * @param listJog
	 * @param tecnico
	 */
	public Selecao(String nome, ArrayList<Jogador> listJog, Tecnico tecnico){
		name = nome;
		this.listJog = listJog;
		this.tecnico = tecnico;
	}

	// GETTERS E SETTERS DA SELEÇÃO:
	public String getName() {return name;}
	public Tecnico getTecnico() {return tecnico;}
	
	public void setName(String nome) {name = nome;}
//	public static void setListJog(ArrayList<Jogador> listJog) {this.listJog = listJog;}
	public void setTecnico(Tecnico tecnico) {this.tecnico = tecnico;}
	
	public ArrayList<Jogador> getListJog() {return listJog;}

	public void setListJog(ArrayList<Jogador> jogador) {this.listJog = jogador;}
	
	public String toString() {
		return "Nome: "+ name +
			   "Jogadores: " + this.listJog +
			   "Tecnico: " + this.tecnico;
	}

	/**
	 * MENU DE SELEÇÃO:
	 */
	public static void menuSelecao() {
		
		scan = new Scanner(System.in);
		int opcao;
		do {
			System.out.println("\n---------- MENU DE SELECOES ----------");
			System.out.println("1 - INSERIR SELECAO");
			System.out.println("2 - EDITAR SELECAO");
			System.out.println("3 - EXCLUIR SELECAO");
			System.out.println("4 - LISTAR SELECOES");
			System.out.println("5 - VOLTAR AO MENU 'SYCOPA'");
			System.out.flush();
			opcao = scan.nextInt();
			switch(opcao) {
				case 1:
					SelecaoDAO.inserirSelecao();
					break;
				case 2:
					SelecaoDAO.editarSelecao();
					break;
				case 3:
					SelecaoDAO.excluirSelecao();
					break;
				case 4:
					SelecaoDAO.listarSelecao();
					break;
				case 5:
					Main.main(null);
			} 
		}while (opcao != 5);
	}
	
}