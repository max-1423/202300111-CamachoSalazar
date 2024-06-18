public class SE<T>{
    private T        dato;
    private SE<T> suc;
    public SE(){
        dato = null;
        suc = null;
    }
    public SE(T valor){
        dato = valor;
        suc = new SE();
    }
    public T getDato(){
        return dato;
    }
    public SE<T> getSuc(){
        return suc;
    }
    public void setDato(T valor){
        dato = valor;
    }
    public void setSuc(SE<T> otro){
        suc = otro;
    }
    public boolean vacio(){
        boolean res = false;
        if(dato == null){
            res = true;
        }
        return res;
    }
}
