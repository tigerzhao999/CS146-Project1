import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {


    long start;
    long end;
    Set set1;
    Set set2;
@BeforeEach
    public void setUp(){
    set1 = new Set();
    set2 = new Set();
    }
@Test
public void unionTestFunction(){
        start = System.currentTimeMillis();
        set1.add("2");
        set1.add("3");
        set1.add("4");
        set2.add("4");
        set2.add("5");
        Set unionSet = set1.union(set2);
        assertEquals(true,unionSet.exists("2"));
        assertEquals(true,unionSet.exists("3"));
        assertEquals(true,unionSet.exists("4"));
        assertEquals(true,unionSet.exists("5"));
        assertEquals(false,unionSet.exists("6"));
        end = System.currentTimeMillis();
        System.out.println("Time for Union:" + (end - start));
    }
@Test
    public void intersectTestFunction(){
        start = System.currentTimeMillis();
        set1.add("2");
        set1.add("3");
        set1.add("4");
        set2.add("4");
        set2.add("5");
        Set intersectSet = set1.intersect(set2);
        assertEquals(false,intersectSet.exists("2"));
        assertEquals(false,intersectSet.exists("3"));
        assertEquals(true,intersectSet.exists("4"));
        assertEquals(false,intersectSet.exists("5"));
        assertEquals(false,intersectSet.exists("6"));
        end = System.currentTimeMillis();
        System.out.println("Time for Union:" + (end - start));
    }
@Test
    public void testAddAndCountFunction(){
        assertEquals(0,set1.count());
        start = System.currentTimeMillis();
        set1.add("0");
        end = System.currentTimeMillis();
        System.out.println("Time for add:" + (end - start));
        assertEquals(1,set1.count());
        set1.add("0");
        assertEquals(1,set1.count());
        set1.add("0");
        assertEquals(1,set1.count());
    }
@Test
    public void testRemoveFunction(){
        assertEquals(0,set1.count());
        start = System.currentTimeMillis();
        set1.add("0");
        set1.remove("0");
        end = System.currentTimeMillis();
        assertEquals(0,set1.count());
        System.out.println("Time for one add and one remove:" + (end - start));
        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.remove("3");
        assertEquals(2,set1.count());
        set1.remove("3");
        assertEquals(2,set1.count());
        set1.remove("2");
        assertEquals(1,set1.count());
        set1.remove("1");
        assertEquals(0,set1.count());
    }
    @Test
    public void test1000(){
        int testNumber = 1000;
        start = System.currentTimeMillis();
        for(int i = 0; i < testNumber; i++){
            set1.add(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("Time for adding " + testNumber + " elements :"+  (end - start) +"ms");

        start = System.currentTimeMillis();
        MyNode nodeSearch = set1.search("1");
        assertEquals("1",nodeSearch.getData());
        end = System.currentTimeMillis();
        System.out.println("Time for search with " + testNumber + " elements "+ (end - start) +"ms");

        for(int i = 0; i <= testNumber; i++){
            set2.add(String.valueOf(i));
        }
        start = System.currentTimeMillis();
        Set unionSet = set1.union(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for union with " + testNumber + " elements "+ (end - start) +"ms");
        //intersect test
        start = System.currentTimeMillis();
        Set intersectSet = set1.intersect(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for intersect with " + testNumber + " elements "+ (end - start) +"ms");
    }
    @Test
    public void test10000(){
        int testNumber = 10000;
        //addtest
        start = System.currentTimeMillis();
        for(int i = 0; i < testNumber; i++){
            set1.add(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("Time for adding " + testNumber + " elements :"+  (end - start) +"ms");
        //search test
        start = System.currentTimeMillis();
        MyNode nodeSearch = set1.search("1");
        assertEquals("1",nodeSearch.getData());
        end = System.currentTimeMillis();
        System.out.println("Time for search with " + testNumber + " elements "+ (end - start) +"ms");

        for(int i = 0; i <= testNumber; i++){
            set2.add(String.valueOf(i));
        }
        //union test
        start = System.currentTimeMillis();
        Set unionSet = set1.union(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for union with " + testNumber + " elements "+ (end - start) +"ms");
        //intersect test
        start = System.currentTimeMillis();
        Set intersectSet = set1.intersect(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for intersect with " + testNumber + " elements "+ (end - start) +"ms");

    }

    @Test
    public void test25000(){
        int testNumber = 25000;
        //addtest
        start = System.currentTimeMillis();
        for(int i = 0; i < testNumber; i++){
            set1.add(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("Time for adding " + testNumber + " elements :"+  (end - start) +"ms");
        //search test
        start = System.currentTimeMillis();
        MyNode nodeSearch = set1.search("1");
        assertEquals("1",nodeSearch.getData());
        end = System.currentTimeMillis();
        System.out.println("Time for search with " + testNumber + " elements "+ (end - start) +"ms");

        for(int i = 0; i <= testNumber; i++){
            set2.add(String.valueOf(i));
        }
        //union test
        start = System.currentTimeMillis();
        Set unionSet = set1.union(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for union with " + testNumber + " elements "+ (end - start) +"ms");
        //intersect test
        start = System.currentTimeMillis();
        Set intersectSet = set1.intersect(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for intersect with " + testNumber + " elements "+ (end - start) +"ms");

    }

    @Test
    public void test50k(){
        int testNumber = 50000;
        //addtest
        start = System.currentTimeMillis();
        for(int i = 0; i < testNumber; i++){
            set1.add(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("Time for adding " + testNumber + " elements :"+  (end - start) +"ms");
        //search test
        start = System.currentTimeMillis();
        MyNode nodeSearch = set1.search("1");
        assertEquals("1",nodeSearch.getData());
        end = System.currentTimeMillis();
        System.out.println("Time for search with " + testNumber + " elements "+ (end - start) +"ms");

        for(int i = 0; i <= testNumber; i++){
            set2.add(String.valueOf(i));
        }
        //union test
        start = System.currentTimeMillis();
        Set unionSet = set1.union(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for union with " + testNumber + " elements "+ (end - start) +"ms");
        //intersect test
        start = System.currentTimeMillis();
        Set intersectSet = set1.intersect(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for intersect with " + testNumber + " elements "+ (end - start) +"ms");
    }

    @Test
    public void test75k(){
        int testNumber = 75000;
        //addtest
        start = System.currentTimeMillis();
        for(int i = 0; i < testNumber; i++){
            set1.add(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("Time for adding " + testNumber + " elements :"+  (end - start) +"ms");
        //search test
        start = System.currentTimeMillis();
        MyNode nodeSearch = set1.search("1");
        assertEquals("1",nodeSearch.getData());
        end = System.currentTimeMillis();
        System.out.println("Time for search with " + testNumber + " elements "+ (end - start) +"ms");
        for(int i = 0; i <= testNumber; i++){
            set2.add(String.valueOf(i));
        }
        //union test
        start = System.currentTimeMillis();
        Set unionSet = set1.union(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for union with " + testNumber + " elements "+ (end - start) +"ms");
        //intersect test
        start = System.currentTimeMillis();
        Set intersectSet = set1.intersect(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for intersect with " + testNumber + " elements "+ (end - start) +"ms");
    }

    @Test
    public void test100k(){
        int testNumber = 100000;
        //addtest
        start = System.currentTimeMillis();
        for(int i = 0; i < testNumber; i++){
            set1.add(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("Time for adding " + testNumber + " elements :"+  (end - start) +"ms");
        //search test
        start = System.currentTimeMillis();
        MyNode nodeSearch = set1.search("1");
        assertEquals("1",nodeSearch.getData());
        end = System.currentTimeMillis();
        System.out.println("Time for search with " + testNumber + " elements "+ (end - start) +"ms");

        for(int i = 0; i <= testNumber; i++){
            set2.add(String.valueOf(i));
        }
        //union test
        start = System.currentTimeMillis();
        Set unionSet = set1.union(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for union with " + testNumber + " elements "+ (end - start) +"ms");
        //intersect test
        start = System.currentTimeMillis();
        Set intersectSet = set1.intersect(set2);
        end = System.currentTimeMillis();
        System.out.println("Time for intersect with " + testNumber + " elements "+ (end - start) +"ms");
    }

}
