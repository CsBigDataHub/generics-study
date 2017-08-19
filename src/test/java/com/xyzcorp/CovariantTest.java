package com.xyzcorp;

import com.xyzcorp.people.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CovariantTest {


    public void processCovariantList(List<? extends American> americans) {
        Object object = americans.get(0);
        Person person = americans.get(0);
        NorthAmerican northAmerican = americans.get(0);
        American american = americans.get(0);

        //only a null
        americans.add(null);
    }

    //11. Process Covariant List
    @Test
    public void testCovariantAmericanList() throws Exception {
        List<NorthCarolinian> americans = new ArrayList<>();
        processCovariantList(americans);
    }

    //12. Process Covariant Assignment
    @Test
    public void testCovariantAssignment() throws Exception {
        List<? extends American> people = new ArrayList<Raleighite>();
        Object object = people.get(0);
        Person person = people.get(0);
        NorthAmerican northAmerican = people.get(0);
        American american = people.get(0);


        //NorthCarolinian northCarolinian= people.get(0);
        //Raleighite ralieghite= people.get(0);

//        people.add(new Object());
//        people.add(new Person());
//        people.add(new NorthAmerican());
//        people.add(new American());
//        people.add(new NorthCarolinian());
//        people.add(new Raleighite());
        people.add(null); //special case
    }

    public void processCovariantPersonList(List<? extends Person> people) {
        Object object = people.get(0);
        Person person = people.get(0);

//        people.add(new Person("Justin", "Bieber"));
        people.add(null);
    }

    //13. Process Covariant Assignment
    @Test
    public void testCovariantPersonList() throws Exception {
        List<? extends Person> people = Arrays.<Raleighite>asList(new Raleighite(), new Raleighite());
        processCovariantPersonList(people);
    }

    //14. Process Covariant Assignment
    @Test
    public void testMixMatchedPersonList() throws Exception {
        List<? extends Raleighite> raleighites = Arrays.asList(new Raleighite(), new Raleighite());
        List<? extends American> people = raleighites;
        processCovariantPersonList(people);
    }

    public void processCovariantObjectList(List<? extends Object> people) {
        Object object = people.get(0);
        //Person person = people.get(0);
        //Raleighite raleighite = people.get(0);

        people.add(null);
    }

    //15. Process Covariant Assignment with Object List
    @Test
    public void testProcessCovariantObjectList() throws Exception {
        List<?> objects = Arrays.<Raleighite>asList(new Raleighite(), new Raleighite());
        List<?> objects2 = Arrays.<Object>asList(new Object(), new Object());
        processCovariantObjectList(objects);
        processCovariantObjectList(objects2);
    }
}