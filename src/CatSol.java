/**Cat represents a cat with attributes age, and name, and a local
*path to an image of this cat.
* */

public class CatSol {
    private double age;
    private String name;
    private String path;

    /**constructs a new cat with given age, name, and path for an image
     *
     * @param {double} age
     * @param {String} name
     * @param {String} path
     *
    * @spec.modifies this; sets age, name, and path
    * */
    public CatSol(double age, String name, String path){
        this.age = age;
        this.name= name;
        this.path=path;
    }

    /**@returns the age of this Cat */
    public double getAge(){
        return this.age;
    }

    /**@returns the name of this Cat */
    public String getName(){
        return this.name;
    }

    /**@returns the path of this Cat */
    public String getPath(){
        return this.path;
    }
}
