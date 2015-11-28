package sainsburys.console.application.test.model;

import sainsburys.console.application.test.error.BuilderError;

import java.text.DecimalFormat;
import java.util.List;

public class ConsoleResponse{

    private List<Item> results;
    private String total;


    private ConsoleResponse(Builder builder){
        validate(builder);
        this.total = builder.total;
        this.results = builder.items;
    }

    public String getTotal() {
        DecimalFormat df = new DecimalFormat("##.00");
        total = df.format(results
                .stream()
                .mapToDouble(Item::getUnitPriceAsNumber)
                .sum());

        return total;
    }

    public List<Item> getResults() {
        return results;
    }

    public void validate(Builder builder) {

        if(builder.items == null){
            throw new BuilderError("Items");
        }
    }

    public static class Builder {
        private String total;
        private List<Item>items;
        private DecimalFormat df = new DecimalFormat("#.00");

        public Builder withTotal(double total) {
            this.total = df.format(total);
            return this;
        }

        public Builder withItems(List<Item> items) {
            this.items = items;
            return this;
        }
        public ConsoleResponse build(){
            return new ConsoleResponse(this);
        }

    }
}
