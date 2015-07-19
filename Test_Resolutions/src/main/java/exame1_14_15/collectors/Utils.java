package exame1_14_15.collectors;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/**
 * Created by Ruben Gomes on 19/07/2015.
 */
public class Utils {

    public static <T> Collector<T,?,Integer> summingInt(ToIntFunction<? super T> mapper){
        Supplier<Integer> supplier = () -> 0;
        BiConsumer<Integer,T> accumulator = (accumulated,nextValue) -> accumulated+= mapper.applyAsInt(nextValue);
        BinaryOperator<Integer> combiner = (res1,res2) -> res1+= res2;

        return new CollectorImpl<>(supplier,accumulator,combiner);
    }
}
