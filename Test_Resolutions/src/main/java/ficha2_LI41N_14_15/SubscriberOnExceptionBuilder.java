package ficha2_LI41N_14_15;

import java.util.function.Consumer;

/**
 * Created by Ruben Gomes on 25/06/2015.
 */
public class SubscriberOnExceptionBuilder<T> {

    private ServiceWrapper<T> serviceWrapper;

    public SubscriberOnExceptionBuilder(ServiceWrapper<T> serviceWrapper) {
        this.serviceWrapper = serviceWrapper;
    }

    public void onException(Consumer<Exception> err){
        serviceWrapper.addSubscriber(e->{},err);
    }
}
