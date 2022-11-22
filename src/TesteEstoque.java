import java.time.LocalDate;
import java.util.*;

public class TesteEstoque {

    public static void main(String[] args) {


        Scanner leitor = new Scanner(System.in);
        //Criando ArrayList para estoque de EPIs
        List<Epi> epis = new ArrayList<>();


        //Cadastrando EPIs
        Epi capacete = new Epi("Proteção para a cabeça", 465, "Capacete MSA Verde", 1, LocalDate.of(2024, 10, 29));
        epis.add(capacete);
        Epi sapato = new Epi("Proteção para os pés", 42239, "Sapato com biqueira PVC Bracol", 2, LocalDate.of(2023, 10, 30));
        epis.add(sapato);
        Epi luva = new Epi("Proteção para as maos", 34474, "Luva pigmentada", 1, LocalDate.of(2024, 6, 20));
        epis.add(luva);


        // Buscando EPI por C.A.
        System.out.println("Digite o CA do EPI que deseja buscar: ");
        int ca = leitor.nextInt();
        //String buscaCa = String.valueOf(ca);
        int posicao = -1;
        for (int i = 0; i < epis.size(); i++) {
            if (epis.get(i).getCa() == ca) {
                posicao = i;
            }
        }
        System.out.println(epis.get(posicao));


        //Comando de ordenação natural
        System.out.println("----Lista ordenada pelo C.A----");
        Collections.sort(epis);
        System.out.println(epis);

        //Comando de ordenacao atraves da validade do CA
        System.out.println("----Lista ordenada pela validade do CA----");
        epis.sort(new ValidadeCaComparator());
        System.out.println(epis);

    }
}

    class ValidadeCaComparator implements Comparator<Epi> {
        //Ordenando Lista pela data.
        @Override
        public int compare(Epi ca1, Epi ca2) {

            return ca1.getValidadeCa().compareTo(ca2.getValidadeCa());

        }
    }

