package ficha2_LI41N_14_15;

import java.util.function.Consumer;

/**
 * Created by Ruben Gomes on 24/06/2015.
 */
public class ServiceWrapper<T> {


    //4.1
    private PureService<T> pureService;


    public ServiceWrapper(PureService<T> pureService){
        this.pureService = pureService;

    }

    public void addSubscriber(Consumer<T> success, Consumer<Exception> err ){
        pureService.addSubscriber(new Subscriber<T>() {
            @Override
            public void onComplete(T elem) {
                success.accept(elem);
            }

            @Override
            public void onException(Exception elem) {
                err.accept(elem);
            }
        });

    }

    public void start(){
       pureService.start();
    }

    public SubscriberOnExceptionBuilder<T> onComplete(Consumer<T> success){
        this.addSubscriber(success,e->{});
        return new SubscriberOnExceptionBuilder<>(this);
    }

    public void onException(Consumer<Exception> err){
        this.addSubscriber(e->{},err);
    }


}
