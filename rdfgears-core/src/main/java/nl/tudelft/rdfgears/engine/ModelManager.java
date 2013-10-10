package nl.tudelft.rdfgears.engine;

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

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.hp.hpl.jena.n3.N3JenaWriter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFWriter;

/**
 * A manager providing graphs that can be manipulated in the background.
 * 
 * So be very aware that this is for side-effects!  
 * 
 * TODO: make these models persistent on the disk, if possible. That'd be much nicer! 
 * 
 * @author Eric Feliksik
 *
 */
public class ModelManager {
	private Map<String, Model> modelMap = new HashMap<String, Model>(); 

	protected ModelManager(){
		
	}
	
	/**
	 * Returns a buffered writer to the file with given name. 
	 * If the file cannot be opened, a RuntimeException will be thrown.
	 * The writer should *NOT* be closed the the user of this function. 
	 * At the end of the workflow execution Engine.close() will be called
	 * to close it.   
	 * 
	 * @param filename
	 * @return
	 */
	public Model getModel(String modelName){
		Model model = modelMap.get(modelName);
		
		if (model==null){
			model = ModelFactory.createDefaultModel();
			modelMap.put(modelName, model);
		}
		
		return model;
	}
	
	/**
	 * Write models to disk. 
	 * 
	 */
	public void close(){
		/**
		 * use model name as filename 
		 */
		for (String modelName : modelMap.keySet()){
			Model model = modelMap.get(modelName);
			
			String fileName = modelName + ".n3";
			
			RDFWriter rdfWriter = new N3JenaWriter();

			/*  Actually we shouldn't use the fileManager for this, as people
			 * may not be aware that creating a model will create a similarly-named
			 * file (so it's better to create a file here locally).
			 * 
			 * But for now, it will work.
			 */
			Writer writer = Engine.getFileManager().getFileWriter(fileName);
			rdfWriter.write(model, writer, null);
			
			model.close();
		}
	}
}
