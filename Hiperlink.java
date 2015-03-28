import java.util.*;
import java.io.*;

public class Hiperlink {
	String name;
	String url;
	String comment;
	Date creationDate;
	Date modificationDate;
	ArrayList <String> metatags;
	
	public void editName(){
		Scanner x = new Scanner(System.in);
		System.out.println("Digite o nome do Hiperlink: ");	
		this.name = x.nextLine();
		this.modificationDate = new Date();
	}

	public void getName(){
		System.out.println(this.name);
	}

	public void editUrl(){
		Scanner x = new Scanner(System.in);
		System.out.println("Digite a url do Hiperlink: ");	
		this.url =  x.nextLine();
		this.modificationDate = new Date();
	}
	
	public void getUrl(){
		System.out.println(this.url);
	}
	
	public void editComment(){
		Scanner x = new Scanner(System.in);
		System.out.println("Digite um comentario a respeito do Hiperlink: ");	
		this.comment =  x.nextLine();
		this.modificationDate = new Date();
	}
	
	public void getComment(){
		System.out.println(this.comment);
	}
	
	public void addMetatag(){
		Scanner x = new Scanner(System.in);
		System.out.println("Digite a metatag a ser adicionada: ");
		this.metatags.add(x.nextLine());
		this.modificationDate = new Date();
	}
	
	public void removeMetatag(){
		Scanner x = new Scanner(System.in);
		System.out.println("Digite a metatag a ser removida: ");
		this.metatags.remove(x.nextLine());
		this.modificationDate = new Date();
	}
	
	public void getMetatags(){
		System.out.println(Arrays.toString(this.metatags.toArray()));
	}
	
	public void getCreationDate(){
		System.out.println(this.creationDate.toString());
	}
	
	public void getModificationDate(){
		System.out.println(this.modificationDate.toString());
	}
	
	Hiperlink(String newName, String newUrl){
		name = newName;
		url = newUrl;
		creationDate = new Date();
		metatags = new ArrayList <String>();
		modificationDate = creationDate;
	}
	
	public static void main(String[] args) {
		Hiperlink h = new Hiperlink("teste", "teste");
		int opt;
		Scanner x = new Scanner(System.in);
		for(;;){
			System.out.println("O que deseja fazer? 1.editName 2.getName 3.editUrl 4.getUrl 5.editComment 6.getComment 7.addMetatags 8.removeMetatags 9.getMetatags 10.getCreationDate 11.getModificationDate");
			opt = x.nextInt();
			if(opt == 1)
				h.editName();
			else if(opt == 2)
				h.getName();
			else if(opt == 3)
				h.editUrl();
			else if(opt == 4)
				h.getUrl();
			else if(opt == 5)
				h.editComment();
			else if(opt == 6)
				h.getComment();
			else if(opt ==7)
				h.addMetatag();
			else if(opt == 8)
				h.removeMetatag();
			else if(opt == 9)
				h.getMetatags();
			else if(opt == 10)
				h.getCreationDate();
			else if(opt == 11)
				h.getModificationDate();
		}
	}
}
