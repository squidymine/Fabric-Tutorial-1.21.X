package com.squidymine.tutorialmod;

import com.squidymine.tutorialmod.block.ModBlocks;
import com.squidymine.tutorialmod.entity.ModEntities;
import com.squidymine.tutorialmod.entity.client.*;
import com.squidymine.tutorialmod.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Allows the holes in the door and trapdoor to be see-through
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HONEY_BERRY_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_SAPLING, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(MantisModel.MANTIS, MantisModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MANTIS, MantisRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(TomahawkProjectileModel.TOMAHAWK, TomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TOMAHAWK, TomahawkProjectileRenderer::new);

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);

    }
}
