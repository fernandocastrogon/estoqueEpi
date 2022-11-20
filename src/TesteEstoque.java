import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TesteEstoque {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        List<Epi> epis = new ArrayList<Epi>();


        Epi capacete = new Epi("Proteção para a cabeça", 465,"Capacete MSA Verde", 1,new java.util.Date());
        epis.add(capacete);
        Epi sapato = new Epi("Proteção para os pés", 42239,"Sapato com biqueira PVC Bracol", 2,new Date(20/11/2025));
        epis.add(sapato);



        System.out.println("Digite o CA do EPI que deseja buscar: ");
        int ca = leitor.nextInt();
        //String buscaCa = String.valueOf(ca);
        int posicao = -1;
        for(int i = 0; i < epis.size(); i++){
            if (epis.get(i).getCa() == ca){
                posicao = i;
            }
        }

        Epi ItemPesquisado = epis.get(posicao);

        System.out.println(ItemPesquisado);




    }



}
