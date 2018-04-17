package hunter.s.adventure.game;

public class Home extends Map{
    Player p_1;
    Home(){
    }
    
    Home(Player p_1){
        this.p_1=p_1;
    }
    Tools_pack tp = new Tools_pack();
    void Training_place(){
        boolean training=true;
        while(training){
        System.out.println("=====================================Train Place=========================================");
        System.out.println("You have "+p_1.getEXP()+" EXP"
                + "\nYour current HP:"+p_1.getHP()+" ATK:"+p_1.getATK()
                + "\n(1)+10 HP point cost "+100*p_1.getLevelHp()+" EXP"
                + "\n(2)+5 ATK potnt cost "+100*p_1.getLevelAtk()+" EXP"
                + "\nBack(b)");
               String input=tp.enter.nextLine();
               switch(input){
                   case"1":
                       if(p_1.getEXP()>=100*p_1.getLevelHp()){
                            p_1.setHP(10);
                            p_1.setEXP(-100*p_1.getLevelHp());
                       }else
                           System.out.println("Not enoungh Exp.");
                       
                       break;
                   case"2":
                       if(p_1.getEXP()>=100*p_1.getLevelAtk()){
                            p_1.setATK(5);
                            p_1.setEXP(-100*p_1.getLevelAtk());
                       }else
                           System.out.println("Not enoungh Exp.");
                       break;
                   case"b":case"B":training=false;
                       break;
               }
            
        }
    }
    void Refill() {
        boolean refill = true ;
        while(refill){
        System.out.println("========================================Refill==========================================="
                + "\nYou have "+p_1.getGOLD()+" Gold");
        System.out.println("Your current\tpotion : "+p_1.getPotion()
                +"/"+p_1.getLimitPotion()
                +"\tmini bomb : "+p_1.getMiniBomb()+"/"+p_1.getLimitMiniBomb());
        int gold=(100*(p_1.getLimitPotion()-p_1.getPotion()))+(100*(p_1.getLimitMiniBomb()-p_1.getMiniBomb()));
        System.out.println("refill(use "+gold+" G)\nAre you sure about that?\n"
                         + "(y)yes             (n)no");
        System.out.print("Choose: ");
        String re = tp.enter.nextLine();
        switch(re){
            case "y":case"Y":
                if(p_1.getGOLD()>=gold){
                    p_1.setGOLD(-gold);
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
        System.out.println("You have "+p_1.getGOLD()+" Gold"
                       + "\nUpgrade List"
                       + "\n\t(1)Backpack\n"
                       + "\t(2)Damage Mini Bomb & Healing Power(potion)\n"
                       + "\t(3)Weapon Damage\n"
                       + "(b)Back");
        
        System.out.print("Choose: ");
        String Upgrade = tp.enter.nextLine();
        switch(Upgrade){
            case "1":upgradeBackpack();break;
            case "2":upgradePower();break;
            case "3":upgradeWeapon();break;
            case "b":upgrade=false;break;
            default :upgrade = true  ;break;
                    }
        }
    }
    void upgradeBackpack(){
        boolean limi=true;
        while(limi){
            int gold=1000;
                System.out.println("========================================Back Pack===========================================");                
                System.out.println("You have "+p_1.getGOLD()+" Gold"
                                 + "\nYour current backpack size"
                                 + "\tBackpack's Potion "+p_1.getLimitPotion()
                                 + "\tBackpack's Mini Bomb "+p_1.getLimitMiniBomb()
                                 + "\n\t(1)Upgrade Backpack's Potion "
                                 + "\n\t(2)Upgrade Backpack's MiniBomb "
                                 + "\nBack(b)");
                System.out.print("Choose: ");
                String Limi = tp.enter.nextLine();
                switch(Limi){
                case"1":

                    if(p_1.getGOLD()>=gold){
                        p_1.setLimitPotion(1);
                        p_1.setGOLD(-gold);
                    }else
                        System.out.println("Not enough money");
                    break;
                case"2":
                    if(p_1.getGOLD()>=gold){
                        p_1.setLimitMiniBomb(1);
                        p_1.setGOLD(-gold);
                    }else{
                        System.out.println("Not enough money");
                    }break;
                case"b":case"B":
                    limi=false;
                    break;
                }
        }
    }
    void upgradePower(){
        boolean power=true;
        while(power){
        System.out.println("========================================Heal&Explotion===========================================");
                
                
                int gold=1000;
                
                System.out.println("Your current "+p_1.getGOLD()+" Gold"
                        + "\n Damage's mini bomb:"+p_1.getExplotion()
                        + "\n Power's healing potion:"+p_1.getHeal()
                        + "\n\t(1)Upgarde Mini Bomb"
                        + "\n\t(2)Upgarde Potion"
                        + "\nback(b)");
                System.out.print("Choose: ");
                String Limi = tp.enter.nextLine();
                switch(Limi){
                case"1":
                    if(p_1.getGOLD()>=gold){
                        p_1.setExplotion(20);
                        p_1.setGOLD(-gold);
                    }else{
                        System.out.println("Not enough money");}
                    break;
                case"2":
                    if(p_1.getGOLD()>=gold){
                        p_1.setHeal(50);
                        p_1.setGOLD(-gold);
                    }else{
                        System.out.println("Not enough money");}break;
                case"b":case"B":power=false;break;
                default :power = true  ;break;
                }
                }
     }
     void upgradeWeapon(){
         boolean wp = true;
         while(wp){
         System.out.println("========================================Upgrade Weapon===========================================");
                
                
                int gold=1000*p_1.getLevel();
                System.out.println("You have "+p_1.getGOLD()+" Gold\n"
                        + "Your current weapon :"+p_1.getWeaponName()+" Lv."+p_1.getLevel()+" ATK"+p_1.getWeaponDamage()
                        + "\n Upgarde Weapon +"+WeaponInfo.WEADAM[p_1.getWeaponType()-1]+" Damages  (cost "+p_1.getLevel()*1000+" Gold)");
                System.out.print("Do you want to upgrade Y/N >");
                String Upgrade = tp.enter.nextLine();
                switch(Upgrade){
                    case "y" :case"Y":
                        if(p_1.getGOLD()>=gold){
                            p_1.UpgradeWeapon() ;
                            p_1.setGOLD(-gold);
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
    void ChangeWeapon(){
        boolean cw = true ;
        
        System.out.println("========================================Change Weapons==========================================="
                       + "\n\t(1)Heavy Sword      Lv."+p_1.getLevelType(0)+" "+p_1.getWeaponDamType(0)+" Damages"
                       + "\n\t(2)Short Hand Sword Lv."+p_1.getLevelType(1)+" "+p_1.getWeaponDamType(1)+" Damages"
                       + "\n\t(3)Huntsman Knife   Lv."+p_1.getLevelType(2)+" "+p_1.getWeaponDamType(2)+" Damages"
                       + "\nBack(B)");
        while(cw){
        System.out.print("Choose: ");
        String changeweapons = tp.enter.nextLine();
        if(changeweapons.equalsIgnoreCase("b"))
            cw=false;
        else
            switch(changeweapons){
                case "1" :  p_1.setWeaponType(1);
                      System.out.println("Now using Heavy Sword");break;
                case "2" :  p_1.setWeaponType(2);
                      System.out.println("Now using Short Hand Sword");break;
                case "3" :  p_1.setWeaponType(3);
                      System.out.println("Now using Huntsman Knife");break;
            }
        
        }
}    
}
