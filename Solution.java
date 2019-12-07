package 数据结构;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows == 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for(int i = 0;i < numRows; i ++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);
            row.add(1);

            for(int j = 1; j < i; j ++) {
               row.add(prevRow.get(j - 1) + prevRow.get( j ));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
