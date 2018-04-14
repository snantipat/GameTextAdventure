package hunter.s.adventure.game;
import java.util.ArrayList;
import java.util.Scanner;
interface Tools{
    char NUM[]={'0','1','2','3','4','5','6','7','8','9'};
}
public class Tools_pack implements Tools{
    private int num;
    public Scanner enter = new Scanner(System.in);//for String only
    public void startGame(){
        System.out.println("=================================================="
                        +  "\n\n\tHUNTER’s ADVENTURE (HIGH ENRGY FORNT)"
                        +  "\n=================================================="
                        +  "\n\tpress enter to start game");
    }
    public void exit(ArrayList<Player> slots){
        System.out.println("Clearing memorys");
        for(int i = slots.size()-1;i>=0;i--){
            Player player;
                    player=slots.get(i);
            System.out.println("\tRemoving Slot "+player.getName());
            slots.remove(i);
            
        }
    }
    public void mainMenu(int size){
        int choose=2;
        System.out.print("+++++++++++++++++++++++++HUNTER’s ADVENTURE+++++++++++++++++++++++++\n" +
                         "\tnew game(1)\n");
        if(size>0)
            System.out.println("\tcontinue(2)");
   
        System.out.print("\texit(0)\n" +
                         "enter:");
        
    }
    public String resistNaming(){
        String name=null;
        boolean NotPass=true;
        while(NotPass){
            System.out.print("Name :");name=enter.nextLine();
            for(int i = 0;i<name.length();i++){
                if(!(name.equals("")||name.charAt(i)==' '))
                   NotPass=false;
            }
            if(NotPass)
               System.out.println("Naming can not be this \""+name+"\" word.");
        }
        return name;
    }
    public boolean checkName(String name,ArrayList<Player> slots){
        boolean repetitive=false;
        for(int i=0;i<slots.size();i++){
            if(slots.get(i).getName().equals(name))
                repetitive=true;
        }
        return repetitive;
    }
    public String selectSlot(ArrayList<Player> slots){
        System.out.println("------Load Game------");
        for(int i=0;i<slots.size();i++){
            System.out.println("Slot "+(i+1)+" :Name>"+slots.get(i).getName()
                            + "\n\tLast Auto save dd/mm/yyyy hh:mm "
                            + "\n\tState clear "+slots.get(i).getStateClear()
                            + "/"+10);
        }
        System.out.println("Back(b)\t\tDelete(r)");
                boolean slotIsNull=true;
                String input=null;
                while(slotIsNull){
                    System.out.print("Choose slot:");
                    input=enter.nextLine();
                    if(input.equalsIgnoreCase("b")||input.equalsIgnoreCase("r"))
                        slotIsNull=false;
                    else if(StringToNum(input)){
                        for(int i = 0;i<slots.size()&&(this.num-1)<slots.size()&&this.num>0;i++){
                            if((this.num-1)==i)
                                slotIsNull=false;
                        }
                        if(this.num>=slots.size()||this.num<=0)
                            System.out.println("Slot at "+this.num+" doesn't exist.");
                    }
                    else
                        System.out.println("Slot at "+input+" doesn't exist.");
                }
                
        return input;
    }public String removeSlot(ArrayList<Player> slots){
        String removeAt=null;
        System.out.println("==================Remove Slot======================");
            for(int i=0;i<slots.size();i++){
            System.out.println("Slot "+(i+1)+" :Name>"+slots.get(i).getName()
                            + "\n\tLast Auto save dd/mm/yyyy hh:mm "
                            + "\n\tState clear "+slots.get(i).getStateClear()
                            + "/"+10);
            }
            System.out.println("\nBack(b)");
            boolean slotIsNull=true;
                while(slotIsNull){
                    System.out.print("Choose slot:");
                    removeAt=enter.nextLine();
                    if(removeAt.equalsIgnoreCase("b"))
                        slotIsNull=false;
                    else if(StringToNum(removeAt)){
                        for(int i = 0;i<slots.size()&&(this.num-1)<slots.size()&&(this.num-1)>=0;i++){
                            if((this.num-1)==i)
                                slotIsNull=false;
                        }
                        if(this.num>slots.size()||this.num<=0)
                            System.out.println("Slot at "+this.num+" dosen't exist.");
                    }else
                        System.out.println("Slot at "+removeAt+" dosen't exist.");
                }
            
        return removeAt;
    }
    
    public String homeTown(){
        NPC npc1 = null,npc2 = null,npc3 = null;
        Player p1 = null;
        String input=null;
        Home h = new Home(npc1,npc2,npc3,p1);
            //1 2 3 4 b
        boolean chooseIsNull=true;
            System.out.println("=============Home Town============="
                    + "\n\n\t(1)Refill"
                    + "\n\t(2)Upgrade"
                    + "\n\t(3)Change Weapon"
                    + "\nSelect State(4)\t\t\tMain Menu(b)");
        while(chooseIsNull){
            System.out.print("Choose : ");input=enter.nextLine();
            switch(input){
                case"1":case"2":case"3":case"4":case"b":chooseIsNull=false;
            }
        }
        return input;
    }
    public String sureState(int stateAt){
        String input = null;
        boolean inputIsNull=true;
        System.out.printf("================STATE %d=================="
                + "\n\t\tStart(1)"
                + "\nHome(b)",stateAt);
        while(inputIsNull){
            System.out.print("Choose:");input=enter.nextLine();
            switch(input){
                case"1":case"b":inputIsNull=false;
            }
        }
        return input;
    }
    public String chooseState(boolean[] states_p){
        String input=null;
        System.out.println("==============MAP==============");
        for(int i = 0;i < states_p.length;i++){
            if(states_p[i])
                System.out.print("\t"+(i+1));
            else
                System.out.print("\t["+(i+1)+"]");
        }
        System.out.println("\nHome(b)");
        boolean chooseIsNull=true;
        while(chooseIsNull){
            System.out.print("Select : ");
            input=enter.nextLine();
            switch(input){
                case"1":case"2":case"3":case"4":case"5":case"6":
                case"7":case"8":case"9":case"10":
                StringToNum(input);
                if(states_p[this.num-1])
                    chooseIsNull=false;
                else
                    System.out.println("You have to Complete state "+(this.num-1)+" first.");
                break;
                case"b":chooseIsNull=false;
                    break;
                default:
                    System.out.println("state "+input+" Not Found!");
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
        return check;
    }
    public int getNum(){
        int n_1=this.num;
        this.num=0;
       return n_1;
    }

    void chooseWeapon() {
        System.out.println("========================================Choose Weapons==========================================="
                + "\n\n\t(1)Heavy Sword\t60 damages\n\t  - one hit in one turn"
                + "\n\t(2)Short Hand Sword\t30 damages\n\t  - two hit in one turn"
                + "\n\t(3)Huntsman Knife\t10 damages\n\t  - three hit in one turn");
    }
}
