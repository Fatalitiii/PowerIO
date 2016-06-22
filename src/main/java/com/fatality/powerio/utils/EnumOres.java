/**
 * Created by Fatality
 */

/* You are free to:
 *
 * Share — copy and redistribute the material in any medium or format
 * Adapt — remix, transform, and build upon the material
 * for any purpose, even commercially.
 * The licensor cannot revoke these freedoms as long as you follow the license terms.
 * Under the following terms:
 * Attribution — You must give appropriate credit, provide a link to the license, and indicate if changes were made. You may do so in any reasonable manner, but not in any way that suggests the licensor endorses you or your use.
 * ShareAlike — If you remix, transform, or build upon the material, you must distribute your contributions under the same license as the original.
 * No additional restrictions — You may not apply legal terms or technological measures that legally restrict others from doing anything the license permits.
 * Notices:
 *
 * You do not have to comply with the license for elements of the material in the public domain or where your use is permitted by an applicable exception or limitation.
 * No warranties are given. The license may not give you all of the permissions necessary for your intended use. For example, other rights such as publicity, privacy, or moral rights may limit how you use the material.
 */

package com.fatality.powerio.utils;

import net.minecraft.util.IStringSerializable;

import java.util.Arrays;

public enum EnumOres implements IStringSerializable {
	//Vanilla Ores Updated
	GOLD("Gold", 0, EnumOreTypes.DUST),
	IRON("Iron", 1, EnumOreTypes.NUGGET, EnumOreTypes.DUST),
	COAL("Coal", 2, EnumOreTypes.DUST),
	LAPIS("Lapis", 3, EnumOreTypes.DUST),
	DIAMOND("Diamond", 4, EnumOreTypes.NUGGET, EnumOreTypes.DUST),
	EMERALD("Emerald", 5, EnumOreTypes.NUGGET, EnumOreTypes.DUST),
	
	//POWERIO Ores
	ALUMINUM("Aluminum", 6, EnumOreTypes.ORE, EnumOreTypes.INGOT, EnumOreTypes.NUGGET, EnumOreTypes.DUST, EnumOreTypes.FLUID),
	CHROMITE("Chromite", 7, EnumOreTypes.ORE, EnumOreTypes.INGOT, EnumOreTypes.NUGGET, EnumOreTypes.DUST, EnumOreTypes.FLUID),
	COPPER("Copper", 8, EnumOreTypes.ORE, EnumOreTypes.INGOT, EnumOreTypes.NUGGET, EnumOreTypes.DUST, EnumOreTypes.FLUID),
	GALLIUM("Gallium", 9, EnumOreTypes.ORE, EnumOreTypes.INGOT, EnumOreTypes.NUGGET, EnumOreTypes.DUST, EnumOreTypes.FLUID),
	NICKEL("Nickel", 10, EnumOreTypes.ORE, EnumOreTypes.INGOT, EnumOreTypes.NUGGET, EnumOreTypes.DUST, EnumOreTypes.FLUID),
	POTASH("Potash", 11, EnumOreTypes.ORE, EnumOreTypes.INGOT, EnumOreTypes.NUGGET, EnumOreTypes.DUST, EnumOreTypes.FLUID),
	TITANIUM("Titanium", 12, EnumOreTypes.ORE, EnumOreTypes.INGOT, EnumOreTypes.NUGGET, EnumOreTypes.DUST, EnumOreTypes.FLUID),
	URANIUM("Uranium", 13, EnumOreTypes.ORE, EnumOreTypes.INGOT, EnumOreTypes.NUGGET, EnumOreTypes.DUST, EnumOreTypes.FLUID),
	ZINC("Zinc", 14, EnumOreTypes.ORE, EnumOreTypes.INGOT, EnumOreTypes.NUGGET, EnumOreTypes.DUST, EnumOreTypes.FLUID)
	;
	
	private static final EnumOres[] META = new EnumOres[values().length];
	
	static {
		for (EnumOres ore : values()) {
			if (META[ore.getMeta()] != null) {
				System.out.println(ore.getName() + " meta cannot be the same as another ore type.");
			} else {
				META[ore.getMeta()] = ore;
			}
		}
	}
	
	private final String name;
	private final int meta;
	private final EnumOreTypes[] types;
	
	EnumOres(String name, int meta, EnumOreTypes... oreTypes) {
		this.name = name;
		this.meta = meta;
		this.types = oreTypes;
	}
	
	public static EnumOres byMeta(int meta) {
		if (meta < 0 || meta >= META.length) {
			meta = 0;
		}
		
		return META[meta];
	}
	
	public int getMeta() {
		return this.meta;
	}
	
	public String getUnlocalizedName() {
		return this.name.toLowerCase().replaceAll(" ", "_").toLowerCase();
	}
	
	public String getName() {
		return this.name.toLowerCase();
	}
	
	public boolean isTypeSet(EnumOreTypes enumOreType) {
		return Arrays.asList(types).contains(enumOreType);
	}
}