import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;
import java.util.List;


public class TesteEstoqueEPI {


    public static void main(String[] args) throws IOException {

        //new Menu();

        Scanner leitorTeclado = new Scanner(System.in);
        //Criando ArrayList para estoque de EPIs
        List<Epi> epis = new ArrayList<>();


        Scanner leitorArquivo = new Scanner(new File("epis.csv"));
        while(leitorArquivo.hasNextLine()){
            String linha = leitorArquivo.nextLine();
            System.out.println(linha);

            //Criando scanner e definindo metodo de separacao
            Scanner linhaScanner = new Scanner(linha);
            linhaScanner.useLocale(Locale.US);
            linhaScanner.useDelimiter(",");

            //Lendo dados da linha do arquivo epis.csv para criacao de novo Epi
            String categoria = linhaScanner.next();
            int ca = linhaScanner.nextInt();
            String descricao = linhaScanner.next();
            int quantidadeInicial = linhaScanner.nextInt();
            int ano = linhaScanner.nextInt();
            int mes = linhaScanner.nextInt();
            int dia = linhaScanner.nextInt();
            epis.add(new Epi(categoria,ca,descricao,quantidadeInicial,LocalDate.of(ano,mes,dia)));
            System.out.println(epis);
            linhaScanner.close();
//            String[] valores = linha.split(",");
//            System.out.println(valores[0]);
        }
        leitorArquivo.close();




        //Cadastrando EPIs
        Epi capacete = new Epi("Proteção para a cabeça", 465, "Capacete MSA Verde", 1, LocalDate.of(2024, 10, 29));
        epis.add(capacete);
        Epi sapato = new Epi("Proteção para os pés", 42239, "Sapato com biqueira PVC Bracol", 2, LocalDate.of(2023, 10, 30));
        epis.add(sapato);
        Epi luva = new Epi("Proteção para as maos", 34474, "Luva pigmentada", 1, LocalDate.of(2024, 6, 20));
        epis.add(luva);

        //Cadastrando EPIs em um arquivo .txt
        PrintWriter pw = new PrintWriter("listaEpis.txt");
        //Loop para gravação dos Epis na listaEpis.txt
        epis.forEach(pw::println);
        pw.close();



        // Buscando EPI por C.A.
        System.out.println("Digite o CA do EPI que deseja buscar: ");
        int ca = leitorTeclado.nextInt();
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

        //Ordenando Lista pela data através de lambda
        epis.sort((Epi ca1, Epi ca2) -> ca1.getValidadeCa().compareTo(ca2.getValidadeCa()));

        //Ordenando Lista pela data através do metodo comparing da interface Comparator
        //epis.sort(Comparator.comparing(Epi::getValidadeCa));

        //Imprimindo lista através de lambda
        epis.forEach((Epi) -> System.out.println(Epi.getValidadeCa()));

        leitorTeclado.close();





    }
}


