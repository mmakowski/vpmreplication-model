/////////////////////////////////////////////////////////////////////////////////////////
//                 University of Luxembourg  -
//                 Interdisciplinary center for Security and Trust (SnT)
//                 Copyright © 2016 University of Luxembourg, SnT
//
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Lesser General Public
//  License as published by the Free Software Foundation; either
//  version 3 of the License, or (at your option) any later version.
//
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public
//  License along with this library; if not, write to the Free Software
//  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
//
//
//    Author: Matthieu Jimenez – SnT – matthieu.jimenez@uni.lu
//
//////////////////////////////////////////////////////////////////////////////////////////
package lu.jimenez.research.bugsandvulnerabilities.model.extension.experiment

import java.io.Serializable


/**
 * Data class representing the result of an experiment with usual metrics
 *
 * @param fp False positives
 * @param fn False negatives
 * @param tn True negatives
 * @param tp True positives
 */
data class ResultScore(val fp :Int,
                       val fn : Int,
                       val tn :Int,
                       val tp : Int
):Serializable {

    /**
     * Method returnin the total number of element in the testing set
     */
    fun totalNumber() : Int {
        return fp+fn+tp+tn
    }

    /**
     * Method computing the recall of an experiment
     * i.e., the number of true positive over the total of the positives
     */
    fun recall():Float{
        return (tp.toFloat()/(tp+fn).toFloat())
    }

    /**
     * Method computing the precision of an experiment
     * i.e., the number of true positive over the number of result declared as positive
     */
    fun precision():Float{
        return (tp.toFloat()/(tp+fp).toFloat())
    }

    /**
     * Method computing the fmeasure of an experiment
     * i.e., a measure of the harmonic mean of Recall and Precision
     */
    fun fmeasure():Float{
        return (2*precision()*recall())/(precision()+recall())
    }

    /**
     * Method computing the elusion of an experiment
     * i.e., the number of positive that were not found over the total of declared as negative
     */
    fun elusion():Float{
        return (fn.toFloat()/(fn+tn).toFloat())
    }

    /**
     * Method computing the fallout of an experiment
     * i.e., number of declared wrongly as positive over the total of negative
     */
    fun fallout():Float{
        return (fp.toFloat()/(tn+fp).toFloat())
    }

    /**
     * Method computing the accuracy of an experiment
     * i.e., number of correctly classify overall
     */
    fun accuracy():Float{
        return ((tp+tn).toFloat()/(tp+tn+fp+fn).toFloat())
    }

    /**
     * Method computing the prevalence of an experiment
     * i.e., the number of elements to find as positive overall
     * this can be computed before laaunching the experiment in fact
     */
    fun prevalence():Float{
        return ((tp+fn).toFloat()/(tp+tn+fp+fn).toFloat())
    }

    /**
     * Method computing the true Negative rate of an experiment
     * i.e., the number of correctly classify as false over the number of false
     */
    fun trueNegativeRate():Float{
        return (tn.toFloat()/(tn+fp).toFloat())
    }

    fun mcc():Float{
        return (tp*tn-fp*fn).toFloat()/Math.sqrt(((tp+fp)*(tp+fn)*(tn+fp)*(tn+fn)).toDouble()).toFloat()
    }


}