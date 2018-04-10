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
public class Player extends Character{
    private final String name;
    private boolean states[]={true,false,false,false,false,
                              false,false,false,false,false};
    private int Gold;
    private int Exp;
    private int StateClear;
    Player(){
        super();
        this.name=null;
    }
    Player(String n){
        super(n);
        this.name= n;
        this.states[0]=true;
    }
    public String getName(){
        return name;
    }
    void setState(boolean state,int i){
        this.states[i]=state;   
    }
    boolean getState(int i){
        return this.states[i];
    }
    boolean[] getStates(){
        return this.states;
    }
    private void setStateClear(boolean states[]){
        int stateClear=0;
        for(int i=0;i<states.length;i++){
            if(states[i])
                stateClear++;
        }
        this.StateClear=stateClear;
    }
    public int getStateClear(){
        setStateClear(this.states);
        return this.StateClear;
    }
    public void setGold(int g){
        this.Gold+=g;
    }
    public void setExp(int xp){
        this.Exp+=xp;
    }
    public int getGold(){
        return this.Gold;
    }
    public int getExp(){
        return this.Exp;
    }
}
