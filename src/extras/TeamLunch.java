
import java.util.*;

public class TeamLunch {

 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 // RETURN AN EMPTY MATRIX IF PREFERRED LUNCH IS NOT FOUND
 public String[][] matchLunches(String[][] lunchMenuPairs, 
                         String[][] teamCuisinePreference)
 {
     //Map stores Cuisine name and all the dishes of that cuisine
     HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
     
     //Iterates through all the lunchMenuPairs add stores them in map
     for(int i=0; i<lunchMenuPairs.length; i++){
         String cuisine = lunchMenuPairs[i][1];
         String dish    = lunchMenuPairs[i][0];
         
         ArrayList<String> cuisinelist = map.containsKey(cuisine) ? map.get(cuisine) : new ArrayList<String>(); // Current cuisine list
         ArrayList<String> defaultList = map.containsKey("*") ? map.get("*") : new ArrayList<String>(); // "*" cuisine list which has all the dishes
         cuisinelist.add(dish);
         defaultList.add(dish);
         map.put(cuisine, cuisinelist);
         map.put("*", defaultList); // Each dish is also stored in "*" cuisine list
     }
     
     ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
     
     // Iterate over the team and store all the dishes related to preferred cuisine along with the member
     for(int i=0; i<teamCuisinePreference.length; i++){
         String member = teamCuisinePreference[i][0];
         String prefCuisine = teamCuisinePreference[i][1];
         ArrayList<String> dishes = map.get(prefCuisine);
         
         if(dishes!=null && dishes.size()!=0){
             for(String dish : dishes){
                 ArrayList<String> temp = new ArrayList<String>();
                 temp.add(member);
                 temp.add(dish);
                 result.add(temp);
             }
         }
     }
     
     //Resultant array with team member and dish name
     String[][] resultArr = new String[result.size()][2];
     
     for(int i=0; i<result.size(); i++){
         ArrayList<String> curr = result.get(i);
         
         String[] strArr = new String[2];
         strArr[0] = curr.get(0);
         strArr[1] = curr.get(1);
         resultArr[i] = strArr;
     }
     
     return resultArr;
 }
 // METHOD SIGNATURE ENDS
}