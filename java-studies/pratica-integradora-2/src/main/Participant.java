package main;

public class Participant {
    private String rg;
    private String name;
    private String surname;
    private Integer age;
    private String cellphoneNumber;
    private String cellphoneEmergency;
    private String bloodGroup;
    private String circuit;
    private String price;

    public Participant(String rg, String name, String surname, Integer age, String cellphoneNumber, String cellphoneEmergency, String bloodGroup, String circuit, String price) {
        this.rg = rg;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cellphoneNumber = cellphoneNumber;
        this.cellphoneEmergency = cellphoneEmergency;
        this.bloodGroup = bloodGroup;
        this.circuit = circuit;
        this.price = price;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getCellphoneEmergency() {
        return cellphoneEmergency;
    }

    public void setCellphoneEmergency(String cellphoneEmergency) {
        this.cellphoneEmergency = cellphoneEmergency;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
