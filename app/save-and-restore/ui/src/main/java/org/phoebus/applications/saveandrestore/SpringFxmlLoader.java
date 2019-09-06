/**
 * Copyright (C) 2019 European Spallation Source ERIC.
 * <p>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.phoebus.applications.saveandrestore;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Helper class used to load FXML such that the associated controller is provided
 * by the Spring application context. This is needed in order to inject dependencies into
 * the controller classes.
 */
public class SpringFxmlLoader {

    private FXMLLoader loader;

    public Object load(String url) {
        try {
            loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(url));
            loader.setControllerFactory(clazz -> ApplicationContextProvider.getApplicationContext().getBean(clazz));
            return loader.load();
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public FXMLLoader getLoader(){
        return loader;
    }
}
