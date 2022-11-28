package main.person;

public interface Manage<T> {//strategy
    
    public boolean isEmpty();
    public void showAll();
    public void remove(String toRemove);
    //public void search(T any);
}
