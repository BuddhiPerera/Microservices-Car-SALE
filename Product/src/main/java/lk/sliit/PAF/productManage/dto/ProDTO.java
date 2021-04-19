package lk.sliit.PAF.productManage.dto;

public class ProDTO {


        String id;
        String name;
        String description;
        String price;
        String qty;
        String shipping;
        String image;

        public ProDTO(String id, String name, String description, String price, String qty, String shipping, String image) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.qty = qty;
            this.shipping = shipping;
            this.image = image;
        }

        public ProDTO() {

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

        @Override
        public String toString() {
            return "ProDTO{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", price='" + price + '\'' +
                    ", qty='" + qty + '\'' +
                    ", shipping='" + shipping + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        }
    }

