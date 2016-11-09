package x3.benjamin.study.async;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by benjamin on 2016. 11. 7..
 */
public class StreamExample1 {

    @Test
    public void test() {
        List<Integer> integerList = Stream.of("1", "2", "3", "4", "5", "6")
                .map(numberStr -> Integer.valueOf(numberStr))
                .collect(Collectors.toList());

        assertThat(integerList.size(), is(6));
    }
}
