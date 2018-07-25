package hieuboy.excel.model;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    private int id;
    private String name;
    private String address;
    private String email;
    private int numberPhone;

    public Customer() {
    }

    public Customer(int id, String name, String address, String email, int numberPhone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "[Id:" + id + " Name: " + name + " Address: " + address + " Email: " + email + " Number Phone: " + numberPhone + "]";

    }
}
