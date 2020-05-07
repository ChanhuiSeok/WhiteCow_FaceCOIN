package white_cow_gui;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;

public class Block implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String hash;
	public String previousHash;
	public String merkleRoot;
	public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	public long timeStamp;
	public int nonce;
	
	public Block(String previousHash ) {
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256(
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nonce) +
				merkleRoot
				);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		merkleRoot = StringUtil.getMerkleRoot(transactions);
		String target = StringUtil.getDificultyString(difficulty); 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
			//SendThread.getInstance().BroadCast(String.format("nonce : %d\n" + 
					//"hash = %s \n\n ", nonce,hash));
		}
		
		BlockThread.getInstance().setPreviousHash(hash);
		//System.out.println("Block Mined!!! : " + hash + "\n" + new Date().getTime());
	}
	
	// 블록에 트랜잭션을 추가
	public boolean addTransaction(Transaction transaction) {
		// 트랜잭션의 유효성을 확인한다.
		if(transaction == null) return false;		
		if((previousHash != "0")) {
			if((transaction.processTransaction() != true)) {
				System.out.println("Transaction failed to process. Discarded.");
				return false;
			}
		}
		transactions.add(transaction);
		System.out.println("Transaction Successfully added to Block");
		return true;
	}
	
}