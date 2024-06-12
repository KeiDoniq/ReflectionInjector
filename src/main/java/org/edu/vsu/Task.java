package org.edu.vsu;

interface SomeInterface{
    public void doSomething();
}
interface SomeOtherInterface{
    public void doSomeOther();
}
class SomeImpl implements SomeInterface{
    @Override
    public void doSomething(){
        System.out.println("A");}
}
class OtherImpl implements SomeInterface{
    @Override
    public void doSomething(){System.out.println("B");}
}
class SODoer implements SomeOtherInterface{
    public void doSomething(){
        System.out.println("C");}

    @Override
    public void doSomeOther() {

    }
}
class SomeBean{
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;
    public void foo(){
        field1.doSomething();
        field2.doSomeOther();
    }
}
