package week12.d01;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class GoodsPacker2 {

    public static void main(String[] args) {
        System.out.println(new GoodsPacker2().packGoods(new int[][]{
            {6, 600},
            {4, 297},
            {2, 15}
                    }, 20));
    }

    int packGoods(int[][] types, int capacity) {
        List<ProductType2> productTypes = typesToList(types);
        Collections.sort(productTypes);
        Collections.reverse(productTypes);
        int weightSum = 0;
        int priceSum = 0;
        for (ProductType2 productType : productTypes) {
            while (weightSum + productType.getWeight() <= capacity) {
                weightSum += productType.getWeight();
                priceSum += productType.getPrice();
            }
        }
        return priceSum;
    }



    private List<ProductType2> typesToList(int[][] types) {
        if (types == null) {
            throw new IllegalArgumentException("types were null");
        }
        List<ProductType2> result = new ArrayList<>();
        for (int[] type : types) {
            result.add(new ProductType2(type[0], type[1]));
        }
        return result;
    }



    class ProductType2 implements Comparable<ProductType2> {



        private int weight;
        private int price;



        public ProductType2(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }



        public int getWeight() {
            return weight;
        }



        public int getPrice() {
            return price;
        }



        private BigDecimal getRate() {
            return BigDecimal.valueOf(price).divide(BigDecimal.valueOf(weight));
        }



        @Override
        public int compareTo(ProductType2 o) {
            return getRate().compareTo(o.getRate());
        }
    }
}