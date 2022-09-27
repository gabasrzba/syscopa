package dao;
import syscopa.*;
import Interface.*;
import java.util.*;

public class TecnicoDAO implements TecnicoInterface{
	static Scanner scan = new Scanner(System.in);
	
	/**
	 * LISTA DE TÉCNICO:
	 */
	private static ArrayList<Tecnico> listaTecnicos = new ArrayList<Tecnico>();
	
	/**
	 * MÉTODO PARA INSERIR TÉCNICO:
	 * @param nomeSelecao
	 * @return
	 */
	public static Tecnico inserirTecnico(String nomeSelecao) {
		boolean jaExiste = false;
		System.out.println("CODIGO DO TECNICO: ");
		System.out.flush();
		int codigo = scan.nextInt();
		ListIterator<Tecnico> i = listaTecnicos.listIterator();
		while (i.hasNext()) {
			Tecnico e = i.next();
			if (e.getCodTec() == codigo) {
				jaExiste = true;
				while (jaExiste) {
					System.out.println("CODIGO DE TECNICO JA USA1DO. TENTE OUTRO");
					System.out.println("CODIGO DO TECNICO: ");
					System.out.flush();
					codigo = scan.nextInt();
					if (e.getCodTec() == codigo)
						jaExiste = true;
					else
						jaExiste = false;
				}
			}
		}
		
		System.out.println("NOME DO TECNICO: ");
		System.out.flush();
		String nome = scan.next();
		listaTecnicos.add(new Tecnico(codigo, nome, Tecnico.getNomeSelecao()));
		adicionarEmSelecao(new Tecnico(codigo, nome, Tecnico.getNomeSelecao()));
		return new Tecnico(codigo, nome, nomeSelecao);
	}

	/**
	 * MÉTODO PARA EDITAR UM TÉCNICO:
	 */
	@SuppressWarnings("static-access")
	public static void editarTecnico() {
		boolean encontrado = false;
		System.out.println("DIGITE O CODIGO DO TECNICO QUE DESEJA ATUALIZAR: ");
		System.out.flush();
		int codigo = scan.nextInt();
		System.out.println("----------------------------------------");
		ListIterator<Tecnico> l = listaTecnicos.listIterator();
		while(l.hasNext()) {
			Tecnico e = l.next();
			if(e.getCodTec() == codigo) {
				System.out.print("DIGITE O NOME DO TECNICO: ");
				String nome = scan.next();
				l.set(new Tecnico(codigo, nome, Tecnico.getNomeSelecao()));
				encontrado = true;
				
				ArrayList<Selecao> listaSelecao = SelecaoDAO.getListaSelecao();
				ListIterator<Selecao> s = listaSelecao.listIterator();
				while(s.hasNext()) {
					Selecao f = s.next();
					if(f.getName().equals(e.getNomeSelecao())){
						f.setTecnico(new Tecnico(codigo, nome, Tecnico.getNomeSelecao()));
					}
				}
			}
		}
		if (!encontrado)
			System.out.println("CODIGO DE TECNICO NAO ENCONTRADO");
		else
			System.out.println("TECNICO ATUALIZADO");
		System.out.println("----------------------------------------");
	}

	/**
	 * MÉTODO PARA EXCLUIR TÉCNICO:
	 */
	public static void excluirTecnico() {
		boolean encontrado = false;
		System.out.println("DIGITE O CODIGO DO TECNICO QUE DESEJA REMOVER: ");
		System.out.flush();
		int codigo = scan.nextInt();
		System.out.println("----------------------------------------");
		Iterator<Tecnico> i = listaTecnicos.iterator();
		while(i.hasNext()) {
			Tecnico e = i.next();
			if (e.getCodTec() == codigo) {
				i.remove();
				ArrayList<Selecao> listaSelecao = SelecaoDAO.getListaSelecao();
				ListIterator<Selecao> s = listaSelecao.listIterator();
				while(s.hasNext()) {
					Selecao e2 = s.next();
					Tecnico tec = e2.getTecnico();
					if(tec.getCodTec() == e.getCodTec()){
						e2.setTecnico(null);
				}
				encontrado = true;
				}
			}
	
		}
		if (!encontrado)
			System.out.println("CODIGO DE TECNICO NAO ENCONTRADO");
		else
			System.out.println("TECNICO REMOVIDO");
		System.out.println("----------------------------------------");
	}

	public static void listarTecnico() {
		for (Tecnico objeto : listaTecnicos) {
			System.out.println(objeto);		
		}
	}
	
	/**
	 * MÉTODO PARA ADICIONAR TÉCNICO À SELEÇÃO:
	 * @param tecnico
	 */
	@SuppressWarnings("static-access")
	public static void adicionarEmSelecao(Tecnico tecnico) {
		String nomeSelecao = scan.next();
		boolean encontrado = false;
		System.out.println("----------------------------------------");
		ArrayList<Selecao> listaSelecao = SelecaoDAO.getListaSelecao();
		Iterator<Selecao> s = listaSelecao.iterator();
		while(s.hasNext()) {
			Selecao e = s.next();
			if(e.getName().equals(tecnico.getNomeSelecao())) {
				if(e.getTecnico() == null) {
					tecnico.setNomeSelecao(nomeSelecao);
					e.setTecnico(tecnico);
				} else {
					System.out.println("ESTA SELECAO JA POSSUI TECNICO!");
				}
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("SELECAO NAO ENCONTRADA!");
		}
	}

}
