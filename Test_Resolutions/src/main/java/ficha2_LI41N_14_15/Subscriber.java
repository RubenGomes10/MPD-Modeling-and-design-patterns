package ficha2_LI41N_14_15;

/**
 * Created by Ruben Gomes on 24/06/2015.
 */
public interface Subscriber<T> {

    void onComplete(T elem);
    void onException(Exception elem);
}
