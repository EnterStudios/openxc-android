package com.openxc.measurements;

import com.openxc.units.Unit;
import com.openxc.util.Range;

/**
 * The MeasurementInterface is the base for all OpenXC measurements.
 *
 * A Measurement has at least a value and an age, and optionally a range of
 * valid values.
 */
public interface MeasurementInterface {
    public interface Listener {
        public void receive(MeasurementInterface measurement);
    }

    /**
     * Retreive the age of this measurement.
     *
     * @return the age of the data in seconds.
     */
    public double getAge();

    /**
     * Set the birth timestamp for this measurement.
     *
     */
    public void setTimestamp(double timestamp);

    /**
     * Determine if this measurement has a valid range.
     *
     * @return true if the measurement has a non-null range.
     */
    public boolean hasRange();

    /**
     * Retrieve the valid range of the measurement.
     *
     * @return the Range of the measurement
     * @throws NoRangeException if the measurement doesn't have a range.
     */
    public Range<? extends Unit> getRange() throws NoRangeException;

    /**
     * Return the value of this measurement.
     *
     * @return The wrapped value (an instance of TheUnit)
     */
    public Unit getValue();

    public Object getSerializedValue();

    // TODO argh, no easy way to get a type for this without having two template
    // parameters
    public Object getEvent();

    public Object getSerializedEvent();
}
