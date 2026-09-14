# Ol’ Reliable Miner Helmet

Fabric 1.21.1 mod for ZagaStarX.

## Current design

- Item: **Ol’ Reliable Miner Helmet**
- Protection: diamond-helmet level
- Durability: diamond-helmet level
- Armor toughness: diamond level
- Enchantability: diamond level
- Passive effect: **Haste I** while equipped
- Standard helmet enchantments are supported, including Protection, Unbreaking, Mending, Respiration and Aqua Affinity.
- Crafting recipe:

```text
I G I
I L I
  R
```

Where `I` = Iron Ingot, `G` = Gold Ingot, `L` = Lantern and `R` = Redstone.

## Lighting

The project includes optional dynamic-light metadata for a compatible client-side dynamic-light implementation. The helmet still functions normally if dynamic lighting is unavailable.

## Build

GitHub Actions builds the Fabric 1.21.1 mod automatically with Java 21. The compiled JAR is uploaded as a workflow artifact.
