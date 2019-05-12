package pl.com.marcinkrol.firstblockchain;

import java.util.Date;

public class Block {

    public String hash;
    private Long timeStamp;
    private String data;
    private String prevHash;
    private int nonce;

    public Block(String data, String prevHash) {
        this.data = data;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    private String calculateHash() {
        String calculatedHash = StringUtil.applySha256(
                prevHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data);
        return calculatedHash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined! : " + hash);
    }

}
