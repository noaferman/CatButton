import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/** This represents a CatFinder, which simulates finding a cat from a database.*/
public class CatFinderSol {
    private ArrayList<CatSol> cats;

    /** Constructs a CatFinder from cats.txt
     *
     * @spec.modifies this
     * */
    public CatFinderSol() throws FileNotFoundException {
        cats = new ArrayList<>();
        Scanner s = new Scanner(new File("src/cats.txt"));
        while(s.hasNextLine()){
           double age = s.nextDouble();
           String name = s.next();
           String path = s.next();
           CatSol temp = new CatSol(age, name,path);
           this.cats.add(temp);
        }
    }

    /** Returns the given cat objct if it exists, otherwise, returns null
     *
     * @param {String} name, the name of the cat
     * @returns If found, returns cat. Otherwise, returns an impossible Cat.
     * */
    public CatSol findCat(String name){
        for(CatSol cat : this.cats){
            if(cat.getName().equals(name)) return cat;
        }
        return null;
    }

    /**Checks if cat exists in this
     *
     * @param {String} name, the name of the cat
     * @returns {boolean}  true if cat exists in this, false otherwise
     * */
    public boolean exists(String name){
        for(CatSol cat : this.cats){
            if(cat.getName().equals(name)) return true;
        }
        return false;
    }

    /** Returns all Cats in this
     *
     * @returns {ArrayList<Cat>}, that is the Cats in this.
     * */
    public ArrayList<CatSol> getCats(){
        //Returning the field directly has representation exposure as ArrayLists use
        //reference semantics. Tbus, returning a reference allows clients to modify the internal
        //state of CatFinder.
        return cats;
    }


}
