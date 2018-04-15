package hunter.s.adventure.game;
import java.util.Scanner;
public class Home extends Map{
    Player p_1;
        int ld1=1,ld2=1,ld3=1 ;

        
    Home(Player p_1){
    this.p_1=p_1;
    }

        //Gold
        int g1=1000*ld1,g2=1000*ld2,g3=1000*ld3;

    void Refill() {
        boolean refill = true ;
        while(refill){
        System.out.println("========================================Refill===========================================");
        System.out.println("you have your potion : ");
        Scanner ur = new Scanner(System.in);
        System.out.println("are you sure about that(use 500 G)"
                         + "(y)yes             (n)no");
        System.out.println("Choose: ");
        String re = ur.nextLine();
        switch(re){
            case "y":p_1.setPotion(4);break;
            case "n":refill = false  ;break;
            default :refill = true   ;break;
        }    
        }
    }
    void Upgrade() {
        boolean upgrade = true ;
        while(upgrade){
        //Gold
        int g1=1000*ld1,g2=1000*ld2,g3=1000*ld3;
        //ATK Weapon
        int d1=60,d2=30,d3=20 ;
        System.out.print("========================================Upgrade===========================================\n"
                       + "you have "+p_1.getGold()+" Gold\n"
                       + "(1)Heavy Sword      level "+ld1+" "+g1+" Gold"+"ATK"+p_1.getWeaponDamage()+"\n"
                       + "(b)Back");
        Scanner sr = new Scanner(System.in);
        System.out.println("Choose: ");
        String Upgrade = sr.nextLine();
        switch(Upgrade){
            case "1" :p_1.setWeaponDamage(d1) ;
                      p_1.setGold(-g1);
                      ld1++;
                      upgrade = true;
                      break;
            case "2" :p_1.setWeaponDamage(d2) ;
                      p_1.setGold(-g2);
                      ld2++;
                      upgrade = true;
                      break;
            case "3" :p_1.setWeaponDamage(d3) ;
                      p_1.setGold(-g3);
                      ld3++;
                      upgrade = true;
                      break;
            case "b" :upgrade = false ;break;
            default : upgrade = true ;break;
        }
        }
    }
    
    void ChangeWeapon(){
        boolean cw = true ;
        while(cw){
            int d1=60,d2=30,d3=20 ;
        System.out.print("========================================Change Weapons===========================================\n"
                       + "you have "+p_1.getGold()+" Gold\n"
                       + "(1)Heavy Sword      level "+ld1+"\n"
                       + "(2)Short Hand Sword level "+ld2+"\n"
                       + "(3)Huntsman Knife   level "+ld3+"\n"
                       + "(b)Back");
        Scanner sr = new Scanner(System.in);
        System.out.println("Choose: ");
        String changeweapons = sr.nextLine();
        switch(changeweapons){
            case "1" :p_1.setWeaponType(1);
                      p_1.setWeaponDamage(d1);
                      System.out.println("you have Heavy Sword");break;
            case "2" :p_1.setWeaponType(2) ;
                      p_1.setWeaponDamage(d2);
                      System.out.println("you have Short Hand Sword");break;
            case "3" :p_1.setWeaponType(3) ;
                      p_1.setWeaponDamage(d3);
                      System.out.println("you have Huntsman Knife");break;
            case "b" :cw = false;break;
            default : cw = true ;break;
        }
        }
}    
}
