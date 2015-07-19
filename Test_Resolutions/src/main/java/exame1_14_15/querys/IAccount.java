package exame1_14_15.querys;

import java.util.stream.Stream;

/**
 * Created by Ruben Gomes on 26/06/2015.
 */
public interface IAccount {

    String getId();
    long getAmmount();
    Stream<ITransaction> getTrxs();
}
