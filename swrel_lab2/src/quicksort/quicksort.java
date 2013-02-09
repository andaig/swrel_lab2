/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author
 */
public class quicksort {
  private int[] elements;
  private int no_of_elements;

  public void sort(int[] values){
      
    //sanity check
    if(values == null || values.length == 0){
      return;
    }
    
    //set members
    this.elements = values;
    no_of_elements = values.length;
    
    //call sort algorithm
    qs(0, no_of_elements - 1);
    
  }

  private void qs(int low, int high){
      
    int i = low;
    int j = high;
    
    //select middle element as a pivot
    int pivot = elements[ low + ((high - low)/2) ];

    // split elements into two list
    while (i <= j){

      // iterate through the left side, searching for elements 
      // that are bigger than pivot
      while (elements[i] < pivot) {
        i++;
      }
      
      // iterate through the right side, searching for elements 
      // that are smaller than pivot
      while (elements[j] > pivot) {
        j--;
      }
      
      /*if we have found an element in the left side which is smaller than pivot,
       * or we have found an element in the right side which is larger than pivot
       * then swap them 
       */
      if (i <= j){
        swap(i, j);
        i++;
        j--;
      }
    }
    
    //call recursively
    if (low < j){
      qs(low, j);
    }
    if (i < high){
      qs(i, high);
    }
  }

  private void swap(int i, int j) {

    int tmp = elements[i];
    
    elements[i] = elements[j];
    elements[j] = tmp;
    
  }
    
    
}
