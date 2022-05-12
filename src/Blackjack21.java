import java.util.Scanner;

public class Blackjack21 {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        
        // Wait for the user to press enter.
        scan.nextLine();
        
    
        
        int card1 = drawRandomCard();  
        int card2= drawRandomCard();
        String playerCard2= cardString(card2);  //second card for player
        
        System.out.println("\nYou get a \n" + cardString(card1)+ "\n and a \n"+ cardString(card2));
        
        
        
        int handValue= Math.min(card1, 10) + Math.min(10,card2);
        System.out.println("\nYour total is: "+ handValue);
        
        
        System.out.println("\n\tPress enter to seeing dealer's hand\n ");
        scan.nextLine();
	    
         int firstDealerCardInt= drawRandomCard();
         String firstDealerCard= cardString(firstDealerCardInt);  //first dealer card
         
         int faceDownCardInt= drawRandomCard();
         
         System.out.println("The dealer shows\n"+ firstDealerCard + "\nand has a card facing down \n" + faceDown());
         int dealerValue= firstDealerCardInt + faceDownCardInt;
         System.out.println("\nThe dealer's total hiden");
         
         
       while(true) {
    	   String option= hitOrStay();
    	   if(option.equalsIgnoreCase("stay")) {
    		   break;
    	   } else if(option.equalsIgnoreCase("hit")) {
    		   int newCard= drawRandomCard();
    		   handValue+= Math.min(10,newCard);
    		   System.out.println("\nYou got a\n"+ cardString(newCard));
    		   System.out.println("\nYour new total is: "+ handValue);
    		    if(handValue>21) {
    		     System.out.println("\n\n\tBust! Player loses!");
    		     System.exit(0);
    		     }
    	   }
    	  
    	 
       }
     
      
       
       System.out.println("\nDealer's turn:");
       System.out.println("\n" + cardString(faceDownCardInt));
       System.out.println("\nDealer total is: "+ dealerValue);
       
       while (dealerValue < 20) {
           int newCard = drawRandomCard();

           dealerValue += Math.min(newCard, 10);
           System.out.println("\n Dealer gets a \n" + cardString(newCard));
           System.out.println("Dealer's total is " + dealerValue);
       }
       if(dealerValue>21) {
    	   System.out.println("\n\n\tBust! Dealer loses!");
		     System.exit(0);
       }
       
       if(handValue>dealerValue) {
    	   System.out.println("\n\n\tPlayer win!!");
       }else{
    	   System.out.println("\n\n\tDealer win!!");
       }
       
       
    
      scan.close();

    }

   
    public static int drawRandomCard() {
    	int card= (int) (1+ Math.random()*13);
    	return card;
    }

 
    public static String cardString(int cardNumber) {
    
    	switch(cardNumber) {
    	case 1: 
    	return		 "   _____\n"+
                     "  |A _  |\n"+ 
                     "  | ( ) |\n"+
                     "  |(_'_)|\n"+
                     "  |  |  |\n"+
                     "  |____V|\n";
    		
    	case 2:
    	return  "   _____\n"+              
                "  |2    |\n"+ 
                "  |  o  |\n"+
                "  |     |\n"+
                "  |  o  |\n"+
                "  |____Z|\n";
    		
    		
    	case 3:
        return  "   _____\n" +
                "  |3    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  |  o  |\n"+
                "  |____E|\n";
        		
        		
        		
    	case 4:
    	return  "   _____\n" +
                "  |4    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  | o o |\n"+
                "  |____h|\n";
    			
    			
    	case 5:
    	return  "   _____ \n" +
                "  |5    |\n" +
                "  | o o |\n" +
                "  |  o  |\n" +
                "  | o o |\n" +
                "  |____S|\n";
    				
    				
    	case 6:
    	return  "   _____ \n" +
                "  |6    |\n" +
                "  | o o |\n" +
                "  | o o |\n" +
                "  | o o |\n" +
                "  |____6|\n";
    	
    	case 7:
    	return  "   _____ \n" +
                "  |7    |\n" +
                "  | o o |\n" +
                "  |o o o|\n" +
                "  | o o |\n" +
                "  |____7|\n";
    	case 8:
    	return  "   _____ \n" +
                "  |8    |\n" +
                "  |o o o|\n" +
                "  | o o |\n" +
                "  |o o o|\n" +
                "  |____8|\n";
    	case 9:
    	return  "   _____ \n" +
                "  |9    |\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |____9|\n";
    	case 10:
    	return  "   _____ \n" +
                "  |10  o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |___10|\n";
    	case 11:
    	return  "   _____\n" +
                "  |J  ww|\n"+ 
                "  | o {)|\n"+ 
                "  |o o% |\n"+ 
                "  | | % |\n"+ 
                "  |__%%[|\n";
    	case 12:
    	return  "   _____\n" +
                "  |Q  ww|\n"+ 
                "  | o {(|\n"+ 
                "  |o o%%|\n"+ 
                "  | |%%%|\n"+ 
                "  |_%%%O|\n";
    	
    	case 13:
    	return "   _____\n" +
               "  |K  WW|\n"+ 
               "  | o {)|\n"+ 
               "  |o o%%|\n"+ 
               "  | |%%%|\n"+ 
               "  |_%%%>|\n";
    	
    	default: return "This should not be happened!";
    	
    	}
    	
    	
    }
    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    

    public static String hitOrStay() {
    	System.out.println("\n\nhit or stay?");	
    	String res= scan.nextLine();
    	while(!(res.equalsIgnoreCase("hit") || res.equalsIgnoreCase("stay"))) {
    		System.out.println("\nPlease 'write' hit or 'stay'");
    		res = scan.nextLine();
    	}
    	return res;
        }
    	
    }
    
    
    
    
    
    
