package sainsburys.console.application.test.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import sainsburys.console.application.test.error.BuilderError;

import java.text.DecimalFormat;

public class Item {

    private final String title;
    private final String size;
    private final String unitPrice;
    private final String description;

    public Item(Builder builder){
        this.validate(builder);
        this.title = builder.title;
        this.unitPrice = builder.unitPrice;
        this.size = builder.size;
        this.description = builder.description;
    }

    public String getTitle() {
        return title;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    @JsonIgnore
    public double getUnitPriceAsNumber(){
        return Double.valueOf(this.unitPrice);
    }

    public String getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    private void validate(Builder builder) {

        if( builder.unitPrice == null) {
            throw new BuilderError("Price cannot be zero");
        }

        if(builder.size == null) {
            throw new BuilderError("size cannot be zero");
        }

        if(builder.title == null || builder.description == null){
            throw new BuilderError("Field cannot be null");
        }
    }

    public static class Builder {
        private String title;
        private String unitPrice;
        private String size;
        private String description;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }
        public Builder withUnitPrice(double unitPrice) {
            DecimalFormat df = new DecimalFormat("#.00");
            this.unitPrice = df.format(unitPrice);
            return this;
        }
        public Builder withSize(String size) {
            this.size = size;
            return this;
        }
        public Builder withDescription(String description){
            this.description = description;
            return this;
        }
        public Item build(){
            return new Item(this);
        }
    }
}
