package hunter.s.adventure.game;
import java.util.Scanner;
public class Home extends Map{
    NPC n_1,n_2,n_3;
    Player p_1;
    Home(NPC npc1,NPC npc2,NPC npc3,Player p1){
        this.n_1=npc1;
        this.n_2=npc2;
        this.n_3=npc3;
        this.p_1=p1;
    }
    void homeTown(){

    }
        
    

    void upStatus() {
        System.out.println("            -up status-");
        System.out.println("  Status			  use\n" +
                           "	VIT	          	 10xp\n" +
                           "	ATK		         10xp\n" +
                           "notice:\n" +
                           "max hp+10 per vit\n" +
                           "max power 2 per atk");
    }

    void utilityShop() {
        System.out.println("            -Food&Potion");
        System.out.println("Small  potion   Hp+25%       50 G\n" +
                           "middle potion   Hp+50%       50 G\n" +
                           "big    potion   Hp+75%       50 G\n" +
                           "   BUY(b)	          SELL(S)\n" +
                           "BUYBACK(0)\n" +
//                           "Your Wallet : "+g+" G");
        Scanner r = new Scanner(System.in);
        System.out.print("Choose: ");
        int bs = r.nextInt();
        
    }

    void weaponShop() {
        
        System.out.println("            <WEAPON SHOP>");
        System.out.println("Greatswords   1Hit/turn           50 G\n" +
                           "Sword         2Hit/turn           50 G\n" +
                           "Daggers       3Hit/turn           50 G");
        System.out.println("      Buy(b)              Sell(s)\n"+
                           "            Buy Back(0)");
        Scanner ur = new Scanner(System.in);
        System.out.print("Choose: ");
        int buy = ur.nextInt();
//        System.out.println("Your Wallet : "+g+" G");
        System.out.println("BACKPACK : ");
        System.out.println("MENU(1)			 MAP(2)");
        Scanner sr = new Scanner(System.in);
        System.out.print("Choose: ");
        int mm = ur.nextInt();
    }
    
}
