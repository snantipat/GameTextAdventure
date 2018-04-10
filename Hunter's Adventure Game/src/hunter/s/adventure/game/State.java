package hunter.s.adventure.game;
public class State extends Map{
    int G;
    int Xp;
    int StateAt;
    State(int stateAt){
    
    }
    State(){
    
    
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
}
