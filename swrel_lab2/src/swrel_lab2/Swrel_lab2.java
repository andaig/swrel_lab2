/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swrel_lab2;

import java.util.Arrays;

/**
 *
 * @author jbs
 */
public class Swrel_lab2 {
           
    public void sortIntArray(int[] array) {
        Arrays.sort(array);
    }

 
    public int membershipQueryOnUnSortedArr(int[] array, int key) {
        
        sortIntArray(array);
        return membershipQueryOnSortedArr(array,key);
          
    }
    public int membershipQueryOnSortedArr(int[] array, int key) {
    
        int x,left,right;
        
        x=0;
        left=0;
        right = array.length -1;
        
        while ( key != array[x] && left <=right ){
           
            x = (left+right) >> 1;
            
            if( key < array[x]){
                right = x - 1;
            }
            else{
                left = x + 1;
            }
                
        }
        
        if (key == array[x]){
            return x;
        }
        else{
            return -1;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int[] array = new int[] {48, 5, 89, 80, 81, 23, 45, 16, 2};
        int ret;
        
        Swrel_lab2 main = new Swrel_lab2();
  
        ret = main.membershipQueryOnUnSortedArr(array, 89);
        
        /*    
        main.sortIntArray(array);
       
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        
        ret = main.membershipQueryOnSortedArr(array, 33    );
        */ 

        System.out.printf("Position: %d\n",ret);
        System.out.printf("Value:    %d\n",array[ret]);
        System.out.printf("Finished...");
        
 
    }
}

