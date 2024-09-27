package AnimalShelterProject;

public class Main {
    public static void main(String[] args) {
        
        AnimalQueue animals = new AnimalQueue();
        animals.enQueue(new Cat("chinchilla"));
        animals.enQueue(new Cat("british short hair"));
        animals.enQueue(new Cat("pookie cat"));
        animals.enQueue(new Cat("angry cat"));
        animals.enQueue(new Dog("Golden retriever"));
        animals.enQueue(new Dog("Labrador"));
        animals.enQueue(new Dog("Chihuahua"));
        animals.enQueue(new Dog("Pitbull"));
        
        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeuDogs().name());
        System.out.println(animals.dequeuCats().name());
        System.out.println(animals.peekCats().name());
        System.out.println(animals.peekDogs().name());

    }
    
    
}
