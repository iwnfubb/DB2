/* XXL: The eXtensible and fleXible Library for data processing

Copyright (C) 2000-2011 Prof. Dr. Bernhard Seeger
                        Head of the Database Research Group
                        Department of Mathematics and Computer Science
                        University of Marburg
                        Germany

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 3 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library;  If not, see <http://www.gnu.org/licenses/>. 

    http://code.google.com/p/xxl/

*/

package xxl.core.util.timers;

/**
 * The timer interface is the base of efficient timers which are 
 * based on Ticks as smallest units. Each implementation of this
 * interface can have a different number of ticks per second.
 */
public interface Timer {
	/** 
	 * Starts the timer.
	 */
	public void start();
	/**
	 * Returns the time in ticks since the last start-call.
	 * @return number of ticks
	 */
	public long getDuration();
	/**
	 * Returns the number of ticks per second.
	 * @return number of ticks
	 */
	public long getTicksPerSecond();
	/**
	 * Returns a String with information about the Timer.
	 * @return timer info
	 */
	public String timerInfo();
}
