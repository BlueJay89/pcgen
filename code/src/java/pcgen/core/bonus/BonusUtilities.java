/*
 * Copyright 2001 (C) Bryan McRoberts <merton_monk@yahoo.com>
 * Copyright 2005 (C) Tom Parker <thpr@sourceforge.net>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 * Refactored out of PObject July 22, 2005
 *
 * Current Ver: $Revision: 1.10 $
 * Last Editor: $Author: binkley $
 * Last Edited: $Date: 2005/11/13 20:01:22 $
 */
package pcgen.core.bonus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Tom Parker <thpr@sourceforge.net>
 *
 * This is a utility class related to BonusObj objects.
 */
public final class BonusUtilities
{

	private BonusUtilities()
	{
		//Don't allow instantiation of utility class
	}

	/**
	 * Get the bonus from a list
	 * @param bonusList
	 * @param aType
	 * @param aName
	 * @return List
	 */
	public static List getBonusFromList(final List bonusList, final String aType, final String aName)
	{
		final List aList = new ArrayList();

		if (bonusList != null)
		{
			for (Iterator ab = bonusList.iterator(); ab.hasNext();)
			{
				final BonusObj aBonus = (BonusObj) ab.next();

				if (!aBonus.getTypeOfBonus().startsWith(aType))
				{
					continue;
				}

				if (aBonus.getBonusInfoList().size() > 1)
				{
					final StringTokenizer aTok = new StringTokenizer(aBonus.getBonusInfo(), ",");

					while (aTok.hasMoreTokens())
					{
						final String aBI = aTok.nextToken();

						if (aBI.equals(aName))
						{
							aList.add(aBonus);
						}
					}
				}
				else if (aBonus.getBonusInfo().equals(aName))
				{
					aList.add(aBonus);
				}
			}
		}

		return aList;
	}

	/**
	 * Get Bonus from list
	 * @param bonusList
	 * @param iType
	 * @return List
	 */
	public static List getBonusFromList(final List bonusList, final int iType)
	{
		final List aList = new ArrayList(bonusList.size());

		// Analysis reveals that bonusList is never null
		for (Iterator ab = bonusList.iterator(); ab.hasNext();)
		{
			final BonusObj aBonus = (BonusObj) ab.next();

			if (aBonus.getTypeOfBonusAsInt() != iType)
			{
				continue;
			}
			aList.add(aBonus);
		}

		return aList;
	}
}
