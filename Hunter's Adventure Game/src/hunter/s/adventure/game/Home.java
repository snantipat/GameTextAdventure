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
        
    

    void upStatus(){
        System.out.println("            -up status-");
        System.out.println("  Status			  use\n" +
                           "(1)	VIT	          	 10xp\n" +
                           "(2)	ATK		         10xp\n" +
                           "notice:\n" +
                           "max hp+10 per vit\n" +
                           "max power 2 per atk");
        System.out.println("               back(0)");
        Scanner u = new Scanner(System.in);
        System.out.print("Choose: ");
        int up = u.nextInt();
        switch(up){
            case 0 : ;break;
            case 1 : ;break;
            case 2 : ;break;
        }
    }
    void utilityShop() {
        System.out.println("         -Food&Potion-");
        System.out.println("   BUY(1)	          SELL(2)");
        System.out.println("           back(3)");
        Scanner r = new Scanner(System.in);
        System.out.print("Choose: ");
        int bs = r.nextInt();
        switch(bs){
            case 1 :buyitem() ;break;
            case 2 : ;break;
            case 3 : ;break;
    }
    }
    void buyitem(){
        System.out.println("(1) Small  potion   Hp+25%       50 G\n" +
                           "(2) middle potion   Hp+50%       50 G\n" +
                           "(3) big    potion   Hp+75%       50 G\n" );
        System.out.println("     Buy Back(0)    Back(4)");
        Scanner r = new Scanner(System.in);
        System.out.print("Choose: ");
        int bs = r.nextInt();  
        switch(bs){
            case 0 : ;break;
            case 1 : ;break;
            case 2 : ;break;
            case 3 : ;break;
            case 4 :utilityShop() ;break;
        }
    }

    void weaponShop() {
        System.out.println("            <WEAPON SHOP>");
        System.out.println("      Buy(1)              Sell(2) ");
        System.out.println("               back(3)");
        Scanner ur = new Scanner(System.in);
        System.out.print("Choose: ");
        int buy = ur.nextInt();
        switch(buy){
            case 1 :buyweapon() ;break;
            case 2 : ;break;
            case 3 : ;break;
        }
    }
    void buyweapon(){
        System.out.println("(1)Greatswords   1Hit/turn           50 G.\n" +
                           "(2)Sword         2Hit/turn           50 G.\n" +
                           "(3)Daggers       3Hit/turn           50 G.");
        System.out.println("Your Wallet : 100G");
        System.out.println("     Buy Back(0)    Back(4)");
        Scanner r = new Scanner(System.in);
        System.out.print("Choose: ");
        int bs = r.nextInt();  
        switch(bs){
            case 0 : ;break;
            case 1 : ;break;
            case 2 : ;break;
            case 3 : ;break;
            case 4 :weaponShop() ;break;
    }
    
}
    
}
