package aedTrabalho_n2;

import java.util.Iterator;
import myCollections.ArrayDeque;
public class Baralho {
    private ArrayDeque<Carta> conteudo;

    public Baralho(){
        conteudo = new ArrayDeque<>();
    } // fim de construtor
    
    public Baralho(int numeroDeCartas){
        conteudo = new ArrayDeque<>(numeroDeCartas);
    } // fim de construtor

    public ArrayDeque<Carta> getConteudo(){
        return conteudo;
    }
    
    public boolean nextBaralho(ArrayDeque<Carta> baralho){
        if(baralho.size() != conteudo.size())
            return false;
        Iterator<Carta> iter1 = baralho.iterator();
        Iterator<Carta> iter2 = conteudo.iterator();
        Carta c1 = null;
        Carta c2 = null;
        while(iter1.hasNext() != false && iter2.hasNext() != false){
            c1 = iter1.next();
            c2 = iter2.next();
            if(!c1.equals(c2))
                return false;
        }
        return true;
    }

    public void inShuffle(ArrayDeque<Carta> baralho){
        ArrayDeque<Carta> metadeSuperior = new ArrayDeque<>();
        ArrayDeque<Carta> metadeInferior = new ArrayDeque<>();
        
        System.out.println("IN-SHUFFLE");
        print("Baralho Original: ", baralho);
        while(baralho.isEmpty() != true){
            metadeSuperior.addLast(baralho.removeFirst());
            metadeInferior.addFirst(baralho.removeLast());
        }
        
        print("Metade Superior: ", metadeSuperior);
        print("Metade Inferior: ", metadeInferior);
        
        while(metadeSuperior.isEmpty() != true && metadeInferior.isEmpty() != true){
            baralho.addLast(metadeInferior.removeFirst());
            baralho.addLast(metadeSuperior.removeFirst());            
        }
        
        print("Baralhado: ", baralho);     
        System.out.println("");
    } // fim de inShuffle
    
    public void outShuffle(ArrayDeque<Carta> baralho){
        ArrayDeque<Carta> metadeSuperior = new ArrayDeque<>();
        ArrayDeque<Carta> metadeInferior = new ArrayDeque<>();
        
        System.out.println("OUT-SHUFFLE");
        print("Baralho Original: ", baralho);
        while(baralho.isEmpty() != true){
            metadeSuperior.addLast(baralho.removeFirst());
            metadeInferior.addFirst(baralho.removeLast());
        }
        
        print("Metade Superior: ", metadeSuperior);
        print("Metade Inferior: ", metadeInferior);
        
        while(metadeSuperior.isEmpty() != true && metadeInferior.isEmpty() != true){
            baralho.addLast(metadeSuperior.removeFirst());
            baralho.addLast(metadeInferior.removeFirst());
        }
        
        print("Baralhado: ", baralho);
        System.out.println("");
    } // fim de outShuffle
    
    public void moveTopo(int posicao, boolean messagens, ArrayDeque<Carta> baralho){
        String numBin = binario(posicao);
        
        if(messagens){
            System.out.println("MOVENDO " + posicao + " POSIÇÕES");
            print("Baralho Original: ", baralho);
            System.out.println(posicao + " equivale a " + numBin + " em binario\n");           
        }

        for(int i = 0; i < numBin.length(); i++){
            if(numBin.charAt(i) == '1')
                inShuffle(baralho);
            else
                outShuffle(baralho);
        }
        
        if(messagens){
            print("Depos de movido: ", baralho);
            System.out.println("Feito.");           
        }
    } // fim de moveTopo
    
    private void print(String texto, ArrayDeque<Carta> baralho){
        System.out.print(texto);
        for (Carta carta : baralho) {
            System.out.print(carta);
        }
        System.out.println("");
    }
    
    private String binario(int numero) {
        int d = numero;
        StringBuffer binario = new StringBuffer();
        while (d > 0) {
                int b = d % 2;
                binario.append(b);
                d = d >> 1; 
        }
        return binario.reverse().toString();
    }

} // fim de Baralho
