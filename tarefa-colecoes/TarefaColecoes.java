import java.util.*;

class Pessoa implements Comparable<Pessoa> {
    String nome;
    String sexo;

    public Pessoa (String nome, String sexo) {
	this.nome = nome;
	this.sexo = sexo;
    }
    public String getNome() {
	return nome;
    }
    public String getSexo() {
	return sexo;
    }

    public String toString() {
	return this.nome + " " + this.sexo;
    }
    public int compareTo(Pessoa pessoa) {
	return this.sexo.compareTo(pessoa.getSexo());
    }
}

public class TarefaColecoes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	List<String> nomes = new ArrayList<String>();

	// Parte 1
	System.out.print("Digite lista de nomes separados por virgula: ");
	nomes = Arrays.asList(input.nextLine().split(","));
	Collections.sort(nomes);
	System.out.println(nomes);

	// Parte 2
	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	System.out.print("Digite lista de pessoas no formato [nome - sexo,...] : ");
	for (String p : input.nextLine().split(",")) {
	    String[]arrp =   p.split("-");
	    pessoas.add(new Pessoa (arrp[0],arrp[1]));
	}
	Collections.sort(pessoas);
	System.out.println(pessoas);
    }
}
