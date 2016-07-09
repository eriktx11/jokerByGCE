package test;
import com.example.Jocker;
import org.junit.Test;

/**
 * Created by erikllerena on 7/8/16.
 */
public class TestJoker {
    @Test
    public void test() {
        Jocker joker = new Jocker();
        assert joker.getJoke().length() != 0;
    }

}