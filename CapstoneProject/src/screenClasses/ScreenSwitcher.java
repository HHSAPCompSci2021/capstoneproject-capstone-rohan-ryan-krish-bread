package screenClasses;

/**
 * Represents the screens that can be switched to
 * @author Ryan, Rohan, Krish
 */
public interface ScreenSwitcher {
	
	public static final int LEVEL_SELECT = 0;
	public static final int BUILD_1 = 1;
	public static final int BUILD_2 = 2;
	public static final int LAUNCH_1 = 3;
	public static final int LAUNCH_2 = 4;
	public static final int INSTRUCTIONS = 5;
	public static final int LAUNCH_3 = 7;
	public static final int BUILD_3 = 6;

	/**
	 * Switches the screen that is being drawn
	 * @param i Integer that is used to specify the new screen
	 */
	public void switchScreen(int i);
}
