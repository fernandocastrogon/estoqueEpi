import javax.swing.*;


public class Menu extends JFrame {

    JMenuBar barra = new JMenuBar();
    JMenu menu1 = new JMenu("Opcoes");
    JMenu menu2 = new JMenu("Sair");

    JMenuItem item1 = new JMenuItem("Exit");


    public Menu(){

        setJMenuBar(barra);
        barra.add(menu1);
        barra.add(menu2);
        menu2.add(item1);
        item1.addActionListener(e -> System.exit(0));
        setTitle("Controle de Estoque de EPI");
        setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }
}