/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qsTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import quicksort.quicksort;
/**
 *
 * @author 
 */
public class qsTest {
    
  private int[] numbers;
  private final static int SIZE = 7;
  private final static int MAX = 20;

    public qsTest() {
    }

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
          numbers[i] = generator.nextInt(MAX);
        }
    }

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testNull() {
      quicksort sorter = new quicksort();
      sorter.sort(null);
    }

    @Test
    public void testEmpty() {
      quicksort sorter = new quicksort();
      sorter.sort(new int[0]);
    }

    @Test
    public void testSimpleElement() {
      quicksort sorter = new quicksort();
      int[] test = new int[1];
      test[0] = 5;
      sorter.sort(test);
    }

    @Test
    public void testSpecial() {
      quicksort sorter = new quicksort();
      int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
      sorter.sort(test);
      if (!validate(test)) {
        fail("Should not happen");
      }
      printResult(test);
    }

    @Test
    public void testQuickSort() {
      for (Integer i : numbers) {
        System.out.println(i + " ");
      }
      long startTime = System.currentTimeMillis();

      quicksort sorter = new quicksort();
      sorter.sort(numbers);

      long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      System.out.println("quicksort " + elapsedTime);

      if (!validate(numbers)) {
        fail("Should not happen");
      }
      assertTrue(true);
    }

    @Test
    public void testStandardSort() {
      long startTime = System.currentTimeMillis();
      Arrays.sort(numbers);
      long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      System.out.println("Standard Java sort " + elapsedTime);
      if (!validate(numbers)) {
        fail("Should not happen");
      }
      assertTrue(true);
    }

    private boolean validate(int[] numbers) {
      for (int i = 0; i < numbers.length - 1; i++) {
        if (numbers[i] > numbers[i + 1]) {
          return false;
        }
      }
      return true;
    }

    private void printResult(int[] numbers) {
      for (int i = 0; i < numbers.length; i++) {
        System.out.print(numbers[i]);
      }
      System.out.println();
    }

}


