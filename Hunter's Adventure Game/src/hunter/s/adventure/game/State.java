package hunter.s.adventure.game;
import java.util.ArrayList;
public class State extends Map implements StatesInfo{
    int G;
    int Xp;
    int StateAt;
    int amountWave;
    int amountMon;
    boolean waveFine;
    String waves[];
    char con_num[]={'0','1','2','3','4','5','6','7','8','9'};
    ArrayList<Monster[]> Waves= new ArrayList();
    State(int stateAt){
        decodeState(States[stateAt]);
        if(waveFine)
            for(int i=0;i<waves.length;i++)
                System.out.println("Wave "+(i+1)+" :"+waves[i]);
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
                    key="";
                    wave+=raw.charAt(i);
                break;
                case'n':
                    waves[index]=wave;
                    wave="";
                    index-=1;
                    
                break;
                case'_':
                    wave+=raw.charAt(i);
                    key="";
                    break;
                case'e':
                    waves[index]=wave;
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
}
