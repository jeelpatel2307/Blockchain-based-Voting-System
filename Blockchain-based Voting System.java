import java.security.MessageDigest;
import java.util.ArrayList;

class Block {
    private String hash;
    private String previousHash;
    private String data;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest((previousHash + data).getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }
}

class Blockchain {
    private ArrayList<Block> blockchain = new ArrayList<>();

    public Blockchain() {
        addBlock("Genesis Block", "0");
    }

    public void addBlock(String data, String previousHash) {
        blockchain.add(new Block(data, previousHash));
    }

    public Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    public boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.addBlock("Vote for Candidate A", blockchain.getLatestBlock().getHash());
        blockchain.addBlock("Vote for Candidate B", blockchain.getLatestBlock().getHash());

        System.out.println("Blockchain is valid: " + blockchain.isChainValid());

        // Tampering with the data
        blockchain.blockchain.get(1).setData("Vote for Candidate C");
        System.out.println("Blockchain is valid: " + blockchain.isChainValid());
    }
}
