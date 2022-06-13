package Animals;

public class Cat extends Animal {
    private String name;

    public Cat(String  name){
        this.name = name;
    }

    public String getName(){
        return  name;
    }

    public void Cat(String name){
        this.name = name;
    }
    public Cat(){
        this.name = "Gat per defecte";
    }

    public void talk (){
        System.out.println("miau, miau");
    }



}
