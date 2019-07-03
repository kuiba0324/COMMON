package COMMON.SecondProject;
//字符验证：利用正则表达式查找特定格式文本，比方说如下，检测原始文本是否为合法http网址


import java.util.regex.Pattern;
public class Project_Second {
	public static void main(String[] args){
		System.out.println("程序开始");
		Pattern pattern = Pattern.compile("http(s)?://([\\w-]+\\.)+[ \\w-]+(/[\\w- ./?%&=]*)?");
		//要被检查的原始文本
		String str  = "http://www.njmars.net";
		
		//判断是否能匹配
		boolean result = pattern.matcher(str).matches();
		
		//显示匹配结果
		if(result){
			System.out.println(str + "是有效的http网址");
		}else{
			System.out.println(str+"不是有效的http网址");
		}
	}
}
