/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author Domekenji
 */
import java.util.ArrayList;
public class NewClass {
    public void testArrayList(){
        ArrayList<NewClass1[]> neq=new ArrayList();
        
        NewClass1 wave[]=new NewClass1[2];
        wave[0]=new NewClass1();
        wave[1]=new NewClass1();
        NewClass1 mon[];
        
        neq.add(wave);
        mon=neq.get(0);
        ArrayList<NewClass1> mons=new ArrayList();
        mons.add(mon[0]);
        
        ArrayList<NewClass1[]> t1=new ArrayList();
        t1.add(wave);
        ArrayList t2=new ArrayList();
        t2.add(t1);
        
        Object waves=t2.get(0);
        
        NewClass1 wp[]=(NewClass1[]) t2.get(0);
    }
}
