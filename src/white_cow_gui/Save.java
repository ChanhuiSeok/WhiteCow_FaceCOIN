package white_cow_gui;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Save implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Transaction getGenesisTransaction() {
		return genesisTransaction;
	}
	public void setGenesisTransaction(Transaction genesisTransaction) {
		this.genesisTransaction = genesisTransaction;
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
	public void setCurrentBlock(Block currentBlock) {
		this.currentBlock = currentBlock;
	}

	String previousHash;
	Block currentBlock;
	Hashtable<String, Wallet> walletHash;
	ArrayList<Wallet> walletArray;
	ArrayList<Block> blockchain;
	HashMap<String,TransactionOutput> UTXO;
	Transaction genesisTransaction;
	
	public HashMap<String, TransactionOutput> getUTXO() {
		return UTXO;
	}
	public void setUTXO(HashMap<String, TransactionOutput> uTXO) {
		UTXO = uTXO;
	}
	
	public Hashtable<String, Wallet> getWalletHash() {
		return walletHash;
	}
	public void setWalletHash(Hashtable<String, Wallet> walletHash) {
		this.walletHash = walletHash;
	}
	public ArrayList<Wallet> getWalletArray() {
		return walletArray;
	}
	public void setWalletArray(ArrayList<Wallet> walletArray) {
		this.walletArray = walletArray;
	}
	public ArrayList<Block> getBlockchain() {
		return blockchain;
	}
	public void setBlockchain(ArrayList<Block> blockchain) {
		this.blockchain = blockchain;
	}
	
}
