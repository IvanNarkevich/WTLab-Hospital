package by.bsuir.wt_lab.entity;

public class Doctor implements java.io.Serializable, Comparable<Doctor>  {

    private int ID;
    private String name;
    private String birthDate;
    private int departmentID;

    public Doctor() {
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
        if ((name != ((Doctor)o).name) || (birthDate != ((Doctor)o).birthDate))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Врач{ " + name + "\nДата рождения :" + birthDate + " }";
    }

    public int compareTo(Doctor doctor){
        return ((Integer) getID()).compareTo(doctor.getID());
    }
}
