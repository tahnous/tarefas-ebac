import java.util.*;
import java.text.*;

class Pessoa {
    String nome;
    String sexo;

    public Pessoa (String nome, String sexo) {
	this.nome = nome;
	this.sexo = sexo;
    }
    public String toString() {
	return this.nome + " " + this.sexo;
    }
}

public class TarefaColecoes2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	List<String> nomes = new ArrayList<String>();

	// Parte 1
	System.out.print("Digite lista de nomes separados por virgula: ");
	nomes = Arrays.asList(input.nextLine().split(","));
	Collections.sort(nomes,Collator.getInstance());
	System.out.println(nomes);

	// Parte 2
	List<Pessoa> pessoasF = new ArrayList<Pessoa>();
	List<Pessoa> pessoasM = new ArrayList<Pessoa>();
	System.out.print("Digite lista de pessoas no formato [nome - sexo,...] : ");
	for (String pessoa : input.nextLine().split(",")) {
	    String[]arrp =   pessoa.split("-");
	    String sexo = arrp[1].trim();
	    if (sexo.startsWith("f") || sexo.startsWith("F")) {
		pessoasF.add(new Pessoa (arrp[0],sexo));
	    }
	    else if (sexo.startsWith("m") || sexo.startsWith("M")) {
		pessoasM.add(new Pessoa (arrp[0],sexo));
	    }
	}
	System.out.println("Pessoas sexo feminino: "  + pessoasF);
	System.out.println("Pessoas sexo masculino: " + pessoasM);

    }
}
