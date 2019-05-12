package pl.com.marcinkrol.firstblockchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class FirstBlockChain {

    public static ArrayList<Block> blockChain = new ArrayList<Block>();
    public static int difficuty = 5;

    public static void main(String[] args) {

        blockChain.add(new Block("First block", "0"));
        blockChain.add(new Block("Second block", blockChain.get(blockChain.size() - 1).hash));
        blockChain.add(new Block("Third block", blockChain.get(blockChain.size() - 1).hash));

        String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockChainJson);

    }
}
