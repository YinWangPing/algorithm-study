package study.JDKProxy;

public class MyClassLoader extends ClassLoader {
    public Class<?> defineMyClasss(byte [] b, int off,int len){
        return super.defineClass("study.JDKProxy.Programmer",b,off,len);
    }
}
