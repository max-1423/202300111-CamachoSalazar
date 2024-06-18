import java.util.*;
public class Ejercicio1{
    public static void main(String[] args) {
        Ejercicio1 ej = new Ejercicio1();
        String[] muñecas = {"a", "b", "c", "a", "c", "a", "b"};
        ArrayList<ArrayList<String>> resultado = ej.ordenarMuñecas(muñecas);
        System.out.println(resultado);
    }
    public ArrayList<ArrayList<String>> ordenarMuñecas(String[] muñecas) {
        ArrayList<ArrayList<String>> juegos = new ArrayList<>();
        Arrays.sort(muñecas);
        ArrayList<String> conjunto=new ArrayList<>(Arrays.asList(muñecas));;
        while(!conjunto.isEmpty()){
            ArrayList<String> juegoActual = new ArrayList<>();
            juegoActual.add(conjunto.get(0));
            for(int i=1;i<conjunto.size();i++){
                if(!juegoActual.contains(conjunto.get(i))){
                    juegoActual.add(conjunto.get(i));
                }
            }
            juegos.add(juegoActual);
            conjunto = eliminar(conjunto, juegoActual);
        }
        return juegos;
    }
    public ArrayList<String> eliminar(ArrayList<String> conjunto,ArrayList<String> juegoActual){
        ArrayList<String> nuevoConjunto = new ArrayList<>(conjunto);
        for (String muñeca : juegoActual) {
            nuevoConjunto.remove(muñeca);
        }
        return nuevoConjunto;
    }
}