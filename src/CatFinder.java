import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/** This represents a CatFinder, which simulates finding a cat from a database.
 *
 * Abstract representation(this) = ArrayList<Cat> is the directory of cats*/
public class CatFinder {

    private ArrayList<Cat> cats;

    /** Constructs a CatFinder from cats.txt
     *
     * @spec.modifies this
     * */
    public CatFinder() throws FileNotFoundException {
        cats = new ArrayList<>();
        Scanner s = new Scanner(new File("src/cats.txt"));
        while (s.hasNextLine()) {
            double age = s.nextDouble();
            String name = s.next();
            String path = s.next();
            Cat cat = new Cat(age, name, path);
            this.cats.add(cat);
        }
    }

    /** Returns the given cat objct if it exists, otherwise, returns null
     *
     * @param {String} name, the name of the cat
     * @returns If found, returns cat. Otherwise, returns an impossible Cat.
     * */
    public Cat findCat(String name){
        for (Cat cat : this.cats) {
            if (cat.getName().equals(name)) {
                return cat;
            }
        }
        return null;
    }

    /**Checks if cat exists in this
     *
     * @param {String} name, the name of the cat
     * @returns {boolean}  true if cat exists in this, false otherwise
     * */
    public boolean exists(String name){
        for (Cat cat : this.cats) {
            if (cat.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /** Returns all Cats in this
     *
     * @returns {ArrayList<Cat>}, that is the Cats in this.
     * */
    public ArrayList<Cat> getCats(){
        return cats;
    }


}
