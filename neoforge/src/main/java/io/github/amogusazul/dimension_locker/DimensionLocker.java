package io.github.amogusazul.dimension_locker;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import static io.github.amogusazul.dimension_locker.platform.NeoForgeCommonRegistry.DATA_COMPONENT_TYPES;

@Mod(Constants.MOD_ID)
public class DimensionLocker {

    public DimensionLocker(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.



        CommonClass.init();
        DATA_COMPONENT_TYPES.register(eventBus);

    }
}