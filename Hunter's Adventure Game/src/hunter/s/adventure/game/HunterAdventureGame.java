package hunter.s.adventure.game;
import java.util.ArrayList;
public class HunterAdventureGame {
    public static void main(String args[]){
        Tools_pack UI = new Tools_pack();                
        ArrayList<Player> slots = new ArrayList();
        Player player = new Player();
        State state = new State();
        Home homeTown=new Home();
        boolean playing = true;
        boolean SlotIsNull=true;
        boolean selectedSlot=false;
        String input,temp;
        
        UI.startGame();
        
        input=UI.enter.nextLine();
        temp=input;    
        while(playing){
            while(SlotIsNull&&playing){
                selectedSlot=false;
                UI.mainMenu(slots.size());
                input=UI.enter.nextLine();
                switch(input){
                    case"1":
                        
                        System.out.println(">Create New Slot");
                        boolean check;
                        String name=null;
                        System.out.println("\tcreate your name");
                        do{
                            input=UI.resistNaming();
                            check=UI.checkName(input,slots);
                            if(check){
                                System.out.println("Name \""+input+"\" already exist");
                            }else{
                                name=input;
                            }
                        }while(check);
                        boolean TypeWeaponUnable=true;
                        int weaponType=0;
                        UI.chooseWeapon();
                        do{
                            System.out.print("choose:");
                            input=UI.enter.nextLine();
                            switch(input){
                                case"1":case"2":case"3":
                                    if(UI.StringToNum(input)){
                                        weaponType=UI.getNum();
                                        TypeWeaponUnable=false;
                                    }
                            }
                            
                        }while(TypeWeaponUnable);
                        player=new Player(name,weaponType);
                        slots.add(player);
                    case"2":
                        if(slots.size()>0){
                            input=UI.selectSlot(slots);
                            if(input.equals("r")){
                                input=UI.removeSlot(slots);
                                if(UI.StringToNum(input)){
                                    int removeAt=UI.getNum()-1;
                                    boolean confirmDeleteSlot=false;
                                    System.out.print("enter name for confirm :");
                                    input=UI.enter.nextLine();
                                    if(input.equals(slots.get(removeAt).getName())){
                                        confirmDeleteSlot=true;
                                    }else
                                        System.out.println(">Delete Fail!");
                                    if(confirmDeleteSlot){
                                        System.out.println(">Deleting slot at "+(removeAt+1)
                                                +" name:"+slots.get(removeAt).getName());
                                        slots.remove(removeAt);
                                        System.out.println("slot deleted.");
                                    }
                                }
                                System.out.println("returning to Main Menu");
                            }else if(UI.StringToNum(input)){
                                player=slots.get(UI.getNum()-1);
                                SlotIsNull=false;
                                selectedSlot=true;
                            }  
                        }else{
                            System.out.println("please press 1 for New game.");
                    break;
                    }
                    break;
                    case"0":playing=false;
                    break;    
                }
            }
            
            boolean stateSelected=false;
            boolean stateIsNull=true;
            int stateAt=0;
            
            while(selectedSlot&&stateIsNull){
                input=UI.homeTown();
                homeTown=new Home(player);
                switch(input){
                    case"1":homeTown.Refill();
                        break;
                    case"2":homeTown.Upgrade();
                        break;
                    case"3":homeTown.ChangeWeapon();
                        break;
                    case"4"://@select state
                        //clear
                        input=UI.chooseState(player.getStates());
                        if(UI.StringToNum(input)){
                            stateAt=UI.getNum();
                            stateSelected=true;
                            stateIsNull=false;
                        }
                        break;
                    case"b"://@main menu
                        //clear
                        SlotIsNull=true;
                        selectedSlot=false;
                        break;
                }
            }
            boolean confirmState=false;
            while(stateSelected){
                input = UI.sureState(stateAt);
                switch(input){
                    case"1":
                        System.out.println(stateAt);
                        state = new State(stateAt-1);
                        confirmState=true;
                        stateSelected=false;
                        break;
                    case"b":
                        stateSelected=false;
                        System.out.println("Returning to Home");
                }
            }
            boolean alive=true;
            int hp=player.getHp();
            while(confirmState){
                for(int waveAt=0;waveAt<state.getAmountWave()&&alive&&state.getBattle();waveAt++){
                    alive=state.wave(waveAt,hp,player);
                    hp=state.getHp();
                }
                state.Result(alive);
                confirmState=false;
            }
        }
        UI.exit(slots);
    }
    
}
