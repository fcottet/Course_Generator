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
public class CgData {
	/**Line number**/
	private double Num;
	/**Latitude of the position**/
	private double Latitude;
	/**Longitude of the position**/
	private double Longitude;
	/**Elevation of the position in meter**/
	private double Elevation;
	/**Memorized elevation of the position in meter**/
	private double ElevationMemo; // Elevation in meter
	/**Tag of the position**/
	private int Tag;
	/**Distance between 2 points in meters**/
	private double Dist;
	/**Total distance in meters from the start to this position**/
	private double Total;
	/**Track difficulty coefficient at this position**/
	private double Diff;
	/**Health coefficient at this position**/
	private double Coeff;
	/**Health recovery percentage at this position**/
	private double Recovery;
	/**Slope of the track from the last position to this position (in %)**/
	private double Slope;
	/**Speed from the last position to this position (in km/h)**/
	private double Speed;
	/**Elevation from the last position to this position (in m)**/
	private double dElevation;
	/**Time from the start to this position (in s)**/
	private int Time;
	/**Time from the previous position to this position (in s). In float format in order to maximize the precision**/
	private double dTime_f;
	/**Time limit at this position. in second from the start. 0=none**/
	private int TimeLimit;
	/**Hour at this position**/
	private DateTime Hour;
	/**Time stayed at this position. Rest, eat, drink... (in s)**/
	private int Station;
	/**Name of the position**/
	private String Name;
	/**Comment of the position**/
	private String Comment;
	/**Used for calculation*/
	public double tmp1;
	/**Used for calculation*/
	public double tmp2;
	/**Label format in the mini roadbook for this position**/
	public String FmtLbMiniRoadbook;
	/**Option of the mini roadbook for this position**/
	public int OptionMiniRoadbook;
	/**Vertical position of the label in the mini roadbook for this position**/
	public int VPosMiniRoadbook;
	/**Comment of this position in the mini roadbook**/
	public String CommentMiniRoadbook;
	/**Font size of this position in the mini roadbook**/
	public int FontSizeMiniRoadbook;

	public double getNum() {
		return Num;
	}

	public void setNum(double num) {
		Num = num;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

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
		
		double e=getElevation(unit);
		
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
	
	
	public void setElevation(double elevation) {
		Elevation = elevation;
	}

	public int getTag() {
		return Tag;
	}

	public void setTag(int tag) {
		Tag = tag;
	}

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

		String s="";
		
		//-- Set the value
		switch (unit) {
			case CgConst.UNIT_METER: 
				s=String.format("%1.0f ",d);
				if (withunit)
					s=s+"m";
				break;
			case CgConst.UNIT_MILES_FEET: 
				s=String.format("%1.0f ",d);
				if (withunit)
					s=s+"miles";
				break;
			default:
				s=String.format("%1.0f ",d);
				if (withunit)
					s=s+"m";
				break;        	
		}
		return s;
	}


	public void setDist(double dist) {
		Dist = dist;
	}

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

		Double d = getTotal(unit)/1000.0;

		String s="";
		
		//-- Set the value
		switch (unit) {
			case CgConst.UNIT_METER: 
				s=String.format("%1.3f ",d);
				if (withunit)
					s=s+"km";
				break;
			case CgConst.UNIT_MILES_FEET: 
				s=String.format("%1.3f ",d);
				if (withunit)
					s=s+"miles";
				break;
			default:
				s=String.format("%1.3f ",d);
				if (withunit)
					s=s+"km";
				break;        	
		}
		return s;
	}

	
	
	public void setTotal(double total) {
		Total = total;
	}

	public double getDiff() {
		return Diff;
	}

	public void setDiff(double diff) {
		Diff = diff;
	}

	public double getCoeff() {
		return Coeff;
	}

	public void setCoeff(double coeff) {
		Coeff = coeff;
	}

	public double getRecovery() {
		return Recovery;
	}

	public void setRecovery(double recup) {
		Recovery = recup;
	}

	public double getSlope() {
		return Slope;
	}

	public String getSlopeString(boolean withunit) {
		if (withunit)
			return String.format("%1.1f ",getSlope())+"%";
		else
			return String.format("%1.1f ",getSlope());
	}

	public void setSlope(double slope) {
		Slope = slope;
	}

	public double getSpeed() {
		return Speed;
	}

	public double getSpeed(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return Speed;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2uMiles(Speed);
		default:
			return Speed;
		}
	}
	
	public String getSpeedString(int unit, boolean withunit) {
		double v=getSpeed(unit);
		
		String s="";
		switch (unit) {
			case CgConst.UNIT_METER:
				s=String.format("%1.1f ",v);
				if (withunit)
					s=s+"km/h";
				break;        	
		case CgConst.UNIT_MILES_FEET:
			s=String.format("%1.1f ",v);
			if (withunit)
				s=s+"miles/h";
			break;        	
		default:
			s=String.format("%1.1f ",v);
			if (withunit)
				s=s+"km/h";
			break;        	
		}
		return s;
	}
	

	public void setSpeed(double speed) {
		Speed = speed;
	}

	public double getdElevation() {
		return dElevation;
	}

	public double getdElevation(int unit) {
		switch (unit) {
		case CgConst.UNIT_METER:
			return dElevation;
		case CgConst.UNIT_MILES_FEET:
			// meter to miles
			return Utils.Meter2Feet(dElevation);
		default:
			return dElevation;
		}
	}

	public void setdElevation(double dElevation) {
		this.dElevation = dElevation;
	}

	public int getTime() {
		return Time;
	}

	public String getTimeString() {
	 int time = getTime();

     //-- Set the value
     int nbh = time / 3600;
     int nbm = (time % 3600) / 60;
     int nbs = (time % 3600) % 60;
     return String.format("%02d:%02d:%02d ",nbh,nbm,nbs);
	}
	
	public void setTime(int time) {
		Time = time;
	}

	public double getdTime_f() {
		return dTime_f;
	}

	public void setdTime_f(double dTime_f) {
		this.dTime_f = dTime_f;
	}

	public int getTimeLimit() {
		return TimeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		TimeLimit = timeLimit;
	}

	public DateTime getHour() {
		return Hour;
	}
	
	public String getHourString() {
		return getHour().toString("E HH:mm:ss");
	}

	public void setHour(DateTime hour) {
		Hour = hour;
	}

	public int getStation() {
		return Station;
	}

	public void setStation(int station) {
		Station = station;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public CgData(double Num, double Latitude, double Longitude, double Elevation, double ElevationMemo, int Tag,
			double Dist, double Total, double Diff, double Coeff, double Recup, double Slope, double Speed,
			double dElevation, int Time, // Temps total en seconde
			double dTime_f, // temps de parcours du tronçon en seconde (avec
							// virgule)
			int TimeLimit, // Barrière horaire
			DateTime Hour, // Contient la date et l'heure de passage
			int Station, String Name, String Comment, double tmp1, double tmp2, String FmtLbMiniRoadbook,
			int OptionMiniRoadbook, int VPosMiniRoadbook, String CommentMiniRoadbook, int FontSizeMiniRoadbook) {
		this.Num = Num;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		this.Elevation = Elevation;
		this.ElevationMemo = ElevationMemo;
		this.Tag = Tag;
		this.Dist = Dist;
		this.Total = Total;
		this.Diff = Diff;
		this.Coeff = Coeff;
		this.Recovery = Recup;
		this.Slope = Slope;
		this.Speed = Speed;
		this.dElevation = dElevation;
		this.Time = Time; // Temps total en seconde
		this.dTime_f = dTime_f; // temps de parcours du tronçon en seconde (avec
								// virgule)
		this.TimeLimit = TimeLimit; // Barrière horaire
		this.Hour = Hour; // Contient la date et l'heure de passage
		this.Station = Station;
		this.Name = Name;
		this.Comment = Comment;
		this.tmp1 = tmp1;
		this.tmp2 = tmp2;
		this.FmtLbMiniRoadbook = FmtLbMiniRoadbook;
		this.OptionMiniRoadbook = OptionMiniRoadbook;
		this.VPosMiniRoadbook = VPosMiniRoadbook;
		this.CommentMiniRoadbook = CommentMiniRoadbook;
		this.FontSizeMiniRoadbook = FontSizeMiniRoadbook;
	}

	public double getElevationMemo() {
		return ElevationMemo;
	}

	public void setElevationMemo(double elevationMemo) {
		ElevationMemo = elevationMemo;
	}
}
