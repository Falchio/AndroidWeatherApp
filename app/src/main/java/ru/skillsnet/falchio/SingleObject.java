package ru.skillsnet.falchio;

public final class SingleObject {
    private static SingleObject instance;
    private static final Object SYNC_OBJ = new Object();

    private static boolean showWindSpeed = false;
    private static boolean showAtmPressure = false;

    private SingleObject() {
    }

    public static SingleObject getInstance() {

        synchronized (SYNC_OBJ){
            if (instance == null){
                instance = new SingleObject();
            }
            return instance;
        }
    }

    public static boolean isShowWindSpeed() {
        return showWindSpeed;
    }

    public static boolean isShowAtmPressure() {
        return showAtmPressure;
    }

    public static void setShowWindSpeed(boolean showWindSpeed) {
        SingleObject.showWindSpeed = showWindSpeed;
    }

    public static void setShowAtmPressure(boolean showAtmPressure) {
        SingleObject.showAtmPressure = showAtmPressure;
    }
}
