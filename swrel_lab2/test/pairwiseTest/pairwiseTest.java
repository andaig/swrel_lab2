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
  private int   key;
  private final static int SIZE = 200;
  private final static int MAX_VALUE = 200000;
  private quicksort sorter = new quicksort();
  private membershipqry query = new membershipqry();

  public pairwiseTest() {
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

      boolean ret = query.membershipQueryOnUnSortedArr(testArray,key,sorter);
      
      if (!validate(testArray)) {
       fail("Sort failed");
      }
      
      if(!ret){
       fail("Couldn't find member");
      }
      
      assertTrue(true);
    }

    private boolean validate(int[] testArray) {
      for (int i = 0; i < testArray.length - 1; i++) {
        if (testArray[i] > testArray[i + 1]) {
          return false;
        }
      }
      return true;
    }
}
