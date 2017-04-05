package stadheim.eirik.api.dto;

import stadheim.eirik.persistence.model.MealProduct;

public class ProductUnitDto {
        private ProductDto product;
        private String unit;
        private int quantity;

        public ProductUnitDto() {
        }

        public ProductDto getProduct() {
            return product;
        }

        public void setProduct(ProductDto product) {
            this.product = product;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public MealProduct toModel() {
            MealProduct mealProduct = new MealProduct();
            mealProduct.setProduct(product.toModel());
            mealProduct.setUnit(unit);
            mealProduct.setQuantity(quantity);

            return mealProduct;
        }
    }