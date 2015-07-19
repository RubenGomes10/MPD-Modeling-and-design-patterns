package exame1_14_15.collectors;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by Ruben Gomes on 19/07/2015.
 */
public class CollectorImpl<T,A> implements Collector<T,A,A> {


    Supplier<A> supplier;
    BiConsumer<A,T> accumulator;
    BinaryOperator<A> combiner;
    Function<A,A> finisher;
    Set<Characteristics> characteristics;

    public CollectorImpl(Supplier<A> supplier, BiConsumer<A,T> accumulator,BinaryOperator<A> combiner){
        this.supplier = supplier;
        this.accumulator = accumulator;
        this.combiner = combiner;
        this.finisher = item -> item;
        this.characteristics = new HashSet<>();
        this.characteristics.add(Characteristics.IDENTITY_FINISH);
    }

    @Override
    public Supplier<A> supplier() {
        return supplier;
    }

    @Override
    public BiConsumer<A, T> accumulator() {
        return accumulator;
    }

    @Override
    public BinaryOperator<A> combiner() {
        return combiner;
    }

    @Override
    public Function<A, A> finisher() {
        return finisher;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }
}
