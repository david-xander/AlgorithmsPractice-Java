import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) throws Exception {
        //
        // 
        //
        int[] data = new int[]{10, 5, 12, 4, 1, 8, 2, 11, 7, 9, 13, 3, 6, 14};
        System.out.println("MERGESORT " + Arrays.toString(data) + ": " + Arrays.toString(merge_sort(data)));        
    }
    
    private static int[] merge_sort(int[] data){
        int[] res = new int[data.length];
        int n=data.length;
        int half=n/2;
        int[] L = new int[half];
        int[] R = new int[n-half];

        for(int i=0; i<half; i++){
            L[i]=data[i];
        }
        for(int i=0; i<n-half; i++){
            R[i]=data[i+half];
        }     
        
        if(L.length>1)
            L=merge_sort(L);
        if(R.length>1)
            R=merge_sort(R);
        
        res = merge_ordered(L, R);

        return(res);
    }

    private static int[] merge_ordered(int[] L, int[] R){
        int n = L.length + R.length;
        int[] res = new int[n];
        int k=0;
        int i=0; 
        int j=0;
        for(; k<n && i<L.length && j<R.length; k++){
            if(L[i]<=R[j]){
                res[k]=L[i];
                i++;
            }
            else{
                res[k]=R[j];
                j++;                
            }
        }
        for(;i<L.length;i++, k++)
            res[k]=L[i];
        for(;j<R.length;j++, k++)
            res[k]=R[j];    
        
        return(res);
    }

}
