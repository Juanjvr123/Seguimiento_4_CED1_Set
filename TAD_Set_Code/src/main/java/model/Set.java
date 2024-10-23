package model;

import java.util.ArrayList;
import java.util.List;

public class Set<T extends Comparable<T>> implements ISet<T>{
    private List<T> elements;

    public Set() {
        elements = new ArrayList<>();
    }

    public boolean add(T element) {
        boolean existEqual = false;

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).compareTo(element) == 0) {
                existEqual = true;
                return false;
            }
        }

        if(existEqual == false){
            elements.add(element);
            return true;
        }
        return false;
    }

    public boolean delete(T element) {

        for(int i = 0; i < elements.size(); i++) {
            if(elements.get(i).compareTo(element) == 0) {
                elements.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean have(T element) {
        for(int i = 0; i<elements.size(); i++){
            if(elements.get(i).compareTo(element) == 0){
                return true;
            }
        }
        return false;
    }

    public int size() {
        int counter = 0;
        for(int i = 0; i<elements.size(); i++){
            counter ++;
        }
        return counter;
    }

    public boolean isEmpty() {
        int counter = 0;
        for(int i = 0; i<elements.size(); i++){
            counter ++;
        }
        if(counter == 0){
            return true;
        }
        return false;
    }

    public boolean emptySet(){
        for(int i = 0; i<elements.size(); i++){
            elements.remove(i);
        }
        if(elements.isEmpty()){
            return true;
        }
        return false;
    }

    public List<T> union (ISet<T> set){
        List<T> unionSet = this.elements;
        for (int i = 0; i < set.getElements().size(); i++) {
            T element1 = set.getElements().get(i);
            for(int j= 0; j<unionSet.size(); j++) {
                T element2 = unionSet.get(i);
                if(element1.compareTo(element2) == 1 || element1.compareTo(element2) == 2) {
                    unionSet.add(element1);
                }
            }
        }

        return unionSet;
    }

    public List<T> getElements(){
        return elements;
    }

    public List<T> intersection(ISet<T> set) {
        List<T> intersectionSet = new ArrayList<>();
        for (int i = 0; i < set.getElements().size(); i++) {
            T element1 = set.getElements().get(i);
            for(int j= 0; j<elements.size(); j++) {
                T element2 = elements.get(i);
                if(element1.compareTo(element2) == 0) {
                    intersectionSet.add(element1);
                }
            }
        }

        return intersectionSet;

    }

    public List<T> diference(ISet<T> set) {
        List<T> diferenceSet = this.elements;
        for (int i = 0; i < diferenceSet.size(); i++) {
            T element1 = diferenceSet.get(i);
            for(int j= 0; j<set.getElements().size(); j++) {
                T element2 = diferenceSet.get(i);
                if(element1.compareTo(element2) == 0) {
                    diferenceSet.remove(element1);
                }
            }
        }
        return diferenceSet;
    }

}
