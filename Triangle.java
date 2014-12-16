public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()<=0) return 0;
        if (triangle.size()==1) return triangle.get(0).get(0);
        int nRow = triangle.size();
        int [] minPath = new int[nRow];
        minPath[0]=triangle.get(0).get(0);
        for(int iRow=1;iRow<nRow;iRow++){
            List<Integer> row = triangle.get(iRow);
            for(int j=iRow;j>=0;j--){
                int p1=Integer.MAX_VALUE,p2=Integer.MAX_VALUE;
                if(j>0){
                    p1 = row.get(j) + minPath[j-1]; 
                } 
                if(j<iRow){
                    p2 = row.get(j) + minPath[j]; 
                }
                minPath[j] = p1>p2?p2:p1;
            } 
        }
        int minSum = Integer.MAX_VALUE;
        for(int j=0;j<nRow;j++){
            if (minPath[j]<minSum) minSum = minPath[j];
        }
        
        return minSum;
    }
}
