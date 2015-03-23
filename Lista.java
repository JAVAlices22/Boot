import java.util.*;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Lista implements Serializable {
	
	ArrayList <Hiperlink> lista = new ArrayList <Hiperlink>();
	
	private void addHiperlink(){
		Scanner x = new Scanner(System.in);
		String nome;
		String url;
		System.out.println("Digite o nome do hiperlink:");
		nome = x.nextLine();
		System.out.println("Digite a url do hiperlink:");
		url = x.nextLine();
		Hiperlink h = new Hiperlink(nome, url);
		lista.add(h);
	}
	
	private void removeHiperlink(){
		
	}
	
	private void editHiperlink(Hiperlink h){

	}
	
	private Hiperlink searchHiperlink(){
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
