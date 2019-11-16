package main.java.bsuirlab.model.bean;


public class Doctor implements java.io.Serializable {

    private int ID;
    private String name;
    private String birthDate;
    private int departmentID;

    public Doctor() {
        this.name = "Name";
        this.birthDate = "1900.1.1";
        this.departmentID = 0;
		this.ID = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int ID) {
        this.departmentID = ID;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return (name.equals(((Doctor) o).name)) && (birthDate.equals(((Doctor) o).birthDate));
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Врач{ " + name + "\nДата рождения :" + birthDate + " }";
    }
}
