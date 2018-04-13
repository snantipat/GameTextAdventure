package hunter.s.adventure.game;
import java.util.ArrayList;
public class State extends Map implements StatesInfo{
    int G;
    int Xp;
    int StateAt;
    int amountWave;
    int amountMon;
    boolean waveFine;
    boolean battle=true;
    String waves[];
    Player player;
    
    char con_num[]={'0','1','2','3','4','5','6','7','8','9'};
    ArrayList<Monster> Mons= new ArrayList();
    State(int stateAt){
        decodeState(States[stateAt]);
        if(waveFine){
            this.amountWave=this.waves.length;
            System.out.println("================State "+stateAt+"======================");
        }else
            System.out.printf("--------<Load Waves fail!>---------",stateAt);
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
        String waves[]=null;
        //em0_2nm0_3nm0_3nm1_1w4 <
        boolean notFail=true;
        String key="";
        String wave="";
        int index=0;
        int length=0;
        for(int i=raw.length()-1;i>=0&&notFail;i--){
            switch(raw.charAt(i)){
                case'0':case'1':case'2':case'3':case'4':
                case'5':case'6':case'7':case'8':case'9':
                    key+=raw.charAt(i);
                    wave+=raw.charAt(i);
                break;
                case'w':
                    length=StringToNum(key);
                    waves=new String[length];
                    index=length-1;
                    key="";
                    wave="";
                break;
                case'm':
                    int index_m=StringToNum(key);
                    if(index_m<0||index_m>MonstersInfo.NAME.length)
                        notFail=false;
                    key="";
                    wave+=raw.charAt(i);
                break;
                case'n':
                    if(index>=0)
                        waves[index]=wave;
                    else
                        notFail=false;
                    
                    wave="";
                    index-=1;
                    
                break;
                case'_':
                    wave+=raw.charAt(i);
                    key="";
                    break;
                case'e':
                    if(index==0)
                        waves[index]=wave;
                        
                    else
                        notFail=false;
                    key="";
                break;
                default:notFail=false;
            }
        }
        if(waves!=null&&notFail){
            this.waves=waves;
        }else
            notFail=false;
        this.waveFine=notFail;
    }
    public boolean wave(int waveAt,int hp,Player player){
        
        boolean pass=false;
        this.player=player;
        return pass;
    }
    private void addMonsWaveAt(int i){
        String codeWave=waves[i];
        boolean codeFine=true;
        String key="";
        int amount=0;
        Monster mon;
        for(int runChar=0;i<codeWave.length()&&codeFine;runChar++){
            switch(codeWave.charAt(runChar)){
                case'0':case'1':case'2':case'3':case'4':
                case'5':case'6':case'7':case'8':case'9':
                    key+=codeWave.charAt(runChar);
                break;
                case'm':
                    int indexMon=StringToNum(key);
                    if(indexMon==15){
                        mon=new Defender(indexMon);
                    }else{
                        mon=new Attacker(indexMon);
                    }
                    while(amount>0){
                        this.Mons.add(mon);
                        amount-=1;
                    }
                    key="";
                break;
                case'_':
                    amount=StringToNum(key);
                    key="";
                break;
            }
        }
    }
    public int StringToNum(String num){
        int number=0;
        int digit=1;
        
        for(int i=num.length()-1;i>=0;i--){
            boolean numIsNull=true;
            for(int j=0;j<con_num.length&&numIsNull;j++){
                if(num.charAt(i)==con_num[j]){
                    number+=j*digit;digit*=10;numIsNull=false;
                }
            }
            
        }
        return number;
    }
    public int getAmountWave(){
        return this.amountWave;
    }
    public int getHp(){
        return player.getHp();
    }
    public boolean getBattle(){
        return this.battle;
    }
}
