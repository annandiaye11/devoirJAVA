package core;

import java.util.List;

public interface Service<T> {
    void add(T data);
    List<T> show();
    T getBy(String data);

}
