/*
 *  Initiative - A role playing utility to track turns
 *  Copyright (C) 2002 Devon D Jones
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 *  The author of this program grants you the ability to use this code
 *  in conjunction with code that is covered under the Open Gaming License
 *
 *  PreferencesTrackingPanel.java
 *
 *  Created on August 29, 2002, 2:41 PM
 */
package plugin.initiative.gui;

import pcgen.core.SettingsHandler;
import plugin.initiative.InitiativePlugin;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Font;

/**
 * Panel that tracks the misc preferences
 *
 * @author devon
 * @since April 7, 2003
 */
public class PreferencesInitiativePanel extends gmgen.gui.PreferencesPanel
{

	private JPanel performancePanel;
	private JPanel mainPanel;
	private JCheckBox rollPCInitiatives;

	/** Creates new form PreferencesMiscPanel */
	public PreferencesInitiativePanel()
	{
		initComponents();
		initPreferences();
	}

	public void applyPreferences()
	{
		SettingsHandler.setGMGenOption(InitiativePlugin.LOG_NAME
			+ ".rollPCInitiatives", getRollPCInitiatives());
	}

	public void initPreferences()
	{
		setRollPCInitiatives(SettingsHandler.getGMGenOption(
			InitiativePlugin.LOG_NAME + ".rollPCInitiatives", true));
	}

	/**
	 * <p>
	 * Turns on or off refresh on state cange
	 * </p>
	 *
	 * @param b
	 */
	private void setRollPCInitiatives(boolean b)
	{
		rollPCInitiatives.setSelected(b);
	}

	/**
	 * <p>
	 * Gets current setting of refresh on state change
	 * </p>
	 *
	 * @return true or false
	 */
	private boolean getRollPCInitiatives()
	{
		return rollPCInitiatives.isSelected();
	}

	@Override
	public String toString()
	{
		return "Initiative";
	}

	private void initComponents()
	{
		setLayout(new BorderLayout());

		mainPanel = new JPanel();
		rollPCInitiatives = new JCheckBox();

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		performancePanel = new JPanel();
		performancePanel.setLayout(new BoxLayout(performancePanel,
			BoxLayout.Y_AXIS));
		performancePanel.setBorder(new TitledBorder(null, "Initiative",
			TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
			new Font("Dialog", 1, 11)));

		rollPCInitiatives
			.setText("Automatically roll PC initiatives at combat start");
		performancePanel.add(rollPCInitiatives);

		mainPanel.add(performancePanel);

		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setViewportView(mainPanel);
		add(jScrollPane1, BorderLayout.CENTER);
	}
}