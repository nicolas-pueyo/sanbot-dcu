package com.example.sanbotapp.robotControl;

/*import com.qihancloud.opensdk.function.beans.handmotion.AbsoluteAngleHandMotion;
import com.qihancloud.opensdk.function.unit.HandMotionManager;*/

import com.sanbot.opensdk.function.beans.handmotion.AbsoluteAngleHandMotion;
import com.sanbot.opensdk.function.unit.HandMotionManager;

public class HandsControl {
    private HandMotionManager handMotionManager;

    // Constructor
    public HandsControl(HandMotionManager handMotionManager){
        this.handMotionManager = handMotionManager;
    }

    // Enum utilizado para definir las acciones de brazo, en este caso: levantar y bajar
    public enum AccionesBrazos {
        LEVANTAR_BRAZO,
        BAJAR_BRAZO,
    }

    // Enum utilizado para definir los tipos de brazo con los que se puede trabajar,
    // en este caso: derecho, izquierdo y ambos
    public enum TipoBrazo {
        DERECHO,
        IZQUIERDO,
        AMBOS;
    }

    // Función utilizada para indicar la acción que se quiere realizar
    // y el brazo o brazos que se quieren mover
    public boolean controlBasicoBrazos(AccionesBrazos accion, TipoBrazo brazo) {
        byte[] absolutePart = new byte[]{AbsoluteAngleHandMotion.PART_LEFT, AbsoluteAngleHandMotion.PART_RIGHT, AbsoluteAngleHandMotion.PART_BOTH};
        AbsoluteAngleHandMotion absoluteAngleHandMotion;
        switch(accion) {
            case LEVANTAR_BRAZO:
                switch (brazo) {
                    case IZQUIERDO:
                        absoluteAngleHandMotion = new AbsoluteAngleHandMotion(absolutePart[0], (byte) 7, (byte) 10, 5, 90);
                        // TODO PROVISIONAL
                        //handMotionManager.doAbsoluteAngleMotion(absoluteAngleHandMotion);

                        break;
                    case DERECHO:
                        absoluteAngleHandMotion = new AbsoluteAngleHandMotion(absolutePart[1], (byte) 7, (byte) 10, 5, 90);
                        //handMotionManager.doAbsoluteAngleMotion(absoluteAngleHandMotion);
                        break;
                    case AMBOS:
                        absoluteAngleHandMotion = new AbsoluteAngleHandMotion(absolutePart[2], (byte)7, (byte)10, 5, 90);
                        //handMotionManager.doAbsoluteAngleMotion(absoluteAngleHandMotion);
                        break;
                }
                break;
            case BAJAR_BRAZO:
                switch (brazo) {
                    case IZQUIERDO:
                        absoluteAngleHandMotion = new AbsoluteAngleHandMotion(absolutePart[0], (byte) 7, (byte)170, 5, 90);
                        //handMotionManager.doAbsoluteAngleMotion(absoluteAngleHandMotion);
                        break;
                    case DERECHO:
                        absoluteAngleHandMotion = new AbsoluteAngleHandMotion(absolutePart[1], (byte) 7, (byte)170, 5, 90);
                        //handMotionManager.doAbsoluteAngleMotion(absoluteAngleHandMotion);
                        break;
                    case AMBOS:
                        absoluteAngleHandMotion = new AbsoluteAngleHandMotion(absolutePart[2], (byte) 7, (byte)170, 5, 90);
                        //handMotionManager.doAbsoluteAngleMotion(absoluteAngleHandMotion);
                        break;
                }
                break;
        }
        return true;
    }

    // Función para poner los brazos en su posición original, en este caso: hacia abajo
    public boolean reiniciar(){
        byte[] absolutePart = new byte[]{AbsoluteAngleHandMotion.PART_LEFT, AbsoluteAngleHandMotion.PART_RIGHT, AbsoluteAngleHandMotion.PART_BOTH};
        // TODO PROVISIONAL
        //AbsoluteAngleHandMotion absoluteAngleHandMotion = new AbsoluteAngleHandMotion(absolutePart[2], 7, 170);
        //handMotionManager.doAbsoluteAngleMotion(absoluteAngleHandMotion);
        return true;
    }
}
