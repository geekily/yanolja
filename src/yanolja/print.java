package yanolja;

public class print { // ¸Þ´º µðÀÚÀÎ

	String leftBlank="                                 ";
	String upBlank="\n\n\n";
	String menuBlank="                 ";

	public String rogo() { // ¸Þ´º ·Î°í

		String rogo = upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				leftBlank+"¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" + 
				leftBlank+"¦­                                                                                                           ¦­\n" + 
				leftBlank+"¦­                                 __   __        _   _         _                                            ¦­\n" + 
				leftBlank+"¦­                                 \\ \\ / /       | \\ | |       | |                                           ¦­\n" + 
				leftBlank+"¦­                                  \\ V /   __ _ |  \\| |  ___  | | ____  __ _                                ¦­\n" + 
				leftBlank+"¦­                                   \\ /   / _` || . ` | / _ \\ | ||_  / / _` |                               ¦­\n"+ 
				leftBlank+"¦­                                   | |  | (_| || |\\  || (_) || | / / | (_| |                               ¦­\n" + 
				leftBlank+"¦­                                   \\_/   \\__,_|\\_| \\_/ \\___/ |_|/___| \\__,_|                               ¦­\n" + 
				leftBlank+"¦­                                                                                                           ¦­\n" + 
				leftBlank+"¦­                                                                                                           ¦­\n" + 
				leftBlank+"¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n";

		return rogo;

	}

	public String id() { // ÇöÀç ·Î±×ÀÎ µÈ ¾ÆÀÌµð µðÀÚÀÎ

		
		String id = upBlank +
				leftBlank + leftBlank + "          ¡á¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + leftBlank + "              " + Member.member + " ´Ô\n" +
				leftBlank + leftBlank + "          ¦±¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n";
		return id;

	}
	
	public String main() { // ·Î±×ÀÎ ÈÄ ¸Þ´º

		String main =
				leftBlank + menuBlank + " ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + menuBlank + " ¦­   1. ³» °èÁ¤   ¦­    2. ¿¹¾à    ¦­   3. ¿¹¾à°ü¸®   ¦­   4. ·Î±×¾Æ¿ô   ¦­\n" +
				leftBlank + menuBlank + " ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n" +
				leftBlank + menuBlank + "                               ¡áÀÔ·Â: ";
		return main;
	}

	public String managerLogo() { // °ü¸®ÀÚ ·Î±×ÀÎ ÈÄ ·Î°í

		String managerlogo = upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				upBlank +
				leftBlank+"¡á¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" + 
				leftBlank+" ¦­               ___  ___                                         ___  ___                                   ¦­ \n" + 
				leftBlank+" ¦­               |  \\/  |                                         |  \\/  |                                   ¦­ \n" + 
				leftBlank+" ¦­               | .  . |  __ _  _ __    __ _   __ _   ___  _ __  | .  . |  ___  _ __   _   _                ¦­\n" + 
				leftBlank+" ¦­               | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__| | |\\/| | / _ \\| '_ \\ | | | |               ¦­\n" + 
				leftBlank+" ¦­               | |  | || (_| || | | || (_| || (_| ||  __/| |    | |  | ||  __/| | | || |_| |               ¦­\n" + 
				leftBlank+" ¦­               \\_|  |_/ \\__,_||_| |_| \\__,_| \\__, | \\___||_|    \\_|  |_/ \\___||_| |_| \\__,_|               ¦­\n" + 
				leftBlank+" ¦­                                              __/ |                                                        ¦­\n" + 
				leftBlank+" ¦­                                             |___/                                                         ¦­\n" + 
				leftBlank+" ¦­                                                                                                           ¦­\n" + 
				leftBlank+" ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n";

		return managerlogo;

	}

	public String managerMenu() { // °ü¸®ÀÚ ·Î±×ÀÎ ÈÄ ¸Þ´º

		String managermenu = upBlank + 
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + "                              È£ÅÚ¸Å´ÏÁ® °ü¸®Ã¢                           \n" +
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + " ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + menuBlank + " ¦­ 1. È£ÅÚ°ü¸® ¦­ 2. È£ÅÚ ¹æ°ü¸® ¦­ 3. ¿¹¾à°ü¸® ¦­ 4. È¸¿ø°ü¸® ¦­ 5.µÚ·Î ¦­\n" +
				leftBlank + menuBlank + " ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n" +
				leftBlank + menuBlank + "                               ¡áÀÔ·Â: ";

		return managermenu;
	}

	public String hotelMenu() { // °ü¸®ÀÚ - 1. È£ÅÚ°ü¸® ¸Þ´º

		String hotelmenu = upBlank + 
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + "                                 È£ÅÚ °ü¸®Ã¢                              \n" +
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + " ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + menuBlank + " ¦­ 1. È£ÅÚÁ¶È¸ ¦­ 2. È£ÅÚ Ãß°¡ ¦­ 3. È£ÅÚ ¼öÁ¤ ¦­ 4. È£ÅÚ »èÁ¦ ¦­ 5.µÚ·Î ¦­\n" +
				leftBlank + menuBlank + " ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n" +
				leftBlank + menuBlank + "                               ¡áÀÔ·Â: ";

		return hotelmenu;


	}

	public String roomMenu() { // °ü¸®ÀÚ - 2. È£ÅÚ ¹æ°ü¸® ¸Þ´º

		String roommenu = upBlank + 
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + "                               È£ÅÚ ¹æ °ü¸®Ã¢                           \n" +
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + " ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + menuBlank + " ¦­1.È£ÅÚ ¹æ Á¶È¸¦­2.È£ÅÚ ¹æ Ãß°¡¦­3.È£ÅÚ ¹æ ¼öÁ¤¦­4.È£ÅÚ ¹æ »èÁ¦¦­5. µÚ·Î¦­\n" +
				leftBlank + menuBlank + " ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n" +
				leftBlank + menuBlank + "                               ¡áÀÔ·Â: ";

		return roommenu;

	}
	
	public String managerRMMenu() { // °ü¸®ÀÚ - 3. ¿¹¾à°ü¸® ¸Þ´º

		String RMmenu = upBlank+
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + "                                  ¿¹¾à °ü¸®                                \n" +
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + " ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + menuBlank + " ¦­ 1. ¿¹¾àÁ¶È¸ ¦­ 2. ¿¹¾à°Ë»ö ¦­ 3. ¿¹¾à º¯°æ ¦­ 4. ¿¹¾à Ãë¼Ò ¦­ 5. µÚ·Î ¦­\n" +
				leftBlank + menuBlank + " ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n" +
				leftBlank + menuBlank + "                               ¡áÀÔ·Â: ";

		return RMmenu;

	}

	public String managerUserMenu() { // °ü¸®ÀÚ - 4. È¸¿ø°ü¸® ¸Þ´º

		String userMenu = upBlank+
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + "                                 È¸¿ø °ü¸®Ã¢                             \n" +
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + " ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + menuBlank + " ¦­ 1. È¸¿øÁ¶È¸ ¦­ 2. È¸¿ø °Ë»ö ¦­ 3. È¸¿ø ¼öÁ¤ ¦­ 4. È¸¿ø»èÁ¦ ¦­ 5. µÚ·Î ¦­\n" +
				leftBlank + menuBlank + " ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n" +
				leftBlank + menuBlank + "                               ¡áÀÔ·Â: ";

		return userMenu;

	}

	public String selectHotel() { // print() ¶§ »ç¿ëÇÏ´Â µð½ºÇÃ·¹ÀÌ ?

		String sh = upBlank+
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + "                               È£ÅÚÄÚµå  ¹æÀÌ¸§                            \n" +
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" ;
		return sh;
	}

	public String printsr() { // print() ÈÄ µÚ·Î°¡±â ?

		String vprint = upBlank + 
				leftBlank + menuBlank + " ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + menuBlank + " ¦­                               1. µÚ·Î°¡±â                             ¦­\n" +
				leftBlank + menuBlank + " ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n" +
				leftBlank + menuBlank + "                               ¡áÀÔ·Â: ";

		return vprint;
	}

	public void blank() { // À­ °ø¹é
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	public void downBlank() { // ¹Ø °ø¹é
		String str =
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank +
		upBlank ;
	}
	public String display() { // ÃÊ±â È­¸é

		String str =
				leftBlank + menuBlank + " ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + menuBlank + " ¦­   1. È¸¿ø°¡ÀÔ   ¦­   2. ·Î±×ÀÎ   ¦­  3. °ü¸®ÀÚ ·Î±×ÀÎ  ¦­   4. Á¾·á   ¦­\n" +
				leftBlank + menuBlank + " ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n" +
				leftBlank + menuBlank + "                              ¡áÀÔ·Â : ";
		return str;

	}

	public String myInfo() { // ·Î±×ÀÎ¸Þ´º - 1. ³» Á¤º¸
		
		String str = 
				leftBlank + menuBlank + " ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + menuBlank + " ¦­     1. ³» Á¤º¸ º¸±â     ¦­     2. ³» Á¤º¸ ¼öÁ¤     ¦­     3. µÚ·Î     ¦­\n" +
				leftBlank + menuBlank + " ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n" +
				leftBlank + menuBlank + "                              ¡áÀÔ·Â : ";
		return str;
		
	}
	
	
	

	public String RMMenu() { // ·Î±×ÀÎ - ¿¹¾à°ü¸® ¸Þ´º

		String RMmenu = upBlank+
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + "                             " + Member.member + "´ÔÀÇ ¿¹¾à °ü¸®         \n" +
				leftBlank + menuBlank + "   ¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬\n" +
				leftBlank + menuBlank + " ¡á-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¯\n" +
				leftBlank + menuBlank + " ¦­   1. ¿¹¾àÁ¶È¸   ¦­   2. ¿¹¾à º¯°æ   ¦­   3. ¿¹¾à Ãë¼Ò   ¦­  4. µÚ·Î   ¦­\n" +
				leftBlank + menuBlank + " ¦±-¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦¬¦°\n" +
				leftBlank + menuBlank + "                               ¡áÀÔ·Â: ";

		return RMmenu;

	}
	
}