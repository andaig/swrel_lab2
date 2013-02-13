/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package membershipqry;

import quicksort.quicksort;

/**
 *
 * @author 
 */

public class membershipqry {

    public boolean membershipQueryOnUnSortedArr(int[] array, int key, quicksort sortObj) {
        
    //sanity check
    if(array == null || array.length == 0){
      return false;
    }
    //sorting the array
    sortObj.sort(array);
    //membership search
    return membershipQueryOnSortedArr(array,key);
          
    }
    
    public boolean membershipQueryOnSortedArr(int[] array, int key) {
        
        //sanity check on input arguments
        if(array == null || array.length == 0){
          return false;
        }
        //sanity check on the array
        if (!validateArraySorted(array)) {
          return false;
        }
        
        
        int x,left,right;

        x=0;
        /* INJECTION-4: left = 2 */
        left=2;
        /* INJECTION-5: right = array.length */
        right = array.length -1 ;
        /* INJECTION-3: key != array[x] || left <=right */
        /* INJECTION-6: key != array[x] && left < right */
        while ( key != array[x] && left <= right ){

            x = (left+right) >> 1;

            if( key < array[x]){
                /* INJECTION-1: right = x + 2 */
                right = x - 1;
            }
            else{
                left = x + 1;
            }

        }
        /* INJECTION-2: key != array[x] */
        if (key == array[x]){
            return true;
        }
        else{
            return false;
        }
    }
     
     private boolean validateArraySorted(int[] testArray) {
      for (int i = 0; i < testArray.length - 1; i++) {
        if (testArray[i] > testArray[i + 1]) {
          return false;
        }
      }
      return true;
    }
    
}
