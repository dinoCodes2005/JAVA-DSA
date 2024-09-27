package AnimalShelterProject;

import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order=0;

    public void enQueue(Animal a)
    {
        a.setOrder(order);
        order++;
        if(a instanceof Dog)
        {
            dogs.addLast((Dog)a);
        }
        else if(a instanceof Cat)
        cats.addLast((Cat)a);
    }

    public int size()
    {
        return dogs.size()+cats.size();
    }

    public Dog dequeuDogs()
    {
        return dogs.poll();
    }

    public Dog peekDogs()
    {
        return dogs.peek();
    }

    public Cat dequeuCats()
    {
        return cats.poll();
    }

    public Cat peekCats()
    {
        return cats.peek();
    }

    public Animal dequeueAny()
    {
        if(dogs.size()==0)
        return dequeuCats();
        else if(cats.size()==0)
        return dequeuDogs();
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat))
        return dogs.poll();
        return cats.poll();
    }

    public Animal peek()
    {
        if(dogs.size()==0)
        return cats.peek();
        else if(cats.size()==0)
        return dogs.peek();
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat))
        return dogs.peek();
        return cats.peek();
    }

}
