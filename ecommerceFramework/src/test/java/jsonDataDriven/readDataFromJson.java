package jsonDataDriven;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class readDataFromJson {
	public static void main(String[] args) throws ParseException {
//		step 1:parse json physical file into java object using json parse class
		JSONParser parser=new JSONParser();
		Object obj=parser.parse("/ecommerceFramework/configAppData/commonJsonData.json");
		
        //step 2 : convert java object into jsonObject using casting
		JSONObject map=(JSONObject) obj;
		//step 3 : get the value from json file using key..
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOut"));

		
	}

}
