/**
 * DataCleaner (community edition)
 * Copyright (C) 2013 Human Inference
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.eobjects.datacleaner.monitor.configuration;

import org.eobjects.analyzer.connection.Datastore;
import org.eobjects.analyzer.connection.DatastoreConnection;
import org.eobjects.analyzer.util.SchemaNavigator;
import org.apache.metamodel.DataContext;

/**
 * {@link DatastoreConnection} placeholder for lightweight reading of analysis
 * jobs without having to read live metadata from an actual datastore.
 */
final class PlaceholderDatastoreConnection implements DatastoreConnection {

    private final PlaceholderDatastore _datastore;

    public PlaceholderDatastoreConnection(PlaceholderDatastore datastore) {
        _datastore = datastore;
    }

    @Override
    public void close() {
        // do nothing
    }

    @Override
    public DataContext getDataContext() {
        return new PlaceholderDataContext(_datastore.getSourceColumnPaths(), _datastore.getSourceColumnTypes());
    }

    @Override
    public Datastore getDatastore() {
        return _datastore;
    }

    @Override
    public SchemaNavigator getSchemaNavigator() {
        return new SchemaNavigator(getDataContext());
    }

}
