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
        System.out.println("You have "+p_1.getExp()+" EXP"
                + "\nyour current HP:"+p_1.getHp()+" ATK:"+p_1.getAtk()
                + "\n(1)+10 HP point cost "+100*p_1.getLevelHp()+" EXP"
                + "\n(2)+5 ATK potnt cost "+100*p_1.getLevelAtk()+" EXP"
                + "\nBack(b)");
               String input=tp.enter.nextLine();
               switch(input){
                   case"1":
                       if(p_1.getExp()>=100*p_1.getLevelHp()){
                            p_1.setHp(10);
                            p_1.setExp(-100*p_1.getLevelHp());
                       }else
                           System.out.println("Not enoungh Exp.");
                       
                       break;
                   case"2":
                       if(p_1.getExp()>=100*p_1.getLevelAtk()){
                            p_1.setAtk(5);
                            p_1.setExp(-100*p_1.getLevelAtk());
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
        System.out.println("========================================Refill===========================================");
        System.out.println("You have\n\tpotion : "+p_1.getPotion()
                +"/"+p_1.getLimitPotion()
                +"\n\tmini bomb : "+p_1.getMiniBomb()+"/"+p_1.getLimitMiniBomb());
        int gold=(100*(p_1.getLimitPotion()-p_1.getPotion()))+(100*(p_1.getLimitMiniBomb()-p_1.getMiniBomb()));
        System.out.println("refill(use "+gold+" G)\nAre you sure about that?\n"
                         + "(y)yes             (n)no");
        System.out.print("Choose: ");
        String re = tp.enter.nextLine();
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
        System.out.println("You have "+p_1.getGold()+" Gold\n"
                       + "(1)backpack\n"
                       + "(2)damage minibomb & healing power potion\n"
                       + "(3)weapon\n"
                       + "(b)back");
        
        System.out.print("Choose: ");
        String Upgrade = tp.enter.nextLine();
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
        boolean limi=true;
        while(limi){
                System.out.println("========================================Limit===========================================");
                
                
                int gold=200;
                
                System.out.println("(1)LimitPotion:   "+p_1.getLimitPotion()+"\n"
                                 + "(2)LimitMiniBomb: "+p_1.getLimitMiniBomb()+"\n"
                                 + "(b)back");
                System.out.print("Choose: ");
                String Limi = tp.enter.nextLine();
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
        boolean power=true;
        while(power){
        System.out.println("========================================Heal&Explotion===========================================");
                
                
                int gold=100;
                
                System.out.println("(1)MiniBomb: "+p_1.getExplotion()+" use 100 gold\n"
                                 + "(2)Potion:   "+p_1.getHeal()+"      use 100 gold\n"
                                 + "(b)back");
                System.out.print("Choose: ");
                String Limi = tp.enter.nextLine();
                switch(Limi){
                case"1":
                    if(p_1.getGold()>=gold){
                        
                        p_1.setExplotion(20);
                    }else{
                        System.out.println("Have not enough money");}
                    break;
                case"2":
                    if(p_1.getGold()>=gold){p_1.setHeal(50);
                    }else{
                    System.out.println("Have not enough money");}break;
                case"b":case"B":power=false;break;
                default :power = true  ;break;
                }
                }
     }
     void upgradeweapon(){
         boolean wp = true;
         while(wp){
         System.out.println("========================================UpgradeWeapon===========================================");
                
                
                int gold=1000*p_1.getLevel();
                System.out.println(p_1.getWeaponName()+" level "+p_1.getLevel()+" use "+gold+" Gold"+" ATK"+p_1.getWeaponDamage());
                
                System.out.println("do you want to upgrade Y/N");
                String Upgrade = tp.enter.nextLine();
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
    void ChangeWeapon(){
        boolean cw = true ;
        while(cw){
        System.out.print("========================================Change Weapons===========================================\n"
                       + "(1)Heavy Sword      Lv."+p_1.getLevelType(0)+"\n"
                       + "(2)Short Hand Sword Lv."+p_1.getLevelType(1)+"\n"
                       + "(3)Huntsman Knife   Lv."+p_1.getLevelType(2)+"\n"
                       + "(b)Back");
        
        System.out.println("Choose: ");
        String changeweapons = tp.enter.nextLine();
        if(changeweapons.equals("b"))
            cw=false;
        else
            switch(changeweapons){
                case "1" :  p_1.setWeaponType(1);
                      System.out.println("you have Heavy Sword");break;
                case "2" :  p_1.setWeaponType(2);
                      System.out.println("you have Short Hand Sword");break;
                case "3" :  p_1.setWeaponType(3);
                      System.out.println("you have Huntsman Knife");break;
            }
        
        }
}    
}
