import com.playground.DataStructure.HashMap;
import com.playground.TestGenerator.IntegerGenerator;
import com.util.print;


public class Main {

    public static void main(String[] args) {
//        usingInternalLibrary.testHeap();
//        Solution sol = new Solution();
//        int[] arr = new int[] {-1,0,1,2,-1,-4};
//        System.out.println(sol.threeSum(arr));
        IntegerGenerator ig = new IntegerGenerator(0,26);
        int[] arr = new int[30];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0 ; i < 100000; i++)
        {
            int cur = ig.nextInt();
            arr[cur]++;
        }
        print.printArray(arr);
        System.out.println("This is a playground!");
    }
}
