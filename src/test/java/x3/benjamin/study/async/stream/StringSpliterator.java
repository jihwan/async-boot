package x3.benjamin.study.async.stream;

import java.io.BufferedReader;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by benjamin on 2016. 11. 8..
 * <p>
 * http://www.popit.kr/java8-stream%EC%9D%98-parallel-%EC%B2%98%EB%A6%AC/
 * http://stackoverflow.com/questions/24511052/how-to-convert-an-iterator-to-a-stream
 * https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html
 * https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html
 */
public class StringSpliterator implements Spliterator<String> {

    private BufferedReader reader;

    public StringSpliterator(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        return false;
    }

    @Override
    public Spliterator<String> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return Spliterator.IMMUTABLE;
    }
}
