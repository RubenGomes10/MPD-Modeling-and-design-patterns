package exame1_14_15.querys;

import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;


/**
 * Created by Ruben Gomes on 26/06/2015.
 */
public class Implementations {

    //a
    public IAccount highestAmountWithMax(Stream<IClient> client){
        return client
                .flatMap(IClient::getAccs)
                .max(comparingDouble(IAccount::getAmmount))
                .get();
    }

    public IAccount highestAmountWithCollect(Stream<IClient> client){
        return client
                .flatMap(IClient::getAccs)
                .collect(maxBy(comparingDouble(IAccount::getAmmount)))
                .get();
    }

    //b
    public LongStream totalAmountPerClientV1(Stream<IClient> client){
            List<Long> totalAmountPerClient =
                    client.collect(
                            mapping(
                                    (IClient c) -> c.getAccs().collect(summingLong(IAccount::getAmmount)),
                                    toList()
                            )
                    );
        return totalAmountPerClient.stream().mapToLong((l)->l);
    }

    public LongStream totalAmountPerClientV2(Stream<IClient> client){
        return client.mapToLong((IClient c) -> c.getAccs().collect(summingLong(IAccount::getAmmount)));
    }

    //c
    public String clientWithMoreMoney(Stream<IClient> client){
        return client
                .collect(maxBy(comparing((IClient c) -> c.getAccs().collect(summingLong(IAccount::getAmmount)))))
                .get()
                .getName();
    }

    //d
    public Map<Integer,List<String>> clientNameByNrOfTransactions(Stream<IClient> client){
        return client
                .collect(groupingBy(
                            (IClient c)-> (int) c.getAccs().flatMap(IAccount::getTrxs).count(),
                            mapping(IClient::getName,toList())
                        )
                );
    }

    //e
    public Map<Integer,Double> trxsValueAveragePerMonth(Stream<IClient> client){
        return client
                .flatMap(IClient::getAccs)
                .flatMap(IAccount::getTrxs)
                .collect(groupingBy(ITransaction::getMonth,averagingLong(ITransaction::getValue)));
    }


}
