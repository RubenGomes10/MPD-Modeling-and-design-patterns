package ficha1_SV_13_14;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Created by Ruben Gomes on 25/06/2015.
 */
public class ReflectIterableLazy <T> implements ReflectIterable<T> {

    protected Iterable<?> iterableSeq;
    Predicate<T> pred;


    public ReflectIterableLazy(Iterable<T> iterableSeq){
        this.iterableSeq= iterableSeq;
    }

    @Override
    public ReflectIterable<T> filter(String fieldName, Object expected) {
        if(pred == null)
            pred = new ReflectPredicate<>(fieldName,expected);
        else
            pred = ReflectPredicate.and(pred, new ReflectPredicate<T>(fieldName,expected));
        return new ReflectIterableFilterLazy<>(this,pred);
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) iterableSeq.iterator();
    }


    public static <T> ReflectIterable<T> reflectLazy(Iterable<T> items){
        return new ReflectIterableLazy<>(items);
    }
}
