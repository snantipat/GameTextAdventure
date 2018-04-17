package hunter.s.adventure.game;
import java.util.Scanner;
interface Tools{
    char NUM[]={'0','1','2','3','4','5','6','7','8','9'};
}
public class tools_pack implements Tools{
    private int num;
    public String enter_to_continoue;
    public Scanner enter = new Scanner(System.in);
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
        else
            this.num=0;
        return check;
    }
    public int StringToNum(String num,int type){
        int number=0;
        int digit=1;
        String key_temp="";
        if(type==2){
            for(int i=num.length()-1;i>=0;i--){
                key_temp+=num.charAt(i);
            }
            num=key_temp;
        }
        
            for(int i=num.length()-1;i>=0;i--){
                boolean numIsNull=true;
                for(int j=0;j<NUM.length&&numIsNull;j++){
                    if(num.charAt(i)==NUM[j]){
                        number+=j*digit;digit*=10;numIsNull=false;
                    }
                }
            
            }
        
        return number;
    }
    public void enterToContinoue(){
        System.out.print("enter to continoue >");
        enter_to_continoue=enter.nextLine();
    }
    public int getNum(){
       return this.num;
    }
}
