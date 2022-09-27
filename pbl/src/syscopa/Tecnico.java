package syscopa;
import dao.*;
import Interface.TecnicoInterface;
import java.util.Scanner;

// CLASSE TECNICO:
public class Tecnico implements TecnicoInterface {
	static Scanner scan = new Scanner(System.in);
	
	/**
	 *  DADOS DO TECNICO:
	 */
	private int codTec;
	private String nomeTec;
	private static String nomeSelecao;
	
	/**
	 * CONSTRUCTOR DE TÉCNICO:
	 * @param codTec
	 * @param nomeTec
	 * @param Selecao
	 */
	public Tecnico(int codTec, String nomeTec, String Selecao) {
		this.codTec = codTec;
		this.nomeTec = nomeTec;
		nomeSelecao = Selecao;
	}
	
	// GETTER E SETTER DO ARBITRO:
	public int getCodTec() {return codTec;}
	public String getNomeTec() {return nomeTec;}
	
	public void setCodTec(int codTec) {this.codTec = codTec;}
	public void setNomeTec(String nomeTec) {this.nomeTec = nomeTec;}
	
	public static String getNomeSelecao() {
		return nomeSelecao;
	}

	public void setNomeSelecao(String Selecao) {
		nomeSelecao = Selecao;
	}

	public String toString() {return "\nCODIGO: " + codTec + 
			"\nNOME: " + nomeTec + 
			"\nSELECAO: " + nomeSelecao;}
	
	/**
	 * MENU DE TÉCNICO
	 */
	public static void menuTecnico() {
		int opcao;
		do {
			System.out.println("\n---------- MENU DE TECNICO ----------");
			System.out.println("1 - ADICIONAR NOVO TECNICO");
			System.out.println("2 - ATUALIZAR TECNICO EXISTENTE");
			System.out.println("3 - REMOVER TECNICO EXISTENTE");
			System.out.println("4 - VISUALIZAR LISTA DE TECNICOS");
			System.out.println("5 - VOLTAR AO MENU 'SYSCOPA'");
			System.out.flush();
			opcao = scan.nextInt();
			switch(opcao) {
				case 1:
					TecnicoDAO.inserirTecnico(null);
					break;
				case 2:
					TecnicoDAO.editarTecnico();
					break;
				case 3:
					TecnicoDAO.excluirTecnico();
					break;
				case 4:
					TecnicoDAO.listarTecnico();
					break;
				case 5:
					Main.main(null);
			}
		} while(opcao != 5);
	}
}