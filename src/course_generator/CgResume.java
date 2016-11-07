/*
 * Course Generator
 * Copyright (C) 2016 Pierre Delore
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package course_generator;

import org.joda.time.DateTime;

import course_generator.utils.CgConst;
import course_generator.utils.Utils;

/**
 *
 * @author pierre.delore
 */
public class CgResume {
	private double Num; // Line number
	private String Name; // Name of the position
	private double Line; // Line from the data grid
	private double Elevation; // Elevation in meter
	private double ClimbP; // Positive climb
	private double ClimbM; // Negative climb
	private double Dist; // Distance between point in meter
	private int Time; // Total time in second
	private DateTime Hour; // Date and hour at this position
	private int dTime_f; // Time from the previous position in second
	private double Total; // Total distance in meter
	private int TimeLimit; // Time limit at this position
	private int StationTime; // Time to stay at this position
	private double dDist; // Distance from the previous position
	private double dClimbP; // Positive from the previous position
	private double dClimbM; // Negative from the previous position
	private double SpeedP; // Positive climb speed m/h
	private double SpeedM; // Negative climb speed m/h
	private double AvgSlopeP; // Average positive slope %
	private double AvgSlopeM; // Average negative slope %
	private double AvgSpeed; // Average speed km/h
	private String Comment; // Comment

	// -- Number
	public double getNum() {
		return Num;
	}

	public void setNum(double num) {
		Num = num;
	}

	// -- Name
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	// -- Line number
	public double getLine() {
		return Line;
	}

	public void setLine(double line) {
		Line = line;
	}

	// -- Elevation
	public double getElevation() {
		return Elevation;
	}

	public double getElevation(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return Elevation;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2Feet(Elevation);
		default:
			return Elevation;
		}
	}

	public String getElevationString(int unit, boolean withunit) {

		double e = getElevation(unit);

		String s = "";
		switch (unit) {
		case CgConst.UNIT_METER:
			s = String.format("%1.0f ", e);
			if (withunit)
				s = s + "m";
			break;
		case CgConst.UNIT_MILES_FEET:
			s = String.format("%1.0f ", e);
			if (withunit)
				s = s + "feet";
			break;
		default:
			s = String.format("%1.0f ", e);
			if (withunit)
				s = s + "m";
			break;
		}
		return s;
	}

	public void setElevation(double elevation) {
		Elevation = elevation;
	}

	// -- positive climb
	public double getClimbP() {
		return ClimbP;
	}

	public double getClimbP(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return ClimbP;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2Feet(ClimbP);
		default:
			return ClimbP;
		}
	}

	
	public String getClimbPString(int unit, boolean withunit) {
		
		double e=getClimbP(unit);
		
		String s="";
		switch (unit) {
			case CgConst.UNIT_METER:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"m";
				break;
			case CgConst.UNIT_MILES_FEET:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"feet";
				break;
			default:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"m";
				break;
		}
		return s;
	}
	
	public void setClimbP(double climbP) {
		ClimbP = climbP;
	}

	// -- Negative climb
	public double getClimbM() {
		return ClimbM;
	}

	public double getClimbM(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return ClimbM;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2Feet(ClimbM);
		default:
			return ClimbM;
		}
	}

	
	public String getClimbMString(int unit, boolean withunit) {
		
		double e=getClimbM(unit);
		
		String s="";
		switch (unit) {
			case CgConst.UNIT_METER:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"m";
				break;
			case CgConst.UNIT_MILES_FEET:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"feet";
				break;
			default:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"m";
				break;
		}
		return s;
	}
	
	public void setClimbM(double climbM) {
		ClimbM = climbM;
	}

	// -- Distance
	public double getDist() {
		return Dist;
	}

	public double getDist(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return Dist;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2uMiles(Dist);
		default:
			return Dist;
		}
	}

	public String getDistString(int unit, boolean withunit) {

		Double d = getDist(unit);

		String s = "";

		// -- Set the value
		switch (unit) {
		case CgConst.UNIT_METER:
			s = String.format("%1.0f ", d);
			if (withunit)
				s = s + "m";
			break;
		case CgConst.UNIT_MILES_FEET:
			s = String.format("%1.0f ", d);
			if (withunit)
				s = s + "miles";
			break;
		default:
			s = String.format("%1.0f ", d);
			if (withunit)
				s = s + "m";
			break;
		}
		return s;
	}

	public void setDist(double dist) {
		Dist = dist;
	}

	// -- Time
	public int getTime() {
		return Time;
	}

	public void setTime(int time) {
		Time = time;
	}

	// -- Hour
	public DateTime getHour() {
		return Hour;
	}

	public void setHour(DateTime hour) {
		Hour = hour;
	}

	// -- Delta Time
	public int getdTime_f() {
		return dTime_f;
	}

	public void setdTime_f(int dTime_f) {
		this.dTime_f = dTime_f;
	}

	// -- Total distance
	public double getTotal() {
		return Total;
	}

	public double getTotal(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return Total;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2uMiles(Total);
		default:
			return Total;
		}
	}

	public String getTotalString(int unit, boolean withunit) {

		Double d = getTotal(unit) / 1000.0;

		String s = "";

		// -- Set the value
		switch (unit) {
		case CgConst.UNIT_METER:
			s = String.format("%1.3f ", d);
			if (withunit)
				s = s + "km";
			break;
		case CgConst.UNIT_MILES_FEET:
			s = String.format("%1.3f ", d);
			if (withunit)
				s = s + "miles";
			break;
		default:
			s = String.format("%1.3f ", d);
			if (withunit)
				s = s + "km";
			break;
		}
		return s;
	}

	public void setTotal(double total) {
		Total = total;
	}

	// -- Time limit
	public int getTimeLimit() {
		return TimeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		TimeLimit = timeLimit;
	}

	// -- Station time
	public int getStationTime() {
		return StationTime;
	}

	public void setStationTime(int stationTime) {
		StationTime = stationTime;
	}

	// -- Delta distance
	public double getdDist() {
		return dDist;
	}

	public double getdDist(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return dDist;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2uMiles(dDist);
		default:
			return dDist;
		}
	}

	public String getdDistString(int unit, boolean withunit) {

		Double d = getdDist(unit);

		String s = "";

		// -- Set the value
		switch (unit) {
		case CgConst.UNIT_METER:
			s = String.format("%1.0f ", d);
			if (withunit)
				s = s + "m";
			break;
		case CgConst.UNIT_MILES_FEET:
			s = String.format("%1.0f ", d);
			if (withunit)
				s = s + "miles";
			break;
		default:
			s = String.format("%1.0f ", d);
			if (withunit)
				s = s + "m";
			break;
		}
		return s;
	}

	public void setdDist(double dDist) {
		this.dDist = dDist;
	}

	// -- Delta Climb positive
	public double getdClimbP() {
		return dClimbP;
	}

	public double getdClimbP(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return dClimbP;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2Feet(dClimbP);
		default:
			return dClimbP;
		}
	}

	
	public String getdClimbPString(int unit, boolean withunit) {
		
		double e=getdClimbP(unit);
		
		String s="";
		switch (unit) {
			case CgConst.UNIT_METER:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"m";
				break;
			case CgConst.UNIT_MILES_FEET:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"feet";
				break;
			default:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"m";
				break;
		}
		return s;
	}
	
	public void setdClimbP(double dClimbP) {
		this.dClimbP = dClimbP;
	}

	// -- Delta climb negative
	public double getdClimbM() {
		return dClimbM;
	}

	public double getdClimbM(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return dClimbM;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2Feet(dClimbM);
		default:
			return dClimbM;
		}
	}

	
	public String getdClimbMString(int unit, boolean withunit) {
		
		double e=getdClimbM(unit);
		
		String s="";
		switch (unit) {
			case CgConst.UNIT_METER:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"m";
				break;
			case CgConst.UNIT_MILES_FEET:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"feet";
				break;
			default:
				s=String.format("%1.0f ",e);
				if (withunit)
					s=s+"m";
				break;
		}
		return s;
	}
	
	public void setdClimbM(double dClimbM) {
		this.dClimbM = dClimbM;
	}

	// -- Ascend speed
	public double getSpeedP() {
		return SpeedP;
	}

	public double getSpeedP(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return SpeedP;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2Feet(SpeedP);
		default:
			return SpeedP;
		}
	}

	public String getSpeedPString(int unit, boolean withunit) {

		Double e = getSpeedP(unit);
		
		if (e.isNaN())	return "0";

		String s = "";
		switch (unit) {
		case CgConst.UNIT_METER:
			s = String.format("%1.0f ", e);
			if (withunit)
				s = s + "m";
			break;
		case CgConst.UNIT_MILES_FEET:
			s = String.format("%1.0f ", e);
			if (withunit)
				s = s + "feet";
			break;
		default:
			s = String.format("%1.0f ", e);
			if (withunit)
				s = s + "m";
			break;
		}
		return s;
	}
	
	public void setSpeedP(double speedP) {
		SpeedP = speedP;
	}

	// -- Descend speed
	public double getSpeedM() {
		return SpeedM;
	}

	public double getSpeedM(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return SpeedM;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2Feet(SpeedM);
		default:
			return SpeedM;
		}
	}

	public String getSpeedMString(int unit, boolean withunit) {

		Double e = getSpeedM(unit);

		if (e.isNaN())	return "0";

		String s = "";
		switch (unit) {
		case CgConst.UNIT_METER:
			s = String.format("%1.0f ", e);
			if (withunit)
				s = s + "m";
			break;
		case CgConst.UNIT_MILES_FEET:
			s = String.format("%1.0f ", e);
			if (withunit)
				s = s + "feet";
			break;
		default:
			s = String.format("%1.0f ", e);
			if (withunit)
				s = s + "m";
			break;
		}
		return s;
	}
	
	public void setSpeedM(double speedM) {
		SpeedM = speedM;
	}

	// -- Average ascend slope
	public double getAvgSlopeP() {
		return AvgSlopeP;
	}

	public void setAvgSlopeP(double avgSlopeP) {
		AvgSlopeP = avgSlopeP;
	}

	// -- average descend slope
	public double getAvgSlopeM() {
		return AvgSlopeM;
	}

	public void setAvgSlopeM(double avgSlopeM) {
		AvgSlopeM = avgSlopeM;
	}

	// -- Comment
	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	// -- Average speed
	public double getAvgSpeed() {
		return AvgSpeed;
	}

	public double getAvgSpeed(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return AvgSpeed;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Km2Miles(AvgSpeed);
		default:
			return AvgSpeed;
		}
	}

	public String getAvgSpeedString(int unit, boolean withunit) {

		Double d = getAvgSpeed(unit);

		String s = "";

		// -- Set the value
		switch (unit) {
		case CgConst.UNIT_METER:
			s = String.format("%1.1f ", d);
			if (withunit)
				s = s + "km/h";
			break;
		case CgConst.UNIT_MILES_FEET:
			s = String.format("%1.2f ", d);
			if (withunit)
				s = s + "miles/h";
			break;
		default:
			s = String.format("%1.1f ", d);
			if (withunit)
				s = s + "km/h";
			break;
		}
		return s;
	}
	
	public void setAvgSpeed(double avgSpeed) {
		AvgSpeed = avgSpeed;
	}

}
