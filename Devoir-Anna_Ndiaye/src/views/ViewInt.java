package views;

import java.util.List;

public interface ViewInt<T> {
    T saisie();
    void liste(List<T> datas);
}
