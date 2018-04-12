package hunter.s.adventure.game;
public class State extends Map implements MonstersInfo{
    int G;
    int Xp;
    int StateAt;
    State(int stateAt){
        
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
    void deCode(String raw){
        Tools_pack tool=new Tools_pack();
        for(int i=0;i<raw.length();i++){
            
        }
    }
}
