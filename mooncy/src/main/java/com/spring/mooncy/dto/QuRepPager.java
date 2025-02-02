package com.spring.mooncy.dto;

public class QuRepPager {
	// ??΄μ§??Ή κ²μλ¬? ?
	public static final int PAGE_SCALE = 5;
	// ?λ©΄λΉ ??΄μ§? ?
	public static final int BLOCK_SCALE = 5;
	private int curPage; // ??¬ ??΄?
	private int prevPage; // ?΄?  ??΄μ§?
	private int nextPage; // ?€? ??΄μ§?
	private int totPage; // ? μ²? ??΄μ§? κ°??
	private int totBlock; // ? μ²? ??΄μ§? λΈλ‘ κ°??
	private int curBlock; // ??¬ ??΄μ§? λΈλ‘ 
	private int prevBlock; // ?΄?  ??΄μ§? λΈλ‘
	private int nextBlock; // ?€? ??΄μ§? λΈλ‘
	// WHERE rn BETWEEN #{start} AND #{end}
	private int pageBegin; // #{start}
	private int pageEnd; // #{end}
	// [?΄? ] blockBegin -> 41 42 43 44 45 46 47 48 49 50 [?€?]
	private int blockBegin; // ??¬ ??΄μ§? λΈλ‘? ??λ²νΈ
	// [?΄? ] 41 42 43 44 45 46 47 48 49 50 <- blockEnd [?€?]
	private int blockEnd; // ??¬ ??΄μ§? λΈλ‘? ?λ²νΈ
	
	// ??±?
	// BoardPager(? μ½λ κ°??, ??¬ ??΄μ§? λ²νΈ)
	public QuRepPager(int count, int curPage){
		curBlock = 1; // ??¬ ??΄μ§? λΈλ‘ λ²νΈ
		this.curPage = curPage; // ??¬ ??΄μ§? ?€? 
		setTotPage(count); // ? μ²? ??΄μ§? κ°?? κ³μ°
		setPageRange(); // 
		setTotBlock(); // ? μ²? ??΄μ§? λΈλ‘ κ°?? κ³μ°
		setBlockRange(); // ??΄μ§? λΈλ‘? ??, ? λ²νΈ κ³μ°
	}
	
	public void setBlockRange(){
		// *??¬ ??΄μ§?κ°? λͺλ²μ§? ??΄μ§? λΈλ‘? ???μ§? κ³μ°
		// (??¬??΄μ§?-1)/??΄μ§? λΈλ‘?¨?+1
		// 1??΄μ§? => 1λΈλ‘ (1-1)/10 + 1 => 1
		// 9??΄μ§? => 	1λΈλ‘ (9-1)/10 + 1 => 1
		// 11??΄μ§? => 2λΈλ‘ (11-1)/10 + 1 => 2
		// 57??΄μ§? => 6λΈλ‘ (57-1)/10 + 1 => 6 
		curBlock = (int)Math.ceil((curPage-1) / BLOCK_SCALE)+1;
		// *??¬ ??΄μ§? λΈλ‘? ??, ? λ²νΈ κ³μ°
		// ??΄μ§? λΈλ‘? ??λ²νΈ
		// (??¬λΈλ‘-1)*λΈλ‘?¨?+1
		// 1λΈλ‘ => (1-1)*10 + 1 => 1
		// 2λΈλ‘ => (2-1)*10 + 1 => 11
		// 6λΈλ‘ => (6-1)*10 + 1 => 51
		blockBegin = (curBlock-1)*BLOCK_SCALE+1;
		// ??΄μ§? λΈλ‘? ?λ²νΈ
		// λΈλ‘??λ²νΈ+λΈλ‘?¨?-1;
		// 1λΈλ‘ => 1+10-1 => 10
		// 2λΈλ‘ => 11+10-1 => 20
		// 6λΈλ‘ => 51+10-1 => 60 	
		blockEnd = blockBegin+BLOCK_SCALE-1;
		// *λ§μ?λ§? λΈλ‘?΄ λ²μλ₯? μ΄κ³Ό?μ§? ??λ‘? κ³μ°
		// [?΄? ] 61 62 => ?΄?¬? κ²½μ° 70λ²κΉμ§? ??€μ§? ??λ‘νκΈ? ??΄?
		if(blockEnd > totPage) blockEnd = totPage;
		// *?΄? ? ???? ? ?΄??  ??΄μ§? λ²νΈ
		prevPage = (curPage == 1)? 1:(curBlock-1)*BLOCK_SCALE;
		// *?€?? ???? ? ?΄??  ??΄μ§? λ²νΈ
		nextPage = curBlock > totBlock ? (curBlock*BLOCK_SCALE) : (curBlock*BLOCK_SCALE)+1;
		// λ§μ?λ§? ??΄μ§?κ°? λ²μλ₯? μ΄κ³Ό?μ§? ??λ‘? μ²λ¦¬
		if(nextPage >= totPage) nextPage = totPage;
	}
	
	public void setPageRange(){
	// WHERE rn BETWEEN #{start} AND #{end}
		// ??λ²νΈ = (??¬??΄μ§?-1)*??΄μ§??Ή κ²μλ¬Όμ +1
		pageBegin = (curPage-1)*PAGE_SCALE+1;
		// ?λ²νΈ = ??λ²νΈ+??΄μ§??Ή κ²μλ¬Όμ -1
		pageEnd = pageBegin+PAGE_SCALE-1;
	}
	
	// Getter/Setter
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int count) {
		// 91κ°μ κ²μλ¬Όμ 10κ°μ© 9??΄μ§?λ₯? μ²λ¦¬?κ³? ?¨?? 1κ°μ κ²μλ¬Όλ ??΄μ§?? μΆλ ₯?κΈ? ??΄??
		// ?­? ?¬λ¦ΌμΌλ‘? μ²λ¦¬?΄?Ό??€.
		// Math.ceil(?€?) ?¬λ¦? μ²λ¦¬
		// λͺ¨λ  ??΄μ§?? ?¬λ¦Όμ²λ¦?
		totPage = (int) Math.ceil(count*1.0 / PAGE_SCALE);
	}
	public int getTotBlock() {
		return totBlock;
	}
	
	// ??΄μ§? λΈλ‘? κ°?? κ³μ°(μ΄? 100??΄μ§??Όλ©? 10κ°μ λΈλ‘)
	public void setTotBlock() {
		// ? μ²? ??΄μ§? κ°?? / 10
		// 91 / 10 => 9.1 => 10κ°?
		totBlock = (int)Math.ceil(totPage / BLOCK_SCALE);
	}
	
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public int getBlockBegin() {
		return blockBegin;
	}
	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}
	public int getBlockEnd() {
		return blockEnd;
	}
	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	
	
}
