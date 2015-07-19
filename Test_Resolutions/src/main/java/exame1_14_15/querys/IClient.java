package exame1_14_15.querys;

import exame1_14_15.querys.IAccount;

import java.util.stream.Stream;

/**
 * Created by Ruben Gomes on 26/06/2015.
 */
public interface IClient {

    String getId();
    String getName();
    Stream<IAccount> getAccs();
}
