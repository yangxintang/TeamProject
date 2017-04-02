package org.springframework.security.core.userdetails.util;

/**
 * Description	��ҳ��,ֻ�贫�뵱ǰҳ��������������Ϳ��Ե������е���һҳ��һҳ�ȡ�
 * @author 		������
 * @version		2008/10/01
 */
public class Page {
	/**��ǰҳ*/
	private int currentPage;
	/**��ҳ*/
	private int firstPage;
	/**��һҳ*/
	private int priviousPage;
	/**��һҳ*/
	private int nextPage;
	/**βҳ*/
	private int lastPage;
	/**��ҳ��*/
	private int totalPage;
	/**ÿҳ����*/
	private int pageRows=2;
	/**������*/
	private int totalRows;
	
	public int getFirstPage() {
		this.firstPage = 1;
		return firstPage;
	}
	
	public int getLastPage() {
		this.lastPage = this.getTotalPage();
		return lastPage;
	}
	
	public int getNextPage() {
		if(this.currentPage>=this.getTotalPage()){
			this.nextPage=this.getTotalPage();
		}else{
			this.nextPage = this.currentPage+1;
		}
		return nextPage;
	}
	
	public int getPageRows() {
		if(pageRows*this.currentPage>this.getTotalRows()){
			return this.getTotalRows();
		}
		return pageRows*this.currentPage;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getPriviousPage() {
		if(this.currentPage<=1){
			this.priviousPage = 1;
		}else{
			this.priviousPage = this.currentPage-1;
		}
		return priviousPage;
	}
	public void setPriviousPage(int priviousPage) {
		this.priviousPage = priviousPage;
	}
	
	public int getTotalPage() {
		this.totalPage = (int) Math.ceil(this.totalRows/(double)this.pageRows);
		return this.totalPage;
	}
	
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getCurrentPage() {
		
		if(this.totalRows==0){
			this.currentPage=0;
		}
		
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/**����Ҫ��ѯ����*/
	public int getRows(){
		return (this.currentPage-1)*this.pageRows;
	}
}

