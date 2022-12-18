
public interface Buffer<E>{
     // producers call this method
    void insert();

    // consumers call this method
    E remove();
}
