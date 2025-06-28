package com.squidymine.tutorialmod.entity.client;

import com.squidymine.tutorialmod.entity.custom.ChairEntity;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class ChairRenderer extends EntityRenderer<ChairEntity> {
    public ChairRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(ChairEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(ChairEntity entity, Frustum frustum, double x, double y, double z) { // ?? Maybe b/c it has no texture this needs to be here?
        return true;
    }
}
