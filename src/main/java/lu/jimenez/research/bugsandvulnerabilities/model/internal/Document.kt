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
package lu.jimenez.research.bugsandvulnerabilities.model.internal

import java.io.Serializable

/**
 * Document Data class
 * (Named this way to avoid confusion with the java File class taht is regularly use to build the dataset
 *
 * This class is representing a file and its history
 *
 * @property fullPath relative path to the file
 * @property time timestamp of the time at which the file was retrieved
 * @property commitHash hash of the commit from which the file is coming
 * @property content content of the file
 *
 * @author Matthieu Jimenez
 */
data class Document(val fullPath: String, val time: Int, val commitHash: String, val content: String) : Serializable



