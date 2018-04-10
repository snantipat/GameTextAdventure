/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter.s.adventure.game;

/**
 *
 * @author Domekenji
 */

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
        System.out.print("\tHUNTER’s ADVENTURE\n" +
                         "\tnew game(1)\n");
        if(size>0)
            System.out.println("\tcontinue(2)");
   
        System.out.print("\texit(0)\n" +
                         "enter:");
        
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
        System.out.println("Back(b)");
                boolean slotIsNull=true;
                String input=null;
                while(slotIsNull){
                    System.out.print("Choose slot:");
                    input=enter.nextLine();
                    if(StringToNum(input)){
                        for(int i = 0;i<slots.size()&&(this.num-1)<slots.size();i++){
                            if((this.num-1)==i)
                                slotIsNull=false;
                        }
                    }
                    else if(input.equalsIgnoreCase("b"))
                        slotIsNull=false;
                }
                
        return input;
    }
    public String homeTown(){
        String input=null;
            //1 2 3 4 b
        boolean chooseIsNull=true;
            System.out.println("=============Home Town============="
                    + "\n\t(1)Weapon Shop"
                    + "\n\t(2)Utility Shop"
                    + "\n\t(3)Up Stat"
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
}
