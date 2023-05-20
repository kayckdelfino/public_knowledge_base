/*
[ ] Crie uma classe Carro que tenha como atributos a placa, marca e modelo, todos literais. Crie ainda um método acelerar que mostre uma mensagem no console e retorne void.
[ ] Crie uma classe de testes que, via Java Reflection, crie uma instância de Carro, atribua valores aos seus atributos (via reflection) e os mostre no console depois disso. Chame ainda o método acelerar (via reflection).
*/

package ExReflection.Ex01;

import java.lang.reflect.*;

public class Teste {
    public static void main(String[] args) {
        try {
            Object o = Class.forName("ExReflection.Ex01.Carro").getDeclaredConstructor().newInstance();
            System.out.println("\nAtributos:------------");
            for(Field f : o.getClass().getDeclaredFields()){
                System.out.println(f.getName());
            }
            System.out.println("\nMétodos:--------------");
            for(Method m : o.getClass().getDeclaredMethods()){
                System.out.println(m.getName());
            }
            System.out.println("\nInvoke:---------------");
            Method acelerar = Class.forName("ExReflection.Ex01.Carro").getDeclaredMethod("acelerar", int.class);
            acelerar.invoke(o, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}