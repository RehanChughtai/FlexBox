package flexbox;

import java.util.*;

public class OrderingSystem {
    /**
     * ArrayList containing the orders made by the user.
     */
    public ArrayList<Box> orderList;
    
    /**
     * BoxSelector to facilitate the creation of type of box
     * based on FlexBox specifications.
     */
    protected BoxSelector boxSelector;
    
    /**
     * Constructor Class for OrderingSystem.
     * Ordering System manages the communication between the GUI and the classes
     * from back-end.
     */
    public OrderingSystem(){
        orderList = new ArrayList<>();
        boxSelector = new BoxSelector();
        
    }
    
    /**
     * Method to add orders to the orderList
     * @param length double length of box.
     * @param height double height of box. 
     * @param width double width of box.
     * @param cardboardGrade Integer containing the grade of cardboard.
     * @param numberOfColours Integer number of colours requested.
     * @param reinforcementBottom Boolean if user specifies reinforcement bottom.
     * @param reinforcementCorners Boolean if user specifies reinforcement corners.
     * @param sealableTop Boolean if user specifies sealable top.
     * @param numberOfBoxes int how many boxes to add.
     */
    public void addPreviewOrder(double length, double height, double width, int cardboardGrade, 
            int numberOfColours, boolean reinforcementBottom,boolean reinforcementCorners, 
            boolean sealableTop,int numberOfBoxes){
        
        if(numberOfBoxes>0){
            for(int i=0;i<numberOfBoxes;i++){
                orderList.add(retBoxType(length,height,width,cardboardGrade,
                        numberOfColours,reinforcementBottom,reinforcementCorners,sealableTop));
            }
        }
    }
    
    /**
     * Method to clear the preview order. Deletes all boxes that are not confirmed by the user.
     */
    public void clearPreviewOrder(){
        Iterator<Box> it = orderList.iterator();
        while(it.hasNext()){
            Box box = it.next();
            if(!box.isConfirmedOrderBox()){
                it.remove();
            }
        }
    }
    
    /**
     * Method to delete all boxes confirmed by the user.
     */
    public void clearAllOrder(){
        Iterator<Box> it = orderList.iterator();
        while(it.hasNext()){
            Box box = it.next();
            if(box.isConfirmedOrderBox()){
                it.remove();
            }
        }
    }
    
    /**
     * Method to calculate the number of unconfirmed boxes made by the user.
     * @return int number of uncorfirmed boxes.
     */
    public int numberOfPreviewItems(){
        int count=0;
        for(Box box:orderList){
            if(!box.isConfirmedOrderBox()){
                count+=1;
            }
        }
        return count;
    }
    
    /**
     * Method to calculate the number of confirmed boxes made by the user.
     * @return int number of corfirmed boxes.
     */
    public int numOfTotalItems(){
        int count=0;
        for(Box box:orderList){
            if(box.isConfirmedOrderBox()){
                count+=1;
            }
        }
        return count;
    }
    
    /**
     * Method to delete a specific order. Checks if the deletion is valid before execuring.
     * @param orderNumber int Order to delete.
     */
    public void deleteOrder(int orderNumber){
        int numOfConfirmedBox=0;
        for(Box box:orderList){
            if(box.isConfirmedOrderBox()){
                numOfConfirmedBox+=1;
            }
        }
        if(orderNumber<=numOfConfirmedBox &&
                orderList.get(orderNumber-1).isConfirmedOrderBox()){
            orderList.remove(orderNumber-1);
        }
    }
    
    /**
     * Method to see if the there are any uncorfirmed boxes in order list.
     * @return boolean true if there are uncorfirmed boxes.
     */
    public boolean previewListIsEmpty(){
        for(Box box:orderList){
            if(!box.isConfirmedOrderBox()){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Method to change the status of box to confirmed boxes when the user request.
     */
    public void confirmOrderBox(){
        for(Box box:orderList){
            if(!box.isConfirmedOrderBox()){
                box.changeConfirmedOrderBox();
            }
        }
    }
    
    /**
     * Method to check if the order list has exceeded its capacity.
     * @return boolean true if maximum capacity has achieved.
     */
    public boolean isTotalOrderCompleted(){
        return(orderList.size()>=5001);
    }
    
    /**
     * Method to check if there are any confirmed boxes.
     * @return true if there are confirmed boxes.
     */
    public boolean isTotalOrderEmpty(){
        return(orderList.isEmpty());
    }
    
    /**
     * Method to display uncorfirmed boxes from the same charactetistics. It will display the size of uncorfirmed box.
     * @return String information size about the uncorfirmed box.
     */
    public String disPreOrdBoxSize(){
        if(!orderList.get(orderList.size()-1).isConfirmedOrderBox()){
            return orderList.get(orderList.size()-1).boxSizeInformation();
        }
        return"";
    }
    
    /**
     * Method to display uncorfirmed boxes from the same charactetistics. It will display the feature of uncorfirmed box.
     * @return String information aabout features of the uncorfirmed box.
     */
    public String disPreOrdFeatureInformation(){
        if(!orderList.get(orderList.size()-1).isConfirmedOrderBox()){
            return orderList.get(orderList.size()-1).featuresInformation();
        }
        return"";
    }
    
    /**
     * Method to display uncorfirmed boxes from the same charactetistics. It will display the costs of uncorfirmed box.
     * @return String information about cost of producing the uncorfirmed box.
     */
    public String disPreOrdPriceBreakdown(){
        if(!orderList.get(orderList.size()-1).isConfirmedOrderBox()){
            return orderList.get(orderList.size()-1).costBreakdownInformation();
        }
        return"";
    }
    
    /**
     * Method to find if there any confirmed boxes in the list for GUI display purposes.
     * @return true if there are confirmed box in the list
     */
    public boolean isConfirmedOrder(){
        for(Box box:orderList){
            if(box.isConfirmedOrderBox()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method to calcualte the price of unconfirmed boxes.
     * @return double total price of unconfirmed boxes.
     */
    public double getPreviewOrderPrice(){
        double price=0;
        for(Box boxType:orderList){
            if(!boxType.isConfirmedOrderBox()){
                price+=boxType.boxCost();
            }
        }
        return price;
    }
    
    /**
     * Method to calculate the price of confirmed boxes.
     * @return double total price of confirmed boxes.
     */
    public double getOrderPrice(){
        double price=0;
        for(Box order : orderList){
            if(order.isConfirmedOrderBox()){
                price += order.boxCost();
            }
        }
        return price;
    }
    
    /**
     * Method to check the input size given by the user.
     * @param length double length of box.
     * @param height double height of box. 
     * @param width double width of box.
     * @return true if it is within the range.
     */
    public boolean isSizeValid(double length, double height, double width){
        return ((length>=0.3&&height>=0.3&&width>=0.3)&&
                (length<=10&&height<=10&&width<=10));
    }
    
    /**
     * Method to call box selector and check if the input features are valid,
     * @param cardboardGrade Integer containing the grade of cardboard.
     * @param numberOfColours Integer number of colours requested.
     * @param reinforcementBottom Boolean if user specifies reinforcement bottom.
     * @param reinforcementCorners Boolean if user specifies reinforcement corners.
     * @see BoxSelector Class.
     * @return true if the hashmap matches the set of characteristics of box
     */
    public boolean isBoxCanBeMade(int cardboardGrade,int numberOfColours, boolean reinforcementBottom,boolean reinforcementCorners){
        return(boxSelector.boxIsValid(cardboardGrade, numberOfColours, reinforcementBottom, reinforcementCorners));
    }
    
    /**
     * Method to create the box type based on the set of features and box dimension.
     * Calls Box Selector to give the value of matching keys.
     * @param length double length of box.
     * @param height double height of box. 
     * @param width double width of box.
     * @param cardboardGrade Integer containing the grade of cardboard.
     * @param numberOfColours Integer number of colours requested.
     * @param reinforcementBottom Boolean if user specifies reinforcement bottom.
     * @param reinforcementCorners Boolean if user specifies reinforcement corners.
     * @param sealableTop Boolean if user specifies sealable top.
     * @return Object BoxType given the set of characteristics.
     */
    public Box retBoxType(double length, double height, double width,
            int cardboardGrade,int numberOfColours, boolean reinforcementBottom,
            boolean reinforcementCorners, boolean sealableTop){
        
        switch (boxSelector.returnBoxType(cardboardGrade,numberOfColours,reinforcementBottom,reinforcementCorners)) {
            
            case 1:
                return new BoxType1(length, height, width, cardboardGrade,
                        numberOfColours, reinforcementBottom,reinforcementCorners,
                        sealableTop);
            case 2:
                return new BoxType2(length, height, width, cardboardGrade,
                        numberOfColours, reinforcementBottom,reinforcementCorners,
                        sealableTop);
            case 3:
                return new BoxType3(length, height, width, cardboardGrade,
                        numberOfColours, reinforcementBottom,reinforcementCorners,
                        sealableTop);
            case 4:
                return new BoxType4(length, height, width, cardboardGrade,
                        numberOfColours, reinforcementBottom,reinforcementCorners,
                        sealableTop);
            case 5:
                return new BoxType5(length, height, width, cardboardGrade,
                        numberOfColours, reinforcementBottom,reinforcementCorners,
                        sealableTop);
            default:
                break;
        }
        return null;
    }
}