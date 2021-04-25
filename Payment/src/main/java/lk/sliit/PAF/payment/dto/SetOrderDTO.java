package lk.sliit.PAF.payment.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SetOrderDTO {
        String id;
        String name;
        String description;
        String price;
        String qty;
        String shipping;
        String image;
        String buyerId;
        String buyerName;
        String email;

    public SetOrderDTO(String id, String name, String description, String price, String qty, String shipping, String image, String buyerId, String buyerName, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.qty = qty;
        this.shipping = shipping;
        this.image = image;
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.email = email;
    }

    public SetOrderDTO() {

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getShipping() {
            return shipping;
        }

        public void setShipping(String shipping) {
            this.shipping = shipping;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SetOrderDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", qty='" + qty + '\'' +
                ", shipping='" + shipping + '\'' +
                ", image='" + image + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

