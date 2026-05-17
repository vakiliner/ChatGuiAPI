package vakiliner.chatguiapi.fabric.impl;

import java.util.function.Function;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.network.chat.Component;
import vakiliner.chatcomponentapi.component.ChatComponent;
import vakiliner.chatcomponentapi.fabric.FabricParser;
import vakiliner.chatguiapi.fabric.ChatGuiAPIFabricParser;
import vakiliner.chatguiapi.fabric.FabricChatSlider;

public class FabricChatSliderImpl implements FabricChatSlider {
	@SuppressWarnings("unused")
	private final ChatGuiAPIFabricParser parser;
	private final SliderImpl impl;

	public FabricChatSliderImpl(ChatGuiAPIFabricParser parser, int i, int j, int k, int l, ChatComponent component, double d) {
		this.parser = parser;
		this.impl = new SliderImpl(i, j, k, l, FabricParser.fabric(component), d);
	}

	public AbstractSliderButton toFabric() {
		if (this.impl.applyValue == null) {
			throw new UnsupportedOperationException("Unimplemented method applyValue");
		}
		if (this.impl.updateMessage == null) {
			throw new UnsupportedOperationException("Unimplemented method updateMessage");
		}
		return this.impl;
	}

	public ChatComponent getMessage() {
		return FabricParser.fabric(this.impl.getMessage());
	}

	public int getHeight() {
		return this.impl.getHeight();
	}

	public int getWidth() {
		return this.impl.getWidth();
	}

	public boolean isFocused() {
		return this.impl.isFocused();
	}

	public void setMessage(ChatComponent component) {
		this.impl.setMessage(FabricParser.fabric(component));
	}

	public void setWidth(int i) {
		this.impl.setWidth(i);
	}

	public void setAlpha(float f) {
		this.impl.setAlpha(f);
	}

	public void onApplyValue(Runnable applyValue) {
		this.impl.applyValue = applyValue;
	}

	public void onUpdateMessage(Runnable updateMessage) {
		this.impl.updateMessage = updateMessage;
	}

	public void onClick(Function<OnClick, OnClick> function) {
		this.impl.onClick = function.apply(this.impl.onClick);
	}

	public class SliderImpl extends AbstractSliderButton {
		private Runnable applyValue;
		private Runnable updateMessage;
		private OnClick onClick = super::onClick;

		public SliderImpl(int i, int j, int k, int l, Component component, double d) {
			super(i, j, k, l, component, d);
		}

		protected void applyValue() {
			this.applyValue.run();
		}

		protected void updateMessage() {
			this.updateMessage.run();
		}

		public void onClick(double d, double e) {
			this.onClick.onClick(d, e);
		}

		public FabricChatSliderImpl toChatGuiAPI() {
			return FabricChatSliderImpl.this;
		}
	}
}