package hunter.s.adventure.game;
import java.util.Scanner;
public class Home extends Map{
    Player p_1;
    Home(){
    }
    
    Home(Player p_1){
        this.p_1=p_1;
    }
        //Gold
    void Training_place(){
        System.out.println("Train Place");
    }
    void Refill() {
        boolean refill = true ;
        while(refill){
        System.out.println("========================================Refill===========================================");
        System.out.println("you have\n\tpotion : "+p_1.getPotion()
                +"/"+p_1.getLimitPotion()
                +"\n\tmini bomb : "+p_1.getMiniBomb()+"/"+p_1.getLimitMiniBomb());
        Scanner ur = new Scanner(System.in);
        int gold=(100*(p_1.getLimitPotion()-p_1.getPotion()))+(100*(p_1.getLimitMiniBomb()-p_1.getMiniBomb()));
        System.out.println("refill(use "+gold+" G)\nAre you sure about that?\n"
                         + "(y)yes             (n)no");
        System.out.print("Choose: ");
        String re = ur.nextLine();
        switch(re){
            case "y":case"Y":
                if(p_1.getGold()>=gold){
                    p_1.setGold(-gold);
                    p_1.Refill();
                }else
                    System.out.println("Not enough");
                refill=false;
                break;
            case "n":case"N":refill = false  ;break;
            default :refill = true   ;break;
        }    
        }
    }
    void Upgrade() {
        boolean upgrade = true ;
        while(upgrade){
        System.out.println("========================================Upgrade===========================================");
//upgrade potion minibomb
        System.out.println("You have "+p_1.getGold()+" Gold\n"
                       + "(1)backpack\n"
                       + "(2)damage minibomb & healing power potion\n"
                       + "(3)weapon\n"
                       + "(b)back");
        Scanner sr = new Scanner(System.in);
        System.out.print("Choose: ");
        String Upgrade = sr.nextLine();
        switch(Upgrade){
            case "1":upgradelimit();break;
            case "2":upgradePower();break;
            case "3":upgradeweapon();break;
            case "b":upgrade=false;break;
            default :upgrade = true  ;break;
                    }
        }
    }
    void upgradelimit(){
                System.out.println("========================================Limit===========================================");
                boolean limi=true;
                while(limi){
                int gold=200;
                Scanner ur = new Scanner(System.in);
                System.out.println("(1)LimitPotion: "+p_1.getLimitPotion()+"\n"
                                 + "(2)LimitMiniBomb: "+p_1.getLimitMiniBomb()+"\n"
                                 + "(b)back");
                System.out.print("Choose: ");
                String Limi = ur.nextLine();
                switch(Limi){
                case"1":if(p_1.getGold()>=gold){p_1.setLimitPotion(1)  ;limi=true;
                }else{
                    System.out.println("Have not enough money");}break;
                case"2":if(p_1.getGold()>=gold){p_1.setLimitMiniBomb(1);limi=true;break;
                }else{
                    System.out.println("Have not enough money");}break;
                case"b":case"B":limi=false;break;
                default :limi = true  ;break;
                }
                }
    }
    void upgradePower(){
        System.out.println("========================================Heal&Explotion===========================================");
                boolean power=true;
                while(power){
                int gold=100;
                Scanner ur = new Scanner(System.in);
                System.out.println("(1)MiniBomb: "+p_1.getExplotion()+" use 100 \n"
                                 + "(2)Potion: "+p_1.getHeal()+" use 100 \n"
                                 + "(b)back");
                System.out.print("Choose: ");
                String Limi = ur.nextLine();
                switch(Limi){
                case"1":if(p_1.getGold()>=gold){p_1.setExplotion(20);power = true;
                }else{
                    System.out.println("Have not enough money");}break;
                case"2":if(p_1.getGold()>=gold){p_1.setHeal(50);power = true;break;
                }else{
                    System.out.println("Have not enough money");}break;
                case"b":case"B":power=false;break;
                default :power = true  ;break;
                }
                }
     }
     void upgradeweapon(){
         System.out.println("========================================UpgradeWeapon===========================================");
                boolean wp = true;
                while(wp){
                int gold=1000*p_1.getLevel();
                System.out.println(p_1.getWeaponName()+" level "+p_1.getLevel()+" "+gold+" Gold"+" ATK"+p_1.getWeaponDamage());
                Scanner sr = new Scanner(System.in);
                System.out.println("do you want to upgrade Y/N");
                String Upgrade = sr.nextLine();
                switch(Upgrade){
                    case "y" :case"Y":
                        if(p_1.getGold()>=gold){
                        p_1.UpgradeWeapon() ;
                         p_1.setGold(-gold);
                    }else{
                        System.out.println("Have not enough money");
                    }
                    wp = true;
                    break;
                    case "n" :case"N":wp=false ;break;
                    default : wp = true  ;break;
            }
                }
     }
        
        
    
    //clear
    void ChangeWeapon(){
        boolean cw = true ;
        while(cw){
            int d1=60,d2=30,d3=20 ;
        System.out.print("========================================Change Weapons===========================================\n"
                       + "(1)Heavy Sword      level "+p_1.getLevel()+"\n"
                       + "(2)Short Hand Sword level "+p_1.getLevel()+"\n"
                       + "(3)Huntsman Knife   level "+p_1.getLevel()+"\n"
                       + "(b)Back");
        Scanner sr = new Scanner(System.in);
        System.out.println("Choose: ");
        String changeweapons = sr.nextLine();
        
        Tools_pack tp = new Tools_pack();
        if(changeweapons.equals("b"))cw=false;
        else if(tp.StringToNum(changeweapons)){
        switch(tp.getNum()){
            case 1 :  p_1.setWeaponType(1);
                      System.out.println("you have Heavy Sword");break;
            case 2 :  p_1.setWeaponType(2);
                      System.out.println("you have Short Hand Sword");break;
            case 3 :  p_1.setWeaponType(3);
                      System.out.println("you have Huntsman Knife");break;
            default : cw = true ;break;
        }
        }
        }
}    
}
