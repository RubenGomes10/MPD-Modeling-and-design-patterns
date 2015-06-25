package ficha1_SV_13_14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Created by Ruben Gomes on 25/06/2015.
 */
public class ReflectIterableEager<T> implements ReflectIterable<T> {

    Iterable<?> iterableSeq;
    Predicate<T> pred;

    public ReflectIterableEager(Iterable<T> iterableSeq){
        this.iterableSeq= iterableSeq;
    }


    @Override
    public ReflectIterable<T> filter(String fieldName, Object expected) {
        ArrayList<T> items = new ArrayList<>();
        if(pred == null)
            pred = new ReflectPredicate<>(fieldName,expected);
        else{
            pred = ReflectPredicate.and(pred,new ReflectPredicate<T>(fieldName,expected));
        }
        for(T t : this){
            System.out.println(t);
                if(pred.test(t)){
                    items.add(t);
                }
        }
        System.out.println("-----Final Select-----");
        return reflectEager(items);
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>)iterableSeq.iterator();
    }


    public static <T> ReflectIterable<T> reflectEager(Iterable<T> items){
        return new ReflectIterableEager<>(items);
    }
}
