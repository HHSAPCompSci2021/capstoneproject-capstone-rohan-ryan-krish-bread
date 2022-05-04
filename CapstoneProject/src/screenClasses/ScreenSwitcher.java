package screenClasses;



public interface ScreenSwitcher {
	
	public static final int LEVEL_SELECT = 0;
	public static final int BUILD_1 = 1;
	public static final int BUILD_2 = 2;
	public static final int LAUNCH_1 = 3;
	public static final int LAUNCH_2 = 4;

	
	public void switchScreen(int i);
}
