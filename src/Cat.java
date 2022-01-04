/**Cat represents a cat with attributes age, and name, and a local
 *path to an image of this cat.
 *
 * Abstract representation(this) Cat.getAge() is the age of this, Cat.getName() is the name of this,
 * Cat.getPath() is the path of this
 * */

public class Cat{

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
    public Cat(double age, String name, String path){
        this.age = age;
        this.name = name;
        this.path = path;
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
