package lk.sliit.PAF.funding.dto;

public class FundDTO {
    private int id;
    private String name;
    private float price;

    public FundDTO() {
    }

    public FundDTO(int id) {
        this.id = id;
    }

    public FundDTO(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public FundDTO(String name, float price) {
        this.name = name;
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

