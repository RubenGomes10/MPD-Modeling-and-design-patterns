package ficha2_LI41N_14_15;

/**
 * Created by Ruben Gomes on 24/06/2015.
 */
public class Student {

    public final int nr;
    public final String name;
    public final long birthTimestamp;
    public final int birthYear;

    public Student(int nr , String name, long birthTimestamp, int birthYear){
        this.nr = nr;
        this.name = name;
        this.birthTimestamp = birthTimestamp;
        this.birthYear = birthYear;
    }

    @Override
    public String toString(){
        return " "+nr+" ," + name+ ","+ birthTimestamp+","+ birthYear;
    }
}
