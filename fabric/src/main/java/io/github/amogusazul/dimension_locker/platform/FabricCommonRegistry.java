package io.github.amogusazul.dimension_locker.platform;

import io.github.amogusazul.dimension_locker.platform.services.CommonRegistry;
import io.github.amogusazul.dimension_locker.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;


import java.util.function.Function;
import java.util.function.Supplier;

public class FabricCommonRegistry implements CommonRegistry {

    public FabricCommonRegistry() {
        // Default constructor
    }

    private static <T, R extends Registry<? super T>> Supplier<T> registerSupplier(R registry, String id, Supplier<T> object) {
        final T registeredObject = Registry.register((Registry<T>) registry,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id), object.get());

        return () -> registeredObject;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String itemName, Function<Item.Properties, T> function, Item.Properties properties) {
        ResourceKey<Item> itemId = createItemId(itemName);
        return (Supplier<T>) registerSupplier(BuiltInRegistries.ITEM, itemName, () -> function.apply(properties.setId(itemId)));
    }

    private static ResourceKey<Item> createItemId(String id) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id));
    }
}