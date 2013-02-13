/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pairwiseTest;

import java.util.Random;
import membershipqry.membershipqry;
import quicksort.quicksort;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author jbs
 */
public class pairwiseTest {
    
  private int[] testArray;
  private int[] defaultArray;
  private int   key;
  private final static int SIZE = 20;
  private final static int MAX_VALUE = 200000;
  private quicksort sorter = new quicksort();
  private membershipqry query = new membershipqry();

  public pairwiseTest() {
        //create reference defaultArray, it never change during the exectuion
        defaultArray = new int[SIZE];
        //create testArray where we change the values
        testArray  = new int[SIZE];
        
        //fill up testArray
        Random generator = new Random();
        for(int i=0; i<testArray.length; i++){
          defaultArray[i] = generator.nextInt(MAX_VALUE);
        }
        
    }
  
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testNullPointer() {
      boolean ret = query.membershipQueryOnUnSortedArr(null,0,sorter);
      if(ret){
        fail("wrong return value");
      }
      assertTrue(true);
    }

    @Test
    public void testEmpty() {
      boolean ret = query.membershipQueryOnUnSortedArr(new int[0],0,sorter);
      if(ret){
         fail("wrong return value");
      }
      assertTrue(true);
    }

    @Test
    public void testMembershipQuery() {
        
      Random generator = new Random();

      //change one of the input variables 
      for(int i=0; i<testArray.length; i++){
        //change one more input variables  
        for(int j= i+1; j<testArray.length; j++){
            
                 
            //copy the reference testArray to the keyArray
            for(int k=0; k<defaultArray.length; k++){
              testArray[k] = defaultArray[k];
            }
            
            //pairwise test
            //change two input variables
            testArray[i] = generator.nextInt(MAX_VALUE);
            testArray[j] = generator.nextInt(MAX_VALUE);
            
            //set key, we make sure that key is in the table
            key = testArray[0];
            
            //run the membership query with the testArray and key
            //expecting for a ret == true
            boolean ret = query.membershipQueryOnUnSortedArr(testArray,key,sorter);

            //validate if the array is sorted
            if (!validateArraySorted(testArray)) {
                fail("Sort failed");
            }
            
            if(!ret){
                fail("Couldn't find member");
            }
            
        }

      }
          
      assertTrue(true);
    }

    @Test
    public void testMembershipQueryFalse() {
        
      Random generator = new Random();

      //change one of the input variables 
      for(int i=0; i<testArray.length; i++){
        //change one more input variables  
        for(int j= i+1; j<testArray.length; j++){
            
                 
            //copy the reference testArray to the keyArray
            for(int k=0; k<defaultArray.length; k++){
              testArray[k] = defaultArray[k];
            }
            
            //pairwise test
            //change two input variables
            testArray[i] = generator.nextInt(MAX_VALUE);
            testArray[j] = generator.nextInt(MAX_VALUE);
            
            //set key, we make sure that key is NOT in the table
            key = MAX_VALUE + 1 + generator.nextInt(MAX_VALUE);
            
            //run the membership query with the testArray and key
            //expecting for a ret == true
            boolean ret = query.membershipQueryOnUnSortedArr(testArray,key,sorter);

            //validate if the array is sorted
            if (!validateArraySorted(testArray)) {
                fail("Sort failed");
            }
            
            if(ret){
                fail("Find a member? impossible...");
            }
            
        }

      }
          
      assertTrue(true);
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
