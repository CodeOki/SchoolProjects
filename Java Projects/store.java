public class store {
   static int TwoOrders = 0;
   class linkList {
      String sale[];
      String receipt[];
      String promotion_card[];
      linkList next;
   }
   
linkList S_head;
linkList R_head;
linkList P_head;

void readReceiptRecord(int quantity, int price) {

   linkList receipt = new linkList();
   receipt.receipt = new String[3];

   receipt.receipt[0] = "R";

   receipt.receipt[1] = Integer.toString(quantity);

   receipt.receipt[2] = Integer.toString(price);
  
   receipt.next = null;
   if(R_head==null)
   R_head = receipt;
   else
   {
   //getting end of list by using head node
   linkList temp = R_head;
   while(temp.next!=null)
   {
   temp= temp.next;
   }
   //string current recipt to end of list
   temp.next = receipt;
   }
   
   System.out.println("Receipt "+receipt.receipt[0]);
   System.out.println("Quantity "+receipt.receipt[1]);
   System.out.println("Price "+receipt.receipt[2]);
   System.out.println("\nStored Successfully!");
    
}

void readPromotionCard(int discount) {

   linkList promotionCard = new linkList();
   promotionCard.promotion_card = new String[2];

   promotionCard.promotion_card[0] = "P";

   promotionCard.promotion_card[1] = Integer.toString(discount);
  
   promotionCard.next = null;
   if(P_head==null)
   P_head = promotionCard;
   else {
   linkList temp = P_head;
   while(temp.next!=null) {
   temp= temp.next;
   }
   temp.next = promotionCard;
   }
   System.out.println("promotionCard "+promotionCard.promotion_card[0]);
   System.out.println("Discount "+promotionCard.promotion_card[1]);
   System.out.println("\nNext two Customer will be served Discount!");
   }
void soldRecord(int quantity) {
   linkList sold = new linkList();
   sold.sale = new String[2];
   sold.sale[0] = "S";
  
   sold.next = null;
   int availableQuantity = 0;
   int count = 1;
   int totalSale = 0;
   boolean check = false;
   linkList temp = R_head;
   availableQuantity = Integer.parseInt(temp.receipt[1]);
   while(temp.next!=null) {
   //as quantity is stored on 2nd column
   if(availableQuantity>=quantity) {
      TwoOrders++;
      temp = R_head;
      linkList promoCard = P_head;
      check = true;
      int discount;
      int priceWithDiscount;
      while(count>0) {
         if(promoCard.next!=null)
      {
      if(TwoOrders==2) {
         TwoOrders = 0;
         P_head = promoCard.next;
      }

         discount = Integer.parseInt(promoCard.promotion_card[1]);
         priceWithDiscount = (discount/100)*Integer.parseInt(temp.receipt[2]);
         System.out.println("\n"+availableQuantity+" Widgets sold");
         System.out.println(temp.receipt[1]+" at "+discount
         +" each\tSales: $ "+(Integer.parseInt(temp.receipt[1])
         *Integer.parseInt(temp.receipt[2])));
   
         totalSale = totalSale + (Integer.parseInt(temp.receipt[1])*discount);
      } else {
      System.out.println("\n"+availableQuantity+" Widgets sold");
      System.out.println(temp.receipt[1]+" at "+temp.receipt[2]
      +" each\tSales: $ "+(Integer.parseInt(temp.receipt[1])
      *Integer.parseInt(temp.receipt[2])));

      totalSale = totalSale + (Integer.parseInt(temp.receipt[1])
      *Integer.parseInt(temp.receipt[2]));
      }


temp = temp.next;
R_head = temp.next;
count--;

      }
   }

availableQuantity = availableQuantity + Integer.parseInt(temp.receipt[1]);
count++;
temp = temp.next;

  
   }
   if(!check) {
      temp = R_head;
      while(count>0 && temp.next!=null) {
      System.out.println("\n"+availableQuantity+" Widgets sold");
      System.out.println(temp.receipt[1]+" at "+temp.receipt[2]
      +" each\tSales: $ "+(Integer.parseInt(temp.receipt[1])
      *Integer.parseInt(temp.receipt[2])));

      totalSale = totalSale + (Integer.parseInt(temp.receipt[1])
      *Integer.parseInt(temp.receipt[2]));
      temp = temp.next;
      R_head = temp.next;
      count--;
      }
   }
System.out.println("\nTotal Sale: $ "+totalSale);
System.out.println("\nRemainder of "+(availableQuantity-quantity)+" Widgets not available");
  
sold.sale[1] = Integer.toString(availableQuantity);
}

  
//method at the end of program print data
void printProgramData() {
int getPromo = 0;
System.out.println("\nData for Program");
System.out.println("\nR/S/P\t#Widgets or Discount%\tPrice");
  
//getting records data from link list
linkList R_data = R_head;
linkList P_data = P_head;
linkList S_data = S_head;
  
   while(R_data!=null) {
      System.out.print(R_data.receipt[0]+"\t");
         if(P_data!=null) {
            getPromo = 1;
         }
         if(getPromo<=2) {
         System.out.print(P_data.promotion_card[1]+"%\t");
         getPromo++;
         } else {
         System.out.print(R_data.receipt[1]+"\t");
         P_data = P_data.next;
         }
         System.out.println("$"+R_data.receipt[2]);
         R_data = R_data.next;
   }
}

//main method to test above functionalities
public static void main(String[] args) {
   store shipment = new store();
  
   shipment.S_head = null;
   shipment.R_head = null;
   shipment.P_head = null;
 
  
shipment.readReceiptRecord(200, 600);
shipment.readReceiptRecord(100, 100);
shipment.readReceiptRecord(20, 70);
shipment.readReceiptRecord(60, 100);
shipment.readReceiptRecord(400, 100);
  
shipment.readPromotionCard(20);
shipment.readPromotionCard(30);
shipment.readPromotionCard(60);
  
shipment.soldRecord(20);
shipment.soldRecord(200);
shipment.soldRecord(40);
  
shipment.printProgramData();
}
}