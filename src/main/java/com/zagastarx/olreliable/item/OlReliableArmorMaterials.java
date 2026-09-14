package com.zagastarx.olreliable.item;

import com.zagastarx.olreliable.OlReliableMod;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public final class OlReliableArmorMaterials {
    private OlReliableArmorMaterials() {}

    // Diamond helmet durability: 11 * 33 = 363.
    public static final int DURABILITY_MULTIPLIER = 33;

    public static final Holder<ArmorMaterial> OL_RELIABLE = registerMaterial(
            "ol_reliable",
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3
            ),
            10,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(Items.IRON_INGOT),
            2.0F,
            0.0F
    );

    private static Holder<ArmorMaterial> registerMaterial(
            String id,
            Map<ArmorItem.Type, Integer> defensePoints,
            int enchantability,
            Holder<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngredientSupplier,
            float toughness,
            float knockbackResistance
    ) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(
                        ResourceLocation.fromNamespaceAndPath(OlReliableMod.MOD_ID, id),
                        "",
                        false
                )
        );

        ArmorMaterial material = new ArmorMaterial(
                defensePoints,
                enchantability,
                equipSound,
                repairIngredientSupplier,
                layers,
                toughness,
                knockbackResistance
        );

        material = Registry.register(
                BuiltInRegistries.ARMOR_MATERIAL,
                ResourceLocation.fromNamespaceAndPath(OlReliableMod.MOD_ID, id),
                material
        );

        return Holder.direct(material);
    }

    public static void initialize() {}
}
