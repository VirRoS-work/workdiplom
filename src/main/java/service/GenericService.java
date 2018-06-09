package service;

import java.util.List;

public interface GenericService<T, Pk>{

    public void save(T t);

    public void delete(Pk pk);

    public T getObjectByPk(Pk pk);

    public List<T> getAll();
}
