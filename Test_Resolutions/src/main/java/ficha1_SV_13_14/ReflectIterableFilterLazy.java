package ficha1_SV_13_14;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Created by Ruben Gomes on 25/06/2015.
 */
public class ReflectIterableFilterLazy<T> extends ReflectIterableLazy<T> {

    private Predicate<T> pred;

    public ReflectIterableFilterLazy(Iterable<T> iterableSeq,Predicate<T> pred) {
        super(iterableSeq);
        this.pred = pred;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Iterator<T> prevIter = (Iterator<T>) iterableSeq.iterator();
            T curr;

            @Override
            public boolean hasNext() {
                if(curr!= null) return true;
                while(prevIter.hasNext()){
                    T preCurr = prevIter.next();
                    if(pred.test(preCurr)){
                        curr = preCurr;
                        System.out.println("Choose by predicate -" + curr);
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                T aux = curr;

                curr = null;
                return aux;
            }
        };
    }
}
