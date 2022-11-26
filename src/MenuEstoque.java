import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

import static java.lang.System.exit;

public class MenuEstoque {





    public MenuEstoque(){
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("ERRO");
        }
    }

    public static void printMenu(String[] opcoes) {
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }
        System.out.print("Escolha sua opcao : ");
    }


    private static String[] opcoes = {
            "",
            "Seja bem vindo ao controle de estoque EPI ",
            "1 - Cadastrar EPI no array",
            "2 - Cadastrar EPI no arquivo.csv",
            "3 - Buscar EPI por C.A. e imprimir",
            "4 - Ler arquivo.csv e criar estoque",
            "8 - Sair",
    };


    public static void main(String[] args) throws FileNotFoundException {
        Scanner leitor = new Scanner(System.in);


        List<Epi> epis = new ArrayList<>();


        int opcao = 0;
        while (opcao != 8) {
            printMenu(opcoes);
            try {
                opcao = leitor.nextInt();

                switch (opcao) {
                    case 1 -> {
                        //Cadastro CA no array
                        System.out.println("Digite a categoria do EPI");
                        String categoria = leitor.next();

                        System.out.println("Digite o C.A. do EPI");
                        int ca = leitor.nextInt();

                        System.out.println("Digite a descrição do EPI");
                        String descricao = leitor.next();

                        System.out.println("Digite a quantidade inicial em estoque");
                        int quantidadeInicial = leitor.nextInt();

                        System.out.println("Digite o ano da validade do C.A. ");
                        int ano = leitor.nextInt();
                        System.out.println("Digite o mes da validade do C.A. ");
                        int mes = leitor.nextInt();
                        System.out.println("Digite o dia da validade do C.A. ");
                        int dia = leitor.nextInt();

                        epis.add(new Epi(categoria,ca,descricao,quantidadeInicial,LocalDate.of(ano,mes,dia)));

                    }
                    case 2 -> {
                        PrintWriter pw = new PrintWriter("epis.csv");
                        System.out.println(epis);
                        epis.forEach(pw::println);
                        pw.close();


                    }
                    case 3 -> {
                       //Buscando EPI por C.A. e imprimi na tela
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
                    }
                    case 4 -> {
                        System.out.println(epis);
                        Scanner leitorArquivo = new Scanner(new File("epis.csv"));
                        while(leitorArquivo.hasNextLine()){
                            String linha = leitorArquivo.nextLine();
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
                            linhaScanner.close();
                            System.out.println(epis);
                        }
                        leitorArquivo.close();


                    }
                    case 8 -> {
                        exit(0);

                    }
                }
            } catch (InputMismatchException ex) {
                clearConsole();
                System.out.println("Por favor entre com um numero entre 1 e " + opcoes.length);
                leitor.next();
            }




        }


    }


}
