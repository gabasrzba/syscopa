package syscopa;
import dao.*;
import java.util.Scanner;

// CLASSE JOGADOR:
public class Jogador {
	static Scanner scan = new Scanner(System.in);
	
	/**
	 *  DADOS DO JOGADOR:
	 */
	private int codJog;
	private String nomeJog;
	private String posJog;
	private String selJog;
	private int golsJog;
	private int amarelosJog;
	private int vermelhosJog;
	
	/**
	 * CONSTRUCTOR DE JOGADOR:
	 * @param codJog
	 * @param nomeJog
	 * @param posJog
	 * @param selJog
	 * @param golsJog
	 * @param amarelosJog
	 * @param vermelhosJog
	 */
	public Jogador(int codJog, String nomeJog, String posJog, String selJog, int golsJog, int amarelosJog, int vermelhosJog){
		this.codJog = codJog;
		this.nomeJog = nomeJog;
		this.posJog = posJog;
		this.selJog = selJog;
		this.golsJog = golsJog;
		this.amarelosJog = amarelosJog;
		this.vermelhosJog = vermelhosJog;
	}
	
	// GETTER'S E SETTER'S DE JOGADOR:
	public int getCodJog() {return codJog;}
	public String getNomeJog() {return nomeJog;}
	public String getPosJog() {return posJog;}
	public String getSelJog() {return selJog;}
	public int getGolsJog() {return golsJog;}
	public int getAmarelosJog() {return amarelosJog;}
	public int getVermelhosJog() {return vermelhosJog;}
	
	public void setCodJog(int codJog) {this.codJog = codJog;}
	public void setNomeJog(String nomeJog) {this.nomeJog = nomeJog;}
	public void setPosJog(String posJog) {this.posJog = posJog;}
	public void setSelJog(String selJog) {this.selJog = selJog;}
	public void setGolsJog(int golsJog) {this.golsJog = golsJog;}
	public void setAmarelosJog(int amarelosJog) {this.amarelosJog = amarelosJog;}
	public void setVermelhosJog(int vermelhosJog) {this.vermelhosJog = vermelhosJog;}
	
	
	
	public String toString() {
		return "\nNOME: " + this.getNomeJog() +
			   "\nGOLS: " + this.getGolsJog() +
			   "\nPOSICAO: " + this.getPosJog() +
			   "\nCARTOES AMARELOS: " + this.getAmarelosJog() +
			   "\nCARTOES VERMELHOS: " + this.getVermelhosJog() +
			   "\nSelecao do jogador: " + this.getSelJog();
	}
	
	/**
	 * MENU DE JOGADOR:
	 */
	public static void menuJogador() {
		int opcao;
		do {
			System.out.println("\n---------- MENU DE JOGADORES ----------");
			System.out.println("1 - ADICIONAR NOVO JOGADOR");
			System.out.println("2 - ATUALIZAR JOGADOR EXISTENTE");
			System.out.println("3 - REMOVER JOGADOR EXISTENTE");
			System.out.println("4 - VISUALIZAR LISTA DE JOGADORES");
			System.out.println("5 - VOLTAR AO MENU 'SYSCOPA'");
			System.out.flush();
			opcao = scan.nextInt();
			switch(opcao) {
				case 1:
					JogadorDAO.inserirJogador(null);
					break;
				case 2:
					JogadorDAO.editarJogador();
					break;
				case 3:
					JogadorDAO.excluirJogador();
					break;
				case 4:
					JogadorDAO.listarJogadores();
					break;
				case 5:
					Main.main(null);
			}
		} while(opcao != 5);
}
		
}