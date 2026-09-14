package com.zagastarx.olreliable.item;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class OlReliableMinerHelmetItem extends ArmorItem {
    public OlReliableMinerHelmetItem(Holder<ArmorMaterial> material, Item.Properties properties) {
        super(material, ArmorItem.Type.HELMET, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        if (level.isClientSide() || !(entity instanceof Player player)) {
            return;
        }

        ItemStack equippedHelmet = player.getItemBySlot(EquipmentSlot.HEAD);
        if (!equippedHelmet.is(this)) {
            return;
        }

        MobEffectInstance currentHaste = player.getEffect(MobEffects.DIG_SPEED);

        // Never overwrite a stronger Haste effect from a beacon, potion, or another mod.
        if (currentHaste == null ||
                (currentHaste.getAmplifier() == 0 && currentHaste.getDuration() <= 20)) {
            player.addEffect(new MobEffectInstance(
                    MobEffects.DIG_SPEED,
                    40,
                    0,
                    false,
                    false,
                    true
            ));
        }
    }
}
