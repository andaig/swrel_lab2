/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swrel_lab2;

import java.util.Arrays;
import quicksort.quicksort;
import membershipqry.membershipqry;

/**
 *
 * @author jbs
 */
public class Swrel_lab2 {
           
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int[] array = new int[] {48, 5, 89, 80, 81, 23, 45, 16, 2};
        boolean ret;
        
        Swrel_lab2 main     = new Swrel_lab2();
        quicksort  QS       = new quicksort();
        membershipqry msqry = new membershipqry();
  
        ret = msqry.membershipQueryOnUnSortedArr(array, 89, QS);
        
        if(ret){
            System.out.printf("Member!\n",ret);
        }
        else{
            System.out.printf("Not a member!\n");
        }
        
        System.out.printf("Finished...");
        
 
    }
}



        /*    
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        
        ret = msqry.membershipQueryOnSortedArr(array, 33    );
        */ 
