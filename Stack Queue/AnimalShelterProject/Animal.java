package AnimalShelterProject;

public abstract class Animal {
    private int order;          //stores the order of the animal that came earlier
    protected String name;
    public Animal(String n)
    {
        name =n;
    }

    public abstract String name();

    public void setOrder(int ord)
    {
        order = ord;
    }

    public int getOrder()
    {
        return order;
    }

    public boolean isOlderThan(Animal a)
    {
        return this.order<a.getOrder();
    }
}
