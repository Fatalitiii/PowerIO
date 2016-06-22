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

public enum EnumCableTiers implements IStringSerializable {
	COPPER("Copper", 0, 64),
	GOLD("Gold", 1, 512),
	REDSTONE("Redstone", 2, 4096),
	FIBER("Fiber", 3, 16384)
	;
	
	private static final EnumCableTiers[] META = new EnumCableTiers[values().length];
	
	static {
		for (EnumCableTiers tiers : values()) {
			if (META[tiers.getMeta()] != null) {
				System.out.println(tiers.getName() + " meta cannot be the same as another ore type.");
			} else {
				META[tiers.getMeta()] = tiers;
			}
		}
	}
	
	private final String name;
	private final int meta;
	private final int transferRate;
	
	EnumCableTiers(String name, int meta, int transferRate) {
		this.name = name;
		this.meta = meta;
		this.transferRate = transferRate;
	}
	
	public static EnumCableTiers byMeta(int meta) {
		if (meta < 0 || meta >= META.length) {
			meta = 0;
		}
		
		return META[meta];
	}
	
	public int getMeta() {
		return this.meta;
	}
	
	public int getTransferRate() {
		return this.transferRate;
	}
	
	public String getUnlocalizedName() {
		return this.name.toLowerCase().replaceAll(" ", "_").toLowerCase();
	}
	
	public String getName() {
		return this.name.toLowerCase();
	}
}
