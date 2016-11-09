package x3.benjamin.study.function;

import java.lang.FunctionalInterface;
import java.util.function.Consumer;

/**
 * Created by benjamin on 2016. 11. 5..
 */
@FunctionalInterface
public interface ThrowableConsumer<T> extends Consumer<T> {

    void acceptOrThrow(T t) throws Exception;

    @Override
    default void accept(T t) {
        try {
            acceptOrThrow(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
