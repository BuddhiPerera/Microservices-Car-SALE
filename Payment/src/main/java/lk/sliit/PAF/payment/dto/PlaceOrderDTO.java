package lk.sliit.PAF.payment.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlaceOrderDTO {
    String id;
    String name;
    String address;
    String state;
    String country;
    String zip;
    String contact;
    int qty;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(String id, String name, String address, String state, String country, String zip, String contact, int qty) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.contact = contact;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "PlaceOrderDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zip='" + zip + '\'' +
                ", contact='" + contact + '\'' +
                ", qty=" + qty +
                '}';
    }
}
