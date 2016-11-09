package x3.benjamin.study.async;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Created by benjamin on 2016. 11. 9..
 */
public class StreamExample4 {

    private String[] numbers = {"1", "2", "3", "4", "5", "6"};

    @Test
    public void test() {
        List<Integer> integerList = Stream.of(numbers)
                .map(numberStr -> Integer.valueOf(numberStr))
                .collect(Collectors.toList());
        //Collectors.toCollection(LinkedList::new))

        assertThat(integerList, instanceOf(List.class));
//        assertThat(line, is("1,2,3,4,5,6"));
    }
}
