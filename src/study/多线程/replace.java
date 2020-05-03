import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/1 17:08
 */

public class replace {

    public static void main(String[] args) throws Exception {
        InputStreamReader in=new InputStreamReader(new FileInputStream("C:\\Users\\YinWangPing\\Desktop\\str.txt"),"GBK");
        //InputStreamReader接受一个InputStream对象，和编码格式
        BufferedReader bufferedReader=new BufferedReader(in);
        //BufferedReader接受一个Reader对象，并提供有逐行读取的readLine（）功能
        String line="";
        String res="";
        int count=1;
        while ((line=bufferedReader.readLine())!=null){
            if (line.contains("<td ")){
                line=line.replace("<td ","<td id="+count+++" ");
                res=res+"\n"+line;
            }else {
                res=res+"\n"+line;
            }
        }
        bufferedReader.close();
        System.out.println(res);
    }
}
