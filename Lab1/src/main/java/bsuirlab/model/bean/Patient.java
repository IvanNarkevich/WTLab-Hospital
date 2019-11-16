package main.java.bsuirlab.model.bean;


public class Patient implements java.io.Serializable {
    private int ID;
    private String name;
    private String birthDate;
    private String admissionDate;
    private String diagnosis;
    private String treatment;
    private int doctorID;
    private int departmentID;

    public Patient() {
        name = "Name";
        birthDate = "01.01.1900";
        admissionDate = "01.01.1900";
        diagnosis = "diagnosis";
        treatment = "treatment";
        doctorID = 0;
        departmentID = 0;
        ID = 0;
    }

    public void setName(String name){
        if (name != null) {
            this.name = name;
        }
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

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis != null) {
            this.diagnosis = diagnosis;
        }
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDiagnosis(){
        return diagnosis;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int ID) {
        this.doctorID = ID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int ID) {
        this.departmentID = ID;
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
        if ((name != ((Patient)o).name) || (birthDate != ((Patient)o).birthDate))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Пациент{ " + name + "\nДата рождения :" + birthDate + "\nПоступил: " + admissionDate + "\nДиагноз: " + diagnosis + /*"\nЛечащий врач: " + doctor.getName() +*/ " }";
    }
}
