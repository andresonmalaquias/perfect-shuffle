package aedTrabalho_n2;

public class Carta {
    private Naipe naipe; // naipe da carta
    private int valor = 0; // o valor da carta
    
    public Carta(Naipe n, int v){
        setNaipe(n);
        setValor(v);
    } // fim de construtor
    
    // Definir o naipe da carta.
    private void setNaipe(Naipe oNaipe){
        naipe = oNaipe; 
    }

    /** Devolve o naipe da carta como uma constante do enumerador Naipe.
    @return O naipe da carta. */
    public Naipe getNaipe(){
        return naipe; 
    }
    
     // Define o valor / número da carta.
    private void setValor (int oValor){
        valor = oValor; 
    }

    /** Devolve o valor da carta como inteiro.
    @return o valor da carta. */
    public int getValor(){
        return valor; 
    }
    
    public String toString(){
        char naipeCar = ' '; // Versão com caracter para o naipe

        switch (naipe) {
            case ESPADAS:
            naipeCar = 'E';
            break;
            case PAUS:
            naipeCar = 'P';
            break;
            case COPAS:
            naipeCar = 'C';
            break;
            case OUROS:
            naipeCar = 'O';
            break;
        } // end switch

        String valorString = "" + valor;

        return "[" + naipeCar + " " + valorString + "]";
    }
} // fim de Carta