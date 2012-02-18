/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.camera;

/**
 *
 * @author 694
 */
public class AxisCamera {

    /**
     * Enumeration representing the image resoultion provided by the camera.
     */
    public static class ResolutionT {

        /**
         * The integer value of the enumeration.
         */
        public final int value;
        /**
         * Number of pixels wide.
         */
        public final int width;
        /**
         * Number of pixels tall.
         */
        public final int height;
        static final ResolutionT[] allValues = new ResolutionT[4];
        /**
         * Image is 640 pixels wide by 480 tall
         */
        public static final ResolutionT k640x480 = new ResolutionT(0, 640, 480);
        /**
         * Image is 640 pixels wide by 360 tall
         */
        public static final ResolutionT k640x360 = new ResolutionT(1, 640, 360);
        /**
         * Image is 320 pixels wide by 240 tall
         */
        public static final ResolutionT k320x240 = new ResolutionT(2, 320, 240);
        /**
         * Image is 160 pixels wide by 120 tall
         */
        public static final ResolutionT k160x120 = new ResolutionT(3, 160, 120);

        private ResolutionT(int value, int horizontal, int vertical) {
            this.value = value;
            this.width = horizontal;
            this.height = vertical;
            allValues[value] = this;
        }

        private static ResolutionT get(int value) {
            return allValues[value];
        }
    }


    public static AxisCamera getInstance() {
        return new AxisCamera();
    }

    public ResolutionT getResolution() {
        return ResolutionT.k320x240;
    }

    public ColorImage getImage() {
        return new ColorImage();
    }

    public BinaryImage thresholdHSL(int a, int b, int c, int d, int e, int f) {
        return new BinaryImage();
    }

}
