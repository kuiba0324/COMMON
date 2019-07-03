package COMMON.EnumPackage;

import java.util.Calendar;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map.Entry;

enum ColorEnum4 {
    SUN(1,"星期日"),
    MON(2,"星期一"),
    TUE(3,"星期二"),
    WEN(4,"星期三"),
    THR(5,"星期四"),
    FRI(6,"星期五"),
    SAT(7,"星期六");
    
    private Integer ID;
    private String NAME;
    private ColorEnum4(Integer iD, String nAME) {
        ID = iD;
        NAME = nAME;
    }
    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        ID = iD;
    }
    public String getNAME() {
        return NAME;
    }
    public void setNAME(String nAME) {
        NAME = nAME;
    }
    
    
}

//public class EnumSet_AND_EnumMap {
// 
//    private void GetWeekDay01() {
//        Calendar c=Calendar.getInstance();
////        int day=c.get(Calendar.DAY_OF_WEEK);
//        System.out.print("今天是：");
//        switch (c.get(Calendar.DAY_OF_WEEK)) {
//            case 1:
//                System.out.println(ColorEnum4.SUN.getNAME());
//                break;
//            case 2:
//                System.out.println(ColorEnum4.MON.getNAME());
//                break;
//            case 3:
//                System.out.println(ColorEnum4.TUE.getNAME());
//                break;
//            case 4:
//                System.out.println(ColorEnum4.WEN.getNAME());
//                break;
//            case 5:
//                System.out.println(ColorEnum4.THR.getNAME());
//                break;
//            case 6:
//                System.out.println(ColorEnum4.FRI.getNAME());
//                break;
//            case 7:
//                System.out.println(ColorEnum4.SAT.getNAME());
//                break;
//            default:
//                break;
//        }
//    }
//    private void GetWeekDay02() {
//        Calendar c=Calendar.getInstance();
//        int day=c.get(Calendar.DAY_OF_WEEK);
//        for(ColorEnum4 e:ColorEnum4.values()) {
//            if(e.getID()==day) {
//                System.out.println("今天是："+e.getNAME());
//            }
//        }
//    }
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        new EnumSet_AND_EnumMap().GetWeekDay01();
//        new EnumSet_AND_EnumMap().GetWeekDay02();
//    }
// 
//}


class EnumSet_AND_EnumMap {
   
    public void EnumMapTest() {
        EnumMap<ColorEnum4, String> map=new EnumMap<ColorEnum4, String>(ColorEnum4.class);
        map.put(ColorEnum4.SUN, "sunday");	
        map.put(ColorEnum4.SUN, "sunday01");//覆盖
        map.put(ColorEnum4.MON, "monday");
        map.put(ColorEnum4.TUE, "tuesday");
        for(Entry<ColorEnum4, String> entry:map.entrySet()) {
            System.out.println(entry.getKey().getNAME()+" "+entry.getValue());
            System.out.println(entry.getKey().ordinal());
        }
    }
    public void EnumSetTest() {
        //获取指定部分
       EnumSet<ColorEnum4> set1=EnumSet.of(ColorEnum4.SUN,ColorEnum4.MON);
       System.out.println("set1:"+set1);
       //获取除指定部分外的剩余部分
       EnumSet<ColorEnum4> set2=EnumSet.complementOf(set1);
       System.out.println("set2:"+set2);
       //查询所有
       EnumSet<ColorEnum4> set3=EnumSet.allOf(ColorEnum4.class);
       System.out.println("set3:"+set3);
       //输出范围内实例
       EnumSet<ColorEnum4> set4=EnumSet.range(ColorEnum4.WEN,ColorEnum4.FRI);
       System.out.println("set4:"+set4);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	System.out.println("EnumMap");
        //new EnumSet_AND_EnumMap().EnumSetTest();
        new EnumSet_AND_EnumMap().EnumMapTest();
        
        
    }
 
}


