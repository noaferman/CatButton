
import com.google.gson.Gson;
import spark.Spark;
import spark.*;

import java.io.FileNotFoundException;
public class SparkServer {

    public static void main(String[] args) throws FileNotFoundException {
        CORSFilter corsFilter = new CORSFilter();
        corsFilter.apply();
        // The above two lines help set up some settings that allow the
        // React application to make requests to the Spark server, even though it
        // comes from a different server.
        // You should leave these two lines at the very beginning of main().

        //Create instance of Map and Gson object
        CatFinder cats = new CatFinder();
        Gson gson = new Gson();

        //handles paths of form "/find-cat?name=_____"
        Spark.get("/find-cat", new Route(){
            @Override
            public Object handle(Request request, Response response)throws Exception{
                String name = request.queryParams("name");

                try{
                    if(cats.exists(name)) {
                        Cat cat = cats.findCat(name);
                        return new Gson().toJson(cat);
                    }else{
                        return " ";
                    }
                }catch(IllegalArgumentException e){ // findPath throws IllegalArgumentException if null or not in Map
                    Spark.halt(400, "Error");
                    return "";
                }
            }
        });

        //to get building names
        Spark.get("/get-cats", new Route(){
            @Override
            public Object handle(Request request, Response response) throws Exception{
                return new Gson().toJson(cats.getCats());
            }
        });
    }




}
