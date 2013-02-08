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

    public int membershipQueryOnUnSortedArr(int[] array, int key, quicksort sortObj) {

    sortObj.sort(array);
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
    
}
