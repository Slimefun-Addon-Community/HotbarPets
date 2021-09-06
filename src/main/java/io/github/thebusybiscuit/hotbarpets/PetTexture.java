package io.github.thebusybiscuit.hotbarpets;

import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * This class holds the head hashes for all head textures.
 *
 * @author WalshyDev
 */
public enum PetTexture {

    // Category
    CATEGORY("621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4"),

    // Boss
    WITHER_PET("cdf74e323ed41436965f5c57ddf2815d5332fe999e68fbb9d6cf5c8bd4139f"),

    // Farm Animals
    COW_PET("5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5"),
    PIG_PET("621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4"),
    CHICKEN_PET("1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893"),
    MOOSHROOM_PET("d0bc61b9757a7b83e03cd2507a2157913c2cf016e7c096a4d6cf1fe1b8db"),
    GOLDEN_COW_PET("8d103358d8f1bdaef1214bfa77c4da641433186bd4bc44d857c16811476fe"),

    // Hostile
    SPIDER_PET("f7a4c256f0df614231f8d55344c9de39389361a740c11facc0d299f676dd9a"),
    GHAST_PET("8b6a72138d69fbbd2fea3fa251cabd87152e4f1c97e5f986bf685571db3cc0"),
    SHULKER_PET("b1d3534d21fe8499262de87affbeac4d25ffde35c8bdca069e61e1787ff2f"),
    PHANTOM_PET("40b9189c3713f0dacac9b2bb6065090c52b0c90f108208e0a86be5885e99579a"),
    ENDERMAN_PET("7a59bb0a7a32965b3d90d8eafa899d1835f424509eadd4e6b709ada50b9cf"),
    MAGMA_CUBE_PET("38957d5023c937c4c41aa2412d43410bda23cf79a9f6ab36b76fef2d7c429"),
    BLAZE_PET("62505be7796b7d78a717c3e65ea42bf211449fdb6d93f2b406a88ab71b70"),

    // Passive
    IRON_GOLEM_PET("89091d79ea0f59ef7ef94d7bba6e5f17f2f7d4572c44f90f76c4819a714"),
    SLIME_PET("16ad20fc2d579be250d3db659c832da2b478a73a698b7ea10d18c9162e4d9b5"),

    // Peaceful Animals
    FISH_PET("6f99b580d45a784e7a964e7d3b1f97cece74911173bd21c1d7c56acdc385ed5"),
    SQUID_PET("01433be242366af126da434b8735df1eb5b3cb2cede39145974e9c483607bac"),
    RABBIT_PET("ff1559194a175935b8b4fea6614bec60bf81cf524af6f564333c555e657bc"),
    DOLPHIN_PET("cefe7d803a45aa2af1993df2544a28df849a762663719bfefc58bf389ab7f5"),
    PANDA_PET("414ff627a6a6f35e1d717ebcb191e4c7f9097542db599e7108ae2c7dd3513e51"),

    // Special
    PURPLICIOUS_COW_PET("3e1fc63d303eb5f366aecae6d250d4e2d779a9f5ef8deaff5b3bc95307ff9"),
    MR_COOKIE_SLIME_PET("16709d87e85d153bb883a23a5a883ee44ddb284d5318b780a16e82a9dac651"),
    PATRIOT_PET("78a5646c8473e1bf45513be4e6e8656050671b65133c0048d484e1bf0b46295f"),
    WALSHRUS_PET("c966f0ebd77f1bcd656fa2dc3ef0303e26a6a3de498c3999d39fdcacc5f5ad"),
    EYAMAZ_PET("18474f7a6c139f1ccd735a4677c0453c4befedfc89feda49ea886eb18ddf6cdf"),

    // Utility
    ENDER_CHEST_PET("a6cc486c2be1cb9dfcb2e53dd9a3e9a883bfadb27cb956f1896d602b4067"),
    WORKBENCH_PET("4ad881d68547161aa7b2925e383778756bc67a75b444a586e515953ef83a9");

    private final String hash;

    PetTexture(@Nonnull String hash) {
        this.hash = hash;
    }

    @Nonnull
    public String getHash() {
        return hash;
    }

    @Nonnull
    @Override
    public String toString() {
        return this.hash;
    }

    @Nonnull
    public ItemStack getAsItem() {
        return PlayerHead.getItemStack(PlayerSkin.fromHashCode(getHash()));
    }
}
