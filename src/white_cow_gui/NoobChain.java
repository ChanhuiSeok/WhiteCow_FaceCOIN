package white_cow_gui;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class NoobChain {
	
	public static ArrayList<PrintWriter> m_OutputList;
	public static String UserID;
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static HashMap<String,TransactionOutput> UTXOs = new HashMap<String,TransactionOutput>();
	
	public static int difficulty = 4;
	public static float minimumTransaction = 0.1f;
	public static Wallet walletA;
	public static Wallet walletB;
	public static Transaction genesisTransaction;
	
	public static Hashtable<String, Wallet> walletHash = new Hashtable<String, Wallet>();
	public static ArrayList<Wallet> walletArray = new ArrayList<Wallet>();
	
	
	public static void InitWallet(){
	//public static void Trade () {	
		//Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		
	
		
		/*SendThread send_thread = null;
		
		try {
			Socket c_socket = new Socket("192.168.93.1", 8888);
			
			ReceiveThread.getInstance().setSocket(c_socket);
			
			SendThread.getInstance().setSocket(c_socket);
			
			ReceiveThread.getInstance().start();
			SendThread.getInstance().start();
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		*/
		
		//BlockThread.getInstance().start();
		//LoadData();
		//id로 지갑 찾기
		//Wallet sWallet = walletHash.get("heewon");
		//Wallet rWallet = walletHash.get("mart");
		//BlockThread.getInstance().getCurrentBlock().addTransaction(sWallet.sendFunds(rWallet.publicKey, money));
		//SaveData();
		

		/*walletA = new Wallet();
		walletB = new Wallet();
		
		walletHash.put("A", walletA);
		walletHash.put("B", walletB);
		
		walletArray.add(walletA);
		walletArray.add(walletB);*/

		
		//LoadData();
		
		//UserInput();
		//BlockThread.getInstance().start();
		Init();
		showList();
		SaveData();
		/*
		Wallet coinbase = new Wallet();
		
		
		genesisTransaction = new Transaction(coinbase.publicKey, walletA.publicKey, 5000000f, null);
		genesisTransaction.generateSignature(coinbase.privateKey);	
		genesisTransaction.transactionId = "0"; 
		genesisTransaction.outputs.add(new TransactionOutput(genesisTransaction.reciepient, genesisTransaction.value, genesisTransaction.transactionId)); 
		UTXOs.put(genesisTransaction.outputs.get(0).id, genesisTransaction.outputs.get(0)); 
		
		System.out.println("Creating and Mining Genesis block... ");
		Block genesis = new Block("0");
		genesis.addTransaction(genesisTransaction);
		
		addBlock(genesis);
		*/
		
		
		//testing
		
		/*
		Block block1 = new Block(genesis.hash);
		System.out.println("\nWalletA's balance is: " + walletA.getBalance());
		System.out.println("\nWalletA is Attempting to send funds (40) to WalletB...");
		block1.addTransaction(walletA.sendFunds(walletB.publicKey, 40f));
		addBlock(block1);
		System.out.println("\nWalletA's balance is: " + walletA.getBalance());
		System.out.println("WalletB's balance is: " + walletB.getBalance());
		
		Block block2 = new Block(block1.hash);
		System.out.println("\nWalletA Attempting to send more funds (1000) than it has...");
		block2.addTransaction(walletA.sendFunds(walletB.publicKey, 1000f));
		addBlock(block2);
		System.out.println("\nWalletA's balance is: " + walletA.getBalance());
		System.out.println("WalletB's balance is: " + walletB.getBalance());
		
		Block block3 = new Block(block2.hash);
		System.out.println("\nWalletB is Attempting to send funds (20) to WalletA...");
		block3.addTransaction(walletB.sendFunds( walletA.publicKey, 20));
		System.out.println("\nWalletA's balance is: " + walletA.getBalance());
		System.out.println("WalletB's balance is: " + walletB.getBalance());
		
		addBlock(block3);
		
		Block block4 = new Block(block2.hash);
		System.out.println("\nWalletB is Attempting to send funds (20) to WalletA...");
		block3.addTransaction(walletB.sendFunds( walletA.publicKey, 20));
		System.out.println("\nWalletA's balance is: " + walletA.getBalance());
		System.out.println("WalletB's balance is: " + walletB.getBalance());
		
		addBlock(block3);
		
		
		isChainValid();
		*/

		
		
	}
	
	public static void showList()
	{
		for(int i=0; i<walletArray.size(); i++)
		System.out.println(walletArray.get(i) + "'s balance is: " + walletArray.get(i).getBalance());
	}
	
	public static Wallet makeWallet(String name)
	{
		
		Wallet newWallet = new Wallet();
		walletHash.put(name, newWallet);
		walletArray.add(newWallet);

		System.out.println("지갑 생성 완료 : wallet" + name);
		
		return newWallet;
	}
	
	public static void deleteWallet(String name)
	{
		Wallet target=null;
		target=walletHash.get(name);
		walletHash.remove(name);
		walletArray.remove(target);
	}
	
	public static Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		HashMap<String,TransactionOutput> tempUTXOs = new HashMap<String,TransactionOutput>(); 
		tempUTXOs.put(genesisTransaction.outputs.get(0).id, genesisTransaction.outputs.get(0));
		
		for(int i=1; i < blockchain.size(); i++) {
			
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("#Current Hashes not equal");
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("#Previous Hashes not equal");
				return false;
			}
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("#This block hasn't been mined");
				return false;
			}
			
			//loop thru blockchains transactions:
			TransactionOutput tempOutput;
			for(int t=0; t <currentBlock.transactions.size(); t++) {
				Transaction currentTransaction = currentBlock.transactions.get(t);
				
				if(!currentTransaction.verifiySignature()) {
					System.out.println("#Signature on Transaction(" + t + ") is Invalid");
					return false;
				}
				// 현재 수수료 개념이 없기때문에 input과 output의 총량은 서로 같아야한다.
				if(currentTransaction.getInputsValue() != currentTransaction.getOutputsValue()) {
					System.out.println("#Inputs are note equal to outputs on Transaction(" + t + ")");
					return false;
				}
				
				// 블록의 트랜잭션들의 input값이 올바른지 확인
				for(TransactionInput input: currentTransaction.inputs) {	
					tempOutput = tempUTXOs.get(input.transactionOutputId);
					// input을 올바르게 참조하는가?
					if(tempOutput == null) {
						System.out.println("#Referenced input on Transaction(" + t + ") is Missing");
						return false;
					}
					// 참조 한 값과 value가 동일한가?
					if(input.UTXO.value != tempOutput.value) {
						System.out.println("#Referenced input Transaction(" + t + ") value is Invalid");
						return false;
					}
					
					tempUTXOs.remove(input.transactionOutputId);
				}

				// 블록의 트랜잭션들의 input값이 올바른지 확인
				for(TransactionOutput output: currentTransaction.outputs) {
					tempUTXOs.put(output.id, output);
				}
				// 수취인이 정확한가?
				if( currentTransaction.outputs.get(0).reciepient != currentTransaction.reciepient) {
					System.out.println("#Transaction(" + t + ") output reciepient is not who it should be");
					return false;
				}
				// 거스듬론의 수취인이 정확한가?
				if( currentTransaction.outputs.get(1).reciepient != currentTransaction.sender) {
					System.out.println("#Transaction(" + t + ") output 'change' is not sender.");
					return false;
				}
				
			}
			
		}
		System.out.println("Blockchain is valid");
		return true;
	}

	public static void addBlock(Block newBlock) {
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);

		System.out.println("Block Mined!!! : " + newBlock.hash);
		//SendThread.getInstance().BroadCast("Block Mined!!! : " + newBlock.hash + "\n" + new Date().getTime());
	}
		//채굴자들에게 채굴을 명령함
	
	 public static void SaveSerial(Save save,String filePath) throws IOException {
		 
	        FileOutputStream fos = new FileOutputStream(filePath);
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(save);
	        oos.close();
	    }
	 
	 public static Save LoadSerial(String filePath) throws IOException, ClassNotFoundException {
		 
	        FileInputStream fis = new FileInputStream(filePath);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        Save save = (Save) ois.readObject();
	        ois.close();
	         
	        return save;
	    }


	 public static void SaveData()
	 {
		 Save newSave = new Save();
			newSave.setBlockchain(blockchain);
			newSave.setWalletArray(walletArray);
			newSave.setWalletHash(walletHash);
			newSave.setUTXO(UTXOs);
			newSave.setGenesisTransaction(genesisTransaction);
			newSave.setCurrentBlock(BlockThread.getInstance().getCurrentBlock());
			newSave.setPreviousHash(BlockThread.getInstance().getPreviousHash());
			
			try {
				File file = new File("database.ser");
				if( file.exists() ){
		            if(file.delete()){
		                System.out.println("기존 파일삭제 성공");
		            }else{
		                System.out.println("기존 파일삭제 실패");
		            }
		        }else{
		            System.out.println("파일이 존재하지 않습니다.");
		        }
				
				File file2 = new File("database.ser");
				SaveSerial(newSave,"database.ser");
				System.out.println("저장 성공");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 
	 public static Save LoadData()
	 {
		 Save savedData=null;
			
			try {
				savedData=LoadSerial("database.ser");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			blockchain=savedData.getBlockchain();
			walletArray=savedData.getWalletArray();
			walletHash=savedData.getWalletHash();
			UTXOs=savedData.getUTXO();
			genesisTransaction=savedData.getGenesisTransaction();
			BlockThread.getInstance().setPreviousHash(savedData.getPreviousHash());
			BlockThread.getInstance().setCurrentBlock(savedData.getCurrentBlock());
					
			System.out.println("불러오기 성공");
			
		 return savedData;
	 }
	 
	 public static void Init()
	 {
		 
		 System.out.println("Init");
		 Wallet coinbase = new Wallet();

		 makeWallet("Parkmyunghun");
		 makeWallet("Jangsungwon");
		 makeWallet("Kimheewon");
		 makeWallet("Parkhyosang");
		 makeWallet("Seokchanhee");
		 makeWallet("Yoonyoungshin");
		 makeWallet("Mart");
		 
			//Wallet sWallet = walletHash.get("heewon");
			Wallet markWallet = walletHash.get("Mart");
			
			genesisTransaction = new Transaction(coinbase.publicKey, markWallet.publicKey, 10000000f, null);
			genesisTransaction.generateSignature(coinbase.privateKey);	
			genesisTransaction.transactionId = "0"; 
			genesisTransaction.outputs.add(new TransactionOutput(genesisTransaction.reciepient, genesisTransaction.value, genesisTransaction.transactionId)); 
			UTXOs.put(genesisTransaction.outputs.get(0).id, genesisTransaction.outputs.get(0)); 
			
			System.out.println("Creating and Mining Genesis block... ");
			Block genesis = new Block("0");
			genesis.addTransaction(genesisTransaction);
			
			//Wallet sWallet = walletHash.get("heewon");
			//Wallet rWallet = walletHash.get("mart");
			//BlockThread.getInstance().getCurrentBlock().addTransaction(sWallet.sendFunds(rWallet.publicKey, money));
			
			addBlock(genesis);
			

			Auto("Mart","Kimheewon",1000000);
			Auto("Mart","Parkhyosang",1000000);
			Auto("Mart","Parkmyunghun",1000000);
			Auto("Mart","Seokchanhee",1000000);
			Auto("Mart","Jangsungwon",1000000);
			Auto("Mart","Yoonyoungshin",1000000);
		 
	 }
	 
	 public static void UserInput()
	 {

			Scanner scan = new Scanner(System.in); 
			float money;
			String sender;
			String receiver;
			
			Wallet sWallet;
			Wallet rWallet;
			
			while(true)
			{

				System.out.println("송신자 입력 : ");
				sender=scan.nextLine();
				
				if(sender.contains("ac"))
				{
					makeWallet("");
					continue;
				}else if(sender.contains("save"))
				{
					SaveData();
					continue;
				}else if(sender.contains("load"))
				{
					LoadData();
					continue;
				}
				else if(sender.contains("list"))
				{
					showList();
					continue;
				}
				else
				{
					if(walletHash.get(sender) == null)
					{
						System.out.println("올바른 송신자 입력");
						continue;
					}
				}
				
				//LoadData();
				//id로 지갑 찾기
				//BlockThread.getInstance().getCurrentBlock().addTransaction(sWallet.sendFunds(rWallet.publicKey, money));
				
				
				System.out.println("수신자 입력 : ");
				receiver=scan.nextLine();
				
				while(walletHash.get(receiver) == null)
				{
					System.out.println("올바른 수신자 입력 :");
					receiver=scan.nextLine();
				}
				
					System.out.println(sender + "가 " +receiver+ "에게 줄 금액 입력 : ");
					money=scan.nextFloat();
				
				scan.nextLine(); // rm buffer
				
				sWallet=walletHash.get(sender);
				rWallet=walletHash.get(receiver);
				BlockThread.getInstance().getCurrentBlock().addTransaction(sWallet.sendFunds(rWallet.publicKey, money));
				
				System.out.println(sender + "'s balance is: " + sWallet.getBalance());
				System.out.println(receiver + "'s balance is: " + rWallet.getBalance());
				isChainValid();
			}
	 }
	 
	 public static void Auto(String sender, String receiver,int amount)
	 {
		 
		 	Wallet sWallet=walletHash.get(sender);
		 	Wallet rWallet=walletHash.get(receiver);
		 	
		 	float money = (float)amount;
			BlockThread.getInstance().getCurrentBlock().addTransaction(sWallet.sendFunds(rWallet.publicKey, money));
			
			System.out.println("#############################결제성공######");
			System.out.println(sender + "'s balance is: " + sWallet.getBalance());
			System.out.println(receiver + "'s balance is: " + rWallet.getBalance());
			isChainValid();
			
			SaveData();
			
			showList();
	 }
}
