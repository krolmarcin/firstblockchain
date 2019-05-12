package pl.com.marcinkrol.firstblockchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class FirstBlockChain {

    public static ArrayList<Block> blockChain = new ArrayList<Block>();
    public static int difficuty = 5;

    public static void main(String[] args) {

        blockChain.add(new Block("First block", "0"));
        System.out.println("Mining Block 1...");
        blockChain.get(0).mineBlock(difficuty);

        blockChain.add(new Block("Second block", blockChain.get(blockChain.size() - 1).hash));
        System.out.println("Mining Block 2...");
        blockChain.get(1).mineBlock(difficuty);

        blockChain.add(new Block("Third block", blockChain.get(blockChain.size() - 1).hash));
        System.out.println("Mining Block 3...");
        blockChain.get(2).mineBlock(difficuty);

        String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockChainJson);

    }
}
