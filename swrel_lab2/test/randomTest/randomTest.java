/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import membershipqry.membershipqry;
import quicksort.quicksort;

/**
 *
 * @author
 */
public class randomTest {

  private int[] testArray;
  private int   key;
  private final static int SIZE = 20;
  private final static int MAX_VALUE = 20;
  private quicksort sorter = new quicksort();
  private membershipqry query = new membershipqry();
  
    public randomTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        testArray = new int[SIZE];
        Random generator = new Random();
        for(int i=0; i<testArray.length; i++){
          testArray[i] = generator.nextInt(MAX_VALUE);
        }
        key = testArray[0];
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testNullPointer() {
      boolean ret = query.membershipQueryOnUnSortedArr(null,key,sorter);
      if(ret){
        fail("wrong return value");
      }
      assertTrue(true);
    }

    @Test
    public void testEmpty() {
      boolean ret = query.membershipQueryOnUnSortedArr(new int[0],key,sorter);
      if(ret){
         fail("wrong return value");
      }
      assertTrue(true);
    }

    @Test
    public void testMembershipQuery() {
      //run test 10x times
      for(int i=0; i<40000; i++){

        //create random vector for every time
        Random generator = new Random();
        for(int j=0; j<testArray.length; j++){
          testArray[j] = generator.nextInt(MAX_VALUE);
        }
        //set key for the first element of the unsorted array, 
        //make sure we can find it
        key = testArray[0];    
          
        boolean ret = query.membershipQueryOnUnSortedArr(testArray,key,sorter);

        if (!validateArraySorted(testArray)) {
         fail("Sort failed");
        }

        if(!ret){
         fail("Couldn't find member");
        }
      }
      assertTrue(true);
    }
    
    @Test
    public void testMembershipQueryFalse() {
      //run test 10x times
      for(int i=0; i< 40000; i++){

        //create random vector for every time
        Random generator = new Random();
        for(int j=0; j<testArray.length; j++){
          testArray[j] = generator.nextInt(MAX_VALUE);
        }
        //set key outside the maxvalue, make sure we can't find it
        key = ( MAX_VALUE + 1 + generator.nextInt(MAX_VALUE)); 
          
        boolean ret = query.membershipQueryOnUnSortedArr(testArray,key,sorter);

        if (!validateArraySorted(testArray)) {
         fail("Sort failed");
        }

        if(ret){
         fail("Found member? impossible...");
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
