package com.squidymine.tutorialmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {

        // THE ORDER PROBABLY MATTERS!!??
        // (Ctrl + Left Click) on GenerationStep to see the order!!!

        ModOreGeneration.generateOres();

        ModTreeGeneration.generateTrees();
        ModBushGeneration.generateBushes();

    }
}
