/*
 * ProGuard Core -- library to process Java bytecode.
 *
 * Copyright (c) 2002-2019 Guardsquare NV
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package proguard.util;

import java.util.Map;

/**
 * This StringFunction gets its transformed strings from a given map.
 *
 * @author Eric Lafortune
 */
public class MapStringFunction implements StringFunction
{
    private final Map    map;
    private final String defaultString;


    /**
     * Creates a new MapStringFunction based on the given map.
     */
    public MapStringFunction(Map map)
    {
        this(map, null);
    }


    /**
     * Creates a new MapStringFunction based on the given map,
     * with a default string for strings that are not in the map.
     */
    public MapStringFunction(Map map, String defaultString)
    {
        this.map           = map;
        this.defaultString = defaultString;
    }


    // Implementations for StringFunction.

    public String transform(String string)
    {
        String mappedString = (String)map.get(string);

        return mappedString != null ? mappedString : defaultString;
    }
}
