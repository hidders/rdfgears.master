package nl.tudelft.rdfgears.rgl.datamodel.value.impl;

/*
 * #%L
 * RDFGears
 * %%
 * Copyright (C) 2013 WIS group at the TU Delft (http://www.wis.ewi.tudelft.nl/)
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import java.util.Set;

import nl.tudelft.rdfgears.rgl.datamodel.value.RGLValue;
import nl.tudelft.rdfgears.rgl.datamodel.value.RecordValue;
import nl.tudelft.rdfgears.util.row.FieldIndexMap;
import nl.tudelft.rdfgears.util.row.FieldMappedValueRow;
import nl.tudelft.rdfgears.util.row.ValueRow;
import nl.tudelft.rdfgears.util.row.ValueRowWithPut;


/**
 * Field values are modifiable! 
 * @author Eric Feliksik
 *
 */
public class ModifiableRecord extends RecordValue implements ValueRowWithPut {
	private ValueRowWithPut row;

	/**
 	 * Create a Record with given fields. It must still be filled with the put(key,value) operation
	 * @param map
	 */
	public ModifiableRecord(FieldIndexMap map) {
		row = new FieldMappedValueRow(map);
	}

	protected ValueRow getRow(){
		return this.row;
	}
	
	@Override
	public RGLValue get(String s){
		RGLValue v = row.get(s);
		assert(v!=null) : "You fetched field '"+s+"' from a record value where the field is not set. If you're working with SPARQL OPTIONALS: sorry, this isn't supported";
		return v;
	}
	
	public Set<String> getRange(){
		return row.getRange();
	}

	public void put(String fieldName, RGLValue element) {
		row.put(fieldName, element);
	}

}
