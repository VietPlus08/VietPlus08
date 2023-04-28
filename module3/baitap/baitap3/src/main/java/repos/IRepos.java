package repos;

import java.util.List;

public interface IRepos<E> {
    List<E> findAll(String searchName, String index);

    E findById(int id);

    boolean delete(int id);

    void create(E e);

    void update(E e);

    int countItem();
}
