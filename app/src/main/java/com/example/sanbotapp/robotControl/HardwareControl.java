package com.example.sanbotapp.robotControl;

/*import com.qihancloud.opensdk.function.beans.LED;
import com.qihancloud.opensdk.function.unit.HardWareManager;*/

import com.sanbot.opensdk.function.beans.LED;
import com.sanbot.opensdk.function.unit.HardWareManager;

public class HardwareControl {
    private HardWareManager hardWareManager;

    // Constructor
    public HardwareControl(HardWareManager hardWareManager){
        this.hardWareManager = hardWareManager;
    }

    // Función para encender el LED en la parte y modo que se pase como parámetro
    public boolean encenderLED(byte parte, byte modo) {
        hardWareManager.setLED(new LED(parte, modo));
        return true;
    }

    // Función para apagar el LED en la parte y modo que se pase como parámetro
    public boolean apagarLED(byte parte) {
        hardWareManager.setLED(new LED(parte, LED.MODE_CLOSE));
        return true;
    }
}
