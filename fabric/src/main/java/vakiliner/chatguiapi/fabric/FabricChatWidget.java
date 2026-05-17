package vakiliner.chatguiapi.fabric;

import net.minecraft.client.gui.components.AbstractWidget;
import vakiliner.chatguiapi.base.ChatWidget;

public interface FabricChatWidget extends ChatWidget {
	AbstractWidget toFabric();
}