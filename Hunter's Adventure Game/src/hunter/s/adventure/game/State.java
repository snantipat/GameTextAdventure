package hunter.s.adventure.game;
import java.util.ArrayList;
public class State extends Map implements StatesInfo{
    int G;
    int Xp;
    int StateAt;
    int amountWave;
    int amountMon;
    boolean waveFine;
    ArrayList<Monster[]> waves= new ArrayList();
    State(int stateAt){
        decodeState(States[stateAt]);
    }
    State(){
        super();
    }
    int chooseState(){
        int i=0;
        return i;
    }
    void result(boolean result_){
        
    }
    int getXp(){
        return Xp;
    }
    int getG(){
        return G;
    }
    void resetState(){
        this.G=0;
        this.Xp=0;
    }
    int setState(boolean[] states_p){
        int stateAt=0;
        return stateAt;
    }
    
    public void decodeState(String raw){
        String wave_temp="";
        String amount_temp="";
        int amount;
        Monster mons[];
    }
}
