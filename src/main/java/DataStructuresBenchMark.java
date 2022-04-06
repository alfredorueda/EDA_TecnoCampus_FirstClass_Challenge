import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class DataStructuresBenchMark {

    // La octava iteración provoca este error en mi entorno de JVM :)
    // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    public static final int NUM_ITERATIONS = 8;

    public static void main(String[] args) {

        int numPeople = 1;

        for (int i = 0; i < NUM_ITERATIONS; i++) {

            numPeople = numPeople * 10;

            System.out.println();
            System.out.println("--------------------");
            System.out.println();

            System.out.println("Running test with " + numPeople + " people");

            runBechMark(numPeople);

        }

    }

    private static void runBechMark(int numPeople) {

        Person.resetCurrentId();

        ArrayList<Person> peopleList = createPeople(numPeople);

        // Worst case: O(n) Find the last element
        Person personToFind = peopleList.get(numPeople-1);

        // Collections.shuffle(peopleList);

        HashMap<Long, Person> peopleMap = createPeopleMap(peopleList);

        testFindPersonPerformance(personToFind, peopleList, peopleMap);
    }

    private static void testFindPersonPerformance(Person personToFind, ArrayList<Person> peopleList, HashMap<Long, Person> peopleMap) {

        System.out.println("Starting testFindPersonPerformance...");

        long startTime = System.nanoTime();

        findPersonInList(personToFind, peopleList);

        long elapsedNanos = System.nanoTime() - startTime;

        // 1 second = 1_000_000_000 nano seconds
        double elapsedTimeInSecond = (double) elapsedNanos / 1_000_000_000;

        System.out.println("Time elapsed to find a person in the ArrayList: "
                + elapsedNanos + " nanos | " + elapsedTimeInSecond + " seconds");

        startTime = System.nanoTime();

        findPersonInMap(personToFind, peopleMap);

        elapsedNanos = System.nanoTime() - startTime;

        // 1 second = 1_000_000_000 nano seconds
        elapsedTimeInSecond = (double) elapsedNanos / 1_000_000_000;

        System.out.println("Time elapsed to find a person in the HashMap: "
                + elapsedNanos + " nanos | " + elapsedTimeInSecond + " seconds");
    }

    private static void findPersonInMap(Person personToFind, HashMap<Long, Person> peopleMap) {
        Person person = peopleMap.get(personToFind.getId());

        assert person.equals(personToFind);

        System.out.println("findPersonInMap: person located! " + person);

    }

    private static void findPersonInList(Person personToFind, ArrayList<Person> peopleList) {

        for (Person person: peopleList) {
            if (person.equals(personToFind)) {
                System.out.println("findPersonInList: person located! " + person);
                return;
            }
        }

        assert false;
    }

    private static HashMap<Long, Person> createPeopleMap(ArrayList<Person> peopleList) {
        HashMap<Long, Person> peopleMap = new HashMap<>();

        for (Person person: peopleList) {
            peopleMap.put(person.getId(), person);
        }
        return peopleMap;
    }

    private static ArrayList<Person> createPeople(int numPeople) {
        ArrayList<Person> peopleList = new ArrayList<>(numPeople);

        for (int i = 0; i < numPeople; i++) {
            peopleList.add(new Person());
        }
        return peopleList;
    }

}
