/*********************************************************
 *  Copyright (c) 2011 by Web Information Systems (WIS) Group, 
 *  Delft University of Technology.
 *  Qi Gao, http://wis.ewi.tudelft.nl/index.php/home-qi-gao
 *  
 *  Some rights reserved.
 *
 *  Contact: q.gao@tudelft.nl
 *
 **********************************************************/
package org.persweb.sentiment;

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

import org.persweb.pipe.Pipe;

/**
 * @author Qi Gao <a href="mailto:q.gao@tudelft.nl">q.gao@tudelft.nl</a>
 * @version created on May 10, 2012 3:00:26 PM
 */
public interface SentimentAnalysisStrategy {
		
	/**
	 * Returns the sentiment of given content  
	 * 
	 * @param content content for which the sentiment is extracted
	 * @param pipe the pipe used to process the content.
	 * @return
	 * @throws Exception
	 */
	public double getSentiment(String content, Pipe pipe) throws Exception;
	
	/**
	 * Returns the name of strategy
	 * 
	 * @return the name of strategy
	 */
	public String getName();

}