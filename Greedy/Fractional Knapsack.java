
class Item{
    int value;
    int weight;
    
    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        Item[] items = new Item[val.length];
        for(int i = 0 ; i < val.length ; i++){
            items[i] = new Item(val[i],wt[i]);
        }
        
        Arrays.sort(items,
            (a, b) -> Double.compare(
                (double) b.value / b.weight,
                (double) a.value / a.weight
            )
        );
        double totalValue = 0.0;
        for(int i = 0 ; i < items.length ; i++){
            if(capacity >= items[i].weight){
                totalValue += items[i].value;
                capacity -= items[i].weight;
            }
            else if(capacity < items[i].weight){
                totalValue += ((double)items[i].value/items[i].weight) * capacity;
                break;
            }
        }
        return totalValue;
        
    }
}
