package vakiliner.chatguiapi.base;

import java.util.function.Function;
import vakiliner.chatcomponentapi.component.ChatComponent;

public interface ChatScreen {
	ChatComponent getTitle();

	boolean shouldCloseOnEsc();

	default void onInit(Runnable init) {
		this.onInit((supr) -> init);
	}

	void onInit(Function<Runnable, Runnable> function);
}