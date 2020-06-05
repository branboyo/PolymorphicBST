package tests;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;
import tree.PlaceKeysValuesInArrayLists;
import tree.PolymorphicBST;

public class StudentTests extends TestCase {
	@Test
	public void testGet() {
		PolymorphicBST<Integer,Integer> test = new PolymorphicBST<Integer,Integer>();
		test.put(2,2);
		test.put(1,1);
		test.put(3,3);
		assertTrue(test.get(2)==2);
		assertTrue(test.get(1)==1);
		assertTrue(test.get(3)==3);
		}
	
	@Test
	public void testSize() {
		PolymorphicBST<Integer,Integer>test = new PolymorphicBST<Integer,Integer>();
		test.put(1,1);
		test.put(2, 2);
		test.put(4,4);
		test.put(5, 5);
		assertEquals(test.size(),4);
	}
	
	@Test
	public void testKeySet() {
		PolymorphicBST<Integer,Integer>test = new PolymorphicBST<Integer,Integer>();
		test.put(2,2);
		test.put(3,3);
		test.put(1, 1);
		Set<Integer> set= new HashSet<Integer>();
		set = test.keySet();
		assertEquals(set.toString(),"[1, 2, 3]");
	}
	
	@Test
	public void testGetMinMax() {
		PolymorphicBST<Integer,Integer>test = new PolymorphicBST<Integer,Integer>();
		test.put(5,5);
		test.put(3,3);
		test.put(8, 8);
		test.put(9, 9);
		test.put(2, 2);
		test.put(1, 1);
		assertTrue(test.getMin()==1);
		assertTrue(test.getMax()==9);
	}
	
	@Test
	public void testSubMap() {
		PolymorphicBST<Integer,Integer>test = new PolymorphicBST<Integer,Integer>();
		test.put(5,5);
		test.put(3,3);
		test.put(8, 8);
		test.put(9, 9);
		test.put(2, 2);
		test.put(1, 1);
		PolymorphicBST<Integer,Integer>sub = test.subMap(5, 8);
		PlaceKeysValuesInArrayLists<Integer, Integer> task = new PlaceKeysValuesInArrayLists<Integer, Integer>();
		sub.inorderTraversal(task);
		assertEquals(task.getKeys().toString(),"[5, 8]");
		assertEquals(task.getValues().toString(),"[5, 8]");
		
	}
	
	@Test
	public void testInorder() {
		PolymorphicBST<Integer,Integer> test = new PolymorphicBST<Integer,Integer>();
		
		test.put(2, 20);
		test.put(1, 10);
		test.put(3, 30);
		test.put(4, 40);
		PlaceKeysValuesInArrayLists<Integer, Integer> task = new PlaceKeysValuesInArrayLists<Integer, Integer>();
		test.inorderTraversal(task);
		assertEquals(task.getKeys().toString(), "[1, 2, 3, 4]");
		assertEquals(task.getValues().toString(), "[10, 20, 30, 40]");
	}
	
	@Test
	public void testRightRootLeft() {
		PolymorphicBST<Integer,Integer> test = new PolymorphicBST<Integer,Integer>();
		
		test.put(2, 20);
		test.put(1, 10);
		test.put(3, 30);
		test.put(4, 40);
		PlaceKeysValuesInArrayLists<Integer, Integer> task = new PlaceKeysValuesInArrayLists<Integer, Integer>();
		test.rightRootLeftTraversal(task);
		assertEquals(task.getKeys().toString(), "[4, 3, 2, 1]");
		assertEquals(task.getValues().toString(), "[40, 30, 20, 10]");
	}
	
	@Test
	public void testClearHeight() {
		PolymorphicBST<Integer,Integer> test = new PolymorphicBST<Integer,Integer>();
		test.put(3, 3);
		test.put(6, 6);
		test.put(1, 1);
		test.put(10, 10);
		assertEquals(test.height(),3);
		test.clear();
		assertEquals(test.height(),0);
	}
	
	@Test
	public void testDeleteOne() {
		PolymorphicBST<Integer,Integer>test = new PolymorphicBST<Integer,Integer>();
		test.put(3, 3);
		test.put(6, 6);
		test.put(1, 1);
		test.put(10, 10);
		test.remove(3);
		PlaceKeysValuesInArrayLists<Integer, Integer> task = new PlaceKeysValuesInArrayLists<Integer, Integer>();
		test.rightRootLeftTraversal(task);
		assertEquals(task.getValues().toString(),"[10, 6, 1]");
	}
	
	@Test
	public void testDeleteTwo() {
		PolymorphicBST<Integer,Integer>test = new PolymorphicBST<Integer,Integer>();
		test.put(5, 5);
		test.put(1, 1);
		test.put(7, 7);
		test.put(6, 6);
		test.put(8, 8);
		test.remove(8);
		PlaceKeysValuesInArrayLists<Integer, Integer> task = new PlaceKeysValuesInArrayLists<Integer, Integer>();
		test.rightRootLeftTraversal(task);
		assertEquals(task.getValues().toString(),"[7, 6, 5, 1]");
	}
	
	@Test
	public void testDeleteThree() {
		PolymorphicBST<Integer,Integer>test = new PolymorphicBST<Integer,Integer>();
		test.put(10, 10);
		test.put(8, 8);
		test.put(20, 20);
		test.put(17, 17);
		test.put(21, 21);
		test.put(7, 7);
		test.put(9, 9);
		test.remove(8);
		PlaceKeysValuesInArrayLists<Integer, Integer> task = new PlaceKeysValuesInArrayLists<Integer, Integer>();
		test.rightRootLeftTraversal(task);
		assertEquals(task.getValues().toString(),"[21, 20, 17, 10, 9, 7]");
	}
	
}