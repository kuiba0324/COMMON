package COMMON.FourthPackage;
//本范例演示了使用String类提供的split方法实现简单的分词处理（常应用于如搜索引擎对网页文本进行分词解析等）

public class Class4 {
	public static void main(String[] args){
		System.out.println("程序开始");
		//构造停用词表
		String[] stopList = {
				"and" ,"is" ,"an" ,"are" ,"at",
				"be" ,"by" ,"will"
		};
		//需要进行分词处理的语句
		String doc = "what are you fucking doing?";
		//为了确保能够正确搜索停用词，必须对停用词数组进行排序
		java.util.Arrays.sort(stopList);
		//根据任何非单词字符进行分词
		/*
		 * 该方法在匹配分词界限的时候，仍然采用正则表达式
		 */
		String[] results = doc.toLowerCase().split("\\W");
		
		//显示分词结果
		for(int i = 0;i<results.length;i++){
			//不显示无用的空字符
			if( results[i].equals("")){
				continue;
			}
			
			//不显示停用词
			if(java.util.Arrays.binarySearch(stopList, results[i] ) < 0){
				System.out.println(results[i]);
			}
		}
		
	
	}
}
