import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class trade{
    int tradeId;
    String tradeDate;
    int amount;
    Product product;
    String counterParty;
    Direction direction;
    public enum Direction{
        PAY,
        RECEIVE
    }
    public trade(int tradeId,String tradeDate,int amount,Product product,String counterParty,Direction direction){
        this.tradeId=tradeId;
        this.tradeDate=tradeDate;
        this.amount=amount;
        this.product=product;
        this.counterParty=counterParty;
        this.direction=direction;
    }
    static class Product{
        int productId;
        String productName;
        public Product(int productId,String productName){
            this.productId=productId;
            this.productName=productName;
        }
    }
    public static List<Integer> displayTrades(List<trade> allTrades){
        List<Integer>Id=new ArrayList<Integer>();
        for(int i=0;i<allTrades.size();i++){
            if((allTrades.get(i).counterParty) != null &&(allTrades.get(i).counterParty.equals("X"))){
                Id.add(allTrades.get(i).tradeId);
            }
        }
        return Id;
    }
    private static int addAmount(List<trade> allTrades){
        int sum=0;
        for(int i=0;i<allTrades.size();i++){
            if((allTrades.get(i).product.productName.equals("A")) && ((allTrades.get(i).product.productName) != null) && (allTrades.get(i).direction.toString().equals("RECEIVE")) && (allTrades.get(i).direction.toString()) != null){
                sum+=allTrades.get(i).amount;
            }
            else {
                System.out.println("ProductName " + allTrades.get(i).product.productName + " and direction  " + allTrades.get(i).direction + " didn't match" );
            }


        }
        return sum;
    }
    private static int addAmountReversed(List<trade> allTrades){
        int sum=0;
        for(int i=0;i<allTrades.size();i++){
            if((allTrades.get(i).product.productName.equals("B")) && ((allTrades.get(i).product.productName) != null) && (allTrades.get(i).direction.toString().equals("PAY")) && (allTrades.get(i).direction.toString()) != null){
                sum+=allTrades.get(i).amount;
            }
            else {
                System.out.println("ProductName " + allTrades.get(i).product.productName + " and direction  " + allTrades.get(i).direction + " didn't match with amount revesed" );
            }
        }
        sum*=-1;
        return sum;
    }
    public static void main(String[] args){
        List<trade>allTrades = new ArrayList<trade>();
        Product p1= new Product(1001,"A");
        Product p2= new Product(1002,"B");
        trade t1= new trade(1,"20220812",100,p1,"X",Direction.PAY);
        trade t2= new trade(2,"20220812",200,p1,"Y",Direction.RECEIVE);
        trade t3= new trade(3,"20220812",400,p2,"X",Direction.RECEIVE);
        trade t4=new trade(4,"20220812",500,p1,null,Direction.RECEIVE);
        trade t5=new trade(5,"20220812",1000,p2,null,Direction.PAY);
        allTrades.add(t1);
        allTrades.add(t2);
        allTrades.add(t3);
        allTrades.add(t4);
        allTrades.add(t5);

        System.out.println("Trade ID's are :" + displayTrades(allTrades));
        System.out.println("Total amount is :" + addAmount(allTrades));
        System.out.println("Total Reversed amount is :" + addAmountReversed(allTrades));
    }
}

