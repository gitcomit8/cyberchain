import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class CyberChain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
        blockchain.add(new Block("First Block", "0"));
        blockchain.add(new Block("Second Block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Third Block", blockchain.get(blockchain.size() - 1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }

    public static boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }
}
