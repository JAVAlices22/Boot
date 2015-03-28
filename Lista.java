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
	
	private void viewHiperlink(int position){
		
		lista.get(position).getName();
		lista.get(position).getUrl();
		lista.get(position).getComment();
		lista.get(position).getMetatags();
		lista.get(position).getCreationDate();
		lista.get(position).getModificationDate();
	}
	
	private void removeHiperlink(){
		lista.remove(this.searchHiperlink());
	}
	
	private int searchHiperlink(){
		int size, msize, i, k, opt;
		String n;
		String[] meta;
		Hiperlink[] search;
		Scanner x = new Scanner(System.in);
		Scanner y = new Scanner(System.in);
		
		search = new Hiperlink[1];
		meta = new String[1];
		size = lista.size();
		msize = 0;
		search = lista.toArray(search);
		
		System.out.println("Insira a opção de busca: 1)nome 2)url 3)metatag");
		opt = x.nextInt();
		
		switch(opt){
			case 1:
				System.out.println("Digite o nome:");
				n = y.nextLine();
				for(i=0; i <= size; i++){
					if(i == size){
						System.out.println("Não encontrado.");
						return -1;
					}
					else if(n.equals(search[i].name)){
						return i;
					}
				}
				break;
			
			case 2:
				System.out.println("Digite a url");
				n = y.nextLine();
				for(i=0; i <= size; i++){
					if(i == size){
						return -1;
					}
					else if(n.equals(search[i].url)){
						return i;
					}
				}
				break;
		
			case 3:
				System.out.println("Digite a metatag:");
				n = y.nextLine();
				for(i =0; i <= size; i++){
					if(i == size){
						System.out.println("Não encontrado.");
						return -1;
					}
					meta = search[i].metatags.toArray(meta);
					msize = search[i].metatags.size();
					for(k=0; k < msize; k++){
						if(n.equals(meta[k])){
							System.out.format("O hiperlink da posição %d possui a metag. Deseja continuar a busca? 1)sim 2)não\n", i);
							if(x.nextInt() == 2)
								return i;
						}
					}
				}
				break;
		}	
		return 0;
	}

	private void editHiperlink(int position){
		int opt, optm;
		boolean goon = false, goonm = false;
		Scanner x = new Scanner(System.in);
		do{
			System.out.println("Digite a opção que deseja editar: 1)nome 2)url 3)comentário 4)metatags");
			opt = x.nextInt();
			switch (opt){
				case 1:
					System.out.print("Nome atual: ");
					lista.get(position).getName();
					lista.get(position).editName();
					System.out.print("Novo nome: ");
					lista.get(position).getName();
					break;
				case 2:
					System.out.print("Url atual: ");
					lista.get(position).getUrl();
					lista.get(position).editUrl();
					System.out.print("Nova url: ");
					lista.get(position).getUrl();
					break;
				case 3:
					System.out.print("Comentário atual: ");
					lista.get(position).getComment();
					lista.get(position).editComment();
					System.out.print("Novos comentários: ");
					lista.get(position).getComment();
					break;
				case 4:

					do{
						System.out.print("Lista atual de metatags: ");
						lista.get(position).getMetatags();
						System.out.println("Digite o que deseja fazer: 1)adicionar 2)remover");
						optm = x.nextInt(); 
						if(optm == 1)
							lista.get(position).addMetatag();
						else if(optm == 2)
							lista.get(position).removeMetatag();
						System.out.println("Deseja continuar as edições de metatag? 1)sim 2)não");
						optm = x.nextInt();
						if(optm == 1)
							goonm = true;
						else if(optm == 2){
							System.out.print("Nova lista de metatags: ");
							lista.get(position).getMetatags();
							goonm = false;
						}
					}while(goonm);	
			}
			System.out.println("Deseja continuar as edições? 1)sim 2)não");
			opt = x.nextInt(); 
			if(opt == 1)
				goon = true;
			else if(opt == 2)
				goon = false;
		}while(goon);
	}
	
	Lista(){
		
	}

	
	
	
	public static void main(String[] args) {
		Lista L = new Lista();
		int escolha, flag;
		Scanner scan = new Scanner(System.in);
		for(;;)
		{
			System.out.println("O que deseja fazer?");
			System.out.println("1-add\n2-search\n3- view\n4-edit\n5-remove\n6-sair");
			escolha = scan.nextInt();
			switch (escolha)
			{
				case 1:
					L.addHiperlink();
					break;
				case 2:
					flag = L.searchHiperlink();
					if(flag != -1)
						System.out.format("O hiperlink encontra-se na posição %d da lista.\n", flag);
					break;
				case 3:
					L.viewHiperlink(L.searchHiperlink());
					break;
				case 4:
					L.editHiperlink(L.searchHiperlink());
					break;
				case 5:
					L.removeHiperlink();
					break;
			}
			if (escolha == 6) break; //sai do for
		}

	}

}
