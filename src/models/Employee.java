package models;

public class Employee {
    String objectId;
    String name;
    String phone;

    public Employee(String objectId, String name, String phone) {
        this.objectId = objectId;
        this.name = name;
        this.phone = phone;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
