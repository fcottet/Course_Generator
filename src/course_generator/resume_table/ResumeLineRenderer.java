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

package course_generator.resume_table;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import course_generator.CgResume;

/**
*
* @author pierre.delore
*/
public class ResumeLineRenderer   extends DefaultTableCellRenderer {
   
   @Override
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);

       CgResume data = (CgResume) value;

       Double val = data.getLine();

       //-- Display the value
       setText(String.format("%1.0f ",val));
       setHorizontalAlignment(CENTER);
       return this;
   }
   
}