package p2_binary_search;

public class p3t74Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(arr,3));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {

        int matrixWidth=matrix[0].length;
        int l=0;
        int r=matrix.length*matrixWidth-1;
        int m;

        int cel;
        int ostat;

        while (l<r){
            m=(l+r)/2;

            cel=m/matrixWidth;
            ostat=m%matrixWidth;
            if(matrix[cel][ostat]==target) return true;
            if(matrix[cel][ostat]>target){
                r=m;
            }
            else{
                l=m+1;
            }
        }
        cel=r/matrixWidth;
        ostat=r%matrixWidth;
        if(matrix[cel][ostat]==target) return true;
        else return false;
    }
}
