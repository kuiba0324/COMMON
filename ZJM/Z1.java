package COMMON.ZJM;

import java.util.Locale;

public class Z1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));		//?
		System.out.println(Locale.getDefault().getCountry());
		//循环输出locale支持的全部区域
		Locale[] ls = Locale.getAvailableLocales();
		for (Locale locale : ls) {

			System.out.println("locale :" + locale.getDisplayCountry());

		}
	}

}
