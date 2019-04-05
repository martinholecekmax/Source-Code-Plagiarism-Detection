public class EZCalcAPI {
		
		public static String getVersion() {
			return EZCalc.currentVersion;
		}
		
		public static boolean isBeta() {
			return Config.readBoolean("updates.nightlies");	
		}
		
		public static boolean isStable() {
			return Config.readBoolean("updates.stable");	
		}
		
		public static boolean doesAutoUpdate() {
			return Config.readBoolean("updates.auto-update");	
		}
		
		public static boolean usingPermissions() {
			return true;
		}
		
		public static boolean ping() {
			return true;	
		}
		
		public static boolean pong() {
			return false;	
		}
}