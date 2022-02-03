package aedTrabalho_n2;

import myCollections.ArrayDeque;

public class Main {
        
        public static void main(String[] args) {
        Baralho baralho = new Baralho(52);
        int i;
        for(i = 1; i <= 6; i++)
            baralho.getConteudo().addLast(new Carta(Naipe.PAUS, i));
        
        
        ArrayDeque<Carta> cartas = new ArrayDeque<>();
        
        baralhoOriginal(cartas, baralho.getConteudo());      
        System.out.println("---Testar In-Shuffle---");
        baralho.inShuffle(cartas);
        
        
        baralhoOriginal(cartas, baralho.getConteudo());
        System.out.println("---Testar Out-Shuffle---");
        baralho.outShuffle(cartas);
        
        
        baralhoOriginal(cartas, baralho.getConteudo());
        //inShuffle
        i = 0;
        System.out.println("---Testar Numero de In-Shuffles ate obter o Baralho Original---");
        do{
            System.out.println("--embaralhar #" + (i+1) + "--");
            baralho.inShuffle(cartas);
            i++;
        }while(baralho.nextBaralho(cartas) != true);
        
        System.out.println("Foi necessario " + i + " in-shuffles para voltar as " + cartas.size() + " cartas do baralho original!\n");
        
        //outShuffle
        i = 0;
        System.out.println("---Testar Numero de Out-Shuffles ate obter o Baralho Original---");
        do{
            System.out.println("--embaralhar #" + (i+1) + "--");
            baralho.outShuffle(cartas);
            i++;
        }while(baralho.nextBaralho(cartas) != true);
        
        System.out.println("Foi necessario " + i + " Out-shuffles para voltar as " + cartas.size() + " cartas do baralho original!\n");
        
          
        //Mover as cartas 
        System.out.println("---Testar Mover as 3 Cartas de Topo---");
        baralho.moveTopo(3, true, cartas);
        
    }
    
    public static void baralhoOriginal(ArrayDeque<Carta> cartas, ArrayDeque<Carta> baralho){
        if(cartas.size() != 0)
            while(cartas.size() != 0)
                cartas.removeLast();

        for (Carta carta : baralho) {
            cartas.addLast(carta);
        }
    }
    
}
