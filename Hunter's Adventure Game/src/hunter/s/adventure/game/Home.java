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
                p_1.setGold(-gold);
                p_1.Refill();break;
            case "n":case"N":refill = false  ;break;
            default :refill = true   ;break;
        }    
        }
    }
    void Upgrade() {
        boolean upgrade = true ;
        while(upgrade){
        //Gold
        int gold=1000*p_1.getLevel();
        //ATK Weapon
        System.out.print("========================================Upgrade===========================================\n"
//upgrade potion minibomb
                       + "you have "+p_1.getGold()+" Gold\n"
                       + p_1.getWeaponName()+" level "+p_1.getLevel()+" "+gold+" Gold"+" ATK"+p_1.getWeaponDamage()+"\n"
                       + "(b)Back\n");
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
                upgrade = true;
                break;
            case "n" :case"N":upgrade = false ;break;
            case "b" :case"B":upgrade = false ;break;
            default : upgrade = true  ;break;
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
