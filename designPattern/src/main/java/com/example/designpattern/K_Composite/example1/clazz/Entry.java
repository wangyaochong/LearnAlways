package com.example.designpattern.K_Composite.example1.clazz;

public abstract class Entry {
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry){
        throw new FileTreatmentException();
    }
    public void printList(){
        printList("");
    }
    protected abstract void printList(String prefix);
    public String toString(){
        return getName()+"("+getSize()+")";
    }
}
