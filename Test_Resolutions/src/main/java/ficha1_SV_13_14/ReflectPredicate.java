package ficha1_SV_13_14;

import java.lang.reflect.Field;
import java.util.function.Predicate;

/**
 * Created by Ruben Gomes on 25/06/2015.
 */
public class ReflectPredicate<T> implements Predicate<T> {


    private final String fieldName;
    private final Object expected;

    public ReflectPredicate(String fieldName, Object expected){
        this.fieldName = fieldName;
        this.expected = expected;
    }


    @Override
    public boolean test(T t) {
        Field field ;
        Object value = null;
        try {
            field = t.getClass().getDeclaredField(fieldName);
            value  = field.get(t);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return value.equals(expected);
    }

    public static <T> Predicate<T> and(Predicate<T> p1, Predicate<T> p2){
        return (t) -> p1.test(t) && p2.test(t);

    }
}
