package COMMON.ElevenPackage;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

//集合分页
/*
 * 利用多页面在有限的空间内动态显示全部的集合元素
 * 
 * */
public class Class11 {
	public static void main(String[] args){
		System.out.println("程序开始");
		//生成含有20个整数的集合
		List lists = new ArrayList();
		for(int i = 0;i<20;i++){
			lists.add(new Integer(i));
		}
		
		//利用page类对集合分页
		Page page = new Page(lists,5);
		//显示所有页面的所有记录
		page.first();
		for(int i = 0;i<page.getTotalPage();i++){
			//得到当前页面记录
			List list  = page.getPageContents();
			Iterator it = list.iterator();
			while(it.hasNext()){
				Integer integer = (Integer)it.next();
				System.out.print(integer+"\t");
				
			}
			
			System.out.println();
			page.next();
		}
	}
}


//分页类
class Page{
	//每页记录数
	private int recordsInPage;
	//当前页数
	private int currentPage=1;
	//总页数
	private int totalPage=0;
	//需要分页的集合
	private List list;
	
	//对集合，每页记录数进行初始化并得到总页数
	public Page(List list,int recordsInPage){
		this.list  =list;
		this.recordsInPage = recordsInPage;
		
		this.totalPage= (list.size()-1)/recordsInPage+1;
		
	}
	
	//定位到第一页
	public void first(){
		currentPage = 1;
	}
	
	//定位到下一页
	public void next(){
		currentPage = currentPage+1;
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
	}
	
	//定位到上一页
	public void previous(){
		currentPage  = currentPage-1;
		if (currentPage < 0){
			currentPage = 1;
		}
	}
	
	//定位到最后一页
	public void last(){
		currentPage = totalPage;
		
	}
	
	//定位到绝对页
	public void absolute(int page){
		if(page >= 0 && page <= totalPage){
			currentPage = page;
		}
	}
	
	//读取当前页所有记录
	public List getPageContents(){
		//当前页中其实记录号
		int pageStartRow;
		//当前页面中的结束记录号
		int pageEndRow;
		
		//区分当前页是否为最后一页
		if(currentPage*recordsInPage < list.size()){
			pageEndRow = currentPage*recordsInPage;
			pageStartRow = pageEndRow - recordsInPage;
			
		}else{
			pageEndRow = list.size();
			pageStartRow = recordsInPage*(totalPage - 1);
		}
		//保存当前页面的返回集合
		List listInPage = new ArrayList();
		
		//保存当前页面的所有记录
		int counter = 0;
		for(int i = pageStartRow;i<pageEndRow;i++){
			Object object = list.get(i);
			listInPage.add(counter,object);
			counter++;
			
		}
		return listInPage;
	}
	
	public int getTotalPage(){
		return totalPage;
	}
	
}