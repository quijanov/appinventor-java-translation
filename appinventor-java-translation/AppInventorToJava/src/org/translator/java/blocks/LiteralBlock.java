/*
   appinventor-java-translation

   Originally authored by Joshua Swank at the University of Alabama
   Work supported in part by NSF award #0702764 and a Google 2011 CS4HS award

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.translator.java.blocks;

import org.translator.java.code.Value;
import java.util.ArrayList;
import java.util.Collection;
import org.translator.java.TranslatorConstants;
import org.translator.java.code.CodeSegment;
import org.translator.java.code.api.APIType;
import org.w3c.dom.Node;

/**
 *
 * @author Joshua
 */
public final class LiteralBlock extends Block
{
    private APIType type;
    
    public LiteralBlock( Node block )
    {
        super( block );

        this.type = TranslatorConstants.API.getMatchingLiteral( genusName );
    }

    public static String getGenusPattern()
    {
        return TranslatorConstants.API.getLiteralGenusPattern();
    }

    public Collection<Value> getConstructorParameters()
    {
        ArrayList<Value> parameters = new ArrayList<Value>();

        parameters.add( (Value)generateCode() );

        return parameters;
    }

    public CodeSegment generateCode()
    {
        return type.getValue( label );
    }

    public String getDataType()
    {
        return type.getName();
    }
}
