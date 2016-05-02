package egen.usermanagement.service;

import java.util.HashMap;

import com.google.gson.Gson;

import spark.Response;
import spark.ResponseTransformer;

/*
 * JSON Transformer an implementation of Spark’s ResponseTransformer interface.
 * It allows you to convert response objects to other formats like JSON. 
 */
public class JsonTransformer implements ResponseTransformer {
	
	private Gson gson = new Gson();		
	 
    @Override
    public String render(Object model) {
    	if (model instanceof Response) {
            return gson.toJson(new HashMap<>());
        }
        return gson.toJson(model);
    }

}
