package net.minecraft.nbt;

import java.util.AbstractList;

public abstract class CollectionNBT<T extends INBT> extends AbstractList<T> implements INBT {
   public abstract T set(int p_set_1_, T p_set_2_);

   public abstract void add(int p_add_1_, T p_add_2_);

   public abstract T remove(int p_remove_1_);

   public abstract boolean setTag(int p_218659_1_, INBT p_218659_2_);

   public abstract boolean addTag(int p_218660_1_, INBT p_218660_2_);

   public abstract byte getElementType();
}
