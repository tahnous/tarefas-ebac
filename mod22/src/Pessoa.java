import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private String  sexo;

    public Pessoa(){

    }
    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List <Pessoa> popularPessoas() {
        Scanner input = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        System.out.print("Digite lista de pessoas no formato [nome - sexo,...] : ");
        for (String p : input.nextLine().split(",")) {
            String[]arrp = p.split("-");
            if (arrp.length == 2)
                pessoas.add(new Pessoa (arrp[0],arrp[1].replaceAll("\\s+","")));
        }
        return pessoas;
    }
}