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
package lu.jimenez.research.bugsandvulnerabilities.model.extension.preprocessing.williams

import java.io.Serializable

/**
 *Complexity Metrics Data class
 *
 * This class gather all complexity Metrics produced by [File Metrics][https://github.com/electricalwind/FilesMetrics]
 *
 * @property loc Lines of codes
 * @property blankLines Blank Lines in the file
 * @property commentingLines Number of comment lines
 * @property commentDensity Ratio comment/loc
 * @property countDeclFunction Number of Function
 * @property countDeclVariable NUmber of Variable Declared
 * @property cc Map of function to cyclomatic complexity
 * @property scc Map of function to strict cyclomatic complexity
 * @property mcc Map of function to modified cyclomatic complexity
 * @property ec Map of function to essential complexity
 * @property maxNesting Map of function to Max Nesting
 * @property fanIn Map of function to fANIN
 * @property fanOut Map of function to FANOUT
 */
data class ComplexityMetrics(val simpleMetrics: SimpleMetrics,
                             val cyclomaticMetrics: CyclomaticMetrics,
                             val nestFanMetrics: NestFanMetrics
) : Serializable

data class SimpleMetrics(val loc: Int,
                         val blankLines: Int,
                         val preprocessorLines: Int,
                         val commentingLines: Int,
                         val commentDensity: Float,
                         val countDeclFunction: Int,
                         val countDeclVariable: Int) : Serializable

data class CyclomaticMetrics(val ccMax: Int,
                             val ccAverage: Double,
                             val ccSum: Int,
                             val sccMax: Int,
                             val sccAverage: Double,
                             val sccSum: Int,
                             val mccMax: Int,
                             val mccAverage: Double,
                             val mccSum: Int,
                             val ecMax: Int,
                             val ecAverage: Double,
                             val ecSum: Int) : Serializable
data class NestFanMetrics(val maxNestingMax: Int,
                          val maxNestingAverage: Double,
                          val maxNestingSum: Int,
                          val fanInMax: Int,
                          val fanInAverage: Double,
                          val fanInSum: Int,
                          val fanOutMax: Int,
                          val fanOutAverage: Double,
                          val fanOutSum: Int):Serializable