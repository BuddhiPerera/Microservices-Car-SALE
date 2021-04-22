package lk.sliit.PAF.funding.dto;

public class FundDTO {
    private int id;
    private String fundID;
    private String fundName;
    private String email;
    private String address;
    private String contactNumber;
    private String fundMethod;
    private String amount;


    public FundDTO() {
    }

    public FundDTO(int id) {
        this.id = id;
    }

    public FundDTO(int id, String fundID, String fundName, String email, String address, String contactNumber, String fundMethod, String amount) {
        this.id = id;
        this.fundID = fundID;
        this.fundName = fundName;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.fundMethod = fundMethod;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FundDTO{" +
                "id=" + id +
                ", fundID='" + fundID + '\'' +
                ", fundName='" + fundName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", fundMethod='" + fundMethod + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFundID() {
        return fundID;
    }

    public void setFundID(String fundID) {
        this.fundID = fundID;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFundMethod() {
        return fundMethod;
    }

    public void setFundMethod(String fundMethod) {
        this.fundMethod = fundMethod;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FundDTO other = (FundDTO) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

