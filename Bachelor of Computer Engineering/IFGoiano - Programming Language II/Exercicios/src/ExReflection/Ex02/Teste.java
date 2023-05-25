/* 
[ ]Crie uma classe Aluno, com os atributos (privados) nome, código (literal), telefone e endereço, ano de nascimento (inteiro) e online (booleano). Encapsule os métodos e implemente ainda o método toString.
[ ] Crie uma classe de testes e nela crie uma instância de Aluno usando reflection. Implemente ainda o código para atribuir valores (arbitrários) aos campos desse objeto usando reflection e os mostre no console, também usando reflection.
[ ] Crie uma segunda instância de Aluno, coloque os mesmos valores nos atributos e compare a igualdade dessas duas instâcias usando reflection.
*/

package ExReflection.Ex02;

import java.lang.reflect.*;

public class Teste {
    public static void main(String[] args) {
        try {
            //Recuperando classe
            Class<?> cl = Class.forName("ExReflection.Ex02.Aluno");

            //Listando atributos da classe
            System.out.println("\nAtributos:------------");
            for(Field f : cl.getDeclaredFields()){
                System.out.println(f.getName());
            }

            //Listando métodos da classe
            System.out.println("\nMétodos:--------------");
            for(Method m : cl.getDeclaredMethods()){
                System.out.println(m.getName());
            }

            //Listando construtores da classe
            System.out.println("\nConstrutores:---------");
            int contador = 1;
            for(Constructor<?> c : cl.getDeclaredConstructors()){
                System.out.println("Parâmetros do construtor: " + contador);
                for(Class<?> parametros : c.getParameterTypes()){
                    System.out.println(parametros);
                }
                contador++;
            }

            //Recuperando construtor completo da classe
            Constructor<?> cons = cl.getConstructor(String.class, String.class, String.class, String.class, int.class, boolean.class);

            //Recuperando set's dos atributos da classe
            Method setNome = Class.forName("ExReflection.Ex02.Aluno").getDeclaredMethod("setNome", String.class);
            Method setCodigo = Class.forName("ExReflection.Ex02.Aluno").getDeclaredMethod("setCodigo", String.class);
            Method setTelefone = Class.forName("ExReflection.Ex02.Aluno").getDeclaredMethod("setTelefone", String.class);
            Method setEndereco = Class.forName("ExReflection.Ex02.Aluno").getDeclaredMethod("setEndereco", String.class);
            Method setAno_nascimento = Class.forName("ExReflection.Ex02.Aluno").getDeclaredMethod("setAno_nascimento", int.class);
            Method setOnline = Class.forName("ExReflection.Ex02.Aluno").getDeclaredMethod("setOnline", boolean.class);

            //Criando objetos com todos os atributos da classe
            Object o1 = cons.newInstance("Kayck", "1234", "912345678", "Rua 01", 2000, true);

            //Criando objetos "vazios" pelo construtor vazio (forma reduzida)
            Object o2 = Class.forName("ExReflection.Ex02.Aluno").getDeclaredConstructor().newInstance();
            Object o3 = Class.forName("ExReflection.Ex02.Aluno").getDeclaredConstructor().newInstance();

            //Usando os métodos set's obtidos
            //Objeto o2
            setNome.invoke(o2, "Kayck");
            setCodigo.invoke(o2, "1234");
            setTelefone.invoke(o2, "912345678");
            setEndereco.invoke(o2, "Rua 01");
            setAno_nascimento.invoke(o2, 2000);
            setOnline.invoke(o2, true);
            //Objeto o3
            setNome.invoke(o3, "Kayck");
            setCodigo.invoke(o3, "1234");
            setTelefone.invoke(o3, "912345678");
            setEndereco.invoke(o3, "Rua 01");
            setAno_nascimento.invoke(o3, 2000);
            setOnline.invoke(o3, true);

            //Recuperando toString
            Method toString = cl.getDeclaredMethod("toString");

            //Listando os objetos
            System.out.println("\n" + toString.invoke(o1));
            System.out.println(toString.invoke(o2));
            System.out.println(toString.invoke(o3));

            //Comparando os objetos (equals)
            System.out.println("\n" + o1.equals(o2));    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}