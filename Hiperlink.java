import java.util.*;
import java.io.*;

public class Hiperlink implements Serializable{
	String name;
	String url;
	ArrayList <String> comment;
	Date creationDate;
	Date modificationDate;
	ArrayList <String> metatags;
	
	public void editName(){
		Scanner x = new Scanner(System.in);
		System.out.println("Digite o novo nome do Hiperlink: ");	
		name = x.nextLine();
		modificationDate = new Date();
	}

	public void getName(){
		System.out.println(name);
	}

	public void editUrl(){
		Scanner x = new Scanner(System.in);
		System.out.println("Digite a nova url do Hiperlink: ");	
		url =  x.nextLine();
		modificationDate = new Date();
	}
	
	public void getUrl(){
		System.out.println(url);
	}
	
	public void addComment(){
		Scanner x = new Scanner(System.in);
		System.out.println("Digite o comentário a ser adicionado: ");
		comment.add(x.nextLine());
		modificationDate = new Date();
	}
	
	public void getComment(){
		System.out.println(Arrays.toString(comment.toArray()));
	}
	
	public void removeComment(){
		int index;
		Scanner x = new Scanner(System.in);
		System.out.println("O hiperlink possui a seguinte lista de comentários: ");
		getComment();
		do{
			System.out.println("Digite o índice do comentário a ser removido (a contagem começa de 0):");
			index = x.nextInt();
			if(0 <= index && index <= comment.size())
				comment.remove(index);
			else
				System.out.println("Índice inválio.");
		}while(0 > index || index > comment.size());
		modificationDate = new Date();
	}
		
	public void addMetatag(){
		Scanner x = new Scanner(System.in);
		System.out.println("Digite a metatag a ser adicionada: ");
		metatags.add(x.nextLine());
		modificationDate = new Date();
	}
	
	public void getMetatags(){
		System.out.println(Arrays.toString(metatags.toArray()));
	}
	
	public void removeMetatag(){
		int index;
		Scanner x = new Scanner(System.in);
		System.out.println("O hiperlink possui a seguinte lista de metatags: ");
		getComment();
		do{
			System.out.println("Digite o índice do comentário a ser removido (a contagem começa de 0):");
			index = x.nextInt();
			if(0 <= index && index <= metatags.size())
				metatags.remove(index);
			else
				System.out.println("Índice inválio.");
		}while(0 > index || index > metatags.size());
		modificationDate = new Date();
	}
	
	public void getCreationDate(){
		System.out.println(creationDate.toString());
	}
	
	public void getModificationDate(){
		System.out.println(modificationDate.toString());
	}
	
	Hiperlink(){
		creationDate = new Date();
		comment = new ArrayList<String>();
		metatags = new ArrayList <String>();
		modificationDate = creationDate;
	}
	
	Hiperlink(String newName, String newUrl){
		name = newName;
		url = newUrl;
		creationDate = new Date();
		comment = new ArrayList<String>();
		metatags = new ArrayList <String>();
		modificationDate = creationDate;
	}

}
