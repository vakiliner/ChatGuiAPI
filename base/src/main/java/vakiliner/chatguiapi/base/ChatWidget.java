package vakiliner.chatguiapi.base;

import java.util.function.Function;
import vakiliner.chatcomponentapi.component.ChatComponent;

public interface ChatWidget {
	ChatComponent getMessage();

	int getHeight();

	int getWidth();

	boolean isFocused();

	void setWidth(int i);

	void setAlpha(float f);

	void setMessage(ChatComponent component);

	default void onClick(OnClick onClick) {
		this.onClick((supr) -> onClick);
	}

	void onClick(Function<OnClick, OnClick> function);

	public static interface OverrideMethods {
		default void onClick(double d, double e, Super supr) {
			supr.onClick(d, e);
		}
	}

	public static interface Super extends ChatWidget {
		void onClick(double d, double e);
	}

	public static interface OnClick {
		void onClick(double d, double e);
	}
}