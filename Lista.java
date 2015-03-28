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
		int escolha;
		Scanner scan = new Scanner(System.in);
		for(;;)
		{
			System.out.println("O que deseja fazer?");
			System.out.println("1-asoidaos\n2-adaosdjaos\n3dasojdaosjd...")
			escolha = scan.nextInt();
			switch (escolha)
			{
				case 1:
					//chama o metodo
					break;
				case 2:
					
					break;
				
			}
			if (escolha == x) break; //sai do for
		}

	}

}
