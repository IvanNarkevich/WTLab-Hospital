package main.bsuirlab.entity;

public class Department implements java.io.Serializable, Comparable<Department> {

    private int ID;
    private String name;

    public Department() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if ((name != ((Department)o).name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Отделение{ " + name + " }";
    }

    public int compareTo(Department department){
        return ((Integer) getID()).compareTo(department.getID());
    }
}

