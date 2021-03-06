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

package course_generator.trackdata_table;

import course_generator.CgData;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pierre.delore
 */
public class TimelimitRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);

        CgData data = (CgData) value;

        int timelimit = data.getTimeLimit();
        int time = data.getTime();

        //-- Set the value
        if (timelimit!=0) {
            int nbh = timelimit / 3600;
            int nbm = (timelimit % 3600) / 60;
            int nbs = (timelimit % 3600) % 60;
            setText(String.format("%02d:%02d:%02d ",nbh,nbm,nbs));
        }
        else setText("");
        setHorizontalAlignment(RIGHT);
        
        //-- Set the background
        if (isSelected)
            setBackground(new Color(51,153,255));
        else {
            if ((timelimit != 0) && (time > timelimit))
               setBackground(Color.PINK);
             else 
               setBackground(Color.WHITE);
        }
        
        return this;
    }
    
}
