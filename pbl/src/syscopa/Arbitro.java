package syscopa;
import dao.ArbitroDAO;
import java.util.Scanner;
import Interface.*;

public class Arbitro implements ArbitroInterface {
	static Scanner scan = new Scanner(System.in);
	
	/**
	 * DADOS DE ARBITRO:
	 */
	private String nome;
	private int codigo;
	
	/**
	 * CONSTRUCTOR DE ARBITRO:
	 * @param nome
	 * @param codigo
	 */
	public Arbitro(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}	
	
	public String toString() {
		return "\nNome: " + this.nome + "\nCodigo: " + this.codigo;
	}
	
	/**
	 * MENU DE ARBITRO:
	 */
	public static void menuArbitro() {
		int opcao;
		do {
			System.out.println("\n---------- MENU DE JOGADORES ----------");
			System.out.println("1 - ADICIONAR NOVO ARBITRO");
			System.out.println("2 - ATUALIZAR ARBITRO EXISTENTE");
			System.out.println("3 - REMOVER ARBITRO EXISTENTE");
			System.out.println("4 - VISUALIZAR LISTA DE ARBITROS");
			System.out.println("5 - VOLTAR AO MENU 'SYSCOPA'");
			System.out.flush();
			opcao = scan.nextInt();
			switch(opcao) {
				case 1:
					ArbitroDAO.inserirArbitro();
					break;
				case 2:
					ArbitroDAO.editarArbitro();
					break;
				case 3:
					ArbitroDAO.excluirArbitro();
					break;
				case 4:
					ArbitroDAO.listarArbitro();
					break;
				case 5:
					Main.main(null);
			}
		} while(opcao != 5);
	}
}