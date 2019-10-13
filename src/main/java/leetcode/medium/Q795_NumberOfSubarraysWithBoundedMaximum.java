package leetcode.medium;

public class Q795_NumberOfSubarraysWithBoundedMaximum {
//    public int numSubarrayBoundedMax(int[] A, int L, int R) {
//        int i = 0, j = 0;
//        int result = 0, max = 0;
//        while (j < A.length) {
//            max = max < A[j] ? A[j] : max;
//            if (max >= L && max <= R) {
//                j ++;
//                if (j >= A.length) {
//                    int l = j - i;
//                    result += (l + 1) * l / 2;
//                    return result;
//                }
//                continue;
//            }
//            int l = j - i;
//            result += (l + 1) * l / 2;
//            while (!(A[j] >= L && A[j] <= R)) {
//                j ++;
//                if (j >= A.length) return result;
//            }
//            i = j;
//            max = A[j];
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Q795_NumberOfSubarraysWithBoundedMaximum q = new Q795_NumberOfSubarraysWithBoundedMaximum();
////        int[] a = new int[]{2,9,2,5,6};
//        int[] a = new int[]{2,1,4,3};
//        int r = q.numSubarrayBoundedMax(a, 2, 3);
//        System.out.println(r);
//    }
}
