package screenClasses;



public interface ScreenSwitcher {
	
	public static final int LEVEL_SELECT = 0;
	public static final int INSTRUCTIONS = 1;
	
	public static final int BUILD_1 = 2;
	public static final int BUILD_2 = 3;
	public static final int BUILD_3 = 4;
	public static final int BUILD_4 = 5;
	
	public static final int LAUNCH_1 = 6;
	public static final int LAUNCH_2 = 7;
	public static final int LAUNCH_3 = 8;
	public static final int LAUNCH_4 = 9;
	

	
	public void switchScreen(int i);
}
