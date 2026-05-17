package vakiliner.chatguiapi.base;

public interface ChatSlider extends ChatWidget {
	void onApplyValue(Runnable applyValue);

	void onUpdateMessage(Runnable updateMessage);
}