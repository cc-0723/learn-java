import java.util.*;

public class MaxGap {
    public int findMaxGap(int[] A, int n) {
        int leftmax = 0, rightmax = 0, value = 0, tmp = 0;
        for(int K = 0; K < n - 1; K++) {
            if(value != 0 && A[K] > leftmax) {
                leftmax = A[K];
            } else {
                leftmax = A[0];
                for(int i = 0; i <= K ; i++) {
                    leftmax = A[i] > leftmax ? A[i] : leftmax;
                }
            }
            rightmax = A[K + 1];
            for(int j = K + 1; j < n; j++) {
                rightmax = A[j] > rightmax ? A[j] : rightmax;
            }
            value = leftmax - rightmax;
            value = value < 0 ? -value : value;
            tmp = value > tmp ? value : tmp;
        }
        return tmp;
    }
}