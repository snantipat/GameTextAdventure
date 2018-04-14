package hunter.s.adventure.game;
import java.util.Scanner;
public class Home extends Map{
    NPC n_1,n_2,n_3;
    Player p_1;
        //ATK Weapon
        int d1=60,d2=30,d3=20 ;
        //Upgrade Weapon
        int ld1=1,ld2=1,ld3=1 ;
        //Gold
        int g1=1000*ld1,g2=1000*ld1,g3=1000*ld1;
    Home(NPC npc1,NPC npc2,NPC npc3,Player p1){
        this.n_1=npc1;
        this.n_2=npc2;
        this.n_3=npc3;
        this.p_1=p1;
    }
    void homeTown(){
    }
        
    

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
            case "y":p_1.setpotion(4);break;
            case "n":refill = false  ;break;
            default :refill = true   ;break;
        }    
        }
    }
    void Upgrade() {
        boolean upgrade = true ;
        while(upgrade){
        System.out.print("========================================Upgrade==========================================="
                       + "(1)Heavy Sword      level: "+ld1+" "+g1+"Gold"
                       + "(2)Short Hand Sword level: "+ld2+" "+g2+"Gold"
                       + "(3)Huntsman Knife   level: "+ld3+" "+g3+"Gold"
                       + "(b)Back");
        Scanner sr = new Scanner(System.in);
        System.out.println("Choose: ");
        String Upgrade = sr.nextLine();
        switch(Upgrade){
            case "1" :p_1.setWeaponDamage(d1+60) ;
                      p_1.setGold(-g1);
                      ld1++;
                      upgrade = true;
                      break;
            case "2" :p_1.setWeaponDamage(d2+30) ;
                      p_1.setGold(-g2);
                      ld2++;
                      upgrade = true;
                      break;
            case "3" :p_1.setWeaponDamage(d3+20) ;
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
        System.out.print("========================================Change Weapons==========================================="
                       + "(1)Heavy Sword      level:"+ld1
                       + "(2)Short Hand Sword level:"+ld2
                       + "(3)Huntsman Knife   level:"+ld3
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