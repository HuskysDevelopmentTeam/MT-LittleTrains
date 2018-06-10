package net.multiteam.mt_t_trains.client.render;

import net.minecraft.client.renderer.entity.RenderManager;
import net.multiteam.mt_t_trains.entity.EntityTrainPart;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: MrCrayfish
 */
public class RenderTrainPart<T extends EntityTrainPart> extends RenderTrain<T> {
    protected List<Wheel> wheels = new ArrayList<>();

    protected RenderTrainPart(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        wheels.forEach(wheel -> wheel.render(entity, partialTicks));
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
