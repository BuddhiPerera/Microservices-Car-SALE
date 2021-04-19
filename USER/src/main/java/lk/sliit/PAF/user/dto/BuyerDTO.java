package lk.sliit.PAF.user.dto;

import java.util.Objects;

public class BuyerDTO {
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String contact;
    private String address;
    private String zipCode;
    private String pass;

    public BuyerDTO() {
    }

    public BuyerDTO(int id, String fName, String lName, String email, String contact, String address, String zipCode, String pass) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.zipCode = zipCode;
        this.pass = pass;
    }

    public BuyerDTO(int id) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        BuyerDTO other = (BuyerDTO) o;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getfName(), getlName(), getEmail(), getContact(), getAddress(), getZipCode(), getPass());
    }
}
