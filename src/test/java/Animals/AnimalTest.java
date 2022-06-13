package Animals;

import org.junit.jupiter.api.Test;

import java.util.List;

class AnimalTest {

    @Test
    void catCanTalk(){
        var cat1 = new Cat("coco");
        System.out.println(cat1.getName());
        var cat = new Cat();
        //cat.talk();
        var dog = new Dog();
        //dog.talk();

        List <Animal> animalList = List.of(cat,dog);

        //LAMBDAS

        animalList.forEach(item -> item.talk());
    }

}