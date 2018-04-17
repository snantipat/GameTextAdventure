package hunter.s.adventure.game;
public class HunterAdventureGame {
    public static void main(String args[]){      
        inteface_game UI = new inteface_game();
        Player player = null;
        State state = null;
        Home homeTown=null;
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
                UI.mainMenu(UI.slots.size());
                input=UI.enter.nextLine();
                switch(input){
                    case"1":
                        String name=UI.createNewGame(UI.slots);
                        int weaponType=UI.chooseWeaponType();
                        player=new Player(name,weaponType,UI.getHp(),UI.getAtk());
                        UI.slots.add(player);
                    case"2":
                        if(UI.slots.size()>0&&UI.loadGame()){
                            player=UI.slots.get(UI.getNum()-1);
                            homeTown=new Home(player);
                            SlotIsNull=false;
                            selectedSlot=true;
                        }
                    break;
                    case"0":playing=false;
                    break;    
                }
            }
            
            boolean stateSelected=false;
            boolean stateIsNull=true;
            int stateAt=0;
            while(selectedSlot&&stateIsNull&&homeTown!=null&&player!=null){
                input=homeTown.Lobby();
                switch(input){
                    case"0":homeTown.Training_place();
                        break;
                    case"1":homeTown.Refill();
                        break;
                    case"2":homeTown.Upgrade();
                        break;
                    case"3":homeTown.ChangeWeapon();
                        break;
                    case"4":input=UI.chooseState(player.getStates());
                        if(UI.StringToNum(input)){
                            stateAt=UI.getNum();
                            stateSelected=true;
                            stateIsNull=false;
                        }
                        break;
                    case"b":
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
                        state = new State(stateAt-1,player);
                        confirmState=true;
                        stateSelected=false;
                        break;
                    case"b":
                        stateSelected=false;
                        System.out.println("[System]returning to Home");
                }
            }
            boolean alive=true;
            while(confirmState&&state!=null&&player!=null){
                int hp=player.getHP();
                for(int waveAt=0;waveAt<state.getAmountWave()&&alive&&state.getBattle();waveAt++){
                    alive=state.wave(waveAt,hp);
                    hp=state.getHp();
                }
                state.Result(alive);
                confirmState=false;
            }
        }
        UI.exit(UI.slots);
    }
}
