package ficha2_LI41N_14_15;


import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Created by Ruben Gomes on 24/06/2015.
 */
public class Implementations {

    //a

    public Stream<Classroom> overCrowdedClass(Stream<Classroom> crs, int maxNrOfStudents){
        return crs.filter((_class)->_class.students.size() > maxNrOfStudents);
    }

    //b
    public Classroom biggestClass(Stream<Classroom> crs){
        return crs.collect(maxBy(comparing((Classroom c) -> c.students.size()))).get();
    }

    public Classroom biggestClassWithReduce(Stream<Classroom> crs){
        return crs
                .reduce(
                        (crs1, crs2) -> crs1.students.size() > crs2.students.size() ? crs1 : crs2).get();
    }

    public Classroom biggestClassWithMax( Stream<Classroom> crs){
        return crs.max(comparing((_class)->_class.students.size())).get();
    }


    //c

    public String youngestStudent(Stream<Classroom> crs){

        return crs.flatMap((_class) -> _class.students.stream())
                  .sorted(comparing(student->student.birthTimestamp))
                  .findFirst()
                  .get()
                  .name;
    }

    //d

    public Map<Integer,List<Classroom>> classesByNrOfStudents(Stream<Classroom> crs){
        return crs
                .collect(groupingBy((_class) -> _class.students.size()));
    }

    public Map<Integer,List<Classroom>> classesByNrOfStudentsWithMapping(Stream<Classroom> crs){

        return crs
                .collect(
                        groupingBy(
                                (Classroom c) -> c.students.size(),
                                mapping((Classroom c) -> c, toList())
                        )
                );
    }


    //e

    public Map<Integer,List<String>> classesIdByNrOfStudents(Stream<Classroom> crs){
        return crs.
                collect(
                        groupingBy(
                                (Classroom c) -> c.students.size(),
                                mapping((Classroom c) -> c.id,toList())

                        )
                );
    }


    //f

    public Map<Integer,List<String>> studentsNameByBirthYear(Stream<Classroom> crs){
        return crs
                .flatMap((_class) -> _class.students.stream())
                .collect(groupingBy((Student s)->s.birthYear,mapping((Student s)-> s.name,toList())));
    }
}
