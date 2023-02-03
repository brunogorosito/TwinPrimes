package unrn.edu.ar;

import unrn.edu.ar.model.TwinPrime;

import java.util.*;

class TwinPrimesToN {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bienvenidos al programa de números primos gemelos!");
            System.out.println("A continuación ingrese el límite superior e inferior para realizar el cálculo de los números primos gemelos contenidos en el entorno.");
            Scanner lectura = new Scanner (System.in);
            System.out.println("Límite inferior (X>1):");
            int inferior = Integer.parseInt(lectura.next());;
            System.out.println("Límite superior:");
            int superior = Integer.parseInt(lectura.next());;
            printTwinPrime(inferior, superior);
            System.out.print("\n"+"--------------------------------------------------------------------------------------------------------------------------------------"+"\n");
        }
    }

    static void printTwinPrime(int inf, int n){

        Map<Integer, TwinPrime> map = new HashMap<Integer, TwinPrime>();
        boolean prime[] = new boolean[n + 1];
        TwinPrime twinPrime = null;
        int aux = 1;

        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        for (int i = inf; i <= n - 2; i++) {
            if (prime[i] == true && prime[i + 2] == true){
                twinPrime = new TwinPrime(aux,i,(i+2));
                map.put(twinPrime.getId(),twinPrime);
                aux++;
            }
        }

        Integer index = aux;
        aux = 1;
        List<Integer> cadencia = new ArrayList<Integer>();
        int twinAux1;
        int twinAux2;

        for(TwinPrime twin : map.values()){
            if(twin.getId() != index-1)
                System.out.print(twin + ", ");
            else
                System.out.print(twin);
            if(twin.getId() != 0 && twin.getId() != index-1 ){
                twinAux1 = twin.getSecondNumber();
                twinAux2 = map.get(aux+1).getFirstNumber();
                cadencia.add((twinAux2-twinAux1));
                System.out.print((twinAux2-twinAux1) + ", ");
            }
            aux++;
        }

        Integer mayor = cadencia.get(0);

        for(int i=0; i < cadencia.size();i++){
            if(cadencia.get(i) > mayor) {
                mayor = cadencia.get(i);
            }
        }

        System.out.print("\n"+"La cantidad de números primos gemélos en el entorno "+"["+ inf + ","+n + "]" +" es: "+(aux-1));
        System.out.print("\n"+"La mayor distancia entre los primos gemelos es: " + mayor);

    }

}

