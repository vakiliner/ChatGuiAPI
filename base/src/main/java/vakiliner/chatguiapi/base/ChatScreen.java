package vakiliner.chatguiapi.base;

import vakiliner.chatcomponentapi.component.ChatComponent;

public interface ChatScreen {
	ChatComponent getTitle();

	boolean shouldCloseOnEsc();
}