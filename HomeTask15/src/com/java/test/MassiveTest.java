package com.java.test;

import com.java.hometask15.Massive;
import com.java.hometask15.SomeException;
import org.junit.*;

import static org.junit.Assert.*;

public class MassiveTest {

  private Massive massive;

  @BeforeClass
  public static void makeItHappen(){
    System.out.println("the BeforeClass Method");
  }

  @Before
  public void setUp() throws Exception {
    massive = new Massive();
  }

  @Test
  public void test1(){
    double[] actual = massive.printEvens(massive.getMas());
    double[] expected = { };
    assertArrayEquals(expected, actual, 0.00);
  }

  @Test(expected = SomeException.class)
  public void test2() throws SomeException {
    String actual = (massive.makeSomeDivs(massive.getMas(), 0)).toString();
    String expected = "ERROR! Бесконечно малый делитель";
    assertEquals(expected, actual);
  }

  @Test
  public void test3(){
    assertNotNull(massive);
    assertNotNull("Creation failed?", massive);
  }

  @Test
  public void test4(){
    assertNull(massive);
    assertNotNull("Object is self-created?", massive);
  }

  @Test
  public void test5(){
    Massive othermassive = massive;
    assertSame(massive, othermassive);
  }

  @Ignore("Not cool enough")
  @Test
  public void test6(){
    Massive othermassive = new Massive();
    assertNotSame(massive, othermassive);
  }

  @Test(timeout = 2)
  public void test7(){
    Massive othermassive = new Massive();
    assertNotSame(massive, othermassive);
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("the test is complete");
  }

  @AfterClass
  public static void madeItHappen(){
    System.out.println("the AfterClass Method");
  }
}