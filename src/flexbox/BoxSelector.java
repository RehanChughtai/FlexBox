package flexbox;

import java.util.*;

public class BoxSelector{
    
    /**
     * HashMap used to store the combination fo valid box
     */
    protected Map<Box, Integer> boxMap;
    
    /**
     * Constructor for box Selector.
     * Box Selector helps to facilitate the selection of box type.
     */
    public BoxSelector(){
    
        boxMap = new HashMap<>();
        
        
        boxMap.put(new Box(1,0,false,false), 1);
        boxMap.put(new Box(2,0,false,false), 1);
        boxMap.put(new Box(3,0,false,false), 1);
        boxMap.put(new Box(2,1,false,false), 2);
        boxMap.put(new Box(3,1,false,false), 2);
        boxMap.put(new Box(4,1,false,false), 2);
        boxMap.put(new Box(2,2,false,false), 3);
        boxMap.put(new Box(3,2,false,false), 3);
        boxMap.put(new Box(4,2,false,false), 3);
        boxMap.put(new Box(5,2,false,false), 3);
        boxMap.put(new Box(2,2,true,false), 4);
        boxMap.put(new Box(3,2,true,false), 4);
        boxMap.put(new Box(4,2,true,false), 4);
        boxMap.put(new Box(5,2,true,false), 4);
        boxMap.put(new Box(3,2,true,true), 5);
        boxMap.put(new Box(4,2,true,true), 5);
        boxMap.put(new Box(5,2,true,true), 5);
        
        
    }
    
    /**
     * Method to to check if the box is valid by checking with HashMap.
     * This method is used in HashMap.
     * @param cardboardGrade int Cardboard grade of box.
     * @param numberOfColours int number of colours of box.
     * @param reinforcementBottom boolean reinforcement bottom of box.
     * @param reinforcementCorners boolean reinforcement corners of box.
     * @see OrderingSystem Class
     * @return boolean indicating true if contains key in the hashmap given the set of constrains
     */
    public boolean boxIsValid(int cardboardGrade, int numberOfColours,boolean reinforcementBottom, boolean reinforcementCorners){
        return boxMap.containsKey(new Box(cardboardGrade,numberOfColours,reinforcementBottom,reinforcementCorners));
    }
    
    /**
     * Method to return the value from the key within the hashmap.
     * This method is used in HashMap.
     * @param cardboardGrade int Cardboard grade of box.
     * @param numberOfColours int number of colours of box.
     * @param reinforcementBottom boolean reinforcement bottom of box.
     * @param reinforcementCorners boolean reinforcement corners of box.
     * @see OrderingSystem Class
     * @return Integer indicating the BoxType
     */
    public int returnBoxType(int cardboardGrade, int numberOfColours,boolean reinforcementBottom, boolean reinforcementCorners){
        return boxMap.get(new Box(cardboardGrade,numberOfColours,reinforcementBottom,reinforcementCorners));
    }

}
