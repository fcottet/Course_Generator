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
import course_generator.utils.CgConst;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pierre.delore
 */
public class TagRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);

        CgData data = (CgData) value;

        int tag = data.getTag();

        //-- Count the number of active tag
        int cmpt=0;
        int i=1;
        while (i<65536) {
            if ((tag & i)!=0) cmpt++;
            i=i*2;
        }

        int x=0; //X position in the resulting image
        
        if (cmpt>0) {
            //-- Prepare the resulting image
            BufferedImage combined = new BufferedImage(18*cmpt,16, BufferedImage.TYPE_INT_ARGB);
            Graphics g = combined.getGraphics();
            
            //Higher point
            if ((tag & CgConst.TAG_HIGH_PT) != 0) {
                ImageIcon image=new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/high_point.png"));
                g.drawImage(image.getImage(), x, 0, null);
                x+=18;
            }
            
            //Lower point
            if ((tag & CgConst.TAG_LOW_PT) != 0) {
                ImageIcon image=new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/low_point.png"));
                g.drawImage(image.getImage(), x, 0, null);
                x+=18;
            }

            //Station
            if ((tag & CgConst.TAG_EAT_PT) != 0) {
                ImageIcon image=new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/eat.png"));
                g.drawImage(image.getImage(), x, 0, null);
                x+=18;
            }

            //Drink
            if ((tag & CgConst.TAG_WATER_PT) != 0) {
                ImageIcon image=new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/drink.png"));
                g.drawImage(image.getImage(), x, 0, null);
                x+=18;
            }
            
            //Mark
            if ((tag & CgConst.TAG_MARK) != 0) {
                ImageIcon image=new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/flag.png"));
                g.drawImage(image.getImage(), x, 0, null);
                x+=18;
            }
            
            //Roadbook
            if ((tag & CgConst.TAG_ROADBOOK) != 0) {
                ImageIcon image=new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/roadbook.png"));
                g.drawImage(image.getImage(), x, 0, null);
                x+=18;
            }
            
            //Photo
            if ((tag & CgConst.TAG_COOL_PT) != 0) {
                ImageIcon image=new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/photo.png"));
                g.drawImage(image.getImage(), x, 0, null);
                x+=18;
            }
            
            //Note
            if ((tag & CgConst.TAG_NOTE) != 0){
                ImageIcon image=new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/note.png"));
                g.drawImage(image.getImage(), x, 0, null);
                x+=18;
            }

            //Info
            if ((tag & CgConst.TAG_INFO) != 0) {
                ImageIcon image=new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/info.png"));
                g.drawImage(image.getImage(), x, 0, null);
                x+=18;
            }
            
            setIcon(new ImageIcon(combined));
        }
        else setIcon(null); //No image
        
        //-- Set the value
        setText("");
        
        return this;
    }
    
}
