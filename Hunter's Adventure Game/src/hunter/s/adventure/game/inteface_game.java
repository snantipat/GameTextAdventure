package hunter.s.adventure.game;
import java.util.ArrayList;
import java.util.Scanner;
interface Tools{
    char NUM[]={'0','1','2','3','4','5','6','7','8','9'};
}
public class inteface_game implements Tools{
    private int num;
    private int hp;
    private int atk;
    public ArrayList<Player> slots = new ArrayList();
    public boolean loadGame(){
        String input;
        boolean chooseSlot=false;
        if(slots.size()>0){
            input=selectSlot(slots);
            if(input.equals("r")){
                input=removeSlot(slots);
                if(StringToNum(input)){
                    int removeAt=this.num-1;
                    boolean confirmDeleteSlot=false;
                    System.out.print("[System]enter name for confirm :");
                    input=enter.nextLine();
                    if(input.equals(slots.get(removeAt).getNAME())){
                        confirmDeleteSlot=true;
                    }else
                        System.out.println("[System]delete Fail!");
                    if(confirmDeleteSlot){
                        System.out.println("[System]deleting slot at "+(removeAt+1)
                                +" name:"+slots.get(removeAt).getNAME());
                        slots.remove(removeAt);
                        System.out.println("[System]slot deleted.");
                    }
                }
                System.out.println("[System]returning to Main Menu");
            }else if(StringToNum(input)){
                chooseSlot=true;
            }  
        }else
            System.out.println("[System]please press 1 for New game.");
        return chooseSlot;
    }
    public String  createNewGame(ArrayList<Player> slots){
        boolean check;
        String input;
        System.out.println(">Create New Slot");
                        do{
                            input=resistNaming();
                            check=checkName(input,slots);
                            if(check)
                                System.out.println("[System]name \""+input+"\" already exist");
                            else{
                                System.out.println("Saving Name "+input);
                                //setstatus
                                boolean choosing=true;
                                int stat=10;
                                this.hp=0;
                                this.atk=0;
                                do{
                                    System.out.println("You have "+stat+" stats."
                                            + "\nYour current [HP "+(hp*10)+"] [ATK "+(atk*5)+"]"
                                            + "\n\t(1)Up + 10 Health cost 1 stat."
                                            + "\n\t(2)Up + 5 Attack cost 1 stat.");
                                    System.out.print("choose:");
                                    String up=enter.nextLine();
                                    switch(up){
                                        case"1":
                                            if(this.hp<5){
                                                this.hp+=1;stat-=1;
                                            }else
                                                System.out.println("[System]can not up hp anymore.");
                                        break;
                                        case"2":
                                            if(this.atk<5){
                                                this.atk+=1;stat-=1;
                                            }else
                                                System.out.println("[System]can not up atk anymore.");
                                        break;
                                    }
                                }while(stat>0);
                                
                                this.hp*=10;
                                this.atk*=5;
                                System.out.println("[System]Current [HP "+this.hp
                                        +"] [ATK "+this.atk+"]");
                            }
                        }while(check);
        return input;               
    }
    public int chooseWeaponType(){
        boolean TypeWeaponUnable=true;
        int weaponType=0;
        chooseWeapon();
        do{
            System.out.print("choose:");
            String input=enter.nextLine();
            switch(input){
                case"1":case"2":case"3":
                    if(StringToNum(input)){
                        weaponType=this.num;
                        TypeWeaponUnable=false;
                    }else
                        System.out.println("[System]input again.");
            }
                            
        }while(TypeWeaponUnable);
        return weaponType;
    }
    public Scanner enter = new Scanner(System.in);//for String only
    public void startGame(){
        System.out.println(">Game Hunter's Adventure"
                        +  "\n\tpress enter to start game");
    }
    public void exit(ArrayList<Player> slots){
        System.out.println("[System]clearing memorys");
        for(int i = slots.size()-1;i>=0;i--){
            Player player;
                    player=slots.get(i);
            System.out.println("[System]removing slot [player]"+player.getNAME());
            slots.remove(i);
            
        }
    }
    public void mainMenu(int size){
        System.out.print(">MAIN MENU\n" +
                         "\tnew game(1)\n");
        if(size>0)
            System.out.println("\tcontinue(2)");
   
        System.out.print("\texit(0)\nenter:");
        
    }
    public String resistNaming(){
        String name=null;
        boolean NotPass=true;
        do{
            
            System.out.print("Name :");name=enter.nextLine();
            for(int i = 0;i<name.length()&&name.length()>2&&NotPass;i++){
                if(name.equals(""))
                   NotPass=true;
                else{
                    switch(name.charAt(i)){
                        case'1':case'2':case'3':case'4':case'5':case' ':
                        case'6':case'7':case'8':case'9':case'0':case',':
                            NotPass=true;
                        break;
                        default:NotPass=false;
                        
                    }
                }
            }
            if(NotPass)
               System.out.println("[System]naming can not be this \""+name+"\" word.");
        }while(NotPass);
        return name;
    }
    public boolean checkName(String name,ArrayList<Player> slots){
        boolean repetitive=false;
        for(int i=0;i<slots.size();i++){
            if(slots.get(i).getNAME().equals(name))
                repetitive=true;
        }
        return repetitive;
    }
    public String selectSlot(ArrayList<Player> slots){
        System.out.println(">Load Game");
        showSlots(slots);
        System.out.println("Back(b)\t\tDelete(r)");
                boolean slotIsNull=true;
                String input=null;
                while(slotIsNull){
                    System.out.print("choose slot:");
                    input=enter.nextLine();
                    if(input.equalsIgnoreCase("b")||input.equalsIgnoreCase("r")){
                        slotIsNull=false;
                    }else if(StringToNum(input)&&input.length()<6){
                        for(int i = 0;i<slots.size()&&(this.num-1)<slots.size()&&this.num>0;i++){
                            if((this.num-1)==i)
                                slotIsNull=false;
                        }
                        if(this.num>slots.size()||this.num<0)
                            System.out.println("[System]slot at "+this.num+" doesn't exist.");
                    }
                    else
                        System.out.println("[System]slot at "+input+" doesn't exist.");
                }
                
        return input;
    }
    public void showSlots(ArrayList<Player> slots){
        for(int i=0;i<slots.size();i++){
            System.out.println(" Slot "+(i+1)
                    + "\t[Name] "+slots.get(i).getNAME()
                    + " [HP] "+slots.get(i).getHP()+" [ATK] "+slots.get(i).getATK()
                    + "\n\t[GOLD] "+slots.get(i).getGOLD()+" [EXP] "+slots.get(i).getEXP()
                    + "\n\t[WEAPON] "+slots.get(i).getWeaponName()+" Lv."+slots.get(i).getLevel()
                    + "\n\t[POTION] "+slots.get(i).getPotion()+"/"+slots.get(i).getLimitPotion()
                    + " [MINI BOMB] "+slots.get(i).getMiniBomb()+"/"+slots.get(i).getLimitMiniBomb()
                    + "\n\tState Clear "+slots.get(i).getStateClear()
                    + "/"+10);
            }
    }
    public String removeSlot(ArrayList<Player> slots){
        String removeAt=null;
        System.out.println(">Remove Slot");
            //details
            showSlots(slots);
            System.out.println("\nBack(b)");
            boolean slotIsNull=true;
                while(slotIsNull){
                    System.out.print("choose slot:");
                    removeAt=enter.nextLine();
                    if(removeAt.equalsIgnoreCase("b"))
                        slotIsNull=false;
                    else if(StringToNum(removeAt)){
                        for(int i = 0;i<slots.size()&&(this.num-1)<slots.size()&&(this.num-1)>=0;i++){
                            if((this.num-1)==i)
                                slotIsNull=false;
                        }
                        if(this.num>slots.size()||this.num<=0)
                            System.out.println("[System]slot at "+this.num+" dosen't exist.");
                    }else
                        System.out.println("[System]slot at "+removeAt+" dosen't exist.");
                }
            
        return removeAt;
    }
    public String sureState(int stateAt){
        String input = null;
        boolean inputIsNull=true;
        System.out.printf(">STATE %d"
                + "\n\tStart(1)\tHome(b)",stateAt);
        while(inputIsNull){
            System.out.print("\nChoose:");input=enter.nextLine();
            switch(input){
                case"1":case"b":inputIsNull=false;
            }
        }
        return input;
    }
    public String chooseState(boolean[] states_p){
        String input=null;
        System.out.println(">MAP");
        for(int i = 0;i < states_p.length;i++){
            if(states_p[i])
                System.out.print("\t"+(i+1));
            else
                System.out.print("\t["+(i+1)+"]");
        }
        System.out.println("\nHome(b)");
        boolean chooseIsNull=true;
        while(chooseIsNull){
            System.out.print("select : ");
            input=enter.nextLine();
            switch(input){
                case"1":case"2":case"3":case"4":case"5":case"6":
                case"7":case"8":case"9":case"10":
                StringToNum(input);
                if(states_p[this.num-1])
                    chooseIsNull=false;
                else
                    System.out.println("[System]you have to Complete state "+(this.num-1)+" first.");
                break;
                case"b":chooseIsNull=false;
                    break;
                default:
                    System.out.println("[System]state "+input+" not found!");
            }   
            
        }
        return input;
    }
    public boolean StringToNum(String raw){
        boolean check=true;
        boolean isNumber=true;
        int n=0;
        int degit=1;
        for(int i_raw=raw.length()-1;i_raw>=0&&isNumber;i_raw--){
            isNumber=false;
            boolean numNotFound=true;
            for(int i_num = 0;i_num<NUM.length&&numNotFound;i_num++){
                if(raw.charAt(i_raw)==NUM[i_num]){
                    isNumber=true;numNotFound=false;
                    n+=degit*i_num;degit*=10;
                }
            }
            if(numNotFound)
                check=false;
        }
        if(check)
            this.num=n;
        else
            this.num=0;
        return check;
    }
    public int getNum(){
       return this.num;
    }
    public int getAtk(){
        return this.atk;
    }
    public int getHp(){
        return this.hp;
    }
    void chooseWeapon(){
        System.out.println(">Choose Weapons"
                + "\n\t(1)Heavy Sword   \t60 damages <1 hit/turn>"
                + "\n\t(2)Short Hand Sword\t30 damages <2 hit/turn>"
                + "\n\t(3)Huntsman Knife\t20 damages <3 hit/turn>");
    }
}
