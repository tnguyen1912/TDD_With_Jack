import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Edge cases:
 * Numbers w/ length >1 - 33, 567 - DONE
 * Multiple same numbers - 3,3,3 - DONE
 *
 * Solvable with regex:
 * Decimals - 1.2
 * Negative numbers - "-1"
 * Leading zero - "000001" vs "1" should evaluate to be the same
 * Special characters - !@#$%^&*ACB " " - Anything that is not a number - treat as 0 and sort
 *
 * String is too big - "983713719237189236172392871231283123..."
 * Passing words - "Nine"
 * Fractions - 1/2, one and half, three halves
 */

/**
 * Leading Zeros
 * If number is zero - remove it from string inside the comparator
 *      and check again
 * Still returning the same string with zeroes after sorting
 *
 * Negatives
 * Check if current and next are positive or negative
 * If current[0] == "-" and next[0] = a number -> next is bigger and vice versa
 * If both negatives -> use regular logic but switch true & false
 *
 * Decimals
 * 0.1000 vs 0.1 - should be identical
 * 0.1001 > 0.1
 * 0.0001 < 0.1
 * length is irrelevant AFTER the decimal
 * If number before decimal is NOT equal - numbers after decimal
 *          is irrelevant - run compare to on portion before decimal.
 * If numbers before decimal are equal - run compare on whole string.
 * Write method to compare lengths BEFORE the decimal -- if equal go
 *          to (current.compareTo(next) > 0).
 */

public class TestMain {
    //this is available for all tests
    Main main = new Main();

    @Before
    //this runs before every test

    @Test
    public void initialTest(){
        //given
        String[] given = {"9","5","1"};
        String[] expected = {"1","5","9"};
        //when
        String[] actual = main.sortArr(given);

        //then
        Assert.assertArrayEquals(expected,actual);

    }



    @Test
    public void testLongerLengthNumbers(){
        //given
        String[] given = {"9","15","2"};
        String[] expected = {"2","9","15"};
        //when
        String[] actual = main.sortArr(given);
        //then
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void testUsingMultipleSameNumbers(){
        //given
        String[] given = {"9","15","2","2","2"};
        String[] expected = {"2","2","2","9","15"};
        //when
        String[] actual = main.sortArr(given);
        //then
        Assert.assertArrayEquals(expected,actual);
    }

    //------------- TESTING SUB METHODS---------
    @Test
    public void testCurrentIsGreaterThanNext_WhenTrue(){
        //given
        String current = "9";
        String next = "5";
        //when
        Boolean result = main.currentIsGreaterThanNext(current,next);
        //then
        Assert.assertTrue(result);

    }

    @Test
    public void testCurrentIsGreaterThanNext_WhenCurrentIsSmaller(){
        //given
        String current = "5";
        String next = "9";
        //when
        Boolean result = main.currentIsGreaterThanNext(current,next);
        //then
        Assert.assertFalse(result);

    }

    @Test
    public void testCurrentIsGreaterThanNext_WhenNumbersAreEqual(){
        //given
        String current = "5";
        String next = "5";
        //when
        Boolean result = main.currentIsGreaterThanNext(current,next);
        //then
        Assert.assertFalse(result);

    }

    @Test
    public void testCurrentIsGreaterThanNext_WhenFirstIsLonger(){
        //given
        String current = "15";
        String next = "5";
        //when
        Boolean result = main.currentIsGreaterThanNext(current,next);
        //then
        Assert.assertTrue(result);

    }

    @Test
    public void testCurrentIsGreaterThanNext_WhenFirstIsShorter(){
        //given
        String current = "6";
        String next = "57";
        //when
        Boolean result = main.currentIsGreaterThanNext(current,next);
        //then
        Assert.assertFalse(result);

    }


}
