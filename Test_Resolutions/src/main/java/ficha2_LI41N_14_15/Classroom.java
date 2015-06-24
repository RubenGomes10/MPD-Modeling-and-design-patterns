package ficha2_LI41N_14_15;

import java.util.List;

/**
 * Created by Ruben Gomes on 24/06/2015.
 */
public class Classroom {

    public final String id ;
    public final List<Student> students;

    public Classroom(String id, List<Student> students){
        this.id = id;
        this.students = students;
    }

    @Override
    public  String toString(){
        return id + " Class with "+students.size()+" students";
    }
}
