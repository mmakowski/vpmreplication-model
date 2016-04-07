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

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldEqual


class ResultScoreTest : Spek() {
    init {

        // Nice scenario
        given(" A result score of 1 for everything") {
            val fp = 1
            val fn = 1
            val tn = 1
            val tp = 1
            on("crating the corresponding resultscore") {
                val result= ResultScore(fp, fn,tn,tp)
                it ("should return a precision of 0,5"){
                    shouldEqual(0.5f,result.precision())
                }
                it ("should return a recall of 0,5"){
                    shouldEqual(0.5f,result.recall())
                }
                it ("should return an accuracy of 0,5"){
                    shouldEqual(0.5f,result.accuracy())
                }
                it ("should return an elusion of 0,5"){
                    shouldEqual(0.5f,result.elusion())
                }
                it ("should return a fallout of 0,5"){
                    shouldEqual(0.5f,result.fallout())
                }
                it ("should return a prevalence of 0,5"){
                    shouldEqual(0.5f,result.prevalence())
                }
                it ("should return a true negative rate of 0,5"){
                    shouldEqual(0.5f,result.trueNegativeRate())
                }
                it ("should return a fmeasure of 0,5"){
                    shouldEqual(0.5f,result.fmeasure())
                }
            }
        }

        //Less good scenario
        given(" A result score 2,1,0,1") {
            val fp = 2
            val fn = 1
            val tn = 0
            val tp = 1
            on("crating the corresponding resultscore") {
                val result= ResultScore(fp, fn,tn,tp)
                it ("should return a precision of 1/3"){
                    shouldEqual(1f/3f,result.precision())
                }
                it ("should return a recall of 0,5"){
                    shouldEqual(0.5f,result.recall())
                }
                it ("should return an accuracy of 0,25"){
                    shouldEqual(0.25f,result.accuracy())
                }
                it ("should return an elusion of 1"){
                    shouldEqual(1f,result.elusion())
                }
                it ("should return a fallout of 1"){
                    shouldEqual(1f,result.fallout())
                }
                it ("should return a prevalence of 0,5"){
                    shouldEqual(0.5f,result.prevalence())
                }
                it ("should return a true negative rate of 0"){
                    shouldEqual(0f,result.trueNegativeRate())
                }
                it ("should return a fmeasure of 0,4"){
                    shouldEqual(0.4f,result.fmeasure())
                }
            }
        }

    }
}