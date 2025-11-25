import br.com.tahnous.anotacao.Tabela;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    @Tabela (nome="test1")
    public static void testAnnotation()
    {
        Main obj = new Main();

        try {
            Class<?> c = obj.getClass();

            // Obtain the annotation for newMethod
            Method m = c.getMethod("testAnnotation");

            // Display the repeated annotation
            Annotation anno
                    = m.getAnnotation(Tabela.class);
            System.out.println(anno);
        }
        catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }
    public static void imprimeAnnotation() {
        Main obj = new Main();

        for (Method method : obj.getClass().getMethods()) {

            if (method.isAnnotationPresent(Tabela.class)) {
                Tabela nome = method.getAnnotation(Tabela.class);
                System.out.println("Nome da anotação:" + nome.toString());
                System.out.println("Valor da  anotação: " + nome.nome());

            }
        }
    }
    public static void main(String[] args) {
        // testAnnotation();
        imprimeAnnotation();
    }

}