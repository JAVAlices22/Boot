import java.util.*;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


//Os comandos do-while seguidos de try-catch destinam-se a impedir que o programa pare
//por causa de um input inesperado fornecido pelo usuário.
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
		int position;
		do{
			position = searchHiperlink();
		}while(position == -1);
		lista.remove(position);
		System.out.println("Removido com sucesso.");
	}
	
	private int searchHiperlink(){
		int size, msize, i, k, opt, ret = -1;
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
	
		do{
			opt = 0;
			try{
				System.out.println("Insira a opção de busca: 1)nome 2)url 3)metatag");
				opt = x.nextInt();
				if(opt < 1 || opt > 3)
					System.out.println("Opção inválida.");
			}
			catch(InputMismatchException e){
				System.out.println("Entrada inválida. Digite um número inteiro válido.");
				x.nextLine();
			}
		}while(opt < 1 || opt > 3);
		switch(opt){
			case 1:
				System.out.println("Digite o nome:");
				n = y.nextLine();
				for(i=0; i < size; i++){
					if(n.equals(search[i].name)){
						ret = i;
					}
				}
				break;
			
			case 2:
				System.out.println("Digite a url");
				n = y.nextLine();
				for(i=0; i < size; i++){
					if(n.equals(search[i].url)){
						ret =  i;
					}
				}
				break;
		
			case 3:
				int optm;
				System.out.println("Digite a metatag:");
				n = y.nextLine();
				for(i =0; i < size; i++){
					meta = search[i].metatags.toArray(meta);
					msize = search[i].metatags.size();
					for(k=0; k < msize; k++){
						if(n.equals(meta[k])){
							do{
								optm =0;
								try{
									System.out.format("O hiperlink da posição %d possui a metag. Deseja continuar a busca? 1)sim 2)não\n", i);
									optm = x.nextInt();
									if(optm == 2)
										ret = i;
									else if(optm != 1)
										System.out.println("Opção inválida.");
								}
								catch(InputMismatchException e){
									System.out.println("Entrada inválida. Digite um número inteiro válido.");
									x.nextLine();
								}
							}while(optm != 1 && opt != 2);
						}
					}
				}
				break;
		}
		if(ret == -1)
			System.out.println("Não encontrado.");
		return ret;
	}

	private void editHiperlink(int position){
		int opt, optm;
		boolean goon = false, goonm = false;
		Scanner x = new Scanner(System.in);
		do{
			do{
				opt = 0;
				try{
					System.out.println("Digite a opção que deseja editar: 1)nome 2)url 3)comentário 4)metatags");
					opt = x.nextInt();
					if(opt < 1 || opt > 4)
						System.out.println("Opção inválida.");
				}
				catch(InputMismatchException e){
					System.out.println("Entrada inválida. Digite um número inteiro válido.");
					x.nextLine();
				}
			}while(opt < 1 || opt > 4);
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
					do{
						System.out.print("Lista atual de comentários ");
						lista.get(position).getComment();
						do{
							optm = 0;
							try{
								System.out.println("Digite o que deseja fazer: 1)adicionar 2)remover");
								optm = x.nextInt(); 
								if(optm == 1)
									lista.get(position).addComment();
								else if(optm == 2)
									lista.get(position).removeComment();
								else
									System.out.println("Opção inválida.");
							}
							catch(InputMismatchException e){
								System.out.println("Entrada inválida. Digite um número inteiro válido.");
								x.nextLine();
							}
						}while(optm != 1 && optm != 2);
						do{
							try{
								System.out.println("Deseja continuar as edições de comentários? 1)sim 2)não");
								optm = x.nextInt();
								if(optm == 1)
									goonm = true;
								else if(optm == 2){
									System.out.print("Nova lista de comentários: ");
									lista.get(position).getComment();
									goonm = false;
								}
								else
									System.out.println("Opção inválida.");
							}
							catch(InputMismatchException e){
								System.out.println("Entrada inválida. Digite um número inteiro válido.");
								x.nextLine();
							}
						}while(optm != 1 && optm != 2);
					}while(goonm);
					break;
				case 4:
					do{
						System.out.print("Lista atual de metatags: ");
						lista.get(position).getMetatags();
						do{
							optm = 0;
							try{
								System.out.println("Digite o que deseja fazer: 1)adicionar 2)remover");
								optm = x.nextInt(); 
								if(optm == 1)
									lista.get(position).addMetatag();
								else if(optm == 2)
									lista.get(position).removeMetatag();
								else
									System.out.println("Opção inválida.");
							}
							catch(InputMismatchException e){
								System.out.println("Entrada inválida. Digite um número inteiro válido.");
								x.nextLine();
							}
						}while(optm != 1 && optm != 2);
						do{
							try{
								System.out.println("Deseja continuar as edições de metatag? 1)sim 2)não");
								optm = x.nextInt();
								if(optm == 1)
									goonm = true;
								else if(optm == 2){
									System.out.print("Nova lista de metatags: ");
									lista.get(position).getMetatags();
									goonm = false;
								}
								else
									System.out.println("Opção inválida.");
							}
							catch(InputMismatchException e){
								System.out.println("Entrada inválida. Digite um número inteiro válido.");
								x.nextLine();
							}
						}while(optm != 1 && optm != 2);
					}while(goonm);	
					break;
			}
			do{
				try{
					System.out.println("Deseja continuar as edições? 1)sim 2)não");
					opt = x.nextInt(); 
					if(opt == 1)
						goon = true;
					else if(opt == 2)
						goon = false;
					else
						System.out.println("Opção inválida.");
				}
				catch(InputMismatchException e){
					System.out.println("Entrada inválida. Digite um número inteiro válido.");
					x.nextLine();
				}
			}while(opt != 1 && opt != 2);
		}while(goon);
	}
	
    private void Save(Lista L){
        try{
        	FileOutputStream arquivoGrav = new FileOutputStream("lista.dat"); //gera arquivo para armazenar objeto
        	ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav); //classe responsável por inserir os objetos
            objGravar.writeObject(L); //grava o objeto L no arquivo
            objGravar.flush();
            objGravar.close();
            arquivoGrav.flush();
            arquivoGrav.close();
        	System.out.println("Foi salvo com sucesso.");
   }catch(Exception ex){
	   ex.printStackTrace();
        }
    }
		
	Lista(){	
	}

	public static void main(String[] args) {
		Lista L = new Lista();
		try{ //Carrega o arquivo, se existir.
			FileInputStream arquivoLeitura = new FileInputStream("lista.dat"); //carrega o arquivo
			ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura); //classe responsável por recuperar os objetos no arquivo
			L = (Lista)objLeitura.readObject(); //lê o objeto L do arquivo
		    objLeitura.close();
	        arquivoLeitura.close();
		}catch(Exception ex){
		   System.out.println("Arquivo não encontrado");
		} 
		int escolha, position;
		Scanner scan = new Scanner(System.in);
		for(;;){ //Inicia a interface com o usuário.
			do{
				escolha =0;
				try{
					System.out.println("O que deseja fazer?");
					System.out.println("1-Adicionar\n2-Buscar\n3-Checar\n4-Editar\n5-Remover Hiperlink\n6-Salvar\n7-Sair e salvar\n8-Sair");
					escolha = scan.nextInt();
					if(escolha < 1 || escolha > 8)
						System.out.println("Opção inválida.");
				}
				catch(InputMismatchException e){
					System.out.println("Entrada inválida. Digite um número inteiro válido.");
					scan.nextLine();
				}
			}while(escolha < 1 || escolha > 8);
			switch (escolha)
			{
				case 1:
					L.addHiperlink();
					break;
				case 2:
					position = L.searchHiperlink();
					if(position != -1)
						System.out.format("O hiperlink encontra-se na posição %d da lista.\n", position);
					break;
				case 3:
					do{
						position = L.searchHiperlink();
					}while(position == -1);
					L.viewHiperlink(position);
					break;
				case 4:
					do{
						position = L.searchHiperlink();
					}while(position == -1);
					L.editHiperlink(position);
					break;
				case 5:
					L.removeHiperlink();
					break;
                case 6:
                    L.Save(L);
                    break;
			}
			if (escolha == 7){
				L.Save(L);
				break; //salva o arquivo e sai do for
			}
			else if(escolha == 8) //sai do for
				break;
		}

	}

}
