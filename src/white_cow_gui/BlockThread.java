package white_cow_gui;

public class BlockThread extends Thread{

	String previousHash=null;
	Block currentBlock;
	
	public static BlockThread temp = null;
	public static BlockThread getInstance()
	{
		if(temp!=null)
			return temp;
		else
		{
				temp = new BlockThread();
			return temp;
		}
	}
	
	@Override
	public void run() {
		super.run();
		
		while(true)
		{
			Block newBlock = new Block(previousHash);
			currentBlock=newBlock;
			
			
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			NoobChain.addBlock(newBlock);
		}
		
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public Block getCurrentBlock() {
		return currentBlock;
	}
	
	public void setCurrentBlock(Block blk) {
		currentBlock = blk;
	}

}
