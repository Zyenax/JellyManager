package net.snickzz.main.utils;

import net.minecraft.server.v1_8_R1.NBTTagCompound;
import net.snickzz.main.Main;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;

public class NPCUtil implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;
	public NPCUtil(Main listener) {
		NPCUtil.plugin = listener;		
	}
	
	public static void createStandingNPC(Entity entity, boolean moving){
		net.minecraft.server.v1_8_R1.Entity nmsEntity = ((CraftEntity)entity).getHandle();
		NBTTagCompound tag = nmsEntity.getNBTTag();
		if(tag == null){
			tag = new NBTTagCompound();
		}
		nmsEntity.c(tag);
		if(moving == false){
			tag.setInt("NoAI", 1);
		}else{
			return;
		}
		nmsEntity.f(tag);
	}

}
