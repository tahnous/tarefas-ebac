import java.util.List;
import java.util.stream.Stream;

public class Mod22 {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().popularPessoas();
        Stream<Pessoa> pessoaStream = lista.stream().filter(pessoa -> pessoa.getSexo().equalsIgnoreCase("FEMININO"));
    pessoaStream.forEach(pessoa -> System.out.println(pessoa.getNome()  + " " +  pessoa.getSexo() ));

    }
}
