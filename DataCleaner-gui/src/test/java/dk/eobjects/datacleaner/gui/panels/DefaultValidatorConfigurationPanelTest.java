/**
 *  This file is part of DataCleaner.
 *
 *  DataCleaner is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  DataCleaner is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with DataCleaner.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.eobjects.datacleaner.gui.panels;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import dk.eobjects.datacleaner.data.ColumnSelection;
import dk.eobjects.datacleaner.data.DataContextSelection;
import dk.eobjects.datacleaner.validator.BasicValidationRuleDescriptor;
import dk.eobjects.datacleaner.validator.IValidationRuleDescriptor;
import dk.eobjects.datacleaner.validator.ValidatorJobConfiguration;
import dk.eobjects.datacleaner.validator.trivial.NotNullValidationRule;

import junit.framework.TestCase;

public class DefaultValidatorConfigurationPanelTest extends TestCase {

	public void testInitialize() throws Exception {
		DefaultValidatorConfigurationPanel configurationPanel = new DefaultValidatorConfigurationPanel();
		IValidationRuleDescriptor descriptor = new BasicValidationRuleDescriptor(
				"foobar", NotNullValidationRule.class);
		configurationPanel.initialize(new JTabbedPane(), descriptor,
				new ColumnSelection(new DataContextSelection()),
				new ValidatorJobConfiguration(descriptor));
		JPanel panel = configurationPanel.getPanel();
		assertNotNull(panel);
	}
}