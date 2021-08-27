package Sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort_test {
    public static void main(String args[]){
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Solution solution = new Solution();
        System.out.println(solution.merge(intervals));
    }
}


class Solution{
    //1.合并区间
    //https://leetcode-cn.com/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
    public int[][] merge(int[][] intervals){

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[0] - intervals2[0];
            }
        });
        List<int[]> result = new ArrayList<int[]>();
        for(int i=0;i< intervals.length;i++){

            if(result.size()==0 || result.get(result.size() - 1)[1] < intervals[i][0]){
                result.add(intervals[i]);
            }
            else if(result.get(result.size()-1)[1] >= intervals[i][0]){
                result.get(result.size()-1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);

            }

        }
        return result.toArray(new int[result.size()][]);

    }


}

