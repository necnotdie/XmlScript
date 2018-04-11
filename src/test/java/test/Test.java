package test;

import com.XmlScript.ruleutil.RulesLoad;

/**
 * Created by Administrator on 2018/3/1.
 */
public class Test {
    public static void main(String[] args){
        try {
            RulesLoad.Load("/ruleTest.xml","test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int get(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = (int)(Math.random()*10);
        return result;
    }
}
