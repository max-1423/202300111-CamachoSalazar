import java.util.ArrayList;
public class Ejercicio2<T> {
    SE<T> ini;
    public static void main(String[]args){
        Ejercicio2 lista = new Ejercicio2();
        lista.insertar(7);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        lista.insertar(0);
        lista.insertar(2);
        lista.insertar(8);
        System.out.println("Lista antes del intercambio:");
        String[] resultado = lista.print();
        for (String s : resultado) {
            System.out.print(s + " ");
        }
        System.out.println();
        lista.swap(1,6);
        System.out.println("Lista después del intercambio:");
        resultado = lista.print();
        for (String s : resultado) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    public Ejercicio2(){
        ini = new SE<T>();
        ini.setSuc(ini);
    }
    public boolean vacio(){
        return ini.vacio();
    }
    public void insertar (T dat){
        if(vacio()){
            ini.setDato(dat);
        }else{
            SE<T> nodoact = ini;
            while(nodoact.getSuc() != ini){
                nodoact = nodoact.getSuc();
            }
            SE<T> nuevo = new SE<T>(dat);
            nodoact.setSuc(nuevo);
            nuevo.setSuc(ini);
        }
    }
    public int longitud(){
        if(vacio()) {
            return 0;
        }
        else{
            SE<T> nodoact = ini;
            int tam = 1;
            while(nodoact.getSuc() != ini){
                tam++;
                nodoact = nodoact.getSuc();
            }
            return tam;
        }
    }
    public void swap(int i, int j){
        int tam= longitud();
        if(i<tam && j<tam){
            T a = acceder(i);
            T b = acceder(j);
            reemplazar(a,j); 
            reemplazar(b,i);
        }
    }
    public void reemplazar(T dato, int pos){
        int tam = longitud();
        if(pos < tam){
            SE<T> nodobuscado = buscar(pos);
            nodobuscado.setDato(dato);
        }
    }
    public SE<T> buscar(int pos){
        SE<T> nodoact = ini;
        int cont = 0;
        while(cont < pos){
            nodoact = nodoact.getSuc();
            cont++;
        }
        return nodoact;
    }
    public T acceder(int pos){
        T dato = null;
        int tam = longitud();
        if(pos < tam){
            SE<T> nodobuscado = buscar(pos);
            dato = nodobuscado.getDato();
        }
        return dato;
    }
    public String[] print(){
        if(vacio()){
            return new String[]{};
        }else{
            ArrayList<String> c= new ArrayList<String>();
            SE<T> f= ini;
            do{
                c.add(f.getDato().toString());
                f= f.getSuc();
            }while(f!= ini);
            return c.toArray(new String[0]);
        }
    }
}