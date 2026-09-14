package com.zagastarx.olreliable.item;

import com.zagastarx.olreliable.OlReliableMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public final class ModItems {
    private ModItems() {}

    public static final Item OL_RELIABLE_MINER_HELMET = register(
            new OlReliableMinerHelmetItem(
                    OlReliableArmorMaterials.OL_RELIABLE,
                    new Item.Properties().durability(
                            ArmorItem.Type.HELMET.getDurability(OlReliableArmorMaterials.DURABILITY_MULTIPLIER)
                    )
            ),
            "ol_reliable_miner_helmet"
    );

    private static Item register(Item item, String id) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                ResourceLocation.fromNamespaceAndPath(OlReliableMod.MOD_ID, id),
                item
        );
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register(entries -> entries.accept(OL_RELIABLE_MINER_HELMET));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(entries -> entries.accept(OL_RELIABLE_MINER_HELMET));
    }
}
