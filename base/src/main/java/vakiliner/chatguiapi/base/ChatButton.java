package vakiliner.chatguiapi.base;

import java.util.function.Function;

public interface ChatButton extends ChatWidget {
	default void onPress(Runnable onPress) {
		this.onPress((supr) -> onPress);
	}

	void onPress(Function<Runnable, Runnable> function);
}