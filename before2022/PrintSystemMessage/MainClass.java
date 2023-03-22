package COMMON.PrintSystemMessage;
//输出Java 属性信息
/*
 * 键 	相关值的描述
java.version 	Java 运行时环境版本
java.vendor 	Java 运行时环境供应商
java.vendor.url 	Java 供应商的 URL
java.home 	Java 安装目录
java.vm.specification.version 	Java 虚拟机规范版本
java.vm.specification.vendor 	Java 虚拟机规范供应商
java.vm.specification.name 	Java 虚拟机规范名称
java.vm.version 	Java 虚拟机实现版本
java.vm.vendor 	Java 虚拟机实现供应商
java.vm.name 	Java 虚拟机实现名称
java.specification.version 	Java 运行时环境规范版本
java.specification.vendor 	Java 运行时环境规范供应商
java.specification.name 	Java 运行时环境规范名称
java.class.version 	Java 类格式版本号
java.class.path 	Java 类路径
java.library.path 	加载库时搜索的路径列表
java.io.tmpdir 	默认的临时文件路径
java.compiler 	要使用的 JIT 编译器的名称
java.ext.dirs 	一个或多个扩展目录的路径
os.name 	操作系统的名称
os.arch 	操作系统的架构
os.version 	操作系统的版本
file.separator 	文件分隔符（在 UNIX 系统中是“/”）
path.separator 	路径分隔符（在 UNIX 系统中是“:”）
line.separator 	行分隔符（在 UNIX 系统中是“/n”）
user.name 	用户的账户名称
user.home 	用户的主目录
user.dir 	用户的当前工作目录*/
public class MainClass {
	public static void main(String[] args){
		System.out.println("程序开始");
		java.util.Properties pop = System.getProperties();
		java.util.Enumeration e = pop.propertyNames();
		while(e.hasMoreElements()){
			String popName = (String)e.nextElement();
			String popValue = (String)pop.get(popName);
			System.out.println(popName+"    ======   "+popValue);
			
		}
	}
}
/*
 * 程序开始
java.runtime.name    ======   Java(TM) SE Runtime Environment
sun.boot.library.path    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\bin
java.vm.version    ======   25.112-b15
java.vm.vendor    ======   Oracle Corporation
java.vendor.url    ======   http://java.oracle.com/
path.separator    ======   ;
java.vm.name    ======   Java HotSpot(TM) 64-Bit Server VM
file.encoding.pkg    ======   sun.io
user.script    ======   
user.country    ======   CN
sun.java.launcher    ======   SUN_STANDARD
sun.os.patch.level    ======   
java.vm.specification.name    ======   Java Virtual Machine Specification
user.dir    ======   E:\Myeclipseworkplace\COMMONProject
java.runtime.version    ======   1.8.0_112-b15
java.awt.graphicsenv    ======   sun.awt.Win32GraphicsEnvironment
java.endorsed.dirs    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\endorsed
os.arch    ======   amd64
java.io.tmpdir    ======   C:\Users\DELL\AppData\Local\Temp\
line.separator    ======   

java.vm.specification.vendor    ======   Oracle Corporation
user.variant    ======   
os.name    ======   Windows 10
sun.jnu.encoding    ======   GBK
java.library.path    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;C:\Program Files (x86)\Common Files\Oracle\Java\javapath;C:\ProgramData\Oracle\Java\javapath;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\iCLS\;C:\Program Files\Intel\Intel(R) Management Engine Components\iCLS\;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Windows\System32\OpenSSH\;C:\Program Files (x86)\NVIDIA Corporation\PhysX\Common;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;D:\swiftforelement\Elements\bin;C:\Program Files\NVIDIA Corporation\NVIDIA NvDLISR;C:\Program Files\Git\cmd;D:\JDK\jre\bin;D:\JDK\bin;C:\Program Files\Intel\WiFi\bin\;C:\Program Files\Common Files\Intel\WirelessCommon\;C:\Users\DELL\AppData\Local\Microsoft\WindowsApps;D:\Visual Studio Code\Microsoft VS Code\bin;C:\Users\DELL\AppData\Local\GitHubDesktop\bin;D:\Docker\Docker Toolbox;.
java.specification.name    ======   Java Platform API Specification
java.class.version    ======   52.0
sun.management.compiler    ======   HotSpot 64-Bit Tiered Compilers
os.version    ======   10.0
user.home    ======   C:\Users\DELL
user.timezone    ======   
java.awt.printerjob    ======   sun.awt.windows.WPrinterJob
file.encoding    ======   GBK
java.specification.version    ======   1.8
user.name    ======   DELL
java.class.path    ======   E:\Myeclipseworkplace\COMMONProject\bin;D:\JDK\jre\lib\rt.jar;E:\Myeclipseworkplace\COMMONProject\napkinlafjar\napkinlaf.jar;E:\Myeclipseworkplace\COMMONProject\src\abc
java.vm.specification.version    ======   1.8
sun.arch.data.model    ======   64
java.home    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre
sun.java.command    ======   COMMON.PrintSystemMessage.MainClass
java.specification.vendor    ======   Oracle Corporation
user.language    ======   zh
awt.toolkit    ======   sun.awt.windows.WToolkit
java.vm.info    ======   mixed mode
java.version    ======   1.8.0_112
java.ext.dirs    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\ext;C:\Windows\Sun\Java\lib\ext
sun.boot.class.path    ======   D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\resources.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\rt.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\sunrsasign.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\jsse.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\jce.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\charsets.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\lib\jfr.jar;D:\Myeclipse2017\binary\com.sun.java.jdk8.win32.x86_64_1.8.0.v112\jre\classes
java.vendor    ======   Oracle Corporation
file.separator    ======   \
java.vendor.url.bug    ======   http://bugreport.sun.com/bugreport/
sun.cpu.endian    ======   little
sun.io.unicode.encoding    ======   UnicodeLittle
sun.desktop    ======   windows
sun.cpu.isalist    ======   amd64
 * */
 