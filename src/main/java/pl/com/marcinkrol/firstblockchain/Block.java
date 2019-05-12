package pl.com.marcinkrol.firstblockchain;

import java.util.Date;

public class Block {

    public String hash;
    private Long timeStamp;
    private String data;
    private String prevHash;

    public Block(String data, String prevHash){
        this.data = data;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    private String calculateHash() {
        String calculatedHash = StringUtil.applySha256(
                prevHash +
                Long.toString(timeStamp) +
                data);
        return calculatedHash;
    }
}
