/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modele_table.pack.BeauteTableau;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DELL
 */
public class BeauteTotal extends DefaultTableCellRenderer {
    
        @Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus,	row, column);

		int qte = (int) value;
		//setText(note.toString());

		if (true) {
			setForeground(Color.BLUE);
		} else {
			setForeground(Color.BLACK);
		}

		return this;
	}
    
}
