package hunter.s.adventure.game;
public abstract class Map {
    public Player player;
    tools_pack tool=new tools_pack();
    public Map(Player p_1){
        this.player=p_1;
    }   
    public abstract void showPlace();
}
