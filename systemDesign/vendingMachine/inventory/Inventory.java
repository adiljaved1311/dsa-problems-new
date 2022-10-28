package systemDesign.vendingMachine.inventory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory {
    private Map<Integer,Product> aisleToProductMap;
    private Map<Integer,Integer> productIdToCountMap;
    Queue<Integer> availableAisles;

    public Inventory(int aisleCount) {
        availableAisles = new LinkedList<>();
        for (int aisleNo = 1;aisleNo <= aisleCount; aisleNo++ )
            availableAisles.add(aisleNo);

        aisleToProductMap = new HashMap<>();
        productIdToCountMap = new HashMap<>();
    }

    public void addProduct(Product product) throws Exception{
        int productId = product.getProductId();
        int productCount = productIdToCountMap.getOrDefault(productId,0);
        if(productCount == 0){
            if(availableAisles.isEmpty())
                throw new Exception("Out os space to add product");

            aisleToProductMap.put(availableAisles.poll(),product);
        }
        productIdToCountMap.put(productId,productId+1);
    }

    public Product getProductAt(int aisleNumber){
        return aisleToProductMap.get(aisleNumber);
    }

    public boolean checkIfProductAvailable(int productId){
        int productCount = productIdToCountMap.getOrDefault(productId,0);
        return productCount > 0;
    }

    public void deductProductCount(int aisleNumber){
        int productId = aisleToProductMap.get(aisleNumber).getProductId();
        int updatedProductCount = productIdToCountMap.get(productId) - 1;
        if(updatedProductCount == 0){ // stock of product is finished, hence aisle number
            productIdToCountMap.remove(productId);
            aisleToProductMap.remove(aisleNumber);
            availableAisles.add(aisleNumber); // adding current to available aisles
        }else{
            productIdToCountMap.put(productId,updatedProductCount);
        }
    }
}
