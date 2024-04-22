import java.util.*;

public class Nota {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String msg  = "";
        float nota  = 0;
        float media = 0;

        for(int i=1; i<5; i++){
            System.out.print("Digite Nota " + i + ": ");
            nota += input.nextDouble();
        }
        media = nota/4;
        if (media < 5) {
            msg = "Reprovado";
        } else if (media  >= 5 && media < 7) {
            msg = "De recuperação";
        } else if (media  >= 7) {
            msg = "Aprovado";
        }
        System.out.println(msg);
    }
}
