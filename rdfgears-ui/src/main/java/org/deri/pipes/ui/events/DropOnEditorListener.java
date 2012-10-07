/*
 * Copyright (c) 2008-2009,
 * 
 * Digital Enterprise Research Institute, National University of Ireland, 
 * Galway, Ireland
 * http://www.deri.org/
 * http://pipes.deri.org/
 *
 * Semantic Web Pipes is distributed under New BSD License.
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 *  * Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright 
 *    notice, this list of conditions and the following disclaimer in the 
 *    documentation and/or other materials provided with the distribution and 
 *    reference to the source code.
 *  * The name of Digital Enterprise Research Institute, 
 *    National University of Ireland, Galway, Ireland; 
 *    may not be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.deri.pipes.ui.events;

import org.deri.pipes.ui.PipeEditor;
import org.integratedmodelling.zk.diagram.components.Workspace;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.MouseEvent;

/**
 * @author Danh Le Phuoc
 *
 */
public class DropOnEditorListener implements org.zkoss.zk.ui.event.EventListener {
	       private  Workspace wsp;
		   public DropOnEditorListener(Workspace wsp){
			   this.wsp=wsp;
		   }
	       public void onEvent(Event event) throws UiException {  
//	    	   System.out.println("DropOnEditorListener#onEvent() fired, but is ignored becuase it is disabled for RDFGears");
	    	     int x=((MouseEvent)event).getX(), y=((MouseEvent)event).getY();
	    	     Component dragged= ((DropEvent)event).getDragged();
//	    	     if (dragged instanceof SindiceSearchResult){
//	    	    	 System.out.println("in here " +((SindiceSearchResult)dragged).getFormat());
//	    	    	 if(((SindiceSearchResult)dragged).getFormat().equalsIgnoreCase("RDF") ){
//	    	    		 RDFFetchNode rdfFetch=new RDFFetchNode(x,y);
//	    	    		 rdfFetch.setURL(((SindiceSearchResult)dragged).getLink());
//	    	    		 wsp.addFigure(rdfFetch);
//	    	    	 }
//	    	    	 else if(((SindiceSearchResult)dragged).getFormat().equalsIgnoreCase("html")){
//	    	    		 HTMLFetchNode htmlFetch =new HTMLFetchNode(x,y);
//	    	    		 htmlFetch.setURL(((SindiceSearchResult)dragged).getLink());
//	    	    		 wsp.addFigure(htmlFetch);
//	    	    	 }
//	    	    	 else{
//	    	    		 HttpGetNode httpGet= new HttpGetNode(x,y);
//	    	    		 httpGet.setURL(((SindiceSearchResult)dragged).getLink());
//	    	    		 wsp.addFigure(httpGet);
//	    	    	 }
//	    	    	 return;	        
//	    	     }
		         ((PipeEditor)wsp).createFigure(x,y,dragged.getId());
		   }    
}