package ficha1_SV_13_14;

/**
 * Created by Ruben Gomes on 25/06/2015.
 */
public interface ReflectIterable <T> extends Iterable<T> {
    ReflectIterable<T> filter (String fieldName,Object expected);
}
