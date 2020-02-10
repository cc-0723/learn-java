package 寒假作业;

import java.util.Stack;

public class Solution29 {
    //股票价格跨度
    Stack<Integer> prices, weights;

    public Solution29() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while( !prices.isEmpty() && price >= prices.peek()) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }
}
