import java.util.Date;

public class Epi extends CategoriaEpi{

    public int ca;
    public Date validadeCa;


    public Epi(String categoria,int ca, Date validadeCa){

        this.ca = ca;
        this.validadeCa = validadeCa;
        super.categoria = categoria;

    }






}
