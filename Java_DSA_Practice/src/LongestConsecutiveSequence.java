import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    //Brute Force
    /*public static boolean linearSearch(int[] a, int num) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            if(a[i] == num)
            return true;
        }
        return false;
    }
    public static int longestSuccessiveElements(int[] a) {
        int n = a.length;
        int longest  = 1;

        for(int i = 0; i < n; i++) {
            int x = a[i];
            int cnt = 1;

            while(linearSearch(a, x + 1) == true) {
                x += 1;
                cnt += 1;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
}*/
//Better Approach
/*public static int longestSuccessiveElements(int []a) {
    int n = a.length;
    if (n == 0) return 0;

    //sort the array:
    Arrays.sort(a);
    int lastSmaller = Integer.MIN_VALUE;
    int cnt = 0;
    int longest = 1;

    //find longest sequence:
    for (int i = 0; i < n; i++) {
        if (a[i] - 1 == lastSmaller) {
            //a[i] is the next element of the
            //current sequence.
            cnt += 1;
            lastSmaller = a[i];
        } else if (a[i] != lastSmaller) {
            cnt = 1;
            lastSmaller = a[i];
        }
        longest = Math.max(longest, cnt);
    }
    return longest;
}

public static void main(String[] args) {
    int[] a = {100, 200, 1, 2, 3, 4};
    int ans = longestSuccessiveElements(a);
    System.out.println("The longest consecutive sequence is " + ans);
}
}*/
//Optimal Approach
public static int longestSuccessiveElements(int []a) {
    int n = a.length;
    if (n == 0) return 0;

    int longest = 1;
    Set<Integer> set = new HashSet<>();

    for(int i = 0; i < n; i++) {
        set.add(a[i]);
    }

    for(int it : set) {
        if(!set.contains(it - 1)) {
            int cnt = 1;
            int x = it;
            while(set.contains(x + 1)){
                x = x + 1;
                cnt = cnt + 1;
            } 
            longest = Math.max(longest, cnt);
        }
    }
    return longest;
}
public static void main(String[] args) {
    int[] a = {100, 200, 1, 2, 3, 4};
    int ans = longestSuccessiveElements(a);
    System.out.println("The longest consecutive sequence is " + ans);
}
}