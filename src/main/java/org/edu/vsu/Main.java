package org.edu.vsu;

public class Main {
    public static void main(String[] args){
        SomeBean sb = null;
        sb = (new Injector()).inject(new SomeBean());
        sb.foo();
    }
}