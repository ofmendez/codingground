import java.util.Scanner;
import java.util.ArrayDeque;

public class JavaApplication5{
    
    
    static class Proceso{
        int prioridad;
        int indice;
        
        public Proceso(int prioridad, int indice){
            this.indice = indice;
            this.prioridad = prioridad;
        }
    }
    
    public static boolean buscar_mayor_prioridad(int _k, ArrayDeque<Proceso> _lista){
        boolean movido =false;
        for (Proceso pi : _lista ) {

            if( pi.prioridad > _k ){
                movido = true;
                _lista.addLast(_lista.removeFirst());
                break;
            }
        }      
        return movido;
    }

    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        ArrayDeque<Proceso> pry = new ArrayDeque<>();

        int prioridad = 0;
        for(int i = 0; i < n; i++){
            prioridad = scan.nextInt();
            pry.add(new Proceso(prioridad, i));
        }
        
        
        int impresiones = 0;
        int k =0;

        while( !pry.isEmpty() ){

            k = pry.getFirst().prioridad;
           
            if (! buscar_mayor_prioridad(k,pry) ){
                impresiones +=1;
                if (pry.getFirst().indice == m) {
                    break;
                }
                pry.remove();
           }
       }

        System.out.println(impresiones);
    }
}