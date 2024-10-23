package model;

import java.util.List;

public interface ISet<T extends Comparable<T>> {
    public boolean add(T element);
    public List<T> union(ISet<T> element);
    public List<T> intersection (ISet<T> element);
    public List<T> diference (ISet<T> element);
    public List<T> getElements();
}
