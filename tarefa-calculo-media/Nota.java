import java.util.*;

public class Nota {
    double nota;

    public double getNota() {
	return nota;
    }

    public void setNota(double nota) {
	this.nota = nota;
    }

    public static void main(String[] args) {
	Nota n1 = new Nota();
	n1.setNota(10.0);
	Nota n2 = new Nota();
	n2.setNota(9.0);
	Nota n3 = new Nota();
	n3.setNota(5.0);
	Nota n4 = new Nota();
	n4.setNota(7.0);
	Nota media = new Nota();
	media.setNota((n1.getNota() + n2.getNota() + n3.getNota() + n4.getNota())/4);
	System.out.println(media.getNota());
    }
}
