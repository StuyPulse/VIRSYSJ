/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.image;

/**
 *
 * @author 694
 */
public class NIVision {

    public static class MeasurementType {

        public final int value;
        /** X-coordinate of the point representing the average position of the total particle mass, assuming every point in the particle has a constant density. */
        public static final MeasurementType IMAQ_MT_CENTER_OF_MASS_X = new MeasurementType(0);
        /** Y-coordinate of the point representing the average position of the total particle mass, assuming every point in the particle has a constant density. */
        public static final MeasurementType IMAQ_MT_CENTER_OF_MASS_Y = new MeasurementType(1);
        /** X-coordinate of the highest, leftmost particle pixel. */
        public static final MeasurementType IMAQ_MT_FIRST_PIXEL_X = new MeasurementType(2);
        /** Y-coordinate of the highest, leftmost particle pixel. */
        public static final MeasurementType IMAQ_MT_FIRST_PIXEL_Y = new MeasurementType(3);
        /** X-coordinate of the leftmost particle point. */
        public static final MeasurementType IMAQ_MT_BOUNDING_RECT_LEFT = new MeasurementType(4);
        /** Y-coordinate of highest particle point. */
        public static final MeasurementType IMAQ_MT_BOUNDING_RECT_TOP = new MeasurementType(5);
        /** X-coordinate of the rightmost particle point. */
        public static final MeasurementType IMAQ_MT_BOUNDING_RECT_RIGHT = new MeasurementType(6);
        /** Y-coordinate of the lowest particle point. */
        public static final MeasurementType IMAQ_MT_BOUNDING_RECT_BOTTOM = new MeasurementType(7);
        /** X-coordinate of the start of the line segment connecting the two perimeter points that are the furthest apart. */
        public static final MeasurementType IMAQ_MT_MAX_FERET_DIAMETER_START_X = new MeasurementType(8);
        /** Y-coordinate of the start of the line segment connecting the two perimeter points that are the furthest apart. */
        public static final MeasurementType IMAQ_MT_MAX_FERET_DIAMETER_START_Y = new MeasurementType(9);
        /** X-coordinate of the end of the line segment connecting the two perimeter points that are the furthest apart. */
        public static final MeasurementType IMAQ_MT_MAX_FERET_DIAMETER_END_X = new MeasurementType(10);
        /** Y-coordinate of the end of the line segment connecting the two perimeter points that are the furthest apart. */
        public static final MeasurementType IMAQ_MT_MAX_FERET_DIAMETER_END_Y = new MeasurementType(11);
        /** X-coordinate of the leftmost pixel in the longest row of contiguous pixels in the particle. */
        public static final MeasurementType IMAQ_MT_MAX_HORIZ_SEGMENT_LENGTH_LEFT = new MeasurementType(12);
        /** X-coordinate of the rightmost pixel in the longest row of contiguous pixels in the particle. */
        public static final MeasurementType IMAQ_MT_MAX_HORIZ_SEGMENT_LENGTH_RIGHT = new MeasurementType(13);
        /** Y-coordinate of all of the pixels in the longest row of contiguous pixels in the particle. */
        public static final MeasurementType IMAQ_MT_MAX_HORIZ_SEGMENT_LENGTH_ROW = new MeasurementType(14);
        /** Distance between the x-coordinate of the leftmost particle point and the x-coordinate of the rightmost particle point. */
        public static final MeasurementType IMAQ_MT_BOUNDING_RECT_WIDTH = new MeasurementType(16);
        /** Distance between the y-coordinate of highest particle point and the y-coordinate of the lowest particle point. */
        public static final MeasurementType IMAQ_MT_BOUNDING_RECT_HEIGHT = new MeasurementType(17);
        /** Distance between opposite corners of the bounding rectangle. */
        public static final MeasurementType IMAQ_MT_BOUNDING_RECT_DIAGONAL = new MeasurementType(18);
        /** Length of the outer boundary of the particle. */
        public static final MeasurementType IMAQ_MT_PERIMETER = new MeasurementType(19);
        /** Perimeter of the smallest convex polygon containing all points in the particle. */
        public static final MeasurementType IMAQ_MT_CONVEX_HULL_PERIMETER = new MeasurementType(20);
        /** Sum of the perimeters of each hole in the particle. */
        public static final MeasurementType IMAQ_MT_HOLES_PERIMETER = new MeasurementType(21);
        /** Distance between the start and end of the line segment connecting the two perimeter points that are the furthest apart. */
        public static final MeasurementType IMAQ_MT_MAX_FERET_DIAMETER = new MeasurementType(22);
        /** Length of the major axis of the ellipse with the same perimeter and area as the particle. */
        public static final MeasurementType IMAQ_MT_EQUIVALENT_ELLIPSE_MAJOR_AXIS = new MeasurementType(23);
        /** Length of the minor axis of the ellipse with the same perimeter and area as the particle. */
        public static final MeasurementType IMAQ_MT_EQUIVALENT_ELLIPSE_MINOR_AXIS = new MeasurementType(24);
        /** Length of the minor axis of the ellipse with the same area as the particle, and Major Axis equal in length to the Max Feret Diameter. */
        public static final MeasurementType IMAQ_MT_EQUIVALENT_ELLIPSE_MINOR_AXIS_FERET = new MeasurementType(25);
        /** Longest side of the rectangle with the same perimeter and area as the particle. */
        public static final MeasurementType IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE = new MeasurementType(26);
        /** Shortest side of the rectangle with the same perimeter and area as the particle. */
        public static final MeasurementType IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE = new MeasurementType(27);
        /** Distance between opposite corners of the rectangle with the same perimeter and area as the particle. */
        public static final MeasurementType IMAQ_MT_EQUIVALENT_RECT_DIAGONAL = new MeasurementType(28);
        /** Shortest side of the rectangle with the same area as the particle, and longest side equal in length to the Max Feret Diameter. */
        public static final MeasurementType IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE_FERET = new MeasurementType(29);
        /** Average length of a horizontal segment in the particle. */
        public static final MeasurementType IMAQ_MT_AVERAGE_HORIZ_SEGMENT_LENGTH = new MeasurementType(30);
        /** Average length of a vertical segment in the particle. */
        public static final MeasurementType IMAQ_MT_AVERAGE_VERT_SEGMENT_LENGTH = new MeasurementType(31);
        /** The particle area divided by the particle perimeter. */
        public static final MeasurementType IMAQ_MT_HYDRAULIC_RADIUS = new MeasurementType(32);
        /** Diameter of a disk with the same area as the particle. */
        public static final MeasurementType IMAQ_MT_WADDEL_DISK_DIAMETER = new MeasurementType(33);
        /** Area of the particle. */
        public static final MeasurementType IMAQ_MT_AREA = new MeasurementType(35);
        /** Sum of the areas of each hole in the particle. */
        public static final MeasurementType IMAQ_MT_HOLES_AREA = new MeasurementType(36);
        /** Area of a particle that completely covers the image. */
        public static final MeasurementType IMAQ_MT_PARTICLE_AND_HOLES_AREA = new MeasurementType(37);
        /** Area of the smallest convex polygon containing all points in the particle. */
        public static final MeasurementType IMAQ_MT_CONVEX_HULL_AREA = new MeasurementType(38);
        /** Area of the image. */
        public static final MeasurementType IMAQ_MT_IMAGE_AREA = new MeasurementType(39);
        /** Number of holes in the particle. */
        public static final MeasurementType IMAQ_MT_NUMBER_OF_HOLES = new MeasurementType(41);
        /** Number of horizontal segments in the particle. */
        public static final MeasurementType IMAQ_MT_NUMBER_OF_HORIZ_SEGMENTS = new MeasurementType(42);
        /** Number of vertical segments in the particle. */
        public static final MeasurementType IMAQ_MT_NUMBER_OF_VERT_SEGMENTS = new MeasurementType(43);
        /** The angle of the line that passes through the particle Center of Mass about which the particle has the lowest moment of inertia. */
        public static final MeasurementType IMAQ_MT_ORIENTATION = new MeasurementType(45);
        /** The angle of the line segment connecting the two perimeter points that are the furthest apart. */
        public static final MeasurementType IMAQ_MT_MAX_FERET_DIAMETER_ORIENTATION = new MeasurementType(46);
        /** Percentage of the particle Area covering the Image Area. */
        public static final MeasurementType IMAQ_MT_AREA_BY_IMAGE_AREA = new MeasurementType(48);
        /** Percentage of the particle Area in relation to its Particle and Holes Area. */
        public static final MeasurementType IMAQ_MT_AREA_BY_PARTICLE_AND_HOLES_AREA = new MeasurementType(49);
        /** Equivalent Ellipse Major Axis divided by Equivalent Ellipse Minor Axis. */
        public static final MeasurementType IMAQ_MT_RATIO_OF_EQUIVALENT_ELLIPSE_AXES = new MeasurementType(50);
        /** Equivalent Rect Long Side divided by Equivalent Rect Short Side. */
        public static final MeasurementType IMAQ_MT_RATIO_OF_EQUIVALENT_RECT_SIDES = new MeasurementType(51);
        /** Max Feret Diameter divided by Equivalent Rect Short Side (Feret). */
        public static final MeasurementType IMAQ_MT_ELONGATION_FACTOR = new MeasurementType(53);
        /** Area divided by the product of Bounding Rect Width and Bounding Rect Height. */
        public static final MeasurementType IMAQ_MT_COMPACTNESS_FACTOR = new MeasurementType(54);
        /** Perimeter divided by the circumference of a circle with the same area. */
        public static final MeasurementType IMAQ_MT_HEYWOOD_CIRCULARITY_FACTOR = new MeasurementType(55);
        /** Factor relating area to moment of inertia. */
        public static final MeasurementType IMAQ_MT_TYPE_FACTOR = new MeasurementType(56);
        /** The sum of all x-coordinates in the particle. */
        public static final MeasurementType IMAQ_MT_SUM_X = new MeasurementType(58);
        /** The sum of all y-coordinates in the particle. */
        public static final MeasurementType IMAQ_MT_SUM_Y = new MeasurementType(59);
        /** The sum of all x-coordinates squared in the particle. */
        public static final MeasurementType IMAQ_MT_SUM_XX = new MeasurementType(60);
        /** The sum of all x-coordinates times y-coordinates in the particle. */
        public static final MeasurementType IMAQ_MT_SUM_XY = new MeasurementType(61);
        /** The sum of all y-coordinates squared in the particle. */
        public static final MeasurementType IMAQ_MT_SUM_YY = new MeasurementType(62);
        /** The sum of all x-coordinates cubed in the particle. */
        public static final MeasurementType IMAQ_MT_SUM_XXX = new MeasurementType(63);
        /** The sum of all x-coordinates squared times y-coordinates in the particle. */
        public static final MeasurementType IMAQ_MT_SUM_XXY = new MeasurementType(64);
        /** The sum of all x-coordinates times y-coordinates squared in the particle. */
        public static final MeasurementType IMAQ_MT_SUM_XYY = new MeasurementType(65);
        /** The sum of all y-coordinates cubed in the particle. */
        public static final MeasurementType IMAQ_MT_SUM_YYY = new MeasurementType(66);
        /** The moment of inertia in the x-direction twice. */
        public static final MeasurementType IMAQ_MT_MOMENT_OF_INERTIA_XX = new MeasurementType(68);
        /** The moment of inertia in the x and y directions. */
        public static final MeasurementType IMAQ_MT_MOMENT_OF_INERTIA_XY = new MeasurementType(69);
        /** The moment of inertia in the y-direction twice. */
        public static final MeasurementType IMAQ_MT_MOMENT_OF_INERTIA_YY = new MeasurementType(70);
        /** The moment of inertia in the x-direction three times. */
        public static final MeasurementType IMAQ_MT_MOMENT_OF_INERTIA_XXX = new MeasurementType(71);
        /** The moment of inertia in the x-direction twice and the y-direction once. */
        public static final MeasurementType IMAQ_MT_MOMENT_OF_INERTIA_XXY = new MeasurementType(72);
        /** The moment of inertia in the x-direction once and the y-direction twice. */
        public static final MeasurementType IMAQ_MT_MOMENT_OF_INERTIA_XYY = new MeasurementType(73);
        /** The moment of inertia in the y-direction three times. */
        public static final MeasurementType IMAQ_MT_MOMENT_OF_INERTIA_YYY = new MeasurementType(74);
        /** The normalized moment of inertia in the x-direction twice. */
        public static final MeasurementType IMAQ_MT_NORM_MOMENT_OF_INERTIA_XX = new MeasurementType(75);
        /** The normalized moment of inertia in the x- and y-directions. */
        public static final MeasurementType IMAQ_MT_NORM_MOMENT_OF_INERTIA_XY = new MeasurementType(76);
        /** The normalized moment of inertia in the y-direction twice. */
        public static final MeasurementType IMAQ_MT_NORM_MOMENT_OF_INERTIA_YY = new MeasurementType(77);
        /** The normalized moment of inertia in the x-direction three times. */
        public static final MeasurementType IMAQ_MT_NORM_MOMENT_OF_INERTIA_XXX = new MeasurementType(78);
        /** The normalized moment of inertia in the x-direction twice and the y-direction once. */
        public static final MeasurementType IMAQ_MT_NORM_MOMENT_OF_INERTIA_XXY = new MeasurementType(79);
        /** The normalized moment of inertia in the x-direction once and the y-direction twice. */
        public static final MeasurementType IMAQ_MT_NORM_MOMENT_OF_INERTIA_XYY = new MeasurementType(80);
        /** The normalized moment of inertia in the y-direction three times. */
        public static final MeasurementType IMAQ_MT_NORM_MOMENT_OF_INERTIA_YYY = new MeasurementType(81);
        /** The first Hu moment. */
        public static final MeasurementType IMAQ_MT_HU_MOMENT_1 = new MeasurementType(82);
        /** The second Hu moment. */
        public static final MeasurementType IMAQ_MT_HU_MOMENT_2 = new MeasurementType(83);
        /** The third Hu moment. */
        public static final MeasurementType IMAQ_MT_HU_MOMENT_3 = new MeasurementType(84);
        /** The fourth Hu moment. */
        public static final MeasurementType IMAQ_MT_HU_MOMENT_4 = new MeasurementType(85);
        /** The fifth Hu moment. */
        public static final MeasurementType IMAQ_MT_HU_MOMENT_5 = new MeasurementType(86);
        /** The sixth Hu moment. */
        public static final MeasurementType IMAQ_MT_HU_MOMENT_6 = new MeasurementType(87);
        /** The seventh Hu moment. */
        public static final MeasurementType IMAQ_MT_HU_MOMENT_7 = new MeasurementType(88);

        public static final MeasurementType IMAQ_MEASUREMENT_TYPE_SIZE_GUARD = new MeasurementType(0xFFFFFFFF);

        private MeasurementType(int value) {
            this.value = value;
        }
    }


}
