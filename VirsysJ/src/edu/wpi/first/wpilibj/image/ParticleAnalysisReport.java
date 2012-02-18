/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.image;

import edu.wpi.first.wpilibj.camera.BinaryImage;

/**
 * Class to store commonly used information about a particle.
 * @author dtjones
 */
public class ParticleAnalysisReport {

    /**
     * The height of the image in pixels.
     */
    public final int imageHeight;
    /**
     * The width of the image in pixels.
     */
    public final int imageWidth;
    /** X-coordinate of the point representing the average position of the
     * total particle mass, assuming every point in the particle has a constant density */
    public final int center_mass_x;  			// MeasurementType: IMAQ_MT_CENTER_OF_MASS_X
    /** Y-coordinate of the point representing the average position of the
     * total particle mass, assuming every point in the particle has a constant density */
    public final int center_mass_y;  			// MeasurementType: IMAQ_MT_CENTER_OF_MASS_Y
    /**
     * Center of mass x value normalized to -1.0 to +1.0 range.
     */
    public final double center_mass_x_normalized;
    /**
     * Center of mass y value normalized to -1.0 to +1.0 range.
     */
    public final double center_mass_y_normalized;
    /** Area of the particle */
    public final double particleArea;				// MeasurementType: IMAQ_MT_AREA
    /** Bounding Rectangle */
    public final int boundingRectLeft;				// left/top/width/height
    /** Bounding Rectangle */
    public final int boundingRectTop;
    /** Bounding Rectangle */
    public final int boundingRectWidth;
    /** Bounding Rectangle */
    public final int boundingRectHeight;
    /** Percentage of the particle Area covering the Image Area. */
    public final double particleToImagePercent;		// MeasurementType: IMAQ_MT_AREA_BY_IMAGE_AREA
    /** Percentage of the particle Area in relation to its Particle and Holes Area */
    public final double particleQuality;			// MeasurementType: IMAQ_MT_AREA_BY_PARTICLE_AND_HOLES_AREA

    ParticleAnalysisReport(BinaryImage image, int index) throws NIVisionException {
        imageHeight = 320;
        imageWidth = 480;
        center_mass_x = 100;
        center_mass_y = 200;
        center_mass_x_normalized = (2.0 * center_mass_x / imageWidth) - 1.0;
        center_mass_y_normalized = (2.0 * center_mass_y / imageHeight) - 1.0;
        particleArea = 1337;
        boundingRectLeft = 50;
        boundingRectTop = 70;
        boundingRectWidth = 80;
        boundingRectHeight = 90;
        particleToImagePercent = 64;
        particleQuality = 6.94;
    }

    static double getParticleToImagePercent(BinaryImage image, int index) throws NIVisionException {
        return 66;
    }

    /**
     * Get string representation of the particle analysis report.
     * @return A string representation of the particle analysis report.
     */
    public String toString() {
        return "Particle Report: \n" +
                "    Image Height    : " + imageHeight + "\n" +
                "    Image Width     : " + imageWidth + "\n" +
                "    Center of mass  : ( " + center_mass_x + " , " + center_mass_y + " )\n" +
                "      normalized    : ( " + center_mass_x_normalized + " , " + center_mass_y_normalized + " )\n" +
                "    Area            : " + particleArea + "\n" +
                "      percent       : " + particleToImagePercent + "\n" +
                "    Bounding Rect   : ( " + boundingRectLeft + " , " + boundingRectTop + " ) " + boundingRectWidth + "*" + boundingRectHeight + "\n" +
                "    Quality         : " + particleQuality + "\n";
    }
}
