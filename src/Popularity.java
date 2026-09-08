import java.io.IOException;
import java.util.TreeSet;

//need to work  on this

public class Popularity {
        /**
     * Return the number of elements in people whose .eatery() value
     * is equal to parameter eatery
     * @param people is array of Person201 objects
     * @param eatery is the searched for string
     * @return the number of elements in people whose .eatery() value
     * is equal to eatery
     */
    public int countEateries(Person201[] people, String eatery) {
        int count = 0;
        for (Person201 p : people){
            if (p.eatery().equals(eatery)){
                count++;
            }
        }
        return count;
    }

    /**
     * Read the file specified by parameter, determine the unique
     * eatery values, and print the number of lines in the file/Person201
     * objects matching each of the unique eatery values. Eateries are in
     * alphabetical order, number of matches printed first, e.g., 
     * Prints the total number of People201 objects, which is
     * the same as the total of all the eatery values
     * 
     * @param filename is accessible with properly formatted data for Person201 objects
     * @throws IOException if file can't be read, rethrown from Person201Utilities
     */
    public void doWork(String filename) throws Exception{
        Person201[] people = Person201Utilities.read(filename);
        TreeSet<String> eateries = new TreeSet<>();
        for(Person201 p : people){
            eateries.add(p.eatery());
        }

        int total = 0;
        for(String eat : eateries){
            int count = countEateries(people, eat);
            total += count;
            System.out.printf("%d:\t%s\n",count,eat);
        }
        System.out.printf("--------\ntotal = %d\n",total);
        System.out.printf("total # eateries = %d\n",eateries.size());
    }
    public static void main(String[] args) throws Exception{
        CountEateries eats = new CountEateries();
        String fname = "data/foodlarge.txt";
        eats.doWork(fname);
    }

}
