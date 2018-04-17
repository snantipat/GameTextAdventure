package hunter.s.adventure.game;

public class Home extends Map{
    Home(Player player){
        super(player);
    }
    public String Lobby(){
        Player p1 = null;
        String input=null;
        boolean chooseIsNull=true;
            System.out.println(">Home Town"
                    + "\n\t(0)Up Status"
                    + "\n\t(1)Refill Items"
                    + "\n\t(2)Upgrade Items"
                    + "\n\t(3)Change Weapon"
                    + "\nSelect State(4)\t\t\tMain Menu(b)");
        while(chooseIsNull){
            System.out.print("choose : ");input=tool.enter.nextLine();
            switch(input){
                case"0":case"1":case"2":case"3":case"4":case"b":chooseIsNull=false;
            }
        }
        return input;
    }
    void Training_place(){
        boolean training=true;
        while(training){
        System.out.println("=====================================Train Place=========================================");
        System.out.println("You have "+super.player.getEXP()+" EXP"
                + "\nYour current HP:"+super.player.getHP()+" ATK:"+super.player.getATK()
                + "\n(1)+10 HP point cost "+100*super.player.getLevelHp()+" EXP"
                + "\n(2)+5 ATK potnt cost "+100*super.player.getLevelAtk()+" EXP"
                + "\nBack(b)");
               String input=tool.enter.nextLine();
               switch(input){
                   case"1":
                       if(super.player.getEXP()>=100*super.player.getLevelHp()){
                            super.player.setHP(10);
                            super.player.setEXP(-100*super.player.getLevelHp());
                       }else{
                           System.out.println("Not enoungh Exp.");
                           tool.enterToContinoue();
                       }
                       break;
                   case"2":
                       if(super.player.getEXP()>=100*super.player.getLevelAtk()){
                            super.player.setATK(5);
                            super.player.setEXP(-100*super.player.getLevelAtk());
                       }else{
                           System.out.println("Not enoungh Exp.");
                           tool.enterToContinoue();
                       }
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
                + "\nYou have "+super.player.getGOLD()+" Gold");
        System.out.println("Your current\toolotion : "+super.player.getPotion()
                +"/"+super.player.getLimitPotion()
                +"\tmini bomb : "+super.player.getMiniBomb()+"/"+super.player.getLimitMiniBomb());
        int gold=(100*(super.player.getLimitPotion()-super.player.getPotion()))+(100*(super.player.getLimitMiniBomb()-super.player.getMiniBomb()));
        System.out.println("refill(use "+gold+" G)\nAre you sure about that?\n"
                         + "(y)yes             (n)no");
        System.out.print("Choose: ");
        String re = tool.enter.nextLine();
        switch(re){
            case "y":case"Y":
                if(super.player.getGOLD()>=gold){
                    super.player.setGOLD(-gold);
                    super.player.Refill();
                }else{
                    System.out.println("gold not enough");
                    tool.enterToContinoue();
                }
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
        System.out.println("You have "+super.player.getGOLD()+" Gold"
                       + "\nUpgrade List"
                       + "\n\t(1)Backpack\n"
                       + "\t(2)Damage Mini Bomb & Healing Power(potion)\n"
                       + "\t(3)Weapon Damage\n"
                       + "(b)Back");
        
        System.out.print("Choose: ");
        String Upgrade = tool.enter.nextLine();
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
                System.out.println("You have "+super.player.getGOLD()+" Gold"
                                 + "\nYour current backpack size"
                                 + "\tBackpack's Potion "+super.player.getLimitPotion()
                                 + "\tBackpack's Mini Bomb "+super.player.getLimitMiniBomb()
                                 + "\n\t(1)Upgrade Backpack's Potion "
                                 + "\n\t(2)Upgrade Backpack's MiniBomb "
                                 + "\nBack(b)");
                System.out.print("Choose: ");
                String Limi = tool.enter.nextLine();
                switch(Limi){
                case"1":

                    if(super.player.getGOLD()>=gold){
                        super.player.setLimitPotion(1);
                        super.player.setGOLD(-gold);
                    }else{
                        System.out.println("Not enough money");
                        tool.enterToContinoue();
                    }
                    break;
                case"2":
                    if(super.player.getGOLD()>=gold){
                        super.player.setLimitMiniBomb(1);
                        super.player.setGOLD(-gold);
                    }else{
                        System.out.println("Not enough money");
                        tool.enterToContinoue();
                    }
                    break;
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
                
                System.out.println("Your current "+super.player.getGOLD()+" Gold"
                        + "\n Damage's mini bomb:"+super.player.getExplotion()
                        + "\n Power's healing potion:"+super.player.getHeal()
                        + "\n\t(1)Upgarde Mini Bomb"
                        + "\n\t(2)Upgarde Potion"
                        + "\nback(b)");
                System.out.print("Choose: ");
                String Limi = tool.enter.nextLine();
                switch(Limi){
                case"1":
                    if(super.player.getGOLD()>=gold){
                        super.player.setExplotion(20);
                        super.player.setGOLD(-gold);
                    }else{
                        System.out.println("Not enough money");
                        tool.enterToContinoue();
                    }
                    break;
                case"2":
                    if(super.player.getGOLD()>=gold){
                        super.player.setHeal(50);
                        super.player.setGOLD(-gold);
                    }else{
                        System.out.println("Not enough money");
                        tool.enterToContinoue();
                    }break;
                case"b":case"B":power=false;break;
                default :power = true  ;break;
                }
                }
     }
     void upgradeWeapon(){
         boolean wp = true;
         while(wp){
         System.out.println("========================================Upgrade Weapon===========================================");
                
                
                int gold=1000*super.player.getLevel();
                System.out.println("You have "+super.player.getGOLD()+" Gold\n"
                        + "Your current weapon :"+super.player.getWeaponName()+" Lv."+super.player.getLevel()+" ATK"+super.player.getWeaponDamage()
                        + "\n Upgarde Weapon +"+WeaponInfo.WEADAM[super.player.getWeaponType()-1]+" Damages  (cost "+super.player.getLevel()*1000+" Gold)");
                System.out.print("Do you want to upgrade Y/N >");
                String Upgrade = tool.enter.nextLine();
                switch(Upgrade){
                    case "y" :case"Y":
                        if(super.player.getGOLD()>=gold){
                            super.player.UpgradeWeapon() ;
                            super.player.setGOLD(-gold);
                        }else{
                            System.out.println("Have not enough money");
                            tool.enterToContinoue();
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
        System.out.println("========================================Change Weapons==========================================="
                       + "\n\t(1)Heavy Sword      Lv."+super.player.getLevelType(0)+" "+super.player.getWeaponDamType(0)+" Damages"
                       + "\n\t(2)Short Hand Sword Lv."+super.player.getLevelType(1)+" "+super.player.getWeaponDamType(1)+" Damages"
                       + "\n\t(3)Huntsman Knife   Lv."+super.player.getLevelType(2)+" "+super.player.getWeaponDamType(2)+" Damages"
                       + "\nBack(B)");
        
        System.out.print("Choose: ");
        String changeweapons = tool.enter.nextLine();
        if(changeweapons.equalsIgnoreCase("b"))
            cw=false;
        else
            switch(changeweapons){
                case "1" :  super.player.setWeaponType(1);
                      System.out.println("Now using Heavy Sword");
                      tool.enterToContinoue();
                      break;
                case "2" :  super.player.setWeaponType(2);
                      System.out.println("Now using Short Hand Sword");
                      tool.enterToContinoue();
                      break;
                case "3" :  super.player.setWeaponType(3);
                      System.out.println("Now using Huntsman Knife");
                      tool.enterToContinoue();
                      break;
            }
        
        }
}    
}
