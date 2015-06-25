package ficha2_LI41N_14_15;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ruben Gomes on 24/06/2015.
 */
public class TestImplementations {

    static final Implementations  _implementations = new Implementations();
    static List<Classroom> classrooms;

    @BeforeClass
    public static void setClassRooms(){
        classrooms = Arrays.asList(
                new Classroom("LS",getStudentsForLS),
                new Classroom("MPD",getStudentsForMPD),
                new Classroom("PI",getStudentsForPI),
                new Classroom("PC",getStudentsForPC)
        );
    }


    static  List<Student> getStudentsForPC =
        Arrays.asList(
                    new Student(39367,"Rúben",4000000,1992),
                    new Student(23984,"Sílvio",10000000,1973)

                );

    static  List<Student> getStudentsForLS =
            Arrays.asList(
                    new Student(39367,"Filipe",4000000,1992),
                    new Student(23984,"Humberto",10000000,1973)

            );

    static  List<Student> getStudentsForMPD =
        Arrays.asList(
                new Student(39367,"João Pedro",4000000,1992),
                new Student(23984,"Manuel",10000000,1973),
                new Student(12345,"Zé Carlos",300000,1994)
        );

    static  List<Student> getStudentsForPI =
        Arrays.asList(
                new Student(39367,"Rúben Gomes",4000000,1992),
                new Student(23984,"Roberto",10000000,1973),
                new Student(12345,"Zé Manel",305000,1994),
                new Student(45632,"Diogo",4500000,1990)
        );

    //a
    @Test
    public void testShouldGetClassPI(){

        int maxNrOfStudents = 3;

        Stream<Classroom> classPi = _implementations.overCrowdedClass(classrooms.stream(),maxNrOfStudents);

        Classroom pi = classPi.findFirst().get();


        assertEquals("PI", pi.id);
    }

    @Test
    public void testShouldGetClassMPDandPI(){
        int maxNrOfStudents = 2;

        Stream<Classroom> classes = _implementations.overCrowdedClass(classrooms.stream(),maxNrOfStudents);

        List<Classroom> classesList = classes.collect(toList());


        assertEquals("MPD", classesList.get(0).id);
        assertEquals("PI", classesList.get(1).id);
    }

    //b

    @Test
    public void testShouldGetPI_biggestClass(){

        Classroom biggest = _implementations.biggestClass(classrooms.stream());

        assertEquals("PI",biggest.id);
    }

    @Test
    public void testShouldGetPI_biggestClassWithReduce(){
        Classroom biggest = _implementations.biggestClassWithReduce(classrooms.stream());

        assertEquals("PI", biggest.id);
    }

    @Test
    public void testShouldGetPI_biggestClassWithMax(){
        Classroom biggest = _implementations.biggestClassWithMax(classrooms.stream());

        assertEquals("PI", biggest.id);
    }

    //c

    @Test
    public void testShouldGetYoungestStudent(){
        String youngest = _implementations.youngestStudent(classrooms.stream());

        assertEquals("Zé Carlos",youngest);
    }


    //d
    @Test
    public void testClassesByNrOfStudents(){

        Map<Integer,List<Classroom>> classesByNrOfStudents =
                _implementations.classesByNrOfStudents(classrooms.stream());

        //System.out.println(classesByNrOfStudents);
        classesByNrOfStudents.entrySet().stream()
                .forEach((entrySet)->{
                    System.out.printf("Classes with nr of Students = %d \n", entrySet.getKey());
                    entrySet.getValue().stream()
                            .forEach(System.out::println);
                });
    }


    @Test
    public void testClassesByNrOfStudentsWithMapping(){
        Map<Integer,List<Classroom>> classesByNrOfStudents =
                _implementations.classesByNrOfStudentsWithMapping(classrooms.stream());

        //System.out.println(classesByNrOfStudents);
        classesByNrOfStudents.entrySet().stream()
                .forEach((entrySet)->{
                    System.out.printf("Classes with nr of Students = %d \n", entrySet.getKey());
                    entrySet.getValue().stream()
                            .forEach(System.out::println);
                });
    }

    //e
    @Test
    public void classesIdByNrOfStudents(){
        Map<Integer,List<String>> classesIdByNrOfStudents =
                _implementations.classesIdByNrOfStudents(classrooms.stream());

        //System.out.println(classesIdByNrOfStudents);
        classesIdByNrOfStudents.entrySet().stream()
                .forEach((entrySet)->{
                    System.out.printf("Classes with nr of Students = %d \n", entrySet.getKey());
                    entrySet.getValue().stream()
                            .forEach(System.out::println);
                });
    }

    //f

    @Test
    public void studentsNameByBirthYears(){
        Map<Integer,List<String>> studentsNameByBirthYear =
                _implementations.studentsNameByBirthYear(classrooms.stream());

        System.out.println(studentsNameByBirthYear);
        /*studentsNameByBirthYear.entrySet().stream()
                .forEach((entrySet)->{
                    System.out.printf("Students birth -> %d \n", entrySet.getKey());
                    entrySet.getValue().stream()
                            .forEach(System.out::println);
                });
                */
    }


    //4
    @Test
    public void testServiceWrapper(){


        ServiceWrapper<String> serv = new ServiceWrapper<>(new PureService<>());

        serv.addSubscriber(
                elem -> System.out.println("Succeeded with " + elem),
                excep -> System.out.println("bhaaaa")
        );
        serv.start();

    }

}





