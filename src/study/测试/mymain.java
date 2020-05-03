//package study.测试;
//
//public interface mymain {
//    String calculateStringdisance(String expressionA,String expressinB){
//        int a=Stringdisance(expressionA,0,expressionA.length()-1,expressinB,0,expressinB.length()-1);
//        return "1/"+(Math.max(expressionA.length(),expressinB.length())-a+1);
//    }
//    int Stringdisance(String expressionA,int ALeft,int ARight,String expressinB,int BLeft,int BRight){
//        if(ALeft>ARight){
//            if(BLeft>BRight){
//                return 0;
//            }
//        }else {
//            return (BRight-BLeft+1);
//        }
//        if(BLeft>BRight){
//            if(ALeft>ARight){
//                return 0;
//            }
//        }else {
//            return (ARight-ALeft+1);
//        }
//        if(expressionA.charAt(ALeft)==expressinB.charAt(BLeft)){
//            return Stringdisance(expressionA,ALeft+1,ARight,expressinB, BLeft+1,BRight);
//        }else {
//            int r1=Stringdisance(expressionA,ALeft,ARight,expressinB, BLeft+1,BRight);
//            int r2=Stringdisance(expressionA,ALeft+1,ARight,expressinB, BLeft,BRight);
//            int r3=Stringdisance(expressionA,ALeft+1,ARight,expressinB, BLeft+1,BRight);
//            return Math.min(r1,Math.min(r2,r3))+1;
//        }
//    }
//}
