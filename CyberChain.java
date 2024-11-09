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
}
