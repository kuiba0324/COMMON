package COMMON.EighthPackage;

import java.util.Scanner;

//应用字符界面的输入

public class Class8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 在字符界面输入字符串
		System.out.println("请输入字符串");
		System.out.println(ConsoleInput.readString());

		// 在字符界面输入整数
		System.out.println("请输入整数");
		System.out.println(ConsoleInput.readInt());
		
		//或者直接采用java1.5開始支持的Scanner
//		Scanner s = new Scanner(System.in);
//		System.out.println(s.next());
	}  
}

// 能够在字符界面输入不同类型数据的类
class ConsoleInput {
	// 该静态函数可以在字符界面输入字符串
	public static String readString() {
		String result = null;
		try {
			
			byte[] bytes = null;
			//for (int j = 0;j<20;j++) {
				// 利用System.in.read输入字符信息到字节数组中
				bytes = new byte[1000];
				System.in.read(bytes);
				/*
				 * 以二进制（基数 2）无符号整数形式返回一个整数参数的字符串表示形式。 如果参数为负，该无符号整数值为参数加上
				 * 232；否则等于该参数。 将该值转换为二进制（基数 2）形式的无前导 0 的 ASCII 数字字符串。
				 */
				for (int i = 0; i < 10; i++) {
					int by = bytes[i];
					if (by < 0) {
						by = by * -1;
					}
					//System.out.println(by);
					System.out.println(Integer.toBinaryString(by));

				}

			//}
			
			// 通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String并 去掉尾部的无用空格
			/*
			 * 返回字符串的副本，忽略前导空白和尾部空白。
			 * 如果此 String 对象表示一个空字符序列，或者此 String 对象表示的字符序列的第一个和最后一个字符的代码都大于 '\u0020'（空格字符），则返回对此 String 对象的引用。
			 * 否则，若字符串中没有代码大于 '\u0020' 的字符，则创建并返回一个表示空字符串的新 String 对象。
			 * 否则，假定 k 为字符串中代码大于 '\u0020' 的第一个字符的索引，m 为字符串中代码大于 '\u0020' 的最后一个字符的索引。创
			 * 建一个新的 String 对象，它表示此字符串中从索引 k 处的字符开始，到索引 m 处的字符结束的子字符串，即 this.substring(k, m+1) 的结果。
			 * 
			 * 此方法可用于截去字符串开头和末尾的空白（如上所述）
			 * */
			result = new String(bytes).trim();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	// 该静态函数可在字符界面输入整数
	public static int readInt() {
		int result = 0;
		try {
			// 利用System.in.read输入字符信息到字节数组中
			byte[] bytes = new byte[1000];
			System.in.read(bytes);
			String str = new String(bytes).trim();

			// 将字符串转化为整数
			result = Integer.parseInt(str);
		} catch (Exception e) {

		}

		return result;
	}

}