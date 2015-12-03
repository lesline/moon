package base.fx;
public class GenericsFoo<T> {
    private T x;
 
    public GenericsFoo(T x) {
        this.x = x;
    }
 
    public T getX() {
        return x;
    }
 
    public void setX(T x) {
        this.x = x;
    }
}
 
