package dao;
import syscopa.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

import Interface.ArbitroInterface;

public class ArbitroDAO implements ArbitroInterface{

	static Scanner scan = new Scanner(System.in);
	
	/**
	 * DADOS DE ARBITRO:
	 */
	private static ArrayList<Arbitro> listaArbitros = new ArrayList<Arbitro>();
	private static int codigo;
	
	/**
	 * METODO PARA INSERIR UM ARBITRO:
	 */
	public static void inserirArbitro() {
		System.out.println("NOME DO ARBITRO: ");
		System.out.flush();
		String nome = scan.next();
		listaArbitros.add(new Arbitro(nome, codigo++));	
	}

	/**
	 * METODO PARA EDITAR UM ARBITRO:
	 */
	public static void editarArbitro() {
		ArrayList<Arbitro> listaArbitros = new ArrayList<Arbitro>();
		boolean encontrado = false;
		
		System.out.println("DIGITE O CODIGO DO ARBITRO QUE DESEJA ATUALIZAR: ");
		System.out.flush();
		int codigo = scan.nextInt();
		System.out.println("----------------------------------------");
		ListIterator<Arbitro> l = listaArbitros.listIterator();
		
		while(l.hasNext()) {
			Arbitro e = l.next();
			if(e.getCodigo() == codigo) {
					System.out.print("DIGITE O NOME DO ARBITRO: ");
					String nome = scan.next();
					l.set(new Arbitro(nome, codigo));
					encontrado = true;
				}
			}
		if (!encontrado) {
			System.out.println("CODIGO DE ARBITRO NAO ENCONTRADO");
		}
		else
			System.out.println("ARBITRO ATUALIZADO");
		System.out.println("----------------------------------------");
	}
	
	/**
	 * METODO PARA EXCLUIR UM ARBITRO:
	 */
	public static void excluirArbitro() {
		
		ArrayList<Arbitro> listaArbitros = new ArrayList<Arbitro>();
		boolean encontrado = false;
		System.out.println("DIGITE O CODIGO DO ARBITRO QUE DESEJA REMOVER: ");
		System.out.flush();
		int codigo = scan.nextInt();
		System.out.println("----------------------------------------");
		Iterator<Arbitro> i = listaArbitros.iterator();
		while(i.hasNext()) {
			Arbitro e = i.next();
			if (e.getCodigo() == codigo) {
			i.remove();
			encontrado = true;
			}
		}
		if (!encontrado)
			System.out.println("CODIGO DE ARBITRO NAO ENCONTRADO");
		else
			System.out.println("ARBITRO REMOVIDO");
		System.out.println("----------------------------------------");		
	}

	/**
	 * METODO PARA LISTAR OS ARBITROS:
	 */
	public static void listarArbitro() {
		for (Arbitro objeto : listaArbitros) {
			System.out.println(objeto);
		}
	}

}