package io.github.amogusazul.dimension_locker.registry;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.github.amogusazul.dimension_locker.platform.Services;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.level.GameRules;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public interface CommonRegistryInterface {

    static <T> Supplier<DataComponentType<T>> registerDataComponent(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator){
        return Services.COMMON_REGISTRY.registerDataComponent(name, builderOperator);
    }

    static void registerCommand(LiteralArgumentBuilder<CommandSourceStack> command){
        Services.COMMON_REGISTRY.registerCommand(command);
    }
    static GameRules.Key<GameRules.BooleanValue> registerBooleanGameRule(String name, GameRules.Category category, boolean defaultValue){
        return Services.COMMON_REGISTRY.registerBooleanGameRule(name, category, defaultValue);
    }

    static boolean reSupplyDataComponent(){
        return Services.COMMON_REGISTRY.reSupplyDataComponent();
    }
}
